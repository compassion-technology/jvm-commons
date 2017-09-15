/*******************************************************************************
 * Copyright (c) 2016 Elder Research, Inc.
 * All rights reserved.
 *******************************************************************************/
package com.elderresearch.commons.lang;

import java.util.concurrent.TimeUnit;

/**
 * This class is very similar to Apache Common's stopwatch but with three differences
 * that make it easier to use.<ul>
 * <li>Elapsed time is measured with nanosecond precision, not millisecond</li>
 * <li>Start/suspend/resume/stop simplified to start/stop</li>
 * <li>All the methods return the instance for method chaining</li></ul>
 * 
 * This class also introduces a stop watch hierarchy, where child stop watches
 * start and stop parent stop watches (to track the time it takes to perform
 * a parent task at the same time you are tracking each child task).
 * 
 * @author <a href="dimeo@datamininglab.com">John Dimeo</a>
 * @since Jan 15, 2013
 */
public class StopWatch {
	/**
	 * A "dummy" stop watch that immediately returns for all calls to {@link #start()},
	 * {@link #stop()}, and {@link #reset()}. This is useful for "release" code
	 * where you don't want to pay the overhead of using a real stop watch to
	 * measure elapsed time but also don't want to <tt>null</tt> check.
	 */
	public static final StopWatch DUMMY = new StopWatch() {
		@Override public StopWatch reset() { return this; }
		@Override public StopWatch start() { return this; }
		@Override public StopWatch stop()  { return this; }
	};
	
	private StopWatch parent;
	private volatile boolean isRunning;
	private volatile long start;
	private volatile long time;
	
	/**
	 * Sets this stop watch's parent stop watch. Any calls to {@link #start()}
	 * and {@link #stop()} will be propagated to the parent stop watch.
	 * @param parent the parent stop watch, or <tt>null</tt> for no parent
	 * @return this instance for method chaining
	 */
	public StopWatch setParent(StopWatch parent) {
		this.parent = parent;
		return this;
	}
	
	/**
	 * Gets this stop watch's parent stop watch.
	 * @return the parent stop watch
	 */
	public StopWatch getParent() {
		return parent;
	}
	
	/**
	 * Returns whether this stop watch is currently running.
	 * @return the state of the stop watch
	 */
	public boolean isRunning() {
		return isRunning;
	}
	
	/**
	 * Stops the stop watch if it is running and resets the elapsed time.
	 * @return this instance for method chaining
	 */
	public StopWatch reset() {
		if (isRunning) { stop(); }
		time = 0L;
		return this;
	}
	
	/**
	 * Starts the stop watch.
	 * @return this instance for method chaining
	 */
	public StopWatch start() {
		if (isRunning) {
			throw new IllegalStateException("Cannot start a running stop watch");
		}
		
		start = System.nanoTime();
		isRunning = true;
		if (parent != null) { parent.start(); }
		return this;
	}
	
	/**
	 * Stops the stop watch.
	 * @return this instance for method chaining
	 */
	public StopWatch stop() {
		if (!isRunning) {
			throw new IllegalStateException("Cannot stop an idle stop watch");	
		}
		
		time += System.nanoTime() - start;
		isRunning = false;
		if (parent != null) { parent.stop(); }
		return this;
	}
	
	/**
	 * Gets the total elapsed time in milliseconds.
	 * @return the elapsed time in milliseconds
	 */
	public long getTime() {
		return getTime(TimeUnit.MILLISECONDS);
	}
	
	/**
	 * Gets the elapsed time since the last call to {@link #start()}.
	 * @param unit the time unit to which to convert the elapsed time
	 * @return the "lap" time
	 */
	public long getLapTime(TimeUnit unit) {
		return unit.convert(getLapTimeNS(), TimeUnit.NANOSECONDS);
	}
	
	private long getLapTimeNS() {
		return isRunning? System.nanoTime() - start : 0L;
	}
	
	/**
	 * Gets the total elapsed time.
	 * @param unit the time unit to which to convert the elapsed time
	 * @return the elapsed time
	 */
	public long getTime(TimeUnit unit) {
		return unit.convert(time + getLapTimeNS(), TimeUnit.NANOSECONDS);
	}
}
