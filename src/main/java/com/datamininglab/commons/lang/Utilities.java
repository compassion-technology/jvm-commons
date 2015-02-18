/*
 * Copyright (c) 2012 Elder Research, Inc.
 * All rights reserved.
 */
package com.datamininglab.commons.lang;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.DatatypeConverter;

import com.datamininglab.commons.logging.LogContext;

/**
 * A collection of common stateless utilities.
 * 
 * @author <a href="dimeo@datamininglab.com">John Dimeo</a>
 * @since Sep 26, 2012
 */
public final class Utilities {
	private static final DateFormat DF = new SimpleDateFormat("yyyy-MM-dd");
	// The following isn't 0 since it's the epoch in our time zone, not GMT
	public static final long DATE_1970_1_1 = Utilities.parseDate(DF, "1970-01-01", null).getTime();
	public static final long DATE_1900_1_1 = Utilities.parseDate(DF, "1900-01-01", null).getTime();
	public static final long DATE_2000_1_1 = Utilities.parseDate(DF, "2000-01-01", null).getTime();
	
	//10 MB (1 char = 2 bytes)
	private static final int DEFAULT_BUFFER = 5242880;
	public static final String DEFAULT_CONTENT_TYPE = "text/plain; charset=us-ascii";
	
	private static final Pattern SSN = Pattern.compile(".*(\\d{3})-?(\\d{2})-?(\\d{4}).*");
	private static final Pattern PAIRED_QUOTES = Pattern.compile("^[\\s]*['\"](.*)['\"][\\s]*$");
	
	private Utilities() {
		// Prevent initialization
	}
	
	/**
	 * Removes leading and trailing whitespace and matching single and
	 * double quotes.  For example, <br>
	 * <tt>stripQuotes("  'hello world '") = "hello world"</tt>
	 * @param s the string to clean
	 * @return the cleaned string
	 */
	public static String stripQuotes(String s) {
		if (s == null) { return null; }
		
		Matcher m = PAIRED_QUOTES.matcher(s);
		return m.matches()? m.group(1).trim() : s.trim();
	}
	
	/**
	 * Compares the distribution of lengths of the provided tokens
	 * and compares them against the expected length distribution of
	 * the English language, returning a score to describe how "normal"
	 * or "well formed" the provided tokens are.  
	 * @param tokens a set of tokens
	 * @return a score describing how much the lengths of the tokens
	 * vary from the expected token length distribution.  A lower score
	 * means the tokens closely match the expected distribution.
	 * @see #getTokenLengthScore(long[], long)
	 */
	public static float getTokenLengthScore(String[] tokens) {
		if (tokens.length == 0) { return Float.MAX_VALUE; }
		
		long[] counts = new long[24];
		for (int i = 0; i < tokens.length; i++) {
			int len = tokens[i].length();
			counts[Math.min(len, counts.length - 1)]++;
		}
		return getTokenLengthScore(counts, tokens.length);
	}
	
	/**
	 * Compares the distribution of token lengths against the expected
	 * length distribution of the English language, returning a score
	 * to describe how "normal" or "well formed" the provided token lengths are.  
	 * @param tokenLenDist a distribution of token lengths. Each array 
	 * index is the token length, and the array value is the count of tokens
	 * with that length.
	 * @param tokens the total number of tokens (used to normalize the distribution)
	 * @return a score describing how much the provided distribution varies
	 * from the expected token length distribution.  A lower score
	 * means the token lengths closely match the expected distribution.
	 * @see #getTokenLengthScore(String[])
	 */
	public static float getTokenLengthScore(long[] tokenLenDist, long tokens) {
		double score = 0.0;
		double denom = 1.0 / tokens;
		for (int i = 1; i < tokenLenDist.length; i++) {
			 double expected = 0.16 * Math.pow(i, 2.33) * Math.pow(0.49, i);
			 double diff = Math.abs(expected - tokenLenDist[i] * denom);
			 score += diff * diff;
		}
		return (float) score;
	}

	/**
	 * Compares the length of a token against its length w/o "Junk" Characters.
	 * @param token - the token to be compared
	 * @return a score (0 - 1) showing how much of the token is NOT junk
	 */
	public static float getTokenNonJunkCharacterRate(String token) {
		if (token.length() < 1) {
			return 0.0f;
		}
		String cleanedToken = token.replaceAll("[^ -~]", "");
		
		return Float.valueOf(cleanedToken.length()) / Float.valueOf(token.length());
	}
	
	/**
	 * Applies the same format string to each element of a <tt>float</tt> array,
	 * concatenating each formatted string together with a space.
	 * @param format the format to use for each element (i.e. <tt>"%3.2f"</tt>)
	 * @param array the array to format
	 * @return a formatted string
	 * @see String#format(String, Object...)
	 */
	public static String deepFormat(String format, float[] array) {
		StringBuilder sb = new StringBuilder();
		Object[] obj = new Object[array.length];
		for (int i = 0; i < array.length; i++) {
			sb.append(format + " ");
			obj[i] = array[i];
		}
		return String.format(sb.toString().trim(), obj);
	}

