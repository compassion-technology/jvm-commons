/*
 * Copyright (c) 2015 Elder Research, Inc.
 * All rights reserved.
 */
package com.datamininglab.commons.lang;

import java.util.Objects;
import java.util.prefs.Preferences;

import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * Interface designed to be used with an {@link Enum} that enumerates the
 * available keys for the preferences in a {@link Preferences} node.
 * This interface uses its subclass' {@code toString()} representation as the
 * key into the node.
 * 
 * @author <a href="mailto:dimeo@datamininglab.com">John Dimeo</a>
 * @since Nov 23, 2015
 */
public interface PreferencesKey {
	default String key() { return toString().toLowerCase(); }
	
	default String get(Preferences node) {
		return StringUtils.trimToNull(node.get(key(), null));
	}
	default Character getChar(Preferences node) {
		return CharUtils.toCharacterObject(get(node));
	}
	default boolean isOn(Preferences node) {
		return node.getBoolean(key(), false);
	}
	default Long getLong(Preferences node) {
		long ret = node.getLong(key(), Long.MIN_VALUE);
		return ret == Long.MIN_VALUE? null : ret;
	}
	default Double getDouble(Preferences node) {
		double ret = node.getDouble(key(), Double.NaN);
		return Double.isNaN(ret)? null : ret; 
	}
	
	default void put(Preferences node, String val) {
		node.put(key(), StringUtils.defaultString(val));
	}
	default void put(Preferences node, Character val) {
		put(node, Objects.toString(val, null));
	}
	default void put(Preferences node, boolean flag) {
		node.putBoolean(key(), flag);
	}
	default void put(Preferences node, Long val) {
		node.putLong(key(), val == null? Long.MIN_VALUE : val.longValue());
	}
	default void put(Preferences node, Double val) {
		node.putDouble(key(), val == null? Double.NaN : val.doubleValue());
	}
}
