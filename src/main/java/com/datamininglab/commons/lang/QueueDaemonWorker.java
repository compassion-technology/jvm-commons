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
import java.util.function.Consumer;

import lombok.val;

/**
 * Processes items in a queue with a daemon thread. 
 * 
 * @author <a href="mailto:dimeo@datamininglab.com">John Dimeo</a>
 * @param <T> the type of items to process
 * @since Aug 26, 2016
 */
public class QueueDaemonWorker<T> implements Runnable {
	private static final long WAIT_TIME_MS = 100L;	
	private static final ThreadGroup GROUP = new ThreadGroup(Utilities.pluralize(QueueDaemonWorker.class.getSimpleName())); 
	
	private int batchSize;
	private BlockingQueue<T> queue;
	private Consumer<List<T>> callback;
	
	private Thread thread;
	private volatile boolean running;
	
	
	/**
	 * Create a new worker.
	 * @param queueSize the maximum size of the queue
	 * @param batchSize the maximum size of each batch of items to process
	 * @param callback callback for the each batch of items. This list will be no larger than <tt>batchSize</tt> but may
	 * only have one item. 
	 */
	public QueueDaemonWorker(int queueSize, int batchSize, Consumer<List<T>> callback) {
		this.queue = new ArrayBlockingQueue<>(queueSize);
		this.batchSize = batchSize;
		this.callback = callback;
		
	}
	
	/**
	 * Start (or restart) the worker thread. Subclasses are encouraged to call this once all initialization is finished.
	 * This method has no effect if it has already been called and the thread is currently running.
	 */
	public void start() {
		if (thread == null || !thread.isAlive()) {
			running = true;
			thread = Utilities.startDaemon(GROUP, this, getClass().getSimpleName());
		}
	}
	
	@Override
	public void run() {
		val batch = new ArrayList<T>(batchSize);
		while (running || !queue.isEmpty()) {
			if (Utilities.pollBatch(queue, 1L, TimeUnit.SECONDS, batch, batchSize)) {
				callback.accept(batch);
				batch.clear();
			}
		}
	}

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
	 * Shuts down the worker thread once the current queue has been processed and waits for the thread to stop.
	 */
	public void shutdownAndWait() {
		shutdown();
		Utilities.join(thread);
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