	/**
	 * Applies the same format string to each element of an <tt>int</tt> array,
	 * concatenating each formatted string together with a space.
	 * @param format the format to use for each element (i.e. <tt>"%5d"</tt>)
	 * @param array the array to format
	 * @return a formatted string
	 * @see String#format(String, Object...)
	 */
	public static String deepFormat(String format, int[] array) {
		StringBuilder sb = new StringBuilder();
		Object[] obj = new Object[array.length];
		for (int i = 0; i < array.length; i++) {
			sb.append(format + " ");
			obj[i] = array[i];
		}
		return String.format(sb.toString().trim(), obj);
	}
	
	private static final char[] NUM_PREFIX_SYM = {
		'k', 'm', 'g', 't', 'p', 'e', 'z', 'y'
	};
	
	/**
	 * Converts a long into its string representation of no more than 4 significant digits,
	 * using SI prefixes like <tt>k</tt> for "kilo" (1,000) and <tt>m</tt> for "mega" (1,000,000).
	 * This method does not round mathematically- it only does string manipulation.
	 * For example: <code>compactLargetNumber(1234567L) = "1,234k"</code>
	 * @param l the number to format
	 * @return the compacted number
	 */
	public static String compactLargeNumber(long l) {
		String s = String.valueOf(l);
		int i = -1;
		int n;
		while ((n = s.length()) > 4) {
			s = s.substring(0, n - 3); i++;
		}
		
		if (n == 4) { s = s.charAt(0) + "," + s.substring(1); }
		if (i >= 0) { s += NUM_PREFIX_SYM[i]; }
		return s;
	}
	
	/**
	 * Gets the charset name inside a <tt>Content-Type</tt> header.  If the
	 * charset name cannot be parsed, <tt>"us-ascii"</tt> is returned. 
	 * For example, <tt>getEncoding("text/plain; charset=utf-8")</tt> returns
	 * <tt>"utf-8"</tt>.
	 * @param s the <tt>Content-Type</tt> string to parse
	 * @return the encoding
	 */
	public static String getEncoding(String s) {
		if (s == null) { return getEncoding(DEFAULT_CONTENT_TYPE); }
		int semi = s.indexOf('=');
		if (semi < 0) { return getEncoding(DEFAULT_CONTENT_TYPE); }
		String enc = s.substring(semi + 1).trim();
		if (enc.isEmpty()) { return getEncoding(DEFAULT_CONTENT_TYPE); }
		return enc;
	}
	
	/**
	 * Returns the extension of the filename. This is the
	 * substring starting at the last index of <tt>'.'</tt>.
	 * If the filename does not contain a <tt>'.'</tt>, an
	 * empty string is returned.
	 * @param filename a file name 
	 * @return the file's extension, including the <tt>'.'</tt>
	 */
	public static String getExtension(String filename) {
		int i = filename.lastIndexOf('.');
		int j = filename.length();
		if (i < 0) { return ""; }
		for (int k = i + 1; k < filename.length(); k++) {
			if (!Character.isLetterOrDigit(filename.charAt(k))) {
				j = k; break;
			}
		}
		return filename.substring(i, j);
	}
	
	/**
	 * Gets the absolute path of the directory in which the program is installed.
	 * @return a string with the program's absolute path (ends with a <tt>'\'</tt>)
	 */
	public static String getInstallPath() {
		String s = new File("install.path").getAbsolutePath();
		return s.substring(0, s.lastIndexOf('\\')) + '\\';
	}
	
	/**
	 * Finds the Edit Distance between strings s1 and s2. The Edit Distance
	 * is defined as the minimum number of single-character edit operations 
	 * (deletions, insertions, and/or replacements) that would convert
	 * <tt>s1</tt> into <tt>s2</tt> or vice-versa. Uses an efficient dynamic
	 * programming algorithm. Useful for gene sequence matching, among other
	 * applications.<br><br>Examples:<br>
	 * <code>getEditDistance("cow", "house")</code> returns a value of <tt>4</tt>.<br>
	 * <code>getEditDistance("now", "cow")</code> returns a value of <tt>1</tt>.<br>
	 * <code>getEditDistance("ATTTGCATTA","ATTGCTT")</code> returns a value of <tt>3</tt>.<br>
	 * <br>If there are more than two inputs, the 3d, 4th, and 5th inputs will be
	 * interpreted as the costs of the three edit operations: DELETION, INSERTION,
	 * and REPLACEMENT respectively. The default is <tt>1</tt> for all three
	 * operations. Note that if the cost of replacement is at least twice the
	 * respective costs of deletion and insertion, replacements will never be
	 * performed.<br><br>Examples:<br>
	 * <code>getEditDistance("cow", "house", 1, 1, 1)</code> returns a value of <tt>4</tt>.<br>
	 * <code>getEditDistance("cow", "house", 1, 2, 1.5)</code> returns a value of <tt>5</tt>.<br>
	 * <code>getEditDistance("cow", "house", 1, 1, 2)</code> returns a value of <tt>6</tt>.<br>
	 * <br>Written and tested in Matlab 5.3, Release 11.1 (should work with earlier versions).
	 * @author Miguel A. Castro (talk2miguel@yahoo.com)
	 * @author John Dimeo (translated to Java)
	 * @version 6/4/2000
	 * @param s1 the first string
	 * @param s2 the second string
	 * @param costDelete the cost of a deletion operation
	 * @param costInsert the cost of an insertion operation
	 * @param costReplace the cost of a replacement operation
	 * @return the edit distance between the two strings
	 */
	public static float getEditDistance(String s1, String s2, float costDelete, float costInsert, float costReplace) {
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();
		int n1 = s1.length();
		int n2 = s2.length();
		
		float[][] d = new float[n1 + 1][n2 + 1];
		for (int i = 0; i < n1; i++) {
			d[i + 1][0] = d[i][0] + costDelete;
		}
		for (int j = 0; j < n2; j++) {
			d[0][j + 1] = d[0][j] + costInsert;
		}
		for (int i = 0; i < n1; i++) {
			for (int j = 0; j < n2; j++) {
				float rep = (s1.charAt(i) == s2.charAt(j))? 0.0f : costReplace;
				float c1 = d[i][j] + rep;
				float c2 = d[i + 1][j] + costDelete;
				float c3 = d[i][j + 1] + costInsert;
				d[i + 1][j + 1] = Math.min(c1, Math.min(c2, c3));
			}
		}
		return d[n1][n2];
	}
	
