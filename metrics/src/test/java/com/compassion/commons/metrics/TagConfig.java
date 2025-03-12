package com.compassion.commons.metrics;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter @Getter @Accessors(chain = true)
@NoArgsConstructor
public class TagConfig {

	private TagMappings tags = new TagMappings();
	
	@JsonPropertyOrder(alphabetic = true)
	@JsonNaming(SnakeCaseStrategy.class) @Data
	public static class TagMappings implements DataDogTags {
		private String testEnvironment;
		private boolean testHaveZildjians;
		private String testVersion;
		@Override public String appPrefix() { return "test"; }
	}
}
