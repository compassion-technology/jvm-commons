/*******************************************************************************
 * Copyright (c) 2017 Elder Research, Inc.
 * All rights reserved.
 *******************************************************************************/
package com.elderresearch.commons.lang.jackson;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.yaml.snakeyaml.DumperOptions.LineBreak;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import lombok.val;
import lombok.experimental.UtilityClass;
import lombok.extern.log4j.Log4j2;

/**
 * Utilities for using Jackson and its {@link ObjectMapper} to use YAML.
 * 
 * @author <a href="mailto:dimeo@elderresearch.com">John Dimeo</a>
 * @since Nov 14, 2017
 */
@Log4j2
@UtilityClass
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
	
	/**
	 * Loads a YAML configuration file, applying any overrides from the environment.
	 * This looks for the named file relative to the executing code, not the current directory.
	 * @param <T> the type of the configuration object
	 * @param m the object mapper to use (usually a YAML mapper via {@link #newMapper())
	 * @param c the class of the configuration object. This class must have a default/no-arg constructor.
	 * @param fileName the expected file name (for example {@code file.yaml})
	 * @param env the environment to override specifying the prefix
	 * @return the loaded configuration object or a default instance if there was a problem
	 * loading the configuration from the file.
	 */
	public <T> T loadConfig(ObjectMapper m, Class<T> c, String fileName, EnvironmentTree env) {
		Path file;
		try {
			// Try to load relative to the running .jar, not the current directory
			val jar = c.getProtectionDomain().getCodeSource().getLocation();
			val jarParent = Paths.get(jar.toURI()).getParent();
			file = jarParent.resolve(fileName);
		} catch (URISyntaxException | SecurityException e) {
			log.warn("Error locating executable; using current directory to look for config file", e);
			file = Paths.get(fileName);
		}
		
		T ret;
		try {
			ret = m.readValue(file.toFile(), c);
		} catch (IOException e) {
			try {
				ret = c.newInstance();
			} catch (InstantiationException | IllegalAccessException e1) {
				throw new IllegalArgumentException("The configuration class " + c + " must have a default constructor");
			}
		}
		
		try {
			return env.applyOverrides(m, ret);
		} catch (IOException e) {
			log.warn("Error applying environment overrides", e);
			return ret;
		}
	}
}
