package com.compassion.commons.metrics;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.apache.commons.lang3.ArrayUtils;
import org.jooq.lambda.Seq;
import org.junit.jupiter.api.Test;

import com.compassion.commons.Documentation;
import com.compassion.commons.LambdaUtils;
import com.compassion.commons.Utilities;
import com.compassion.commons.Documentation.Doc;
import com.compassion.commons.Documentation.Produces;
import com.compassion.commons.Documentation.Requires;
import com.compassion.commons.metrics.MyCustomTags.MyCustomTagsContainer;
import com.datadog.api.client.v2.model.MetricIntakeType;
import com.datadog.api.client.v2.model.MetricPayload;
import com.datadog.api.client.v2.model.MetricPoint;
import com.datadog.api.client.v2.model.MetricSeries;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.val;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class TestDataDogTags {
	@Test
	public void testDataDogTags() {
		var ret = new MyStandardClass();
		ret.setCofVersion("abc");
		ret.setFiltered(4);
		ret.setId("12345");
		ret.setName("defg");
		ret.setResponses(80);
		var mapOf = new HashMap<StandardMetricType, DataDogTags>();
		for (var m : MyStandardClass.class.getDeclaredMethods()) {
			if (m == null) { continue; }
			var doc = Optional.ofNullable(m.getAnnotation(MetricsTagProvider.class));
			if (doc.isEmpty()) { continue; }
			var value = invokeClass(ret, m);
			if (value.isEmpty()) { continue; }
			var types = doc.get().types();
			types = ArrayUtils.isEmpty(types) ? StandardMetricType.values() : types;
			Arrays.asList(types).forEach($ -> mapOf.put($, value.get()));
		}
		System.out.println(mapOf);
		for (var m : MyStandardClass.class.getDeclaredMethods()) {
			if (m == null) { continue; }
			
			var doc = Optional.ofNullable(m.getAnnotation(MetricValueProviders.class));
			if (doc.isEmpty()) { continue; }
			var value = invoke(ret, m);
			for (var i : doc.get().value()) {
				var body = new MetricPayload(List.of(
		            new MetricSeries()
		                .metric(i.type().toString())
		                .type(MetricIntakeType.COUNT)
		                .tags(mapOf.get(i.type()).tagList())
		                .points(List.of(
		                    new MetricPoint()
		                        .timestamp(now())
		                        .value(value.get())))));
				System.out.println(body);
			}
			if (!doc.isPresent()) { continue; }
		}
		
		var custom = new MyCustomTags();
		custom.setEnvironment("DEVINT");
		custom.setHaveZildjians(true);
		custom.setVersion("1.2.3");
		
		assertEquals(List.of(
			"test_environment:DEVINT",
			"test_have_zildjians:true",
			"test_version:1.2.3"
		), MyCustomTagsContainer.wrap(custom).tagList());
	}
	
	private static Optional<Double> invoke(MyStandardClass ret, Method m) {
		try {
			return Utilities.cast(Optional.ofNullable(m.invoke(ret)));
		} catch (IllegalAccessException | InvocationTargetException e) {
			log.error(e);
			return Optional.empty();
		}
	}

	private static Optional<? extends DataDogTags> invokeClass(MyStandardClass ret, Method m) {
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
}
