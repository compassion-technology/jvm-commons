package com.compassion.commons.gui.swt.events;

import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;

@FunctionalInterface
public interface FocusGainedLambda extends FocusListener {
	@Override
	default void focusLost(FocusEvent e) {
		// No-op
	}
}
