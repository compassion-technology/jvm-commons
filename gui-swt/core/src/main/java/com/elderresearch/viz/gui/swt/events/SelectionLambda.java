/* ©2016-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.viz.gui.swt.events;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

@FunctionalInterface
public interface SelectionLambda extends SelectionListener {
	@Override
	default void widgetDefaultSelected(SelectionEvent e) {
		widgetSelected(e);
	}
}
