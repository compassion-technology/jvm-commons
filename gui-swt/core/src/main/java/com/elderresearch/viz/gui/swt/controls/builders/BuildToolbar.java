/* ©2017-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.viz.gui.swt.controls.builders;

import java.util.function.Consumer;

import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

import com.elderresearch.viz.gui.swt.events.SelectionLambda;

public class BuildToolbar extends BuildControl<ToolBar, BuildToolbar> {
	protected BuildToolbar(ToolBar t) {
		super(t);
	}
	
	public BuildToolbar items(Consumer<ToolBar> callback) {
		callback.accept(ref);
		return this;
	}
	
	@Override
	protected BuildToolbar self() { return this; }
	
	public static class BuildToolbarItem extends BuildItem<ToolItem, BuildToolbarItem> implements IEnabled<BuildToolbarItem> {
		protected BuildToolbarItem(ToolItem i) {
			super(i);
		}
		
		public BuildToolbarItem separatorContent(Control c) {
			ref.setControl(c);
			return this;
		}
		
		public BuildToolbarItem separatorWidth(int width) {
			ref.setWidth(width);
			return this;
		}
		
		public BuildToolbarItem select() {
			ref.setSelection(true);
			return this;
		}
		
		public BuildToolbarItem tooltip(String tooltip) {
			ref.setToolTipText(tooltip);
			return this;
		}
		
		@Override
		public BuildToolbarItem enabled(boolean enabled) {
			ref.setEnabled(enabled);
			return this;
		}
		
		public BuildToolbarItem onSelect(SelectionLambda l) {
			ref.addSelectionListener(l);
			return this;
		}

		@Override
		protected BuildToolbarItem self() { return this; }
	}
}
