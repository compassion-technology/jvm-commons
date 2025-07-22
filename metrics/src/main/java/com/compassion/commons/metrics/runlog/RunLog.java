package com.compassion.commons.metrics.runlog;

import static com.compassion.commons.metrics.runlog.sql.tables._CiRunLog._CI_RUN_LOG;

import java.time.OffsetDateTime;
import java.util.function.Consumer;

import org.jooq.impl.DSL;

import com.compassion.commons.jdbc.JDBCUtils;
import com.compassion.commons.metrics.runlog.sql.tables.daos._CiRunLogDao;
import com.compassion.commons.metrics.runlog.sql.tables.interfaces.I_CiRunLog;
import com.compassion.commons.metrics.runlog.sql.tables.pojos._CiRunLog;
import com.google.common.collect.Comparators;

public class RunLog {
	private final _CiRunLogDao dao;
	private _CiRunLog stats = new _CiRunLog();
	
	public RunLog(String database, String schema, _CiRunLogDao dao) {
		this.dao = dao;
		
		JDBCUtils.executeBlock(dao.ctx(), dao.ctx()
			.createTableIfNotExists(DSL.name(database, schema, _CI_RUN_LOG.getName()))
			.columns(_CI_RUN_LOG.fields()), $ -> $
			.replace("timestamp(6) with time zone", "timestamp_tz")
			.replace("ID int", "ID int AUTOINCREMENT INCREMENT 1"));
	}
	
	public void set(Consumer<I_CiRunLog> callback) {
		callback.accept(stats);
	}
	
	public void runStart(String phase) {
		stats.setRecordsRead(0);
		stats.setRecordsWritten(0);
		stats.setPhase(phase);
		stats.setTimestampStart(OffsetDateTime.now());
		stats.setTimestampMaxRead(null);
		stats.setTimestampMaxWritten(null);
		stats.setTimestampEnd(null);
	}
	
	public void recordRead(OffsetDateTime modifiedTS) {
		stats.setRecordsRead(stats.getRecordsRead() + 1);
		stats.setTimestampMaxRead(stats.getTimestampMaxRead() == null? modifiedTS : Comparators.max(modifiedTS, stats.getTimestampMaxRead()));
	}
	
	public void recordWritten(OffsetDateTime modifiedTS) {
		stats.setRecordsWritten(stats.getRecordsWritten() + 1);
		stats.setTimestampMaxWritten(stats.getTimestampMaxWritten() == null? modifiedTS : Comparators.max(modifiedTS, stats.getTimestampMaxWritten()));
	}
	
	public void runFinished() {
		stats.setTimestampEnd(OffsetDateTime.now());
		dao.insert(stats);
	}
	
	public void startPhase(String phase) {
		runFinished();
		stats = stats.into(new _CiRunLog());
		runStart(phase);
	}
}
