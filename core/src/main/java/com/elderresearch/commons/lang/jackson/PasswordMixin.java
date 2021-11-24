package com.elderresearch.commons.lang.jackson;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public interface PasswordMixin {
	@JsonSerialize(using = PasswordSerializer.class)
	public String getPassword();
}
