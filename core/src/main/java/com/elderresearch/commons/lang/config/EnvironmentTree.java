/* ©2020 Elder Research, Inc. All rights reserved. */
package com.elderresearch.commons.lang.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.elderresearch.commons.lang.Utilities;
import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.CaseFormat;

import lombok.val;

/**
 * This class reads values starting with a prefix from the current environment (including environment variables
 * via {@link System#getenv()} and system properties via {@link System#getProperties()}) and applies them to an
 * object via a {@link JsonNode} tree.
 * 
 * @author <a href="dimeo@elderresearch.com">John Dimeo</a>
 * @since Jun 13, 2020
 */
public class EnvironmentTree {
	public interface Environment {
		boolean isEmpty();
		void put(String path, String value);
		boolean has(String path);
		String get(String path);
	}
	
	public static class EnvironmentMap implements Environment {
		private Map<String, String> map = new HashMap<>();
		
		@Override public boolean isEmpty() { return map.isEmpty(); }
		@Override public boolean has(String path) { return map.containsKey(path); }
		@Override public String get(String path) { return map.get(path); }
		@Override public void put(String path, String value) { map.put(path, value); }
	}

	private final String prefix;
	private Environment environment;
	
	protected EnvironmentTree(String prefix) {
		this.prefix = StringUtils.lowerCase(prefix);
		this.environment = new EnvironmentMap();
	}
	
	public static EnvironmentTree forPrefix(String prefix) {
		return new EnvironmentTree(prefix);
	}
	
	public EnvironmentTree withImpl(Environment e) {
		this.environment = e;
		return this;
	}

	public EnvironmentTree addEnvironmentVariables() {
		System.getenv().forEach(this::add);
		return this;
	}
	
	public EnvironmentTree addSystemProperties() {
		System.getProperties().forEach((k, v) -> add(k.toString(), v.toString()));
		return this;
	}
	
	public void add(String path, String value) {
		if (StringUtils.startsWithIgnoreCase(path, prefix)) {
			val srcFmt = StringUtils.isAllUpperCase(StringUtils.replaceChars(path, "_- .", null))
				? CaseFormat.UPPER_UNDERSCORE : CaseFormat.LOWER_CAMEL;
			path = StringUtils.replaceChars(srcFmt.to(CaseFormat.LOWER_UNDERSCORE, path), "-.", "__");
			environment.put(StringUtils.removeStart(path, prefix), value);
		}
	}
	
	public <T> void applyOverrides(ObjectMapper om, T obj) throws IOException {
		if (environment.isEmpty()) { addEnvironmentVariables().addSystemProperties(); }
		
		val tree = om.valueToTree(obj);
		val trav = tree.traverse();
		while (!trav.isClosed()) {
			val fn = trav.nextFieldName();
			if (fn == null) { continue; }
			
			val path = trav.getParsingContext().pathAsPointer();
			val key = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE,
					path.toString().replace(JsonPointer.SEPARATOR, '_'));
			if (environment.has(key)) {
				ObjectNode n = Utilities.cast(tree.at(path));
				n.put(last(path), environment.get(key));
			}
		}
		
		om.readerForUpdating(obj).readValue(tree);
	}
	
	private static String last(JsonPointer p) {
		// p.last() is throwing an NPE :-/
		int i = p.toString().lastIndexOf(JsonPointer.SEPARATOR);
		return p.toString().substring(i + 1);
	}
}
