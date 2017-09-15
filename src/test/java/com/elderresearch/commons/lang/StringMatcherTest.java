/*******************************************************************************
 * Copyright (c) 2017 Elder Research, Inc.
 * All rights reserved.
 *******************************************************************************/
package com.elderresearch.commons.lang;

import com.elderresearch.commons.lang.StringMatcher.StringMatchStrat;

import junit.framework.TestCase;
import lombok.val;

public class StringMatcherTest extends TestCase {
	public void test() {
		StringMatcher sm = new StringMatcher();
		assertFalse(sm.does("jo").match("John"));
		assertTrue(sm.test("Jo"));
		
		assertFalse(sm.does("Jo").matchAll("Jill", "John", "Jude"));
		assertTrue(sm.does("Jo").matchAny("Jill", "John", "Jude"));
		assertTrue(sm.ignoreCase().does("jo").matchAny("Jill", "John", "Jude"));
		
		assertFalse(sm.setStrategies(StringMatchStrat.ENDS_WITH).test("ji"));
		assertTrue(sm.test("hn"));
	}
	
	public void testExample() {
		 assertTrue(new StringMatcher(StringMatchStrat.STARTS_WITH).does("Jo").match("John"));
		 
		 val sm = new StringMatcher(StringMatchStrat.STARTS_WITH);
		 sm.match("John");
		 assertTrue(sm.test("Jo"));
		 assertFalse(sm.test("Ji"));
		 
		 sm.test("Jo");
		 assertTrue(sm.matchAny("John", "Jill"));
		 assertFalse(sm.matchAll("Jill", "Jill"));
	}
}
