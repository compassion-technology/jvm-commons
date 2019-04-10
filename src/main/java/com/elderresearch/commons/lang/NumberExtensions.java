/*******************************************************************************
 * Copyright (c) 2016 Elder Research, Inc.
 * All rights reserved.
 *******************************************************************************/
package com.elderresearch.commons.lang;

import lombok.experimental.UtilityClass;

/**
 * Extends {@link Number} with utilities to convert the number to the boxed
 * primitive types, skipping unboxing/boxing if possible. 
 * 
 * @author <a href="mailto:dimeo@datamininglab.com">John Dimeo</a>
 * @since Mar 8, 2016
 */
@UtilityClass
public class NumberExtensions {
	public Long asLong(Number n) {
		if (n instanceof Long) { return (Long) n; }
		return LambdaUtils.apply(n, Number::longValue);
	}
	
	public Double asDouble(Number n) {
		if (n instanceof Double) { return (Double) n; }
		return LambdaUtils.apply(n, Number::doubleValue);
	}
	
	public Integer asInteger(Number n) {
		if (n instanceof Integer) { return (Integer) n; }
		return LambdaUtils.apply(n, Number::intValue);
	}
	
	public Float asFloat(Number n) {
		if (n instanceof Float) { return (Float) n; }
		return LambdaUtils.apply(n, Number::floatValue);
	}
	
	public Short asShort(Number n) {
		if (n instanceof Short) { return (Short) n; }
		return LambdaUtils.apply(n, Number::shortValue);
	}
	
	public Byte asByte(Number n) {
		if (n instanceof Byte) { return (Byte) n; }
		return LambdaUtils.apply(n, Number::byteValue);
	}
}
