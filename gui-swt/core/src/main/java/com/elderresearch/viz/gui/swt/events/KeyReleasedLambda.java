/* ©2017-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.viz.gui.swt.events;

import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;

@FunctionalInterface
public interface KeyReleasedLambda extends KeyListener {
	@Override
	default void keyPressed(KeyEvent e) {
		// No-op
	}
}
