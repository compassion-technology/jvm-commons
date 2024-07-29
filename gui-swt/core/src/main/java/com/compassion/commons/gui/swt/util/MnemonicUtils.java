package com.compassion.commons.gui.swt.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.compassion.commons.Utilities;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class MnemonicUtils {
	private Map<Object, Set<Character>> used = new HashMap<>();

	/**
	 * Gets an available mnemonic.  Available mnemonics are those characters
	 * that have not already been assigned to another control on a per-composite
	 * basis.  If no mnemonic is available, one is not assigned.
	 * @param o the scope (usually a UI component) in which this mnemonic must be unique
	 * @param str the string in which to find an available mnemonic
	 * @param hint the character to use as a mnemonic if it is available, or {@code null} for no hint
	 * @return the original string, with an ampersand ({@code '&'}) in front
	 * of the chosen mnemonic.
	 */
	public String getMnemonic(Object o, String str, Character hint) {
		Set<Character> list = used.get(o);
		if (list == null) {
			list = new HashSet<>();
			used.put(o, list);
		}

		String lower = str.trim().toLowerCase();
		char[] arr = lower.toCharArray();
		int pos = -1;

		//Use the hint if it is available
		if (hint != null) {
			hint = Character.toLowerCase(hint);
			if (!list.contains(hint)) {
				pos = lower.indexOf(hint);
			}
		}

		//First, try the first char of each word
		if (pos < 0) {
			int space = -1;
			do {
				int i = space + 1;
				if (!list.contains(arr[i]) && Character.isLetterOrDigit(arr[i])) {
					pos = i;
					break;
				}
				space = lower.indexOf(' ', i);
			} while (space >= 0);
		}

		//Give preference to consonants because they usually come
		//at the beginning of syllables and are more intuitive
		if (pos < 0) {
			for (int i = 0; i < arr.length; i++) {
				if (!list.contains(arr[i]) && !Utilities.isVowel(arr[i])
				   && Character.isLetterOrDigit(arr[i])) {
					pos = i; break;
				}
			}
		}

		//Finally, try every character or digit
		if (pos < 0) {
			for (int i = 0; i < arr.length; i++) {
				if (!list.contains(arr[i])
				   && Character.isLetterOrDigit(arr[i])) {
					pos = i; break;
				}
			}
		}

		if (pos < 0) { return str; }
		list.add(arr[pos]);
		return str.substring(0, pos) + "&" + str.substring(pos);
	}

	/**
	 * Marks the mnemonic character as being used as to prevent other
	 * controls from using that letter as their mnemonic.  Use this
	 * method if you set the mnemonic character manually for a control.
	 * @param o the scope (usually a UI component) in which this mnemonic must be unique
	 * @param mnemonic the mnemonic that should be marked as "in use"
	 */
	public void markMnemonic(Object o, char mnemonic) {
		Set<Character> list = used.get(o);
		if (list == null) {
			list = new HashSet<>();
			used.put(o, list);
		}
		list.add(Character.toLowerCase(mnemonic));
	}

	/**
	 * Unmarks the string's mnemonic character as being "used" for the
	 * given shell. This is useful if a control's text gets changed.
	 * This method does nothing if {@code str} does not contain an
	 * ampersand ({@code '&'}).
	 * @param o the scope (usually a UI component) in which this mnemonic is unique
	 * @param str the string with a mnemonic to release
	 * mnemonic assignment function
	 */
	public void freeMnemonic(Object o, String str) {
		int pos = str.indexOf('&');
		Set<Character> list = used.get(o);
		if (pos < 0 || list == null) { return; }
		list.remove(Character.toLowerCase(str.charAt(pos + 1)));
	}
}
