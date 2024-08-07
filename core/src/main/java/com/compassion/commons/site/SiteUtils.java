package com.compassion.commons.site;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringEscapeUtils;

/**
 * <p>Utilities for generating Maven sites, usually using Markdown, with Mermaid for charts, as the source
 * language rendering to HTML.</p>
 * 
 * <p>This API may be exposed to Velocity templates so using an IDE to discover usages might not uncover all
 * actual uses of these utilities.</p>
 */
public class SiteUtils {
	private static final String[] MERMAID_RESERVED_WORDS = {"self", "call", "parent", "default", "style"};

	public static String sanitizeIdForMermaid(String s) {
		// Weird bug in Mermaid that if a node identifier ends with _self or _call it breaks the graph
		for (var word : MERMAID_RESERVED_WORDS) {
			var suffix = "_" + word;
			if (StringUtils.endsWith(s, suffix)) { return s.replace(suffix, word); }
		}
		return s;
	}

	/**
	 * This delegates to {@link StringEscapeUtils#escapeHtml4(String)} but is included here for use in Velocity templates.}
	 * @param s the string to sanitize
	 * @return the string with special characters like {@code &} escaped as HTML entities like {@code &amp;}, including 
	 * all HTML markup characters like {@code <}
	 */
	public static String sanitizeHtml(String s) {
		return StringEscapeUtils.escapeHtml4(s);
	}

	/**
	 * This is similar to {@link #sanitizeHtml(String)} but only sanitizes some commonly used entities, preserving
	 * markup like {@code <b>} that is supported inside Markdown.
	 * @param s the string to sanitize
	 * @return the string with special characters like {@code &} escaped as HTML entities like {@code &amp;}
	 */
	public static String sanitizeEntities(String s) {
		return StringUtils.replace(StringUtils.replace(s, "&", "&amp;"), ",", "&comma;");
	}
	
	/**
	 * Preserve any newlines in the string in HTML by replacing them with {@code <br/>}.
	 * @param s the string to sanitize
	 * @return the string with any newlines replaced with an HTML line break tag
	 */
	public static String preserveNewlines(String s) {
		return StringUtils.replace(s, "\n", "<br/>");
	}
}
