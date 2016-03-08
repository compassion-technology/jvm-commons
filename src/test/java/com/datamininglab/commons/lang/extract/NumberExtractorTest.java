/*
 * Copyright (c) 2016 Elder Research, Inc.
 * All rights reserved.
 */
package com.datamininglab.commons.lang.extract;

import junit.framework.TestCase;

public class NumberExtractorTest extends TestCase {
	private static final NumberExtractor ALL = NumberExtractor.getInstance(LocalityLevel.ALL);
	private static final NumberExtractor LANG = NumberExtractor.getInstance(LocalityLevel.LANGUAGE);
	private static final NumberExtractor LOCAL = NumberExtractor.getInstance(LocalityLevel.LOCAL);	
	
	public void testNumberExtractor() {
		assertEquals(1234.5, LOCAL.parse("1234.5").doubleValue());
		assertEquals(-1234.5, LANG.parse("-1234.5").doubleValue());
		assertEquals(-1234.5, ALL.parse("(1234,5)").doubleValue());
	}
}
