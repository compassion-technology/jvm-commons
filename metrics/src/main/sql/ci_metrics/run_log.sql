CREATE SCHEMA IF NOT EXISTS run_log;
/*[jooq ignore start]*/ USE SCHEMA run_log; /*[jooq ignore stop]*/

CREATE TABLE
	run_log._CI_RUN_LOG (
		ID INTEGER /*[jooq ignore start]*/ AUTOINCREMENT INCREMENT 1 /*[jooq ignore stop]*/ NOT NULL PRIMARY KEY COMMENT $$Unique identifier for the job$$,
		NAME VARCHAR(1000) COMMENT $$The name of the job$$,
		PHASE VARCHAR(100) COMMENT $$If the job runs for multiple phases, the current phase or stage of the job.$$,
		SOURCE VARCHAR(1000) COMMENT $$The location from which data was read.$$,
		TARGET VARCHAR(1000) COMMENT $$The location to which data was written.$$,
		RECORDS_READ INTEGER COMMENT $$The total number of records that were read from the source, like rows of data, number of events, or number of API calls.$$,
		RECORDS_WRITTEN INTEGER COMMENT $$The total number of records written to the target, like rows of data, number of events, or number of API calls.$$,
		TIMESTAMP_START TIMESTAMP WITH TIME ZONE COMMENT $$The timestamp that the job began executing.$$,
		TIMESTAMP_END TIMESTAMP WITH TIME ZONE COMMENT $$The timestamp that the job stopped executing.$$,
		TIMESTAMP_MAX_READ TIMESTAMP WITH TIME ZONE COMMENT $$For each records that was read from the source, the most recent timestamp represented by each record, like a last modified timestamp. This is helpful for calculating data "freshness" read from the source.$$,
		TIMESTAMP_MAX_WRITTEN TIMESTAMP WITH TIME ZONE COMMENT $$For each records that was written to the target, the most recent timestamp represented by each record, like a last modified timestamp. This is helpful for calculating data "freshness" written to the target.$$);
