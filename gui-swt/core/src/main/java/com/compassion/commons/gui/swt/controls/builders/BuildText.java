package com.compassion.commons.gui.swt.controls.builders;

import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Text;

public class BuildText extends BuildControlWithText<Text, BuildText> {
	protected BuildText(Text t) {
		super(t, Text::setText);
	}
	
	public BuildText prompt(String prompt) {
		ref.setMessage(prompt);
		return this;
	}
	
	public BuildText textLimit(int limit) {
		ref.setTextLimit(limit);
		return this;
	}
	
	public BuildText readOnly() {
		ref.setEditable(false);
		return this;
	}
	
	public BuildText onModify(ModifyListener ml) {
		ref.addModifyListener(ml);
		return this;
	}
	
	@Override
	protected BuildText self() { return this; }
}
