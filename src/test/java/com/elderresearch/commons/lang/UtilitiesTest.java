/*******************************************************************************
 * Copyright (c) 2016 Elder Research, Inc.
 * All rights reserved.
 *******************************************************************************/
package com.elderresearch.commons.lang;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import junit.framework.TestCase;

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
	
	public void testFormatSSN() {
		assertEquals("123-45-6785", Utilities.formatSSN(" 123456785___"));
		assertEquals("123-45-6785", Utilities.formatSSN("123-456785"));
		assertEquals("123-45-6785", Utilities.formatSSN("123-45-6785"));
		assertEquals("1234-56785", Utilities.formatSSN("1234-56785"));
		assertEquals("#123456", Utilities.formatSSN("#123456"));
	}
	
	public void testStripQuotes() {
		assertEquals("Hello", Utilities.stripQuotes(" 'Hello'"));
		assertEquals("Hello", Utilities.stripQuotes("\"Hello \""));
		assertEquals("Hello", Utilities.stripQuotes("'Hello\""));
		assertEquals("'Hello", Utilities.stripQuotes("'Hello"));
		assertEquals("hello world", Utilities.stripQuotes("  'hello world '"));
		assertEquals("hello world", Utilities.stripQuotes("\" hello world\" "));
		assertEquals("' hello world", Utilities.stripQuotes("' hello world  "));
	}
	
	public void testPluralize() {
		assertEquals("plants", Utilities.pluralize("plant"));
		assertEquals("indexes", Utilities.pluralize("index"));
		assertEquals("oboes", Utilities.pluralize("oboe"));
		assertEquals("cities", Utilities.pluralize("city"));
		assertEquals("toys", Utilities.pluralize("toy"));
		assertEquals("glasses", Utilities.pluralize("glass"));
		
		assertEquals("plants", Utilities.pluralizeIf("plant", 0));
		assertEquals("potatoes", Utilities.pluralizeIf("potato", 2));
		assertEquals("bushes", Utilities.pluralizeIf("bush", 0.3));
		assertEquals("pizza", Utilities.pluralizeIf("pizza", 1));
	}
}
