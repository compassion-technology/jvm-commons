/* ©2017-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.viz.gui.swt.controls.builders;

import java.util.function.BiConsumer;

import org.eclipse.swt.widgets.Control;

import com.elderresearch.viz.gui.UIAction;
import com.elderresearch.viz.gui.swt.util.ResourceManager;

public abstract class BuildControlWithText<C extends Control, B extends BuildControl<C, B>> extends BuildControl<C, B>
		implements IBuildText<B> {
	private BiConsumer<C, String> setText;
	
	protected BuildControlWithText(C c, BiConsumer<C, String> setText) {
		super(c);
		this.setText = setText;
	}
	
	@Override
	public B action(UIAction action, ResourceManager rm) {
		String text = action.getName();
		if (action.isMoreInputNeeded()) { text += "..."; }
		text(text);
		return super.action(action, rm);
	}
	
	@Override
	public B text(String text) {
		with(text, setText);
		return self();
	}
}
