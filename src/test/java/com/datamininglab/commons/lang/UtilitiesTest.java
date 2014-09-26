/*
 * Copyright (c) 2013 Elder Research, Inc.
 * All rights reserved.
 */
package com.datamininglab.commons.lang;

import java.util.LinkedList;
import java.util.List;

import junit.framework.TestCase;

import org.apache.commons.lang3.StringUtils;

public class UtilitiesTest extends TestCase {
	public void testSoundex() {
		assertEquals("R163", Utilities.getSoundex("Robert"));
		assertEquals("R163", Utilities.getSoundex("Rupert"));
		assertEquals("R150", Utilities.getSoundex("Rubin"));
		assertEquals("A261", Utilities.getSoundex("Ashcraft"));
		assertEquals("A261", Utilities.getSoundex("Ashcroft"));
	}
	
	public void testAppendString() {
		assertEquals("the | cat |  | chased | the | mouse", StringUtils.join(
			new String[] {"the", "cat", null, "chased", "the", "mouse"}, " | "
		));
	}
	
	public void testAppendCollection() {
		List<String> l = new LinkedList<>();
		l.add("the");
		l.add("cat");
		l.add(null);
		l.add("chased");
		l.add("the");
		l.add("mouse");
		
		assertEquals("the | cat |  | chased | the | mouse", StringUtils.join(l, " | "));
	}
	
	public void testClean() {
		assertEquals("hello world", Utilities.clean("  'hello world '"));
	}
	
	public void testEditDistance() {
		assertEquals(4.0f, Utilities.getEditDistance("cow", "house"));
		assertEquals(1.0f, Utilities.getEditDistance("now", "cow"));
		assertEquals(4.0f, Utilities.getEditDistance("cow", "house", 1.0f, 1.0f, 1.0f));
		assertEquals(5.0f, Utilities.getEditDistance("cow", "house", 1.0f, 2.0f, 1.5f));
		assertEquals(6.0f, Utilities.getEditDistance("cow", "house", 1.0f, 1.0f, 2.0f));
	}
	
	public void testFormatSSN() {
		assertEquals("123-45-6785", Utilities.formatSSN(" 123456785___"));
		assertEquals("123-45-6785", Utilities.formatSSN("123-456785"));
		assertEquals("123-45-6785", Utilities.formatSSN("123-45-6785"));
		assertEquals("1234-56785", Utilities.formatSSN("1234-56785"));
		assertEquals("#123456", Utilities.formatSSN("#123456"));
	}
	
	public void testStripQuotes() {
		assertEquals("Hello", Utilities.stripQuotes(" 'Hello'"));
		assertEquals("Hello ", Utilities.stripQuotes("\"Hello \""));
		assertEquals("Hello", Utilities.stripQuotes("'Hello\""));
		assertEquals("'Hello", Utilities.stripQuotes("'Hello"));
	}
}
