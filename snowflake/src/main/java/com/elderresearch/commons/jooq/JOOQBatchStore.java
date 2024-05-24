/* ©2016-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.commons.jooq;

import java.io.Closeable;
import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.function.Predicate;

import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.UpdatableRecord;
import org.jooq.exception.DataAccessException;

import com.elderresearch.commons.jdbc.JDBCUtils;

import lombok.val;
import lombok.extern.log4j.Log4j2;

/**
 * <p>Wrapper around {@link DSLContext#batchStore(UpdatableRecord...)}. This class adds thread safety and intelligent
 * error handling. You are not required to call {@link #close()}, which is why this class is not auto-closeable 
 * (depending on how the context passed to the constructor is being used).</p>
 * <p>Please note that by default jOOQ uses the entire record state for hashing and equality, which can lead to 
 * inconsistent behavior if the state of a record changes after it has been added to this batch. You are encouraged to
 * override {@link #hashCode()} for records added to this store to just use the primary key values (whose values should
 * not change once initialized).</p>
 * 
 * @author <a href="mailto:dimeo@elderresearch.com">John Dimeo</a>
 * @since Oct 24, 2016
 */
@Log4j2
public class JOOQBatchStore implements Closeable {
	private Object batchLock = new Object(), commitLock = new Object();
	
	private DSLContext ctx;
	private Set<UpdatableRecord<?>> batch;
	private int batchSize;
	private boolean retryEachRecordOnError;
	
	private Field<?>[] resetFields;

	/**
	 * Creates a new batch store using the context for the database connection using the default batch size
	 * {@link JDBCUtils#BATCH_SIZE}.
	 * @param ctx the database connection provider
	 */
	public JOOQBatchStore(DSLContext ctx) {
		this(ctx, JDBCUtils.BATCH_SIZE);
	}
	
	/**
	 * Creates a new batch store using the context for the database connection.
	 * @param ctx the database connection provider
	 * @param batchSize the batch size to use (the number of instances to buffer in memory before calling {@link #commit()})
	 */
	public JOOQBatchStore(DSLContext ctx, int batchSize) {
		this.ctx = ctx;
		this.batchSize = batchSize;
		setResetFields();
		copyBatch();
	}
	
	/**
	 * If an error is encountered while committing a batch of records, if this is {@code true}, each individual record
	 * will be stored again to help isolate the problem. Note that this might mean primary key violation errors or
	 * duplicate rows if records were in fact saved in the first batched store attempt, so it is {@code false} by default.
	 * @param retryEachRecordOnError whether or not to try to save each record invidually if there was an error during
	 * the batch store
	 * @return this for method chaining
	 */
	public JOOQBatchStore setRetryEachRecordOnError(boolean retryEachRecordOnError) {
		this.retryEachRecordOnError = retryEachRecordOnError;
		return this;
	}
	
	/**
	 * Sets the fields that will be reset prior to saving. Usually this is used with synthetic IDs to ensure that the
	 * database assigns the next ID during insert.
	 * @param resetFields the fields to reset prior to saving
	 * @return this for method chaining
	 */
	public JOOQBatchStore setResetFields(Field<?>... resetFields) {
		this.resetFields = resetFields;
		return this;
	}
	
	/**
	 * Gets the context passed to the constructor for ad-hoc queries.
	 * @return the context
	 */
	public DSLContext getContext() { return ctx; }
	
	/**
	 * Add the record to the batch of records to store. If the batch is equal to the batch size, all records will be
	 * stored in the underlying database. This can be safely called from multiple threads.
	 * @param record the record to store
	 * @return if the record was accepted, or {@code false} if the same record was already added to this batch. Note 
	 * that this will return {@code true} if the same record is stored before and after a {@link #commit()}.
	 * @see DSLContext#batchStore(UpdatableRecord...)
	 */
	public boolean store(UpdatableRecord<?> record) {
		for (val f : resetFields) {
			try {
				record.reset(f);
			} catch (IllegalArgumentException e) {
				// This record does not have the field
			}
		}
		
		Set<UpdatableRecord<?>> copy;
		synchronized (batchLock) {
			if (!batch.add(record)) { return false; }
			if (batch.size() < batchSize) { return true; }
			
			copy = copyBatch();
		}
		// Copy batch so we don't block other calls to store() from other threads while we commit
		commit(copy);
		return true;
	}
	
	/**
	 * Finds the record in the current batch based on some predicate. This is provided so that pending records can be
	 * accessed to test whether a record has actually been written to the database or not.
	 * @param predicate the predicate to test records
	 * @return the matching record, or {@code null} if there are no pending records or no records matched the predicate
	 */
	public UpdatableRecord<?> find(Predicate<UpdatableRecord<?>> predicate) {
		synchronized (batchLock) {
			for (UpdatableRecord<?> r : batch) {
				if (predicate.test(r)) { return r; }
			}
		}
		return null;
	}
	
	/**
	 * Manually flush any pending records in the batch of records to store.
	 */
	public void commit() {
		Set<UpdatableRecord<?>> copy;
		synchronized (batchLock) {
			if (batch.isEmpty()) { return; }
			copy = copyBatch();
		}
		commit(copy);
	}
	
	private Set<UpdatableRecord<?>> copyBatch() {
		// LinkedHashSet because it maintains order since callers will store things in correct order if needed (e.g. 
		// save the reference of a foreign key before saving the object that references it), but also avoid saving the
		// same object twice in the same batch (confuses jOOQ about update vs. insert)
		try {
			return batch;
		} finally {
			batch = new LinkedHashSet<>(batchSize);
		}
	}
	
	private void commit(Set<UpdatableRecord<?>> list) {
		synchronized (commitLock) {
			try {
				ctx.connection(this::preBatch);
				ctx.batchStore(list).execute();
				ctx.connection(this::postBatch);
			} catch (DataAccessException e) {
				Throwable batchEx = e;
				if (e.getCause() instanceof BatchUpdateException) {
					// BatchUpdateExceptions never have very useful info in their message so get underlying error
					batchEx = ((BatchUpdateException) e.getCause()).getNextException();
					if (batchEx == null) { batchEx = e.getCause(); }
				}
				
				if (!retryEachRecordOnError) {
					log.warn("Error storing batch of {} records", list.size(), batchEx);
					return;
				}
				
				// If there's an error, single insert each item so we only skip the one that failed
				log.warn("Error storing batch of {} records, attemping non-batched store...", list.size(), batchEx);
				int errors = 0;
				for (UpdatableRecord<?> r : list) {
					try {
						r.attach(ctx.configuration());
						r.store();
					} catch (DataAccessException recEx) {
						// Only print the error from the first failure to avoid spamming logs
						if (errors++ == 0) { log.warn("Error storing record {}", r, recEx); }
					}
				}
				if (--errors > 0) { log.warn("Additionally, {} other records failed to store after error", errors); }
			}
		}
	}
	
	protected void preBatch(Connection c) {
		// No-op by default
	}
	
	protected void postBatch(Connection c) {
		// No-op by default
	}
	
	@Override
	public void close() {
		commit();
	}
}
