package com.elderresearch.commons.lang.jackson;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public interface ApiKeyMixin {
	@JsonSerialize(using = PasswordSerializer.class)
	String getApiKey();
}