	/** See {@link #getEditDistance(String, String, float, float, float)} for the full
	 *  documentation for this method.  
	 *  @param s1 the first string
	 *  @param s2 the second string
	 *  @return the edit distance between the two strings*/
	public static float getEditDistance(String s1, String s2) {
		return getEditDistance(s1, s2, 1.0f, 1.0f, 1.0f);
	}
	
	private static char[] vowels = "aeiouAEIOU".toCharArray();
	/**
	 * Returns if the character is a vowel.
	 * @param c the character to test
	 * @return if <tt>c</tt> is an <tt>a</tt>, <tt>e</tt>, <tt>i</tt>, <tt>o</tt> or <tt>u</tt> (case-insensitive)  
	 */
	public static boolean isVowel(char c) {
		return Arrays.binarySearch(vowels, c) >= 0;
	}
	
	/**
	 * Encloses the string in single quotes (<tt>'</tt>) if the string can
	 * <b>not</b> be parsed as a number and it is not already enclosed in single
	 * or double quotes.
	 * @param s the string
	 * @return the string enclosed with single quotes (if it is not a number)
	 */
	public static String addQuotes(String s) {
		if (s == null) { return null; }
		
		double d;
		try {
			d = Double.parseDouble(s);
		} catch (NumberFormatException e) {
			d = Double.NaN;
		}
		
		Matcher m = PAIRED_QUOTES.matcher(s);
		if (Double.isNaN(d) && !m.matches()) {
			return String.format("'%s'", s);
		}
		return s;
	}
	
	/**
	 * Creates the plural form of the passed string.  This method is not
	 * exhaustive but covers most English singular nouns.
	 * @param s a singular string
	 * @return the pluralized form of <tt>s</tt>
	 */
	public static String pluralize(String s) {
		try {
			char c = Character.toLowerCase(s.charAt(s.length() - 1));
			if (c == 's') { return s + "es"; }
			char b = Character.toLowerCase(s.charAt(s.length() - 2));
			String sub = s.substring(0, s.length() - 1);
			if (c == 'x') { return b == 'o'? s + "es" : sub + "cies"; }
			if (c == 'y' && !isVowel(b)) { return sub + "ies"; }
			return s + "s";
		} catch (IndexOutOfBoundsException ex) {
			return s + "s";
		}
	}
	
	/**
	 * If the object is a number, the value is formatted with the specified
	 * precision via {@link #stringValue(double, int)}. Otherwise, the default
	 * {@link Object#toString()} is returned.
	 * @param o the object to format
	 * @param precision the number of decimal places to show if <tt>d</tt> is not a whole number. If
	 * this is less than <tt>0</tt> or <tt>Integer.MAX_VALUE</tt>, the default string is returned
	 * @return the formatted object, or <tt>null</tt> if <tt>o</tt> is <tt>null</tt>
	 */
	public static String stringValue(Object o, int precision) {
		if (o == null) { return null; }
		
		if (o instanceof Number) {
			Number n = (Number) o;
			return stringValue(n.doubleValue(), precision);
		}
		return o.toString();
	}
	
	/**
	 * Formats the number as a string, handling decimal places in a more advanced way than the
	 * default logic.  If the rounded value of <tt>d</tt> is equal to <tt>d</tt>, the returned
	 * string is a whole number (no decimal point shown).  If not, <tt>precision</tt> determines
	 * how many decimal places are shown.
	 * @param d the number to format
	 * @param precision the number of decimal places to show if <tt>d</tt> is not a whole number. If
	 * this is less than <tt>0</tt> or <tt>Integer.MAX_VALUE</tt>, the default string is returned
	 * @return the formatted number
	 */
	public static String stringValue(double d, int precision) {
		long l = Math.round(d);
		if (l == d) {  return String.valueOf(l); }
		
		if (precision < 0 || precision == Integer.MAX_VALUE) {
			return String.valueOf(d);
		}
		return String.format("%1." + precision + "f", d);
	}
	
