/* ©2017-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.viz.gui.swt.controls.builders;

import org.eclipse.swt.layout.RowLayout;

import com.elderresearch.viz.gui.swt.controls.builders.IBuildMargins.IBuildMarginsAsymmetric;

public class BuildLayoutRows extends BuildLayout<RowLayout> implements
		IBuildMarginsAsymmetric<BuildLayoutRows>, IBuildSpacing<BuildLayoutRows> {
	protected BuildLayoutRows(int type) {
		super(new RowLayout(type));
	}

	@Override
	public BuildLayoutRows hMargin(int width) {
		ref.marginWidth = width;
		return this;
	}
	
	@Override
	public BuildLayoutRows vMargin(int height) {
		ref.marginHeight = height;
		return this;
	}
	
	@Override
	public BuildLayoutRows hMargin(int left, int right) {
		ref.marginLeft = left;
		ref.marginRight = right;
		return this;
	}
	
	@Override
	public BuildLayoutRows vMargin(int top, int bottom) {
		ref.marginTop = top;
		ref.marginBottom = bottom;
		return this;
	}
	
	@Override
	public BuildLayoutRows spacing(int spacing) {
		ref.spacing = spacing;
		return this;
	}
	
	public BuildLayoutRows wrap(boolean wrap) {
		ref.wrap = wrap;
		return this;
	}
	
	public BuildLayoutRows pack(boolean pack) {
		ref.pack = pack;
		return this;
	}
	
	public BuildLayoutRows fill(boolean fill) {
		ref.fill = fill;
		return this;
	}
	
	public BuildLayoutRows justify(boolean justify) {
		ref.justify = justify;
		return this;
	}
	
	public BuildLayoutRows center(boolean center) {
		ref.center = center;
		return this;
	}
}
