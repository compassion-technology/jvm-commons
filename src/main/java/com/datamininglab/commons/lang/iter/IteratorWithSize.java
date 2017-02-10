/*******************************************************************************
 * Copyright (c) 2017 Elder Research, Inc.
 * All rights reserved.
 *******************************************************************************/
package com.datamininglab.commons.lang.iter;

import java.util.Iterator;

/**
 * A size-aware iterator implementation. This is useful when you want streaming behavior (unlike an in-memory list) but
 * also know a priori how many elements will be returned, like returning rows from a database query.
 * 
 * @author <a href="mailto:dimeo@datamininglab.com">John Dimeo</a>
 * @param <T> the type of elements returned by this iterator
 * @since Feb 8, 2017
 */
public interface IteratorWithSize<T> extends Iterator<T> {
	/**
	 * Gets the number (which may be approximate) of items that will be returned by this iterator.
	 * @return the iterator's size
	 */
	long size();
}
