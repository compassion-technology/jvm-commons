package com.compassion.commons.config;

import java.util.function.Consumer;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

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
	}
	
	@Getter @Setter @Accessors(chain = true)
	public class ConfigWithUserPassword extends YAMLConfig implements CredentialConfig {
		private String user;
		private String password;
		
		@Override
		public void forEachCredentialPath(Consumer<String> withSecretPath) {
			withSecretPath.accept("user");
			withSecretPath.accept("password");
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
    }
}
