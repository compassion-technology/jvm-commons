package com.compassion.commons;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

import com.compassion.commons.iter.IteratorMultithreaded;

public class ParallelIteratorTest {
	private static final Random RAND = new Random();
	private static final int RECORDS = 100000;
	private AtomicInteger count = new AtomicInteger();
	
	@Test
	public void testIterator() {
		final List<Integer> list = new ArrayList<>(RECORDS);
		for (int i = 0; i < RECORDS; i++) { list.add(RAND.nextInt(10)); }
		
		new IteratorMultithreaded<Integer>() {
			@Override
			protected boolean process(Integer object) {
				count.incrementAndGet();
				return true;
			}
		}.setThreads(6).iterate(list.iterator());
		assertEquals(RECORDS, count.get());
	}
}
