/*
 * Copyright (c) 2013 Elder Research, Inc.
 * All rights reserved.
 */
package com.datamininglab.commons.lang;

import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import com.datamininglab.commons.logging.LogContext;

/**
 * This class will consume an iterator, spawn multiple worker threads, and then
 * invoke a user-specified callback routine for each element. Note that, when
 * using more than one worker thread, the callback routine must be thread-safe
 * and the iterator order is no longer guaranteed.
 * 
 * @author <a href="dimeo@datamininglab.com">John Dimeo</a>
 * @since Jul 4, 2013
 * @param <T> the type of object to iterate
 */
public abstract class ParallelIterator<T> {
	private static final long WAIT_TIME_MS = 50L;
	private static final int  DEFAULT_QUEUE_SIZE = 102400;
	private static final int  DEFAULT_THREADS = 1;

	private StatusMonitor sm;
	private int threads, threadPriority;
	private ArrayBlockingQueue<T> queue;
	
	// If the iterator has more elements available (don't want workers to stop when queue is empty)
	private volatile boolean iterHasNext;
	// If all the iterator worker threads are still running
	private volatile boolean iterWorking;
	// The number of live worker threads
	private CountDownLatch liveThreads;
	
	public ParallelIterator() {
		setQueueSize(DEFAULT_QUEUE_SIZE);
		setThreads(DEFAULT_THREADS);
		setThreadPriority(Thread.NORM_PRIORITY - 1);
	}
	
	/**
	 * Sets the size of the worker thread's queue. The default is <tt>1024</tt>
	 * @param size the new size
	 * @return this for method chaining
	 */
	public ParallelIterator<T> setQueueSize(int size) {
		this.queue = new ArrayBlockingQueue<>(size);
		return this;
	}
	
	/**
	 * Sets the number of worker threads. The default is <tt>1</tt>, thus not
	 * requiring the callback to be thread-safe, but still benefitting from
	 * having the main thread devoted to consuming the iterator.
	 * @param threads the number of worker threads
	 * @return this for method chaining
	 */
	public ParallelIterator<T> setThreads(int threads) {
		this.threads = threads;
		return this;
	}
	
	
	/**
	 * Sets the priority for the worker threads. Priorities are specified by the
	 * constants in the {@link Thread} class.
	 * @param threadPriority the thread priority for the worker threads
	 * @return this for method chaining
	 */
	public ParallelIterator<T> setThreadPriority(int threadPriority) {
		this.threadPriority = threadPriority;
		return this;
	}
	
	/**
	 * Sets the status monitor to use to monitor iteration. If the monitor stops
	 * running, iteration will stop. As each element is enqueued, the relative
	 * progress will be incremented by <tt>1</tt>, so the size of the monitor
	 * should be set to the total number of elements (if known) for determinate
	 * progress.
	 * @param sm the status monitor (optional)
	 * @return this for method chaining
	 */
	public ParallelIterator<T> setMonitor(StatusMonitor sm) {
		this.sm = sm;
		return this;
	}
	
	/**
	 * Perform the iteration. This consumes the provided iterator and does not
	 * return until the callback routine has been invoked for every element
	 * returned by the iterator (unless iteration is aborted prematurely).
	 * @param iter the iterator to consume
	 */
	public void iterate(Iterator<T> iter) {
		iterHasNext = true;
		iterWorking = true;
		liveThreads = new CountDownLatch(threads);
		for (int i = 0; i < threads; i++) {
			String name = "IterThread" + i;
			if (sm != null) { name = sm.getName() + name; }
			
			new ThreadedIterWorker(name).start();
		}
		
		if (sm != null) { sm.setProgress(0L, false); }
		while (iterWorking && iter.hasNext()) {
			Utilities.offer(queue, iter.next(), sm);
			if (sm != null) { sm.setProgress(1L, true); }
		}
		iterHasNext = false;
		
		try {
			liveThreads.await();
		} catch (InterruptedException e) {
			LogContext.warning("Interrupted while waiting for iterator worker threads");
		}
	}
	
	/**
	 * The callback to be invoked for each element. This <tt>must</tt> be
	 * thread-safe if there are multiple worker threads. If any invocation of 
	 * callback returns <tt>false</tt>, iteration will stop at the next
	 * opportunity.
	 * @param object the next object to process
	 * @return if iteration should continue
	 */
	protected abstract boolean process(T object);
	
	private class ThreadedIterWorker extends Thread {
		ThreadedIterWorker(String name) {
			super(name);
			setDaemon(true);
			setPriority(threadPriority);
		}
		
		@Override
		public void run() {
			while (iterWorking && (iterHasNext || !queue.isEmpty())) {
				T obj = Utilities.poll(queue, WAIT_TIME_MS, TimeUnit.MILLISECONDS);
				if (obj != null) { iterWorking &= process(obj); }
			}
			liveThreads.countDown();
		}
	}
}
