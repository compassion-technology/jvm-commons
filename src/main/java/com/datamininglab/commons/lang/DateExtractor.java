/*
 * Copyright (c) 2012 Elder Research, Inc.
 * All rights reserved. 
 */
package com.datamininglab.commons.lang;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

/**
 * This class tries every available date format to parse a date from a string.
 * <p><b>Warning:</b> this is class is <b>not</b> thread-safe.</p>
 * 
 * @author <a href="dimeo@datamininglab.com">John Dimeo</a>
 * @since Jun 30, 2012
 */
public class DateExtractor {
	// Epoch- to test formatting
	private static final Date DEF_DATE = new Date(0);
	// Jan 1, 1500
	private static final Date MIN_DATE = new Date(-14828295600000L);
	// Jan 1, 3000
	private static final Date MAX_DATE = new Date(32506376400000L);
	private static final int  CONTEXT_CHARS = 32;
	
	// Supplements the ~500 localized date formats provided by DateFormat
	private static final String[] CUSTOM_FORMATS = {
		"yyyy", "MMM yyyy", "MMMM yyyy", "MMM yy", "MMMM yy", "MMMyyyy"
	};
	
	private Date min = MIN_DATE, max = MAX_DATE;
	
	private List<DateFormat> formatsWithLetters = new LinkedList<>();
	private List<DateFormat> formatsNumbersOnly = new LinkedList<>();
	
	public enum DateLocality {
		/** Use formats from the default locale only (fastest). */
		LOCAL,
		/** Use formats from any locale that starts with the same language code as the default locale. */
		LANGUAGE,
		/** Use formats from all available locales (slowest). */
		ALL
	}
	
	/**
	 * Creates a new date extractor.
	 * @param locality specifies which locales to use when parsing dates.
	 */
	public DateExtractor(DateLocality locality) {
		Set<DateFormat> set = new HashSet<>();
		
		// Get the locales specified by the locality parameter
		Locale defLocale = Locale.getDefault();
		String defLang = defLocale.getLanguage();
		List<Locale> locales;
		switch (locality) {
			case ALL:
				locales = Arrays.asList(DateFormat.getAvailableLocales());
				break;
			case LANGUAGE:
				locales = new LinkedList<>();
				// Ensure the default locale is first (and is tried first)
				locales.add(defLocale);
				for (Locale l : DateFormat.getAvailableLocales()) {
					if (!l.equals(defLocale) && StringUtils.equals(l.getLanguage(), defLang)) { locales.add(l); }
				}
				break;
			case LOCAL: default:
				locales = Arrays.asList(defLocale);
				break;
		}
		
		for (Locale l : locales) {
			for (int j = DateFormat.FULL; j <= DateFormat.SHORT; j++) {
				for (int k = DateFormat.FULL; k <= DateFormat.SHORT; k++) {
					add(DateFormat.getDateTimeInstance(j, k), false, set);
				}
				add(DateFormat.getDateInstance(j, l), false, set);
			}
		}
		
		// Compile custom formats
		for (int i = 0; i < CUSTOM_FORMATS.length; i++) {
			add(new SimpleDateFormat(CUSTOM_FORMATS[i]), false, set);
		}
	}
	
	private void add(DateFormat df, boolean atStart, Set<DateFormat> unique) {
		if (!unique.add(df)) { return; }
		
		df.setLenient(false);
		List<DateFormat> list = Utilities.containsLetters(df.format(DEF_DATE))? formatsWithLetters : formatsNumbersOnly;
		if (atStart) {
			list.add(0, df);
		} else {
			list.add(df);
		}
	}
	
	/**
	 * Sets the minimum date that can be returned by this extractor. Sometimes a date format may
	 * match a given string, but the extracted is outside the range of expected dates, so the
	 * extractor should continue trying other formats.
	 * @param min the minimum (earliest) date returned by this extractor
	 */
	public void setMinDate(Date min) { this.min = min; }
	
