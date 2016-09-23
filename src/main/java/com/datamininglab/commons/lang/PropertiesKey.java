/*******************************************************************************
 * Copyright (c) 2016 Elder Research, Inc.
 * All rights reserved.
 *******************************************************************************/
package com.datamininglab.commons.lang;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Properties;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.math.NumberUtils;

import com.datamininglab.commons.logging.LogContext;

/**
 * <p>Interface designed to be used with an {@link Enum} that enumerates the
 * available keys for the properties in a {@link Properties} table.
 * This interface uses its subclass' {@code toString()} lower-case representation
 * as the key into the table.</p>
 * <p>If using the singleton-style methods (the ones that do not take a {@link Properties} parameter),
 * you must override and implement the {@link #props()} method.</p>
 * 
 * @author <a href="mailto:dimeo@datamininglab.com">John Dimeo</a>
 * @since Sep 22, 2016
 */
public interface PropertiesKey {
	/**
	 * Returns the properties node to use for the singleton-style methods that do not take a {@link Properties} parameter.
	 * @return the properties node to use, or <tt>null</tt> by default if you always will pass in a table to each method
	 */
	default Properties props() { return null; }
	
	/**
	 * Gets the key that uniquely identifies this property. The default implementation is <tt>toString().toLowerCase()</tt>.
	 * @return the property key
	 */
	default String key() { return toString().toLowerCase(); }
	
	/**
	 * Gets the default value for this key as a string.
	 * @return the default value or <tt>null</tt> if no default has been specified
	 */
	default Object defVal() { return null; }
	
	default String get() {
		return get(props());
	}
	default char getChar() {
		return getChar(props());
	}
	default int getInt() {
		return getInt(props());
	}
	default long getLong() {
		return getLong(props());
	}
	default float getFloat() {
		return getFloat(props());
	}
	default double getDouble() {
		return getDouble(props());
	}
	default boolean isOn() {
		return isOn(props());
	}
	default Path getPath() {
		return getPath(props());
	}
	
	default String get(Properties props) {
		return props.getProperty(key(), Objects.toString(defVal(), null));
	}
	default char getChar(Properties props) {
		return CharUtils.toChar(get(props), (char) 0);
	}
	default int getInt(Properties props) {
		return NumberUtils.toInt(get(props), 0);
	}
	default long getLong(Properties props) {
		return NumberUtils.toLong(get(props), 0L);
	}
	default float getFloat(Properties props) {
		return NumberUtils.toFloat(get(props), 0.0f);
	}
	default double getDouble(Properties props) {
		return NumberUtils.toDouble(get(props), 0.0);
	}
	default boolean isOn(Properties props) {
		return BooleanUtils.toBoolean(get(props));
	}
	default Path getPath(Properties props) {
		return Paths.get(get(props));
	}
	
	default void set(String val) {
		set(props(), val);
	}
	default void set(Properties props, String val) {
		props.setProperty(key(), val);
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
	static boolean load(Properties props, String file, PropertiesKey... keys) {
		try (InputStream is = new FileInputStream(file)) {
			props.load(is);
		} catch (FileNotFoundException e) {
			// Use defaults
		} catch (IOException e) {
			LogContext.warning(e, "Error loading config from %s", file);
			return false;
		}
		
		for (PropertiesKey key : keys) {
			String override = System.getProperty(key.key());
			if (override != null) { props.setProperty(key.key(), override); }
		}
		return true;
	}
}
