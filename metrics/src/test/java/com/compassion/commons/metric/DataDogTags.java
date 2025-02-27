package com.compassion.commons.metric;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

public interface DataDogTags {
	static YAMLMapper mapper = new YAMLMapper()
		.configure(YAMLGenerator.Feature.USE_PLATFORM_LINE_BREAKS, false)
		.configure(YAMLGenerator.Feature.WRITE_DOC_START_MARKER, false)
		.configure(YAMLGenerator.Feature.MINIMIZE_QUOTES, true);

	default List<String> tagList() {
		try {
			return List.of(StringUtils.split(mapper.writeValueAsString(this), '\n'));
		} catch (JsonProcessingException e) {
			throw new IllegalStateException("Cannot serialize DataDog tags", e);
		}
	}
}
