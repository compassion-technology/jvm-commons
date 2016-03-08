/*
 * Copyright (c) 2016 Elder Research, Inc.
 * All rights reserved.
 */
package com.datamininglab.commons.lang.extract;

import java.text.Format;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.function.Consumer;

import org.apache.commons.lang3.StringUtils;

import com.datamininglab.commons.lang.Utilities;

abstract class Extractor<F extends Format, T> {
	private Comparator<T> comp;
	private T min, max, defVal;
	
	private List<F> formatsWithLetters = new LinkedList<>();
	private List<F> formatsNumbersOnly = new LinkedList<>();
	
	protected Extractor(LocalityLevel lvl, Comparator<T> comp, T min, T max, T defVal) {
		this.comp   = comp;
		this.min    = min;
		this.max    = max;
		this.defVal = defVal;
		
		Set<F> set = new HashSet<>();
		
		// Get the locales specified by the locality parameter
		Locale defLocale = Locale.getDefault();
		String defLang = defLocale.getLanguage();
		List<Locale> locales;
		switch (lvl) {
			case ALL:
				locales = Arrays.asList(getAvailableLocales());
				break;
			case LANGUAGE:
				locales = new LinkedList<>();
				// Ensure the default locale is first (and is tried first)
				locales.add(defLocale);
				for (Locale l : getAvailableLocales()) {
					if (!l.equals(defLocale) && StringUtils.equals(l.getLanguage(), defLang)) { locales.add(l); }
				}
				break;
			case LOCAL: default:
				locales = Arrays.asList(defLocale);
				break;
		}
		
		for (Locale l : locales) {
			addFormatsFor(l, f -> add(f, false, set));
		}
		addCustomFormats(f -> add(f, false, set));
	}
	
	protected abstract Locale[] getAvailableLocales();
	protected abstract void addFormatsFor(Locale l, Consumer<F> adder);
	protected abstract void addCustomFormats(Consumer<F> adder);
	
	protected void init(F format) {
		// Do nothing by default
	}
	
	private void add(F f, boolean atStart, Set<F> unique) {
		if (!unique.add(f)) { return; }
		
		init(f);
		List<F> list = Utilities.containsLetters(f.format(defVal))? formatsWithLetters : formatsNumbersOnly;
		if (atStart) {
			list.add(0, f);
		} else {
			list.add(f);
		}
	}
	
	/**
	 * Sets the minimum value that can be returned by this extractor. Sometimes
	 * a format may match a given string, but the extracted value is outside the
	 * range of expected values, so the extractor should continue trying other
	 * formats.
	 * @param min the minimum allowable value returned by this extractor
	 */
	public void setMininmum(T min) { this.min = min; }
	
	/**
	 * Sets the maximum value that can be returned by this extractor. Sometimes
	 * a format may match a given string, but the extracted value is outside the
	 * range of expected value, so the extractor should continue trying other
	 * formats.
	 * @param max the maximum allowable value returned by this extractor
	 */
	public void setMaximum(T max) { this.max = max; }
	
	/**
	 * Specifies preferred formats to try first before using all the available
	 * built-in formats.
	 * @param arr the list of formats
	 */
	@SafeVarargs
	public final void setPreferredFormats(F... arr) {
		Set<F> set = new HashSet<>(formatsNumbersOnly);
		set.addAll(formatsWithLetters);
		for (F f : arr) { add(f, true, set); }
	}
	
	/**
	 * Attempts to parse the given string, using all available formats. The
	 * value parsed by the first format that doesn't throw an exception is returned.
	 * @param text the value as a string
	 * @return the parsed value, or <tt>null</tt> if none of the available
	 * formats were able to parse the input parameter
	 */
	public T parse(String text) {
		if (StringUtils.isEmpty(text)) { return null; }
		
		List<F> formats = Utilities.containsLetters(text)? formatsWithLetters : formatsNumbersOnly;
		for (F f : formats) {
			try {
				T val = Utilities.cast(f.parseObject(text));
				if (comp.compare(val, min) >= 0 && comp.compare(val, max) <= 0) { return val; }
			} catch (ParseException ex) {
				// Continue to the next date format
			}
		}
		return null;
	}
	
	/**
	 * Walks through the provided text and extracts all occurrences of any
	 * format in the text. The text is parsed at every character location that
	 * follows a non-alphanumeric character by every available format. The
	 * returned collection has the extracted value, some context text, and the
	 * start and  end offsets for each match. 
	 * @param text the text to extract
	 * @return the list of matches
	 */
	public Set<Match<T>> extractAll(String text) {
		Set<Match<T>> ret = new HashSet<>();
		for (F f : formatsNumbersOnly) { extractAll(text, f, ret); }
		for (F f : formatsWithLetters) { extractAll(text, f, ret); }
		return ret;
	}
	
	private void extractAll(String text, F f, Set<Match<T>> out) {
		boolean tryParse = true;
		int c = 0;
		for (ParsePosition pp = new ParsePosition(0); c < text.length(); c++) {
			if (tryParse) {
				pp.setIndex(c); pp.setErrorIndex(-1);
				T val = Utilities.cast(f.parseObject(text, pp));
				if (val != null && comp.compare(val, min) >= 0 && comp.compare(val, max) <= 0) {
					out.add(new Match<>(text, val, c, pp.getIndex()));
					if (pp.getErrorIndex() < 0) { c = pp.getIndex() - 1; }
				}
			}
			
			// Only try parsing dates after non-alphanumeric characters
			tryParse = !Character.isLetterOrDigit(text.charAt(c));
		}
	}
}
