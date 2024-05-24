/* ©2016-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.commons.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.sql.Wrapper;
import java.util.function.Consumer;

import org.apache.commons.lang3.StringUtils;

import com.compassion.commons.LambdaUtils;
import com.compassion.commons.Utilities;

import lombok.val;
import lombok.experimental.UtilityClass;
import lombok.extern.log4j.Log4j2;
import net.snowflake.client.jdbc.SnowflakeConnectionV1;

/**
 * Provides a set of utilities for interacting with an SQL database.
 *
 * @author <a href="dimeo@datamininglab.com">John Dimeo</a>
 * @since Jun 14, 2012
 */
@Log4j2
@UtilityClass
public final class JDBCUtils {
	/** A good default size for JDBC batching. */
	public static final int BATCH_SIZE = 768;

	@FunctionalInterface
	public interface SQLConsumer {
		void accept() throws SQLException;
	}

	@FunctionalInterface
	public interface SQLSupplier<T> {
		T get() throws SQLException;
	}

	@FunctionalInterface
	public interface SQLFunction<I, O> {
		O apply(I in) throws SQLException;
	}

	/**
	 * Provide a functional way of handling {@link SQLException} instead of a try-catch block.
	 * @param op some functionality that throws a {@link SQLException} (most methods in the JDBC APIs)
	 * @param in the input to the function
	 * @param handler the consumer to invoke if a {@link SQLException} is encountered
	 * @param <I> the input type
	 * @param <O> the output type
	 * @return if the operation completed successfully ({@code true}) or if an exception was thrown ({@code false})
	 */
	public <I, O> O handleException(I in, SQLFunction<I, O> op, Consumer<SQLException> handler) {
		try {
			return op.apply(in);
		} catch (SQLException e) {
			handler.accept(e);
			return null;
		}
	}

	/**
	 * Provide a functional way of handling {@link SQLException} instead of a try-catch block.
	 * @param op some functionality that throws a {@link SQLException} (most methods in the JDBC APIs)
	 * @param handler the consumer to invoke if a {@link SQLException} is encountered
	 * @param <T> the supplier type
	 * @return the result of the call to the supplier, or {@code null} if an exception was thrown
	 */
	public <T> T handleException(SQLSupplier<T> op, Consumer<SQLException> handler) {
		try {
			return op.get();
		} catch (SQLException e) {
			handler.accept(e);
			return null;
		}
	}

	/**
	 * Provide a functional way of handling {@link SQLException} instead of a try-catch block.
	 * @param op some functionality that throws a {@link SQLException} (most methods in the JDBC APIs)
	 * @param handler the consumer to invoke if a {@link SQLException} is encountered
	 * @return if the operation completed successfully ({@code true}) or if an exception was thrown ({@code false})
	 */
	public boolean handleException(SQLConsumer op, Consumer<SQLException> handler) {
		try {
			op.accept();
			return true;
		} catch (SQLException e) {
			handler.accept(e);
			return false;
		}
	}

	/**
	 * Gets the current catalog of the connection. This method consumes any
	 * SQL exceptions and returns {@code null} if the current connection cannot
	 * be derived.
	 * @param c the connection
	 * @return the connection's catalog
	 */
	public String getCatalog(Connection c) {
		try {
			return StringUtils.defaultIfBlank(c.getCatalog(), null);
		} catch (SQLException | AbstractMethodError e) {
			// Oracle throws AbstractMethodErrors for these JDBC methods
			return null;
		}
	}

	/**
	 * Gets the current schema of the connection. If getting the current schema
	 * fails and the connection is an Oracle connection, the current connection's user name is
	 * used instead. If that also fails, {@code null} is returned. This method consumes any
	 * SQL exceptions.
	 * @param c the connection
	 * @return the connection's current schema or user
	 */
	public String getSchema(Connection c) {
		String ret = null;
		try {
			ret = StringUtils.defaultIfBlank(c.getSchema(), null);
		} catch (SQLException | AbstractMethodError e) {
			// Try getting user instead below
		}
//		if (ret == null && isVendorSpecific(c, oracle.jdbc.OracleConnection.class)) {
//			try {
//				ret = c.getMetaData().getUserName();
//			} catch (SQLException e) {
//				// Some other problem accessing the schema
//			}
//		}
		return ret;
	}

