package com.compassion.commons.jackson;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public interface PasswordMixin {
	@JsonSerialize(using = PasswordSerializer.class)
	public String getPassword();
}
