package com.compassion.commons.jackson;

public class PasswordSerializer extends ConstantSerializer {
	public PasswordSerializer() { super(Object.class, "******"); }
}
