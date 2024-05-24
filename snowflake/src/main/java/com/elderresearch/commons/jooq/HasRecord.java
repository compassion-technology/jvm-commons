/* ©2016-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.commons.jooq;

import org.jooq.UpdatableRecord;

/**
 * Interface to indicate a given class has a corresponding {@link UpdatableRecord}. Usually bean classes that implement
 * business logic will implement this interface so that callers can easily persist those beans by transforming them to
 * updateable records to pass to {@link JOOQBatchStore} or other jOOQ APIs.
 * 
 * @author <a href="mailto:dimeo@datamininglab.com">John Dimeo</a>
 * @param <R> the record type
 * @since Oct 24, 2016
 */
public interface HasRecord<R extends UpdatableRecord<R>> {
	/**
	 * Gets the corresponding record for this instance. In general, this should return the same instance for repeated
	 * calls to take advantage of jOOQ's dirty checking (automatically determining if the record should be inserted or
	 * updated) but a new record instance can be returned each time if that matches your use case.
	 * @return a record corresponding to this instance
	 */
	R getRecord();
}
