/* ©2017-2020 Elder Research, Inc. All rights reserved. */
package com.elderresearch.commons.lang;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.val;

/**
 * A (mostly) thread-safe, memoized supplier wrapper that includes the ability to
 * reset the supplier.
 * @author <a href=mailto:colin.thomas@elderresearch.com>Colin Thomas</a>
 * @param <T> the type of objects returned from this supplier
 * @since Oct 5, 2017
 */
public class CachedSupplier<T> implements Supplier<T> {
    private final Supplier<Result<T>> delegate;
    private final Optional<Consumer<T>> beforeReset;
    private Supplier<Result<T>> memoized;
    private boolean cached;
    
    public CachedSupplier(Supplier<Result<T>> delegate) {
    	this(delegate, null);
    }
    
    /**
     * @param delegate
     * @param beforeReset - consumer to run just before resetting the cache (helpful for native
     * 		objects that require smarter memory management than the JVM garbage collector can provide)
     */
    public CachedSupplier(Supplier<Result<T>> delegate, Consumer<T> beforeReset) {
        this.delegate = delegate;
        this.beforeReset = Optional.ofNullable(beforeReset);
        init();
    }
    
    public synchronized void reset() {
    	beforeReset.filter($ -> isCached()).ifPresent(consumer -> getOptional().ifPresent(consumer));
    	init();
    }
    
    private void init() {
		// Note: Suppliers.memoize still expects a Guava supplier, so #lambdas :)
        memoized = Suppliers.memoize(delegate::get);
        cached = false;
    }
    
    @Override
    public T get() {
    	return getOptional().orElse(null);
    }
    
    public Optional<T> getOptional() {
        return getResult().getResult();
    }
    
    public Result<T> getResult() {
        // this is thread safe
        val retval = memoized.get();
        cached = true;
        // this is thread safe-ish
        if (retval.getType() == ResultType.IN_PROGRESS) {
        	// don't run the full reset (i.e. w/ beforeReset)
        	init();
        }
        return retval;
    }
    
    /**
     * check to see if cache has been performed (without actually
     */
    public boolean isCached() {
    	return cached;
    }
    
    public void ifCached(Consumer<T> consumer) {
    	if (isCached()) getOptional().ifPresent(consumer);
    }
    
    public ResultType getResultType() {
		return memoized.get().getType();
	}
	
	public Optional<Throwable> getError() {
		return Optional.ofNullable(memoized.get().getError());
	}
	
	public List<String> getIssues() {
		return memoized.get().getIssues();
	}
	
    /**
     * Enumeration of the results of the calculation.
     * When the type is not {@link ResultType#COMPLETED}, then the calculation will be rememoized.
     * 
     * @author <a href=mailto:colin.thomas@elderresearch.com>Colin Thomas</a>
     * @since Oct 12, 2017
     */
    public enum ResultType {
        FAILED,
        IN_PROGRESS,
        COMPLETED
    }
    
    /**
     * Wrapper for the results of a calculation.
     * 
     * @author <a href=mailto:colin.thomas@elderresearch.com>Colin Thomas</a>
     * @param <T> the type of objects returned from this supplier
     * @since Oct 12, 2017
     */
    @Getter
    @AllArgsConstructor(staticName = "of")
    public static class Result<T> {
        private static final Result<?> FAILED = of(ResultType.FAILED, Optional.empty(), null, Collections.emptyList());
        
        public static <T> Result<T> completed(T result) {
            return of(ResultType.COMPLETED, Optional.of(result), null, Collections.emptyList());
        }
        
        public static <T> Result<T> completed(T result, Collection<String> issues) {
            return of(ResultType.COMPLETED, Optional.of(result), null, ImmutableList.copyOf(issues));
        }
        
        public static <T> Result<T> failed() {
            return Utilities.cast(FAILED);
        }
        
        public static <T> Result<T> failed(Throwable ex) {
        	return of(ResultType.FAILED, Optional.empty(), ex, Collections.emptyList());
        }
        
        public static <T> Result<T> inProgress() {
            return inProgress(null);
        }
        
        public static <T> Result<T> inProgress(T intermediary) {
            return of(ResultType.IN_PROGRESS, Optional.ofNullable(intermediary), null, Collections.emptyList());
        }
        
        private final ResultType type;
        private final Optional<T> result;
        private final Throwable error;
		private final List<String> issues;
    }
}
