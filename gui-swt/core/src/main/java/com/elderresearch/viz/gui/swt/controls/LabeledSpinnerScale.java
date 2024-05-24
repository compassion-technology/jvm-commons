/* ©2016-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.viz.gui.swt.controls;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Scale;
import org.eclipse.swt.widgets.Spinner;

import com.compassion.commons.Utilities;
import com.elderresearch.viz.gui.swt.controls.builders.SWTBuilders;
import com.elderresearch.viz.gui.swt.events.SelectionLambda;
import com.elderresearch.viz.gui.swt.util.SWTUtilities;

/**
 * Links a {@link Scale} and a {@link Spinner} together so that selection events
 * on one update the selection of the other and vice versa. This widget supports
 * either {@link SWT#HORIZONTAL} (default) or {@link SWT#VERTICAL} styles.
 *
 * @author <a href="dimeo@datamininglab.com">John Dimeo</a>
 * @since Oct 16, 2013
 */
public class LabeledSpinnerScale extends Composite implements SWTBuilders {
	private static final int STYLE_MASK = ~(SWT.VERTICAL | SWT.HORIZONTAL);
	private static final int SCALE_MAX = 100;
	private static final int SCALE_PAGE = 10;

	private Label   label;
	private Scale   scale;
	private Spinner spinner;
	private float   min, max, sel;

	private List<SelectionListener> listeners;

	/**
	 * Creates a new linked spinner-scale. The precision is specified in the
	 * constructor since changes to the selection and ranges depend on the
	 * precision/digits of the spinner.
	 * @param parent the parent composite
	 * @param style the style, passed to this composite
	 * @param digits the precision of the spinner
	 * @see Spinner#setDigits(int)
	 */
	public LabeledSpinnerScale(Composite parent, int style, int digits) {
		super(parent, style & STYLE_MASK);

		label = new Label(this, SWT.WRAP);
		if (Utilities.isOn(style, SWT.VERTICAL)) {
			setLayout(grid(1).get());
			initSpinner(digits);
			initScale(SWT.VERTICAL);
		} else {
			label.setLayoutData(gridData().hFill().hSpan(2).get());
			setLayout(grid(1, 1).get());
			initScale(SWT.HORIZONTAL);
			initSpinner(digits);
		}
		SWTUtilities.setVisibleAndIncluded(label, false);

		scale.addSelectionListener((SelectionLambda) e -> {
			float norm = Utilities.normalize(scale.getSelection(), 0, SCALE_MAX);
			sel = norm * (max - min) + min;
			if (Utilities.isOn(style, SWT.VERTICAL)) { norm = 1.0f - norm; }
			SWTUtilities.setSpinnerSelection(spinner, sel);
			notifyListeners(e);
		});
		spinner.addSelectionListener((SelectionLambda) e -> {
			sel = (float) SWTUtilities.getSpinnerSelection(spinner);
			float norm = Utilities.normalize(sel, min, max);
			if (Utilities.isOn(style, SWT.VERTICAL)) { norm = 1.0f - norm; }
			scale.setSelection(Math.round(norm * SCALE_MAX));
			notifyListeners(e);
		});

		listeners = new LinkedList<>();
	}

	@Override
	public void setEnabled(boolean enabled) {
		super.setEnabled(enabled);
		spinner.setEnabled(enabled);
		scale.setEnabled(enabled);
	}

	private void initSpinner(int digits) {
		spinner = new Spinner(this, SWT.BORDER);
		spinner.setDigits(digits);
		spinner.setMinimum(Integer.MIN_VALUE);
		spinner.setMaximum(Integer.MAX_VALUE);
	}
	private void initScale(int style) {
		scale = new Scale(this, style);
		scale.setMinimum(0);
		scale.setMaximum(SCALE_MAX);
		scale.setPageIncrement(SCALE_PAGE);
		scale.setIncrement(1);
		scale.setLayoutData(gridData().fill().get());
	}

	@Override
	public void setFont(Font font) {
		label.setFont(font);
	}

	public LabeledSpinnerScale addSelectionListener(SelectionListener listener) {
		listeners.add(listener);
		return this;
	}

	public LabeledSpinnerScale setText(String text) {
		label.setText(text);
		SWTUtilities.setVisibleAndIncluded(label, true);
		return this;
	}

	public LabeledSpinnerScale setInsets(int border) {
		GridLayout layout = (GridLayout) getLayout();
		layout.marginHeight = border;
		layout.marginWidth = border;
		layout(false);
		return this;
	}

	public LabeledSpinnerScale setRange(float min, float max) {
		this.min = min;
		this.max = max;
		float diff = max - min;
		SWTUtilities.setSpinnerValues(spinner, min, max, diff / SCALE_MAX, diff / SCALE_PAGE);
		return this;
	}

	public LabeledSpinnerScale setSelection(float sel) {
		SWTUtilities.setSpinnerSelection(spinner, sel);
		spinner.notifyListeners(SWT.Selection, new Event());
		return this;
	}

	private void notifyListeners(SelectionEvent se) {
		for (SelectionListener sl : listeners) { sl.widgetSelected(se); }
	}

	public float getSelection() { return sel; }
}
