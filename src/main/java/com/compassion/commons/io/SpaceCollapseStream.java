/* ©2017-2020 Elder Research, Inc. All rights reserved. */
package com.compassion.commons.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * Collapses multiple adjacent spaces into a single space, as well as trimming spaces at the 
 * beginning and end of a line. This is different from the ignore space API offered by Commons
 * CSV since that is trimming space inside a delimited field, and doesn't have any effect if
 * space itself is the delimiter. This is useful for space-/column-aligned files.
 * 
 * @author <a href="mailto:dimeo@datamininglab.com">John Dimeo</a>
 * @since Feb 10, 2017
 */
public class SpaceCollapseStream extends InputStream {
	private static final int NONE = -10;
	private static final int SPACE = ' ';
	
	private InputStream wrapped;
	// Since this also trims lines, initialize prev to space so that leading spaces on the first line are skipped
	private int prev = SPACE, next = NONE;

	public SpaceCollapseStream(InputStream wrapped) { this.wrapped = wrapped; }
	
	@Override
	public int read() throws IOException {
		int ret;
		// If a previously read character was queued up, return that
		if (next > NONE) {
			ret = next;
			next = NONE;
		} else {
			// Otherwise, skip any spaces that occur in the stream
			int skipped = 0;
			while ((ret = wrapped.read()) == SPACE) { skipped++; }
			
			// If we skipped at least one space, test to see if it was preceded or succeeded
			// by whitespace and should still be ignored; otherwise return a single space and
			// "queue up" the character we read ahead
			if (skipped > 0 && !Character.isWhitespace(prev) && !Character.isWhitespace(ret)) {
				next = ret;
				ret = SPACE;
			}
		}
		prev = ret;
		return ret;
	}
}
