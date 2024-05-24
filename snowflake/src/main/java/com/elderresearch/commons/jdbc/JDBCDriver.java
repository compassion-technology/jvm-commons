/* ©2016-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.commons.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;

import lombok.extern.log4j.Log4j2;

/**
 * Enumerates {@link DatabaseDriver} implementations for common database vendors that provide
 * JDBC drivers. Some drivers are "opt out", meaning that the required dependencies/JARs will be 
 * transitively added to your module when you depend on this module. However, if you do not need
 * or want to support the driver, you can exclude the relevant dependencies via Maven and
 * {@link #hasDriver()} will return {@code false}. Other more specialized drivers declared here
 * are "opt in", meaning the dependencies are not provided by default and must be added if you want
 * to use that driver. Finally, any JDBC database can be supported by implementing {@link DatabaseDriver}
 * directly.
 * 
 * @author <a href="mailto:dimeo@datamininglab.com">John Dimeo</a>
 * @since Jun 22, 2016
 */
@Log4j2
public enum JDBCDriver implements DatabaseDriver {
	// OPT OUT DRIVERS
	// The following more common drivers are sent down transitively, but can safely be excluded via 
	// <exclusion> tags for drivers that aren't needed.
	ORACLE {
		@Override
		public String toString() { return "Oracle"; }
		@Override
		public String getDriverClass() { return "oracle.jdbc.driver.OracleDriver"; }
		@Override
		public String getURLPrefix() { return "jdbc:oracle:thin:@"; }
		@Override
		public long getRowEstimate(Connection c, String table) {
			String[] qualified = StringUtils.split(table, '.');
			String sql = "select num_rows from all_tables where ";
			if (qualified.length > 1) {
				sql += "owner = ? and table_name = ?";
			} else {
				sql += "table_name = ?";
			}
			return getRowEstimate(c, sql, qualified);
		}
	},
	MS_SQL_SERVER {
		@Override
		public String toString() { return "MS SQL Server"; }
		@Override
		public String getDriverClass() { return "com.microsoft.sqlserver.jdbc.SQLServerDriver"; }
		@Override
		public String getURLPrefix() { return "jdbc:sqlserver://"; }
		@Override
		public long getRowEstimate(Connection c, String table) {
			String[] qualified = StringUtils.split(table, '.');
			if (qualified.length > 1) {
				try (Statement s = c.createStatement()) {
					s.execute("use " + qualified[0]);
				} catch (SQLException e) {
					return -1L;
				}
				table = StringUtils.substringAfter(table, ".");
			}
			return getRowEstimate(c, "select sum(p.rows) from sys.partitions p where p.object_id = object_id(?) and p.index_id < 2", table);
		}
		
		@Override
		public DataSource getConnectionPool(String host, Properties properties) {
			// Load the auth DLL automatically if the user tried to use integrated security
			if (StringUtils.containsIgnoreCase(host, "integratedSecurity") || properties.containsKey("integratedSecurity")) {
				loadExtensions();
			}
			return super.getConnectionPool(host, properties);
		}
		
		@Override
		public Connection getConnection(String host, String user, String pass) throws SQLException {
			// Load the auth DLL automatically if the user tried to use integrated security
			if (StringUtils.containsIgnoreCase(host, "integratedSecurity")) {
				loadExtensions();
			}
			return super.getConnection(host, user, pass);
		}
	},
	MYSQL {
		@Override
		public String toString() { return "MySQL"; }
		@Override
		public String getDriverClass() { return "com.mysql.jdbc.Driver"; }
		@Override
		public String getURLPrefix() { return "jdbc:mysql://"; }
		@Override
		public long getRowEstimate(Connection c, String table) {
			String[] qualified = StringUtils.split(table, '.');
			if (qualified.length > 1) {
				return getRowEstimate(c, "SELECT TABLE_ROWS FROM information_schema.TABLES WHERE TABLE_SCHEMA = ? AND TABLE_NAME = ?", qualified);				
			}
			return getRowEstimate(c, "SELECT TABLE_ROWS FROM information_schema.TABLES WHERE TABLE_NAME = ?", table);
		}
	},
	POSTGRES {
		@Override
		public String toString() { return "PostgreSQL"; }
		@Override
		public String getDriverClass() { return "org.postgresql.Driver"; }
		@Override
		public String getURLPrefix() { return "jdbc:postgresql://"; }
		@Override
		public long getRowEstimate(Connection c, String table) {
			String[] qualified = StringUtils.split(table, '.');
			if (qualified.length > 1) {
				return getRowEstimate(c, "SELECT reltuples FROM pg_class c join pg_namespace n on c.relnamespace = n.oid where nspname = ? and relname = ?", qualified);
			}
			return getRowEstimate(c, "SELECT reltuples FROM pg_class WHERE relname = ?", table);
		}
	},
	DERBY {
		@Override
		public String toString() { return "Apache Derby"; }
		@Override
		public String getDriverClass() { return "org.apache.derby.jdbc.ClientDriver"; }
		@Override
		public String getURLPrefix() { return "jdbc:derby:"; }
	},
	SQLITE {
		@Override
		public String toString() { return "SQLite"; }
		@Override
		public String getDriverClass() { return "org.sqlite.JDBC"; }
		@Override
		public String getURLPrefix() { return "jdbc:sqlite:"; }
	},
	H2 {
		@Override
		public String getDriverClass() { return "org.h2.Driver"; }
		@Override
		public String getURLPrefix() { return "jdbc:h2:"; }
	},
	DB2 {
		@Override
		public String toString() { return "IBM DB2"; }
		@Override
		public String getDriverClass() { return "com.ibm.db2.jcc.DB2Driver"; }
		@Override
		public String getURLPrefix() { return "jdbc:db2://"; }
	},
	// OPT IN DRIVERS
	// The following do not come with drivers in our POM (due to bloat or unavailability)- up to
	// the end user to make sure necessary drivers are on the classpath to use.
	REDSHIFT {
		@Override
		public String toString() { return "AWS Redshift"; }
		@Override
		public String getDriverClass() { return "com.amazon.redshift.jdbc.Driver"; }
		@Override
		public String getURLPrefix() { return "jdbc:redshift://"; }
	},
	TERADATA {
		@Override
		public String toString() { return "Teradata"; }
		@Override
		public String getDriverClass() { return "com.teradata.jdbc.TeraDriver"; }
		@Override
		public String getURLPrefix() { return "jdbc:teradata://"; }
	},
	NETEZZA {
		@Override
		public String toString() { return "IBM Netezza"; }
		@Override
		public String getDriverClass() { return "org.netezza.Driver"; }
		@Override
		public String getURLPrefix() { return "jdbc:netezza://"; }
	},
	CASSANDRA {
		@Override
		public String toString() { return "Apache Cassandra"; }
		@Override
		public String getDriverClass() { return "com.github.adejanovski.cassandra.jdbc.CassandraDriver"; }
		@Override
		public String getURLPrefix() { return "jdbc:cassandra://"; }
	},
	SNOWFLAKE {
		@Override
		public String toString() { return "Snowflake"; }
		@Override
		public String getDriverClass() { return "net.snowflake.client.jdbc.SnowflakeDriver"; }
		@Override
		public String getURLPrefix() { return "jdbc:snowflake://"; }
	};
	
