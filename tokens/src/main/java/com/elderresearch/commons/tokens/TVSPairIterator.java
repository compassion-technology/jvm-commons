/* ©2017-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.commons.tokens;

import java.util.Iterator;
import java.util.function.LongFunction;

import org.jooq.lambda.tuple.Tuple;
import org.jooq.lambda.tuple.Tuple2;

import lombok.val;

/**
 * Iterates through all pairwise combinations of token vectors in a {@link TokenVectorSet}.
 * 
 * @author <a href="dimeo@datamininglab.com">John Dimeo</a>
 * @since Jul 5, 2013
 */
class TVSPairIterator<TV extends TokenVector> implements Iterator<Tuple2<TV, TV>> {
	private TokenRegistry tokens;
	private boolean uniqueOnly;
	
	private long[] outerKeys, innerKeys;
	private LongFunction<TV> outerGet, innerGet;
	
	private int outerIndex, innerIndex;
	private int innerDir = +1;
	
	
	TVSPairIterator(TokenRegistry tokens, boolean uniqueOnly,
			long[] outerKeys, LongFunction<TV> outerGet,
			long[] innerKeys, LongFunction<TV> innerGet) {
		this.tokens     = tokens;
		this.uniqueOnly = uniqueOnly;
		this.outerKeys  = outerKeys;
		this.outerGet   = outerGet;
		this.innerKeys  = innerKeys;
		this.innerGet   = innerGet;
		this.innerIndex = uniqueOnly? 1 : 0;
		hasNext();
	}
	
	@Override
	public boolean hasNext() {
		if (outerIndex >= outerKeys.length) { return false; }
		
		int minInner = uniqueOnly? (outerIndex + 1) : 0;
		if (innerIndex >= minInner && innerIndex < innerKeys.length) { return true; }
		
		outerIndex++;
		innerDir *= -1;
		innerIndex += innerDir;
		if (uniqueOnly && outerIndex == innerIndex) { innerIndex++; }
		return hasNext();
	}
	
	@Override
	public Tuple2<TV, TV> next() {
		val outer = outerGet.apply(outerKeys[outerIndex]);
		outer.init(tokens);
		
		val inner = innerGet.apply(innerKeys[innerIndex]);
		inner.init(tokens);
		
		innerIndex += innerDir;
		return Tuple.tuple(outer, inner);
	}
	
	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
