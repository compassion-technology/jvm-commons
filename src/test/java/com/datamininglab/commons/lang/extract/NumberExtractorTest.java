/*
 * Copyright (c) 2016 Elder Research, Inc.
 * All rights reserved.
 */
package com.datamininglab.commons.lang.extract;

import junit.framework.TestCase;

public class NumberExtractorTest extends TestCase {
	private static final double EPS = 0.0001;
	
	private static final NumberExtractor ALL = NumberExtractor.getInstance(LocalityLevel.ALL);
	private static final NumberExtractor LANG = NumberExtractor.getInstance(LocalityLevel.LANGUAGE);
	private static final NumberExtractor LOCAL = NumberExtractor.getInstance(LocalityLevel.LOCAL);	
	
	public void testNumberExtractor() {
		assertEquals(1234.5, LOCAL.parse("1234.5").doubleValue(), EPS);
		assertEquals(1234.5, LOCAL.parse("1,234.5").doubleValue(), EPS);
		assertEquals(-1234.5, LANG.parse("-1234.5").doubleValue(), EPS);
		assertEquals(0.985, LOCAL.parse("98.5%").doubleValue(), EPS);
		assertEquals(100, LOCAL.parse("$100.0").doubleValue(), EPS);
		assertEquals(100, LANG.parse("£100").doubleValue(), EPS);
		assertEquals(1e6, LANG.parse("€1,000,000").doubleValue(), EPS);
		assertEquals(-100, LANG.parse("($100.0)").doubleValue(), EPS);
		assertEquals(-1234.5, ALL.parse("(1.234,5)").doubleValue(), EPS);
	}
}
