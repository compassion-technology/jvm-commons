/* ©2017-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.viz.gui.swt.controls.builders;

import org.eclipse.swt.layout.GridLayout;

import com.elderresearch.viz.gui.swt.controls.builders.IBuildMargins.IBuildMarginsAsymmetric;
import com.elderresearch.viz.gui.swt.controls.builders.IBuildSpacing.IBuildSpacingAsymmetric;

public class BuildLayoutGrid extends BuildLayout<GridLayout> implements
		IBuildMarginsAsymmetric<BuildLayoutGrid>, IBuildSpacingAsymmetric<BuildLayoutGrid> {
	
	protected BuildLayoutGrid(int cols) {
		super(new GridLayout(cols, false));
	}
	
	@Override
	public BuildLayoutGrid hMargin(int width) {
		ref.marginWidth = width;
		return this;
	}
	
	@Override
	public BuildLayoutGrid vMargin(int height) {
		ref.marginHeight = height;
		return this;
	}
	
	@Override
	public BuildLayoutGrid hMargin(int left, int right) {
		ref.marginLeft = left;
		ref.marginRight = right;
		return this;
	}
	
	@Override
	public BuildLayoutGrid vMargin(int top, int bottom) {
		ref.marginTop = top;
		ref.marginBottom = bottom;
		return this;
	}
	
	@Override
	public BuildLayoutGrid spacing(int h, int v) {
		ref.horizontalSpacing = h;
		ref.verticalSpacing = v;
		return this;
	}
	
	public BuildLayoutGrid colsEqual(boolean colsEqual) {
		ref.makeColumnsEqualWidth = colsEqual;
		return this;
	}
}
