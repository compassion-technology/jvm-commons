package com.compassion.commons.gui.swt.events;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

@FunctionalInterface
public interface SelectionLambda extends SelectionListener {
	@Override
	default void widgetDefaultSelected(SelectionEvent e) {
		widgetSelected(e);
	}
}
