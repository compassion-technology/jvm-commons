/* ©2016-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.commons.hash;

/**
 * Crc64 checksum computation.
 *
 * @author Uniparc
 * @version $Id: Crc64.java,v 1.1 2003/12/02 11:26:57 skerrien Exp $
 */
// CHECKSTYLE:OFF
abstract class CRC64 {
	private static long[] crc64Array = new long[256];

	/**
	 * Initialization of _crc64Array.
	 */
	static {

		for (int i = 0; i <= 255; ++i) {
			long k = i;

			for (int j = 0; j < 8; ++j) {
				if ((k & 1) != 0) {
					k = (k >>> 1) ^ 0xd800000000000000L;
				} else {
					k = k >>> 1;
				}
			}
			
			crc64Array[i] = k;
		}
	}

	/**
	 * Returns the crc64 checksum for the given sequence.
	 *
	 * @param sequence sequence of bytes
	 * @return the crc64 checksum for the sequence
	 */
	public static Long getCRC64(String sequence) {
		if (sequence == null) { return -1L; }		

		long crc64Number = 0;

		for (int i = 0; i < sequence.length(); ++i) {
			char symbol = sequence.charAt(i);
			long a = (crc64Number >>> 8);
			long b = (crc64Number ^ symbol) & 0xff;
			crc64Number = a ^ crc64Array[(int) b];
		}

		//        String crc64String = Long.toHexString( crc64Number ).toUpperCase();
		//        StringBuffer crc64 = new StringBuffer( "0000000000000000" );
		//        crc64.replace( crc64.length() - crc64String.length(),
		//                       crc64.length(),
		//                       crc64String );

		return crc64Number;
	}
	
	public static void main(String [] args) {
		if (args.length == 1) {
			long hash = CRC64.getCRC64(args[0]);
			System.out.println(hash);
		} else {
			System.out.println("You must specify a string to hash.");
		}
	}
}
// CHECKSTYLE:ON
