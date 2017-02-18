/*******************************************************************************
 * Copyright (c) 2017 Elder Research, Inc.
 * All rights reserved.
 *******************************************************************************/
package com.datamininglab.commons.lang;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

import lombok.val;

/**
 * Very similar to a {@link ThreadLocal} but this allows callers to access and derefence all created instances, not just
 * the one visible to the current thread. This class is thread-safe.
 * 
 * @author <a href="mailto:dimeo@datamininglab.com">John Dimeo</a>
 * @param <T> the type of object associated with each thread
 * @since Feb 17, 2017
 */
public class ThreadLocalMap<T> {
	private Supplier<T> supplier;
	private Map<Thread, T> map;
	
	/**
	 * Creates a new thread-localized map. 
	 * @param supplier the supplier to use to create new values for each new thread accessing the map. If this is
	 * <tt>null</tt>, {@link #get()} will always return <tt>null</tt> unless values are explicitly {@link #set(Object)}. 
	 */
	public ThreadLocalMap(Supplier<T> supplier) {
		this.supplier = supplier;
		this.map = new HashMap<>();
	}
	
	/**
	 * Returns the value for the current thread, creating one if this is the first time this thread accessed the map
	 * using the supplier passesd to the constructor.
	 * @return the value associated with this thread
	 */
	public T get() {
		val t = Thread.currentThread();
		T ret;
		synchronized (map) {
			ret = map.get(t);
			if (ret == null && supplier != null) {
				ret = supplier.get();
				map.put(t, ret);
			}
		}
		return ret;
	}
	
	/**
	 * Sets the value for the current thread.
	 * @param obj the new value for this thread
	 * @return the previous value associated with the thread, or <tt>null</tt> if this is the first object to be 
	 * associated with the thread.
	 */
	public T set(T obj) {
		val t = Thread.currentThread();
		synchronized (map) {
			return map.put(t, obj);
		}
	}
	
	/**
	 * Perform the callback for each value associated with a thread.
	 * @param callback the callback to perform on each value
	 */
	public void forEach(Consumer<T> callback) {
		synchronized (map) {
			map.values().forEach(callback);
		}
	}
	
	/**
	 * Clear all values associated with all threads, so that subsequent calls to {@link #get()} will trigger the
	 * creation of new objects.
	 */
	public void clear() {
		synchronized (map) {
			map.clear();
		}
	}
	
	/**
	 * Perform the callback for each value associated with a thread, then clear the values in a single atomic operation.
	 * @param callback the callback to perform on each value
	 */
	public void forEachThenClear(Consumer<T> callback) {
		synchronized (map) {
			map.values().forEach(callback);
			map.clear();
		}
	}	
}
