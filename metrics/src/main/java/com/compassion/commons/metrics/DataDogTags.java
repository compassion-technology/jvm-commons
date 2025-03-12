package com.compassion.commons.metrics;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

@JsonPropertyOrder(alphabetic = true)
@JsonNaming(SnakeCaseStrategy.class)
public interface DataDogTags {
	static ObjectMapper mapper = new YAMLMapper()
		.configure(YAMLGenerator.Feature.USE_PLATFORM_LINE_BREAKS, false)
		.configure(YAMLGenerator.Feature.WRITE_DOC_START_MARKER, false)
		.configure(YAMLGenerator.Feature.MINIMIZE_QUOTES, true)
		.setSerializationInclusion(Include.NON_EMPTY);
	
	default List<String> tagList() {
		try {
			return List.of(StringUtils.split(mapper.writeValueAsString(this).replace(": ", ":"), '\n'));
		} catch (JsonProcessingException e) {
			throw new IllegalStateException("Cannot serialize DataDog tags", e);
		}
	}
	
	String appPrefix();
}
