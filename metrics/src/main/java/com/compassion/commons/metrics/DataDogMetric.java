package com.compassion.commons.metrics;

import java.util.List;

public interface DataDogMetric {
	String metricName();
	List<String> metricTags(String topic);
	Double metricValue();
}
