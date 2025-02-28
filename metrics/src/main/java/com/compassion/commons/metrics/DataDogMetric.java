package com.compassion.commons.metrics;

public interface DataDogMetric {
	/**
	 * Name of the primary metric implemented.
	 */
	String metricName();
	
	/**
	 * Name of the metric implemented for error states.
	 */
	String errorMetricName();
	
	/**
	 * Metric value to be returned for the primary metric.
	 */
	Double metricValue();
}