	/**
	 * Gets an object from the SQL result set, using the enum's ordinal as the column index.
	 * The ordinal is incremented by {@code 1} since the result set's column indexing is 1-based.
	 * @param rs the result set
	 * @param e the enum that corresponds to a column
	 * @return the object for that column
	 * @throws SQLException if there was a problem getting the object from the result set
	 */
	public Object getObject(ResultSet rs, Enum<?> e) throws SQLException {
		return rs.getObject(e.ordinal() + 1);
	}

	/**
	 * Truncates the string to the specified length if it is too long.
	 * @param field the corresponding field; if this is not {@code null} a warning message will
	 * be printed to the console if truncation happens
	 * @param s the string to truncate
	 * @param len the maximum length of characters for {@code s}
	 * @return the truncated string
	 */
	public String truncate(String field, String s, int len) {
		if (StringUtils.length(s) > len) {
			LambdaUtils.accept(field, $ -> log.warn("Truncating {} {} to {} chars", $, s, len));
			return s.substring(0, len);
		}
		return s;
	}

	/**
	 * Attempts to optimize an Oracle table by calling a system stored procedure to manually compute
	 * statistics about the table. For more information, see
	 * <a href="http://www.dba-oracle.com/concepts/tables_optimizer_statistics.htm">
	 * http://www.dba-oracle.com/concepts/tables_optimizer_statistics.htm</a>.
	 * @param c the JDBC database connection
	 * @param user the name of the Oracle user
	 * @param table the name of the table to optimize
	 * @throws SQLException if there was a problem executing the stored procedure
	 * @see #optimizeSchema(Connection, String)
	 */
	public void optimizeTable(Connection c, String user, String table) throws SQLException {
		try (val cs = c.prepareCall("BEGIN DBMS_STATS.GATHER_TABLE_STATS(OWNNAME => ?, TABNAME => ?, CASCADE => TRUE); END;")) {
			cs.setString(1, user);
			cs.setString(2, table);
			cs.execute();
		}
	}

	/**
	 * Attempts to optimize an Oracle schema/user by calling a system stored procedure to
	 * compute statistics about all tables in that schema. For more information, see
	 * <a href="http://www.dba-oracle.com/concepts/tables_optimizer_statistics.htm">
	 * http://www.dba-oracle.com/concepts/tables_optimizer_statistics.htm</a>.
	 * @param c the JDBC database connection
	 * @param user the name of the Oracle user
	 * @throws SQLException if there was a problem executing the stored procedure
	 * @see #optimizeTable(Connection, String, String)
	 */
	public void optimizeSchema(Connection c, String user) throws SQLException {
		try (val cs = c.prepareCall("BEGIN DBMS_STATS.GATHER_SCHEMA_STATS(OWNNAME => ?, CASCADE => TRUE); END;")) {
			cs.setString(1, user);
			cs.execute();
		}
	}

	/**
	 * Attempts to refresh all Oracle materialized views by calling a system stored
	 * procedure using the the current connection.
	 * @param c the JDBC database connection
	 * @throws SQLException if there was a problem refreshing the materialized views
	 */
	public void refreshMaterializedViews(Connection c) throws SQLException {
		try (val cs = c.prepareCall("DECLARE FAILS NUMBER; BEGIN DBMS_MVIEW.REFRESH_ALL_MVIEWS(FAILS, 'C', NULL, FALSE, FALSE); END;")) {
			cs.execute();
		}
	}

	/**
	 * Sets the batch size on the statement. For all prepared statements,
	 * {@link PreparedStatement#setFetchSize(int)} is invoked with the parameter.
	 * For instances of {@link oracle.jdbc.OraclePreparedStatement},
	 * {@link oracle.jdbc.OraclePreparedStatement#setExecuteBatch(int)} is invoked as well.
	 * @param ps the statement
	 * @param size the new batch size
	 * @return the statement for method chaining
	 * @throws SQLException if there was a problem setting the batch size
	 */
	public PreparedStatement setBatchSize(PreparedStatement ps, int size) throws SQLException {
		ps.setFetchSize(size);
//		if (isVendorSpecific(ps, oracle.jdbc.OraclePreparedStatement.class)) {
//			ps.unwrap(oracle.jdbc.OraclePreparedStatement.class).setExecuteBatch(size);
//		}
		return ps;
	}

