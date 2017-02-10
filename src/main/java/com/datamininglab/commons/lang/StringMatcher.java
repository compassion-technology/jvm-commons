/*******************************************************************************
 * Copyright (c) 2016 Elder Research, Inc.
 * All rights reserved.
 *******************************************************************************/
package com.datamininglab.commons.lang;

import java.util.Arrays;
import java.util.function.BiFunction;

import org.apache.commons.lang3.StringUtils;


/**
 * Stateful API around basic string comparison. You can either use this in "fluent" mode:
 * <pre>assert new StringMatcher(StringMatchStrat.STARTS_WITH).does("Jo").match("John");</pre>
 * or by setting the match basis and repeatedly testing:<pre>
 * val sm = new StringMatcher(StringMatchStrat.STARTS_WITH);
 * sm.match("John");
 * assert sm.test("Jo");
 * assert !sm.test("Ji");</pre>
 * or by setting the test string and repeatedly setting the basis:<pre>
 * val sm = new StringMatcher(StringMatchStrat.STARTS_WITH);
 * sm.test("Jo");
 * assert sm.matchAny("John", "Jill");
 * assert !sm.matchAll("John", "Jill");</pre>
 * This class is <b>not</b> thread-safe and any changes to the settings (like {@link #ignoreCase()} or
 * {@link #setCleaningRegex(String, String)}) must be done <b>before</b> any testing, since the transformed basis and
 * test strings are cached.
 * 
 * @author <a href="dimeo@datamininglab.com">John Dimeo</a>
 * @since Sep 13, 2013
 */
public class StringMatcher {
	/** Enumerated wrapper to the String comparison methods in {@link StringUtils}. */
	public enum StringMatchStrat {
		EQUALS(StringUtils::equals),
		STARTS_WITH(StringUtils::startsWith),
		ENDS_WITH(StringUtils::endsWith),
		CONTAINS(StringUtils::contains);
		
		private BiFunction<String, String, Boolean> fn;
		StringMatchStrat(BiFunction<String, String, Boolean> fn) { this.fn = fn; }
		
		public boolean match(String base, String test) {
			return fn.apply(base, test);
		}
	}

	private StringMatchStrat[] strats;
	private boolean ignoreCase;
	private String cleanRegex;
	private String cleanReplacement;
	
	private String[] basis;
	private String test;
	private boolean all;
	
	public StringMatcher(StringMatchStrat... strats) {
		setStrategies(strats);
	}
	
	/**
	 * Enable case-insensitive matching, regardless of strategy.
	 * @return this for method chaining
	 * @see #matchCase()
	 */
	public StringMatcher ignoreCase() {
		ignoreCase = true;
		return this;
	}
	
	/**
	 * Enable case-sensitive matching, regardless of strategy.
	 * @return this for method chaining
	 * @see #ignoreCase()
	 */
	public StringMatcher matchCase() {
		ignoreCase = false;
		return this;
	}
	
	/**
	 * Sets the strategies to use when matching. This defaults to all available strategies.
	 * @param strats the strategies to use
	 * @return this for method chaining
	 */
	public StringMatcher setStrategies(StringMatchStrat... strats) {
		this.strats = strats.length == 0? StringMatchStrat.values() : strats;
		return this;
	}
	
	/**
	 * Sets the regular expression to use to transform each value that is tested by this matcher. This is a convenience
	 * instead of calling {@link String#replaceAll(String, String)} on each parameter instead.
	 * @param regex the regular expression
	 * @param replacement the replacement for each match
	 * @return this for method chaining
	 */
	public StringMatcher setCleaningRegex(String regex, String replacement) {
		this.cleanRegex = regex;
		this.cleanReplacement = StringUtils.defaultString(replacement);
		return this;
	}
	
	/**
	 * Begin a fluent match test.
	 * @param test the string to test against one or more base strings passed to {@link #match(String)},
	 * {@link #matchAll(String...)}, or {@link #matchAny(String...)}
	 * @return this for method chaining
	 */
	public StringMatcher does(String test) {
		this.test = applySettings(test);
		return this;
	}
	
	/**
	 * Sets the basis for the match and returns the result if a test string has been set (via {@link #does(String)}).
	 * For example, for the {@link StringMatchStrat#STARTS_WITH} strategy, the basis is the set of prefixes to match.
	 * Only one base string must match the test string to return <tt>true</tt>.
	 * @param basis the basis for the match
	 * @return whether or not the test string passed to {@link #does(String)} matched the parameters
	 */
	public boolean matchAny(String... basis) {
		return match(false, basis);
	}
	
	/**
	 * Sets the basis for the match and returns the result if a test string has been set (via {@link #does(String)}).
	 * For example, for the {@link StringMatchStrat#STARTS_WITH} strategy, the basis is the set of prefixes to match.
	 * All of the base strings must match the test string to return <tt>true</tt>.
	 * @param basis the basis for the match
	 * @return whether or not the test string passed to {@link #does(String)} matched the parameters
	 */
	public boolean matchAll(String... basis) {
		return match(true, basis);
	}

	/**
	 * Sets the basis for the match and returns the result if a test string has been set (via {@link #does(String)}).
	 * For example, for the {@link StringMatchStrat#STARTS_WITH} strategy, the basis is the set of prefixes to match.
	 * @param base the basis for the match
	 * @return whether or not the test string passed to {@link #does(String)} matched the parameter
	 */
	public boolean match(String base) {
		return match(true, base);
	}
	
	private boolean match(boolean all, String... basis) {
		this.basis = Arrays.copyOf(basis, basis.length);
		Arrays.setAll(this.basis, i -> applySettings(basis[i]));
		this.all = all;
		return test();
	}
	
	/**
	 * Tests the string against the basis passed to either {@link #match(String)}, {@link #matchAll(String...)}, or
	 * {@link #matchAny(String...)}.
	 * @param test the string to test
	 * @return whether or not the string matched the basis
	 */
	public boolean test(String test) {
		return does(test).test();
	}
	
	private boolean test() {
		boolean ret = false;
		nextBase: for (int i = 0; i < basis.length; i++) {
			for (StringMatchStrat strat : strats) {
				if (strat.match(basis[i], test)) {
					// If one strat matched one base, short circuit return true in "any" mode
					if (!all) { return true; }
					
					// Otherwise, indicate that one strat matched this base and try next base
					ret = true;
					continue nextBase;
				}
			}
			// If none of the strats matched this base, short circuit return false in "all" mode
			if (all) { return false; }
		}
		return ret;
	}
	
	private String applySettings(String s) {
		if (ignoreCase) { 
			s = StringUtils.lowerCase(s);
		}
		if (cleanRegex != null) {
			s = StringUtils.replaceAll(s, cleanRegex, cleanReplacement);
		}
		return s;
	}
}
