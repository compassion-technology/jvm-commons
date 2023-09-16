/* ©2021 Elder Research, Inc. All rights reserved. */
package com.compassion.commons;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

/**
 * Contains utilties for using DateTime API introduced in Java 8
 * 
 * @author <a href="mailto:colin.thomas@elderresearch.com">Colin Thomas</a>
 * @since December 23, 2021
 *
 */
public final class DateTimeUtils {
	
	public static DateTimeUtils DEFAULT = new DateTimeUtils(ZoneId.systemDefault());
	
	private final ZoneId zoneID;
	
	/**
	 * Create a DateTime API converter with the given Zone ID.
	 * Use {@linkplain #DEFAULT} for converter using system default zone id
	 * @param zoneID
	 */
	public DateTimeUtils(ZoneId zoneID) {
		this.zoneID = zoneID;
	}

	/**
	 * Convert from {@linkplain LocalDate} to {@linkplain Date}
	 */
	public Date dateFrom(LocalDate local) {
		return Date.from(toInstant(local));
	}
	
	/**
	 * Convert from {@linkplain LocalDateTime} to {@linkplain Date}
	 */
	public Date dateFrom(LocalDateTime local) {
		return Date.from(toInstant(local));
	}

	/**
	 * Convert from {@linkplain LocalDate} to {@linkplain Calendar}
	 */
	public Calendar calendarFrom(LocalDate local) {
		return CalendarUtils.at(dateFrom(local));
	}
	
	/**
	 * Convert from {@linkplain LocalDateTime} to {@linkplain Calendar}
	 */
	public Calendar calendarFrom(LocalDateTime local) {
		return CalendarUtils.at(dateFrom(local));
	}
	
	
	/**
	 * Convert from {@linkplain Instant} to {@linkplain LocalDateTime}
	 */
	public LocalDateTime localDateTimeFrom(Instant instant) {
		return instant.atZone(zoneID).toLocalDateTime();
	}
	
	/**
	 * Convert from {@linkplain Date} to {@linkplain LocalDateTime}
	 */
	public LocalDateTime localDateTimeFrom(Date date) {
		return localDateTimeFrom(date.toInstant());
	}
	
	/**
	 * Convert from {@linkplain Calendar} to {@linkplain LocalDateTime}
	 */
	public LocalDateTime localDateTimeFrom(Calendar cal) {
		return localDateTimeFrom(cal.toInstant());
	}
	
	/**
	 * Convert from {@linkplain Long} to {@linkplain LocalDateTime}
	 * @param l - long corresponding to the epoch millisecond for the given date/time
	 */
	public LocalDateTime localDateTimeFrom(Long l) {
		return localDateTimeFrom(Instant.ofEpochMilli(l));
	}
	
	
	/**
	 * Convert from {@linkplain Instant} to {@linkplain LocalDate}
	 */
	public LocalDate localDateFrom(Instant instant) {
		return instant.atZone(zoneID).toLocalDate();
	}

	/**
	 * Convert from {@linkplain Date} to {@linkplain LocalDate}
	 */
	public LocalDate localDateFrom(Date date) {
		return localDateFrom(date.toInstant());
	}
	
	/**
	 * Convert from {@linkplain Calendar} to {@linkplain LocalDate}
	 */
	public LocalDate localDateFrom(Calendar cal) {
		return localDateFrom(cal.toInstant());
	}
	
	/**
	 * Convert from {@linkplain Long} to {@linkplain LocalDate}
	 * @param l - long corresponding to the epoch millisecond for the given date/time
	 */
	public LocalDate localDateFrom(Long l) {
		return localDateFrom(Instant.ofEpochMilli(l));
	}
	

	/**
	 * Convert from {@linkplain LocalDateTime} to {@linkplain Instant} using the object's zoneID
	 */
	public Instant toInstant(LocalDateTime localDateTime) {
		return localDateTime.atZone(zoneID).toInstant();
	}
	
	/**
	 * Convert from {@linkplain LocalDate} to {@linkplain Instant} using the object's zoneID
	 */
	public Instant toInstant(LocalDate local) {
		return toInstant(local.atStartOfDay());
	}
	
	
}
