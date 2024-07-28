/* ©2017-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.commons.rest.server;

import java.util.Date;
import java.util.Objects;
import java.util.function.Function;

import com.compassion.commons.LambdaUtils;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * JSON-friendly ranges, since using generic ranges (like Apache's range) can't be reflected when serialized. 
 * All bounds are closed/inclusive.
 * 
 * @author <a href="mailto:dimeo@datamininglab.com">John Dimeo</a>
 * @since Mar 1, 2017
 */
public interface Ranges {
	@AllArgsConstructor(access = AccessLevel.PRIVATE)
	class DateRange {
		@Getter private Date minimum, maximum;
	}
	
	@AllArgsConstructor(access = AccessLevel.PRIVATE)
	class DoubleRange {
		@Getter private Double minimum, maximum;
	}
	
	@AllArgsConstructor(access = AccessLevel.PRIVATE)
	class StringRange {
		@Getter private String minimum, maximum;
	}
	
	static DateRange between(Date min, Date max) {
		return new DateRange(min, max);
	}
	static DoubleRange between(Number min, Number max) {
		return new DoubleRange(LambdaUtils.apply(min, Number::doubleValue), LambdaUtils.apply(max, Number::doubleValue));
	}
	static StringRange between(Object min, Object max) {
		return between(min, max, o -> Objects.toString(o, null));
	}
	static <T> StringRange between(T min, T max, Function<T, String> toString) {
		return new StringRange(toString.apply(min), toString.apply(max));
	}
}
