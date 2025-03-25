package com.compassion.commons.metrics;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter @Getter @Accessors(chain = true)
@NoArgsConstructor
public class TagConfig {

	private TagMappings tags = new TagMappings();
	
	@Data
	public static class TagMappings implements DataDogTags {
		private String testEnvironment;
		private boolean testHaveZildjians;
		private String testVersion;
		@Override public String appPrefix() { return "test"; }
	}
}
