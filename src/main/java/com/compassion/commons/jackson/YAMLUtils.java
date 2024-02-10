/* ©2017-2020 Elder Research, Inc. All rights reserved. */
package com.compassion.commons.jackson;

import java.util.function.Predicate;

import org.apache.commons.lang3.StringUtils;
import org.yaml.snakeyaml.DumperOptions.LineBreak;
import org.yaml.snakeyaml.DumperOptions.ScalarStyle;
import org.yaml.snakeyaml.nodes.MappingNode;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.ScalarNode;
import org.yaml.snakeyaml.nodes.Tag;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.fasterxml.jackson.dataformat.yaml.util.StringQuotingChecker;

import lombok.val;
import lombok.experimental.UtilityClass;

/**
 * Utilities for using Jackson and its {@link ObjectMapper} to use YAML.
 * 
 * @author <a href="mailto:dimeo@elderresearch.com">John Dimeo</a>
 * @since Nov 14, 2017
 */
@UtilityClass
public class YAMLUtils {
	/**
	 * Gets an {@link ObjectMapper} configured to read and write YAML. When writing YAML, the mapper will use the
	 * default line breaks for the platform on which the code is running.
	 * @return a YAML-enabled object mapper
	 * @see LineBreak#getPlatformLineBreak()
	 */
	public YAMLMapper newMapper() {
		return newMapper(LineBreak.getPlatformLineBreak());
	}
	
	/**
	 * Gets an {@link ObjectMapper} configured to read and write YAML. When writing YAML, the mapper will use the
	 * specified line breaks.
	 * @param lineBreak the line breaks to use when writing YAML
	 * @return a YAML-enabled object mapper
	 */
	public YAMLMapper newMapper(LineBreak lineBreak) {
		return new YAMLMapper(new YAMLFactoryCustom(lineBreak));
	}
	
	/**
	 * Look for a key in a YAML mapping node, returning {@code true} if the key is found and the callback returns
	 * {@code true}.
	 * @param <N> the type of node you expect to find at the key
	 * @param n the root node
	 * @param key the key
	 * @param as the type of node you expect to find at the key
	 * @param callback the callback to invoke with the value node if the key is found
	 * @return the result of the callback if the node is found
	 */
	public static <N extends Node> boolean findInMap(MappingNode n, String key, Class<N> as, Predicate<N> callback) {
		for (val tuple : n.getValue()) {
			val keyNode = (ScalarNode) tuple.getKeyNode();
			if (StringUtils.equalsIgnoreCase(key, keyNode.getValue())) {
				return callback.test(as.cast(tuple.getValueNode()));
			}
		}
		return false;
	}
	
	/**
	 * Create a scalar node for the string, detecting the most appropriate {@link ScalarStyle} for the string.
	 * @param s the string
	 * @return a scalar node for the string
	 * @see #detectScalarStyle(String)
	 */
	public static ScalarNode stringNode(String s) {
		s = StringUtils.trimToNull(s);
		return stringNode(s, detectScalarStyle(s));
	}
	
	/**
	 * Create a scalar node for the string, using the specified style.
	 * @param s the string
	 * @return a scalar node for the string
	 */
	public static ScalarNode stringNode(String s, ScalarStyle style) {
		return new ScalarNode(Tag.STR, s, null, null, style);
	}
	
	// This is copied/modified from YAMLGenerator.Feature.MINIMIZE_QUOTES implementation
	private static final int MAX_ONE_LINE_LEN = 80;
	public static ScalarStyle detectScalarStyle(String text) {
		if (StringUtils.containsAny(text, "\r\n")) {
            return ScalarStyle.LITERAL;
		}
		
        // If one of reserved values ("true", "null"), or, number, preserve quoting:
        if (text.length() > MAX_ONE_LINE_LEN || StringQuotingChecker.Default.instance().needToQuoteValue(text)) {
        	return ScalarStyle.FOLDED;
        }
        
        return ScalarStyle.PLAIN;
	}
}
