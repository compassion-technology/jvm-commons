package com.compassion.commons.config;

import java.util.function.Consumer;

import com.compassion.commons.LambdaUtils;
import com.compassion.commons.jackson.PasswordSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import picocli.CommandLine.Option;

public interface CredentialConfig {
	// Create the related/linked SSM parameters from each child secret attribute
	void forEachCredentialPath(Consumer<String> withSecretPath);
	
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
	
	@Getter @Setter @Accessors(chain = true)
    public class ConfigWithToken extends YAMLConfig implements CredentialConfig {
        private String publicKey;
        private String privateKey;
        private String signature;
        
        @Override
        public void forEachCredentialPath(Consumer<String> withSecretPath) {
            withSecretPath.accept("publicKey");
            withSecretPath.accept("privateKey");
            withSecretPath.accept("signature");
        }
        
        public interface Mixin {
        	@JsonSerialize(using = PasswordSerializer.class)
        	String getPrivateKey();
        	@JsonSerialize(using = PasswordSerializer.class)
        	String getSignature();
        }
    }
	
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
	
	static void addMaskingMixins(ObjectMapper mapper) {
		mapper.addMixIn(ConfigWithApiKey.class,       ConfigWithApiKey.Mixin.class)
		      .addMixIn(ConfigWithUserPassword.class, ConfigWithUserPassword.Mixin.class)
		      .addMixIn(ConfigWithToken.class,        ConfigWithToken.Mixin.class)
		      .addMixIn(ConfigWithOAuth.class,        ConfigWithOAuth.Mixin.class);
	}
}
