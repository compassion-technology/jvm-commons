/* ©2013-2020 Elder Research, Inc. All rights reserved. */
package com.compassion.commons;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.compassion.commons.StopWatch;
import com.compassion.commons.Utilities;

/**
 * Test case for stop watch utility.
 * 
 * @author <a href="dimeo@datamininglab.com">John Dimeo</a>
 * @since Jan 15, 2013
 */
public class StopWatchTest {
	@Test
	public void testSingleStop() {
		StopWatch sw = new StopWatch();
		assertEquals(0L, sw.getTime());
		
		sw.start();
		Utilities.sleep(50L, TimeUnit.MILLISECONDS);
		sw.stop();
		
		assertTrue(sw.getTime() > 0L);
	}
	
	@Test
	public void testMultipleStops() {
		StopWatch sw = new StopWatch();
		sw.start();
		Utilities.sleep(50L, TimeUnit.MILLISECONDS);
		sw.stop();
		long elapsed1 = sw.getTime();
		sw.start();
		Utilities.sleep(50L, TimeUnit.MILLISECONDS);
		sw.stop();
		long elapsed2 = sw.getTime();
		sw.start();
		Utilities.sleep(50L, TimeUnit.MILLISECONDS);
		sw.stop();
		long elapsed3 = sw.getTime();
		
		assertTrue(elapsed1 > 0L);
		assertTrue(elapsed2 > elapsed1);
		assertTrue(elapsed3 > elapsed2);
	}
	
	@Test
	public void testTwoStarts() {
		try {
			StopWatch sw = new StopWatch();
			sw.start();
			sw.start();
		} catch (IllegalStateException e) {
			return;
		}
		assertTrue(false);
	}
	
	@Test
	public void testNoStarts() {
		try {
			StopWatch sw = new StopWatch();
			sw.stop();
		} catch (IllegalStateException e) {
			return;
		}
		assertTrue(false);
	}
	
	@Test
	public void testTwoStops() {
		try {
			StopWatch sw = new StopWatch();
			sw.start();
			sw.stop();
			sw.stop();
		} catch (IllegalStateException e) {
			return;
		}
		assertTrue(false);
	}
	
	@Test
	public void testReset() {
		StopWatch sw = new StopWatch();
		sw.start();
		Utilities.sleep(50L, TimeUnit.MILLISECONDS);
		sw.stop();
		sw.reset();
		assertEquals(0L, sw.getTime());
	}
}
