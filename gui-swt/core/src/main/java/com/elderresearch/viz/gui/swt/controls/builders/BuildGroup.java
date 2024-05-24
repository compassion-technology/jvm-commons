/* ©2017-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.viz.gui.swt.controls.builders;

import org.eclipse.swt.widgets.Group;

public class BuildGroup extends BuildParent<Group, BuildGroup> implements IBuildText<BuildGroup> {
	protected BuildGroup(Group g) {
		super(g);
	}
	
	@Override
	public BuildGroup text(String text) {
		ref.setText(text);
		return this;
	}

	@Override
	protected BuildGroup self() { return this; }
}
