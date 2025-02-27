package com.compassion.commons.metrics;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter @Getter
@JsonPropertyOrder(alphabetic = true)
@JsonNaming(SnakeCaseStrategy.class)
public class MyCustomTags {
	private String environment;
	private boolean haveZildjians;
	private String version;
	
	@RequiredArgsConstructor(staticName = "wrap")
	public static class MyCustomTagsContainer implements DataDogTags {
		@JsonUnwrapped(prefix = "test_")
		private final MyCustomTags container;
	}
}
