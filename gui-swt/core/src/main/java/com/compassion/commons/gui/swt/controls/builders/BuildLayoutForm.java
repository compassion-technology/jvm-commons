package com.compassion.commons.gui.swt.controls.builders;

import org.eclipse.swt.layout.FormLayout;

import com.compassion.commons.gui.swt.controls.builders.IBuildMargins.IBuildMarginsAsymmetric;

public class BuildLayoutForm extends BuildLayout<FormLayout> implements
		IBuildMarginsAsymmetric<BuildLayoutForm>, IBuildSpacing<BuildLayoutForm> {
	protected BuildLayoutForm() {
		super(new FormLayout());
	}
	
	@Override
	public BuildLayoutForm hMargin(int width) {
		ref.marginWidth = width;
		return this;
	}
	
	@Override
	public BuildLayoutForm vMargin(int height) {
		ref.marginHeight = height;
		return this;
	}
	
	@Override
	public BuildLayoutForm hMargin(int left, int right) {
		ref.marginLeft = left;
		ref.marginRight = right;
		return this;
	}
	
	@Override
	public BuildLayoutForm vMargin(int top, int bottom) {
		ref.marginTop = top;
		ref.marginBottom = bottom;
		return this;
	}
	
	@Override
	public BuildLayoutForm spacing(int spacing) {
		ref.spacing = spacing;
		return this;
	}
}
