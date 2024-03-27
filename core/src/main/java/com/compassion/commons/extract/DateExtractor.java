/* ©2012-2020 Elder Research, Inc. All rights reserved. */
package com.compassion.commons.extract;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * This class tries every available date format to parse a date from a string.
 * While the class is not thread-safe, since it relies on {@link DateFormat}
 * instances that are not thread-safe, thread-localized instances can be 
 * obtained from the static factory methods of this class.
 * 
 * @author <a href="dimeo@datamininglab.com">John Dimeo</a>
 * @since Jun 30, 2012
 */
public class DateExtractor extends Extractor<DateFormat, Date> {
	// Jan 1, 1500
	private static final Date MIN_DATE = new Date(-14828295600000L);
	// Jan 1, 3000
	private static final Date MAX_DATE = new Date(32506376400000L);
	
	public static final Supplier<Collection<DateFormat>> ISO_LIKE_FORMATS = () -> Arrays.asList(
		// Default Java toString() format
		new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy"),
		new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ"),
		new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ"),
		new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"),
		new SimpleDateFormat("yyyy-MM-dd HH:mm"),
		new SimpleDateFormat("yyyy-MM-dd")
	);
	public static final Supplier<Collection<DateFormat>> MONTH_YEAR_FORMATS = () -> Arrays.asList(
		new SimpleDateFormat("yyyy"),
		new SimpleDateFormat("MMM yyyy"),
		new SimpleDateFormat("MMMM yyyy"),
		new SimpleDateFormat("MMM yy"),
		new SimpleDateFormat("MMMM yy"),
		new SimpleDateFormat("MMMyyyy"),
		new SimpleDateFormat("yyyyMM")
	);
	public static final Supplier<Collection<DateFormat>> EXCEL_FORMATS = () -> Arrays.asList(
		new SimpleDateFormat("dd-MMM-yy"),
		new SimpleDateFormat("dd-MMM-yy H:mm"),
		new SimpleDateFormat("dd-MMM-yy h:mm a"),
		new SimpleDateFormat("M/d/yy"),
		new SimpleDateFormat("M/d/yy H:mm"),
		new SimpleDateFormat("M/d/yy h:mm a")
	);
	
	@SafeVarargs
	public static Supplier<Collection<DateFormat>> concat(Supplier<Collection<DateFormat>>... formats) {
		return () -> Arrays.stream(formats).flatMap(s -> s.get().stream()).collect(Collectors.toList());
	}
	
	public DateExtractor() {
		super(Comparator.naturalOrder(), MIN_DATE, MAX_DATE);
	}
	public DateExtractor(LocalityLevel lvl) {
		this();
		setLocalityLevel(lvl);
	}
	
	@Override
	protected void initFormat(DateFormat format) {
		format.setLenient(false);
	}
	
	@Override
	protected void addFormatsFor(Locale l, Consumer<DateFormat> adder) {
		for (int i = DateFormat.FULL; i <= DateFormat.SHORT; i++) {
			for (int j = DateFormat.FULL; j <= DateFormat.SHORT; j++) {
				adder.accept(DateFormat.getDateTimeInstance(i, j, l));
			}
			adder.accept(DateFormat.getDateInstance(i, l));
		}
	}
	
	private static Map<LocalityLevel, ThreadLocal<DateExtractor>> map;
	static {
		map = new HashMap<>();
		for (LocalityLevel l : LocalityLevel.values()) {
			map.put(l, ThreadLocal.withInitial(() -> new DateExtractor(l)));
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
