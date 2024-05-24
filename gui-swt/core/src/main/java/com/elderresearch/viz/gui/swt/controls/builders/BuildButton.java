/* ©2017-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.viz.gui.swt.controls.builders;

import org.eclipse.swt.widgets.Button;

import com.elderresearch.viz.gui.swt.events.SelectionLambda;

public class BuildButton extends BuildControlWithImage<Button, BuildButton> {
	protected BuildButton(Button b) {
		super(b, Button::setText, Button::setAlignment, Button::setImage);
	}
	
	public BuildButton selected(boolean selected) {
		ref.setSelection(selected);
		return this;
	}

	public BuildButton onSelect(SelectionLambda sl) {
		ref.addSelectionListener(sl);
		return this;
	}
	
	public BuildButton shellDefault() {
		ref.getShell().setDefaultButton(ref);
		return this;
	}
	
	@Override
	protected BuildButton self() { return this; }
}
