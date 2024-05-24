/* ©2017-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.viz.gui.swt.controls.builders;

import java.util.function.Consumer;

import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

import com.elderresearch.viz.gui.swt.events.SelectionLambda;

public class BuildTabs extends BuildControl<TabFolder, BuildTabs> {
	protected BuildTabs(TabFolder t) {
		super(t);
	}
	
	public BuildTabs items(Consumer<TabFolder> callback) {
		callback.accept(ref);
		return this;
	}
	
	public BuildTabs onSelect(SelectionLambda sl) {
		ref.addSelectionListener(sl);
		return this;
	}
	
	@Override
	protected BuildTabs self() { return this; }
	
	public static class BuildTabItem extends BuildItem<TabItem, BuildTabItem> {
		protected BuildTabItem(TabItem i) {
			super(i);
		}
		
		public BuildTabItem content(Control c) {
			ref.setControl(c);
			return this;
		}
		
		public BuildTabItem select() {
			ref.getParent().setSelection(ref);
			return this;
		}
		
		@Override
		protected BuildTabItem self() { return this; }
	}
}