	static {
		// Suppress C3P0 logging. Doesn't seem to work in logback.xml. This is
		// critical as it goes to System.err by default, thus triggering error
		// reports in apps for normal behavior
		System.setProperty("com.mchange.v2.log.MLog", "com.mchange.v2.log.FallbackMLog");
		System.setProperty("com.mchange.v2.log.FallbackMLog.DEFAULT_CUTOFF_LEVEL", "WARNING");
	}
	
	private Boolean hasDriver;
	
	@Override
	public boolean hasDriver() {
		if (hasDriver == null) {
			try {
				Class.forName(getDriverClass());
				hasDriver = true;
			} catch (ClassNotFoundException e) {
				log.debug("JDBC Driver not available: {}", getDriverClass());
				hasDriver = false;
			}
		}
		return hasDriver;
	}
	
	@Override
	public String getName() { return name(); }
	
	/**
	 * Loads extensions (like native libraries) for this driver. For example, this can be used to enable Active
	 * Directory authentication with SQL Server, which is only available on Windows.
	 */
	public void loadExtensions() {
		JDBCDriverExtensions.loadExtensions(this);
	}
	
	protected static long getRowEstimate(Connection c, String sql, String... params) {
		try (PreparedStatement ps = c.prepareStatement(sql)) {
			for (int i = 0; i < params.length; i++) {
				ps.setString(i + 1, params[i]);
			}
			try (ResultSet rs = ps.executeQuery()) {
				return rs.next()? rs.getLong(1) : -1L;	
			}
		} catch (SQLException e) {
			return -1L;
		}
	}
	
	public static JDBCDriver valueFromURL(String url) {
		for (JDBCDriver dbd : values()) {
			if (StringUtils.startsWithIgnoreCase(url, dbd.getURLPrefix())) { return dbd; }
		}
		return null;
	}
}
