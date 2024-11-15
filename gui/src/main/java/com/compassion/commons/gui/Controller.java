package com.compassion.commons.gui;

import java.util.Scanner;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import com.compassion.commons.StatusListener;
import com.compassion.commons.StatusMonitor;
import com.compassion.commons.StatusMonitor.TaskState;
import com.compassion.commons.gui.UserInterface.MessageType;
import com.compassion.commons.Utilities;

import lombok.extern.log4j.Log4j2;

/**
 * A controller is the main thread for an application.  This thread receives
 * events from a separate user interface thread, if any, and manages threads
 * for long-running tasks (see {@link #doTaskAsync(Consumer)}).  This class must be
 * sub-classed to provide application-specific functionality.  To start a
 * controller, call {@link #start()}.  Controllers shut down when another thread
 * exits (usually the calling thread or an interface thread).  Specify this
 * thread with {@link #setInterface(UserInterface)}.
 * @author Jordan Crittenden, John Dimeo
 */
@Log4j2
public class Controller extends Thread implements StatusListener {
	private static final ThreadGroup ERI_CONTROLLER_TASKS = new ThreadGroup("eri-controller-tasks");

	private static final StatusListener CONSOLE_LISTENER = StatusListener.LOG;

	// Wait 200 MS before allowing a task to update the UI with status
	// (to prevent the task from hammering UI widgets like progress bars)
	private static final long STATUS_INTERVAL_MS = 200L;
	// Wait 2 seconds before allowing another running task to display their status
	// (to prevent cycling rapidly through several parallel tasks)
	private static final long TASK_CYCLE_INTERVAL_MS = 2000L;

	private LinkedBlockingQueue<Task> queue = new LinkedBlockingQueue<>();
	private LinkedBlockingDeque<StatusMonitor> active = new LinkedBlockingDeque<>();

	private UserInterface ui = new DefaultInterface();
	private ShutDownDelegate sdd;

	private volatile boolean running;
	private volatile long lastTaskCycle;

	/** Represents a unit of work for this controller. */
	public abstract static class Task implements Runnable {
		private boolean isLongRunning;

		/** The status monitor that monitor's this task's status. */
		protected StatusMonitor status;

		/**
		 * Creates a new task and initializes a new {@link StatusMonitor} to monitor
		 * its progress.  This controller is added as a listener, and the task is
		 * enqueued on the controller's list of tasks.  Subclasses need to implement
		 * the {@link #doTask()} method, and should update the status of the task by
		 * calling methods on the {@code status} field.
		 * @param isLongRunning whether or not this task is "long running" i.e.
		 * should be run on a separate thread from the controller's main thread.
		 * This allows the controller to do work on multiple tasks in parallel.
		 */
		public Task(boolean isLongRunning) {
			this.isLongRunning = isLongRunning;
			status = new StatusMonitor(toString()).addListener(CONSOLE_LISTENER);
		}

		/**
		 * Returns the name describing this task.  This is used as the thread name
		 * for long running tasks and may be used by status listeners to identify
		 * from which task a given status originated.
		 * @return the name describing this task
		 */
		@Override
		public String toString() {
			return getClass().getSimpleName();
		}


		/**
		 * Performs this task's work.  Subclasses should update this task's {@code status}
		 * object and also monitor its state to see if it should abort the work.  The status
		 * monitor is in state {@link TaskState#SCHEDULED} when this method is called.
		 * After this method returns, {@link StatusMonitor#setFinished()} is invoked
		 * automatically, so you do not need to in your implementation of this method.
		 */
		public abstract void doTask();

		@Override
		public void run() {
			status.setStateSilent(TaskState.RUNNING);
			doTask();
			status.setFinished();
		}
	}

	/**
	 * Adds a task to this controller. This enqueues this task and work may
	 * begin immediately if no other tasks are in this controller's queue.
	 * @param t the task to execute
	 * @return this controller for method chaining
	 */
	public Controller add(Task t) {
		t.status.addListener(this).setStateSilent(TaskState.SCHEDULED);

		// This queue will always have space because it is unbounded
		Utilities.offer(queue, t, 1L, TimeUnit.SECONDS);

		return this;
	}

	/**
	 * Create an anonymous task from the lambda and execute it on the main controller thread.
	 * @param callback the task to perform
	 * @return this controller for method chaining
	 */
	public Controller doTask(Consumer<StatusMonitor> callback) {
		return add(new Task(false) {
			@Override public void doTask() { callback.accept(status); }
		});
	}

	/**
	 * Create an anonymous task from the lambda and execute it on a separate thread.
	 * @param callback the task to perform
	 * @return this controller for method chaining
	 */
	public Controller doTaskAsync(Consumer<StatusMonitor> callback) {
		return add(new Task(true) {
			@Override public void doTask() { callback.accept(status); }
		});
	}

