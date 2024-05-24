/* ©2017-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.viz.gui.swt.controls.builders;

import org.eclipse.swt.layout.FillLayout;

public class BuildLayoutFill extends BuildLayout<FillLayout> implements IBuildMargins<BuildLayoutFill>, IBuildSpacing<BuildLayoutFill> {
	protected BuildLayoutFill(int type) {
		super(new FillLayout(type));
	}
	
	@Override
	public BuildLayoutFill hMargin(int width) {
		ref.marginWidth = width;
		return this;
	}
	
	@Override
	public BuildLayoutFill vMargin(int height) {
		ref.marginHeight = height;
		return this;
	}
	
	@Override
	public BuildLayoutFill spacing(int spacing) {
		ref.spacing = spacing; 
		return this;
	}
}
