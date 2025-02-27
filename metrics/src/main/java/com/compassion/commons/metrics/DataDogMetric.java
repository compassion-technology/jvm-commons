package com.compassion.commons.metrics;

import java.util.List;

public interface DataDogMetric {
	public abstract String metricName();
	public abstract List<String> metricTags();
	public abstract Double metricValue();
}
