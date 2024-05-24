/* ©2016-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.commons.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import lombok.Getter;
import lombok.val;
import lombok.experimental.UtilityClass;
import lombok.extern.log4j.Log4j2;

/**
 * Provides a set of utilities for interacting with SQL database tables.
 *
 * @author <a href="dimeo@datamininglab.com">John Dimeo</a>
 * @since July 23, 2013
 */
@Log4j2
@UtilityClass
public final class JDBCTableUtils {
	private static final String COL_ORDINAL     = "ORDINAL_POSITION",
	                            COL_NAME        = "COLUMN_NAME",
	                            COL_TYPE        = "DATA_TYPE",
	                            COL_COMMENT     = "REMARKS",
	                            COL_SYN_NAME    = "SYNONYM_NAME",
	                            COL_SYN_OWNER   = "OWNER",
	                            COL_TABLE_OWNER = "TABLE_OWNER",
	                            COL_TABLE_NAME  = "TABLE_NAME",
	                            COL_TABLE_CAT   = "TABLE_CAT",
	                            COL_TABLE_SCHEM = "TABLE_SCHEM",
	                            COL_TABLE_TYPE  = "TABLE_TYPE";

	/**
	 * Deletes all the data from a table in and resets the identity seed (if it exists).
	 * If truncation fails, this will execute a delete query.
	 * @param c the connection to use
	 * @param table the table to delete
	 * @param optional if the table might not exist (does not log the exception)
	 * @return if the table was successfully truncated
	 */
	public boolean truncate(Connection c, String table, boolean optional) {
		try (val stm = c.createStatement()) {
			try {
				stm.execute("TRUNCATE TABLE " + table);
				return true;
			} catch (SQLException ex) {
				stm.execute("DELETE FROM " + table);
				return true;
			}
		} catch (SQLException ex) {
			if (!optional) {
				log.warn("Warning: could not truncate table {}", table, ex);
			}
			return false;
		}
	}

	/**
	 * Drops the table if it exists.
	 * @param c the connection to use
	 * @param table the table to drop
	 * @return if the table existed and was successfully dropped
	 */
	public static boolean drop(Connection c, String table) {
		try (val stm = c.createStatement()) {
			stm.execute("DROP TABLE " + table);
			return true;
		} catch (SQLException ex) {
			return false;
		}
	}

	/**
	 * Counts the number of rows in the table (using a {@code SELECT COUNT(*) ...} query).
	 * @param c the connection to use
	 * @param table the table to count (including user/schema)
	 * @param optional if the table might not exist (does not log the exception)
	 * @return the number of rows in the table, or {@code -1} if there was an error
	 */
	public static long getRowCount(Connection c, String table, boolean optional) {
		try (val rs = c.prepareStatement("SELECT COUNT(*) FROM " + table).executeQuery()) {
			if (rs.next()) { return rs.getLong(1); }
		} catch (SQLException ex) {
			if (!optional) {
				log.warn("Could not execute SQL query to count rows for table {}", table, ex);
			}
		}
		return -1L;
	}

	/**
	 * Counts the number of columns in the table.
	 * @param c the connection to use
	 * @param table the table name
	 * @return the number of columns, or {@code -1} if there was an error
	 */
	public static int getColumnCount(Connection c, String table) {
		val l = getColumns(c, null, null, table, false);
		return l == null? -1 : l.size();
	}

	/**
	 * Gets all the columns for the given table, using the current catalog and
	 * schema and including comments/remarks.
	 * @param c the connection to use
	 * @param table the table name
	 * @return a list of column metadata, or {@code null} if there was some
	 * error retrieving the columns
	 * @see #getColumns(Connection, String, String, String, boolean)
	 */
	public static List<TableColumn> getColumns(Connection c, String table) {
		return getColumns(c, null, null, table, true);
	}

	/**
	 * Gets all the columns for the given catalog/schema/table.
	 * @param c the connection to use
	 * @param catalog the catalog (can be {@code null} to use the current catalog)
	 * @param schema the user/schema (can be {@code null} to use the current schema)
	 * @param table the table name
	 * @param includeComments whether or not to include comments/remarks. This
	 * can be slow, and is not supported in some JDBC implementations
	 * @return a list of column metadata, or {@code null} if there was some
	 * error retrieving the columns
	 */
	public static List<TableColumn> getColumns(Connection c, String catalog, String schema, String table, boolean includeComments) {
		if (catalog == null) { catalog = JDBCUtils.getCatalog(c); }
		if (schema  == null) { schema  = JDBCUtils.getSchema(c);  }
		handleRemarks(c, includeComments);

		// Resolve any synonyms. The JDBC driver does not support column metadata for
		// synonyms natively
//		if (JDBCDriver.ORACLE.hasDriver() && c instanceof oracle.jdbc.OracleConnection) {
//			TableSynonym syn = Utilities.first(getSynonyms(c, table));
//			if (syn != null) {
//				schema = syn.getTableOwner();
//				table  = syn.getTableName();
//			}
//		}

		List<TableColumn> ret = new ArrayList<>();
		try (val rs = c.getMetaData().getColumns(catalog, schema, table, null)) {
			while (rs.next()) {
				TableColumn tc = new TableColumn();
				tc.oridinal = rs.getInt(COL_ORDINAL);
				tc.type     = rs.getInt(COL_TYPE);
				tc.name     = rs.getString(COL_NAME);
				tc.comments = rs.getString(COL_COMMENT);
				ret.add(tc);
			}
			Collections.sort(ret, TC_ORDINAL_COMP);
			return ret;
		} catch (SQLException e) {
			log.warn("Error retrieving columns for table {}", table, e);
			return null;
		}
	}

