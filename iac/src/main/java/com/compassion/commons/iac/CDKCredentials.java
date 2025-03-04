package com.compassion.commons.iac;

import org.jooq.lambda.Seq;

import com.compassion.commons.config.CredentialConfig;
import com.compassion.commons.iac.CDKUtils.ParamFromSecretBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;

import software.amazon.awscdk.SecretValue;
import software.amazon.awscdk.services.secretsmanager.ISecret;
import software.amazon.awscdk.services.secretsmanager.Secret;
import software.constructs.Construct;

public interface CDKCredentials extends CredentialConfig {
	default Secret.Builder asSecret(Construct stack, String id) {
		try {
			return Secret.Builder.create(stack, id).secretStringValue(SecretValue.unsafePlainText(toPlaceholderJson()));
		} catch (JsonProcessingException e) {
			throw new IllegalArgumentException("Cannot generate placeholder JSON from " + this, e);
		}
	}
	
	/**
	 * Create parameters from this credential object. Secrets should reference the secret to lookup the value.
	 * Regular parameters should specify the value using the values in this credentials objects.
	 * @param utils the utils to create the customized parameter builder
	 * @param path the path of the parent node for these credentials
	 * @param secret the related secret
	 * @return parameter builders with names (paths), path descriptions, and values configured
	 * @see CDKUtils#newParam(String)
	 * @see ParamFromSecretBuilder#pathDescription(String)
	 * @see ParamFromSecretBuilder#secret(ISecret)
	 */
	Seq<ParamFromSecretBuilder> asParams(CDKUtils utils, String path, ISecret secret);
}
