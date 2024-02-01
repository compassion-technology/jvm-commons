package com.compassion.commons.jackson;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public interface ClientSecretMixin {
	@JsonSerialize(using = PasswordSerializer.class)
	String getClientSecret();
}
