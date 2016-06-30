/*******************************************************************************
 * Copyright (c) 2016 Elder Research, Inc.
 * All rights reserved.
 *******************************************************************************/
package com.datamininglab.commons.lang;

import org.apache.commons.lang3.StringUtils;


/**
 * Enumerated wrapper to the String comparison methods in {@link StringUtils}.
 * 
 * @author <a href="dimeo@datamininglab.com">John Dimeo</a>
 * @since Sep 13, 2013
 */
public class StringMatcher {
	public static final int NO_MATCH = -1;
	
	public enum StringMatchStrat {
		EQUALS {
			@Override
			boolean match(String base, String test) {
				return StringUtils.equals(base, test);
			}
		},
		STARTS_WITH {
			@Override
			boolean match(String base, String test) {
				return StringUtils.startsWith(base, test);
			}
		},
		ENDS_WITH {
			@Override
			boolean match(String base, String test) {
				return StringUtils.endsWith(base, test);
			}
		},
		CONTAINS {
			@Override
			boolean match(String base, String test) {
				return StringUtils.contains(base, test);
			}
		};
		
		abstract boolean match(String base, String test);
	}

	private StringMatchStrat[] strats;
	private boolean ignoreCase;
	private String cleanRegex;
	private String cleanReplacement;
	
	public StringMatcher() {
		setStrategies(StringMatchStrat.values());
	}
	
	public StringMatcher ignoreCase() {
		ignoreCase = true;
		return this;
	}
	
	public StringMatcher matchCase() {
		ignoreCase = false;
		return this;
	}
	
	public StringMatcher setStrategies(StringMatchStrat... strats) {
		this.strats = strats;
		return this;
	}
	
	public StringMatcher setCleaningRegex(String regex, String replacement) {
		this.cleanRegex = regex;
		this.cleanReplacement = StringUtils.defaultString(replacement);
		return this;
	}

	/**
	 * Tests the test string against the strings using the different matching
	 * strategies in order.
	 * @param test the string to compare
	 * @param toMatch one or more strings to compare against
	 * @return if any of the strings match the test string using any of the
	 * strategies
	 * @see #matchIndex(String, String...) if you need to know the index of the
	 * string that matched in the input array
	 */
	public boolean matches(String test, String... toMatch) {
		return matchIndex(test, toMatch) != NO_MATCH;
	}
	
	/**
	 * Tests the test string against the strings using the different matching
	 * strategies in order.
	 * @param test the string to compare
	 * @param toMatch one or more strings to compare
	 * @return the index of the matching string in the <tt>test</tt> array, or
	 * {@link #NO_MATCH} if no strings matched
	 */
	public int matchIndex(String test, String... toMatch) {
		if (ignoreCase) {
			test = StringUtils.lowerCase(test);
			for (int i = 0; i < toMatch.length; i++) {
				toMatch[i] = StringUtils.lowerCase(toMatch[i]);	
			}
		}
		
		int m = match(test, toMatch);
		if (m != NO_MATCH) { return m; }
		
		if (cleanRegex != null) {
			test = test.replaceAll(cleanRegex, cleanReplacement);
			for (int i = 0; i < toMatch.length; i++) {
				if (toMatch[i] != null) {
					toMatch[i] = toMatch[i].replaceAll(cleanRegex, cleanReplacement);
				}
			}
			
			m = match(test, toMatch);
			if (m != NO_MATCH) { return m; }
		}
		return NO_MATCH;
	}
	
	private int match(String test, String... toMatch) {
		for (StringMatchStrat strat : strats) {
			for (int i = 0; i < toMatch.length; i++) {
				if (strat.match(toMatch[i], test)) { return i; }
			}
		}
		return NO_MATCH;
	}
}
