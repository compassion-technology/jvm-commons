/*******************************************************************************
 * Copyright (c) 2016 Elder Research, Inc.
 * All rights reserved.
 *******************************************************************************/
package com.elderresearch.commons.lang;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Properties;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.math.NumberUtils;

import lombok.val;

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
	default <T extends Enum<T>> T getEnum(Class<T> c) {
		return getEnum(props(), c);
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
	default <T extends Enum<T>> T getEnum(Properties props, Class<T> c) {
		return Utilities.valueOf(c, get(props), Utilities.cast(defVal()));
	}
	
	default void set(String val) {
		set(props(), val);
	}
	default void set(Properties props, String val) {
		props.setProperty(key(), val);
	}
	
	/**
	 * Loads properties from a file, and optionally overwrites the specified keys with the system property or environment
	 * variable if set. This will catch and log any error encountered while loading the file.
	 * @param props the properties to populate
	 * @param file the file from which to load
	 * @param keys the keys to check for overrides in the system properties and environment variables
	 * @throws IOException if there was an error loading the properties from the file
	 */
	static void load(Properties props, String file, PropertiesKey... keys) throws IOException {
		try (val is = new FileInputStream(file)) {
			props.load(is);
		} catch (FileNotFoundException e) {
			// Use defaults
		}
		
		for (PropertiesKey pk : keys) {
			val key = pk.key();
			// Allow system properties to override first
			LambdaUtils.accept(System.getProperty(key), $ -> props.setProperty(key, $));
			// Allow environment variables to override next
			LambdaUtils.accept(System.getenv(key.toUpperCase()), $ -> props.setProperty(key, $));
			LambdaUtils.accept(System.getenv(key), $ -> props.setProperty(key, $));
		}
	}
	
	/**
	 * Concatenate two sets of property keys together into one array. This is useful if you have several sets
	 * of enums that implement this interface but need to pass all keys to {@link #load(Properties, String, PropertiesKey...)}.
	 * @param keys1 the first set of keys
	 * @param keys2 the second set of keys
	 * @return an array with the keys concatenated together
	 */
	static PropertiesKey[] concat(PropertiesKey[] keys1, PropertiesKey[] keys2) {
		val ret = new PropertiesKey[keys1.length + keys2.length];
		System.arraycopy(keys1, 0, ret, 0, keys1.length);
		System.arraycopy(keys2, 0, ret, keys1.length, keys2.length);
		return ret;
	}
}
