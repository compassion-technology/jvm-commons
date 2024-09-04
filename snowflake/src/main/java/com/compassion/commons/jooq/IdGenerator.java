package com.compassion.commons.jooq;

import static org.jooq.impl.DSL.max;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.Supplier;

import org.jooq.DSLContext;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UpdatableRecord;

import lombok.val;

/**
 * Generates incrementing integer IDs in memory. This class is thread safe.
 * 
 * @author <a href="mailto:dimeo@datamininglab.com">John Dimeo</a>
 * @since Nov 23, 2016
 */
public class IdGenerator implements Supplier<Integer> {
	private AtomicInteger counter = new AtomicInteger();
	
	/**
	 * Sets the next ID to be greater than the maximum ID in the database. This should be called before the first
	 * call to {@link #next()}.
	 * @param ctx the database context
	 * @param table the database table
	 * @param id the primary key column with integer IDs
	 * @param <R> the record type
	 */
	public <R extends UpdatableRecord<R>> void init(DSLContext ctx, Table<R> table, TableField<R, Integer> id) {
		init(ctx, table, id, Function.identity());
	}
	
	/**
	 * Sets the next ID to be greater than the maximum ID in the database. This should be called before the first
	 * call to {@link #next()}.
	 * @param ctx the database context
	 * @param table the database table
	 * @param id the primary key column with IDs convertable to integers
	 * @param toInt the function to convert the IDs to integers
	 * @param <R> the record type
	 * @param <T> the ID type
	 */
	public <R extends UpdatableRecord<R>, T> void init(DSLContext ctx, Table<R> table, TableField<R, T> id, Function<T, Integer> toInt) {
		val maxId = ctx.select(max(id)).from(table).fetchAny(max(id)); 
		if (maxId != null) { counter.set(toInt.apply(maxId)); }
	}
	
	/**
	 * If an external process is allocating IDs, call this method to ensure future IDs allocated by this generator do
	 * not conflict. This should be called before the first call to {@link #next()}.
	 * @param id the new minimum ID past which IDs should be generated (defaults to {@code 0} so the first ID is {@code 1})
	 */
	public void ensureNextIsGreaterThan(int id) {
		counter.updateAndGet(nextId -> Math.max(nextId, id));
	}
	
	/**
	 * Get the next ID. 
	 * @return the next ID
	 */
	public int next() { return counter.incrementAndGet(); }
	
	@Override
	public Integer get() { return next(); }
	
	/**
	 * Look at what the next ID will be without incrementing it.
	 * @return the next ID
	 */
	public int peek() { return counter.get(); }
}
