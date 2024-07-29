package com.compassion.commons.gui.swt.controls.builders;

import java.util.function.BiConsumer;

import org.eclipse.swt.widgets.Control;

public abstract class BuildControlWithTextAlign<C extends Control, B extends BuildControlWithTextAlign<C, B>>
		extends BuildControlWithText<C, B> {
	private BiConsumer<C, Integer> setAlign;
	
	protected BuildControlWithTextAlign(C c, BiConsumer<C, String> setText, BiConsumer<C, Integer> setAlign) {
		super(c, setText);
		this.setAlign = setAlign;
	}
	
	public B align(int align) {
		with(align, setAlign);
		return self();
	}
}
