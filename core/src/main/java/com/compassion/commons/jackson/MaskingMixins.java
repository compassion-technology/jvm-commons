package com.compassion.commons.jackson;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public interface MaskingMixins {
	interface EncryptionKeyMixin {
		@JsonSerialize(using = PasswordSerializer.class)
		String getEncryptionKey();
	}
	
	interface ApiKeyMixin {
		@JsonSerialize(using = PasswordSerializer.class)
		String getApiKey();
	}
	
	interface ClientSecretMixin {
		@JsonSerialize(using = PasswordSerializer.class)
		String getClientSecret();
	}
	
	interface PasswordMixin {
		@JsonSerialize(using = PasswordSerializer.class)
		String getPassword();
	}
}
