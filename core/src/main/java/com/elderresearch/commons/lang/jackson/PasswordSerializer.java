package com.elderresearch.commons.lang.jackson;

public class PasswordSerializer extends ConstantSerializer {
	public PasswordSerializer() { super(Object.class, "******"); }
}
