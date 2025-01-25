package com.compassion.commons;

import java.io.Closeable;
import java.io.IOException;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.jooq.lambda.Seq;

import lombok.experimental.UtilityClass;
import lombok.extern.log4j.Log4j2;

/**
 * Some utilities around interacting with Java 8's lambda/functional interfaces, mostly dealing with {@code null}.
 * 
 * @author <a href="mailto:dimeo@datamininglab.com">John Dimeo</a>
 * @since Oct 19, 2016
 */
@UtilityClass
public class LambdaUtils {
	/**
	 * Invoke the supplier, returning {@code null} if the supplier is {@code null}.
	 * @param supplier the supplier
	 * @param <I> the supplier's return type
	 * @return the result of the supplier, or {@code null} if it was {@code null}
	 */
	public <I> I get(Supplier<I> supplier) {
		return supplier == null? null : supplier.get();
	}
	
	/**
	 * Invoke the function to the input, returning {@code null} if either the input or the function are {@code null}. 
	 * @param in the input
	 * @param fn the function
	 * @param <I> the function's input type
	 * @param <O> the function's output type
	 * @return the output of the function, or {@code null} if the input or functiona was {@code null}
	 */
	public <I, O> O apply(I in, Function<I, O> fn) {
		return in == null || fn == null? null : fn.apply(in);
	}
	
	/**
	 * Invoke the consumer if both the input and the consumer are not {@code null}.
	 * @param in the input
	 * @param consumer the consumer to invoke if the input is not {@code null}
	 * @param <I> the consumer's input type
	 */
	public <I> void accept(I in, Consumer<I> consumer) {
		if (in != null && consumer != null) { consumer.accept(in); }
	}
	
	/**
	 * Perform the operation with the resource, invoking the closer regardless of if the operation succeeds. This is
	 * for classes that do not implement the {@link Closeable} interface but still have a method that releases
	 * held resources.
	 * @param resource the resource on which to operate
	 * @param consumer the operation to perform on the resource
	 * @param closer the custom close method (for example {@code dispose()})
	 * @param <R> the resource type
	 */
	public <R> void acceptResource(R resource, Consumer<R> consumer, Consumer<R> closer) {
		try {
			consumer.accept(resource);
		} finally {
			closer.accept(resource);
		}
	}
	
	/**
	 * Perform the operation with the resource, invoking the closer regardless of if the operation succeeds. This is
	 * for classes that do not implement the {@link Closeable} interface but still have a method that releases
	 * held resources.
	 * @param resource the resource on which to operate
	 * @param function the operation to perform on the resource
	 * @param closer the custom close method (for example {@code dispose()})
	 * @param <R> the resource type
	 * @param <T> the result type
	 * @return the result of the function
	 */
	public <R, T> T applyResource(R resource, Function<R, T> function, Consumer<R> closer) {
		try {
			return function.apply(resource);
		} finally {
			closer.accept(resource);
		}
	}
		
	/**
	 * Returns either a stream with the input value or an empty stream
	 * if the input is null or any other pesky {@link Number} values 
	 * (Such as {@link Double#NaN NaN} or {@link Double#POSITIVE_INFINITY infinite}.
	 * @param in the input object
	 * @param <T> the object type
	 * @return a stream of the input object if it is valid
	 */
	public <T extends Number> Seq<T> filterInvalid(T in) {
		 if (in == null || !Double.isFinite(in.doubleValue())) { return Seq.empty(); }
	     return Seq.of(in);
	}
	
	// This class is needed because, when calling these methods, the compiler can't tell the difference of the method
	// signatures based on throws or not for lambdas- would've needed to cast
	@UtilityClass
	public class IO {
		/**
		 * Invoke the supplier, returning {@code null} if the supplier is {@code null}.
		 * @param supplier the supplier
		 * @param <I> the supplier's return type
		 * @return the result of the supplier, or {@code null} if it was {@code null}
		 * @throws IOException if there was an I/O exception in the supplier's implementation
		 */
		public <I> I get(IOSupplier<I> supplier) throws IOException {
			return supplier == null? null : supplier.get();
		}
		
		/**
		 * Invoke the function to the input, returning {@code null} if either the input or the function are {@code null}. 
		 * @param in the input
		 * @param fn the function
		 * @param <I> the function's input type
		 * @param <O> the function's output type
		 * @return the output of the function, or {@code null} if the input or functiona was {@code null}
		 * @throws IOException if there was an I/O exception in the function's implementation
		 */
		public <I, O> O apply(I in, IOFunction<I, O> fn) throws IOException {
			return in == null || fn == null? null : fn.apply(in);
		}
		
		/**
		 * Invoke the consumer if both the input and the consumer are not {@code null}.
		 * @param in the input
		 * @param consumer the consumer to invoke if the input is not {@code null}
		 * @param <I> the consumer's input type
		 * @throws IOException if there was an I/O exception in the consumer's implementation
		 */
		public static <I> void accept(I in, IOConsumer<I> consumer) throws IOException {
			if (in != null && consumer != null) { consumer.accept(in); }
		}
		
