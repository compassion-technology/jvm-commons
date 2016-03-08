/*
 * Copyright (c) 2016 Elder Research, Inc.
 * All rights reserved.
 */
package com.datamininglab.commons.lang.extract;

import java.text.NumberFormat;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.function.Consumer;

import com.datamininglab.commons.lang.Utilities;

public class NumberExtractor extends Extractor<NumberFormat, Number> {
	public NumberExtractor(LocalityLevel locality) {
		super(locality, Comparator.comparing(Number::doubleValue), Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, 1.0);
	}
	
	@Override
	protected Locale[] getAvailableLocales() {
		return NumberFormat.getAvailableLocales();
	}
	
	@Override
	protected void addFormatsFor(Locale l, Consumer<NumberFormat> adder) {
		adder.accept(NumberFormat.getInstance(l));
		adder.accept(NumberFormat.getIntegerInstance(l));
		adder.accept(NumberFormat.getCurrencyInstance(l));
		adder.accept(NumberFormat.getPercentInstance(l));
	}
	
	@Override
	protected void addCustomFormats(Consumer<NumberFormat> adder) {
		// No custom formats
	}
	
	private static Map<LocalityLevel, ThreadLocal<NumberExtractor>> map;
	static {
		map = new HashMap<>();
		for (LocalityLevel l : LocalityLevel.values()) {
			map.put(l, Utilities.threadLocal(() -> new NumberExtractor(l)));
		}
	}
	
	/**
	 * Gets a thread-localized number extractor for the given locality level.
	 * @param locality the locality level
	 * @return a thread-safe date extractor instance
	 */
	public static NumberExtractor getInstance(LocalityLevel locality) {
		return map.get(locality).get();
	}
}
