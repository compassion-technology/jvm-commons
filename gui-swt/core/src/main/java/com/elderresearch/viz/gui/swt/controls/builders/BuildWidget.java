/* ©2017-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.viz.gui.swt.controls.builders;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Widget;

import com.elderresearch.viz.gui.UIAction;
import com.elderresearch.viz.gui.swt.util.ResourceManager;

public abstract class BuildWidget<W extends Widget, B extends BuildWidget<W, B>> implements Supplier<W> {
	protected W ref;
	
	protected BuildWidget(W ref) {
		this.ref = ref;
	}
	
	public <T> B with(T param, BiConsumer<W, T> callback) {
		callback.accept(ref, param);
		return self();
	}
	
	public B onDispose(DisposeListener dl) {
		ref.addDisposeListener(dl);
		return self();
	}
	
	public B data(Object userData) {
		ref.setData(userData);
		return self();
	}
	
	public B data(String key, Object userData) {
		ref.setData(key, userData);
		return self();
	}
	
	public B action(UIAction action, ResourceManager rm) {
		return data(action);
	}
	
	@Override
	public W get() {
		return ref;
	}
	
	protected abstract B self();
}
