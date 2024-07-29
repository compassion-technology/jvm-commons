package com.compassion.commons.gui.swt.events;

import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;

@FunctionalInterface
public interface MouseUpLambda extends MouseListener {
	@Override
	default void mouseDown(MouseEvent e) {
		// No-op
	}
	
	@Override
	default void mouseDoubleClick(MouseEvent e) {
		// No-op
	}
}
