/* ©2017-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.viz.gui.swt.controls.builders;

import java.util.function.Supplier;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;

import com.compassion.commons.LambdaUtils;
import com.elderresearch.viz.gui.UIAction;
import com.elderresearch.viz.gui.swt.events.FocusGainedLambda;
import com.elderresearch.viz.gui.swt.events.KeyPressedLambda;
import com.elderresearch.viz.gui.swt.events.MouseDownLambda;
import com.elderresearch.viz.gui.swt.events.ResizeLambda;
import com.elderresearch.viz.gui.swt.util.ResourceManager;

import lombok.val;

public abstract class BuildControl<C extends Control, B extends BuildControl<C, B>> extends BuildWidget<C, B>
		implements IEnabled<B>, IVisible<B> {
	protected BuildControl(C c) {
		super(c);
	}

	public B colorFore(Color c) {
		ref.setForeground(c);
		return self();
	}

	public B colorBack(Color c) {
		ref.setBackground(c);
		return self();
	}

	public B colorFore(int systemColor) {
		return colorFore(ref.getDisplay().getSystemColor(systemColor));
	}

	public B colorBack(int systemColor) {
		return colorBack(ref.getDisplay().getSystemColor(systemColor));
	}

	public B colorsParent() {
		val parent = ref.getParent();
		ref.setForeground(parent.getForeground());
		ref.setBackground(parent.getBackground());
		return self();
	}

	public B colorsDefault() {
		ref.setForeground(ref.getDisplay().getSystemColor(SWT.COLOR_WIDGET_FOREGROUND));
		ref.setBackground(ref.getDisplay().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
		return self();
	}

	public B colorsInput() {
		ref.setForeground(ref.getDisplay().getSystemColor(SWT.COLOR_LIST_FOREGROUND));
		ref.setBackground(ref.getDisplay().getSystemColor(SWT.COLOR_LIST_BACKGROUND));
		return self();
	}

	public B cursor(int cursor) {
		ref.setCursor(ref.getDisplay().getSystemCursor(cursor));
		return self();
	}

	public B fontParent() {
		return font(ref.getParent().getFont());
	}

	public B font(Font f) {
		ref.setFont(f);
		return self();
	}

	public B tooltip(String text) {
		ref.setToolTipText(text);
		return self();
	}

	public B onKey(KeyPressedLambda kl) {
		ref.addKeyListener(kl);
		return self();
	}

	public B onPaint(PaintListener pl) {
		ref.addPaintListener(pl);
		return self();
	}

	public B onMouseDown(MouseDownLambda ml) {
		ref.addMouseListener(ml);
		return self();
	}

	public B onMouseMove(MouseMoveListener ml) {
		ref.addMouseMoveListener(ml);
		return self();
	}

	public B onFocus(FocusGainedLambda fl) {
		ref.addFocusListener(fl);
		return self();
	}

	public B onResize(ResizeLambda rl) {
		ref.addControlListener(rl);
		return self();
	}

	@Override
	public B enabled(boolean enabled) {
		ref.setEnabled(enabled);
		return self();
	}

	@Override
	public B visible(boolean visible) {
		ref.setVisible(visible);
		return self();
	}

	public B layoutData(Supplier<?> layoutData) {
		ref.setLayoutData(LambdaUtils.get(layoutData));
		return self();
	}

	@Override
	public B action(UIAction action, ResourceManager rm) {
		LambdaUtils.accept(action.getDescription(), this::tooltip);
		return super.action(action, rm);
	}

	public B menu(Menu menu) {
		ref.setMenu(menu);
		return self();
	}
}
