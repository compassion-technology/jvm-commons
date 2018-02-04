/*******************************************************************************
 * Copyright (c) 2016 Elder Research, Inc.
 * All rights reserved.
 *******************************************************************************/
package com.elderresearch.commons.lang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.Range;
import org.apache.commons.lang3.StringUtils;

import com.elderresearch.commons.lang.LambdaUtils.Interruptable;

import lombok.val;
import lombok.experimental.UtilityClass;
import lombok.extern.log4j.Log4j2;

/**
 * A collection of common stateless utilities.
 * 
 * @author <a href="dimeo@datamininglab.com">John Dimeo</a>
 * @since Sep 26, 2012
 */
@Log4j2
@UtilityClass
public final class Utilities {
	private static final DateFormat DF = new SimpleDateFormat("yyyy-MM-dd");
	// The following isn't 0 since it's the epoch in our time zone, not GMT
	public static final long DATE_1970_1_1 = Utilities.parseDate(DF, "1970-01-01", null).getTime();
	public static final long DATE_1900_1_1 = Utilities.parseDate(DF, "1900-01-01", null).getTime();
	public static final long DATE_2000_1_1 = Utilities.parseDate(DF, "2000-01-01", null).getTime();
	
	public static final String DEFAULT_CONTENT_TYPE = "text/plain; charset=us-ascii";
	
	private static final Pattern SSN = Pattern.compile(".*(\\d{3})-?(\\d{2})-?(\\d{4}).*");
	private static final Pattern PAIRED_QUOTES = Pattern.compile("^[\\s]*['\"](.*)['\"][\\s]*$");
	
