package com.compassion.commons.gui.swt.controls.builders;

import java.util.function.BiConsumer;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Control;

import com.compassion.commons.LambdaUtils;
import com.compassion.commons.gui.UIAction;
import com.compassion.commons.gui.swt.util.ResourceManager;

public abstract class BuildControlWithImage<C extends Control, B extends BuildControlWithImage<C, B>>
		extends BuildControlWithTextAlign<C, B> implements IBuildImage<B> {
	private BiConsumer<C, Image> setImage;

	protected BuildControlWithImage(C c,
			BiConsumer<C, String> setText,
			BiConsumer<C, Integer> setAlign,
			BiConsumer<C, Image> setImage) {
		super(c, setText, setAlign);
		this.setImage = setImage;
	}

	@Override
	public B action(UIAction action, ResourceManager rm) {
		image(LambdaUtils.apply(action.getImage(), rm::getImage));
		return super.action(action, rm);
	}

	@Override
	public B image(int image) {
		return image(ref.getDisplay().getSystemImage(image));
	}

	@Override
	public B image(Image image) {
		with(image, setImage);
		return self();
	}
}
