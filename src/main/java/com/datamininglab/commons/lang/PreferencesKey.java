/*******************************************************************************
 * Copyright (c) 2016 Elder Research, Inc.
 * All rights reserved.
 *******************************************************************************/
package com.datamininglab.commons.lang;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.prefs.Preferences;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import com.datamininglab.commons.logging.LogContext;

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
	default char getChar(Properties props, char defVal) {
		return CharUtils.toChar(get(props), defVal);
	}
	default boolean isOn(Properties props) {
		return BooleanUtils.toBoolean(get(props));
	}
	default long getLong(Properties props, long defVal) {
		return NumberUtils.toLong(get(props), defVal);
	}
	default double getDouble(Properties props, double defVal) {
		return NumberUtils.toDouble(get(props), defVal);
	}
	
	/**
	 * Loads properties from a file, and optionally overwrites the specified keys with the system property
	 * if set. This will catch and log any error encountered while loading the file.
	 * @param props the properties to populate
	 * @param file the file from which to load
	 * @param keys the keys to check for overrides in the system properties
	 * @return if the properties were loaded. This returns <tt>true</tt> if no properties file was found or
	 * if it was loaded without error.
	 */
	static boolean load(Properties props, String file, PreferencesKey... keys) {
		try (InputStream is = new FileInputStream(file)) {
			props.load(is);
		} catch (FileNotFoundException e) {
			// Use defaults
		} catch (IOException e) {
			LogContext.warning(e, "Error loading config from %s", file);
			return false;
		}
		
		for (PreferencesKey key : keys) {
			String override = System.getProperty(key.key());
			if (override != null) { props.setProperty(key.key(), override); }
		}
		return true;
	}
}
