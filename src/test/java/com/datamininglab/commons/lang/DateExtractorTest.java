/*
 * Copyright (c) 2015 Elder Research, Inc.
 * All rights reserved.
 */
package com.datamininglab.commons.lang;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import com.datamininglab.commons.lang.DateExtractor.DateLocality;

import junit.framework.TestCase;

public class DateExtractorTest extends TestCase {
	private static final Date DATE = Utilities.parseDate(new SimpleDateFormat("yyyy-MM-dd"), "2009-06-15", null);
	private static final Date DATE_TIME = Utilities.parseDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), "2009-06-15 13:45:30", null);
	
	@Test
	public void testYearOnly() {
		assertEquals(DateUtils.truncate(DATE, Calendar.YEAR), new DateExtractor(DateLocality.LOCAL).parse("2009"));
		assertNull(new DateExtractor(DateLocality.LOCAL).parse("1234"));
	}
	
	@Test
	public void testShortDate() {
		assertEquals(DATE, new DateExtractor(DateLocality.LOCAL).parse("6/15/2009"));
		assertEquals(DATE, new DateExtractor(DateLocality.LANGUAGE).parse("2009/06/15"));
		assertEquals(DATE, new DateExtractor(DateLocality.ALL).parse("15/06/2009"));
	}
	
	@Test
	public void testShortDateTime() {
		assertEquals(DATE_TIME, new DateExtractor(DateLocality.LOCAL).parse("6/15/2009 1:45:30 PM"));
	}
	
	@Test
	public void testLongDate() {
		assertEquals(DATE, new DateExtractor(DateLocality.LOCAL).parse("Monday, June 15, 2009"));
		assertEquals(DATE, new DateExtractor(DateLocality.LANGUAGE).parse("Monday, June 15, 2009"));
		assertEquals(DATE, new DateExtractor(DateLocality.ALL).parse("Montag, 15. Juni 2009"));
		assertEquals(DATE, new DateExtractor(DateLocality.ALL).parse("Δευτέρα, 15 Ιουνίου 2009"));
	}
	
	@Test
	public void testLongDateTime() {
		assertEquals(DATE_TIME, new DateExtractor(DateLocality.LANGUAGE).parse("Monday, June 15, 2009 1:45:30 PM"));
	}
}
