/* ©2017-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.viz.gui.swt.events;

import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.events.ShellListener;

@FunctionalInterface
public interface ShellClosedLambda extends ShellListener {
	@Override
	default void shellActivated(ShellEvent e) {
		// No-op
	}
	
	@Override
	default void shellDeactivated(ShellEvent e) {
		// No-op
	}
	
	@Override
	default void shellIconified(ShellEvent e) {
		// No-op		
	}
	
	@Override
	default void shellDeiconified(ShellEvent e) {
		// No-op		
	}
}
