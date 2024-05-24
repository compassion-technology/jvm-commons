/* ©2016-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.viz.gui;

import java.awt.Toolkit;
import java.lang.Thread.UncaughtExceptionHandler;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Catches uncaught exceptions and warns the user with a dialog. Minimal details of
 * the error are shown in the dialog as this is intended to be used with additional
 * functionality to log and report errors. This is used to just alert the user
 * and ask if they want to exit/restart.
 * 
 * @author <a href="dimeo@datamininglab.com">John Dimeo</a>
 * @since Sep 25, 2013
 */
public class JExceptionPane implements UncaughtExceptionHandler {
	static {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			// Ignore- look and feel not critical
		}
	}
	
	
	private String title;
	private Runnable shutDown;
	
	/**
	 * Creates a new exception pane. 
	 * @param title the title to show on the popup dialog (usually your application name)
	 * @param shutDown the code to run if the user wants to close and restart the
	 * application
	 */
	public JExceptionPane(String title, Runnable shutDown) {
		this.title = (title == null)? "Unexpected Problem" : title;
		this.shutDown = shutDown;
	}
	
	@Override
	public void uncaughtException(Thread t, Throwable e) {
		e.printStackTrace();
		Toolkit.getDefaultToolkit().beep();
		if (JOptionPane.showConfirmDialog(null, "An unexpected error has occurred. It is recommended you exit the program"
				+ " and restart it as more errors may occur." + System.lineSeparator() + "Do you want to exit?", 
				title, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
			shutDown.run();
		}
	}
}