		/**
		 * Lambda wrapper for a try-with-resources blocks.
		 * @param closeable the closeable resource
		 * @param consumer the operation to perform on the resource
		 * @param <C> the resource type
		 * @throws IOException if {@code consumer} threw an exception
		 */
		public <C extends Closeable> void withResource(C closeable, IOConsumer<C> consumer) throws IOException {
			try (C c = closeable) {
				consumer.accept(c);
			}
		}
		
		/**
		 * Lambda wrapper for a try-with-resources blocks.
		 * @param closeable the closeable resource
		 * @param function the operation to perform on the resource
		 * @param <C> the resource type
		 * @param <T> the result type
		 * @return the result of the function
		 * @throws IOException if {@code function} threw an exception
		 */
		public <C extends Closeable, T> T withResource(C closeable, IOFunction<C, T> function) throws IOException {
			try (C c = closeable) {
				return function.apply(c);
			}
		}
		
		/**
		 * Perform the operation with the resource, invoking the closer regardless of if the operation succeeds. This is
		 * for classes that do not implement the {@link Closeable} interface but still have a method that releases
		 * held resources.
		 * @param resource the resource on which to operate
		 * @param consumer the operation to perform on the resource, which may throw an {@link IOException}
		 * @param closer the custom close method (for example {@code dispose()})
		 * @param <R> the resource type
		 * @throws IOException if {@code consumer} threw an exception
		 */
		public <R> void acceptResource(R resource, IOConsumer<R> consumer, IOConsumer<R> closer) throws IOException {
			try {
				consumer.accept(resource);
			} catch (IOException e) {
				throw e;
			} finally {
				closer.accept(resource);
			}
		}
		
		/**
		 * Perform the operation with the resource, invoking the closer regardless of if the operation succeeds. This is
		 * for classes that do not implement the {@link Closeable} interface but still have a method that releases
		 * held resources.
		 * @param resource the resource on which to operate
		 * @param function the operation to perform on the resource, which may throw an {@link IOException}
		 * @param closer the custom close method (for example {@code dispose()})
		 * @param <R> the resource type
		 * @param <T> the result type
		 * @return the result of the function
		 * @throws IOException if {@code function} threw an exception
		 */
		public <R, T> T applyResource(R resource, IOFunction<R, T> function, IOConsumer<R> closer) throws IOException {
			try {
				return function.apply(resource);
			} catch (IOException e) {
				throw e;
			} finally {
				closer.accept(resource);
			}
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
	 * BiConsumer that throws an {@link IOException}
	 * @param <T> the type of the first parameter
	 * @param <U> the type of the second parameter
	 * @see BiConsumer
	 */
	public interface IOBiConsumer<T, U> {
		void accept(T obj1, U obj2) throws IOException;
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
	
	/**
	 * Bi-function that throws an {@link IOException}.
	 * @param <T> the type of the first input to the function
	 * @param <U> the type of the second input to the function
	 * @param <R> the type of the result of the function
	 * @see BiFunction
	 */
	public interface IOBiFunction<T, U, R> {
		R apply(T in1, U in2) throws IOException;
	}
	
	/** Utilities that catch and log {@link InterruptedException}s using lambdas. */
	@Log4j2
	@UtilityClass
	public class Interruptable {
		public void run(InterruptableRunnable runnable, String verb) {
			try {
				runnable.run();
			} catch (InterruptedException e) {
				log.warn("Interrupted while {}", verb, e);
			}
		}
		
		public <T> void accept(InterruptableConsumer<T> consumer, T obj, String verb) {
			try {
				consumer.accept(obj);
			} catch (InterruptedException e) {
				log.warn("Interrupted while {} {}", verb, obj, e);
			}
		}
		
		public <T> T get(InterruptableSupplier<T> supplier, String verb, T defVal) {
			try {
				return supplier.get();
			} catch (InterruptedException e) {
				log.warn("Interrupted while {}", verb, e);
				return defVal;
			}
		}
		
		public <I, O> O apply(InterruptableFunction<I, O> function, I in, String verb, O defVal) {
			try {
				return function.apply(in);
			} catch (InterruptedException e) {
				log.warn("Interrupted while {} {}", verb, in, e);
				return defVal;
			}
		}
	}
	
	/**
	 * Runnable that throws an {@link InterruptedException}.
	 * @see Runnable
	 */
	public interface InterruptableRunnable {
		void run() throws InterruptedException;
	}
	
	/**
	 * Consumer that throws an {@link InterruptedException}.
	 * @param <T> the type of the input to the operation
	 * @see Consumer 
	 */
	public interface InterruptableConsumer<T> {
		void accept(T obj) throws InterruptedException;
	}
	
	/**
	 * Supplier that throws an {@link InterruptedException}.
	 * @param <T> the type of the input to the operation
	 * @see Supplier 
	 */
	public interface InterruptableSupplier<T> {
		T get() throws InterruptedException;
	}
	
	/**
	 * Function that throws an {@link InterruptedException}.
	 * @param <T> the type of the input to the function
	 * @param <R> the type of the result of the function
	 * @see Function 
	 */
	public interface InterruptableFunction<T, R> {
		R apply(T in) throws InterruptedException;
	}
}
