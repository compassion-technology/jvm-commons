/*******************************************************************************
 * Copyright (c) 2016 Elder Research, Inc.
 * All rights reserved.
 *******************************************************************************/
package com.datamininglab.commons.lang;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Processes items in a queue with a daemon thread. 
 * 
 * @author <a href="mailto:dimeo@datamininglab.com">John Dimeo</a>
 * @param <T> the type of items to process
 * @since Aug 26, 2016
 */
public abstract class QueueDaemonWorker<T> implements Runnable {
	private static final long WAIT_TIME_MS = 100L;	
	private static final ThreadGroup GROUP = new ThreadGroup(Utilities.pluralize(QueueDaemonWorker.class.getSimpleName())); 
	
	private int batchSize;
	private BlockingQueue<T> queue;
	private Thread thread;
	private volatile boolean running = true;
	
	/**
	 * Create a new worker.
	 * @param queueSize the maximum size of the queue
	 * @param batchSize the maximum size of each batch of items to process
	 */
	protected QueueDaemonWorker(int queueSize, int batchSize) {
		this.batchSize = batchSize;
		this.queue = new ArrayBlockingQueue<>(queueSize);
	}
	
	/**
	 * Start (or restart) the worker thread. Subclasses are encouraged to call this once all initialization is finished.
	 * This method has no effect if it has already been called and the thread is currently running.
	 */
	public void start() {
		if (thread == null || !thread.isAlive()) {
			thread = Utilities.startDaemon(GROUP, this, getClass().getSimpleName());
		}
	}
	
	@Override
	public void run() {
		List<T> batch = new ArrayList<>(batchSize);
		while (running || !queue.isEmpty()) {
			if (Utilities.pollBatch(queue, 1L, TimeUnit.SECONDS, batch, batchSize)) {
				nextBatch(batch);
				batch.clear();
			}
		}
	}

	/**
	 * Do work on the next batch of items. This list will be no larger than the batch size passed to the constructor,
	 * but may only have one item. 
	 * @param batch the next batch of items to process
	 */
	protected abstract void nextBatch(List<T> batch); 
	
	/**
	 * Enqueue an item for this worker to process. This method will block until space is available on the queue or
	 * {@link #cancel()} is called.
	 * @param obj the object to enqueue
	 */
	public void enqueue(T obj) {
		while (running) {
			if (Utilities.offer(queue, obj, WAIT_TIME_MS, TimeUnit.MILLISECONDS)) { return; }
		}
	}
	
	/**
	 * Shuts down the worker thread once the current queue has been processed. You don't have to call this method
	 * since the worker thread won't keep the VM alive, but can be used if you know you won't enqueue any more work.
	 * To stop the thread immediately, use {@link #getThread()}. 
	 */
	public void shutdown() { running = false; }
	
	/**
	 * Gets the worker thread.
	 * @return the worker thread, or <tt>null</tt> if this worker has not yet been started.
	 */
	public Thread getThread() { return thread; }
}
