package com.compassion.commons.metrics;

import com.compassion.commons.config.CredentialConfig.ConfigWithApiKey;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DataDogMetricsConfig extends ConfigWithApiKey {
	private boolean verbose, retry;
}
