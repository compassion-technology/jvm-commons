/*******************************************************************************
 * Copyright (c) 2017 Elder Research, Inc.
 * All rights reserved.
 *******************************************************************************/
package com.elderresearch.commons.lang.iter;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.Iterator;

import com.elderresearch.commons.lang.LambdaUtils.IORunnable;

/**
 * Wraps an iterator but calls a callback after no more data is available (auto closing). This iterator can also be
 * closed manually before all data has been iterated over. You should generally use this in a try-with-resource
 * block so you ensure you close the iterator even if not every element is iterated over.
 * 
 * @author <a href="mailto:dimeo@datamininglab.com">John Dimeo</a>
 * @param <T> the type of data being iterated over
 * @since Jan 5, 2017
 */
public class IteratorCloseable<T> implements IteratorWithSize<T>, AutoCloseable {
	private Iterator<T> iter;
	private IORunnable closer;
	private long size;
	
	/**
	 * Creates a new closeable iterator. 
	 * @param iter the wrapped iterator
	 * @param closer the close callback. If this is <tt>null</tt>, you must subclass this class and override {@link #close()}.
	 */
	public IteratorCloseable(Iterator<T> iter, IORunnable closer) {
		this.iter = iter;
		this.closer = closer;
	}
	
	/**
	 * Sets a size to give a hint to callers about how many elements may be returned by the iterator (or bytes, rows, etc.).
	 * @param size the size of objects that will be returned by this iterator
	 * @return this for method chaining
	 */
	public IteratorCloseable<T> setSize(long size) {
		this.size = size;
		return this;
	}
	
	@Override
	public long size() { return size; }
	
	@Override
	public boolean hasNext() {
		if (iter.hasNext()) { return true; }
		
		// Auto close once the iterator doesn't have any more data to return
		try {
			close();
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
		return false;
	}
	
	@Override
	public T next() {
		return iter.next();
	}
	
	@Override
	public void remove() {
		iter.remove();
	}
	
	@Override
	public void close() throws IOException {
		closer.run();
	}
}