	/**
	 * Associates an interface with this controller.  When the thread that was the
	 * last to call this method shuts down, the controller will also automatically shut down.
	 * @param ui the interface with which this controller should communicate.
	 * If this is {@code null} a default interface (with a message to tell the
	 * user to press a key to exit on the console) will be used
	 * @return this controller, useful for chaining a call to {@link #start()} immediately afterward
	 */
	public Controller setInterface(UserInterface ui) {
		this.ui = (ui == null)? new DefaultInterface() : ui;

		if (sdd != null) { sdd.interrupt(); }
		sdd = new ShutDownDelegate(this);
		sdd.start();
		return this;
	}

	public int size() {
		return queue.size();
	}
	
	/**
	 * Start this controller <b>and</b> its associated interface, specified
	 * via {@link #setInterface(UserInterface)}. The controller waits for posted
	 * events and handles them until its interface exists or until it is manually
	 * {@linkplain #shutDown() shut down}.
	 */
	@Override
	public synchronized void start() {
		setName(getClass().getSimpleName());
		ui.initialize();
		running = true;
		super.start();
		ui.start();
	}

	@Override
	public void run() {
		log.info("Starting controller...");
		while (running) {
			Task t = Utilities.poll(queue, 1L, TimeUnit.SECONDS);
			if (t == null) { continue; }

			active.push(t.status);

			if (t.isLongRunning) {
				// Kick off long-running tasks in a separate thread
				// TODO: API for task dependencies/exclusivity
				Utilities.startDaemon(ERI_CONTROLLER_TASKS, t, t + "Worker");
			} else {
				// Handle short tasks on this thread (this allows some
				// dependency logic since this task will "tie up" the
				// controller thread until it is finished)
				t.run();
			}
		}
		log.info("Controller stopped.");
	}

	@Override
	public long getNotifyIntervalNS() {
		return TimeUnit.NANOSECONDS.convert(STATUS_INTERVAL_MS, TimeUnit.MILLISECONDS);
	}

	@Override
	public void statusChanged(StatusMonitor s) {
		long now = System.currentTimeMillis();
		if (!s.isDead()) {
			if (active.peek() == s) {
				ui.setStatus(s.getStatus(), s.getProgress(), s.getSize(), true);
			} else if (now > lastTaskCycle + TASK_CYCLE_INTERVAL_MS) {
				// Pop the task that just updated their status to the top
				active.remove(s);
				active.push(s);

				// Call again, since the task is now on top and will be handled above
				lastTaskCycle = now;
				statusChanged(s);
			}
		} else {
			// Remove finished, canceled, and error tasks
			StatusMonitor newTop;
			active.remove(s);

			if (active.isEmpty()) {
				newTop = null;
			} else {
				newTop = active.peek();
			}

			if (s.getState() == TaskState.ERROR) {
				// Show error message (may be overwritten if another task is running in parallel)
				ui.setMessage(MessageType.ERROR, s.getStatus());
			} else if (newTop == null) {
				// Show default message (no tasks currently running)
				ui.setStatus(null, 0L, 0L, false);
			} else {
				// Show next task on stack's status
				statusChanged(newTop);
			}
		}
	}

	/**
	 * Cancels the last task that updated their status (and should therefore be
	 * the task that the UI is currently displaying), or do nothing if no task
	 * is currently working or if it is not in state {@link TaskState#RUNNING}.
	 */
	public void cancelTask() {
		StatusMonitor sm = active.peek();
		if (sm != null) { sm.setCanceled("The user canceled the task."); }
	}

	/**
	 * Shuts down this controller manually.
	 */
	public void shutDown() {
		for (StatusMonitor sm; (sm = active.poll()) != null; ) {
			if (sm.isRunning()) { sm.setCanceled("The controller was shut down."); }
		}
		running = false;
	}

	private static class DefaultInterface implements UserInterface {
		@Override
		public void initialize() {
			// Do nothing
		}
		@Override
		public void setMessage(MessageType type, String message) {
			// Do nothing
		}
		@Override
		public void setStatus(String message, long progress, long size, boolean cancelable) {
			// Do nothing
		}
		@Override
		public void start() {
			System.out.println("Press any key to exit.");
			try (Scanner s = new Scanner(System.in)) {
				s.next();
			}
		}
	}

	private static class ShutDownDelegate extends Thread {
		private Controller c;
		private Thread t;

		ShutDownDelegate(Controller c) {
			this.c = c;
			this.t = Thread.currentThread();
		}

		@Override
		public void run() {
			Utilities.join(t);
			c.shutDown();
		}
	}
}
