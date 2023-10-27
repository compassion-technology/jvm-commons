package com.compassion.commons.jooq;

import java.sql.Connection;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.apache.commons.text.StringSubstitutor;
import org.jooq.SQLDialect;
import org.jooq.exception.DataAccessException;

import com.compassion.commons.LambdaUtils;
import com.elderresearch.commons.jdbc.JDBCDriver;
import com.elderresearch.commons.jooq.JOOQDatabaseConfig;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.ImmutableMap;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaDefault;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaDescription;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Getter @Setter @Accessors(chain = true)
public class SnowflakeConfig extends JOOQDatabaseConfig {
	private static final String
		DEF_URL  = "ci.us-east-2.aws.snowflakecomputing.com",
		DEF_AUTH = "https://compassion.okta.com",
		SVC_AUTH = "snowflake";
	
	@JsonSchemaDescription("The base Snowflake URL, including the account identifier")
	@JsonSchemaDefault(DEF_URL)
	private String baseURL = DEF_URL;
	
	@JsonSchemaDescription("The Snowflake role to read and write data (will usually be a _DEVELOPER role)")
	private String role;
	
	@JsonSchemaDescription("The database to use to read/write data in Snowflake")
	private String database;
	
	@JsonSchemaDescription("The authenticator to use. When running as an AWS lambda, this defaults to Snowflake authentication for service accounts. When running locally, this defaults to the Okta authenticator.")
	@JsonSchemaDefault(DEF_AUTH)
	private String authenticator;
	
	@JsonSchemaDescription("When batch inserting data, the maximum number of rows to accumulate before saving to the database in batch. Snowflake is very efficient at batching so this number can be large.")
	@JsonSchemaDefault("100000")
	private int maxBatchSize = 100_000;
	
	@JsonSchemaDescription("When batch inserting data, the maximum amount of time (in seconds) to wait between saving, even if the batch isn't full yet.")
	@JsonSchemaDefault("30")
	private int maxBatchTime = 30;
	
	@JsonSchemaDescription("The maximum number of connections to pool when re-using connections to Snowflake")
	@JsonSchemaDefault("4")
	private int maxConnections = 4;
	
	@JsonSchemaDescription("The minimum number of connections to pool when re-using connections to Snowflake")
	@JsonSchemaDefault("1")
	private int minConnections = 1;
	
	protected SnowflakeConfig(String serviceAcct, String defRole, String defDB) {
		if (StringUtils.isBlank(serviceAcct)) {
			setUser(SystemUtils.USER_NAME);
			setAuthenticator(DEF_AUTH);
		} else {
			setUser(serviceAcct);
			setAuthenticator(SVC_AUTH);
		}
		
		setDriver(JDBCDriver.SNOWFLAKE);
		LambdaUtils.accept(defRole, this::setRole);
		LambdaUtils.accept(defDB, this::setDatabase);
	}
	
	@JsonIgnore @Override
	public SQLDialect getDialect() {
		// Use Postgres to make sure update statements aren't qualified
		return SQLDialect.POSTGRES;
	}
	
	@Override
	public String getHostURL() {
		// Set c3p0 props now before the first connection is opened
		System.setProperty("c3p0.minPoolSize", String.valueOf(getMinConnections()));
		System.setProperty("c3p0.initialPoolSize", String.valueOf(getMinConnections()));
		System.setProperty("c3p0.maxPoolSize", String.valueOf(getMaxConnections()));
		// Default of 30 retries can lock users out of account.
		// Problems are usually networking or password which aren't solved by retry.
		System.setProperty("c3p0.acquireRetryAttempts", String.valueOf(1));
		
		return StringSubstitutor.replace("${base}?authenticator=${auth}&role=${role}&db=${db}", ImmutableMap.of(
			"auth",   authenticator,
			"role",   role,
			"base",   baseURL,
			"db",     database
		));
	}
	
	@Override
	public Connection acquire() throws DataAccessException {
		log.debug("Opening new connection to Snowflake...");
		return super.acquire();
	}
}