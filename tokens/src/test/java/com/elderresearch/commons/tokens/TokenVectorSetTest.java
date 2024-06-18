/* ©2017-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.commons.tokens;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.Range;
import org.apache.commons.math3.util.MathArrays.OrderDirection;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.map.mutable.primitive.LongShortHashMap;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.compassion.commons.Utilities;
import com.elderresearch.commons.math.distance.Angle;
import com.elderresearch.commons.tokens.TVSDistanceSettings.MaxDistanceAggregation;

import lombok.val;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class TokenVectorSetTest {
	private static final float EPS = 0.0001f;
	private static int testCount = 0;
	
	private TokenVectorSet<TokenVector> tvs;
	private TokenVector tv1, tv2, tv3;
	
	@BeforeEach
	protected void setUp() throws Exception {
		tvs = new TokenVectorSet<>("test" + ++testCount, TokenVector.class, 1, true);
		
		TokenVectorBuilder tvb = new TokenVectorBuilder().setTransformer(String::toLowerCase);
		tv1 = tvb.build("My dog ate my homework");
		tv2 = tvb.build("My cat ate my sandwich");
		tv3 = tvb.build("A dolphin ate the homework");
	}
	
	@AfterEach
	protected void tearDown() throws Exception {
		tvs.close();
	}
	
	@Test
	public void testAdd() {
		assertTrue(tvs.add(0L, tv1));
		assertTrue(tvs.add(1L, tv2));
		assertTrue(tvs.add(2L, tv3));
		assertFalse(tvs.add(1L, tv2));
	}
	
	@Test
	public void testMerge() {
		assertTrue(tvs.add(1L, tv1));
		tvs.merge(1L, tv2);
		assertEquals(2L, tvs.get(1L).getCount("ate"));
		assertEquals(1L, tvs.size());
	}
	
	@Test
	public void testChange() {
		assertTrue(tvs.add(0L, tv1));
		assertTrue(tvs.add(1L, tv2));
		assertTrue(tvs.add(2L, tv3));
		Utilities.sleep(100L, TimeUnit.MILLISECONDS);
		tvs.update(0L, $ -> $.increment("dog"));
		Utilities.sleep(100L, TimeUnit.MILLISECONDS);
		assertEquals(2, tvs.get(0L).getCount("dog"));
	}
	
	@Test
	public void testIterator() {
		assertTrue(tvs.add(0L, tv1));
		assertTrue(tvs.add(1L, tv2));
		assertTrue(tvs.add(2L, tv3));
		assertCompleteIteration("Simple iter", 0L, tvs.iterator());
	}
	
	@Test
	public void testIteratorComplex() {
		assertTrue(tvs.add(0L, tv1));
		assertTrue(tvs.add(1L, tv2));
		assertTrue(tvs.add(2L, tv3));
		assertTrue(tvs.add(3L, new TokenVector()));
		assertTrue(tvs.add(4L, new TokenVector()));
		assertNotNull(tvs.get(1L));
		assertCompleteIteration("Complex iter", 0L, tvs.iterator());
	}
	
	private void assertCompleteIteration(String type, long minKey, Iterator<TokenVector> iter) {
		MutableLongList keys = LongLists.mutable.empty();
		while (iter.hasNext()) {
			TokenVector tv = iter.next();
			keys.add(tv.getKey());
			log.info("{}: key {}", type, tv.getKey());
		}
		for (long key = minKey; key < tvs.size(); key++) {
			assertTrue(keys.remove(key));
		}
		assertTrue(keys.isEmpty());
	}
	
	public void testComputeWeights() {
		assertTrue(tvs.add(0L, tv1));
		assertTrue(tvs.add(1L, tv2));
		assertTrue(tvs.add(2L, tv3));
		
		tvs.updateCounts(null);
		
		TokenVector tfidf = tvs.getTokenWeights();
		assertTrue(Float.isNaN(tfidf.getWeightedCount("ate")));
		assertTrue(Float.isNaN(tfidf.getWeightedCount("my")));
		assertTrue(Float.isNaN(tfidf.getWeightedCount("dolphin")));
		
		tvs.updateWeights(null, null);
		
		// Weight of "ate" should be 0, occurs 1 time in tv1
		assertEquals(0.0f, tfidf.getWeightedCount("ate"), EPS);
		assertEquals(0.0f, tvs.get(0L).getWeightedCount("ate"));
		
		// Weight of "my" should be 0.405465, occurs 2 times in tv2
		assertEquals(0.405465f, tfidf.getWeightedCount("my"), EPS);
		assertEquals(0.810930f, tvs.get(1L).getWeightedCount("my"), EPS);
		
		// Weight of "dolphin" should be 1.098612, occurs 1 time in tv3
		assertEquals(1.098612f, tfidf.getWeightedCount("dolphin"), EPS);
		assertEquals(1.098612f, tvs.get(2L).getWeightedCount("dolphin"), EPS);
	}
	
	public void testRemoveRare() {
		assertTrue(tvs.add(0L, tv1));
		assertTrue(tvs.add(1L, tv2));
		assertTrue(tvs.add(2L, tv3));
		tvs.updateCounts(null);
		
		TokenVector tfidf = tvs.getTokenWeights();
		assertEquals(9, tfidf.size());
		tvs.updateWeights(null, tvs.getTokenWeights().getTokensWithCountIn(Range.between((short) 2, Short.MAX_VALUE)));
		assertEquals(3, tfidf.size());
	}
	
	public void testMergedWeights() {
		tvs.merge(0L, tv1);
		tvs.merge(1L, tv2);
		tvs.merge(1L, tv3);
		
		tvs.updateWeights(null, null);
		
		TokenVector tfidf = tvs.getTokenWeights();
		assertEquals(0.0f, tfidf.getWeightedCount("ate"), EPS);
		assertEquals(0.0f, tfidf.getWeightedCount("homework"), EPS);
		assertEquals(0.693147f, tfidf.getWeightedCount("dog"), EPS);
		assertEquals(0.693147f, tfidf.getWeightedCount("dolphin"), EPS);
	}
	
	public void testMergeMultithreaded() throws InterruptedException {
		val threads = 100;
		val latch = new CountDownLatch(threads);
		for (int i = 0; i < threads; i++) {
			val key = i % 2;
			Utilities.startDaemon(null, () -> {
				val tv = new TokenVector();
				tv.countsRaw = new LongShortHashMap(tv1.countsRaw);
				tvs.merge(key, tv);
				latch.countDown();
			}, "merger" + i);
		}
		latch.await();

		assertEquals(2L, tvs.size());
		
		TokenVector tv = tvs.get(0L);
		assertEquals(threads, tv.getCount("my"));
		assertEquals(threads / 2, tv.getCount("dog"));
		assertEquals(threads / 2, tv.getCount("ate"));
		assertEquals(threads / 2, tv.getCount("homework"));
		
		tv = tvs.get(1L);
		assertEquals(threads, tv.getCount("my"));
		assertEquals(threads / 2, tv.getCount("dog"));
		assertEquals(threads / 2, tv.getCount("ate"));
		assertEquals(threads / 2, tv.getCount("homework"));
	}
	
	public void testPairIterator() {
		assertTrue(tvs.add(0L, tv1));
		assertTrue(tvs.add(1L, tv2));
		assertTrue(tvs.add(2L, tv3));
		assertTrue(tvs.add(3L, new TokenVector()));
		assertTrue(tvs.add(4L, new TokenVector()));
		
		tvs.pairIterator(true).forEachRemaining(pair -> {
			log.info("Unique pair iterator: keys [{}, {}]", pair.v1.getKey(), pair.v2.getKey());
		});
		tvs.pairIterator(false).forEachRemaining(pair -> {
			log.info("All pair iterator: keys [{}, {}]", pair.v1.getKey(), pair.v2.getKey());
		});
		// TODO: Assert beyond console output this worked
	}
	
	public void testComputeDistances() {
		assertTrue(tvs.add(0L, tv1));
		assertTrue(tvs.add(1L, tv2));
		assertTrue(tvs.add(2L, tv3));
		
		tvs.updateWeights(null, null);
		
		Iterator<TVSDistance> iter = tvs.computeDistances(new TVSDistanceSettings()
			.setMetric(new Angle())
			.setThreads(2)
			.setMaxDistances(5))
			.iterator();
		
		assertTrue(iter.hasNext());
		assertEquals(74.7267f, iter.next().getDistance(), EPS);
		assertTrue(iter.hasNext());
		assertEquals(86.5990f, iter.next().getDistance(), EPS);
		assertTrue(iter.hasNext());
		assertEquals(90.0000f, iter.next().getDistance(), EPS);
		assertFalse(iter.hasNext());
	}
	
	public void testComputeDistancesOrdered() {
		assertTrue(tvs.add(0L, tv1));
		assertTrue(tvs.add(1L, tv2));
		assertTrue(tvs.add(2L, tv3));
		
		tvs.updateWeights(null, null);
		
		Iterator<TVSDistance> iter = tvs.computeDistances(new TVSDistanceSettings()
			.setMetric(new Angle())
			.setThreads(2)
			.setSortOrder(OrderDirection.DECREASING)
			.setMaxDistances(5))
			.iterator();
		
		assertTrue(iter.hasNext());
		assertEquals(90.0000f, iter.next().getDistance(), EPS);
		assertTrue(iter.hasNext());
		assertEquals(86.5990f, iter.next().getDistance(), EPS);
		assertTrue(iter.hasNext());
		assertEquals(74.7267f, iter.next().getDistance(), EPS);
		assertFalse(iter.hasNext());
	}
	
	public void testComputeDistancesPerID() {
		assertTrue(tvs.add(0L, tv1));
		assertTrue(tvs.add(1L, tv2));
		assertTrue(tvs.add(2L, tv3));
		
		tvs.updateWeights(null, null);
		
		Iterator<TVSDistance> iter = tvs.computeDistances(new TVSDistanceSettings()
			.setMetric(new Angle())
			.setMaxAggregation(MaxDistanceAggregation.PER_UNIQUE_ID)
			.setThreads(2)
			.setMaxDistances(2))
			.iterator();
		
		assertTrue(iter.hasNext());
		assertEquals(74.7267f, iter.next().getDistance(), EPS);
		assertTrue(iter.hasNext());
		assertEquals(86.5990f, iter.next().getDistance(), EPS);
		assertTrue(iter.hasNext());
		assertEquals(90.0000f, iter.next().getDistance(), EPS);
		assertFalse(iter.hasNext());
	}
	
	public void testComputeDistancesOther() {
		assertTrue(tvs.add(0L, tv1));
		assertTrue(tvs.add(1L, tv2));
		tvs.updateCounts(null);
		
		try (val otherTVS = new TokenVectorSet<>("other", TokenVector.class)) {
			assertTrue(otherTVS.add(2L, tv3));
			otherTVS.updateCounts(null);
			
			Iterator<TVSDistance> iter = tvs.computeDistancesWith(otherTVS, new TVSDistanceSettings()
				.setMetric(new Angle())
				.setThreads(2)
				.setMaxDistances(5))
				.iterator();
			
			assertTrue(iter.hasNext());
			assertEquals(86.5990f, iter.next().getDistance(), EPS);
			assertTrue(iter.hasNext());
			assertEquals(90.0000f, iter.next().getDistance(), EPS);
			assertFalse(iter.hasNext());
		}
	}
}
