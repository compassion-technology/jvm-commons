package com.compassion.commons.metrics;

public enum StandardMetricType {
	API_CALLS,
	EVENTS_EXCLUDED,
	EVENTS_PROCESSED,
	EXECUTION_TIME,
	EXCEPTION_COUNT;
	
	@Override
	public String toString() {
		return super.toString().toLowerCase();
	}
}
