package com.compassion.commons.config;

import java.util.function.Consumer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;

import lombok.Data;
import lombok.experimental.Accessors;

public interface SecretPlaceholder {
	final ObjectMapper mapper = new ObjectMapper().setPropertyNamingStrategy(PropertyNamingStrategies.LOWER_CAMEL_CASE);

	// If we store the whole config in the placeholder, the non-credential
	// default values would override values from the user's config, so 
	// provide "simple" placeholder classes that only have the relevant
	// secrets included.
	default String toJson() throws JsonProcessingException {
		return mapper.writeValueAsString(this);
	}
		
	// Create the related/linked SSM parameters from each child secret attribute
	void params(Consumer<String> withSecretPath);
	
	@Data @Accessors(chain = true)
	public class SimpleApiKey implements SecretPlaceholder, ISimpleApiKey {
		private String apiKey;
		
		@Override
		public void params(Consumer<String> withSecretPath) {
			withSecretPath.accept("apiKey");
		}
	}
	
	public interface ISimpleApiKey {
		public String getApiKey();
		public ISimpleApiKey setApiKey(String s);
	}
	
	@Data @Accessors(chain = true)
	class SimpleCredentials implements SecretPlaceholder, ISimpleCredentials {
		private String user;
		private String password;
		
		@Override
		public void params(Consumer<String> withSecretPath) {
			withSecretPath.accept("user");
			withSecretPath.accept("password");
		}
	}
	
    public interface ISimpleCredentials {
        public String getUser();
        public String getPassword();
        public ISimpleCredentials setUser(String s);
        public ISimpleCredentials setPassword(String s);
    }
	
    @Data @Accessors(chain = true)
    class SimpleToken implements SecretPlaceholder, ISimpleToken {
        @JsonProperty("public")  private String publicKey;
        @JsonProperty("private") private String privateKey;
        private String signature;
        
        @Override
        public void params(Consumer<String> withSecretPath) {
            withSecretPath.accept("public");
            withSecretPath.accept("private");
            withSecretPath.accept("signature");
        }
    }
    
    public interface ISimpleToken {
        public String getPublicKey();
        public String getPrivateKey();
        public String getSignature();
        public ISimpleToken setPublicKey(String s);
        public ISimpleToken setPrivateKey(String s);
        public ISimpleToken setSignature(String s);
    }
}
