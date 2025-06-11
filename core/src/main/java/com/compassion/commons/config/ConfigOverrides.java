package com.compassion.commons.config;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.mutable.MutableInt;
import org.jooq.lambda.Seq;

import com.compassion.commons.LambdaUtils;
import com.compassion.commons.Utilities;
import com.compassion.commons.config.ConfigEnvironment.ConfigEnvironmentMap;
import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
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
public class ConfigOverrides {
	protected final String[] prefixes;
	private List<ConfigEnvironment> environments;

	protected ConfigOverrides(String... prefixes) {
		if (prefixes.length == 0) { prefixes = new String[] { StringUtils.EMPTY }; }
		this.prefixes = Seq.of(prefixes).map(StringUtils::lowerCase).toArray(String[]::new);
		this.environments = new LinkedList<>();
	}

	public static ConfigOverrides forPrefixes(String... prefixes) {
		return new ConfigOverrides(prefixes);
	}

	public ConfigOverrides with(ConfigEnvironment e) {
		this.environments.add(e);
		return this;
	}

	public ConfigOverrides withEnvironmentVariables() {
		val e = new ConfigEnvironmentMap('_', CaseFormat.UPPER_UNDERSCORE);
		System.getenv().forEach((k, v) -> {
			if (StringUtils.startsWithAny(StringUtils.lowerCase(k), prefixes)) {
				e.put(StringUtils.upperCase(k), v);
			}
		});
		return with(e);
	}

	public ConfigOverrides withSystemProperties() {
		val e = new ConfigEnvironmentMap('.', CaseFormat.LOWER_CAMEL);
		System.getProperties().forEach((k, v) -> {
			if (StringUtils.startsWithAny(StringUtils.lowerCase(k.toString()), prefixes)) {
				e.put(k.toString(), v.toString());
			}
		});
		return with(e);
	}

    /**
     * Override a config object (usually) in the order that they've been added using {@link #with(Environment)},
     * {@link #withEnvironmentVariables()}, or {@link #withSystemProperties()}. this allows you to access overridden
     * properties from previous environments specified with {@link #with(Environment)}.
     * @param om the ObjectMapper that reads from the environments
     * @param obj the POJO object that we will override
     * @return the new configuration after all overrides have been applied
     * @throws IOException
     */
	public <T> T applyOverrides(ObjectMapper om, T obj) throws IOException {
		T ret = obj;
		for (var env: environments) {
	        var tree = om.valueToTree(ret);
	        var trav = tree.traverse();
	        while (!trav.isClosed()) {
	            var fn = trav.nextFieldName();
	            if (fn == null) { continue; }

	            var path = trav.getParsingContext().pathAsPointer();
	            var node = tree.at(path);
	            nextNode(env, path, node);

	            var parent = tree.at(path.head());
	            if (!parent.isObject()) { continue; }

	            var objNode = (ObjectNode) parent;
	            var prop = last(path);

	            applyOverrides(env, path, node, $ -> objNode.replace(prop, $));
	            
	            if (node.isArray()) {
	            	var arr = (ArrayNode) node;
	        		var idx = new MutableInt();
	            	for (var child : node) {
	            		applyOverrides(env, path.appendIndex(idx.intValue()), child, $ -> arr.set(idx.intValue(), $));
	            		idx.increment();
	            	}
	            }
	        }
	        ret = Utilities.cast(om.treeToValue(tree, obj.getClass()));
		}
		for (val env : environments) { env.close(); }
		return ret;
	}

	private void applyOverrides(ConfigEnvironment env, JsonPointer path, JsonNode node, Consumer<JsonNode> updater) {
		for (var prefix : prefixes) {
			val key = CaseFormat.LOWER_CAMEL.to(env.pathFormat(), prefix +
	                path.toString().replace(JsonPointer.SEPARATOR, env.pathSeparator()));
	        if (env.has(key, node)) {
	        	LambdaUtils.accept(env.get(key, node), updater);
	        }
		}
	}

	protected void nextNode(ConfigEnvironment env, JsonPointer path, JsonNode node) {
		// Extension point
	}

	private static String last(JsonPointer p) {
		// p.last() throws NPE or ConcurrentException or is wrong
		int i = p.toString().lastIndexOf(JsonPointer.SEPARATOR);
		return p.toString().substring(i + 1);
	}
	
	public static ConfigOverrides compose(ConfigOverrides... overrides) {
		return new ConfigOverrides() {
			@Override
			public <T> T applyOverrides(ObjectMapper om, T obj) throws IOException {
				for (var o : overrides) {
					obj = o.applyOverrides(om, obj);
				}
				return obj;
			}
		};
	}
}
