package com.compassion.commons.iac;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.jooq.lambda.Seq;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.val;
import lombok.experimental.Delegate;
import software.amazon.awscdk.Stack;
import software.amazon.awscdk.Tags;
import software.amazon.awscdk.services.ec2.ISubnet;
import software.amazon.awscdk.services.ec2.IVpc;
import software.amazon.awscdk.services.ec2.Vpc;
import software.amazon.awscdk.services.ec2.VpcLookupOptions;
import software.amazon.awscdk.services.secretsmanager.ISecret;
import software.amazon.awscdk.services.ssm.CfnParameter;
import software.constructs.IConstruct;

public interface CDKUtils extends CDKVariables {
	static ObjectMapper JSON = new ObjectMapper()
		.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);

	// Implementing stacks define the relevant application
	String application();
	// Stack can define user, defaulting to system username
	default String contact() { return SystemUtils.USER_NAME; }
	
	// TODO: Fix Pair warning
	default <C extends IConstruct> C tag(C c, String env, String name, Pair... additionalTags) {
		val tags = Tags.of(c);
		tags.add("name", StringUtils.prependIfMissingIgnoreCase(name, application().toUpperCase() + " "));
		tags.add("application", application().toLowerCase());
		tags.add("contact", contact() + "@us.ci.org");
		tags.add("creator", "aws-cdk");
		tags.add("team", "Data Works");
		tags.add("environment", env);
		for (var tag : additionalTags) {
			tags.add(tag.getKey().toString(), tag.getValue().toString());
		}
		return c;
	}

	default IVpc findVPC(Stack parent) {
		return Vpc.fromLookup(parent, "vpc", VpcLookupOptions.builder()
			.vpcName(VPC_NAME).ownerAccountId(parent.getAccount()).build());
	}
	
	default List<String> findSubnetsForVPC(IVpc vpc) {
		return Seq.seq(vpc.getPrivateSubnets()).map(ISubnet::getSubnetId).toList();
	}

	default ParamFromSecretBuilder newParam(Stack parent, String path) {
		path = StringUtils.prependIfMissing(path, "/");
		return new ParamFromSecretBuilder(CfnParameter.Builder.create(parent, path)
			.type("String").tier("Standard").name(path), path);
	}

	@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
	class ParamFromSecretBuilder {
		@Delegate
		private final CfnParameter.Builder delegate;
		private final String path;

		// Assumes the last path fragment is the access path inside the secret
		public ParamFromSecretBuilder secret(ISecret s) {
			return secret(s, StringUtils.substringAfterLast(path, "/"));
		}

		// Custom path in the secret regardless of the parameter path
		public ParamFromSecretBuilder secret(ISecret s, String secretPath) {
			value(SECRET_PATH + s.getSecretName() + "/" + secretPath);
			return this;
		}
	}
}
