/* ©2017-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.viz.gui.swt.controls.builders;

import org.eclipse.swt.graphics.Image;

public interface IBuildImage<B> {
	B image(int image);
	B image(Image image);
}
