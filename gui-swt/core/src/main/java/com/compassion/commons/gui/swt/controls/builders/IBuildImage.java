package com.compassion.commons.gui.swt.controls.builders;

import org.eclipse.swt.graphics.Image;

public interface IBuildImage<B> {
	B image(int image);
	B image(Image image);
}
