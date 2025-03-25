package com.compassion.commons.iac;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.jooq.lambda.Seq;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.experimental.Delegate;
import software.amazon.awscdk.Stack;
import software.amazon.awscdk.services.ec2.ISubnet;
import software.amazon.awscdk.services.ec2.IVpc;
import software.amazon.awscdk.services.ec2.Vpc;
import software.amazon.awscdk.services.ec2.VpcLookupOptions;
import software.amazon.awscdk.services.lambda.Code;
import software.amazon.awscdk.services.lambda.Function;
import software.amazon.awscdk.services.lambda.Runtime;
import software.amazon.awscdk.services.secretsmanager.ISecret;
import software.amazon.awscdk.services.ssm.CfnParameter;
import software.amazon.jsii.Builder;
import software.constructs.IConstruct;

@FunctionalInterface
public interface CDKUtils extends CDKVariables {
	static ObjectMapper JSON = new ObjectMapper()
		.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);

	Stack stack();
	
	default <C extends IConstruct> Tagger<C> tag(C c) {
		return Tagger.with(c);
	}
	
	default IVpc findVPC() {
		return Vpc.fromLookup(stack(), "vpc", VpcLookupOptions.builder()
			.vpcName(VPC_NAME).ownerAccountId(stack().getAccount()).build());
	}
	
	default List<String> findSubnetsForVPC(IVpc vpc) {
		return Seq.seq(vpc.getPrivateSubnets()).map(ISubnet::getSubnetId).toList();
	}

	default ParamFromSecretBuilder newParam(String path) {
		path = StringUtils.prependIfMissing(path, "/");
		return new ParamFromSecretBuilder(CfnParameter.Builder.create(stack(), path)
			.type("String").tier("Standard").name(path), path);
	}
	
	/**
	 * <p>Begin building a Lambda function definition from a Maven POM.</p>
	 * <p>You can use this with the Maven dependency plugin to unpack the implementation .jar into this stack's build directory.
	 * For example, declare your function's implementation as a dependency:</p>
	 * <p><pre>{@code
	 * <dependency>
	 *    <groupId>com.mygroup</groupId>
  	 *    <artifactId>my-artifact</artifactId>
  	 *    <version>1.2.3</version>
  	 *    <classifier>shaded</classifier>
  	 * </dependency>
	 * }</pre></p>
	 * <p>Then, use the dependency plugin to unpack the .jar and the .pom file to a location that can be accessed by this
	 * project's build:</p>
	 * <p><pre>{@code
	 * <plugin>
	 *    <artifactId>maven-dependency-plugin</artifactId>
	 *    <version>3.6.1</version>
	 *       <executions>
	 *          <execution>
	 *             <goals><goal>copy-dependencies</goal></goals>
	 *             <phase>compile</phase>
	 *             <configuration>
	 *                <includeClassifiers>shaded</includeClassifiers>
	 *                <copyPom>true</copyPom>
	 *                <stripVersion>true</stripVersion>
	 *             </configuration>
	 *          </execution>
	 *      </executions>
	 * </plugin>
	 * }</pre></p>
	 * <p>In this way, the POM will be available at {@code target/dependency/my-artifact.pom} and parseable for
	 * metadata about the Lambda function.</p>
	 * 
	 * @param artifactId the artifact ID of the Maven project containing the function's implementing code.
	 * This is optional and can be {@code null} if the path to a POM file is specified.
	 * @param pomPaths the path (or candidate paths) to the POM file. If none are specified, the POM file
	 * is discovered in this stack's unpacked dependency folder based on the specified {@code artifactId}.
	 * @return the function with the name, description, and code asset specified
	 * @throws IllegalArgumentException if the POM file could not be found 
	 * @throws IOException if there was a problem reading the POM file
	 */
	default Function.Builder lambdaFromPOM(String artifactId, Path... pomPaths) throws IOException {
		var pathsToTry = Seq.of(pomPaths);
		if (artifactId != null) {
			// This assumes the POM has been unpacked by the dependency plugin as part of the build
			pathsToTry = pathsToTry.append(Path.of("target", "dependency", artifactId + ".pom"));
		}
		
		var path = pathsToTry.findFirst(Files::isReadable).orElseThrow(() ->
			new IllegalArgumentException("No readable POM file found in the specified path(s)"));
		
		try (var reader = Files.newInputStream(path)) {
			var pom = new MavenXpp3Reader().read(reader);
			// TODO: Ideally get Java version from effective POM
			var ret = Function.Builder.create(stack(), pom.getArtifactId()).runtime(Runtime.JAVA_17);
			ret.functionName(pom.getArtifactId()).description(pom.getDescription());
			ret.code(Code.fromAsset(path.resolveSibling(pom.getArtifactId() + "-shaded.jar").toString()));
			return ret;
		} catch (XmlPullParserException e) {
			throw new IOException(e);
		}
	}

	@Setter @Accessors(fluent = true)
	@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
	class ParamFromSecretBuilder implements Builder<CfnParameter> {
		@Delegate
		private final CfnParameter.Builder delegate;
		private final String path;
		
		@Getter
		private String pathDescription;

		// Assumes the last path fragment is the access path inside the secret
		public ParamFromSecretBuilder secret(ISecret s) {
			return secret(s, StringUtils.substringAfterLast(path, "/"));
		}

		// Custom path in the secret regardless of the parameter path
		public ParamFromSecretBuilder secret(ISecret s, String secretPath) {
			value(SECRET_PATH + s.getSecretName() + "/" + secretPath);
			return this;
		}
		
		/**
		 * Sets the description for the parameter. If you have already set a 
		 * path description via {@link #pathDescription(String)} that will be 
		 * appended to the end of this description to form the final description.
		 * If not, this description will be used as-is.
		 * @param baseDescription the base description for related parameters
		 * at the same level of the hierarchy.
		 * @return this for chaining
		 */
		public ParamFromSecretBuilder description(String baseDescription) {
			if (pathDescription == null) {
				delegate.description(baseDescription);
			} else {
				delegate.description(baseDescription + " - " + pathDescription);
			}
			return this;
		}
	}
}
