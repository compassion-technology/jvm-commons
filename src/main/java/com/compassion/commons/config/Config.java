/* ©2020 Elder Research, Inc. All rights reserved. */
package com.compassion.commons.config;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Consumer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.compassion.commons.LambdaUtils.IOFunction;
import com.compassion.commons.jackson.YAMLUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

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
	 * @param <S> the stream type
	 * @param log the logger to use to log any errors/warnings
	 * @param path the path to resolve
	 * @param toStream the function that converts a path to either an input or output stream
	 * @return the stream with the contents of the path
	 * @see #resolveCodeDir(Logger, String, IOFunction)
	 * @see Files#newInputStream(Path, java.nio.file.OpenOption...)
	 * @see Files#newOutputStream(Path, java.nio.file.OpenOption...)
	 */
	default <S> S resolveCurrentDir(Logger log, String path, IOFunction<Path, S> toStream) {
		try {
			return toStream.apply(Paths.get(path));
		} catch (NoSuchFileException e) {
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
	 * this will fall back to {@link #resolveCurrentDir(Logger, String, IOFunction)}.
	 * @param <S> the stream type
	 * @param log the logger to use to log any errors/warnings
	 * @param path the path to resolve
	 * @param toStream the function that converts a path to either an input or output stream
	 * @return the stream with the contents of the path
	 * @see Files#newInputStream(Path, java.nio.file.OpenOption...)
	 * @see Files#newOutputStream(Path, java.nio.file.OpenOption...)
	 */
	default <S> S resolveCodeDir(Logger log, String path, IOFunction<Path, S> toStream) {
		try {
			// Try to load relative to the running .jar, not the current directory
			val jar = getClass().getProtectionDomain().getCodeSource().getLocation();
			Path p = Paths.get(jar.toURI());
			p = Files.isDirectory(p) ? p : p.getParent();
			return toStream.apply(p.resolve(path));
		} catch (URISyntaxException | SecurityException | IOException e) {
			if(!(e instanceof NoSuchFileException)) {
				log.warn("Error locating executable; using current directory instead", e);
			}
			return resolveCurrentDir(log, path, toStream);
		}
	}
	
	/**
	 * Loads a configuration file into this object, merging/overriding values that have already been defined
	 * (or overriding the defaults declared in the bean itself). This can be used to load multiple files into
	 * the same object, but using this method is optional.
	 * @param log the logger to use to log any errors/warnings
	 * @param om the object mapper to use (usually a YAML mapper via {@link YAMLUtils#newMapper()})
	 * @param stream the stream to load (can be {@code null})
	 * @see #load(Logger, ObjectMapper, Config, ConfigOverrides, String...)
	 * @see #resolveCodeDir(Logger, String, IOFunction)
	 * @see #resolveCurrentDir(Logger, String, IOFunction)
	 */
	default void merge(Logger log, ObjectMapper om, InputStream stream) {
		try {
			if (stream != null) { om.readerForUpdating(this).readValue(stream); }
		} catch (IOException e) {
			log.warn("Error loading configuration", e);
		}
	}
	
	/**
	 * Recurse through configurations that have other {@link Config} instances as child beans,
	 * invoking the callback for each. The default implementation is a no-op.
	 * @param callback the callback to invoke for each child configuration bean in this bean
	 */
	default void forEachChild(Consumer<Config> callback) {
		// No-op by default
	}
	
	/**
	 * Subclasses can do post-processing here after a configuration is initialized, like decrypting sensitive data.
	 * @param om the object mapper to use (usually a YAML mapper via {@link YAMLUtils#newMapper()})
	 */
	default Config postProcess(ObjectMapper om) {
		// Now post process any children
		forEachChild($ -> $.postProcess(om));
		return this;
	}

    /**
     * @param om the object mapper with custom mixins to affect only the log
     */
	default void logConfig(ObjectMapper om) {
        val log = LogManager.getLogger(getClass());
        try {
            log.info("Configuration:{}{}", System.lineSeparator(),
                    om.writerWithDefaultPrettyPrinter().writeValueAsString(this));
        } catch (IOException e) {
            log.warn("Couldn't print configuration", e);
        }
    }

	/**
	 * Saves this configuration to the specified output stream.
	 * @param log the logger to use to log any errors/warnings
	 * @param ow the object writer to use
	 * @param os the stream to write the configuration
	 */
	default void save(Logger log, ObjectWriter ow, OutputStream os) {
		try {
			ow.writeValue(os, this);
		} catch (IOException e) {
			log.warn("Error writing configuration", e);
		}
	}
	
	/**
	 * An "all-in-one" configuration loader.
	 * @param <C> the configuration type
	 * @param log the logger to use to log any errors/warnings
	 * @param om the object mapper to use (usually a YAML mapper via {@link YAMLUtils#newMapper()})
	 * @param conf the blank/initial configuration object
	 * @param env the environment values that should override the config, including environment variables and system
	 * properties that should override the defaults and configuration loaded from the file (can be {@code null}). If
	 * no environment values have been added to the specified tree, environment variables and system properties matching
	 * the prefix will be automatically loaded (with system properties taking precedence).
     * @param paths zero or more paths (<em>relative to the executing code</em>, not the current directory)
	 * specifying files to load
	 * @return the configuration object {@code defConfig} after it has been loaded
	 * @see #resolveCodeDir(Logger, String, IOFunction)
	 */
	static <C extends Config> C load(Logger log, ObjectMapper om, C conf, ConfigOverrides env, String... paths) {
		for (val path : paths) {
			conf.merge(log, om, conf.resolveCodeDir(log, path, Files::newInputStream));
		}
		
		if (env != null) {
			try {
				conf = env.applyOverrides(om, conf);
			} catch (IOException e) {
				log.warn("Error applying environment overrides", e);
			}
		}
		conf.postProcess(om);
		return conf;
	}
}
