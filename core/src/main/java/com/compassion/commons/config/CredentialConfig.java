package com.compassion.commons.config;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ServiceLoader;
import java.util.function.Consumer;

import com.compassion.commons.LambdaUtils;
import com.compassion.commons.ReflectionUtils;
import com.compassion.commons.jackson.PasswordSerializer;
import com.compassion.commons.jackson.PlaceholderMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.auto.service.AutoService;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import picocli.CommandLine.Option;

/**
 * Provides common base classes for configuration involving credentials or secrets, like passwords and API keys.
 * These base classes provide:<ul>
 * <li>Provide a simple base class for API SDKs that require credentials to auth against the API. This also allows shared config
 * to inherit from the same base class as a specialized SDK config without having to have the entire SDK on the classpath.</li>
 * <li>Provide a placeholder when creating secrets in CDK stacks that define the structure of the secret without exposing the secret itself</li>
 * <li>Provide mixins that mask the secrets when logging the config</li>
 * </ul>
 */
public interface CredentialConfig {
	// Create the related/linked SSM parameters from each child secret attribute
	void forEachCredentialPath(Consumer<String> withSecretPath);
	
	@AutoService(CredentialConfig.class)
	@Getter @Setter @Accessors(chain = true)
	public class ConfigWithApiKey extends YAMLConfig implements CredentialConfig {
		private String apiKey;
		
		@Override
		public void forEachCredentialPath(Consumer<String> withSecretPath) {
			withSecretPath.accept("apiKey");
		}
		
		public interface Mixin {
			@JsonSerialize(using = PasswordSerializer.class)
			String getApiKey();
		}
	}
	
	@AutoService(CredentialConfig.class)
	@Accessors(chain = true)
	public class ConfigWithUserPassword extends YAMLConfig implements CredentialConfig {
		@Getter @Setter
		@Option(names = {"-u", "--user"}, description = "The user")
		private String user;

		@Option(names = {"-p", "--password"}, description = "The password (if required)")
		private char[] password;
		
		// Don't store password as string internally for security reasons
		public String getPassword() {
			return LambdaUtils.apply(password, String::new);
		}
		public ConfigWithUserPassword setPassword(String s) {
			this.password = LambdaUtils.apply(s, String::toCharArray);
			return this;
		}
		
		@Override
		public void forEachCredentialPath(Consumer<String> withSecretPath) {
			withSecretPath.accept("user");
			withSecretPath.accept("password");
		}
		
		public interface Mixin {
			@JsonSerialize(using = PasswordSerializer.class)
			String getPassword();
		}
	}
	
	@AutoService(CredentialConfig.class)
	@Getter @Setter @Accessors(chain = true)
    public class ConfigWithToken extends YAMLConfig implements CredentialConfig {
		private String privateKey;
		private String publicKey;
        private String signature;
        
        @Override
        public void forEachCredentialPath(Consumer<String> withSecretPath) {
        	withSecretPath.accept("privateKey");
        	withSecretPath.accept("publicKey");
            withSecretPath.accept("signature");
        }
        
        public interface Mixin {
        	@JsonSerialize(using = PasswordSerializer.class)
        	String getPrivateKey();
        	@JsonSerialize(using = PasswordSerializer.class)
        	String getSignature();
        	@JsonSerialize(using = PasswordSerializer.class)
        	String getPublicKey();
        }
    }
	
	@AutoService(CredentialConfig.class)
	@Getter @Setter @Accessors(chain = true)
	public class ConfigWithUserPasswordToken extends ConfigWithUserPassword {
		private String privateKey;
		private String publicKey;
		
		@Override
		public void forEachCredentialPath(Consumer<String> withSecretPath) {
			super.forEachCredentialPath(withSecretPath);
			withSecretPath.accept("privateKey");
			withSecretPath.accept("publicKey");
		}
		
		public interface Mixin extends ConfigWithUserPassword.Mixin, ConfigWithToken.Mixin {
			// No additional methods
		}
	}
	
	@AutoService(CredentialConfig.class)
	@Getter @Setter @Accessors(chain = true)
	public class ConfigWithOAuth extends YAMLConfig implements CredentialConfig {
		private String clientSecret;
		private String clientId;
		
		@Override
		public void forEachCredentialPath(Consumer<String> withSecretPath) {
			withSecretPath.accept("clientSecret");
			withSecretPath.accept("clientId");
		}
		
		public interface Mixin {
			@JsonSerialize(using = PasswordSerializer.class)
			String getClientSecret();
			@JsonSerialize(using = PasswordSerializer.class)
			String getClientId();
		}
	}
	
	static ObjectMapper addMaskingMixins(ObjectMapper om) {
		return om.addMixIn(ConfigWithApiKey.class,            ConfigWithApiKey.Mixin.class)
		         .addMixIn(ConfigWithUserPassword.class, 	  ConfigWithUserPassword.Mixin.class)
		         .addMixIn(ConfigWithUserPasswordToken.class, ConfigWithUserPasswordToken.Mixin.class)
		         .addMixIn(ConfigWithToken.class,             ConfigWithToken.Mixin.class)
		         .addMixIn(ConfigWithOAuth.class,             ConfigWithOAuth.Mixin.class);
	}
	
	/**
	 * Write this credential object as placeholder JSON, using a "snake case" convention
	 * which is more common across languages instead of Java's camel case, and converting
	 * {@code null} to an empty string.
	 * @return this credential object as placeholder JSON
	 * @throws JsonProcessingException if there was an error serializing this to JSON
	 */
	default String toPlaceholderJson() throws JsonProcessingException {
		return PlaceholderMapper.INSTANCE.writeValueAsString(this);
	}
	
	/**
	 * Load all implementations of {@link CredentialConfig} via the service loader and 
	 * return instances of them (suitable for finding the right placeholder type for an
	 * extending configuration subclass).
	 * @return a list of all available implementations sorted by the most specific
	 * implementation first
	 */
	static List<CredentialConfig> getPlaceholders() {
		var ret = new ArrayList<CredentialConfig>();
		ServiceLoader.load(CredentialConfig.class).forEach(ret::add);
		ret.sort(Comparator.comparingInt(cc -> ReflectionUtils.countSuperclasses(cc.getClass())).reversed());
		return ret;
	}
}
