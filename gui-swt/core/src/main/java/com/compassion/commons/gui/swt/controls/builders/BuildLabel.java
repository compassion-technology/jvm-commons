package com.compassion.commons.gui.swt.controls.builders;

import org.eclipse.swt.widgets.Label;

public class BuildLabel extends BuildControlWithImage<Label, BuildLabel> {
	protected BuildLabel(Label c) {
		super(c, Label::setText, Label::setAlignment, Label::setImage);
	}
	
	@Override
	protected BuildLabel self() { return this; }
}
