/* ©2019-2020 Elder Research, Inc. All rights reserved. */
package com.elderresearch.commons.lang;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

import com.elderresearch.commons.lang.CachedSupplier.Result;
import com.elderresearch.commons.lang.CachedSupplier.ResultType;

/**
 * tests for CachedSupplier Utility
 * 
 * @author <a href=mailto:colin.thomas@elderresearch.com>Colin Thomas</a>
 * @since March 26, 2019
 */
public class CachedSupplierTest {
	@Test
	public void testBasicCalculation() {
		CachedSupplier<Integer> cache = new CachedSupplier<>(() -> Result.completed(2));
		assertFalse(cache.isCached());
		assertTrue(cache.getOptional().isPresent() && cache.get() == 2);
		assertTrue(cache.isCached());
	}
	
	@Test
	public void testCache() {
		AtomicInteger test = new AtomicInteger(1);
		CachedSupplier<Integer> cache = new CachedSupplier<>(() -> Result.completed(test.getAndIncrement()));
		
		assertTrue(cache.get() == 1);
		// cache should no longer be same as the test (because the supplier does an increment)
		assertFalse(test.get() == cache.get());
		// cache value should stay the same no matter how many times it is called
		assertTrue(cache.get() == 1);
		// after the first cache run, the atomic integer should no longer be incremented
		assertTrue(test.get() == 2);
	}
	
	@Test
	public void testInProgress() {
		CachedSupplier<Integer> cache = new CachedSupplier<>(() -> Result.inProgress(3));
		// should return the default
		assertTrue(cache.get() == 3);
		// should not be cached
		assertFalse(cache.isCached());
	}
	
	@Test
	public void testReset() {
		AtomicInteger value = new AtomicInteger(5);
		CachedSupplier<Integer> cache = new CachedSupplier<>(() -> Result.completed(value.get()));
		
		assertTrue(value.get() == cache.get());
		value.incrementAndGet();
		assertFalse(value.get() == cache.get());
		cache.reset();
		assertTrue(value.get() == cache.get());
		
	}
	
	@Test
	public void testBeforeReset() {
		int startValue = 1;
		AtomicInteger source = new AtomicInteger(startValue);
		
		CachedSupplier<Integer> cache = new CachedSupplier<>(() -> Result.completed(source.getAndIncrement()), 
				value -> source.set(startValue));
		
		assertTrue(cache.get() == startValue);
		assertTrue(source.get() == startValue + 1);
		cache.reset();
		assertTrue(source.get() == startValue);
	}
	
	@Test
	public void testFailed() {
		CachedSupplier<Integer> cache = new CachedSupplier<>(() -> Result.failed(new Throwable("test")));
		assertNull(cache.get());
		assertTrue(cache.getResultType() == ResultType.FAILED);
		assertTrue(cache.isCached());
	}
}
