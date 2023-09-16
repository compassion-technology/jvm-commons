/* ©2016-2020 Elder Research, Inc. All rights reserved. */
package com.compassion.commons;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.compassion.commons.Utilities;

public class UtilitiesTest {
	@Test
	public void testSoundex() {
		assertEquals("R163", Utilities.getSoundex("Robert"));
		assertEquals("R163", Utilities.getSoundex("Rupert"));
		assertEquals("R150", Utilities.getSoundex("Rubin"));
		assertEquals("A261", Utilities.getSoundex("Ashcraft"));
		assertEquals("A261", Utilities.getSoundex("Ashcroft"));
	}
	
	@Test
	public void testAppendString() {
		assertEquals("the | cat |  | chased | the | mouse", StringUtils.join(
			new String[] {"the", "cat", null, "chased", "the", "mouse"}, " | "
		));
	}
	
	@Test
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
	
	@Test
	public void testStripQuotes() {
		assertEquals("Hello", Utilities.stripQuotes(" 'Hello'"));
		assertEquals("Hello", Utilities.stripQuotes("\"Hello \""));
		assertEquals("Hello", Utilities.stripQuotes("'Hello\""));
		assertEquals("'Hello", Utilities.stripQuotes("'Hello"));
		assertEquals("hello world", Utilities.stripQuotes("  'hello world '"));
		assertEquals("hello world", Utilities.stripQuotes("\" hello world\" "));
		assertEquals("' hello world", Utilities.stripQuotes("' hello world  "));
	}
	
	@Test
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
	
	@Test
	public void testLetterFreq() {
		assertEquals(0.4233f, Utilities.getLetterFrequencyScore("Hello, this is a test".toCharArray()), 0.001f);
		assertEquals(0.2108f, Utilities.getLetterFrequencyScore("ABA12341255asf2sfgerq".toCharArray()), 0.001f);
		assertEquals(0.0043f, Utilities.getLetterFrequencyScore("908&9876875676%$463*7".toCharArray()), 0.001f);
	}
}
