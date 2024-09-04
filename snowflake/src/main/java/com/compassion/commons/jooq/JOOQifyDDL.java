package com.compassion.commons.jooq;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.function.UnaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.RegExUtils;
import org.apache.commons.lang3.StringUtils;

import lombok.val;

public class JOOQifyDDL implements UnaryOperator<String> {
	public static void main(String[] args) throws IOException {
		if (args.length == 0) {
			args = new String[] {
				"src/main/sql/base/cof-sql/META_SCHEMA.sql",
				"src/main/sql/base/cof-sql/DATA_SCHEMA.sql",
			};
		}
		
		var converter = new JOOQifyDDL();
		for (val file : args) {
			converter.rewrite(Path.of(file));
		}
	}
	
	public void rewrite(Path p) throws IOException {
		val s = Files.readString(p);
		Files.write(p, Arrays.asList(apply(s)));
	}
	
	@Override
	public String apply(String s) {
		// Replace unsupported VARIANT type with VARBINARY
		s = StringUtils.replace(s, "VARIANT", "VARBINARY");
		// Autoincrement on integer PKs
		s = addIgnore(s, "AUTOINCREMENT INCREMENT [0-9]+");
		// Doesn't understand Snowflake USE SCHEMA
		s = addIgnore(s, "USE SCHEMA [a-zA-Z_]+;");
		// TRANSIENT table types are non-ANSI
		s = addIgnore(s, "TRANSIENT");
		// Table comments aren't understood with = syntax.
		// Add newline so semicolon is on the next line, not immediately after ignore end.
		s = addIgnore(s, "(?s)" + Pattern.quote("COMMENT=$$") + "(.+?)" + Pattern.quote("$$"), System.lineSeparator());
		// Replace non-standard timestamp column type
		s = RegExUtils.replaceAll(s, Pattern.quote("TIMESTAMP_TZ(") + "[0-9]+" + Pattern.quote(")"), "TIMESTAMP WITH TIME ZONE");
		// JOOQ likes the paren after the last column's comment to be on the same line
		s = RegExUtils.replaceAll(s, Pattern.quote("$$") + "\\s+" + Pattern.quote(")"), Matcher.quoteReplacement("$$)"));
		return s;
	}
	
	private static String addIgnore(String text, String s, String... afterIgnore) {
		return RegExUtils.replaceAll(text, s, "/*[jooq ignore start]*/ $0 /*[jooq ignore stop]*/" + StringUtils.join(afterIgnore));
	}
}
