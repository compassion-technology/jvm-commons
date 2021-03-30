package com.elderresearch.commons.lang.jackson;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializerBase;

/**
 * A serializer that returns a constant string regardless of the input object. This can be used to override or mask
 * a field at serialization. Typically you would use this as a mixin using {@link JsonSerialize} {@code using} a subclass
 * of this class. A provided {@link PasswordSerializer} with a password asterisks can be used to mask sensitive values.
 * 
 * @author <a href="dimeo@elderresearch.com">John Dimeo</a>
 * @since Mar 9, 2021
 */
public class ConstantSerializer extends ToStringSerializerBase {
	private final String constant;
	
	public ConstantSerializer(Class<?> c, String constant) {
		super(c);
		this.constant = constant;
	}
	
	@Override
	public String valueToString(Object value) {
		return constant;
	}
	
	public static class PasswordSerializer extends ConstantSerializer {
		public PasswordSerializer() { super(Object.class, "******"); }
	}
	
	interface PasswordMixin {
		@JsonSerialize(using = PasswordSerializer.class)
		public String getPassword();
	}
}
