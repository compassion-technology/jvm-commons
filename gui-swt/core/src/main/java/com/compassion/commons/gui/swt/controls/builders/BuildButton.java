package com.compassion.commons.gui.swt.controls.builders;

import org.eclipse.swt.widgets.Button;

import com.compassion.commons.gui.swt.events.SelectionLambda;

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
