package com.compassion.commons.metrics;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.jooq.lambda.Seq;

import com.compassion.commons.Utilities;
import com.compassion.commons.metrics.MetricValueProviders.MetricValueProvider;
import com.datadog.api.client.v2.model.MetricPayload;
import com.datadog.api.client.v2.model.MetricPoint;
import com.datadog.api.client.v2.model.MetricSeries;

import lombok.extern.log4j.Log4j2;

@Log4j2
public abstract class MetricValueBuilder {
	
	public static MetricPayload with(Object base) {
		var payload = new MetricPayload(new ArrayList<>());
		var mapOf   = new HashMap<StandardMetricType, DataDogTags>();
		
		for (var m : base.getClass().getDeclaredMethods()) {
			var doc = Optional.ofNullable(m.getAnnotation(MetricsTagProvider.class));
			if (doc.isEmpty()) { continue; }
			var value = invokeClass(base, m);
			if (value.isEmpty()) { continue; }
			var types = doc.get().types();
			types = ArrayUtils.isEmpty(types) ? StandardMetricType.values() : types;
			Arrays.asList(types).forEach($ -> mapOf.put($, value.get()));
		}
		
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
					var tagProv = mapOf.get(i.type());
					payload.addSeriesItem(
						new MetricSeries()
			                .metric(appPrefix(tagProv.appPrefix(), i.type().toString()))
			                .type(i.type().getIntakeType())
			                .tags(mapOf.get(i.type()).tagList())
			                .points(List.of(
			                    new MetricPoint()
			                        .timestamp(now())
			                        .value(n.doubleValue()))));
				});	
			}
		}
		return payload;
	}
	
	private static Optional<? extends DataDogTags> invokeClass(Object ret, Method m) {
		try {
			var r = Optional.ofNullable(m.invoke(ret));
			if (DataDogTags.class.isAssignableFrom(r.get().getClass())) {
				return Utilities.cast(r);
			}
		} catch (IllegalAccessException | InvocationTargetException e) {
			log.error(e);
		}
		return Optional.empty();
	}
	
	private static long now() {
		return OffsetDateTime.now(ZoneOffset.UTC).toInstant().getEpochSecond();
	}
	
	private static String appPrefix(String pref, String metricName) {
		return StringUtils.joinWith(".", pref, metricName);
	}
}
