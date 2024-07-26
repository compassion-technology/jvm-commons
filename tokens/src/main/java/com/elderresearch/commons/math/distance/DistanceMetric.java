/* ©2016-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.commons.math.distance;

import static java.lang.annotation.ElementType.FIELD;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.Arrays;

import org.eclipse.collections.api.block.procedure.primitive.LongFloatProcedure;
import org.eclipse.collections.api.block.procedure.primitive.LongProcedure;
import org.eclipse.collections.api.map.primitive.LongFloatMap;
import org.eclipse.collections.api.set.primitive.MutableLongSet;
import org.eclipse.collections.impl.factory.primitive.LongFloatMaps;
import org.eclipse.collections.impl.set.mutable.primitive.LongHashSet;

/**
 * A DistanceMetric encapsulates a norm computation method for vectors in a metric space.
 * @author Jordan Crittenden, Elder Research, Inc.
 * @author John Dimeo (extended to use high-performance Trove data structures)
 */
public abstract class DistanceMetric implements LongProcedure, LongFloatProcedure {
	/**
	 * Use this to annotate parameters required by {@link DistanceMetric} subclasses.
	 * This allows callers to use reflection to determine what parameters are
	 * required for a given distance implementation. 
	 */
	@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
	@Target(FIELD)
	public @interface DistanceParameter {
	  /**
	   * The name of the option.
	   * @return the name of the option
	   */
	  String name();

	  /**
	   * A description of this option.
	   * @return the description of the option
	   */
	  String description() default "";
	}
	
	public enum EuclideanFormat { SUM_OF_SQUARES, SQUARE_ROOT }
	
	// If the vectors have different key sets, we need to track which keys we didn't
	// iterate through on one vector when we iterate through the keys of the other
	private MutableLongSet keys;
	
	// Limits the computation to a set of keys
	private long[] mask;
	
	// Store one vector as a field so it is accessible by the execute() methods
	private LongFloatMap vec1;
	
	// The largest vector component and corresponding key that influences the total distance the most 
	private double maxVal;
	private long   maxKey;
	
	/**
	 * Sets the mask of keys, or filter, to use when computing the distance.
	 * @param mask the set of keys to only use when computing the distance
	 * @return this for method chaining
	 */
	public DistanceMetric setMask(long... mask) {
		// Sort so we can binary search later
		Arrays.sort(mask);
		this.mask = mask;
		return this;
	}
	
	@Override
	public void value(long key) {
		if (isNotInMask(key)) { return; }
		
		if (vec1 == null) {
			keys.add(key);
		} else {
			execute(key, vec1.get(key), 0.0f);	
		}
	}
	
	@Override
	public void value(long key, float b) {
		if (isNotInMask(key)) { return; }
		
		keys.remove(key);	
		execute(key, vec1.get(key), b);
	}
	
	private void execute(long key, float v1, float v2) {
		if (isNotInMask(key)) { return; }
		
		if (Float.isNaN(v1) || Float.isInfinite(v1)) { v1 = 0.0f; }
		if (Float.isNaN(v2) || Float.isInfinite(v2)) { v2 = 0.0f; }
		
		double d = component(key, v1, v2); 
		if (v1 > 0.0f || v2 > 0.0f) {
			if (d > maxVal) { maxVal = d; maxKey = key; }
		}
	}
	
	private boolean isNotInMask(long key) {
		if (mask == null || mask.length == 0) { return false; }
		return Arrays.binarySearch(mask, key) < 0;
	}
	
	/**
	 * Normalizes a vector using the distance metric.  This is equivalent to calling
	 * {@link #getDistance(LongFloatMap, LongFloatMap)} with an
	 * empty vector as one of the parameters.
	 * @param v the vector to normalize
	 * @return the magnitude of the vector according to this metric
	 */
	public double normalize(LongFloatMap v) {
		return getDistance(LongFloatMaps.immutable.empty(), v);
	}
	
	/**
	 * Computes the distance between two vectors. A value of <code>0.0f</code> is assumed
	 * in the case where a key is present in one vector but not the other.  The mask,
	 * if provided, is a list of <code>long</code> keys that will be the only keys considered
	 * when computing the distance.<br><b>Note:</b> Some metrics require parameters to
	 * be set before computing any distances.
	 * @param v1 the first vector
	 * @param v2 the second vector
	 * @return the distance between the two vectors according to this metric
	 */
	public double getDistance(LongFloatMap v1, LongFloatMap v2) {
		setup();
		maxVal = Double.MIN_VALUE;
		
		// Add all the first vector's keys to the key set
		keys = new LongHashSet(v1.size());
		v1.forEachKey(this);
		
		// Iterate through the second vector, removing v1's keys as we visit them
		this.vec1 = v1;
		v2.forEachKeyValue(this);
		
		// Iterate through any remaining v1 keys
		keys.forEach(this);
		this.vec1 = null;
		this.keys = null;
		
		return distance();
	}

	/**
	 * All distance metrics use internal state during computation,
	 * so you must use a separate instance to calculate distances in parallel.
	 * Use this method to instantiate subclasses of {@link DistanceMetric}.
	 * @return a new instance of this distance metric
	 */
	public abstract DistanceMetric copy();
	
	protected abstract void   setup();
	protected abstract double component(long key, float v1, float v2);
	protected abstract double distance();
	
	/** Returns the key that influenced the distance calculation the most. Usually, this
	 *  is the key that had the largest delta between the two vectors so long as one vector
	 *  is non-zero at that element.
	 *  @return the most influential key on determining the distance between these vectors */
	public long getMostInfluentialKey() { return maxKey; }
	
	@Override
	public String toString() { return getClass().getSimpleName(); }
}
