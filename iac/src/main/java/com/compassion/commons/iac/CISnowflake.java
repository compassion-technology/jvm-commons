package com.compassion.commons.iac;

import org.jooq.lambda.Seq;

import com.compassion.commons.Utilities;
import com.compassion.commons.config.CIEnvironment;
import com.compassion.commons.config.CredentialConfig.ConfigWithUserPassword;
import com.compassion.commons.iac.CDKUtils.ParamFromSecretBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import software.amazon.awscdk.SecretValue;
import software.amazon.awscdk.services.secretsmanager.ISecret;
import software.amazon.awscdk.services.secretsmanager.Secret;
import software.constructs.Construct;

@Getter @Setter @Accessors(chain = true)
public class CISnowflake extends ConfigWithUserPassword {
	public enum CISnowflakeRole {
		WRITER,
		READER,
		DEVELOPER
	}
	
	private String database, role;
	
	public CISnowflake withDefaults(CIEnvironment env, String svc, String domain, CISnowflakeRole roleType) {
		switch (env) {
			case Prod  -> setDatabase(domain).setRole(domain + "_" + roleType).setUser(svc + "_SVC");
			case Stage -> setDatabase(domain + "_STAGE").setRole(domain + "_STAGE_" + roleType).setUser(svc + "_STAGE_SVC");
			default    -> setDatabase(domain + "_DEVINT").setRole(domain + "_DEVINT_" + roleType).setUser(svc + "_DEVINT_SVC");
			case Cloud -> throw new IllegalArgumentException("Snowflake does not support the Cloud environment");
		}
		return this;
	}
	
	public Secret.Builder asSecret(Construct stack, String id) {
		try {
			return Secret.Builder.create(stack, id).secretStringValue(SecretValue.unsafePlainText(toPlaceholderJson()));
		} catch (JsonProcessingException e) {
			throw new IllegalArgumentException("Cannot generate placeholder JSON from " + this, e);
		}
	}
	
	public Seq<ParamFromSecretBuilder> asParams(CDKUtils utils, String path, ISecret secret) {
		return Seq.of(
			utils.newParam(path + "/user").pathDescription("Username").secret(secret),
			utils.newParam(path + "/password").pathDescription("Password").secret(secret),
			Utilities.cast(utils.newParam(path + "/database").pathDescription("Database").value(getDatabase())),
			Utilities.cast(utils.newParam(path + "/role").pathDescription("Database Role").value(getRole()))
		);
	}
}
