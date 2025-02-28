package com.compassion.commons.metrics;

import com.datadog.api.client.ApiClient;
import com.datadog.api.client.v2.api.MetricsApi;

import lombok.Getter;
import lombok.experimental.Accessors;

@Getter @Accessors(fluent = true)
public class DataDogMetricsAPI extends ApiClient implements AutoCloseable {
	private MetricsApi metrics;
	
	public DataDogMetricsAPI(DataDogMetricsConfig conf) {
		setDebugging(conf.isVerbose());
		setApiKey(conf.getApiKey());
		setBasePath(conf.getBasePath());
		
		metrics = new MetricsApi(this);
	}

	@Override public void close() throws Exception { getHttpClient().close(); }
}
