package com.compassion.commons.gui.swt.events;

import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;

@FunctionalInterface
public interface FocusLostLambda extends FocusListener {
	@Override
	default void focusGained(FocusEvent e) {
		// No-op
	}
}