	/**
	 * Removes leading and trailing whitespace and matching single and
	 * double quotes.  For example, <br>
	 * <tt>stripQuotes("  'hello world '") = "hello world"</tt>
	 * @param s the string to clean
	 * @return the cleaned string
	 */
	public String stripQuotes(String s) {
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
	public float getTokenLengthScore(String[] tokens) {
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
	public float getTokenLengthScore(long[] tokenLenDist, long tokens) {
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
	 * Applies the same format string to each element of an array,
	 * concatenating each formatted string together with a space.
	 * @param format the format to use for each element (e.g. <tt>"%5d"</tt>)
	 * @param delim the delimiter between each element (e.g. <tt>" "</tt>)
	 * @param array the array to format
	 * @return a formatted string
	 * @see String#format(String, Object...)
	 */
	public String deepFormat(String format, String delim, Object[] array) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			if (i > 0) { sb.append(delim); }
			sb.append(format);
		}
		return String.format(sb.toString(), array);
	}
	
	private static final char[] NUM_PREFIX_SYM = {
		'k', 'm', 'g', 't', 'p', 'e', 'z', 'y'
	};
	private static final int DIGITS_1K = 4;
	
	/**
	 * Converts a long into its string representation of no more than 4 significant digits,
	 * using SI prefixes like <tt>k</tt> for "kilo" (1,000) and <tt>m</tt> for "mega" (1,000,000).
	 * This method does not round mathematically- it only does string manipulation.
	 * For example: <code>compactLargetNumber(1234567L) = "1,234k"</code>
	 * @param l the number to format
	 * @return the compacted number
	 */
	public String compactLargeNumber(long l) {
		String s = String.valueOf(l);
		int i = -1;
		int n;
		while ((n = s.length()) > DIGITS_1K) {
			s = s.substring(0, n - DIGITS_1K + 1);
			i++;
		}
		
		if (n == DIGITS_1K) { s = s.charAt(0) + "," + s.substring(1); }
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
	public String getEncoding(String s) {
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
	public String getExtension(String filename) {
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
	
	private static char[] vowels = "aeiouAEIOU".toCharArray();
	/**
	 * Returns if the character is a vowel.
	 * @param c the character to test
	 * @return if <tt>c</tt> is an <tt>a</tt>, <tt>e</tt>, <tt>i</tt>, <tt>o</tt> or <tt>u</tt> (case-insensitive)  
	 */
	public boolean isVowel(char c) {
		return Arrays.binarySearch(vowels, c) >= 0;
	}
	
	/**
	 * Encloses the string in single quotes (<tt>'</tt>) if the string can
	 * <b>not</b> be parsed as a number and it is not already enclosed in single
	 * or double quotes.
	 * @param s the string
	 * @return the string enclosed with single quotes (if it is not a number)
	 */
	public String addQuotes(String s) {
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
	public String pluralize(String s) {
		if (s == null) { return null; }
		
		if (StringUtils.endsWith(s, "x")
		 || StringUtils.endsWith(s, "o")
		 || StringUtils.endsWith(s, "s")
		 || StringUtils.endsWith(s, "sh")
		 || StringUtils.endsWith(s, "ch")) {
			return s + "es";
		}
		
		if (StringUtils.endsWith(s, "y")) {
			return s.length() > 2 && isVowel(s.charAt(s.length() - 2))? s + "s" : StringUtils.chop(s) + "ies";
		}
			
		if (StringUtils.endsWith(s, "f")) {
			return StringUtils.chop(s) + "ves";
		}
		if (StringUtils.endsWith(s, "fe")) {
			return StringUtils.chop(StringUtils.chop(s)) + "ves";
		}
		
		return s + "s";
	}
	
	/**
	 * Return the pluralized form of the string if the number is not equal to
	 * <tt>1</tt>.
	 * @param s a singular string
	 * @param n the amount
	 * @return the pluralized form if applicable
	 * @see #pluralize(String)
	 */
	public String pluralizeIf(String s, Number n) {
		return (n != null && n.longValue() == 1L)? s : pluralize(s);
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
	public String stringValue(Object o, int precision) {
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
	public String stringValue(double d, int precision) {
		long l = Math.round(d);
		if (l == d) {  return String.valueOf(l); }
		
		if (precision < 0 || precision == Integer.MAX_VALUE) {
			return String.valueOf(d);
		}
		return String.format("%,." + precision + "f", d);
	}
	
	/**
	 * Tests if the provided string has one or more digit characters.
	 * @param s the string to test
	 * @return if one or more characters are digits or <tt>false</tt> if <tt>s</tt>
	 * is <tt>null</tt>
	 * @see Character#isDigit(char)
	 * @see #containsLetters(String)
	 */
	public boolean containsDigits(String s) {
		if (s == null) { return false; }
		
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) { return true; }
		}
		return false;
	}
	
	/**
	 * Tests if the provided string has one or more letter characters.
	 * @param s the string to test
	 * @return if one or more characters are letters or <tt>false</tt> if
	 * <tt>s</tt> is <tt>null</tt>
	 * @see Character#isLetter(char)
	 * @see #containsDigits(String)
	 */
	public boolean containsLetters(String s) {
		if (s == null) { return false; }
		
		for (int i = 0; i < s.length(); i++) {
			if (Character.isLetter(s.charAt(i))) { return true; }
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
	public String getFriendlyString(Enum<?> e) {
		return getFriendlyString(e.name());
	}
	
	/**
	 * Derives a more user-friendly name of a string following the constant naming convention.
	 * For example, the friendly version of <tt>"ENUM_NAME"</tt> is <tt>"Enum name"</tt>. 
	 * @param s a string following the constant naming convention
	 * @return a more user-friendly version of the string
	 */
	public String getFriendlyString(String s) {
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
	public <T extends Enum<T>> T valueOf(Class<T> c, String name, T defaultValue) {
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
	public String formatSSN(String s) {
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
	public String getSoundex(String s) {
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
	
	/**
	 * Gets the letter combination corresponding to the
	 * number:<br><code>
	 * 1 &nbsp;= A<br> 2 &nbsp;= B<br>...<br>
	 * 26 = Z<br> 27 = AA<br> 28 = AB<br> </code>etc...<br>
	 * (Microsoft Excel uses this lettering for column headers)
	 * @param i the number to convert
	 * @return a string corresponding to number <tt>i</tt>
	 */
	public String getLetters(int i) {
		//Taken from AbstractTableModel.getColumnName(int column)
		String result = "";
		for (i = i - 1; i >= 0; i = i / 26 - 1) {
		    result = (char) ((char) (i % 26) + 'A') + result;
		}
	    return result;
	}
	
	/**
	 * Generic cast method. Use with caution as it bypasses compiler checks.
	 * @param toCast the object to cast
	 * @param <S> the original type
	 * @param <T> the casted type
	 * @return the casted objectS
	 */
	@SuppressWarnings("unchecked")
	public <S, T> T cast(S toCast) {
	    return (T) toCast;
	}
	
	/**
	 * Wraps {@link Thread#sleep(long)} and silently absorbs any
	 * {@link InterruptedException} thrown.
	 * @param duration the length of time to sleep
	 * @param unit the time unit of the duration
	 * @return the actual time (in milliseconds) the thread spent sleeping
	 */
	public long sleep(long duration, TimeUnit unit) {
		if (duration <= 0L) { return 0L; }
		
		val start = System.nanoTime();
		Interruptable.accept(Thread::sleep, TimeUnit.MILLISECONDS.convert(duration, unit), "sleeping for (in ms)");
		return TimeUnit.MILLISECONDS.convert(System.nanoTime() - start, TimeUnit.NANOSECONDS);
	}
	
	/**
	 * Starts a thread marked as a daemon thread that executes the provided runnable.
	 * @param g the thread group (can be <tt>null</tt>)
	 * @param r the runnable to execute
	 * @param name the name of the thread
	 * @return the created thread
	 */
	public Thread startDaemon(ThreadGroup g, Runnable r, String name) {
		Thread t = new Thread(g, r, name);
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
	public void wait(Object obj, long timeout, TimeUnit unit) {
		synchronized (obj) {
			Interruptable.accept($ -> $.wait(TimeUnit.MILLISECONDS.convert(timeout, unit)), obj, "waiting on");
		}
	}
	
	/**
	 * Invokes the object's {@link Object#notifyAll()} method, properly
	 * wrapping the call in a synchronized block on the object.
	 * @param obj the object on which to synchronize and notify all
	 */
	public void notifyAll(Object obj) {
		synchronized (obj) {
			obj.notifyAll();
		}
	}
	
	/**
	 * Joins the thread, handling the interrupted exception.
	 * @param t the thread to join
	 */
	public void join(Thread t) {
		Interruptable.accept(Thread::join, t, "joining");
	}
	
	/**
	 * Waits up to the specified time for the next available object in the queue, handling the
	 * interrupted exception.
	 * @param <T> the type of objects in the queue
	 * @param queue the queue
	 * @param time how long to wait for an object to become available
	 * @param unit the unit in which <tt>time</tt> is measured
	 * @return the next available object from the queue, or <tt>null</tt> if the specified time
	 * elapsed or an {@link InterruptedException} was thrown
	 * @see BlockingQueue#poll(long, TimeUnit)
	 */
	public <T> T poll(BlockingQueue<T> queue, long time, TimeUnit unit) {
		return Interruptable.apply($ -> $.poll(time, unit), queue, "polling", null); 
	}
	
	/**
	 * Waits up to the specified time for the next available object in the queue, handling the
	 * interrupted exception. This method will continue to wait
	 * for the next available object to become available as long as the status monitor is running.
	 * @param <T> the type of objects in the queue
	 * @param queue the queue
	 * @param sm the task's status monitor, which can be <tt>null</tt>. If so,
	 * this method has the same effect as {@link BlockingQueue#poll()}
	 * @return the next available object from the queue, or <tt>null</tt> if the specified time
	 * elapsed or an {@link InterruptedException} was thrown
	 * @see BlockingQueue#poll(long, TimeUnit)
	 * @see StatusMonitor#isRunning()
	 */
	public <T> T poll(BlockingQueue<T> queue, StatusMonitor sm) {
		while (sm == null || sm.isRunning()) {
			val next = poll(queue, 1L, TimeUnit.SECONDS);
			if (next != null) { return next; }
		}
		return null;
	}
	
	/**
	 * Waits the up to specified time for the next available objects in the queue. The batch may only have one item,
	 * but if there are more available in the queue they will also be added (up until the max batch size). An empty
	 * list will only be returned if there are no available objects and the specified time has elapsed.
	 * @param <T> the type of objects in the queue
	 * @param queue the queue
	 * @param time how long to wait for objects to become available
	 * @param unit the unit in which <tt>time</tt> is measured
	 * @param batch the output batch list. This is a parameter so the same list instance can be reused, and is not
	 * required to be empty when passed in
	 * @param maxBatchSize the maximum number of objects to include
	 * @return if any objects were retrieved from the queue
	 * @see BlockingQueue#poll(long, TimeUnit)
	 * @see BlockingQueue#drainTo(Collection, int)
	 */
	public <T> boolean pollBatch(BlockingQueue<T> queue, long time, TimeUnit unit, Collection<T> batch, int maxBatchSize) {
		// If there are any rows in the queue, drain them to the batch
		if (queue.drainTo(batch, maxBatchSize) < 1) {
			// If empty, wait up to a the specified time for an entry to appear
			T first = poll(queue, time, unit);
			// If one is added, add it to the list, and drain any others into the batch that have since been added
			if (first != null) {
				batch.add(first);
				queue.drainTo(batch, maxBatchSize - 1);
				return true;
			}
			return false;
		}
		return true;
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
	public <T> boolean offer(BlockingQueue<T> queue, T obj, long time, TimeUnit unit) {
		return Interruptable.apply($ -> queue.offer($, time, unit), obj, "offering", false);
	}
	
	/**
	 * Adds the object to the queue, waiting for space to become available if necessary
	 * and handling the interrupted exception. This method will continue to wait
	 * for space to become available as long as the status monitor is running.
	 * @param <T> the type of objects in the queue
	 * @param queue the queue
	 * @param obj the object to add
	 * @param sm the task's status monitor, which can be <tt>null</tt>. If so,
	 * this method has the same effect as {@link BlockingQueue#offer(Object)}
	 * @return if the object was successfully added to the queue
	 * @see BlockingQueue#offer(Object, long, TimeUnit)
	 * @see StatusMonitor#isRunning()
	 */
	public <T> boolean offer(BlockingQueue<T> queue, T obj, StatusMonitor sm) {
		while (sm == null || sm.isRunning()) {
			if (offer(queue, obj, 1L, TimeUnit.SECONDS)) { return true; }
		}
		return false;
	}
	
	/**
	 * Tests if an option is turned on in a group of options/flags created with 
	 * the binary OR operator (<tt>|</tt>).  Each option must be a unique
	 * bit for this to work correctly.
	 * @param group a set of options OR'ed together
	 * @param option the option to test
	 * @return whether or not <tt>option</tt> is turned on
	 */
	public boolean isOn(int group, int option) {
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
	public boolean isOn(long group, Enum<?> e) {
		return (group & (1L << e.ordinal())) > 0L;
	}
	
	/**
	 * Linearly interpolate between two boundary values.
	 * @param amount the partial amount (between <tt>0.0</tt> and <tt>1.0</tt>) 
	 * @param min the minimum value
	 * @param max the maximum value
	 * @return the interpolated value
	 */
	public double linterp(double amount, double min, double max) {
		return amount * (max - min) + min;
	}
	/**
	 * Linearly interpolate between two boundary values.
	 * @param amount the partial amount (between <tt>0.0</tt> and <tt>1.0</tt>) 
	 * @param min the minimum value
	 * @param max the maximum value
	 * @return the interpolated value
	 */
	public float linterp(float amount, float min, float max) {
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
	public double normalize(double amount, double min, double max) {
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
	public float normalize(float amount, float min, float max) {
		return (float) normalize((double) amount, (double) min, (double) max);
	}
	
	/**
	 * Clamps the integer value to the specified range.
	 * @param value the value to clamp
	 * @param min the minimum value
	 * @param max the maximum value
	 * @return the clamped value (the min if the value was less than the min,
	 * the max if the value was greater than the max, or the original value)
	 */
	public int clamp(int value, int min, int max) {
		return value > max? max : (value < min? min : value);
	}
	
	/**
	 * Clamps the value to the specified range.
	 * @param value the value
	 * @param range the valid range of values
	 * @param <T> the value type
	 * @return the clamped value (the min if the value was less than the min,
	 * the max if the value was greater than the max, or the original value)
	 */
	public <T> T clamp(T value, Range<T> range) {
		return range.isBefore(value)? range.getMaximum() : (range.isAfter(value)? range.getMinimum() : value);
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
	public boolean applyPropertyOverrides(Properties target, Properties overrides) {
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
	 * Converts a URL to a URI, swallowing and logging any exceptions and returning <tt>null</tt> if it is not valid.
	 * @param u the URL to convert
	 * @return the corresponding URI, or <tt>null</tT> if there was a problem converting it
	 */
	public URI toURI(URL u) {
		try {
			return u.toURI();
		} catch (URISyntaxException | IllegalArgumentException e) {
			log.warn("Invalid URI: {}", u, e);
			return null;
		}
	}
	
	/**
	 * Loads a resource file relative to the current class loader's root directory.
	 * @param relativeFileName the file to load
	 * @return the resource as a file, or <tt>null</tt> if the resource couldn't be found
	 */
	public Path getResourceFile(String relativeFileName) {
		return Optional.ofNullable(Utilities.class.getClassLoader().getResource(relativeFileName))
				.map(Utilities::toURI)
				.map(Paths::get)
				.orElse(null);
	}
	
	/**
	 * Attempts to load the resource relative to the specified class. If it is not found, the path is treated as a file
	 * path instead (relative or absolute).
	 * @param c the class that specifies where to look
	 * @param name the path of the resource or file
	 * @return a stream to the resource, or <tt>null</tt> if it was not found as either a resource or a file
	 */
	public InputStream getResourceOrFile(Class<?> c, String name) {
		return Optional.ofNullable(c.getResourceAsStream(name)).orElseGet(() -> {
			try {
				return Files.newInputStream(Paths.get(name));
			} catch (IOException e) {
				return null;
			}
		});
	}
	
	/**
	 * Reads each line of the resource stream or file and invokes a callback for each non-blank line.
	 * @param c the class for resource loading
	 * @param resourceOrFile the reasource path or file path
	 * @param callback the callback to invoke for each line
	 */
	public void forEachLine(Class<?> c, String resourceOrFile, Consumer<String> callback) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(getResourceOrFile(c, resourceOrFile)))) {
			for (String line = br.readLine(); line != null; line = br.readLine()) {
				LambdaUtils.accept(StringUtils.stripToNull(line), callback::accept);
			}
		} catch (IOException e) {
			log.warn("Error reading lines of {}", resourceOrFile, e);
		}
	}
	
	/**
	 * Attempts to parse the date, returning the default value in case of an 
	 * unparseable string or an error.
	 * @param fmt the format to use to parse
	 * @param s the string to parse
	 * @param defVal the default date value in the case of an error
	 * @return the parsed date, or <tt>defVal</tt>
	 */
	public Date parseDate(DateFormat fmt, String s, Date defVal) {
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
	public String getMessage(Throwable t) {
		Throwable hasMsg = t;
		while (hasMsg != null && hasMsg.getMessage() == null) {
			hasMsg = hasMsg.getCause();
		}
		return hasMsg == null? t.getClass().getSimpleName() : hasMsg.getMessage();
	}
	
	/**
	 * Returns the first element of the collection.
	 * @param col the collection
	 * @param <T> the type of objects in <tt>col</tt>
	 * @return the first element, or <tt>null</tt> if <tt>col</tt> is <tt>null</tt>
	 * or empty
	 */
	public <T> T first(Collection<T> col) {
		return col == null || col.isEmpty()? null : col.iterator().next();
	}
	
	/**
	 * Returns the first element of the array.
	 * @param arr the array
	 * @param <T> the type of objects in <tt>arr</tt>
	 * @return the first element, or <tt>null</tt> if <tt>arr</tt> is <tt>null</tt>
	 * or has a length of <tt>0</tt>
	 */
	@SafeVarargs
	public <T> T first(T... arr) {
		return get(arr, 0);
	}
	
	/**
	 * Returns the <tt>i</tt><sup>th</sup> element of the array, if it is not <tt>null</tt> and has at least
	 * <tt>i + 1</tt> elements.
	 * @param arr the array
	 * @param i the index
	 * @param <T> the type of objects in the array
	 * @return the element at the index, or <tt>null</tt> if the array is null or the index is out of bounds
	 */
	public <T> T get(T[] arr, int i) {
		if (arr == null || i < 0 || i >= arr.length) { return null; }
		return arr[i];
	}
	
	/**
	 * Returns the <tt>i</tt><sup>th</sup> element of the list, if it is not <tt>null</tt> and has at least
	 * <tt>i + 1</tt> elements.
	 * @param list the list
	 * @param i the index
	 * @param <T> the type of objects in the array
	 * @return the element at the index, or <tt>null</tt> if the list is null or the index is out of bounds
	 */
	public <T> T get(List<T> list, int i) {
		if (list == null || i < 0 || i >= list.size()) { return null; }
		return list.get(i);
	}
	
	/**
	 * Concatenates two or more collections together into a list.
	 * @param collections the collections to concatenate
	 * @return the collections concatenated together into a list in order that
	 * collections are specified and the order of their default iterator behavior
	 * @param <T> the type of objects in the collections
	 */
	@SafeVarargs
	public <T> List<T> concat(Collection<T>... collections) {
		List<T> ret = new ArrayList<>();
		for (Collection<T> c : collections) { ret.addAll(c); }
		return ret;
	}
}