	/**
	 * Sets the maximum date that can be returned by this extractor. Sometimes a date format may
	 * match a given string, but the extracted is outside the range of expected dates, so the
	 * extractor should continue trying other formats.
	 * @param max the maximum (latest) date returned by this extractor
	 */
	public void setMaxDate(Date max) { this.max = max; }
	
	/**
	 * Specifies preferred formats to try first before using all the available date formats.
	 * @param arr the list of formats
	 * @see SimpleDateFormat
	 */
	public void setPreferredFormats(DateFormat... arr) {
		Set<DateFormat> set = new HashSet<>(formatsNumbersOnly);
		set.addAll(formatsWithLetters);
		for (DateFormat df : arr) { add(df, true, set); }
	}
	
	/**
	 * Attempts to parse the given string as a date, using all available
	 * formats. The date parsed by the first format that doesn't throw an
	 * exception is returned.
	 * @param date the date as a string
	 * @return the parsed date, or <tt>null</tt> if none of the available
	 * date formats were able to parse the input parameter
	 */
	public Date parse(String date) {
		if (StringUtils.isEmpty(date)) { return null; }
		
		List<DateFormat> formats = Utilities.containsLetters(date)? formatsWithLetters : formatsNumbersOnly;
		for (DateFormat df : formats) {
			synchronized (df) {
				try {
					Date d = df.parse(date);
					if (d.after(min) && d.before(max)) { return d; }
				} catch (ParseException ex) {
					// Continue to the next date format
				}
			}
		}
		return null;
	}
	
	/**
	 * Walks through the provided text and extracts all occurrences of dates
	 * in the text. The text is parsed at every character location that follows
	 * a non-alphanumeric character by every available date format. The returned
	 * collection has the extracted date, some context text, and the start and 
	 * end offsets for each match. 
	 * @param text the text to extract
	 * @return the list of date matches
	 */
	public Set<DateMatch> extractAll(String text) {
		Set<DateMatch> ret = new HashSet<>();
		for (DateFormat df : formatsNumbersOnly) { extractAll(text, df, ret); }
		for (DateFormat df : formatsWithLetters) { extractAll(text, df, ret); }
		return ret;
	}
	
	private void extractAll(String text, DateFormat df, Set<DateMatch> out) {
		ParsePosition pp = new ParsePosition(0);
		boolean tryParse = true;
		for (int c = 0; c < text.length(); c++) {
			if (tryParse) {
				pp.setIndex(c); pp.setErrorIndex(-1);
				Date d;
				synchronized (df) {
					d = df.parse(text, pp);
				}
				if (d != null && d.after(min) && d.before(max)) {
					out.add(new DateMatch(text, d, c, pp.getIndex()));
					if (pp.getErrorIndex() < 0) { c = pp.getIndex() - 1; }
				}
			}
			
			// Only try parsing dates after non-alphanumeric characters
			tryParse = !Character.isLetterOrDigit(text.charAt(c));
		}
	}
	
	public static final class DateMatch implements Comparable<DateMatch> {
		private Date date;
		private int start, end;
		private String context;
		
		private DateMatch(String text, Date date, int start, int end) {
			this.date    = date;
			this.start   = start;
			this.end     = end;
			this.context = text.substring(Math.max(start - CONTEXT_CHARS, 0), start);
		}
		
		public Date   getDate()              { return date;    }
		public int    getStart()             { return start;   }
		public int    getEnd()               { return end;     }
		public String getPreceedingContext() { return context; }
		
		@Override
		public boolean equals(Object obj) {
			// Two matches are equal if they overlap at all and refer to the same date
			DateMatch dm = (DateMatch) obj;
			return ((start  >= dm.start  && start <  dm.end)
				 || (end    >  dm.start  && end   <= dm.end))
				 &&  date.equals(dm.date);
		}
		
		@Override
		public int hashCode() {	return date.hashCode();	}
		
		@Override
		public int compareTo(DateMatch o) {
			return date.compareTo(o.date);
		}
		
		@Override
		public String toString() {
			return date + "[" + start + ", " + end + "]";
		}
	}
}
