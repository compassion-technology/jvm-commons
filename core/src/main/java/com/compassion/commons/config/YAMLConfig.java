/* ©2020 Elder Research, Inc. All rights reserved. */
package com.compassion.commons.config;

import java.io.IOException;
import java.nio.file.Files;

import com.compassion.commons.Utilities;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class YAMLConfig implements Config {
	@Getter
	private static final ObjectMapper mapper = new YAMLMapper()
		.enable(YAMLGenerator.Feature.USE_PLATFORM_LINE_BREAKS)
		.setDefaultMergeable(true);
	
	/**
	 * Load configuration from the environment and optionally YAML files.
	 * @param env the environment values that should override the config, including environment variables and system
	 * properties that should override the defaults and configuration loaded from the file (can be {@code null}).
     * @param paths zero or more paths (<em>relative to the executing code</em>, not the current directory)
	 * specifying files to load
	 * @throws IOException if there was an error reading the configuration from the stream 
	 * @see Config#load(org.apache.logging.log4j.Logger, ObjectMapper, Config, ConfigOverrides, String...)
	 */
	public <C extends YAMLConfig> C load(ConfigOverrides env, String... paths) throws IOException {
		return Utilities.cast(Config.load(log, mapper, this, env, paths));
	}
	
    /**
     * Saves this configuration to the YAML file.
     * @param path the path (<em>relative to the executing code</em>, not the current directory) to which
     * to save the configuration 
     */
    public void save(String path) {
    	save(log, mapper.writer().with(YAMLGenerator.Feature.MINIMIZE_QUOTES),
    		resolveCodeDir(log, path, Files::newOutputStream));
    }
}
