package com.compassion.commons.gui.swt.controls.builders;

import java.util.function.Consumer;
import java.util.function.Supplier;

import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Layout;

public abstract class BuildParent<C extends Composite, B extends BuildParent<C, B>> extends BuildControl<C, B> {
	protected BuildParent(C c) {
		super(c);
	}

	public B layout(Supplier<? extends Layout> layout) {
		ref.setLayout(layout.get());
		return self();
	}
	
	public B children(Consumer<Composite> callback) {
		callback.accept(ref);
		return self();
	}
	
	public static class BuildComposite extends BuildParent<Composite, BuildComposite> {
		protected BuildComposite(Composite c) {
			super(c);
		}
		
		@Override
		protected BuildComposite self() {
			return this;
		}
	}
	
	public static class BuildCanvas extends BuildParent<Canvas, BuildCanvas> {
		protected BuildCanvas(Canvas c) {
			super(c);
		}
		
		@Override
		protected BuildCanvas self() {
			return this;
		}
	}
}
