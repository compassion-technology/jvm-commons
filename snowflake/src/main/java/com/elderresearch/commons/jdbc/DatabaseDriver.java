/* ©2016-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.commons.jdbc;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;

import com.compassion.commons.LambdaUtils;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.sql.SqlUtils;

import lombok.val;

/**
 * Generalizes the interaction with relational database vendors.
 *
 * @author <a href="dimeo@datamininglab.com">John Dimeo</a>
 * @since Jun 27, 2012
 */
public interface DatabaseDriver {
	int INITIAL_POOL_SIZE = 3;
	int IDLE_TEST_MIN = 2;

	/**
	 * System-level name (usually without spaces) uniquely identifying this driver. Override
	 * {@link #toString()} for a user-friendly display name.
	 * @return the name of the driver
	 */
	String getName();

	/**
	 * Whether or not this driver has an underlying implementation on the classpath.
	 * @return if this driver is implemented
	 */
	boolean hasDriver();

	/**
	 * Gets the fully qualified class name of the JDBC driver (e.g. {@code "org.vendor.Driver"})
	 * @return the driver class name
	 */
	String getDriverClass();

	/**
	 * Gets the JDBC URL prefix (e.g. {@code "jdbc:vendor://"})
	 * @return the URL prefix
	 */
	String getURLPrefix();

	/**
	 * Gets an estimate of the number of rows in the table using database-specific
	 * syntax. This will fall back on {@link JDBCTableUtils#getRowCount(Connection, String, boolean)}
	 * if no database-specific logic is defined/available.
	 * @param c the connection
	 * @param table the fully qualified table or object name
	 * @return the row count, or {@code -1} if there was a problem counting the rows
	 */
	default long getRowEstimate(Connection c, String table) {
		return JDBCTableUtils.getRowCount(c, table, true);
	}

	/**
	 * Returns the portion of the URL after the driver prefix returned by {@link #getURLPrefix()}.
	 * @param url the URL
	 * @return the URL without the driver prefix
	 */
	default String getURLAfterJDBCPrefix(String url) {
		return StringUtils.substringAfter(url, getURLPrefix());
	}

	/**
	 * Create a connection pool using this driver and the given properties. Note that connections
	 * returned by this pool will not usually be vendor-specific classes (like {@code OracleConnection}),
	 * but rather pool-specific implementations.
	 * @param host the host URL (without the driver-specific prefix)
	 * @param properties the connection properties
	 * @return a new connection pool (backed by C3P0 connection pooling)
	 * @throws IllegalArgumentException if the driver class is not valid
	 */
	default DataSource getConnectionPool(String host, Properties properties) {
		val cpds = new ComboPooledDataSource();
		cpds.setJdbcUrl(getURLPrefix() + host);
		try {
			cpds.setDriverClass(getDriverClass());
		} catch (PropertyVetoException e) {
			throw new IllegalArgumentException("Unrecognized JDBC driver class " + getDriverClass());
		}

		cpds.setProperties(properties);
		cpds.setInitialPoolSize(INITIAL_POOL_SIZE);
		cpds.setIdleConnectionTestPeriod((int) TimeUnit.SECONDS.convert(IDLE_TEST_MIN, TimeUnit.MINUTES));
		return cpds;
	}

	/**
	 * Create a connection pool using this driver and the given credentials. Note that connections
	 * returned by this pool will not usually be vendor-specific classes (like {@code OracleConnection}),
	 * but rather pool-specific implementations.
	 * @param host the host URL (without the driver-specific prefix)
	 * @param user the user name (if required)
	 * @param pass the password (if required)
	 * @return a new connection pool (backed by C3P0 connection pooling)
	 * @throws IllegalArgumentException if the driver class is not valid
	 */
	default DataSource getConnectionPool(String host, String user, String pass) {
		val props = new Properties();
		LambdaUtils.accept(user, $ -> props.setProperty(SqlUtils.DRIVER_MANAGER_USER_PROPERTY, $));
		LambdaUtils.accept(pass, $ -> props.setProperty(SqlUtils.DRIVER_MANAGER_PASSWORD_PROPERTY, $));
		return getConnectionPool(host, props);
	}

	/**
	 * Create a connection using this driver and the given credentials. Connections returned by
	 * this will usually be vendor-specific classes (like {@code OracleConnection}).
	 * @param host the host URL
	 * @param user the user name (if required)
	 * @param pass the password (if required)
	 * @return a new connection
	 * @throws SQLException if there was a problem opening the connection
	 */
	default Connection getConnection(String host, String user, String pass) throws SQLException {
		return DriverManager.getConnection(getURLPrefix() + host, user, pass);
	}
}
