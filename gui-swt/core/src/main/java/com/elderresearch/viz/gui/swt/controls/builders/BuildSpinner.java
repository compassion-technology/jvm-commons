/* ©2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.viz.gui.swt.controls.builders;

import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.events.ModifyListener;

import com.elderresearch.viz.gui.swt.events.SelectionLambda;

public class BuildSpinner extends BuildControl<Spinner, BuildSpinner> {
	protected BuildSpinner(Spinner s) {
		super(s);
	}
	
	public BuildSpinner selection(int num) {
		ref.setSelection(num);
		return this;
	}
	
	public BuildSpinner increment(int inc) {
		ref.setIncrement(inc);
		return this;
	}
	
	public BuildSpinner min(int min) {
		ref.setMinimum(min);
		return this;
	}
	
	public BuildSpinner max(int max) {
		ref.setMaximum(max);
		return this;
	}
	
	public BuildSpinner range(int min, int max) {
		return min(min).max(max);
	}
	
	public BuildSpinner page(int pInc) {
		ref.setPageIncrement(pInc);
		return this;
	}
	
	public BuildSpinner onModify(ModifyListener ml) {
		ref.addModifyListener(ml);
		return this;
	}

	public BuildSpinner onSelect(SelectionLambda sl) {
		ref.addSelectionListener(sl);
		return this;
	}
		
	@Override
	protected BuildSpinner self() { return this; }
}
