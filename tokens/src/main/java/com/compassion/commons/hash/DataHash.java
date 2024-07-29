package com.compassion.commons.hash;

import java.util.function.Function;

/**
 * Interface for producing {@code long} hash values for any other object type.
 * See {@link HashUtils} for {@code String} and {@code byte} hash implementations.
 * 
 * @author <a href="mailto:dimeo@datamininglab.com">John Dimeo</a>
 * @param <T> the type of object to hash
 * @since Jan 25, 2016
 */
@FunctionalInterface
public interface DataHash<T> extends Function<T, Long> {
	/**
	 * A hash value to be used as a placeholder for {@code null}. This is 
	 * defined as {@link Long#MIN_VALUE} so as to be unlikely to be a legitimate
	 * value or hash. 
	 */
	long NULL = Long.MIN_VALUE;
	
	/**
	 * Return the hash code for the value.
	 * @param obj the object to hash
	 * @return the object's hash code
	 */
	long hash(T obj);
	
	/**
	 * "Reverse" the hash code to get the original object.
	 * @param hash the hash
	 * @return the original object
	 * @throws UnsupportedOperationException if this hash is not reversible
	 */
	default T unhash(long hash) {
		throw new UnsupportedOperationException("This hash is not reversible");
	}
	
	/**
	 * Whether or not this hash is reversible; namely, if {@link #unhash(long)}
	 * is implemented/supported.
	 * @return if this hash is reversible
	 */
	default boolean isReversible() {
		return false;
	}

	/**
	 * Gets the minimum possible hash value returned by this hasher. By default this is {@link Long#MIN_VALUE}. This is
	 * useful for callers to know if they can allocate less space than a {@code long} for storage of a hash. The most
	 * common situation for implementing this method is if your hash function generates {@code ints} (in which case
	 * this would return {@link Integer#MIN_VALUE}).
	 * @return the minimum hash value
	 * @see #getMaxHash()
	 */
	default long getMinHash() { return Long.MIN_VALUE; }
	
	/**
	 * Gets the maximum possible hash value returned by this hasher. By default this is {@link Long#MAX_VALUE}. This is
	 * useful for callers to know if they can allocate less space than a {@code long} for storage of a hash. The most
	 * common situation for implementing this method is if your hash function generates {@code ints} (in which case
	 * this would return {@link Integer#MAX_VALUE}).
	 * @return the maximum hash value
	 * @see #getMinHash()
	 */
	default long getMaxHash() { return Long.MAX_VALUE; }
	
	@Override
	default Long apply(T obj) { return hash(obj); }
}
