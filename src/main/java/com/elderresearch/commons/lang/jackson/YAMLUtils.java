/*******************************************************************************
 * Copyright (c) 2017 Elder Research, Inc.
 * All rights reserved.
 *******************************************************************************/
package com.elderresearch.commons.lang.jackson;

import org.yaml.snakeyaml.DumperOptions.LineBreak;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import lombok.AllArgsConstructor;

/**
 * Utilities for using Jackson and its {@link ObjectMapper} to use YAML.
 * 
 * @author <a href="mailto:dimeo@elderresearch.com">John Dimeo</a>
 * @since Nov 14, 2017
 */
@AllArgsConstructor
public class YAMLUtils {
	/**
	 * Gets an {@link ObjectMapper} configured to read and write YAML. When writing YAML, the mapper will use the
	 * default line breaks for the platform on which the code is running.
	 * @return a YAML-enabled object mapper
	 * @see LineBreak#getPlatformLineBreak()
	 */
	public YAMLMapper newMapper() {
		return newMapper(LineBreak.getPlatformLineBreak());
	}
	
	/**
	 * Gets an {@link ObjectMapper} configured to read and write YAML. When writing YAML, the mapper will use the
	 * specified line breaks.
	 * @param lineBreak the line breaks to use when writing YAML
	 * @return a YAML-enabled object mapper
	 */
	public YAMLMapper newMapper(LineBreak lineBreak) {
		return new YAMLMapper(new YAMLFactoryCustom(lineBreak));
	}
}
