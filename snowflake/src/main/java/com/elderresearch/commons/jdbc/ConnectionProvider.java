/* ©2017-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.commons.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import com.compassion.commons.LambdaUtils;
import com.mchange.v2.c3p0.DataSources;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@FunctionalInterface
public interface ConnectionProvider {
	/**
	 * Acquire a new connection. This might check out a connection from a pool or establish a direct connection to the
	 * database depending on the implementation. In all cases, you should call {@link Connection#close()} on the returned
	 * connection when you are done using it.
	 * @return a new connection
	 * @throws SQLException if there was a problem acquiring the connection
	 */
	Connection getConnection() throws SQLException;

	/**
	 * Registers a caller or "user" of this connection provider. When the last caller calls {@link #close(Object)}, all
	 * resources associated with the provider will be closed/released. This is optional and {@link #closeImmediately()}
	 * can always be used instead. The default implementation is a no-op so this interface can be functional.
	 * @param caller the caller using this provider
	 * @see #close(Object)
	 */
	default void registerCaller(Object caller) {
		// No-op
	}

	/**
	 * Close the connection provider when all callers are finished using it. The default implementation is a no-op
	 * so this interface can be functional.
	 * @param caller the caller
	 * @throws SQLException if there was a problem closing the connection provider
	 * @see #registerCaller(Object)
	 */
	default void close(Object caller) throws SQLException {
		// No-op
	}

	/**
	 * Close the connection provider immediately, even if callers still have connections "checked out" (in the case
	 * of a pooled connection). The default implementation is a no-op so this interface can be functional.
	 * @throws SQLException if there was a problem closing the connection provider
	 */
	default void closeImmediately() throws SQLException {
		// No-op
	}

	/**
	 * Gets the database configuration associated with this connection provider. This might be {@code null} if the
	 * provider was not configured via a {@link DatabaseConfig}.
	 * @return this provider's configuration
	 */
	default DatabaseConfig getConfig() {
		return null;
	}

	/**
	 * Base class for connection provider implementations, handling the caller parameters specified in the interface
	 * for you.
	 */
	abstract class BaseConnectionProvider implements ConnectionProvider {
		private Set<Object> callers = new HashSet<>();

		@Getter @Setter(AccessLevel.PROTECTED)
		private DatabaseConfig config;

		@Override
		public void registerCaller(Object caller) {
			synchronized (callers) {
				LambdaUtils.accept(caller, callers::add);
			}
		}

		@Override
		public void close(Object caller) throws SQLException {
			synchronized (callers) {
				LambdaUtils.accept(caller, callers::remove);
				if (callers.isEmpty()) { close(); }
			}
		}

		@Override
		public void closeImmediately() throws SQLException { close(); }

		protected abstract void close() throws SQLException;

		@Override
		public String toString() {
			return Objects.toString(getConfig(), getClass().getSimpleName());
		}
	}

	class ConnectionProviderDirect extends BaseConnectionProvider {
		@Getter private CloseGuardConnection connection;

		public ConnectionProviderDirect(Connection c) {
			this.connection = new CloseGuardConnection(c);
		}

		public ConnectionProviderDirect(DatabaseConfig c) throws SQLException {
			this(c.connect());
			setConfig(c);
		}

		@Override
		protected void close() throws SQLException {
			connection.getDelegate().close();
		}
	}

	@AllArgsConstructor
	class ConnectionProviderPooled extends BaseConnectionProvider {
		private DataSource pool;

		public ConnectionProviderPooled(DatabaseConfig c) {
			this(c.getDriver().getConnectionPool(c.getHostURL(), c.getUser(), c.getPassword()));
			setConfig(c);
		}

		@Override
		public Connection getConnection() throws SQLException {
			return pool.getConnection();
		}

		@Override
		protected void close() throws SQLException {
			DataSources.destroy(pool);
		}
	}
}
