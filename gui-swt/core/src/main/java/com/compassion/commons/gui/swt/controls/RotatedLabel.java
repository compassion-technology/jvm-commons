/* ©2016-2021 Elder Research, Inc. All rights reserved. */
package com.compassion.commons.gui.swt.controls;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Transform;
import org.eclipse.swt.widgets.Composite;

import com.compassion.commons.LambdaUtils;

public class RotatedLabel extends Composite implements PaintListener {
	private Point preferred;
	private String text = "";

	public RotatedLabel(Composite parent, int style) {
		super(parent, style);
		addPaintListener(this);
		preferred = new Point(SWT.DEFAULT, SWT.DEFAULT);
	}

	@Override
	public Point computeSize(int wHint, int hHint, boolean changed) {
		preferred = LambdaUtils.applyResource(new GC(this), gc -> gc.textExtent(text), GC::dispose);

		int temp    = preferred.x;
		preferred.x = preferred.y;
		preferred.y = temp;
		return preferred;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public void paintControl(PaintEvent e) {
		Point size = getSize();

		Transform t = new Transform(e.display);
		t.translate((size.x - preferred.x) * 0.5f, size.y);
		t.rotate(-90.0f);

		e.gc.setTransform(t);
		e.gc.drawText(text, 0, 0, true);
		t.dispose();
	}
}
