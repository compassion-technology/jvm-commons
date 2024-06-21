package com.compassion.commons.jackson;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.ser.std.ToStringSerializerBase;

public class PasswordSerializer extends ToStringSerializerBase {
	private static final int MIN_LEN = 5;
	
	public PasswordSerializer() { super(Object.class); }

	@Override
	public String valueToString(Object value) {
		return StringUtils.repeat("*", Math.max(Objects.toString(value).length(), MIN_LEN));
	}
}
