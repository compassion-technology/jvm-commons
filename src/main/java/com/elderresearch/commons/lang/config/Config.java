/* ©2020 Elder Research, Inc. All rights reserved. */
package com.elderresearch.commons.lang.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.logging.log4j.Logger;

import com.elderresearch.commons.lang.LambdaUtils;
import com.elderresearch.commons.lang.jackson.YAMLUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.val;

/**
 * An interface from which configuration beans can extend. This interface facilitates convenient:<ul>
 * <li>Loading/merging multiple files (YAML, Jackson, XML, etc. via an {@link ObjectMapper})</li>
 * <li>Overriding values with environment variables and system properties</li>
 * <li>Post-processing (like decrypting a hashed password)</li></ul>
 * 
 * @author <a href="dimeo@elderresearch.com">John Dimeo</a>
 * @since Jul 9, 2020
 */
public interface Config {
	/**
	 * Resolve the path against the current working directory. This will silently return {@code null} if
	 * the file is not found but will log the error if it is any other kind of {@link IOException}.
	 * @param log the logger to use to log any errors/warnings
	 * @param path the path to resolve
	 * @return the input stream with the contents of the path
	 * @see Files#newInputStream(Path, java.nio.file.OpenOption...)
	 * @see #resolveCodeDir(Logger, String)
	 */
	default InputStream resolveCurrentDir(Logger log, String path) {
		try {
			return Files.newInputStream(Paths.get(path));
		} catch (FileNotFoundException e) {
			// This is an expected situation when the user wants to use only defaults
			return null;
		} catch (IOException e) {
			log.warn("Error resolving path {}", path, e);
			return null;
		}
	}
	
	/**
	 * Resolve the path against the location where the code is installed/running and stream the contents.
	 * This allows users to place configuration files next to the executable and not have to worry about
	 * specifying a relative or absolute path from their current working directory. If resolution fails,
	 * this will fall back to {@link #resolveCurrentDir(Logger, String)}.
	 * @param log the logger to use to log any errors/warnings
	 * @param path the path to resolve
	 * @return the input stream with the contents of the path
	 */
	default InputStream resolveCodeDir(Logger log, String path) {
		try {
			// Try to load relative to the running .jar, not the current directory
			val jar = getClass().getProtectionDomain().getCodeSource().getLocation();
			return Files.newInputStream(Paths.get(jar.toURI()));
		} catch (URISyntaxException | SecurityException | IOException e) {
			log.warn("Error locating executable; using current directory to look for config file", e);
			return resolveCurrentDir(log, path);
		}
	}
	
	/**
	 * Loads a configuration file into this object, merging/overriding values that have already been defined
	 * (or overriding the defaults declared in the bean itself). This can be used to load multiple files into
	 * the same object, but using this method is optional.
	 * @param log the logger to use to log any errors/warnings
	 * @param om the object mapper to use (usually a YAML mapper via {@link YAMLUtils#newMapper()})
	 * @param stream the stream to load (can be {@code null})
	 * @see #load(Logger, ObjectMapper, InputStream, EnvironmentTree)
	 * @see #resolveCodeDir(Logger, String)
	 * @see #resolveCurrentDir(Logger, String)
	 */
	default void merge(Logger log, ObjectMapper om, InputStream stream) {
		try {
			if (stream != null) { om.readerForUpdating(this).readValue(stream); }
		} catch (IOException e) {
			log.warn("Error loading configuration", e);
		}
	}
	
	/**
	 * Loads a configuration file into this object, merging/overriding values that have already been defined
	 * (or overriding the defaults declared in the bean itself), as well as applying any overrides from the
	 * environment. Finally, this method will call {@link #postProcess()} before returning.
	 * @param log the logger to use to log any errors/warnings
	 * @param om the object mapper to use (usually a YAML mapper via {@link YAMLUtils#newMapper()})
	 * @param stream the stream to load (can be {@code null})
	 * @param env the environment to override specifying the prefix (can be {@code null})
	 * @see #resolveCodeDir(Logger, String)
	 * @see #resolveCurrentDir(Logger, String)
	 */
	default void load(Logger log, ObjectMapper om, InputStream stream, EnvironmentTree env) {
		merge(log, om, stream);
		
		try {
			if (env != null) { env.applyOverrides(om, this); }
		} catch (IOException e) {
			log.warn("Error applying environment overrides", e);
		}
		
		postProcess(log, om);
	}
	
	/**
	 * Subclasses can do post-processing here after a configuration is initialized, like decrypting sensitive data.
	 * The default implementation of this method is to log the current configuration.
	 * @param log the logger to use to log any errors/warnings
	 * @param m the object mapper to use (usually a YAML mapper via {@link YAMLUtils#newMapper()})
	 */
	default void postProcess(Logger log, ObjectMapper om) {
		try {
			log.info("Configuration:{}{}", System.lineSeparator(),
				om.writerWithDefaultPrettyPrinter().writeValueAsString(this));
		} catch (IOException e) {
			log.warn("Couldn't print configuration", e);
		}
	}
	
	/**
	 * An "all-in-one" configuration loader.
	 * @param <C> the configuration type
	 * @param log the logger to use to log any errors/warnings
	 * @param om the object mapper to use (usually a YAML mapper via {@link YAMLUtils#newMapper()})
	 * @param defConfig the blank/initial configuration object
	 * @param envPrefix the prefix for environment variables and system properties that should override
	 * configuration values (if this is {@code null}, the environment will not be checked). System properties
	 * take precedent over environment variables.
	 * @param paths zero or more paths (<em>relative to the executing code</em>, not the current directory)
	 * specifying files to load
	 * @return the configuration object {@code defConfig} after it has been loaded
	 * @see #resolveCodeDir(Logger, String)
	 */
	static <C extends Config> C load(Logger log, ObjectMapper om, C defConfig, String envPrefix, String... paths) {
		for (val path : paths) {
			defConfig.merge(log, om, defConfig.resolveCodeDir(log, path));
		}
		
		val env = LambdaUtils.apply(envPrefix, $ -> EnvironmentTree.forPrefix($)
			.addEnvironmentVariables().addSystemProperties());
		
		defConfig.load(log, om, null, env);
		return defConfig;
	}
}
