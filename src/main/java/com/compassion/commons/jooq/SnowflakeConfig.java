package com.compassion.commons.jooq;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.apache.commons.text.StringSubstitutor;
import org.jooq.SQLDialect;

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

@Getter @Setter @Accessors(chain = true)
public class SnowflakeConfig extends JOOQDatabaseConfig {
	private static final String
		DEF_URL    = "ci.us-east-2.aws.snowflakecomputing.com",
		DEF_ROLE   = "GLOBAL_PROGRAM_DEVELOPER",
		DEF_DB     = "GLOBAL_PROGRAM_DEVINT",
		DEF_AUTH   = "https://compassion.okta.com";
	
	@JsonSchemaDescription("The base Snowflake URL, including the account identifier")
	@JsonSchemaDefault(DEF_URL)
	private String baseURL = DEF_URL;
	
	@JsonSchemaDescription("The Snowflake role to read and write data (will usually be a _DEVELOPER role)")
	@JsonSchemaDefault(DEF_ROLE)
	private String role = DEF_ROLE;
	
	@JsonSchemaDescription("The database to use to read/write data in Snowflake")
	@JsonSchemaDefault(DEF_DB)
	private String database = DEF_DB;
	
	@JsonSchemaDescription("The authenticator to use. When running as an AWS lambda, this defaults to Snowflake authentication for service accounts. When running locally, this defaults to the Okta authenticator.")
	@JsonSchemaDefault(DEF_AUTH)
	private String authenticator;
	
	@JsonSchemaDescription("When batch inserting data, the maximum number of rows to accumulate before saving to the database in batch. Snowflake is very efficient at batching so this number can be large.")
	@JsonSchemaDefault("100000")
	private int maxBatchSize = 100_000;
	
	@JsonSchemaDescription("When batch inserting data, the maximum amount of time (in seconds) to wait between saving, even if the batch isn't full yet.")
	@JsonSchemaDefault("30")
	private int maxBatchTime = 30;
	
	protected SnowflakeConfig(String serviceAcct, String defRole, String defDB) {
		if (StringUtils.isBlank(serviceAcct)) {
			setUser(SystemUtils.USER_NAME);
			setAuthenticator(DEF_AUTH);
		} else {
			setUser(serviceAcct);
			setAuthenticator("snowflake");
		}
		
		setDriver(JDBCDriver.SNOWFLAKE);
		LambdaUtils.accept(defRole, this::setRole);
		LambdaUtils.accept(defDB, this::setDatabase);
	}
	
	// Can remove once https://gitlab.com/ElderResearch/toolbox/commons/jvm/jooq/-/issues/1 is resolved
	@JsonIgnore @Override
	public SQLDialect getDialect() { return super.getDialect(); }
	
	@Override
	public String getHostURL() {
		return StringSubstitutor.replace("${base}?authenticator=${auth}&role=${role}&db=${db}", ImmutableMap.of(
			"auth",   authenticator,
			"role",   role,
			"base",   baseURL,
			"db",     database
		));
	}
}