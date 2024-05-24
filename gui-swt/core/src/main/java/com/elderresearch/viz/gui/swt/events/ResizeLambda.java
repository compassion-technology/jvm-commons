/* ©2016-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.viz.gui.swt.events;

import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;

@FunctionalInterface
public interface ResizeLambda extends ControlListener {
	@Override
	default void controlMoved(ControlEvent e) {
		// No-op by default- moving is rarely handled since it's controlled by layout engines
	}
}
