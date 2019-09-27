/*******************************************************************************
 * Copyright (c) 2016 Elder Research, Inc.
 * All rights reserved.
 *******************************************************************************/
package com.elderresearch.commons.lang.extract;

import junit.framework.TestCase;
import lombok.val;

public class NumberExtractorTest extends TestCase {
	private static final double EPS = 0.0001;
	
	private static final NumberExtractor ALL = NumberExtractor.getInstance(LocalityLevel.ALL);
	private static final NumberExtractor LANG = NumberExtractor.getInstance(LocalityLevel.LANGUAGE);
	private static final NumberExtractor LOCAL = NumberExtractor.getInstance(LocalityLevel.LOCAL);	
	
	public void testNumberExtractor() {
		assertEquals( 1234.5,    "1234.5", LOCAL);
		assertEquals( 1234.5,   "1,234.5", LOCAL);
		assertEquals(-1234.5,   "-1234.5", LANG);
		assertEquals(-1234.5, "(1.234,5)", ALL);
	}
	
	public void testCurrency() {
		assertEquals( 100,     "$100.0", LOCAL);
		assertEquals( 100,       "£100", LANG);
		assertEquals( 1e6, "€1,000,000", LANG);
		assertEquals(-100,   "($100.0)", LANG);
	}
	
	public void testPercent() {
		assertEquals(0.985, "98.5%", LOCAL);		
	}
	
	public void testScientific() {
		assertEquals(8.5377366E-7, "8.5377366E-7", LOCAL);
		assertEquals(8.5377366E-7, "8.5377366e-7", LOCAL);
	}
	
	private static void assertEquals(double expected, String s, NumberExtractor ne) {
		val result = ne.parse(s);
		assertNotNull(result);
		assertEquals(expected, result.doubleValue(), EPS);
	}
}