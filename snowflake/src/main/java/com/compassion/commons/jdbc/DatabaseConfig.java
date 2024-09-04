package com.compassion.commons.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.lang3.StringUtils;

import com.compassion.commons.LambdaUtils;
import com.compassion.commons.Utilities;
import com.compassion.commons.config.CredentialConfig.ConfigWithUserPassword;
import com.compassion.commons.jdbc.ConnectionProvider.ConnectionProviderDirect;
import com.compassion.commons.jdbc.ConnectionProvider.ConnectionProviderPooled;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

import lombok.Getter;
import lombok.Setter;
import lombok.Synchronized;
import lombok.experimental.Accessors;
import picocli.CommandLine;
import picocli.CommandLine.ArgGroup;
import picocli.CommandLine.Option;

/**
 * A runtime-configurable database connection/configuration. This provides the
 * same functionality as {@link DatabaseDriver} but can be configured via
 * {@link CommandLine}.  Create a member field of this class for your class with
 * a {@code main()} and annotate it with {@link ArgGroup}.
 *
 * @author <a href="dimeo@datamininglab.com">John Dimeo</a>
 * @since Oct 16, 2013
 */
@Getter @Setter @Accessors(chain = true)
public class DatabaseConfig extends ConfigWithUserPassword {
	private static final long serialVersionUID = 1L;

	/** The RDBMS vendor for this configuration. */
	@Option(names = {"-db", "--driver"}, description = "The database driver. Current supported values are 'Oracle' (default), 'MySQL', 'MS SQL Server', 'H2', and 'SQLite'")
	private String driverName = "oracle";

	/** The host name/URL. This does not include the {@code jdbc:}...{@code //} prefix, but it does include the port
	 *  number (if necessary) and the SID/service name/schema/catalog. */
	@Option(names = {"-url", "--hostUrl"}, description = "The host URL, including port and schema/catalog (but not including jdbc:..// prefix)")
	private String hostURL;

	private DatabaseDriver driver;

	private final transient Supplier<ConnectionProviderPooled> $pool = Suppliers.memoize(() -> new ConnectionProviderPooled(this));

	/**
	 * Returns if this configuration is valid; namely, that a connection can
	 * successfully be established to the database.
	 * @return if this configuration is valid
	 */
	@JsonIgnore
	public boolean isValid() {
		try (Connection c = connect()) {
			return true;
		} catch (SQLException | IllegalArgumentException e) {
			return false;
		}
	}

	/**
	 * Gets a connection from the underlying driver.
	 * @return a new connection
	 * @throws SQLException if there was a problem establishing the connection
	 */
	@Synchronized
	public Connection connect() throws SQLException {
		return getDriver().getConnection(getHostURL(), getUser(), getPassword());
	}

	/**
	 * Open a connection to the database and wrap it in a {@link ConnectionProvider}.
	 * @return the connection provider wrapping a direct connection to the underlying database
	 * @throws SQLException if there was a problem establishing the connection
	 */
	public ConnectionProvider asDirect() throws SQLException {
		return new ConnectionProviderDirect(this);
	}

	/**
	 * Open a connection pool to the underlying database and return it as a {@link ConnectionProvider}.
	 * @return a new pooled connection provider for this configuration
	 * @see DatabaseDriver#getConnectionPool(String, String, String)
	 */
	@Synchronized
	public ConnectionProvider asPool() {
		return $pool.get();
	}

	/**
	 * Gets the database driver.
	 * @return the database driver
	 * @throws IllegalArgumentException if the driver name specified as a command
	 * line parameter was not one of the recognized database drivers
	 */
	@JsonIgnore
	@Synchronized
	public DatabaseDriver getDriver() {
		if (driver == null) {
			// First check if the name matched one of the enums (with cleaning
			// provided by valueOf())
			driver = Utilities.valueOf(JDBCDriver.class, driverName, null);

			if (driver == null) {
				// If not, see if the driver name was the URL prefix (jdbc:oracle:thin)
				// or any part thereof
				for (JDBCDriver d : JDBCDriver.values()) {
					if (StringUtils.containsIgnoreCase(d.getURLPrefix(), driverName)) {
						driver = d; break;
					}
				}

				// Otherwise, throw an error
				if (driver == null) {
					throw new IllegalArgumentException("Unrecognized RDBMS: " + driverName);
				}
			}
		}
		return driver;
	}

	public DatabaseConfig setDriver(DatabaseDriver driver) {
		this.driver = driver;
		this.driverName = LambdaUtils.apply(driver, DatabaseDriver::getName);
		return this;
	}

	/**
	 * Copy the database configuration.
	 * @param includeCredentials whether or not to include the credentials
	 * (user name and password) when copying the configuration.
	 * @return a copy of this configuration
	 */
	public DatabaseConfig copy(boolean includeCredentials) {
		DatabaseConfig ret = new DatabaseConfig();
		ret.driverName = driverName;
		ret.driver     = driver;
		ret.hostURL    = hostURL;
		if (includeCredentials) {
			ret.setUser(getUser());
			ret.setPassword(getPassword());
		}
		return ret;
	}

	@Override
	public String toString() {
		return String.format("%s@%s", getUser(), hostURL);
	}
}
