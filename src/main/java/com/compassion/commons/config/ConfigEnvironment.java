package com.compassion.commons.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.CaseFormat;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.Delegate;

/**
 * An environment that provides overrides for configuration items.
 * The simplest form is a key-value map that comes from environment variables
 * but implementations can also integrate with more complex environments
 * like cloud based credential management tools.
 * 
 * @author <a href="mailto:jdimeo@us.ci.org">John Dimeo</a>
 */
public interface ConfigEnvironment extends AutoCloseable {
	/**
	 * Whether or not this environment have an override for the specified path.
	 * This is a separate step to avoid expensive calls to retrieve the value
	 * if none exists at the path.
	 * @param path the path to lookup
	 * @param existing the current value in the JSON or YAML configuration
	 * in case that is needed to determine if this environment has an
	 * override for the value
	 * @return if the key exists in the environment
	 */
	boolean has(String path, JsonNode existing);
	
	/**
	 * Retrieve the value for the configuration at the specified path for this
	 * environment. This method will only be called for paths where {@link #has(String, JsonNode)}
	 * returned {@code true}.
	 * @param path the path to lookup
	 * @param existing the current value in the JSON or YAML configuration
	 * in case that is needed to determine if this environment has an
	 * override for the value
	 * @return the configuration value at the path in this environment
	 */
	String get(String path, JsonNode existing);
	
	/**
	 * When constructing paths, the case format this environment uses. For example, environment
	 * variables use {@link CaseFormat#UPPER_UNDERSCORE} but system properties typically use
	 * {@link CaseFormat#LOWER_CAMEL}.
	 * @return the case format for this environment. The default is {@link CaseFormat#LOWER_CAMEL}.
	 */
	default CaseFormat pathFormat() {
		return CaseFormat.LOWER_CAMEL;
	}
	
	/**
	 * When constructing paths, the path separator this environment uses. For example, environment
	 * variables use an underscore {@code _} and AWS parameters use slash {@code /}.
	 * @return the path separator this environment. The default is {@value JsonPointer#SEPARATOR}.
	 */
	default char pathSeparator() {
		return JsonPointer.SEPARATOR;
	}
	
	@Override
	default void close() throws IOException {
		// Nothing to close by default
	}
	
	/**
	 * A config environment that can be used as a lambda. The path is assumed to be {@link CaseFormat#LOWER_CAMEL}
	 * with the default separator and {@link #has(String, JsonNode)} returns {@code true} if
	 * {@link #get(String, JsonNode)} returns a non-{@code null} value.
	 */
	interface ConfigEnvironmentFn extends ConfigEnvironment {
		@Override
		default boolean has(String path, JsonNode existing) { return get(path, existing) != null; }
	}
	
	/**
	 * A default implementation of a configuration environment storing keys and values.
	 */
	@RequiredArgsConstructor
	@Accessors(fluent = true)
	class ConfigEnvironmentMap implements ConfigEnvironment, Map<String, String> {
		@Getter
		private final char pathSeparator;
		@Getter
		private final CaseFormat pathFormat;
		@Delegate
		private final Map<String, String> map = new HashMap<>();
		
		@Override public boolean has(String path, JsonNode existing) { return map.containsKey(path); }
		@Override public String get(String path, JsonNode existing) { return map.get(path); }
	}
	
	/**
	 * A configuration environment that represents a partial configuration tree loaded from a 
	 * JSON, YAML, or other file that should be merged into a base configuration. 
	 */
	@RequiredArgsConstructor
	class PartialConfiguration implements ConfigEnvironment {
		private final JsonNode tree;
		
		@Override
		public boolean has(String path, JsonNode existing) {
			var node = tree.at(removePrefix(path));
			return (node.isValueNode() || node.isArray()) && !node.isNull();
		}
		
		@Override
		public String get(String path, JsonNode existing) {
			return tree.at(removePrefix(path)).asText();
		}
		
		private static String removePrefix(String path) {
			int i = path.indexOf(JsonPointer.SEPARATOR);
			return i < 0? path : path.substring(i);
		}
	}
}
