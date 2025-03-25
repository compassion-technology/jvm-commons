package com.compassion.commons.metrics;

import com.datadog.api.client.v2.model.MetricIntakeType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor
public enum StandardMetricType {
	API_CALLS,
	EVENTS_EXCLUDED,
	EVENTS_PROCESSED,
	EXECUTION_TIME,
	EXCEPTION_COUNT(MetricIntakeType.GAUGE);
	
	@Getter private MetricIntakeType intakeType = MetricIntakeType.COUNT;
	
	@Override
	public String toString() {
		return super.toString().toLowerCase();
	}
}
