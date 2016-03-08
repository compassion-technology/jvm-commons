/*
 * Copyright (c) 2016 Elder Research, Inc.
 * All rights reserved.
 */
package com.datamininglab.commons.lang.extract;

/**
 * Provides a simplified way of specifying the locale "scope" of extract
 * operations.
 * 
 * @author <a href="mailto:dimeo@datamininglab.com">John Dimeo</a>
 * @since Mar 7, 2016
 */
public enum LocalityLevel {
	/** All locales available to the JVM. */
	ALL,
	/** All locales with the same language as the default locale's language. */
	LANGUAGE,
	/** The default locale only. */
	LOCAL
}
