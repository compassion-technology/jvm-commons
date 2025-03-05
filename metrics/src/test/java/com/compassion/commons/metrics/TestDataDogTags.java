package com.compassion.commons.metrics;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.compassion.commons.metrics.MyCustomTags.MyCustomTagsContainer;

public class TestDataDogTags {
	@Test
	public void testDataDogTags() {
		var ret = new MyStandardClass();
		ret.setCofVersion("abc");
		ret.setFiltered(4);
		ret.setId("12345");
		ret.setName("defg");
		ret.setResponses(80);
		System.out.println(MetricValueBuilder.with(ret));
		
		
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
}
