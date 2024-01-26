/* ©2016-2020 Elder Research, Inc. All rights reserved. */
package com.compassion.commons;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

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
	@Setter @Getter private String name;
	/** The callback to invoke for the each batch of items. This list will be no larger than {@link #setMaxBatchSize(int)}
	 *  but may only have one item. */ 
	@Setter private Consumer<List<T>> callback;
	/** The maximum size of each batch of items to process. */
	@Setter private int maxBatchSize;
	/** The worker thread, or {@code null} if this worker has not yet been started. */
	@Getter private Thread thread;
	
	private BlockingQueue<T> queue;
	private volatile boolean running;
	
	private DaemonWorker<?>[] waitFor;
	@Setter private Runnable beforeWork, afterWork;

	/**
	 * Create a new worker.
	 * @param queueSize the maximum size of the queue
	 * @param callback callback for the each batch of items. This list will have between one and the capacity of the
	 * queue elements when the callback is invoked.
	 */
	public DaemonWorker(int queueSize, Consumer<List<T>> callback) {
		this(null, queueSize, callback);
	}

	/**
	 * Create a new worker.
	 * @param queue the queue from which to poll for work
	 * @param callback callback for the each batch of items. This list will have between one and the capacity of the
	 * queue elements when the callback is invoked.
	 */
	public DaemonWorker(BlockingQueue<T> queue, Consumer<List<T>> callback) {
		this(null, queue, callback);
	}
	
	/**
	 * Create a new worker.
	 * @param name the thread name
	 * @param queueSize the maximum size of the queue
	 * @param callback callback for the each batch of items. This list will have between one and the capacity of the
	 * queue elements when the callback is invoked.
	 */
	public DaemonWorker(String name, int queueSize, Consumer<List<T>> callback) {
		this(name, new ArrayBlockingQueue<>(queueSize), callback);
	}
	
	/**
	 * Create a new worker.
	 * @param name the thread name
	 * @param queue the queue from which to poll for work
	 * @param callback callback for the each batch of items. This list will have between one and the capacity of the
	 * queue elements when the callback is invoked.
	 */
	public DaemonWorker(String name, BlockingQueue<T> queue, Consumer<List<T>> callback) {
		this.name = Objects.toString(name, getClass().getSimpleName() + instances++);
		this.queue = queue;
		this.maxBatchSize = queue.remainingCapacity();
		this.callback = callback;
		waitFor();
	}
	
	protected DaemonWorker(int queueSize) {
		this(queueSize, null);
	}
	
	/**
	 * Indicate an upstream workers on which this worker should wait before exiting.
	 * @param upstream one or more threads that should prevent this worker from exiting while it is still 
	 * running
	 * @return this for method chaining
	 */
	public DaemonWorker<T> waitFor(DaemonWorker<?>... upstream) {
		this.waitFor = upstream;
		return this;
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
		if (beforeWork != null) { beforeWork.run(); }
		
		List<T> batch = new ArrayList<>(maxBatchSize);
		while (running || !queue.isEmpty() || anyRunningUpstreamWorkers()) {
			if (Utilities.pollBatch(queue, 1L, TimeUnit.SECONDS, batch, maxBatchSize)) {
				process(batch);
				batch.clear();
			}
		}
		running = false;
		
		if (afterWork != null) { afterWork.run(); }
	}
	
	private boolean anyRunningUpstreamWorkers() {
		for (val w : waitFor) {
			if (w.running) { return true; }
		}
		return false;
	}
	
	protected void process(List<T> batch) {
		callback.accept(batch);
	}
	
	/**
	 * Enqueue an item for this worker to process. This method will block until space is available on the queue or
	 * until {@link #shutdown()} or {@link #shutdownAndWait()} are called.
	 * @param obj the object to enqueue
	 */
	public boolean enqueue(T obj) {
		while (running) {
			if (Utilities.offer(queue, obj, WAIT_TIME_MS, TimeUnit.MILLISECONDS)) { return true; }
		}
		return false;
	}
	
	/**
	 * Shuts down the worker thread once the current queue has been processed and waits for the thread to stop.
	 */
	public void shutdownAndWait() {
		shutdown();
		LambdaUtils.accept(thread, Utilities::join);
	}
	
	/**
	 * Shuts down the worker thread once the current queue has been processed. You don't have to call this method
	 * since the worker thread won't keep the VM alive, but can be used if you know you won't enqueue any more work.
	 * To stop the thread immediately, use {@link #getThread()}. 
	 */
	public void shutdown() { running = false; }
	
	/**
	 * Gets the number of objects in the queue.
	 * @return the pending work for this worker
	 */
	public int getPendingWork() {
		return queue.size();
	}
}
