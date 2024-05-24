/* ©2017-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.viz.gui.swt.controls.builders;

import org.eclipse.swt.custom.StackLayout;

public class BuildLayoutStack extends BuildLayout<StackLayout> implements IBuildMargins<BuildLayoutStack> {
	protected BuildLayoutStack() {
		super(new StackLayout());
	}
	
	@Override
	public BuildLayoutStack hMargin(int width) {
		ref.marginWidth = width;
		return this;
	}
	
	@Override
	public BuildLayoutStack vMargin(int height) {
		ref.marginHeight = height;
		return this;
	}
}
