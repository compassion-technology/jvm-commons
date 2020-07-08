/* ©2016-2020 Elder Research, Inc. All rights reserved. */
package com.elderresearch.commons.lang.extract;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.Range;

/**
 * Represents a match from an {@link Extractor}.
 * 
 * @author <a href="dimeo@elderresearch.com">John Dimeo</a>
 * @since Jul 1, 2020
 * @param <T> the type of value returned by the extractor
 */
public final class Match<T> {
	private static final int  CONTEXT_CHARS = 32;
	
	private T match;
	private int start, end;
	private String before, matchStr, after;
	
	Match(String text, T match, int start, int end) {
		this.match = match;
		this.start = start;
		this.end    = end;
		
		before   = text.substring(Math.max(start - CONTEXT_CHARS, 0), start);
		matchStr = text.substring(start, end);
		after    = text.substring(end, Math.min(end + CONTEXT_CHARS, text.length()));
	}
	
	public T      getMatch()         { return match;       }
	public int    getStart()         { return start;       }
	public int    getEnd()           { return end;         }
	public int    getLength()        { return end - start; }
	public String getContextAfter()  { return after;       }
	public String getContextBefore() { return before;      }
	public String getMatchText()     { return matchStr;    }
	
	public Range<Integer> getRange() { return Range.between(start, end); }
	
    @Override
    public boolean equals(Object obj) {
        // Two matches are equal if they overlap at all and refer to the same date
        Match<?> m = (Match<?>) obj;
        return match.equals(m.match) && getRange().isOverlappedBy(m.getRange());
    }
    
    @Override
    public int hashCode() {
    	return start + 31 * match.hashCode();
    }
	
	@Override
	public String toString() { return match + "[" + start + ", " + end + "]"; }
	
	public static <T> Comparator<Match<T>> orderByPositionThenShortest() {
		return Comparator.comparing(Match<T>::getStart).thenComparing(Match::getEnd);
	}
	public static <T> Comparator<Match<T>> orderByPositionThenLongest() {
		return Comparator.comparing(Match<T>::getStart).thenComparing(Comparator.comparing(Match<T>::getEnd).reversed());
	}
	public static <T> Comparator<Match<T>> orderByMatchThenShortest(Comparator<T> comp) {
		return Comparator.comparing(Match<T>::getMatch, comp).thenComparing(Match::getLength);
	}
	public static <T> Comparator<Match<T>> orderByMatchThenLongest(Comparator<T> comp) {
		return Comparator.comparing(Match<T>::getMatch, comp).thenComparing(Comparator.comparing(Match<T>::getLength).reversed());
	}
	
	/**
	 * Takes a set of extraction results and removes any overlapping
	 * results, keeping the longest matches. For example, if the text is
	 * (with 4 extracted matches indicated with brackets):<br/>
	 * {@code "Example text from [2000] to [1 [March, [2001]]]"}<br/>
	 * only matches {@code "2000"} and {@code "1 March 2001"} will be preserved
	 * in the returned list.
	 * @param matches the set of matches
	 * @return the matches, but with overlapping matches removed
	 */
	public static <T> List<Match<T>> removeOverlaps(Collection<Match<T>> matches) {
		List<Match<T>> ret = new ArrayList<>(matches);
		Collections.sort(ret, orderByPositionThenLongest());
		
		Match<T> prev = null;
		Iterator<Match<T>> iter = ret.iterator();
		while (iter.hasNext()) {
			Match<T> curr = iter.next();
			if (prev != null && curr.getStart() < prev.getEnd()) {
				iter.remove();
			} else {
				prev = curr;
			}
		}
		return ret;
	}
}
