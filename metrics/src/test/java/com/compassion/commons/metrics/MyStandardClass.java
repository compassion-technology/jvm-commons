package com.compassion.commons.metrics;

import com.compassion.commons.metrics.MyCustomTags.MyCustomTagsContainer;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain = true)
@MetricProvider(types = { StandardMetricType.EVENTS_EXCLUDED, StandardMetricType.EVENTS_PROCESSED, StandardMetricType.EXCEPTION_COUNT },
	tagProvider = MyCustomTagsContainer.class )
public class MyStandardClass {
	private String cofVersion, id, name;
	private int responses, filtered;
	private Throwable error;

	public void incrementResponseCount() {
		responses++;
	}
	
	@JsonIgnore @MetricValueProvider(types = StandardMetricType.EVENTS_PROCESSED)
	public Double eventsProcessed() {
		return Double.valueOf(responses);
	}

	@JsonIgnore @MetricValueProvider(types = StandardMetricType.EVENTS_EXCLUDED)
	public Double eventsExcluded() {
		return Double.valueOf(filtered);
	}
	
	@JsonIgnore @MetricValueProvider(types = StandardMetricType.EXCEPTION_COUNT)
	public Double metricValue() {
		return 1.0;
	}
}
