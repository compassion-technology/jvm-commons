/* ©2020 Elder Research, Inc. All rights reserved. */
package com.elderresearch.commons.lang.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
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

	private final String prefix;
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
		if (environments.isEmpty()) {
			withEnvironmentVariables().withSystemProperties();
		}

		for (val env : environments) {
            val tree = om.valueToTree(obj);
            val trav = tree.traverse();
            while (!trav.isClosed()) {
                val fn = trav.nextFieldName();
                if (fn == null) {
                    continue;
                }

                val path = trav.getParsingContext().pathAsPointer();
                val key = CaseFormat.LOWER_CAMEL.to(env.pathFormat(),
                        path.toString().replace(JsonPointer.SEPARATOR, env.pathSeparator()));
                if (env.has(key)) {
                    ObjectNode n = Utilities.cast(tree.at(path));
                    n.put(last(path), env.get(key));
                }
            }
            om.readerForUpdating(obj).readValue(tree);
        }
		

		for (val env : environments) { env.close(); }
	}
	
	private static String last(JsonPointer p) {
		// p.last() is throwing an NPE :-/
		int i = p.toString().lastIndexOf(JsonPointer.SEPARATOR);
		return p.toString().substring(i + 1);
	}
	
	public String normalizePath(String path) {
		val srcFmt = StringUtils.isAllUpperCase(StringUtils.replaceChars(path, "_- .1234567890", null))
			? CaseFormat.UPPER_UNDERSCORE : CaseFormat.LOWER_CAMEL;
		path = StringUtils.replaceChars(srcFmt.to(CaseFormat.LOWER_UNDERSCORE, path), "-.", "__");
		return StringUtils.removeStart(path, prefix);
	}
}