	/**
	 * Tests if the provided string has one or more digit characters.
	 * @param s the string to test
	 * @return if one or more characters are digits or <tt>false</tt> if <tt>s</tt>
	 * is <tt>null</tt>
	 * @see Character#isDigit(char)
	 */
	public static boolean containsDigits(String s) {
		if (s == null) { return false; }
		
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) { return true; }
		}
		return false;
	}
	
	/**
	 * Derives a more user-friendly name of a string following the
	 * <tt>enum</tt> naming convention.  For example, the friendly
	 * version of <tt>"ENUM_NAME"</tt> is <tt>"Enum name"</tt>. 
	 * @param e a string following the <tt>enum</tt> naming
	 * convention
	 * @return a more user-friendly version of the string
	 */
	public static String getFriendlyString(Enum<?> e) {
		return getFriendlyString(e.name());
	}
	
	/**
	 * Derives a more user-friendly name of a string following the constant naming convention.
	 * For example, the friendly version of <tt>"ENUM_NAME"</tt> is <tt>"Enum name"</tt>. 
	 * @param s a string following the constant naming convention
	 * @return a more user-friendly version of the string
	 */
	public static String getFriendlyString(String s) {
		if (s == null) { return null; }
		s = s.replace('_', ' ').trim();
		return Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
	}

	/**
	 * Finds the enum instance corresponding to the provided string. If no
	 * enums are declared that match <tt>name</tt>, <tt>defaultValue</tt> is returned.
	 * @param <T> the type of enum
	 * @param c the class of enums to search
	 * @param name the name of the enum (can be <tt>null</tt>)
	 * @param defaultValue the enum to return if no enum with name <tt>name</tt> is found
	 * (can be <tt>null</tt>)
	 * @return the matching enum, or <tt>defaultValue</tt>
	 */
	public static <T extends Enum<T>> T valueOf(Class<T> c, String name, T defaultValue) {
		if (name == null) {  return defaultValue; }
		try {
			return Enum.valueOf(c, name.toUpperCase().replace(' ', '_'));
		} catch (IllegalArgumentException ex) {
			return defaultValue;
		}
	}
	
	/**
	 * Formats a string as a social security number.  If <tt>s</tt> is <tt>null</tt>
	 * or does not appear to be a SSN, it is returned.  Otherwise, the matching
	 * group of 9 numbers, with hyphens ("<tt>-</tt>") added after the first
	 * group of 3 and the second group of 2, is returned with any leading or
	 * trailing characters removed.
	 * @param s the string to format
	 * @return the 11-character formatted SSN, or the original string if it does
	 * not appear to be a valid SSN
	 */
	public static String formatSSN(String s) {
		if (s == null) { return null; }
		
		Matcher m = SSN.matcher(s);
		return m.matches()? m.group(1) + "-" + m.group(2) + "-" + m.group(3) : s;
	}
	
	/**
	 * Returns the <a href="http://en.wikipedia.org/wiki/Soundex">Soundex</a>
	 * code for the given string.
	 * @param s the string to encode
	 * @return the Soundex encoding
	 */
	public static String getSoundex(String s) {
		if (s == null || s.isEmpty()) { return null; }
		
        s = s.toUpperCase();
        StringBuilder sb = new StringBuilder(s.length());
        sb.append(s.charAt(0));

        char prev = '0';
        for (int i = 1; i < s.length() && sb.length() < 4; i++) {
            switch (s.charAt(i)) {
                case 'B': case 'F': case 'P': case 'V':
                	if (prev != '1') { sb.append(prev = '1'); }
                	break;
                case 'C': case 'G': case 'J': case 'K':
                case 'Q': case 'S': case 'X': case 'Z':
                	if (prev != '2') { sb.append(prev = '2'); }
                	break;
                case 'D': case 'T':
                	if (prev != '3') { sb.append(prev = '3'); }
                	break;
                case 'L':
                	if (prev != '4') { sb.append(prev = '4'); }
                	break;
                case 'M': case 'N':
                	if (prev != '5') { sb.append(prev = '5'); }
                	break;
                case 'R':
                	if (prev != '6') { sb.append(prev = '6'); }
                	break;
                default:
                	break;
            }
        }
        
        while (sb.length() < 4) { sb.append('0'); }
        return sb.toString();
	}
	
	private static final String[] COMMON_DELIMS = {
		",", "\t", ";", Pattern.quote("|"), Pattern.quote("~"), Pattern.quote("^"), "[ \t]+"
	};
	
	/**
	 * Attempts to automatically detect the delimiter based on the lines that
	 * are passed as the "preview" of the data.  If nothing splits all the lines
	 * into the same number of columns, <tt>null</tt> is returned.
	 * @param preview a few lines of the data file
	 * @return the data file's delimiter
	 */
	public static String getDelimiter(String... preview) {
		return getDelimiter(Arrays.asList(preview));
	}
	
	/**
	 * Attempts to automatically detect the delimiter based on the lines that
	 * are passed as the "preview" of the data.  If nothing splits all the lines
	 * into the same number of columns, <tt>null</tt> is returned.
	 * @param preview a few lines of the data file
	 * @return the data file's delimiter
	 */
	public static String getDelimiter(Collection<String> preview) {
		String delim = null;
		Map<String, Integer> map = new HashMap<>();
		for (String d : COMMON_DELIMS) {
			for (String line : preview) {
				if (line == null) { break; }
				Integer len = map.get(d);
				if (len == null) {
					len = line.split(d, -1).length;
					if (len  > 1) { map.put(d, len); }
				} else if (line.split(d, -1).length != len) {
					map.put(d, -1);
				}
			}
		}
		for (Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() != null && entry.getValue() > 0) {
				delim = entry.getKey();
				break;
			}
		}
		return delim;
	}
	
	/**
	 * Gets the letter combination corresponding to the
	 * number:<br><code>
	 * 1 &nbsp;= A<br> 2 &nbsp;= B<br>...<br>
	 * 26 = Z<br> 27 = AA<br> 28 = AB<br> </code>etc...<br>
	 * (Microsoft Excel uses this lettering for column headers)
	 * @param i the number to convert
	 * @return a string corresponding to number <tt>i</tt>
	 */
	public static String getLetters(int i) {
		//Taken from AbstractTableModel.getColumnName(int column)
		String result = "";
		for (i = i - 1; i >= 0; i = i / 26 - 1) {
		    result = (char) ((char) (i % 26) + 'A') + result;
		}
	    return result;
	}
	
	private static final byte[] HEX_CHAR_TABLE = {
			(byte) '0', (byte) '1', (byte) '2', (byte) '3',
			(byte) '4', (byte) '5', (byte) '6', (byte) '7',
			(byte) '8', (byte) '9', (byte) 'a', (byte) 'b',
			(byte) 'c',	(byte) 'd', (byte) 'e', (byte) 'f' };
	/**
	 * Converts a byte array to its corresponding hex representation. This implementation
	 * is faster than {@link DatatypeConverter#printHexBinary(byte[])}, but may be
	 * deprecated in the future.
	 * @param raw the byte array
	 * @return its hex representation (lower case)
	 */
	public static String getHexString(byte[] raw) {
		byte[] hex = new byte[2 * raw.length];
		for (int i = 0, j = 0; i < raw.length; i++) {
			int v = raw[i] & 0xFF;
			hex[j++] = HEX_CHAR_TABLE[v >>> 4];
			hex[j++] = HEX_CHAR_TABLE[v & 0xF];
		}
		try {
			return new String(hex, "ASCII");
		} catch (UnsupportedEncodingException ex) {
			throw new IllegalStateException();
		}
	}
	
	/**
	 * Converts a hex string to its corresponding byte array.
	 * The length of <tt>hex</tt> must be divisible by two.
	 * @param hex the hex representation of a byte array
	 * @return a byte array
	 */
	public static byte[] getByteArray(String hex) {
		byte[] arr;
		try {
			arr = hex.getBytes("ASCII");
		} catch (UnsupportedEncodingException e) {
			throw new IllegalStateException();
		}
		
		int b0 = HEX_CHAR_TABLE[0];
		int ba = HEX_CHAR_TABLE[10] - 10;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (byte) (arr[i] - (arr[i] > '9'? ba : b0));
		}
		
		byte[] raw = new byte[arr.length / 2];
		for (int i = 0, j = 0; i < raw.length; i++) {
			raw[i] = (byte) ((arr[j++] << 4) | arr[j++]);
		}
		return raw;
	}
	
	/**
	 * Instantiates a new object that subclasses a parent object,
	 * copying the value all of the parent's fields into the
	 * subclass' fields.<br>
	 * <b>Note:</b> This class shallow copies all non-static fields,
	 * so any modification to the returned instance's fields will
	 * also modify the parent's fields
	 * @param instance an instance of the parent class
	 * @param clazz the "parent" class
	 * @param subClass the "child" class which extends <tt>T</tt>
	 * @return a new instance of the child class with all inherited
	 * fields set to the values of the parent's fields
	 * @param <T> the "parent" type
	 * @param <S> the "child" type which extends <tt>T</tt>
	 */
	public static <T, S extends T> S asSubclass(T instance, Class<T> clazz, Class<S> subClass) {
		S sub = ReflectionUtils.newInstance(subClass);
		
		Field[] fields = clazz.getDeclaredFields();
		for (Field f : fields) {
			if (Modifier.isStatic(f.getModifiers())) { continue; }
			
			f.setAccessible(true);
			ReflectionUtils.set(f, sub, ReflectionUtils.get(f, instance));
		}
		return sub;
	}

	/**
	 * Generic cast method. Use with caution as it bypasses compiler checks.
	 * @param toCast the object to cast
	 * @return the casted objectS
	 */
	@SuppressWarnings("unchecked")
	public static <S, T> T cast(S toCast) {
	    return (T) toCast;
	}
	
	/**
	 * Reads and returns the entire contents of a text file as a UTF-8, UTF-16 etc. string
	 * using the NIO utilities.
	 * @param file the file to read
	 * @param charset the charset name to use as an interpreter eg. UTF-8, UTF-16
	 * @return a string with the entire contents of the file
	 * @throws IOException if there was a problem reading the file
	 */
	public static String readNIO(File file, String charset) throws IOException {
		try (FileInputStream stream  = new FileInputStream(file);
		     FileChannel     channel = stream.getChannel()) {
			MappedByteBuffer buffer  = channel.map(MapMode.READ_ONLY, 0, file.length());
        	return Charset.forName(charset).decode(buffer).toString();
        }
	}
	
	/**
	 * Reads and returns the entire contents of a text file as a byte array.
	 * @param file the file to read
	 * @return a byte array with the entire contents of the file
	 * @throws IOException if there was a problem reading the file
	 */
	public static byte[] readBytes(File file) throws IOException {
	    try (FileInputStream stream = new FileInputStream(file);
	         FileChannel channel = stream.getChannel()) {

	        long fileSize = file.length();
	        MappedByteBuffer buffer = channel.map(MapMode.READ_ONLY, 0L, fileSize);
		    byte[] data = new byte[(int) fileSize];
	        for (int i = 0; i < fileSize; i++) {
	            data[i] = buffer.get();
	        }
	        return data;
	    }
	}

	/**
	 * Creates a buffered text writer object to write text to a file.
	 * @param file the file to write text to
	 * @param buffer the size of the buffer
	 * @return a buffered text writer
	 * @throws FileNotFoundException if the file specified cannot be written to
	 */
	public static PrintStream write(File file, int buffer) throws FileNotFoundException {
		return new PrintStream(new BufferedOutputStream(new FileOutputStream(file), buffer));
	}
	
	/**
	 * Creates a buffered text writer object to write text to a file,
	 * using the default buffer size.
	 * @param file the file to write text to
	 * @return a buffered text writer
	 * @throws FileNotFoundException if the file specified can not be written to
	 */
	public static PrintStream write(File file) throws FileNotFoundException {
		return write(file, DEFAULT_BUFFER);
	}
	
	/**
	 * Creates a buffered text writer object to write text to a file. 
	 * @param file the path of the file to write text to
	 * @param buffer the size of the buffer
	 * @return a buffered text writer
	 * @throws FileNotFoundException if the file specified can not be written to
	 */
	public static PrintStream write(String file, int buffer) throws FileNotFoundException {
		return write(new File(file), buffer);
	}
	
	/**
	 * Creates a buffered text writer object to write text to a file,
	 * using the default buffer size.
	 * @param file the path of the file to write text to
	 * @return a buffered text writer
	 * @throws FileNotFoundException if the file specified can not be written to
	 */
	public static PrintStream write(String file) throws FileNotFoundException {
		return write(file, DEFAULT_BUFFER);
	}
	
	/** Wraps a string builder with an output stream. */
	public static class StringOutputStream extends OutputStream {
		private StringBuilder sb;
		
		public StringOutputStream() { this(null); }
		public StringOutputStream(StringBuilder sb) {
			this.sb = sb;
			if (sb == null) { sb = new StringBuilder(); }
		}
		
		@Override
		public void write(int b) throws IOException {
			sb.append((char) b);
		}
		
		@Override
		public String toString() { return sb.toString(); }
	}
	
	/**
	 * Wraps {@link Thread#sleep(long)} and silently absorbs any
	 * {@link InterruptedException} thrown.
	 * @param duration the length of time to sleep
	 * @param unit the time unit of the duration
	 * @return the actual time (in milliseconds) the thread spent sleeping
	 */
	public static long sleep(long duration, TimeUnit unit) {
		if (duration <= 0L) { return 0L; }
		
		long start = System.nanoTime();
		try {
			Thread.sleep(TimeUnit.MILLISECONDS.convert(duration, unit));
		} catch (InterruptedException e) {
			// Silently ignore interrupted exception
		}
		return TimeUnit.MILLISECONDS.convert(System.nanoTime() - start, TimeUnit.NANOSECONDS);
	}
	
	/**
	 * Starts a thread marked as a daemon thread that executes the provided runnable.
	 * @param r the runnable to execute
	 * @param name the name of the thread
	 * @return the created thread
	 */
	public static Thread startDaemon(Runnable r, String name) {
		Thread t = new Thread(r, name);
		t.setDaemon(true);
		t.start();
		return t;
	}
	
	/**
	 * Invokes the object's {@link Object#wait()} method, handling the
	 * interrupted exception.
	 * @param obj the object on which to synchronize and wait
	 * @param timeout the amount of time to wait before returning, or <tt>0</tt>
	 * if the thread should wait indefinitely
	 * @param unit the unit of the timeout amount
	 */
	public static void wait(Object obj, long timeout, TimeUnit unit) {
		try {
			synchronized (obj) {
				obj.wait(TimeUnit.MILLISECONDS.convert(timeout, unit));
			}
		} catch (InterruptedException e) {
			LogContext.warning("Interrupted while waiting on object " + obj);
		}
	}
	
	/**
	 * Invokes the object's {@link Object#notifyAll()} method, properly
	 * wrapping the call in a synchronized block on the object.
	 * @param obj the object on which to synchronize and notify all
	 */
	public static void notifyAll(Object obj) {
		synchronized (obj) {
			obj.notifyAll();
		}
	}
	
	/**
	 * Joins the thread, handling the interrupted exception.
	 * @param t the thread to join
	 */
	public static void join(Thread t) {
		try {
			t.join();
		} catch (InterruptedException e) {
			LogContext.warning("Interrupted while joining thread " + t);
		}
	}
	
	/**
	 * Waits the specified time for the next available object on the queue, handling the
	 * interrupted exception.
	 * @param <T> the type of objects in the queue
	 * @param queue the queue
	 * @param time how long to wait for an object to become available
	 * @param unit the unit in which <tt>time</tt> is measured
	 * @return the next available object from the queue, or <tt>null</tt> if the specified time
	 * elapsed or an {@link InterruptedException} was thrown
	 * @see BlockingQueue#poll(long, TimeUnit)
	 */
	public static <T> T poll(BlockingQueue<T> queue, long time, TimeUnit unit) {
		T o = null;
        try {
            o = queue.poll(time, unit);
        } catch (InterruptedException ex) {
        	LogContext.warning("Interrupted while polling queue " + queue);
        }
        return o;
	}
	
	/**
	 * Adds the object to the queue, waiting for space to become available if necessary and handling
	 * the interrupted exception.
	 * @param <T> the type of objects in the queue
	 * @param queue the queue
	 * @param obj the object to add
	 * @param time how long to wait for space to become available
	 * @param unit the unit in which <tt>time</tt> is measured
	 * @return if the object was successfully added to the queue
	 * @see BlockingQueue#offer(Object, long, TimeUnit)
	 */
	public static <T> boolean offer(BlockingQueue<T> queue, T obj, long time, TimeUnit unit) {
		try {
			return queue.offer(obj, time, unit);
		} catch (InterruptedException e) {
			LogContext.warning("Interrupted while offering %s to %s", obj, queue);
			return false;
		}
	}
	
	/**
	 * Adds the object to the queue, waiting for space to become available if necessary
	 * and handling the interrupted exception. This method will continue to wait
	 * for space to become available every second as long as the status monitor is running.
	 * @param <T> the type of objects in the queue
	 * @param queue the queue
	 * @param obj the object to add
	 * @param rm the task's status monitor, which can be <tt>null</tt>. If so,
	 * this method has the same effect as {@link BlockingQueue#offer(Object)}
	 * @return if the object was successfully added to the queue
	 * @see BlockingQueue#offer(Object, long, TimeUnit)
	 * @see StatusMonitor#isRunning(StatusMonitor)
	 */
	public static <T> boolean offer(BlockingQueue<T> queue, T obj, StatusMonitor rm) {
		while (rm == null || rm.isRunning()) {
			if (offer(queue, obj, 50L, TimeUnit.MILLISECONDS)) { return true; }
		}
		return false;
	}
	
	/**
	 * Converts an unordered set into an ordered list using the natural ordering.
	 * @param set the set to convert
	 * @return the ordered list of values
	 */
	public static <T extends Comparable<T>> List<T> getOrderedList(Set<T> set) {
		List<T> list = new ArrayList<>(set);
		Collections.sort(list);
		return list;
	}

	/**
	 * Converts an unordered set into an ordered list using the specified comparator.
	 * @param set the set to convert
	 * @param comp the comparator to use to compare values in the set
	 * @return the ordered list of values
	 */
	public static <T> List<T> getOrderedList(Set<T> set, Comparator<T> comp) {
		List<T> list = new ArrayList<>(set);
		Collections.sort(list, comp);
		return list;
	}
	
	/**
	 * Tests if an option is turned on in a group of options/flags created with 
	 * the binary OR operator (<tt>|</tt>).  Each option must be a unique
	 * bit for this to work correctly.
	 * @param group a set of options OR'ed together
	 * @param option the option to test
	 * @return whether or not <tt>option</tt> is turned on
	 */
	public static boolean isOn(int group, int option) {
		return (group & option) > 0;
	}
	
	/**
	 * Tests if an option is turned on in a group of options/flags created with
	 * the binary OR operator (<tt>|</tt>). The enum's ordinal is the bit index which bit
	 * it corresponds to.  It must therefore be less than or equal to <tt>63</tt>.
	 * @param group a set of options OR'ed together
	 * @param e an enum value to test
	 * @return whether or not the enum is turned on
	 */
	public static boolean isOn(long group, Enum<?> e) {
		return (group & (1L << e.ordinal())) > 0L;
	}
	
	/**
	 * Linearly interpolate between two boundary values.
	 * @param amount the partial amount (between <tt>0.0</tt> and <tt>1.0</tt>) 
	 * @param min the minimum value
	 * @param max the maximum value
	 * @return the interpolated value
	 */
	public static double linterp(double amount, double min, double max) {
		return amount * (max - min) + min;
	}
	/**
	 * Linearly interpolate between two boundary values.
	 * @param amount the partial amount (between <tt>0.0</tt> and <tt>1.0</tt>) 
	 * @param min the minimum value
	 * @param max the maximum value
	 * @return the interpolated value
	 */
	public static float linterp(float amount, float min, float max) {
		return (float) linterp((double) amount, (double) min, (double) max);
	}
	
	/**
	 * Normalizes the amount between <tt>0.0</tt> and <tt>1.0</tt>.
	 * This method may return a value less than <tt>0.0</tt> or greater than <tt>1.0</tt>
	 * if <tt>amount</tt> falls outside the range of <tt>min</tt> and <tt>max</tt>.
	 * @param amount the original amount
	 * @param min the minimum amount
	 * @param max the maximum amount
	 * @return the normalized value
	 */
	public static double normalize(double amount, double min, double max) {
		return (amount - min) / (max - min);
	}
	
	/**
	 * Normalizes the amount between <tt>0.0</tt> and <tt>1.0</tt>.
	 * This method may return a value less than <tt>0.0</tt> or greater than <tt>1.0</tt>
	 * if <tt>amount</tt> falls outside the range of <tt>min</tt> and <tt>max</tt>.
	 * @param amount the original amount
	 * @param min the minimum amount
	 * @param max the maximum amount
	 * @return the normalized value
	 */
	public static float normalize(float amount, float min, float max) {
		return (float) normalize((double) amount, (double) min, (double) max);
	}
	
	/**
	 * For each property in <tt>target</tt>, check to see if there's a corresponding key in 
	 * <tt>overrides</tt>, and if so, overwrite the value in <tt>target</tt> with the
	 * one in <tt>overrides</tt>.
	 * 
	 * @param target Property set to update/overwrite.
	 * @param overrides Property set to source overrides.
	 * @return <tt>true</tt> if any properties were overridden, <tt>false</tt> otherwise.
	 */
	public static boolean applyPropertyOverrides(Properties target, Properties overrides) {
	    boolean retval = false;
	    for (Object key : target.keySet()) {
	        if (key instanceof String && overrides.containsKey(key)) {
	            String kStr = (String) key;
	            target.setProperty(kStr, overrides.getProperty(kStr));
	            retval = true;
	        }
	    }
	    return retval;
	}
	
	/**
	 * Loads a resource file relative to the current class loader's root directory.
	 * @param relativeFileName the file to load
	 * @return the resource as a file, or <tt>null</tt> if the resource couldn't be found
	 */
	public static File getResourceFile(String relativeFileName) {
		try {
			URL url = Utilities.class.getClassLoader().getResource(relativeFileName);
			if (url != null) { return new File(url.toURI()); }
		} catch (URISyntaxException ex) {
			LogContext.warning("Warning: resource URI malformed: %s", ex.getMessage());
		}
		return null;
	}
	
	/**
	 * Loads a resource relative to the specified class. If it is not found,
	 * and the resource has a relative path, it attempts to look in the
	 * <tt>resources</tt> folder. This is useful when using projects that conform
	 * to the Maven standard, yet aren't properly packaged by Maven but by
	 * Eclipse.
	 * @param c the class that specifies where to look for the resource
	 * @param name the path and name of the resource
	 * @return the resource, or <tt>null</tt> if it was not found
	 */
	@SuppressWarnings("resource")
	public static InputStream getResourceAsStream(Class<?> c, String name) {
	    InputStream is = c.getResourceAsStream(name);
	    if (is == null) {
	        if (!name.startsWith("/")) {
	            String pack = c.getPackage().getName();
	            name = String.format("/%s/%s", pack.replace('.', '/'), name);
	        }
	        is = c.getResourceAsStream("/resources" + name);
	    }
	    return is;
	}

	/**
	 * Attempts to parse the date, returning the default value in case of an 
	 * unparseable string or an error.
	 * @param fmt the format to use to parse
	 * @param s the string to parse
	 * @param defVal the default date value in the case of an error
	 * @return the parsed date, or <tt>defVal</tt>
	 */
	public static Date parseDate(DateFormat fmt, String s, Date defVal) {
		try {
			return fmt.parse(s);
		} catch (ParseException e) {
			return defVal;
		}
	}
	
	/**
	 * Finds the best message to use for the exception. This recurses nested 
	 * exceptions so long as the messsage is <tt>null</tt>. If the exception or
	 * none of its nested exceptions have a message, the simple name of the 
	 * exception's class is returned.
	 * @param t the thrown exception
	 * @return the exception's message
	 */
	public static String getMessage(Throwable t) {
		Throwable hasMsg = t;
		while (hasMsg != null && hasMsg.getMessage() == null) {
			hasMsg = hasMsg.getCause();
		}
		return hasMsg == null? t.getClass().getSimpleName() : hasMsg.getMessage();
	}
	
	/**
	 * Returns the first element of the collection.
	 * @param col the collection
	 * @return the first element, or <tt>null</tt> if <tt>col</tt> is <tt>null</tt>
	 * or empty
	 * @param <T> the type of objects in <tt>col</tt>
	 */
	public static <T> T first(Collection<T> col) {
		return col == null || col.isEmpty()? null : col.iterator().next();
	}
	
	/**
	 * Returns the first element of the array.
	 * @param arr the array
	 * @return the first element, or <tt>null</tt> if <tt>arr</tt> is <tt>null</tt>
	 * or has a length of <tt>0</tt>
	 * @param <T> the type of objects in <tt>arr</tt>
	 */
	@SafeVarargs
	public static <T> T first(T... arr) {
		return arr == null || arr.length == 0? null : arr[1];
	}
	
	/**
	 * Concatenates two or more collections together into a list.
	 * @param collections the collections to concatenate
	 * @return the collections concatenated together into a list in order that
	 * collections are specified and the order of their default iterator behavior
	 * @param <T> the type of objects in the collections
	 */
	@SafeVarargs
	public static <T> List<T> concat(Collection<T>... collections) {
		List<T> ret = new ArrayList<>();
		for (Collection<T> c : collections) { ret.addAll(c); }
		return ret;
	}
}
