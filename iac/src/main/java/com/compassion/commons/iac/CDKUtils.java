package com.compassion.commons.iac;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.jooq.lambda.Seq;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;
import software.amazon.awscdk.Stack;
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

	default <C extends IConstruct> Tagger<C> tag(C c) {
		return Tagger.with(c);
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
