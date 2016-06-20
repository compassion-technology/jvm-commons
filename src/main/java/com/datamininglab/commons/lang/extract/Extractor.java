/*
 * Copyright (c) 2016 Elder Research, Inc.
 * All rights reserved.
 */
package com.datamininglab.commons.lang.extract;

import java.text.Format;
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

/**
 * Abstract parent class that contains shared functionality between 
 * {@link DateExtractor} and {@link NumberExtractor}.
 * 
 * @author <a href="mailto:dimeo@datamininglab.com">John Dimeo</a>
 * @param <F> the format class
 * @param <T> the type of value extracted by the extractor
 * @since Mar 8, 2016
 */
abstract class Extractor<F extends Format, T> {
	private List<Locale> locales;
	private Comparator<T> comp;
	private T min, max, defVal;
	
	private List<F> formatsWithLetters;
	private List<F> formatsNumbersOnly;
	
	protected Extractor(Comparator<T> comp, T min, T max, T defVal) {
		this.comp   = comp;
		this.min    = min;
		this.max    = max;
		this.defVal = defVal;
		setLocalityLevel(LocalityLevel.LOCAL);
	}
	
	/** Should be called when a setting changes that affects the list of locales. */
	protected void loadFormats() {
		formatsNumbersOnly = new LinkedList<>();
		formatsWithLetters = new LinkedList<>();
		Set<F> set = new HashSet<>();
		for (Locale l : locales) {
			addFormatsFor(l, f -> add(f, false, set));
		}
	}
	
	protected abstract Locale[] getAvailableLocales();
	protected abstract void addFormatsFor(Locale l, Consumer<F> adder);
	
	/** Optional callback to initialize formats for use by the extractor. */
	protected void initFormat(F format) {
		// Do nothing by default
	}
	
	private void add(F f, boolean atStart, Set<F> unique) {
		if (!unique.add(f)) { return; }
		
		initFormat(f);
		List<F> list = Utilities.containsLetters(f.format(defVal))? formatsWithLetters : formatsNumbersOnly;
		if (atStart) {
			list.add(0, f);
		} else {
			list.add(f);
		}
	}
	
	/**
	 * Sets the list of locales to be based on the convenience locality level.
	 * @param locality the new locality level
	 */
	public void setLocalityLevel(LocalityLevel locality) {
		this.locales = locality.getLocales(getAvailableLocales());
		loadFormats();
	}
	
	/**
	 * Sets the list of locales to a custom list.
	 * @param locales the new list of locales
	 */
	public void setLocales(Locale... locales) {
		this.locales = Arrays.asList(locales);
		loadFormats();
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
	 * Specifies additional formats to try first before using all the available
	 * built-in formats. Note that these formats will be lost and will need
	 * to be re-set if the list of locales changes (via {@link #setLocalityLevel(LocalityLevel)}
	 * or {@link #setLocales(Locale...)}) so you should generally call this setter last.
	 * @param arr the list of formats
	 */
	@SafeVarargs
	public final void addCustomFormats(F... arr) {
		Set<F> set = new HashSet<>(formatsNumbersOnly.size() + formatsWithLetters.size());
		set.addAll(formatsNumbersOnly);
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
		
		ParsePosition pp = new ParsePosition(0);
		List<F> formats = Utilities.containsLetters(text)? formatsWithLetters : formatsNumbersOnly;
		for (F f : formats) {
			pp.setIndex(0);
			T val = Utilities.cast(f.parseObject(text, pp));
			// Return the extracted value if...
			// ... the value is valid
			if (val != null
			// ... there were no errors
			 && pp.getErrorIndex() < 0
			// ... the entire text was used
			 && pp.getIndex() == text.length()
			// ... the value falls within the expected range
			 && comp.compare(val, min) >= 0
			 && comp.compare(val, max) <= 0) { return val; }
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
