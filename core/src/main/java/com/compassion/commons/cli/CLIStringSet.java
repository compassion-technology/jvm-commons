package com.compassion.commons.cli;

import java.util.LinkedHashSet;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.NoArgsConstructor;

/**
 * A simple string set implementation for CLI and YAML config options (since it supports parsing
 * a CSV or semicolon separated environment variable override).
 */
@NoArgsConstructor
public class CLIStringSet extends LinkedHashSet<String> {
	public CLIStringSet(String... arr) {
		for (var s : arr) { add(s); }
	}
	
	public CLIStringSet(Iterable<?> iter) {
		for (var o : iter) { add(o.toString()); }
	}

	@JsonCreator
	public static CLIStringSet parse(String s) {
		// Provide two options so you can use semicolons if you have commas in your values
		if (s.contains(";")) { return new CLIStringSet(StringUtils.split(s, ';')); }
		return new CLIStringSet(StringUtils.split(s, ','));
	}
}
