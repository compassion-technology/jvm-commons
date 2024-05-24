/* ©2016-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.viz.gui.swt.controls;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;

import com.compassion.commons.Utilities;
import com.elderresearch.viz.gui.swt.util.SWTUtilities;

public class CScrolledComposite extends Composite implements ControlListener {
	private ScrolledComposite sc;
	private boolean hscroll, vscroll;

	public CScrolledComposite(Composite parent, int style) {
		super(new ScrolledComposite(parent, style), SWT.NONE);
		sc = (ScrolledComposite) getParent();

		hscroll = Utilities.isOn(style, SWT.H_SCROLL);
		vscroll = Utilities.isOn(style, SWT.V_SCROLL);
		sc.setExpandHorizontal(true);
		sc.setExpandVertical(true);
		sc.setContent(this);
		sc.addControlListener(this);
		SWTUtilities.setScrollIncrementsOnResize(this);

		autoSize();
	}

	public void autoSize() {
		layout();
		Rectangle r = sc.getClientArea();
		Point p = computeSize(hscroll? SWT.DEFAULT : r.width, vscroll? SWT.DEFAULT : r.height);
		sc.setMinSize(p);
	}

	@Override
	public void setLayoutData(Object layoutData) {
		sc.setLayoutData(layoutData);
	}

	@Override
	public void controlResized(ControlEvent e) {
		autoSize();
	}

	@Override
	public void controlMoved(ControlEvent e) {
		// No-op by default
	}
}
