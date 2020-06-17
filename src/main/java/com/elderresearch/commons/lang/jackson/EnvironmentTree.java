package com.elderresearch.commons.lang.jackson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import lombok.val;

/**
 * This class creates a {@link JsonNode} tree from the current environment (including environment variables
 * via {@link System#getenv()} and system properties via {@link System#getProperties()}). This allows values
 * in the environment to override values in a configuration object.
 * 
 * @author <a href="dimeo@elderresearch.com">John Dimeo</a>
 * @since Jun 13, 2020
 */
public class EnvironmentTree {
	private final String prefix;
	private final ObjectNode root;
	
	private Map<String, String> environment;
	
	public EnvironmentTree(String prefix) {
		this.prefix = prefix;
		this.environment = new HashMap<>();
		this.root = JsonNodeFactory.instance.objectNode();
	}

	public EnvironmentTree addEnvironmentVariables() {
		System.getenv().forEach(this::add);
		return this;
	}
	
	public EnvironmentTree addSystemProperties() {
		System.getProperties().forEach((k, v) -> add(k.toString(), v.toString()));
		return this;
	}
	
	public <T> T applyOverrides(ObjectMapper om, T obj) throws IOException {
		JsonNode tree = om.valueToTree(obj);
		
		val trav = tree.traverse();
		while (!trav.isClosed()) {
			
			
			val fn = trav.nextFieldName();
			if (fn != null) { System.out.println(trav.getParsingContext().pathAsPointer()); }
		}
		
		return om.readerForUpdating(obj)
			.without(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
			.with(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES)
			.readValue(root);
	}
	
	private void add(String path, String value) {
		path = StringUtils.removeStart(path, prefix);
		
		String[] pathArr;
		if (StringUtils.contains(path, ".")) {
			pathArr = StringUtils.split(path, ". ");
		} else {
			pathArr = StringUtils.split(path, "_- ");
		}
		
		// Create intermediary objects
		ObjectNode o = root;
		for (int i = 0; i < pathArr.length - 1; i++) {
			JsonNode child = o.get(pathArr[i]);
			if (child == null) {
				child = JsonNodeFactory.instance.objectNode();
				o.set(pathArr[i], child);
			}
			try {
				o = (ObjectNode) child;
			} catch (ClassCastException e) {
				System.err.println(path);
			}
		}
		
		o.put(pathArr[pathArr.length - 1], value);
		
		// Also set the original/full path in case intermediate objects wasn't intended
		root.put(path, value);
	}
}
