/*******************************************************************************
 * Copyright (c) 2016 Elder Research, Inc.
 * All rights reserved.
 *******************************************************************************/
package com.datamininglab.commons.lang;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Some utilities around interacting with Java 8's lambda/functional interfaces, mostly dealing with <tt>null</tt>.
 * 
 * @author <a href="mailto:dimeo@datamininglab.com">John Dimeo</a>
 * @since Oct 19, 2016
 */
public final class LambdaUtils {
	private LambdaUtils() {
		// Prevent initialization
	}
	
	/**
	 * Invoke the supplier, returning <tt>null</tt> if the supplier is <tt>null</tt>.
	 * @param supplier the supplier
	 * @param <I> the supplier's return type
	 * @return the result of the supplier, or <tt>null</tt> if it was <tt>null</tt>
	 */
	public static <I> I get(Supplier<I> supplier) {
		return supplier == null? null : supplier.get();
	}
	
	/**
	 * Invoke the function to the input, returning <tt>null</tt> if either the input or the function are <tt>null</tt>. 
	 * @param in the input
	 * @param fn the function
	 * @param <I> the function's input type
	 * @param <O> the function's output type
	 * @return the output of the function, or <tt>null</tt> if the input or functiona was <tt>null</tt>
	 */
	public static <I, O> O apply(I in, Function<I, O> fn) {
		return in == null || fn == null? null : fn.apply(in);
	}
	
	/**
	 * Invoke the consumer if both the input and the consumer are not <tt>null</tt>.
	 * @param in the input
	 * @param consumer the consumer to invoke if the input is not <tt>null</tt>
	 * @param <I> the consumer's input type
	 */
	public static <I> void accept(I in, Consumer<I> consumer) {
		if (in != null && consumer != null) { consumer.accept(in); }
	}
}
