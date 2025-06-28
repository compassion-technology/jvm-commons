package com.compassion.commons.jooq;

import org.jooq.conf.ParamCastMode;
import org.jooq.conf.RenderQuotedNames;
import org.jooq.conf.Settings;

public class SnowflakeSettings extends Settings {
	private static final long serialVersionUID = 1L;

	public SnowflakeSettings() {
		// Snowflake doesn't support returning generated IDs on inserts
		withReturnIdentityOnUpdatableRecord(false);
		// If this is true, we don't do batch inserts or updates
		withReturnRecordToPojo(false);
		// We often use the wrong dialect, like Postgres, which casts columns to PG specific types
		withParamCastMode(ParamCastMode.NEVER);
		// Don't double quote names unless necessary
		withRenderQuotedNames(RenderQuotedNames.EXPLICIT_DEFAULT_UNQUOTED);
	}
}
