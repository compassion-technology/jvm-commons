/* ©2016-2020 Elder Research, Inc. All rights reserved. */
package com.compassion.commons.extract;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import com.compassion.commons.Utilities;

public class DateExtractorTest {
	private static final DateExtractor ALL = DateExtractor.getInstance(LocalityLevel.ALL);
	private static final DateExtractor LANG = DateExtractor.getInstance(LocalityLevel.LANGUAGE);
	private static final DateExtractor LOCAL = DateExtractor.getInstance(LocalityLevel.LOCAL);
	private static final DateExtractor MON_YEAR = DateExtractor.getInstance(LocalityLevel.LANGUAGE);
	
	private static final Date DATE = Utilities.parseDate(new SimpleDateFormat("yyyy-MM-dd"), "2009-06-15", null);
	private static final Date DATE_TIME = Utilities.parseDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), "2009-06-15 13:45:30", null);
	
	@Test
	public void testYearOnly() {
		MON_YEAR.setCustomFormats(DateExtractor.MONTH_YEAR_FORMATS);
		assertEquals(DateUtils.truncate(DATE, Calendar.YEAR), MON_YEAR.parse("2009"));
		assertNull(MON_YEAR.parse("1234"));
	}
	
	@Test
	public void testShortDate() {
		assertEquals(DATE, LOCAL.parse("6/15/2009"));
		assertEquals(DATE, LANG.parse("2009/06/15"));
		assertEquals(DATE, ALL.parse("15/06/2009"));
	}
	
	@Test
	public void testShortDateTime() {
		assertEquals(DATE_TIME, LOCAL.parse("6/15/2009 1:45:30 PM"));
	}
	
	@Test
	public void testLongDate() {
		assertEquals(DATE, LOCAL.parse("Monday, June 15, 2009"));
		assertEquals(DATE, LANG.parse("Monday, June 15, 2009"));
		assertEquals(DATE, ALL.parse("Montag, 15. Juni 2009"));
		assertEquals(DATE, ALL.parse("Δευτέρα, 15 Ιουνίου 2009"));
	}
	
	@Test
	public void testLongDateTime() {
		assertEquals(DATE_TIME, LANG.parse("Monday, June 15, 2009 1:45:30 PM"));
	}
	
	@Test
	public void testRemoveOverlaps() {
		Set<Match<Date>> allMatches = MON_YEAR.extractAll("Example text 2000 to 2 March 2001.");
		
		List<Match<Date>> list = new ArrayList<>(allMatches);
		Collections.sort(list, Match.orderByPositionThenShortest());
		
		assertEquals(4, list.size());
		assertEquals(13, list.get(0).getStart());
		assertEquals(17, list.get(0).getEnd());
		assertEquals("2000", list.get(0).getMatchText());
		
		assertEquals(21, list.get(1).getStart());
		assertEquals(33, list.get(1).getEnd());
		assertEquals("2 March 2001", list.get(1).getMatchText());
		
		assertEquals(23, list.get(2).getStart());
		assertEquals(33, list.get(2).getEnd());
		assertEquals("March 2001", list.get(2).getMatchText());
		
		assertEquals(29, list.get(3).getStart());
		assertEquals(33, list.get(3).getEnd());
		assertEquals("2001", list.get(3).getMatchText());
		
		list = Match.removeOverlaps(allMatches);
		
		assertEquals(2, list.size());
		assertEquals(13, list.get(0).getStart());
		assertEquals(17, list.get(0).getEnd());
		assertEquals("2000", list.get(0).getMatchText());
		
		assertEquals(21, list.get(1).getStart());
		assertEquals(33, list.get(1).getEnd());
		assertEquals("2 March 2001", list.get(1).getMatchText());
	}
}
