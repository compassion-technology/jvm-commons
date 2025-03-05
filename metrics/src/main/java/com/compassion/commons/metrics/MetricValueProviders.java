package com.compassion.commons.metrics;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.apache.commons.lang3.StringUtils;

@Retention(RUNTIME)
@Target(ElementType.METHOD) 
@interface MetricValueProviders {
	MetricValueProvider[] value();
	
	@Retention(RUNTIME)
	@Target(ElementType.METHOD) 
	@Repeatable(MetricValueProviders.class)
	public @interface MetricValueProvider {
		StandardMetricType type();
		/**
		 * Define a custom granularity for this metric type, such as Events Excluded broken
		 * down by reasons: `duplicate`, `absent_source_ref`.
		 */
		String customGranularity() default StringUtils.EMPTY;
	}
}
