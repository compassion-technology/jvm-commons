/* ©2017-2020 Elder Research, Inc. All rights reserved. */
package com.compassion.commons;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Supplier;

import lombok.val;

/**
 * Very similar to a {@link ThreadLocal} but this allows callers to access all created instances, not just
 * the one visible to the current thread. This class is thread-safe.
 * 
 * @author <a href="mailto:dimeo@datamininglab.com">John Dimeo</a>
 * @param <T> the type of object associated with each thread
 * @since Feb 17, 2017
 */
public class ThreadLocalList<T> implements Iterable<T> {
	private CopyOnWriteArrayList<T> all;
	private ThreadLocal<T> delegate;
	
	/**
	 * Creates a new thread-localized list. 
	 * @param supplier the supplier to use to create new values for each new thread accessing the map. If this is
	 * {@code null}, {@link #get()} will always return {@code null} unless values are explicitly {@link #set(Object)}. 
	 */
	public ThreadLocalList(Supplier<T> supplier) {
		all = new CopyOnWriteArrayList<>();
		delegate = ThreadLocal.withInitial(() -> {
			T ret = supplier.get();
			all.add(ret);
			return ret;
		});
	}
	
	@Override
	public Iterator<T> iterator() {
		return all.iterator();
	}
	
	/**
	 * Returns the value for the current thread, creating one if this is the first time this thread accessed the list
	 * using the supplier passesd to the constructor.
	 * @return the value associated with this thread
	 */
	public T get() {
		return delegate.get();
	}
	
	/**
	 * Sets the value for the current thread.
	 * @param obj the new value for this thread
	 */
	public void set(T obj) {
		delegate.set(obj);
	}
	
	/**
	 * Removes the current thread's value for this thread-local variable. If this thread-local variable is subsequently
	 * read by the current thread, its value will be reinitialized by invoking its initialValue method,unless its value
	 * is set by the current thread in the interim. This may result in multiple invocations of the initialValue method
	 * in the current thread.
	 */
	public void remove() {
		val existing = delegate.get();
		delegate.remove();
		all.remove(existing);
	}
	
	/**
	 * Return the number of thread-local variables that have been created so far.
	 * @return the size of the thread-local
	 */
	public int size() {
		return all.size();
	}
}
