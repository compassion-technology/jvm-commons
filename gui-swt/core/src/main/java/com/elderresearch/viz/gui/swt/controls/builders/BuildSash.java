/* ©2017-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.viz.gui.swt.controls.builders;

import org.eclipse.swt.custom.SashForm;

public class BuildSash extends BuildParent<SashForm, BuildSash> {
	protected BuildSash(SashForm s) {
		super(s);
	}
	
	public BuildSash sashWidth(int w) {
		ref.setSashWidth(w);
		return this;
	}
	
	public BuildSash weights(int... weights) {
		ref.setWeights(weights);
		return this;
	}
	
	@Override
	protected BuildSash self() { return this; }
}
