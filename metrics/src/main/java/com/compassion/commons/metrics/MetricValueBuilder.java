package com.compassion.commons.metrics;

import java.lang.reflect.InvocationTargetException;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.jooq.lambda.Seq;

import com.compassion.commons.metrics.MetricValueProviders.MetricValueProvider;
import com.datadog.api.client.v2.model.MetricPayload;
import com.datadog.api.client.v2.model.MetricPoint;
import com.datadog.api.client.v2.model.MetricSeries;

import lombok.extern.log4j.Log4j2;

@Log4j2
public abstract class MetricValueBuilder {
	
	public static MetricPayload with(Object base, DataDogTags tags) {
		var payload = new MetricPayload(new ArrayList<>());
		
		for (var m : base.getClass().getDeclaredMethods()) {
			var prov = Seq.of(m.getDeclaredAnnotation(MetricValueProviders.class))
				.filter(Objects::nonNull)
				.flatMap($ -> Seq.of($.value()))
				.append(m.getDeclaredAnnotation(MetricValueProvider.class))
				.filter(Objects::nonNull)
				.toList();
			if (prov.isEmpty()) { continue; }
			
			Object value;
			try {
				value = MethodUtils.invokeMethod(base, m.getName());
			} catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
				log.warn("Error accessing metric value on {}", base, e);
				continue;
			}
			
			if (value instanceof Number n) {
				prov.forEach(i -> {
					payload.addSeriesItem(
						new MetricSeries()
			                .metric(appPrefix(tags.appPrefix(), i.type().toString(), i.customGranularity()))
			                .type(i.type().getIntakeType())
			                .tags(tags.tagList())
			                .points(List.of(
			                    new MetricPoint()
			                        .timestamp(now())
			                        .value(n.doubleValue()))));
				});	
			}
		}
		return payload;
	}
	
	private static long now() {
		return OffsetDateTime.now(ZoneOffset.UTC).toInstant().getEpochSecond();
	}
	
	private static String appPrefix(String pref, String metricName, String subMetric) {
		return StringUtils.removeEnd(StringUtils.joinWith(".", pref, metricName, subMetric), ".");
	}
}
