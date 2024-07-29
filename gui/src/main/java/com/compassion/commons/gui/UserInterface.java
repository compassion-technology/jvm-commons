package com.compassion.commons.gui;


public interface UserInterface {
	enum MessageType {
		DEFAULT, WARN, ERROR, INFO, HELP
	}
	
	/**
	 * Updates the interface to reflect the current status of the application.
	 * @param message the message to display to the user, or {@code null} to
	 * reset back to the default, idle status
	 * @param progress the progress of the current operation.  Use {@code 0}
	 * to represent that no progress has been made or if the concept of progress
	 * does not make sense for the current status (for example, an error message),
	 * and {@code -1L} to indicate an indeterminate amount of progress has
	 * been made.
	 * @param size the number of operations that must be performed
	 * before the task will be finished. Use {@code -1L} to
	 * indicate that a task has an indeterminate size
	 * @param cancelable if the interface's cancel button(s) should be enabled
	 */
	void setStatus(String message, long progress, long size, boolean cancelable);
	
	/**
	 * Displays a message to the user.  This message will be overridden next time a task
	 * updates its status.
	 * @param type the type of message
	 * @param message a message to display to the user, or {@code null} to revert to
	 * the default status message
	 */
	void setMessage(MessageType type, String message);
	
	/**
	 * Initialize/build the interface. You should never call this method since the
	 * {@link Controller} starts its own interface. The controller will not begin
	 * working on tasks until this method returns.
	 */
	void initialize();
	
	/**
	 * Starts the interface. This will be invoked from the same thread that invoked
	 * {@link #initialize()}. This method should block and only return from this
	 * call when the interface has been closed/disposed/exited. You should never
	 * call this method since the {@link Controller} starts its own interface.
	 * The controller will begin working on tasks in parallel with this method,
	 * so ensure that necessary UI components have been created in {@link #initialize()}
	 * for start up tasks.
	 */
	void start();
}