	/**
	 * Gets all the synonyms with the specified name, or all synonyms defined in
	 * the database if {@code name} is {@code null}. Currently only Oracle
	 * synonyms are supported.
	 * @param c the connection to use
	 * @param name the name of the public synonym
	 * @return a list of synonym metadata, or {@code null} if there was some
	 * problem retrieving the synonyms
	 */
	public static List<TableSynonym> getSynonyms(Connection c, String name) {
		val sb = new StringBuilder();
		sb.append("SELECT ").append(COL_SYN_OWNER).append(",").append(COL_SYN_NAME).append(",")
		                    .append(COL_TABLE_OWNER).append(",").append(COL_TABLE_NAME)
		                    .append(" FROM ALL_SYNONYMS");
		if (name != null) {
			sb.append(" WHERE ").append(COL_SYN_NAME).append(" = ?");
		}

		List<TableSynonym> ret = new ArrayList<>();
		try (PreparedStatement ps = c.prepareStatement(sb.toString())) {
			if (name != null) { ps.setString(1, name); }
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					TableSynonym ts = new TableSynonym();
					ts.owner      = rs.getString(COL_SYN_OWNER);
					ts.name       = rs.getString(COL_SYN_NAME);
					ts.tableOwner = rs.getString(COL_TABLE_OWNER);
					ts.tableName  = rs.getString(COL_TABLE_NAME);
					ret.add(ts);
				}
			}
			return ret;
		} catch (SQLException e) {
			log.warn("Error retrieving synonyms with name {}", name, e);
			return null;
		}
	}

	public static List<Table> getTables(Connection c, String catalog, String schema, boolean includeComments) {
		if (catalog == null) { catalog = JDBCUtils.getCatalog(c); }
		if (schema  == null) { schema  = JDBCUtils.getSchema(c);  }
		handleRemarks(c, includeComments);

		List<Table> ret = new ArrayList<>();
		try (val rs = c.getMetaData().getTables(catalog, schema, "%", null)) {
			while (rs.next()) {
				Table t = new Table();
				t.catalog  = rs.getString(COL_TABLE_CAT);
				t.schema   = rs.getString(COL_TABLE_SCHEM);
				t.name     = rs.getString(COL_TABLE_NAME);
				t.type     = rs.getString(COL_TABLE_TYPE);
				t.comments = rs.getString(COL_COMMENT);
				ret.add(t);
			}
		} catch (SQLException e) {
			log.warn("Error retrieving tables for catalog {}, schema {}", catalog, schema, e);
		}
		return ret;
	}

	private static void handleRemarks(Connection c, boolean includeRemarks) {
//		if (JDBCDriver.ORACLE.hasDriver() && c instanceof oracle.jdbc.OracleConnection) {
//			val oc = (oracle.jdbc.OracleConnection) c;
//			oc.setRemarksReporting(includeRemarks);
//		}
//		if (JDBCDriver.MYSQL.hasDriver() && c instanceof com.mysql.jdbc.MySQLConnection) {
//			val mc = (com.mysql.jdbc.MySQLConnection) c;
//			mc.setUseInformationSchema(includeRemarks);
//		}
//		if (JDBCDriver.MS_SQL_SERVER.hasDriver() && (c instanceof com.microsoft.sqlserver.jdbc.SQLServerConnection) && includeRemarks) {
//			log.warn("Warning: comments/remarks requested from a SQL Server connection; "
//				+ "SQL Server JDBC always returns null (http://msdn.microsoft.com/en-us/library/ms379048.aspx)");
//		}
	}

	@Getter
	public static class Table {
		/** The table's catalog (may be {@code null}). */
		private String catalog;
		/** The table's owner schema (may be {@code null}). */
		private String schema;
		/** The table's name. */
		private String name;
		/** The table's type, like {@code TABLE}, {@code VIEW}, {@code SYSTEM TABLE}, or {@code GLOBAL TEMPORARY}. */
		private String type;
		/** The comments associated with this table (may be {@code null} if this table does not have comments or
		 *  comments were not requested). */
		private String comments;

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			if (catalog != null) { sb.append(catalog); }
			if (schema != null) {
				if (sb.length() > 0) { sb.append("."); }
				sb.append(schema);
			}
			if (sb.length() > 0) { sb.append("."); }
			return sb.append(name).toString();
		}
	}

	@Getter
	public static class TableSynonym {
		/** The synonym's owner. */
		private String owner;
		/** The name of the synonym. */
		private String name;
		/** The owner of the resolved table the synonym points to. */
		private String tableOwner;
		/** The resolved name of the table the synonym points to. */
		private String tableName;
	}

	@Getter
	public static class TableColumn {
		/** Gets the position of the column in the table (1-based). */
		private int oridinal;
		/** The type of the column (one of the Java SQL {@link Types}). */
		private int type;
		/** The name of the column. */
		private String name;
		/** The comments associated with this column (may be {@code null} if this column does not have comments or
		 *  comments were not requested). */
		private String comments;
	}

	private static final Comparator<TableColumn> TC_ORDINAL_COMP = (c1, c2) -> Integer.compare(c1.oridinal, c2.oridinal);
}
