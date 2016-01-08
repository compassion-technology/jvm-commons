/*
 * Copyright (c) 2016 Elder Research, Inc.
 * All rights reserved.
 */
package com.datamininglab.commons.lang;

import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * Contains some time/date utilities using the {@link Calendar} API.
 * 
 * @author <a href="mailto:dimeo@datamininglab.com">John Dimeo</a>
 * @since Jan 6, 2016
 */
public final class CalendarUtils {
	private CalendarUtils() {
		// Prevent initialization
	}
	
	/**
	 * A list of more commonly used calendar fields; namely those that comprise
	 * a standard ISO date/time format (see {@link DateTimeFormatter#ISO_LOCAL_DATE_TIME})
	 * plus {@link Calendar#DAY_OF_WEEK} in ascending order.
	 */
	public static final int[] STANDARD_FIELDS = {
		Calendar.YEAR,
		Calendar.MONTH,
		Calendar.DAY_OF_MONTH,
		Calendar.DAY_OF_WEEK,
		Calendar.HOUR_OF_DAY,
		Calendar.MINUTE,
		Calendar.SECOND
	};
	
	private static final ThreadLocal<Calendar> CAL = new ThreadLocal<Calendar>() {
		@Override
		protected Calendar initialValue() { return Calendar.getInstance(); }
	};
	/**
	 * Gets a calendar instance that is local to this thread.
	 * @return a calendar instance that is guaranteed to be thread safe
	 */
	public static Calendar get() { return CAL.get(); }
	
	/**
	 * Gets a calendar that has been set to the given date/time.
	 * @param d the date
	 * @return the calendar
	 */
	public static Calendar at(Date d) {
		Calendar c = get();
		c.setTime(d);
		return c;
	}
	
	/**
	 * Gets a calendar that has been set to the given date/time.
	 * @param millis the time in milliseconds
	 * @return the calendar
	 */
	public static Calendar at(long millis) {
		Calendar c = get();
		c.setTimeInMillis(millis);
		return c;
	}
	
	/**
	 * Convert a {@link Calendar} ordinal field to its string representation.
	 * For example, passing {@link Calendar#AM_PM} returns <tt>"AM/PM"</tt>.
	 * @param calendarField the calendar field
	 * @return the string representation
	 */
	public static String toString(int calendarField) {
		switch (calendarField) {
			case Calendar.ERA:                  return "Era";
			case Calendar.YEAR:                 return "Year";
			case Calendar.MONTH:                return "Month";
			case Calendar.WEEK_OF_YEAR:         return "Week (of Year)";
			case Calendar.WEEK_OF_MONTH:        return "Week (of Month)";
			case Calendar.DAY_OF_MONTH:         return "Day";
			case Calendar.DAY_OF_YEAR:          return "Day (of Year)";
			case Calendar.DAY_OF_WEEK:          return "Day of Week";
			case Calendar.DAY_OF_WEEK_IN_MONTH: return "Day of Week in Month";
			case Calendar.AM_PM:                return "AM/PM";
			case Calendar.HOUR:                 return "Hour";
			case Calendar.HOUR_OF_DAY:          return "Hour (of Day)";
			case Calendar.MINUTE:               return "Minute";
			case Calendar.SECOND:               return "Second";
			case Calendar.MILLISECOND:          return "Millisecond";
			default:                            return "Unknown";
		}
	}
	
	/**
	 * Extract the specified fields/components from the date/time.
	 * @param c the calendar
	 * @return the values of every calendar field
	 */
	public static int[] extract(Calendar c) {
		int[] ret = new int[Calendar.FIELD_COUNT];
		for (int i = 0; i < ret.length; i++) { ret[i] = c.get(i); }
		return ret;
	}
	
	/**
	 * Extract the specified fields/components from the date/time.
	 * @param d the date
	 * @return the values of every calendar field
	 */
	public static int[] extract(Date d) { return extract(at(d)); }
	
	/**
	 * Extract the specified fields/components from the date/time.
	 * @param millis the time in milliseconds
	 * @return the values of every calendar field
	 */
	public static int[] extract(long millis) { return extract(at(millis)); }
}
