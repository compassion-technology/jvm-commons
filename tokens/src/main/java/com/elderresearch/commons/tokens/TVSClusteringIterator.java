/* ©2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.commons.tokens;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.function.LongFunction;

import org.eclipse.collections.impl.set.mutable.primitive.LongHashSet;
import org.jooq.lambda.tuple.Tuple;
import org.jooq.lambda.tuple.Tuple2;

import com.elderresearch.commons.hash.HashUtils;

import lombok.val;

/**
 * <p>This class attempts to skip pairwise computations that are likely to be high distance (so this optimization only
 * currently works for similarity). For each "generation", each outer key has a turn and the distance is computed with
 * every other key. All distances that are less than the max distances are then computed for every other key. The
 * generation is then a fully connected graph of keys with distance less than the max.</p>
 * <p>For the second "generation" the next outer key is selected <i>that was not visited</i> by the first generation,
 * and the process repeats. All connections between clusters are assumed to be greater than the maximum distance (TODO:
 * they might be <i>guaranteed</i> to be greater) and thus computation can be skipped.</p> 
 * 
 * @author jdimeo
 *
 * @param <TV>
 */
class TVSClusteringIterator<TV extends TokenVector> implements Iterator<Tuple2<TV, TV>> {
	private TokenRegistry tokens;
	private long[] outerKeys, innerKeys;
	private LongFunction<TV> outerGet, innerGet;
	
	private int outerFocus = 0;
	private int outerIndex = 0;
	private int innerIndex = 1;
	private LongHashSet visitedPairs;
	private CopyOnWriteArraySet<Long> qualifyingKeys;
	
	public TVSClusteringIterator(TokenRegistry tokens,
			long[] outerKeys, LongFunction<TV> outerGet,
			long[] innerKeys, LongFunction<TV> innerGet) {
		this.tokens         = tokens;
		this.outerKeys      = outerKeys;
		this.outerGet       = outerGet;
		this.innerKeys      = innerKeys;
		this.innerGet       = innerGet;
		this.visitedPairs   = new LongHashSet();
		this.qualifyingKeys = new CopyOnWriteArraySet<>();
		seek();
	}
	
	private void seek() {
		do {
			innerIndex++;
			if (innerIndex >= innerKeys.length) {
				innerIndex = 0;
				do {
					outerIndex++;
					if (outerIndex >= outerKeys.length) {
						do {
							outerIndex = ++outerFocus;
						} while (hasNext() && qualifyingKeys.contains(outerKeys[outerIndex]));
					}
				} while (hasNext() && !qualifyingKeys.contains(outerKeys[outerIndex]));
			}
		} while (hasNext() && isVisited());
	}
	
	@Override
	public boolean hasNext() {
		return outerIndex >= 0 && outerIndex < outerKeys.length
			&& innerIndex >= 0 && innerIndex < innerKeys.length;
	}
	
	private boolean isVisited() {
		return visitedPairs.contains(HashUtils.buildHash(innerIndex, outerIndex))
			|| visitedPairs.contains(HashUtils.buildHash(outerIndex, innerIndex));
	}
	
	@Override
	public Tuple2<TV, TV> next() {
		val outer = outerGet.apply(outerKeys[outerIndex]);
		outer.init(tokens);
		
		val inner = innerGet.apply(innerKeys[innerIndex]);
		inner.init(tokens);
		
		visitedPairs.add(HashUtils.buildHash(innerIndex, outerIndex));

		try {
			return Tuple.tuple(outer, inner);
		} finally {
			seek();
		}
	}
}
