package com.compassion.commons.metrics;

import java.util.function.Consumer;

import com.compassion.commons.config.CredentialConfig;
import com.compassion.commons.jackson.PasswordSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DataDogMetricsConfig implements CredentialConfig {
	private String apiKeyAuth;
	private String appKeyAuth;
	private boolean verbose, retry;
	@Override
	public void forEachCredentialPath(Consumer<String> withSecretPath) {
		withSecretPath.accept("apiKeyAuth");
		withSecretPath.accept("appKeyAuth");
	}
	
	public interface DataDogMetricsMixin {
		@JsonSerialize(using = PasswordSerializer.class) String getApiKeyAuth();
		@JsonSerialize(using = PasswordSerializer.class) String getAppKeyAuth();
	}
}
