/*******************************************************************************
 * Copyright (c) 2016 Elder Research, Inc.
 * All rights reserved.
 *******************************************************************************/
package com.elderresearch.commons.lang.utf;

import java.io.IOException;
import java.io.PrintStream;
import java.lang.Character.UnicodeBlock;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;

import com.elderresearch.commons.lang.ReflectionUtils;
import com.elderresearch.commons.lang.Utilities;

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
final class UnicodeCodeGen {
	private UnicodeCodeGen() {
		// Prevent initialization
	}
	
	private static String cleanName(String name) { return name.replace(' ', '_').replace('-', '_'); }
	
	public static void main(String[] args) throws IOException {
		Map<String, Integer> counts = new HashMap<>();
		for (Field f : ReflectionUtils.getFields(UnicodeBlock.class)) {
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
    	
    	for (Entry<String, List<Character>> e : grouped.entrySet()) {
    		if (e.getValue().size() < 2) { continue; }
    		
    		String clsName = "Unicode" + WordUtils.capitalizeFully(e.getKey());
    		try (PrintStream ps = new PrintStream(clsName + ".java", "UTF-8")) {
    			ps.println("/*******************************************************************************");
    			ps.println(" * Copyright (c) 2017 Elder Research, Inc.");
    			ps.println(" * All rights reserved.");
    			ps.println(" *******************************************************************************/");
    			ps.println(UnicodeCodeGen.class.getPackage() + ";");
    			ps.println();
    			ps.println("// CHECKSTYLE:OFF");
    			ps.println("public interface " + clsName + " {");
    			for (Character c : e.getValue()) {
    				String name = cleanName(Character.getName(c.charValue()));
    				ps.format("    /** %c */ char %s = '\\u%04X';%n", c, name, (int) c.charValue());
    			}
    			ps.println("}");
    			ps.println("// CHECKSTYLE:ON");
    		}
    	}
    }
}
