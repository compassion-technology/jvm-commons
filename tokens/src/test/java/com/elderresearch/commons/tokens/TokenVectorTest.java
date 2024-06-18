/* ©2017-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.commons.tokens;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.eclipse.collections.impl.map.mutable.primitive.LongShortHashMap;
import org.junit.jupiter.api.BeforeEach;

public class TokenVectorTest {
	private static final String TOKEN = "junit";
	
	private TokenVector tv;
	
	@BeforeEach
	protected void setUp() throws Exception {
		tv = new TokenVector();
	}
	
	public void testSetGetOriginal() {
		assertEquals(0, tv.countsRaw.get(1L));

		tv.putCount(1L, 2);
		assertEquals(2, tv.countsRaw.get(1L));
		
		tv.putCount(1L, 1);
		assertEquals(1, tv.countsRaw.get(1L));

		tv.putCount(1L, Short.MAX_VALUE);
		assertEquals(Short.MAX_VALUE, tv.countsRaw.get(1L));
		
		tv.putCount(1L, -1);
		assertEquals(-1, tv.countsRaw.get(1L));
		
		tv.putCount(1L, Short.MIN_VALUE);
		assertEquals(Short.MIN_VALUE, tv.countsRaw.get(1L));
	}
	
	public void testIncremet() {
		assertEquals(0, tv.getCount(TOKEN));
		tv.increment(TOKEN);
		assertEquals(1, tv.getCount(TOKEN));
		tv.increment(TOKEN);
		assertEquals(2, tv.getCount(TOKEN));
		
		LongShortHashMap counts = tv.countsRaw;
		assertEquals(0, counts.get(1L));
		counts.addToValue(1L, (short) 1);
		assertEquals(1, counts.get(1L));
		counts.addToValue(1L, (short) 1);
		assertEquals(2, counts.get(1L));
	}
	
	public void testIncrementMingled() {
		assertEquals(0, tv.getCount(TOKEN));
		tv.increment(TOKEN);
		tv.countsWeighted.put(tv.hash(TOKEN), 2.0f);
		tv.increment(TOKEN);
		assertEquals(2, tv.getCount(TOKEN));
		assertTrue(Float.isNaN(tv.getWeightedCount(TOKEN)));
	}
	
	public void testHash() {
		assertEquals(TOKEN, tv.getToken(tv.hash(TOKEN)));
	}
	
	public void testRemove() {
		tv.increment(TOKEN);
		assertEquals(1, tv.getCount(TOKEN));
		tv.remove(TOKEN);
		assertEquals(0, tv.getCount(TOKEN));
		assertTrue(Float.isNaN(tv.getWeightedCount(TOKEN)));
	}
	
	public void testTotalSize() {
		tv.putCount(1L, 2);
		assertEquals(2, tv.getTotal());
		assertEquals(1, tv.size());
		tv.increment(TOKEN);
		assertEquals(3, tv.getTotal());
		assertEquals(2, tv.size());
		tv.putCount(1L, 1);
		assertEquals(2, tv.getTotal());
		assertEquals(2, tv.size());
		tv.remove(TOKEN);
		assertEquals(1, tv.getTotal());
		assertEquals(1, tv.size());
		tv.increment(TOKEN);
		assertEquals(2, tv.getTotal());
		assertEquals(2, tv.size());
	}
}
