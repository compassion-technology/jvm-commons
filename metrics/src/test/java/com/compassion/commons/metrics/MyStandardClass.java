package com.compassion.commons.metrics;

import com.compassion.commons.metrics.MetricValueProviders.MetricValueProvider;
import com.compassion.commons.metrics.MyCustomTags.MyCustomTagsContainer;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain = true)
public class MyStandardClass {
	private String cofVersion, id, name;
	private int responses, filtered;
	private Throwable error;

	public void incrementResponseCount() {
		responses++;
	}
	
	@MetricsTagProvider
	public MyCustomTagsContainer metricTags() {
		return MyCustomTagsContainer.wrap(new MyCustomTags(this)); 
	}
	
	@MetricValueProvider(type = StandardMetricType.EVENTS_PROCESSED)
	@MetricValueProvider(type = StandardMetricType.API_CALLS)
	public Double eventsProcessed() {
		return Double.valueOf(responses);
	}

	@MetricValueProvider(type = StandardMetricType.EVENTS_EXCLUDED, customGranularity = "source_ref_absent")
	public Double eventsExcluded() {
		return Double.valueOf(filtered);
	}
	
	@MetricValueProvider(type = StandardMetricType.EXCEPTION_COUNT)
	public Double metricValue() {
		return 1.0;
	}
}
