package com.compassion.commons.hash;

import java.nio.ByteBuffer;
import java.nio.LongBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * A collection of stateless hashing utilities. Most are <b>not</b> thread-safe.
 * 
 * @author <a href="dimeo@datamininglab.com">John Dimeo</a>
 * @since Dec 7, 2012
 */
public final class HashUtils {
	private static final int SHA_HASH_LEN = 40;
	private static final int HEX_LEN = 16;
	private static final long HASH_COEFF = 31L;

	private static final MessageDigest SHA1_DIGEST = getMessageDigest("SHA1");
	private static final MessageDigest MD5_DIGEST  = getMessageDigest("MD5");
	
	private HashUtils() {
		// Prevent initialization
	}
	
	/**
	 * Builds an aggregate hash code from the list of hash codes. This uses the
	 * common pattern of multiplying the current aggregate hash code by
	 * a prime number coefficient before adding the next hash code. 
	 * @param hashes the list of hash codes
	 * @return an aggregate hash code
	 */
	public static long buildHash(long... hashes) {
		long ret = 1L;
		for (long hash : hashes) {
			ret = (HASH_COEFF * ret) + hash;
		}
		return ret;
	}
	
	/**
	 * Hashes the parameter using the 64-bit CRC algorithm.
	 * @param string the string to hash
	 * @return the CRC64 hash of {@code string}
	 * @see #getCRC64String(String)
	 */
	public static long getCRC64(String string) {
		return CRC64.getCRC64(string);
	}
	
	/**
	 * Hashes the parameter using the 64-bit CRC algorithm, and returns the result
	 * as a hex string.
	 * @param string the string to hash
	 * @return the CRC64 hash of {@code string}
	 * @see #getCRC64(String)
	 */
	public static String getCRC64String(String string) {
		String hex = Long.toHexString(getCRC64(string)).toUpperCase();
		while (hex.length() < HEX_LEN) { hex = "0" + hex; }
		return hex;
	}
	
	/**
	 * Gets a message digest instance for the specified algorithm, returning
	 * {@code null} if no instance is found.
	 * @param algorithm the algorithm, like {@code "SHA1"} or {@code "MD5"}
	 * @return the message digest instance
	 */
	public static MessageDigest getMessageDigest(String algorithm) {
		try {
			return MessageDigest.getInstance(algorithm);
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}
	
	/**
	 * Hashes the parameter using the SHA1 algorithm, and returns
	 * the resulting bytes in {@code X2} format.
	 * @param string the string to hash (always {@code 40} characters in length)
	 * @return the SHA1 hash of {@code string}
	 */
	public static String getSHA1String(String string) {
		return getSHA1String(string, 1, "");
	}
	
	/**
	 * A more secure version of hashing, where the the random {@code salt}
	 * is appended to the input string and is hashed {@code iterations} times.
	 * The resulting bytes are returned in {@code X2} format.
	 * @param string the string to hash
	 * @param iterations the number of times to hash the input; i.e.
	 * {@code hash(hash(hash( ... hash(string))))}
	 * @param salt some random text to append to the input before hashing. Store
	 * this text in plain text with each hash for future hashing operations.
	 * @return the SHA1 hash of {@code string} (always {@code 40} characters in length)
	 */
	public static String getSHA1String(String string, int iterations, String salt) {
		if (iterations < 1) { throw new IllegalArgumentException("Iterations must be greater than 0"); }
		
		byte[] arr = (string + salt).getBytes();
		for (int i = 0; i < iterations; i++) {
			SHA1_DIGEST.reset();
			arr = SHA1_DIGEST.digest(arr);
		}
		SHA1_DIGEST.reset();
		
		StringBuffer buf = new StringBuffer(SHA_HASH_LEN);
		for (byte b : arr) { buf.append(String.format("%x", b)); }
		return buf.toString().toUpperCase();
	}
	
	private static byte[] getMD5Hash(byte[] data) {
		try {
			return MD5_DIGEST.digest(data);
		} finally {
			MD5_DIGEST.reset();
		}
	}
	
	/**
	 * Hashes the data and returns the resulting hash as a {@code long}.
	 * Since MD5 overflows one {@code long}, the {@code longs} are added
	 * together to form a single {@code long}.
	 * @param data the data to hash
	 * @return the hash as a {@code long}.
	 */
	public static long getMD5(byte[] data) {
		LongBuffer lb = ByteBuffer.wrap(getMD5Hash(data)).asLongBuffer();
		long ret = 0L;
		while (lb.hasRemaining()) {
			ret = (HASH_COEFF * ret) + lb.get();
		}
		return ret;
	}
	
	/**
	 * Hashes the data and returns the resulting hash as a {@code long}.
	 * Since MD5 overflows one {@code long}, the {@code longs} are added
	 * together to form a single {@code long}.
	 * @param string the string to hash
	 * @return the hash as a {@code long}.
	 */
	public static long getMD5(String string) {
		return getMD5(string.getBytes());
	}
}
