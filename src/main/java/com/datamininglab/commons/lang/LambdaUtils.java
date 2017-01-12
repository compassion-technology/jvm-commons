/*******************************************************************************
 * Copyright (c) 2016 Elder Research, Inc.
 * All rights reserved.
 *******************************************************************************/
package com.datamininglab.commons.lang;

import java.io.IOException;
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
	
	// This class is needed because, when calling these methods, the compiler can't tell the difference of the method
	// signatures based on throws or not for lambdas- would've needed to cast
	public static class IO {
		/**
		 * Invoke the supplier, returning <tt>null</tt> if the supplier is <tt>null</tt>.
		 * @param supplier the supplier
		 * @param <I> the supplier's return type
		 * @return the result of the supplier, or <tt>null</tt> if it was <tt>null</tt>
		 * @throws IOException if there was an I/O exception in the supplier's implementation
		 */
		public static <I> I get(IOSupplier<I> supplier) throws IOException {
			return supplier == null? null : supplier.get();
		}
		
		/**
		 * Invoke the function to the input, returning <tt>null</tt> if either the input or the function are <tt>null</tt>. 
		 * @param in the input
		 * @param fn the function
		 * @param <I> the function's input type
		 * @param <O> the function's output type
		 * @return the output of the function, or <tt>null</tt> if the input or functiona was <tt>null</tt>
		 * @throws IOException if there was an I/O exception in the function's implementation
		 */
		public static <I, O> O apply(I in, IOFunction<I, O> fn) throws IOException {
			return in == null || fn == null? null : fn.apply(in);
		}
		
		/**
		 * Invoke the consumer if both the input and the consumer are not <tt>null</tt>.
		 * @param in the input
		 * @param consumer the consumer to invoke if the input is not <tt>null</tt>
		 * @param <I> the consumer's input type
		 * @throws IOException if there was an I/O exception in the consumer's implementation
		 */
		public static <I> void accept(I in, IOConsumer<I> consumer) throws IOException {
			if (in != null && consumer != null) { consumer.accept(in); }
		}
	}
	
	/**
	 * Runnable that throws an {@link IOException}.
	 * @see Runnable
	 */
	public interface IORunnable {
		void run() throws IOException;
	}
	
	/**
	 * Consumer that throws an {@link IOException}.
	 * @param <T> the type of the input to the operation
	 * @see Consumer 
	 */
	public interface IOConsumer<T> {
		void accept(T obj) throws IOException;
	}
	
	/**
	 * Supplier that throws an {@link IOException}.
	 * @param <T> the type of the input to the operation
	 * @see Supplier 
	 */
	public interface IOSupplier<T> {
		T get() throws IOException;
	}
	
	/**
	 * Function that throws an {@link IOException}.
	 * @param <T> the type of the input to the function
	 * @param <R> the type of the result of the function
	 * @see Function 
	 */
	public interface IOFunction<T, R> {
		R apply(T in) throws IOException;
	}
}
