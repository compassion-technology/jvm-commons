package com.compassion.commons.gui.swt.controls.builders;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Item;

public abstract class BuildItem<I extends Item, B extends BuildWidget<I, B>> extends BuildWidget<I, B> implements IBuildImage<B>, IBuildText<B> {
	protected BuildItem(I i) {
		super(i);
	}
	
	@Override
	public B text(String text) {
		ref.setText(text);
		return self();
	}
	
	@Override
	public B image(int image) {
		return image(ref.getDisplay().getSystemImage(image));
	}
	
	@Override
	public B image(Image image) {
		ref.setImage(image);
		return self();
	}
}
