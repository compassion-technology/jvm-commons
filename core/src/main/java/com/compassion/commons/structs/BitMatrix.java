package com.compassion.commons.structs;

import java.util.BitSet;

/**
 * Extends {@link BitSet} to a two-dimensional matrix.
 * 
 * @author <a href="mailto:dimeo@datamininglab.com">John Dimeo</a>
 * @since Jul 7, 2014
 */
public class BitMatrix {
	private BitSet[] rows;
	
	/**
	 * Initialize a newly created matrix of bit values.
	 * @param numRows number of rows in new matrix
	 * @param numColumns number of columns in new matrix
	 */
	public BitMatrix(int numRows, int numColumns) {
		rows = new BitSet[numRows];
		for (int i = 0; i < numRows; i++) {
			rows[i] = new BitSet(numColumns);
		}
	}

	/**
	 * Clear a value in the bit matrix.
	 * @param i row index
	 * @param j column index
	 * @see BitSet#clear(int)
	 */
	public void clear(int i, int j) { rows[i].clear(j); }

	/**
	 * Get a value from the bit matrix.
	 * @param i row index
	 * @param j column index
	 * @return true if the bit is set, false otherwise
	 * @see BitSet#get(int)
	 */
	public boolean get(int i, int j) { return rows[i].get(j); }

	/**
	 * Set a value in the bit matrix.
	 * @param i row index
	 * @param j column index
	 * @see BitSet#set(int)
	 */
	public void set(int i, int j) { rows[i].set(j); }
	
	/**
	 * Sets all the bits in the region.
	 * @param i1 the starting row index (inclusive)
	 * @param i2 the ending row index (exclusive)
	 * @param j1 the starting column index (inclusive)
	 * @param j2 the ending column index (exclusive)
	 * @see BitSet#set(int, int)
	 */
	public void set(int i1, int i2, int j1, int j2) {
		i1 = checkRow(i1); i2 = checkRow(i2);
		j1 = checkCol(j1); j2 = checkCol(j2);
		for (int i = i1; i < i2; i++) { rows[i].set(j1, j2); }
	}
	
	/**
	 * Clear all the bits in the region.
	 * @param i1 the starting row index (inclusive)
	 * @param i2 the ending row index (exclusive)
	 * @param j1 the starting column index (inclusive)
	 * @param j2 the ending column index (exclusive)
	 * @see BitSet#clear(int, int)
	 */
	public void clear(int i1, int i2, int j1, int j2) {
		i1 = checkRow(i1); i2 = checkRow(i2);
		j1 = checkCol(j1); j2 = checkCol(j2);
		for (int i = i1; i < i2; i++) { rows[i].clear(j1, j2); }
	}
	
	/**
	 * Gets the cardinality of the region.
	 * @param i1 the starting row index (inclusive)
	 * @param i2 the ending row index (exclusive)
	 * @param j1 the starting column index (inclusive)
	 * @param j2 the ending column index (exclusive)
	 * @return the summed cardinality of the bits in the region
	 * @see BitSet#cardinality()
	 */
	public int getCardinality(int i1, int i2, int j1, int j2) {
		i1 = checkRow(i1); i2 = checkRow(i2);
		j1 = checkCol(j1); j2 = checkCol(j2);
		
		int ret = 0;
		for (int i = i1; i < i2; i++) {
			ret += rows[i].get(j1, j2).cardinality();
		}
		return ret;
	}
	
	private int checkRow(int row) {
		return Math.min(rows.length, Math.max(0, row));
	}
	private static int checkCol(int col) {
		// Bit set handles out of bounds column
		return Math.max(0, col);
	}
}
