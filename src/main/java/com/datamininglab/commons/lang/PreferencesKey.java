/*
 * Copyright (c) 2015 Elder Research, Inc.
 * All rights reserved.
 */
package com.datamininglab.commons.lang;

import java.util.Properties;
import java.util.prefs.Preferences;

import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * Interface designed to be used with an {@link Enum} that enumerates the
 * available keys for the preferences in a {@link Preferences} node or a 
 * {@link Properties} table.
 * This interface uses its subclass' {@code toString()} lower-case representation
 * as the key into the node.
 * 
 * @author <a href="mailto:dimeo@datamininglab.com">John Dimeo</a>
 * @since Nov 23, 2015
 */
public interface PreferencesKey {
	default String key() { return toString().toLowerCase(); }
	
	default String get(Preferences node) {
		return StringUtils.defaultString(node.get(key(), null), null);
	}
	default char getChar(Preferences node, char defVal) {
		return CharUtils.toChar(get(node), defVal);
	}
	default boolean isOn(Preferences node) {
		return node.getBoolean(key(), false);
	}
	default long getLong(Preferences node, long defVal) {
		return node.getLong(key(), defVal);
	}
	default double getDouble(Preferences node, double defVal) {
		return node.getDouble(key(), defVal);
	}
	
	default void put(Preferences node, String val) {
		node.put(key(), StringUtils.defaultString(val));
	}
	default void put(Preferences node, char val) {
		put(node, String.valueOf(val));
	}
	default void put(Preferences node, boolean flag) {
		node.putBoolean(key(), flag);
	}
	default void put(Preferences node, long val) {
		node.putLong(key(), val);
	}
	default void put(Preferences node, double val) {
		node.putDouble(key(), val);
	}
	
	default void set(Properties props, String val) {
		props.setProperty(key(), val);
	}
	default String get(Properties props) {
		return props.getProperty(key());
	}
}
