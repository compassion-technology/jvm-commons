/* ©2017-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.viz.gui.swt.controls.builders;

public interface IBuildMargins<B> {
	B hMargin(int width);
	B vMargin(int height);
	
	default B margin(int margin) {
		hMargin(margin);
		return vMargin(margin);
	}
	
	interface IBuildMarginsAsymmetric<B> extends IBuildMargins<B> {
		B hMargin(int left, int right);
		B vMargin(int top, int bottom);
		
		@Override
		default B hMargin(int width) {
			return hMargin(width, width);
		}
		
		@Override
		default B vMargin(int height) {
			return vMargin(height, height);
		}
	}
}
