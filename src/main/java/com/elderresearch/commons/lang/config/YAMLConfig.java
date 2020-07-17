/* ©2020 Elder Research, Inc. All rights reserved. */
package com.elderresearch.commons.lang.config;

import java.nio.file.Files;

import com.elderresearch.commons.lang.jackson.YAMLUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class YAMLConfig implements Config {
	@Getter
	private static final ObjectMapper mapper = YAMLUtils.newMapper().setDefaultMergeable(true);
	
	/**
	 * Load configuration from the environment and optionally YAML files.
	 * @param envPrefix the prefix for environment variables and system properties that should override
	 * configuration values (if this is {@code null}, the environment will not be checked). System properties
	 * take precedent over environment variables.
     * @param logConfig whether or not to log the configuration tree after all loading/merging has occurred and
     * environment overrides have been applied
	 * @param paths zero or more paths (<em>relative to the executing code</em>, not the current directory)
	 * specifying files to load
	 * @see Config#load(org.apache.logging.log4j.Logger, ObjectMapper, Config, String, String...)
	 */
	public void load(String envPrefix, boolean logConfig, String... paths) {
		Config.load(log, mapper, this, envPrefix, logConfig, paths);
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
