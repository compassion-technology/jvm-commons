/*
 * Copyright (c) 2016 Elder Research, Inc.
 * All rights reserved.
 */
package com.datamininglab.commons.lang;

/**
 * Extends {@link Number} with utilities to convert the number to the boxed
 * primitive types, skipping unboxing/boxing if possible. 
 * 
 * @author <a href="mailto:dimeo@datamininglab.com">John Dimeo</a>
 * @since Mar 8, 2016
 */
public final class NumberExtensions {
	private NumberExtensions() {
		// Prevent initialization
	}
	
	public static Long asLong(Number n) {
		if (n instanceof Long) { return (Long) n; }
		return n == null? null : Long.valueOf(n.longValue());
	}
	
	public static Double asDouble(Number n) {
		if (n instanceof Double) { return (Double) n; }
		return n == null? null : Double.valueOf(n.doubleValue());
	}
	
	public static Integer asInteger(Number n) {
		if (n instanceof Integer) { return (Integer) n; }
		return n == null? null : Integer.valueOf(n.intValue());
	}
	
	public static Float asFloat(Number n) {
		if (n instanceof Float) { return (Float) n; }
		return n == null? null : Float.valueOf(n.floatValue());
	}
	
	public static Short asShort(Number n) {
		if (n instanceof Short) { return (Short) n; }
		return n == null? null : Short.valueOf(n.shortValue());
	}
	
	public static Byte asByte(Number n) {
		if (n instanceof Byte) { return (Byte) n; }
		return n == null? null : Byte.valueOf(n.byteValue());
	}
}
