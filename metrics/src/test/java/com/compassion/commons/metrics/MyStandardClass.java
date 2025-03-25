package com.compassion.commons.metrics;

import com.compassion.commons.metrics.MetricValueProviders.MetricValueProvider;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain = true)
public class MyStandardClass {
	private String cofVersion, id, name;
	private int responses, filtered, rejected;
	private Throwable error;

	public void incrementResponseCount() {
		responses++;
	}
	
	@MetricValueProvider(type = StandardMetricType.EVENTS_PROCESSED)
	@MetricValueProvider(type = StandardMetricType.API_CALLS)
	public Double eventsProcessed() {
		return Double.valueOf(responses);
	}

	@MetricValueProvider(type = StandardMetricType.EVENTS_EXCLUDED, customGranularity = "source_ref_absent")
	public Double eventsExcluded() {
		return filtered > 0 ? Double.valueOf(filtered) : null;
	}
	
	@MetricValueProvider(type = StandardMetricType.EVENTS_EXCLUDED, customGranularity = "source_rejected")
	public Double eventsRejected() {
		return rejected > 0 ? Double.valueOf(rejected) : null;
	}
	
	@MetricValueProvider(type = StandardMetricType.EXCEPTION_COUNT)
	public Double metricValue() {
		return error != null ? 1.0 : null;
	}
}
