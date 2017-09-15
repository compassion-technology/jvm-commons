/*******************************************************************************
 * Copyright (c) 2016 Elder Research, Inc.
 * All rights reserved.
 *******************************************************************************/
package com.elderresearch.commons.lang;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import org.apache.commons.lang3.StringUtils;

import lombok.Getter;
import lombok.Setter;
import lombok.val;
import lombok.experimental.Accessors;

/**
 * Processes items in a queue with a daemon thread. 
 * 
 * @author <a href="mailto:dimeo@datamininglab.com">John Dimeo</a>
 * @param <T> the type of items to process
 * @since Aug 26, 2016
 */
@Accessors(chain = true)
public class DaemonWorker<T> implements Runnable {
	private static final long WAIT_TIME_MS = 100L;	
	private static final ThreadGroup GROUP = new ThreadGroup(Utilities.pluralize(DaemonWorker.class.getSimpleName()));
	private static volatile int instances;
	
	/** The worker thread name. Defaults to the class name. */
	@Setter private String name;
	/** The callback to invoke for the each batch of items. This list will be no larger than {@link #setMaxBatchSize(int)}
	 *  but may only have one item. */ 
	@Setter private Consumer<List<T>> callback;
	/** The maximum size of each batch of items to process. */
	@Setter private int maxBatchSize;
	/** The worker thread, or <tt>null</tt> if this worker has not yet been started. */
	@Getter private Thread thread;
	
	private BlockingQueue<T> queue;
	private volatile boolean running;

	/**
	 * Create a new worker.
	 * @param queueSize the maximum size of the queue
	 * @param callback callback for the each batch of items. This list will be no larger than <tt>batchSize</tt> but may
	 * only have one item. 
	 */
	public DaemonWorker(int queueSize, Consumer<List<T>> callback) {
		this(null, queueSize, callback);
	}
	
	/**
	 * Create a new worker.
	 * @param name the thread name
	 * @param queueSize the maximum size of the queue
	 * @param callback callback for the each batch of items. This list will be no larger than <tt>batchSize</tt> but may
	 * only have one item. 
	 */
	public DaemonWorker(String name, int queueSize, Consumer<List<T>> callback) {
		this.name = StringUtils.defaultString(name, getClass().getSimpleName() + instances++);
		this.queue = new ArrayBlockingQueue<>(queueSize);
		this.maxBatchSize = queueSize;
		this.callback = callback;
	}
	
	protected DaemonWorker(int queueSize) {
		this(null, queueSize, null);
	}
	
	/**
	 * Start (or restart) the worker thread. Subclasses are encouraged to call this once all initialization is finished.
	 * This method has no effect if it has already been called and the thread is currently running.
	 * @return this for method chaining
	 */
	public DaemonWorker<T> start() {
		if (thread == null || !thread.isAlive()) {
			running = true;
			thread = Utilities.startDaemon(GROUP, this, name);
		}
		return this;
	}
	
	@Override
	public void run() {
		val batch = new ArrayList<T>(maxBatchSize);
		while (running || !queue.isEmpty()) {
			if (Utilities.pollBatch(queue, 1L, TimeUnit.SECONDS, batch, maxBatchSize)) {
				process(batch);
				batch.clear();
			}
		}
	}

	protected void process(List<T> batch) {
		callback.accept(batch);
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
}
