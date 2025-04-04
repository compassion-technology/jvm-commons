package com.compassion.commons.cli;

import java.util.LinkedHashSet;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.NoArgsConstructor;
import picocli.CommandLine.ITypeConverter;
import picocli.CommandLine.Parameters;

/**
 * A simple string set implementation for CLI and YAML config options (since it supports parsing
 * a CSV or semicolon separated environment variable override). Use {@link CLIStringSetConverter}
 * with a {@link Parameters} annotation.
 */
@NoArgsConstructor
public class CLIStringSet extends LinkedHashSet<String> {
	public CLIStringSet(String... arr) {
		for (var s : arr) { add(s); }
	}
	
	public CLIStringSet(Iterable<?> iter) {
		for (var o : iter) { add(o.toString()); }
	}
	
	/**
	 * Trim all the elements in this set. This can be helpful if the user separated
	 * the elements with ", " in the configuration.
	 */
	public void trim() {
		var copy = List.copyOf(this);
    	clear();
    	copy.forEach($ -> add($.trim()));
	}

	@JsonCreator
	public static CLIStringSet parse(String s) {
		// Provide two options so you can use semicolons if you have commas in your values
		if (s.contains(";")) { return new CLIStringSet(StringUtils.split(s, ';')); }
		return new CLIStringSet(StringUtils.split(s, ','));
	}
	
	public static class CLIStringSetConverter implements ITypeConverter<CLIStringSet> {
		@Override
		public CLIStringSet convert(String value) throws Exception {
			return CLIStringSet.parse(value);
		}
	}
}
