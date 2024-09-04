package com.compassion.commons.jooq;

import java.time.Duration;
import java.util.Date;
import java.util.Objects;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import com.compassion.commons.LambdaUtils;
import com.compassion.commons.NumberExtensions;
import com.compassion.commons.Utilities;

import lombok.val;

/**
 * Workarounds for using the free/generic version of jOOQ. Columns would be correctly typed if we used the dialect-specific
 * version of jOOQ. Also a few other convenience utilities.
 *
 * @author <a href="mailto:dimeo@datamininglab.com">John Dimeo</a>
 * @since Aug 9, 2017
 */
public interface TypeUtils {
	// One annus- number of milliseconds for a tropical year in the year 2000
	long MS_PER_YEAR = 31556925445L;

	static Integer asInt(Object o) {
		if (o instanceof Number) { return NumberExtensions.asInteger(Utilities.cast(o)); }
		val ret = NumberUtils.toInt(asString(o), Integer.MIN_VALUE);
		return ret == Integer.MIN_VALUE? null : ret;
	}
	static Long asLong(Object o) {
		if (o instanceof Number) { return NumberExtensions.asLong(Utilities.cast(o)); }
		val ret = NumberUtils.toLong(asString(o), Long.MIN_VALUE);
		return ret == Long.MIN_VALUE? null : ret;
	}

	static Float asFloat(Object o) {
		if (o instanceof Number) { return NumberExtensions.asFloat(Utilities.cast(o)); }
		val ret = NumberUtils.toFloat(asString(o), Float.NEGATIVE_INFINITY);
		return Float.isFinite(ret)? ret : null;
	}
	static Double asDouble(Object o) {
		if (o instanceof Number) { return NumberExtensions.asDouble(Utilities.cast(o)); }
		val ret = NumberUtils.toDouble(asString(o), Double.NEGATIVE_INFINITY);
		return Double.isFinite(ret)? ret : null;
	}

	static Boolean asBool(Object o) {
		return BooleanUtils.toBooleanObject(asString(o));
	}

	static String asString(Object o) {
		return StringUtils.stripToNull(Objects.toString(o, null));
	}

	static java.sql.Timestamp asTimestamp(Date d) {
		return LambdaUtils.apply(d, $ -> new java.sql.Timestamp($.getTime()));
	}
	static java.sql.Date asDate(Date d) {
		return LambdaUtils.apply(d, $ -> new java.sql.Date($.getTime()));
	}
	static java.sql.Timestamp nowAsTimestamp() {
		return new java.sql.Timestamp(System.currentTimeMillis());
	}
	static java.sql.Date nowAsDate() {
		return new java.sql.Date(System.currentTimeMillis());
	}

	static int asYears(Duration d) {
		return (int) (d.toMillis() / (double) MS_PER_YEAR);
	}
}
