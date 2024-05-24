/* ©2017-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.viz.gui.swt.controls.builders;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

import org.eclipse.swt.widgets.Layout;

public abstract class BuildLayout<L extends Layout> implements Supplier<L> {
	protected L ref;
	
	protected BuildLayout(L layout) {
		ref = layout;
	}
	
	public <T> BuildLayout<L> with(T param, BiConsumer<L, T> callback) {
		callback.accept(ref, param);
		return this;
	}
	
	@Override
	public L get() {
		return ref;
	}
}
