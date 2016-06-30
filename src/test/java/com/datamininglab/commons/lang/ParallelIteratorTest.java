/*******************************************************************************
 * Copyright (c) 2016 Elder Research, Inc.
 * All rights reserved.
 *******************************************************************************/
package com.datamininglab.commons.lang;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import junit.framework.TestCase;

public class ParallelIteratorTest extends TestCase {
	private static final Random RAND = new Random();
	private static final int RECORDS = 100000;
	private AtomicInteger count = new AtomicInteger();
	
	public void testIterator() {
		final List<Integer> list = new ArrayList<>(RECORDS);
		for (int i = 0; i < RECORDS; i++) { list.add(RAND.nextInt(10)); }
		
		new ParallelIterator<Integer>() {
			@Override
			protected boolean process(Integer object) {
				count.incrementAndGet();
				return true;
			}
		}.setThreads(6).iterate(list.iterator());
		assertEquals(RECORDS, count.get());
	}
}
