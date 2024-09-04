package com.compassion.commons.jooq;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import org.jooq.ConnectionProvider;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.conf.Settings;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DSL;

import com.compassion.commons.jdbc.DatabaseConfig;
import com.compassion.commons.jdbc.DatabaseDriver;
import com.compassion.commons.jdbc.JDBCDriver;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

/**
 * Bridges the jOOQ {@link ConnectionProvider} and the ERI {@link DatabaseConfig} APIs.
 * 
 * @author <a href="mailto:dimeo@datamininglab.com">John Dimeo</a>
 * @since Oct 24, 2016
 */
public class JOOQDatabaseConfig extends DatabaseConfig implements ConnectionProvider {
	// Register built-in drivers and map them to jOOQ dialects
	// TODO: If we ever get commercial jOOQ, add additional drivers/dialects here
	private static final Map<DatabaseDriver, SQLDialect> DIALECT_MAP = Maps.newHashMap(ImmutableMap.<JDBCDriver, SQLDialect>builder()	
		.put(JDBCDriver.DERBY,    SQLDialect.DERBY)
		.put(JDBCDriver.H2,       SQLDialect.H2)
		.put(JDBCDriver.MYSQL,    SQLDialect.MYSQL)
		.put(JDBCDriver.POSTGRES, SQLDialect.POSTGRES)
		.put(JDBCDriver.SQLITE,   SQLDialect.SQLITE)
		.build());
	
	public static void registerDialect(DatabaseDriver driver, SQLDialect dialect) {
		DIALECT_MAP.put(driver, dialect);
	}
	
	/**
	 * Create a new context for jOOQ queries based on this configuration.
	 * @return a new context
	 * @see #newContext(Settings)
	 */
	public DSLContext newContext() {
		return newContext(null);
	}
	
	/**
	 * Create a new context for jOOQ queries based on this configuration using custom settings for the context.
	 * @param settings the custom settings
	 * @return a new context
	 */
	public DSLContext newContext(Settings settings) {
		return DSL.using(this, getDialect(), settings);
	}
	
	/**
	 * Gets the corresponding {@link SQLDialect} for the configured {@linkplain #getDriver() driver}. Currently, 
	 * commercial dialects (MySQL, Oracle, SQL Server, etc.) are not supported because we are using the free version
	 * of jOOQ.
	 * @return the dialect for this config's driver
	 */
	public SQLDialect getDialect() {
		return DIALECT_MAP.getOrDefault(getDriver(), SQLDialect.DEFAULT);
	}
	
	@Override
	public Connection acquire() throws DataAccessException {
		try {
			return delegateProvider().getConnection();
		} catch (SQLException e) {
			throw new DataAccessException("Can't acquire pooled thread", e);
		}
	}

	@Override
	public void release(Connection connection) throws DataAccessException {
		try {
			connection.close();
		} catch (SQLException e) {
			throw new DataAccessException("Can't release pooled thread", e);
		}
	}
	
	@SuppressWarnings("unused")
	protected com.compassion.commons.jdbc.ConnectionProvider delegateProvider() throws SQLException {
		return asPool();
	}
}
