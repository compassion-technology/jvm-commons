package com.compassion.commons.tokens;

import java.io.Serializable;
import java.util.Objects;

import org.apache.commons.lang3.Range;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.set.primitive.LongSet;
import org.eclipse.collections.api.set.primitive.MutableLongSet;
import org.eclipse.collections.api.tuple.primitive.LongFloatPair;
import org.eclipse.collections.api.tuple.primitive.LongIntPair;
import org.eclipse.collections.impl.map.mutable.primitive.LongFloatHashMap;
import org.eclipse.collections.impl.map.mutable.primitive.LongIntHashMap;
import org.ehcache.sizeof.annotations.IgnoreSizeOf;

import lombok.Setter;
import lombok.val;

/**
 * This class maintains a "bag of words" for a document (or any text). It maps
 * unique token hashes to counts, and should be used in conjunction with 
 * {@link TokenVectorSet}. 
 * 
 * @author <a href="dimeo@datamininglab.com">John Dimeo</a>
 * @since Jul 2, 2013
 */
public class TokenVector implements Serializable {
	// Key to uniquely identify this token vector in a set of token vectors
	@Setter
	private long key;
	// Total number of tokens in this token vector
	int total;
	
	// Maps hashes back to the original tokens
	@IgnoreSizeOf
	private transient TokenRegistry tokenRegistry;
	
	LongIntHashMap countsRaw;
	LongFloatHashMap countsWeighted;
	
	public TokenVector() {
		init(new TokenRegistry.TokenRegistrySmall());
		
		countsRaw = new LongIntHashMap();
		countsWeighted = new LongFloatHashMap();
	}
	
	protected void init(TokenVector other) {
		init(other.tokenRegistry);
	}
	protected void init(TokenRegistry masterRegistry) {
		tokenRegistry = masterRegistry;
	}
	
	/**
	 * Gets the token vector set or corpus to which this vector has been added, or {@code null} if this vector
	 * has not yet been added to any corpora.
	 * @return the vector's container corpus
	 */
	public TokenVectorSet<?> getCorpus() {
		return tokenRegistry.getCorpus();
	}
	
	/**
	 * Hash the token and register it with token vector.
	 * @param string the token
	 * @return the token's uniquely identifying hash
	 */
	public long hash(String string) {
		return tokenRegistry.hash(string);
	}
	
	/**
	 * Finds the original string token corresponding to the provided hash.
	 * @param tokenHash the token hash
	 * @return the string token, or {@code null} if the hash has not been
	 * associated with a token in this vector
	 * @see #hash(String)
	 */
	public String getToken(long tokenHash) {
		return tokenRegistry.get(tokenHash);
	}
	
	/**
	 * Increases the count of the token for this document.
     * @param token the unique token
	 */
	public void increment(String token) {
		increment(hash(token));
	}
	
	public void increment(long tokenHash) {
		total++;
		countsRaw.addToValue(tokenHash, 1);
		countsWeighted.remove(tokenHash);
	}
	
	public void putCount(long tokenHash, int count) {
		val prev = countsRaw.get(tokenHash);
		total = total - prev + count;
		countsRaw.put(tokenHash, count);
		countsWeighted.remove(tokenHash);
	}
	
    /**
     * Gets the count of the token in this document.
     * @param token the unique token
     * @return the count of the token in the document, or {@code 0}
     * if the token was not encountered in the document
     */
    public int getCount(String token) {
    	return getCount(hash(token));
    }
    
    public int getCount(long tokenHash) {
    	return countsRaw.getIfAbsent(tokenHash, 0);
    }
    
    /**
     * Remove the token from this token vector. This removes both the count and
     * the weighted counts from the vector, and also removes the mapping of the
     * token hash to the token in the token registry (if this token vector's
     * registry has not been replaced with a global registry).
     * @param token the token to remove
     */
    public void remove(String token) {
    	remove(hash(token));
    }
    
    public void remove(long tokenHash) {
    	total -= countsRaw.get(tokenHash);
    	countsRaw.remove(tokenHash);
    	countsWeighted.remove(tokenHash);
    	tokenRegistry.remove(tokenHash);
    }
    
    public LongSet getTokensWithCountIn(Range<Integer> range) {
    	return countsRaw.select((t, c) -> range.contains(c)).keySet();
    }
    public LongSet getTokensWithWeightIn(Range<Float> range) {
    	return countsWeighted.select((t, w) -> range.contains(w)).keySet();
    }
    
    /**
     * Gets the weighted/normalized count of the token in this document.
     * @param token the unique token
     * @return the weighted count of the token, or {@code Float.NaN} if weighted
     * counts have not yet been computed or the token was not encountered in
     * the document
     */
    public float getWeightedCount(String token) {
    	return getWeightedCount(hash(token));
    }
    
    public float getWeightedCount(long tokenHash) {
    	return countsWeighted.getIfAbsent(tokenHash, Float.NaN);
    }
    
    public RichIterable<LongIntPair> tokenCountView() {
    	return countsRaw.keyValuesView();
    }
    
    public RichIterable<LongFloatPair> tokenWeightedCountView() {
    	return countsWeighted.keyValuesView();
    }
	
	/**
	 * Gets the key that uniquely identifies this token vector.
	 * @return the key
	 */
	public long getKey() { return key; }
	
	/**
	 * Gets the total number of <b>unique</b> tokens in this token vector.
	 * @return the size of the token vector
	 */
	public int size() { return countsRaw.size(); }
	
	/**
	 * Gets the total number of tokens in this token vector.
	 * @return the total number of tokens
	 */
	public int getTotal() { return total; }
	
	/**
	 * Gets the set of unique token hashes that have been added to this token
	 * vector. Note that retain/remove operations performed on the return set
	 * will affect this token vector.
	 * @return the unique tokens in this token vector
	 * @see #hash(String)
	 */
	public MutableLongSet getTokenHashes() { return countsRaw.keySet(); }
	
	/**
	 * This method takes a mapping of token hashes to their original token
	 * strings and adds this token vector's mappings to the mapping, and then
	 * sets the internal pointer to the {@code master} parameter.  This saves
	 * memory by only having one data structure for all token vectors in a set.
	 * @param masterRegistry the single hash to string mapping that should be used for
	 * all the token vectors in a set
	 */
	void mergeTokens(TokenRegistry masterRegistry) {
		TokenRegistry temp = tokenRegistry;
		tokenRegistry = masterRegistry;
		masterRegistry.merge(temp);
	}
	
	void compact() {
		countsRaw.compact();
		countsWeighted.compact();
	}
	
	// OPTIMIZED implementations of equality assuming counts are only being added/collected. These are used by 
	// TokenVectorSet.merge() and are not intended to be used for "true"/deep equality.
	@Override
	public int hashCode() {
		return Objects.hash(key, total);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof TokenVector) {
			TokenVector tv = (TokenVector) obj;
			return tv.key == key && tv.total == total;
		}
		return false;
	}
}
