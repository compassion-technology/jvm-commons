/* ©2016-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.commons.jdbc;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.h2.util.ScriptReader;

import com.compassion.commons.Utilities;

import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.log4j.Log4j2;
import picocli.CommandLine;
import picocli.CommandLine.ArgGroup;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

/**
 * This class runs a "raw" SQL file against a JDBC connection. The file can be executed
 * line-by-line or in JDBC batch mode, statements can be printed or suppressed, and errors can be
 * ignored or fatal.
 *
 * @author <a href="dimeo@datamininglab.com">John Dimeo</a>
 * @since Oct 16, 2013
 */
@Log4j2
@Accessors(chain = true)
public final class SQLRunner implements Runnable {
	private static final int SQL_PREVIEW_LEN = 30;

	@Parameters(description = "The SQL file or files to run")
	private List<String> files = new LinkedList<>();

	@Option(names = "-sql", description = "One or more SQL statements to execute (executed in order after any files)")
	private List<String> sqls = new LinkedList<>();

	@Option(names = {"-b", "-batch"}, description = "Runs in batch mode (all statements in a file are executed at once)")
	private boolean batch;

	@Option(names = {"-d", "-debug"}, description = "Runs in debug mode (each statment is logged to the console)")
	private boolean debug;

	@Option(names = {"-s", "-ignoreErrors"}, description = "Logs and ignores errors instead of terminating execution")
	private boolean ignoreErrors;

	@Option(names = "-drops", description = "Only execute statements that begin with 'DROP...'")
	private boolean dropsOnly;

	@Setter
	@ArgGroup
	private DatabaseConfig config = new DatabaseConfig();

	private Connection c;

	@Override
	public void run() {
		boolean closeConn = false;
		if (c == null) {
			try {
				c = config.connect();
				closeConn = true;
			} catch (SQLException e) {
				log.warn("Cannot connect to database {}", config, e);
				return;
			}
		}

		try (Statement stm = c.createStatement()) {
			for (String file : files) {
				log.info("Executing SQL file {}...", file);
				try (FileReader fr = new FileReader(file)) {
					readAndExecute(fr, stm);
				} catch (IOException e) {
					if (ignoreErrors) {
						log.warn("Skipping unreadable file {}", file, e);
					} else {
						throw new SQLException(e);
					}
				}
			}
			for (String sql : sqls) {
				log.info("Executing SQL script '{}'...", StringUtils.abbreviate(sql, SQL_PREVIEW_LEN));
				readAndExecute(new StringReader(sql), stm);
			}
		} catch (SQLException e) {
            log.warn("Could not execute SQL script", e);
		}

		if (closeConn) {
			try {
				c.close();
			} catch (SQLException e) {
				log.warn("Error closing connection", e);
			}
		}
	}

	private void readAndExecute(Reader r, Statement stm) throws SQLException {
		ScriptReader sr = new ScriptReader(r);
		sr.setSkipRemarks(true);

		int executed = 0;
		String line;
		while ((line = sr.readStatement()) != null) {
			line = line.trim();
			if (line.isEmpty()) {
				continue;
			}
			if (dropsOnly && !StringUtils.startsWithIgnoreCase(line, "drop")) {
				continue;
			}

			if (debug) {
				log.info(line);
			}
			try {
				if (batch) {
					stm.addBatch(line);
				} else {
					stm.execute(line);
				}
				executed++;
			} catch (SQLException ex) {
				if (ignoreErrors) {
					log.warn("Could not execute {}: {}", line, Utilities.getMessage(ex));
				} else {
					throw ex;
				}
			}
		}

		if (batch) {
			try {
				stm.executeBatch();
			} catch (SQLException ex) {
				if (ignoreErrors) {
					log.warn("Could not execute batch statement: {}", ex.getMessage());
				} else {
					throw ex;
				}
				executed = 0;
			}
		}
		log.info("Executed {} SQL statements", executed);
	}

	/**
	 * Adds a file to the list of SQL files to be executed.
	 * @param file the path to the file
	 * @return this for method chaining
	 */
	public SQLRunner addFile(String file) {
		files.add(file);
		return this;
	}

	/**
	 * Adds a block of SQL to the list of SQL scripts to be executed.
	 * @param sql the SQL statements
	 * @return this for method chaining
	 */
	public SQLRunner addSQL(String sql) {
		sqls.add(sql);
		return this;
	}

	/**
	 * Whether or not to execute all statements in each script at once.
	 * @param batch the batch mode for this runner
	 * @return this for method chaining
	 */
	public SQLRunner setBatch(boolean batch) {
		this.batch = batch;
		return this;
	}

	/**
	 * Whether or not to ignore and log errors, or terminate execution.
	 * @param ignoreErrors the error mode for this runner
	 * @return this for method chaining
	 */
	public SQLRunner setIgnoreErrors(boolean ignoreErrors) {
		this.ignoreErrors = ignoreErrors;
		return this;
	}

	/**
	 * Whether or not to log each statement before it is executed.
	 * @param debug the debug mode for this runner
	 * @return this for method chaining
	 */
	public SQLRunner setDebug(boolean debug) {
		this.debug = debug;
		return this;
	}

	/**
	 * Sets the connection to use to run each statement against. This connection
	 * will <b>not</b> be closed after the SQL script is finished.
	 * @param c the database connection
	 * @return this for method chaining
	 */
	public SQLRunner setConnection(Connection c) {
		this.c = c;
		return this;
	}

	@Override
	public String toString() {
		return String.join(System.lineSeparator(), sqls);
	}

	/**
	 * Runs a SQL file from the command line.
	 * @param args the runtime args
	 */
	public static void main(String[] args) {
		System.exit(new CommandLine(new SQLRunner()).execute(args));
	}
}
