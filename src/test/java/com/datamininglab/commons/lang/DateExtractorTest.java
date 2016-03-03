/*
 * Copyright (c) 2015 Elder Research, Inc.
 * All rights reserved.
 */
package com.datamininglab.commons.lang;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import com.datamininglab.commons.lang.DateExtractor.DateLocality;
import com.datamininglab.commons.lang.DateExtractor.DateMatch;

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
	
	@Test
	public void testRemoveOverlaps() {
		Set<DateMatch> allMatches = new DateExtractor(DateLocality.LANGUAGE).extractAll(
			"Example text 2000 to 2 March 2001.");
		
		List<DateMatch> list = new ArrayList<>(allMatches);
		Collections.sort(list, DateExtractor.POSITION_THEN_SHORTEST);
		
		assertEquals(4, list.size());
		assertEquals(13, list.get(0).getStart());
		assertEquals(17, list.get(0).getEnd());
		assertEquals("2000", list.get(0).getDateText());
		
		assertEquals(21, list.get(1).getStart());
		assertEquals(33, list.get(1).getEnd());
		assertEquals("2 March 2001", list.get(1).getDateText());
		
		assertEquals(23, list.get(2).getStart());
		assertEquals(33, list.get(2).getEnd());
		assertEquals("March 2001", list.get(2).getDateText());
		
		assertEquals(29, list.get(3).getStart());
		assertEquals(33, list.get(3).getEnd());
		assertEquals("2001", list.get(3).getDateText());
		
		list = DateExtractor.removeOverlaps(allMatches);
		
		assertEquals(2, list.size());
		assertEquals(13, list.get(0).getStart());
		assertEquals(17, list.get(0).getEnd());
		assertEquals("2000", list.get(0).getDateText());
		
		assertEquals(21, list.get(1).getStart());
		assertEquals(33, list.get(1).getEnd());
		assertEquals("2 March 2001", list.get(1).getDateText());
	}
}
