/* ©2016-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.viz.gui.swt.dialog;

import java.lang.Thread.UncaughtExceptionHandler;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

import com.elderresearch.viz.gui.swt.util.SWTUtilities;

/**
 * Catches uncaught exceptions and warns the user with a dialog. Minimal details of
 * the error are shown in the dialog as this is intended to be used with additional
 * functionality to log and report errors. This is used to just alert the user
 * and ask if they want to exit/restart.
 * 
 * @author <a href="dimeo@datamininglab.com">John Dimeo</a>
 * @since Sep 25, 2013
 */
public class ExceptionBox implements UncaughtExceptionHandler, Runnable {
	private Shell shell;
	
	public ExceptionBox(Shell shell) {
		this.shell = shell;
	}
	
	@Override
	public void uncaughtException(Thread t, Throwable e) {
		e.printStackTrace();
		SWTUtilities.run(shell.getDisplay(), this);
	}
	
	@Override
	public void run() {
		MessageBox mb = new MessageBox(shell, SWT.ICON_WARNING | SWT.YES | SWT.NO);
		mb.setText(shell.getText() + " Problem");
		mb.setMessage("An unexpected error has occurred. It is recommended you exit the program"
				+ " and restart it as more errors may occur." + System.lineSeparator() + "Do you want to exit?");
		if (mb.open() == SWT.YES) {
			shell.getDisplay().dispose();
		} else if (SWTUtilities.isUIThread()) {
			// Restart event loop- this will work until the next uncaught error
			SWTUtilities.open(shell);
		}
	}
}