	/**
	 * Adds the current parameter set as a batch entry on the statement. For
	 * instances of {@link oracle.jdbc.OraclePreparedStatement}, batching is handled
	 * implicitly, so this method invokes {@link PreparedStatement#executeUpdate()}.
	 * For all other implementations, {@link PreparedStatement#addBatch()} is
	 * invoked.
	 * @param ps the statement
	 * @return the statement for method chaining
	 * @throws SQLException if there was a problem adding the parameters to the batch
	 * @see #setBatchSize(PreparedStatement, int)
	 */
	public PreparedStatement addBatch(PreparedStatement ps) throws SQLException {
//		if (isVendorSpecific(ps, oracle.jdbc.OraclePreparedStatement.class)) {
//			ps.executeUpdate();
//			return ps;
//		}

		ps.addBatch();
		return ps;
	}

	/**
	 * Executes the current batch and commits the transaction. For instances of
	 * {@link oracle.jdbc.OraclePreparedStatement}, this method has no effect, since batches
	 * are implicitly sent to the database once the batch size is reached. For
	 * all statements, their connection's {@link Connection#commit()} is invoked.
	 * @param ps the statement
	 * @return the result of the batch execution, or {@code null} if {@code ps}
	 * is an {@link oracle.jdbc.OraclePreparedStatement}
	 * @throws SQLException if there was a problem executing and committing the batch
	 * @see #addBatch(PreparedStatement)
	 */
	public int[] executeBatchAndCommit(PreparedStatement ps) throws SQLException {
//		if (isVendorSpecific(ps, oracle.jdbc.OraclePreparedStatement.class)) {
//			// Oracle batches implicitly send when the batch number is reached, so we don't need to call executeBatch()
//			ps.getConnection().commit();
//			return null;
//		}

		val ret = ps.executeBatch();
		ps.getConnection().commit();
		return ret;
	}

	/**
	 * Sends any remaining work in the current batch. This is only applicable
	 * to instances of {@link oracle.jdbc.OraclePreparedStatement} where batching is
	 * implicit. You should always call this before the final call to
	 * {@link #executeBatchAndCommit(PreparedStatement)} if there is a possibility
	 * the statement is {@link #executeBatchAndCommit(PreparedStatement)}.
	 * @param ps the statement
	 * @return the result of {@link oracle.jdbc.OraclePreparedStatement#sendBatch()}, or
	 * {@code -1} if the method isn't invoked because {@code ps} is not a
	 * {@link oracle.jdbc.OraclePreparedStatement}
	 * @throws SQLException if there was a problem sending the remaining work
	 */
	public int sendRemainingBatch(PreparedStatement ps) throws SQLException {
//		if (isVendorSpecific(ps, oracle.jdbc.OraclePreparedStatement.class)) {
//			return ps.unwrap(oracle.jdbc.OraclePreparedStatement.class).sendBatch();
//		}
		return -1;
	}

	/**
	 * Creates a PL/SQL callable statement.
	 * @param c the connection to use
	 * @param name the fully qualified name of the procedure or function
	 * @param params the number of input parameters (not including the output
	 * parameter for functions)
	 * @param retType the SQL type being returned by the function, or {@link Types#NULL}
	 * for procedures that don't return a value
	 * @return the callable statement
	 * @throws SQLException if there was a problem creating the statement
	 */
	public CallableStatement getCall(Connection c, String name, int params, int retType) throws SQLException {
		val sb = new StringBuilder("{");
		if (retType != Types.NULL) { sb.append("? = "); }
		sb.append("call ").append(name);
		for (int i = 0; i < params; i++) {
			sb.append(i == 0? "(" : ", ");
			sb.append("?");
		}

		val cs = c.prepareCall(sb.append(")}").toString());
		if (retType != Types.NULL) { cs.registerOutParameter(1, retType); }
		return cs;
	}

	/**
	 * Sets the parameter at the specified position to a float value, interpreting
	 * {@link Float#NaN} as {@code null}.
	 * @param ps the statement
	 * @param ordinal the position
	 * @param val the value
	 * @throws SQLException if there was a problem setting the parameter
	 */
	public void setFloatNaNAsNull(PreparedStatement ps, int ordinal, float val) throws SQLException {
		if (Float.isNaN(val)) {
			ps.setNull(ordinal, Types.FLOAT);
		} else {
			ps.setFloat(ordinal, val);
		}
	}

