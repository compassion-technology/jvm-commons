/*******************************************************************************
 * Copyright (c) 2017 Elder Research, Inc.
 * All rights reserved.
 *******************************************************************************/
package com.elderresearch.commons.lang;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.val;

/**
 * A (mostly) thread-save, memoized supplier wrapper that includes the ability to
 * reset the supplier.
 * @author <a href=mailto:colin.thomas@elderresearch.com>Colin Thomas</a>
 * @param <T> the type of objects returned from this supplier
 * @since Oct 5, 2017
 */
public class CachedSupplier<T> implements Supplier<T> {
    private final Supplier<Result<T>> delegate;
    private Supplier<Result<T>> memoized;
    
    public CachedSupplier(Supplier<Result<T>> delegate) {
        this.delegate = delegate;
        reset();
    }
    
    public synchronized void reset() {
		// Note: Suppliers.memoize still expects a Guava supplier, so #lambdas :)
        memoized = Suppliers.memoize(delegate::get);
    }
    
    @Override
    public T get() {
        // this is thread safe
        val retval = memoized.get();
        // this is thread safe-ish
        if (retval.getType() == ResultType.IN_PROGRESS) {
            reset();
        }
        return retval.getResult();
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
        private static final Result<?> FAILED = of(ResultType.FAILED, null, null, Collections.emptyList());
        
        public static <T> Result<T> completed(T result) {
            return of(ResultType.COMPLETED, result, null, Collections.emptyList());
        }
        
        public static <T> Result<T> completed(T result, Collection<String> issues) {
            return of(ResultType.COMPLETED, result, null, ImmutableList.copyOf(issues));
        }
        
        public static <T> Result<T> failed() {
            return Utilities.cast(FAILED);
        }
        
        public static <T> Result<T> failed(Throwable ex) {
        	return of(ResultType.FAILED, null, ex, Collections.emptyList());
        }
        
        public static <T> Result<T> inProgress() {
            return inProgress(null);
        }
        
        public static <T> Result<T> inProgress(T intermediary) {
            return of(ResultType.IN_PROGRESS, intermediary, null, Collections.emptyList());
        }
        
        private final ResultType type;
        private final T result;
        private final Throwable error;
		private final List<String> issues;
    }
}