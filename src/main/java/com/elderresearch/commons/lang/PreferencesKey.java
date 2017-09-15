/*******************************************************************************
 * Copyright (c) 2016 Elder Research, Inc.
 * All rights reserved.
 *******************************************************************************/
package com.elderresearch.commons.lang;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.prefs.Preferences;

import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * <p>Interface designed to be used with an {@link Enum} that enumerates the
 * available keys for the preferences in a {@link Preferences} node.
 * This interface uses its subclass' {@code toString()} lower-case representation
 * as the key into the node.</p>
 * <p>If using the singleton-style methods (the ones that do not take a {@link Preferences} parameter),
 * you must override and implement the {@link #prefs()} method.</p>
 * 
 * @author <a href="mailto:dimeo@datamininglab.com">John Dimeo</a>
 * @since Nov 23, 2015
 */
public interface PreferencesKey {
	/**
	 * Returns the preferences node to use for the singleton-style methods that do not take a {@link Preferences} parameter.
	 * @return the preferences node to use, or <tt>null</tt> by default if you always will pass in a node to each method
	 */
	default Preferences prefs() { return null; }
	
	/**
	 * Gets the key that uniquely identifies this preference. The default implementation is <tt>toString().toLowerCase()</tt>.
	 * @return the preference key
	 */
	default String key() { return toString().toLowerCase(); }
	
	/**
	 * Gets the default value for this key as a string.
	 * @return the default value or <tt>null</tt> if no default has been specified
	 */
	default Object defVal() { return null; }

	default String get() {
		return get(prefs());
	}
	default char getChar() {
		return getChar(prefs());
	}
	default int getInt() {
		return getInt(prefs());
	}
	default long getLong() {
		return getLong(prefs());
	}
	default float getFloat() {
		return getFloat(prefs());
	}
	default double getDouble() {
		return getDouble(prefs());
	}
	default boolean isOn() {
		return isOn(prefs());
	}
	default Path getPath() {
		return getPath(prefs());
	}
	
	default String get(Preferences prefs) {
		return prefs.get(key(), Objects.toString(defVal(), null));
	}
	default char getChar(Preferences prefs) {
		return CharUtils.toChar(get(prefs), (char) 0);
	}
	default int getInt(Preferences prefs) {
		return prefs.getInt(key(), 0);
	}
	default long getLong(Preferences prefs) {
		return prefs.getLong(key(), 0L);
	}
	default float getFloat(Preferences prefs) {
		return prefs.getFloat(key(), 0.0f);
	}
	default double getDouble(Preferences prefs) {
		return prefs.getDouble(key(), 0.0);
	}
	default boolean isOn(Preferences prefs) {
		return prefs.getBoolean(key(), false);
	}
	default Path getPath(Preferences prefs) {
		return Paths.get(get(prefs));
	}
	
	default void put(String val) {
		put(prefs(), val);
	}
	default void put(char val) {
		put(prefs(), val);
	}
	default void put(boolean flag) {
		put(prefs(), flag);
	}
	default void put(long val) {
		put(prefs(), val);
	}
	default void put(double val) {
		put(prefs(), val);
	}
	
	default void put(Preferences prefs, String val) {
		prefs.put(key(), StringUtils.defaultString(val));
	}
	default void put(Preferences prefs, char val) {
		put(String.valueOf(val));
	}
	default void put(Preferences prefs, boolean flag) {
		prefs.putBoolean(key(), flag);
	}
	default void put(Preferences prefs, long val) {
		prefs.putLong(key(), val);
	}
	default void put(Preferences prefs, double val) {
		prefs.putDouble(key(), val);
	}
}