	/**
	 * Gets the value at the specified position, substituting {@link Float#NaN}
	 * if the value is {@code null}.
	 * @param rs the result set
	 * @param ordinal the position
	 * @return the value
	 * @throws SQLException if there was a problem retrieving the value
	 */
	public float getFloatNullAsNaN(ResultSet rs, int ordinal) throws SQLException {
		float fv = rs.getFloat(ordinal);
		return rs.wasNull()? Float.NaN : fv;
	}

	/**
	 * This method takes a string value and escapes it for use as a SQL literal.
	 * If {@code s} is {@code null} or empty, this method returns {@code "NULL"}.
	 * If {@code s} cannot be converted to a number (it is a string), and it is
	 * not already enclosed in quotes, it is returned enclosed in single quotes
	 * ({@code '}).
	 * @param s the string to escape
	 * @return the SQL literal
	 */
	public String escapeLiteral(String s) {
		s = StringUtils.stripToNull(s);
		if (s == null) { return "NULL"; }
		return Utilities.addQuotes(s);
	}

//	/**
//	 * Convert Oracle-specific datum to the Java equivalent. Currently this
//	 * converts any timestamp/dates to {@link Date dates} and streams and reads
//	 * {@link CLOB CLOBs} into {@code Strings}.
//	 * @param datum the datum
//	 * @return the converted object, or the original datum if the type is not
//	 * recognized or does not require conversion.
//	 * @throws SQLException if there was a problem converting the value
//	 */
//	public Object toJava(oracle.sql.Datum datum) throws SQLException {
//		if (datum instanceof oracle.sql.TIMESTAMP || datum instanceof oracle.sql.TIMESTAMPTZ
//		 || datum instanceof oracle.sql.TIMESTAMPLTZ || datum instanceof oracle.sql.DATE) {
//			return datum.dateValue();
//		}
//		if (datum instanceof oracle.sql.CLOB) {
//			oracle.sql.CLOB clob = (oracle.sql.CLOB) datum;
//			try (Reader r = datum.characterStreamValue()) {
//				char[] arr = new char[(int) clob.length()];
//				r.read(arr);
//				return new String(arr);
//			} catch (IOException e) {
//				return "Unreadable CLOB";
//			}
//		}
//		if (datum instanceof oracle.sql.NUMBER) {
//			return datum.bigDecimalValue();
//		}
//		if (datum instanceof oracle.sql.BINARY_DOUBLE) {
//			return datum.doubleValue();
//		}
//		if (datum instanceof oracle.sql.BINARY_FLOAT) {
//			return datum.floatValue();
//		}
//		return datum;
//	}

	/**
	 * Sets attributes for the connection (current session) so that subsequent queries are case insensitive.
	 * Right now only Oracle connections are supported.
	 * @param c the connection
	 */
	public void setCaseInsensitive(Connection c) {
//		if (isVendorSpecific(c, oracle.jdbc.OracleConnection.class)) {
//			try (val s = c.createStatement()) {
//				s.execute("ALTER SESSION SET NLS_SORT=BINARY_CI");
//				s.execute("ALTER SESSION SET NLS_COMP=LINGUISTIC");
//			} catch (SQLException | NullPointerException e) {
//				// Unsupported database type or error setting the case hint
//			}
//		}
		if (isVendorSpecific(c, SnowflakeConnectionV1.class)) {
			try (val s = c.createStatement()) {
				s.execute("ALTER SESSION SET DEFAULT_DDL_COLLATION='en-ci'");
				s.execute("ALTER SESSION SET QUOTED_IDENTIFIERS_IGNORE_CASE='true'");
			} catch (SQLException | NullPointerException e) {
				// Unsupported database type or error setting the case hint
			}
		}
	}

	/**
	 * Tests if the wrappable object (like a connection or statement) is a given vendor's specific implementation.
	 * This tests if the object is the same type or a subclass or can be "unwrapped" to that type via JDBC's
	 * {@link Wrapper} API (like with connection pooling).
	 * @param w the object
	 * @param type the vendor specific type
	 * @param <W> the object type
	 * @param <T> the vendor specific type
	 * @return if the object is the type, a subtype, or can be unwrapped to the type
	 */
	public <W extends Wrapper, T extends W> boolean isVendorSpecific(W w, Class<T> type) {
		if (type.isAssignableFrom(w.getClass())) { return true; }
		try {
			if (w.isWrapperFor(type)) {
				w.unwrap(type).getClass();
				return true;
			}
			return false;
		} catch (SQLException | NullPointerException | ClassCastException | NoClassDefFoundError e) {
			return false;
		}
	}
}
