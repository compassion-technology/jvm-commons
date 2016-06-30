/*******************************************************************************
 * Copyright (c) 2016 Elder Research, Inc.
 * All rights reserved.
 *******************************************************************************/
package com.datamininglab.commons.lang.extract;

import java.text.NumberFormat;
import java.util.BitSet;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.function.Consumer;

import com.datamininglab.commons.logging.LogContext;

/**
 * This class tries every available number format to parse a date from a string.
 * While the class is not thread-safe, since it relies on {@link NumberFormat}
 * instances that are not thread-safe, thread-localized instances can be 
 * obtained from the static factory methods of this class.
 * 
 * @author <a href="mailto:dimeo@datamininglab.com">John Dimeo</a>
 * @since Mar 8, 2016
 */
public class NumberExtractor extends Extractor<NumberFormat, Number> {
	/** Specifies which type(s) of numbers to extract. */
	public enum NumberFormatType {
		/** Floating-point numbers. See {@link NumberFormat#getInstance()} */
		DECIMAL,
		/** Integer/whole numbers. See {@link NumberFormat#getIntegerInstance()} */
		INTEGER,
		/** Percentages. See {@link NumberFormat#getPercentInstance()} */
		PERCENT,
		/** Floating-point nubmers with currency symbols. See {@link NumberFormat#getCurrencyInstance()} */
		CURRENCY
	}
	
	private BitSet types;
	
	public NumberExtractor() {
		super(Comparator.comparing(Number::doubleValue), Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, 1.0);
	}
	public NumberExtractor(LocalityLevel locality) {
		this();
		setLocalityLevel(locality);
	}
	
	public void setFormatTypes(NumberFormatType... types) {
		if (types.length == 0) {
			LogContext.warning("Disabling all format types will cause the number extractor to not extract any numbers unless custom formats are specified via setCustomFormats()");
		}
		
		this.types = new BitSet(NumberFormatType.values().length);
		for (NumberFormatType type : types) { this.types.set(type.ordinal(), true); }
		loadFormats();
	}
	
	@Override
	protected Locale[] getAvailableLocales() {
		return NumberFormat.getAvailableLocales();
	}
	
	@Override
	protected void addFormatsFor(Locale l, Consumer<NumberFormat> adder) {
		if (isEnabled(NumberFormatType.DECIMAL)) {
			adder.accept(NumberFormat.getInstance(l));	
		}
		if (isEnabled(NumberFormatType.INTEGER)) {
			adder.accept(NumberFormat.getIntegerInstance(l));	
		}
		if (isEnabled(NumberFormatType.PERCENT)) {
			adder.accept(NumberFormat.getPercentInstance(l));	
		}
		if (isEnabled(NumberFormatType.CURRENCY)) {
			adder.accept(NumberFormat.getCurrencyInstance(l));
		}
	}
	private boolean isEnabled(NumberFormatType type) {
		return types == null || types.get(type.ordinal());
	}
	
	private static Map<LocalityLevel, ThreadLocal<NumberExtractor>> map;
	static {
		map = new HashMap<>();
		for (LocalityLevel l : LocalityLevel.values()) {
			map.put(l, ThreadLocal.withInitial(() -> new NumberExtractor(l)));
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
