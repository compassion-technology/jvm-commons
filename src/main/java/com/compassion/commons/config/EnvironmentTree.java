/* ©2020 Elder Research, Inc. All rights reserved. */
package com.compassion.commons.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

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
	public interface Environment extends AutoCloseable {
		boolean has(String path);
		String get(String path);
		
		default CaseFormat pathFormat() {
			return CaseFormat.LOWER_UNDERSCORE;
		}
		
		default char pathSeparator() {
			return JsonPointer.SEPARATOR;
		}
		
		@Override
		default void close() throws IOException {
			// Nothing to close by default
		}
	}

	public class EnvironmentMap implements Environment {
		private Map<String, String> map = new HashMap<>();
		
		@Override public boolean has(String path) { return map.containsKey(path); }
		@Override public String get(String path) { return map.get(path); }
		
		public EnvironmentMap put(String path, String value) {
	        if (StringUtils.startsWithIgnoreCase(path, prefix)) {
	        	map.put(normalizePath(path), value);
	        }
	        return this;
		}
		
		@Override
		public char pathSeparator() { return '_'; }
	}

	protected final String prefix;
	private List<Environment> environments;
	
	protected EnvironmentTree(String prefix) {
		this.prefix = StringUtils.lowerCase(prefix);
		this.environments = new LinkedList<>();
	}
	
	public static EnvironmentTree forPrefix(String prefix) {
		return new EnvironmentTree(prefix);
	}
	
	public EnvironmentTree with(Environment e) {
		this.environments.add(e);
		return this;
	}

	public EnvironmentTree withEnvironmentVariables() {
		val e = new EnvironmentMap();
		System.getenv().forEach(e::put);
		return with(e);
	}
	
	public EnvironmentTree withSystemProperties() {
		val e = new EnvironmentMap();
		System.getProperties().forEach((k, v) -> e.put(k.toString(), v.toString()));
		return with(e);
	}

    /**
     * Override a config object (usually) in the order that they've been added using {@link #with(Environment)},
     * {@link #withEnvironmentVariables()}, or {@link #withSystemProperties()}. this allows you to access overridden
     * properties from previous environments specified with {@link #with(Environment)}.
     * @param om the ObjectMapper that reads from the environments
     * @param obj the POJO object that we will override
     * @throws IOException
     */
	public <T> void applyOverrides(ObjectMapper om, T obj) throws IOException {
        var tree = om.valueToTree(obj);
        var trav = tree.traverse();
        while (!trav.isClosed()) {
            var fn = trav.nextFieldName();
            if (fn == null) { continue; }
            
            var path = trav.getParsingContext().pathAsPointer();
            nextNode(path, tree.at(path));
            
            var node = tree.at(path.head());
            if (!node.isObject()) { continue; }
            
            var objNode = (ObjectNode) node;
            var prop = last(path);
            
            for (val env : environments) {
	            val key = prefix + CaseFormat.LOWER_CAMEL.to(env.pathFormat(),
	                    path.toString().replace(JsonPointer.SEPARATOR, env.pathSeparator()));
	            if (env.has(key)) {
                    objNode.put(prop, env.get(key));	
	            }
            }
            
            objNode.replace(prop, customOverride(path, objNode.get(prop)));
        }
        om.readerForUpdating(obj).readValue(tree);
		
		for (val env : environments) { env.close(); }
	}
	
	protected void nextNode(JsonPointer path, JsonNode node) {
		// Extension point
	}
	
	@SuppressWarnings("unused")
	protected JsonNode customOverride(JsonPointer path, JsonNode node) throws IOException {
		return node;
	}
	
	private static String last(JsonPointer p) {
		// p.last() throws NPE or ConcurrentException or is wrong
		int i = p.toString().lastIndexOf(JsonPointer.SEPARATOR);
		return p.toString().substring(i + 1);
	}
			
	
	public String normalizePath(String path) {
		val srcFmt = path.chars().anyMatch(Character::isLowerCase)? CaseFormat.LOWER_CAMEL : CaseFormat.UPPER_UNDERSCORE;
		return StringUtils.replaceChars(srcFmt.to(CaseFormat.LOWER_UNDERSCORE, path), "-.", "__");
	}
}
