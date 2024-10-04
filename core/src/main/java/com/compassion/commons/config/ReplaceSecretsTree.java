package com.compassion.commons.config;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;

import com.compassion.commons.Utilities;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;

/**
 * <p>An environment tree that also supports dereferencing secrets in Secrets Manager
 * at any point in the configuration.</p>
 * <p>Two instances are provided- one for basic environment variables and system
 * properties (with secrets still dereferenced if used) and one that looks for parameter
 * overrides in the SSM Parameter Store.</p>
 */
@Log4j2
@Getter
public class ReplaceSecretsTree extends ConfigOverrides {
	private final ParamStoreEnvironment ssm;
	private final ConfigEnvironment secrets;

 	protected ReplaceSecretsTree(String... prefixes) {
 		super(prefixes);
 		ssm = new ParamStoreEnvironment(prefixes);
 		secrets = new ConfigEnvironment() {
 	 		@Override
 	 		public boolean has(String path, JsonNode existing) {
 	 			return StringUtils.startsWith(existing.asText(), ParamStoreEnvironment.SECRET_PATH);
 	 		}

 	 		@Override
 	 		public JsonNode get(String path, JsonNode existing) {
 				try {
 					return JsonNodeFactory.instance.textNode(ssm.getSecretValue(path.toString(), existing.asText()));
 				} catch (IOException e) {
 					log.warn("Error resolving secret {}", existing.asText(), e);
 					return null;
 				}
 	 		}
 	 	};
 	}
 	
 	private ReplaceSecretsTree withEnv()     { return Utilities.cast(withEnvironmentVariables().withSystemProperties()); }
 	private ReplaceSecretsTree withSSM()     { return Utilities.cast(with(ssm)); }
 	private ReplaceSecretsTree withSecrets() { return Utilities.cast(with(secrets)); }

 	public static ReplaceSecretsTree envVarsSysProps(String... prefixes) {
 		return new ReplaceSecretsTree(prefixes).withEnv().withSecrets();
 	}
 	public static ReplaceSecretsTree ssmParamsSecrets(String... prefixes) {
 		return new ReplaceSecretsTree(prefixes).withSSM().withSecrets();
 	}
}
