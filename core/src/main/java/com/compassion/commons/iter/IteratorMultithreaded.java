package com.compassion.commons.iter;

import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import com.compassion.commons.Utilities;
import com.compassion.commons.LambdaUtils.Interruptable;

/**
 * This class will consume an iterator, spawn multiple worker threads, and then
 * invoke a user-specified callback routine for each element. Note that, when
 * using more than one worker thread, the callback routine must be thread-safe
 * and the iterator order is no longer guaranteed.
 * 
 * @author <a href="dimeo@datamininglab.com">John Dimeo</a>
 * @param <T> the type of object to iterate
 * @since Jul 4, 2013
 */
public abstract class IteratorMultithreaded<T> {
	private static final long WAIT_TIME_MS = 50L;
	private static final int  DEFAULT_QUEUE_SIZE = 102400;
	private static final int  DEFAULT_THREADS = 1;

	private int threads, threadPriority;
	private BlockingQueue<T> queue;
	
	// If the iterator has more elements available (don't want workers to stop when queue is empty)
	private volatile boolean iterHasNext;
	// If objects are still being enqueued/read by the iterator
	private volatile boolean iterEnqueuing;
	// The number of live worker threads
	private CountDownLatch liveThreads;
	
	public IteratorMultithreaded() {
		setQueueSize(DEFAULT_QUEUE_SIZE);
		setThreads(DEFAULT_THREADS);
		setThreadPriority(Thread.NORM_PRIORITY - 1);
	}
	
	/**
	 * Sets the size of the worker thread's queue. The default is {@code 1024}
	 * @param size the new size
	 * @return this for method chaining
	 */
	public IteratorMultithreaded<T> setQueueSize(int size) {
		this.queue = new ArrayBlockingQueue<>(size);
		return this;
	}
	
	/**
	 * Sets the number of worker threads. The default is {@code 1}, thus not
	 * requiring the callback to be thread-safe, but still benefitting from
	 * having the main thread devoted to consuming the iterator.
	 * @param threads the number of worker threads
	 * @return this for method chaining
	 */
	public IteratorMultithreaded<T> setThreads(int threads) {
		this.threads = threads;
		return this;
	}
	
	/**
	 * Sets the priority for the worker threads. Priorities are specified by the
	 * constants in the {@link Thread} class.
	 * @param threadPriority the thread priority for the worker threads
	 * @return this for method chaining
	 */
	public IteratorMultithreaded<T> setThreadPriority(int threadPriority) {
		this.threadPriority = threadPriority;
		return this;
	}
	
	/**
	 * Perform the iteration. This consumes the provided iterator and does not
	 * return until the callback routine has been invoked for every element
	 * returned by the iterator (unless iteration is aborted prematurely).
	 * @param iter the iterator to consume
	 */
	public void iterate(Iterator<T> iter) {
		iterHasNext   = true;
		iterEnqueuing = true;
		liveThreads   = new CountDownLatch(threads);
		for (int i = 0; i < threads; i++) {
			new ThreadedIterWorker("IterThread" + i).start();
		}
		
		while (iterEnqueuing && iter.hasNext()) {
			T obj = preprocess(iter.next());
			if (obj != null) { Utilities.offer(queue, obj, null); }
		}
		iterHasNext = false;
		
		Interruptable.run(liveThreads::await, "waiting for iterator worker threads");
	}
	
	/**
	 * Called before each object is enqueued.
	 * @param object the next object from the iterator
	 * @return the object after preprocessing, a different object of the same
	 * type, or {@code null} to skip this object
	 */
	protected T preprocess(T object) { return object; }
	
	/**
	 * The callback to be invoked for each element. This {@code must} be
	 * thread-safe if there are multiple worker threads. If any invocation of 
	 * callback returns {@code false}, iteration will stop at the next
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
			// Must process the queue (even when iter has stopped) so the enqueuer
			// thread doesn't hang indefinitely waiting for space in the queue.
			while (iterHasNext || !queue.isEmpty()) {
				T obj = Utilities.poll(queue, WAIT_TIME_MS, TimeUnit.MILLISECONDS);
				if (obj != null) { iterEnqueuing &= process(obj); }
			}
			liveThreads.countDown();
		}
	}
}
