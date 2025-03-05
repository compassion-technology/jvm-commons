package com.compassion.commons.metrics;

import com.compassion.commons.LambdaUtils;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter @Getter
@JsonPropertyOrder(alphabetic = true)
@JsonNaming(SnakeCaseStrategy.class) @NoArgsConstructor
public class MyCustomTags {
	private String environment;
	private boolean haveZildjians;
	private String version;
	
	
	public MyCustomTags(MyStandardClass base) {
		LambdaUtils.accept(base.getName(),       this::setEnvironment);
		LambdaUtils.accept(base.getCofVersion(), this::setVersion);
	}
	
	@RequiredArgsConstructor(staticName = "wrap")
	public static class MyCustomTagsContainer implements DataDogTags {
		@JsonUnwrapped(prefix = "test_")
		private final MyCustomTags container;
	}
}
