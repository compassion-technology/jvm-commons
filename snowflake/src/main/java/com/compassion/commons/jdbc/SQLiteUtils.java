package com.compassion.commons.jdbc;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.h2.util.IOUtils;

import lombok.experimental.UtilityClass;
import lombok.extern.log4j.Log4j2;

/**
 * A collection of utilities for interacting with SQLite database files.
 * 
 * @author <a href="dimeo@datamininglab.com">John Dimeo</a>
 * @since Jun 10, 2013
 */	
@Log4j2
@UtilityClass
public final class SQLiteUtils {
	/**
	 * Copies the schema file (in the {@code "schema"} folder in this class'
	 * resources folder) to the destination file.
	 * @param c the class to use to find the schema resource file
	 * @param schema the schema file name
	 * @param file the destination file
	 */
	public static void copyDB(Class<?> c, String schema, File file) {
		try (
			InputStream is = c.getResourceAsStream(schema);
			OutputStream os = new FileOutputStream(file)
		) {
			IOUtils.copy(is, os);
		} catch (IOException e) {
			log.warn("Could not copy schema file " + schema + " to output file " + file, e);
		}
	}
	
	/**
	 * Connect to the SQLite file via JDBC.
	 * @param file the file name
	 * @param beginTransaction whether or not to begin a new transaction after
	 * the connection is opened
	 * @return a connection, or {@code null} if there was a problem establishing
	 * the connection
	 */
	public static Connection connect(File file, boolean beginTransaction) {
		new org.sqlite.JDBC();
		Connection ret = null;
	    try {
			ret = DriverManager.getConnection("jdbc:sqlite:" + file.getPath().replace('\\', '/'));
			execute(ret, "PRAGMA journal_mode=MEMORY", "PRAGMA synchronous=OFF");
			if (beginTransaction) {
				// SQLite implementation of auto commit begins a transaction
				ret.setAutoCommit(false);
			}
		} catch (SQLException e) {
			log.warn("Error connecting to SQLite file {}", file, e);
		}
	    return ret;
	}
	
	/**
	 * Commit the current transaction and close the connection.
	 * @param con the connection
	 * @param commitTransaction whether or not to commit the current transaction
	 * before closing
	 * @throws SQLException if there was a problem committing or closing the connection
	 */
	public static void disconnect(Connection con, boolean commitTransaction) throws SQLException {
		if (commitTransaction) { execute(con, "COMMIT TRANSACTION"); }
		con.close();
	}
	
	/**
	 * Execute the series of SQL statements against the connection. These should
	 * not be <a href="http://en.wikipedia.org/wiki/Create,_read,_update_and_delete">CRUD</a> statements.
	 * @param con the connection
	 * @param statements one or more statements to execute
	 * @throws SQLException if there was a problem executing the statements
	 */
	public static void execute(Connection con, String... statements) throws SQLException {
		try (Statement s = con.createStatement()) {
			for (String sql : statements) { s.execute(sql); }
		}
	}
}
