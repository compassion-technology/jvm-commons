package com.compassion.commons.jooq;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Predicate;

import org.apache.commons.lang3.function.Consumers;
import org.jooq.DAO;
import org.jooq.lambda.Seq;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Accessors(fluent = true)
@RequiredArgsConstructor
public class DaoBatcher<P, D extends DAO<?, P, ?>> {
	@Getter
	private final D dao;
	private final int maxBatchSize;
	private final long maxBatchTime;
	
	private final List<P> insert = new LinkedList<>(),
	                      update = new LinkedList<>(),
                          delete = new LinkedList<>();
	
	@Setter
	private Predicate<List<P>> flushPre = $ -> true;
	@Setter
	private Consumer<List<P>> flushPost = Consumers.nop();
	
	private long lastTransactionTime = System.currentTimeMillis();
	
	public DaoBatcher(D dao, SnowflakeConfig config) {
		this(dao, config.getMaxBatchSize(), TimeUnit.SECONDS.toMillis(config.getMaxBatchTime()));
	}
	
	public DaoBatcher<P, D> truncate() {
		dao.configuration().dsl().truncate(dao.getTable()).execute();
		return this;
	}
	
	public Seq<P> pending() {
		return Seq.concat(insert, update, delete);
	}
	
	public void insert(P obj) { add(insert, obj); }
	public void update(P obj) { add(update, obj); }
	public void delete(P obj) { add(delete, obj); }
	
	private void add(List<P> batch, P obj) {
		batch.add(obj);
		flush(false);
	}
	
	public void flush(boolean force) {
		if (force) {
			flush(0, 0L);
		} else {
			flush(maxBatchSize, lastTransactionTime + maxBatchTime);
		}
	}
	
	private void flush(int maxSize, long nextTime) {
		flush(insert, maxSize, nextTime, dao::insert, "Inserting");
		flush(update, maxSize, nextTime, dao::update, "Updating");
		flush(delete, maxSize, nextTime, dao::delete, "Deleting");
	}
	
	private void flush(List<P> batch, int maxSize, long nextTime, Consumer<Collection<P>> action, String name) {
		if (!batch.isEmpty() && (batch.size() >= maxSize || System.currentTimeMillis() > nextTime)) {
			log.debug("{} {} values in the database...", name, batch.size());
			if (flushPre.test(batch)) {
				action.accept(batch);
				flushPost.accept(batch);
			}
			batch.clear();
			lastTransactionTime = System.currentTimeMillis();
		}
	}
}
