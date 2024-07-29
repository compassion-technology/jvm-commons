package com.compassion.commons.gui.swt.controls.builders;

import java.util.function.Consumer;

import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

import com.compassion.commons.gui.swt.events.SelectionLambda;

public class BuildMenu extends BuildWidget<Menu, BuildMenu> {

	protected BuildMenu(Menu ref) {
		super(ref);
	}
	
	public BuildMenu items(Consumer<Menu> callback) {
		callback.accept(ref);
		return this;
	}
	
	@Override
	protected BuildMenu self() { return this; }
	
	public static class BuildMenuItem extends BuildItem<MenuItem, BuildMenuItem> implements IEnabled<BuildMenuItem> {
		protected BuildMenuItem(MenuItem i) {
			super(i);
		}
		
		public BuildMenuItem select() {
			ref.setSelection(true);
			return this;
		}
		
		public BuildMenuItem tooltip(String tooltip) {
			ref.setToolTipText(tooltip);
			return this;
		}
		
		@Override
		public BuildMenuItem enabled(boolean enabled) {
			ref.setEnabled(enabled);
			return this;
		}
		
		public BuildMenuItem onSelect(SelectionLambda l) {
			ref.addSelectionListener(l);
			return this;
		}

		@Override
		protected BuildMenuItem self() { return this; }
	}
}
