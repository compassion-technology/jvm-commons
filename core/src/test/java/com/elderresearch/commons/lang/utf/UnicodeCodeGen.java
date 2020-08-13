/* ©2012-2020 Elder Research, Inc. All rights reserved. */
package com.elderresearch.commons.lang.utf;

import java.io.IOException;
import java.io.PrintStream;
import java.lang.Character.UnicodeBlock;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.commons.text.WordUtils;

import com.elderresearch.commons.lang.ReflectionUtils;
import com.elderresearch.commons.lang.Utilities;

import lombok.val;
import lombok.experimental.UtilityClass;

/**
 * This class code generates Java interfaces with declared character constants for each unicode character, the majority
 * of which are declared in {@link UnicodeChars}. However, some are split into separate files to limit memory usage
 * and class loading time. The grouping is informed by the blocks declared in {@link UnicodeBlock}. Most other scripts
 * non-Latin scripts are not checked in to this repository (like CJK, Hangul, Katakana, etc.) to limit the dependency
 * size (since this library is used in almost all ERI code), but can be re-generated using this class if they are needed.  
 * 
 * @author <a href="dimeo@datamininglab.com">John Dimeo</a>
 * @since Dec 29, 2012
 */
@UtilityClass
final class UnicodeCodeGen {
	private static String cleanName(String name) { return name.replace(' ', '_').replace('-', '_'); }
	
	public static void main(String[] args) throws IOException {
		Map<Integer, String> types = new HashMap<>();
		for (Field f : FieldUtils.getAllFieldsList(Character.class)) {
			if (Modifier.isStatic(f.getModifiers())
			&& !StringUtils.startsWithAny(f.getName(), "$", "MIN_", "MAX_", "DIRECTIONALITY_", "TYPE", "BYTES", "SIZE")) {
				val b = (Number) ReflectionUtils.get(f, null);
				types.put(b.intValue(), f.getName());
			}
		}
		
		Map<String, Integer> counts = new HashMap<>();
		for (Field f : FieldUtils.getAllFieldsList(UnicodeBlock.class)) {
			if (f.getType() == UnicodeBlock.class) {
				UnicodeBlock b = Utilities.cast(ReflectionUtils.get(f, null));
				String firstPart = StringUtils.substringBefore(b.toString(), "_");
				counts.put(firstPart, counts.getOrDefault(firstPart, 0) + 1);
			}
		}

		Map<String, List<Character>> grouped = new HashMap<>();
		List<Character> other = new ArrayList<>();
		grouped.put("Chars", other);
		
		for (Entry<String, Integer> e : counts.entrySet()) {
			if (e.getValue() > 1) { grouped.put(e.getKey(), new ArrayList<>()); }
		}
    	
    	for (int i = 0; i < Integer.MAX_VALUE; i++) {
    		if (!Character.isDefined(i)
    		 || !Character.isBmpCodePoint(i)) { continue; }
    		
    		int t = Character.getType(i);
			if (t == Character.PRIVATE_USE
			 || t == Character.CONTROL
			 || t == Character.SURROGATE) { continue; }
			
			String name = cleanName(Character.getName(i));
			String group = StringUtils.substringBefore(name, "_");
			grouped.getOrDefault(group, other).add((char) i);
    	}
    	
    	val year = String.valueOf(LocalDate.now().getYear());
    	for (Entry<String, List<Character>> e : grouped.entrySet()) {
    		if (e.getValue().size() < 2) { continue; }
    		
    		String clsName = "Unicode" + WordUtils.capitalizeFully(e.getKey());
    		try (PrintStream ps = new PrintStream(clsName + ".java", "UTF-8")) {
    			ps.println("/* ©2012-" + year + " Elder Research, Inc. All rights reserved. */");
    			ps.println(UnicodeCodeGen.class.getPackage() + ";");
    			ps.println();
    			ps.println("// CHECKSTYLE:OFF");
    			ps.println("public interface " + clsName + " {");
    			for (Character c : e.getValue()) {
    				String name = cleanName(Character.getName(c.charValue()));
    				ps.format("    /** %c of type %s */%n    char %s = '\\u%04X';%n",
    					c, types.get(Character.getType(c)), name, (int) c.charValue());
    			}
    			ps.println("}");
    			ps.println("// CHECKSTYLE:ON");
    		}
    	}
    }
}
