/*
 * Copyright (c) 2012 Elder Research, Inc.
 * All rights reserved. 
 */
package com.datamininglab.commons.lang.extract;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.function.Consumer;

import com.datamininglab.commons.lang.Utilities;

/**
 * This class tries every available date format to parse a date from a string.
 * 
 * @author <a href="dimeo@datamininglab.com">John Dimeo</a>
 * @since Jun 30, 2012
 */
public class DateExtractor extends Extractor<DateFormat, Date> {
	// Epoch- to test formatting
	private static final Date DEF_DATE = new Date(0);
	// Jan 1, 1500
	private static final Date MIN_DATE = new Date(-14828295600000L);
	// Jan 1, 3000
	private static final Date MAX_DATE = new Date(32506376400000L);
	
	// Supplements the ~500 localized date formats provided by DateFormat
	private static final String[] CUSTOM_FORMATS = {
		"yyyy-MM-dd'T'HH:mm:ssZ", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd",
		"yyyy", "MMM yyyy", "MMMM yyyy", "MMM yy", "MMMM yy", "MMMyyyy", "yyyyMM"
	};
	
	/**
	 * Creates a new date extractor.
	 * @param locality specifies which locales to use when parsing dates.
	 */
	public DateExtractor(LocalityLevel locality) {
		super(locality, Comparator.naturalOrder(), MIN_DATE, MAX_DATE, DEF_DATE);
	}
	
	@Override
	protected void init(DateFormat format) {
		format.setLenient(false);
	}
	
	@Override
	protected Locale[] getAvailableLocales() {
		return DateFormat.getAvailableLocales();
	}
	
	@Override
	protected void addFormatsFor(Locale l, Consumer<DateFormat> adder) {
		for (int i = DateFormat.FULL; i <= DateFormat.SHORT; i++) {
			for (int j = DateFormat.FULL; j <= DateFormat.SHORT; j++) {
				adder.accept(DateFormat.getDateTimeInstance(i, j));
			}
			adder.accept(DateFormat.getDateInstance(i, l));
		}
	}
	
	@Override
	protected void addCustomFormats(Consumer<DateFormat> adder) {
		for (int i = 0; i < CUSTOM_FORMATS.length; i++) {
			adder.accept(new SimpleDateFormat(CUSTOM_FORMATS[i]));
		}
	}
	
	private static Map<LocalityLevel, ThreadLocal<DateExtractor>> map;
	static {
		map = new HashMap<>();
		for (LocalityLevel l : LocalityLevel.values()) {
			map.put(l, Utilities.threadLocal(() -> new DateExtractor(l)));
		}
	}
	
	/**
	 * Gets a thread-localized date extractor for the given locality level.
	 * @param locality the locality level
	 * @return a thread-safe date extractor instance
	 */
	public static DateExtractor getInstance(LocalityLevel locality) {
		return map.get(locality).get();
	}
}
