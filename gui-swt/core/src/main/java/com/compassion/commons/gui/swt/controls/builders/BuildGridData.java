package com.compassion.commons.gui.swt.controls.builders;

import java.util.function.Supplier;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;

public class BuildGridData implements Supplier<GridData> {
	/** The standard width of buttons (in pixels) on Windows dialogs. This prevents
	 *  buttons with short text (like "OK") from being too narrow. */
	public static final int DEFAULT_BUTTON_WIDTH = 72;
	
	private GridData gd;
	
	protected BuildGridData() {
		gd = new GridData();
	}
	
	public BuildGridData hGrab() {
		gd.grabExcessHorizontalSpace = true;
		return this;
	}
	
	public BuildGridData vGrab() {
		gd.grabExcessVerticalSpace = true;
		return this;
	}
	
	public BuildGridData grab() {
		return hGrab().vGrab();
	}
	
	public BuildGridData hAlign(int align) {
		gd.horizontalAlignment = align;
		return this;
	}
	
	public BuildGridData vAlign(int align) {
		gd.verticalAlignment = align;
		return this;
	}
	
	public BuildGridData align(int align) {
		return hAlign(align).vAlign(align);
	}
	
	public BuildGridData hSpan(int span) {
		gd.horizontalSpan = span;
		return this;
	}
	
	public BuildGridData vSpan(int span) {
		gd.verticalSpan = span;
		return this;
	}
	
	public BuildGridData hIndent(int indent) {
		gd.horizontalIndent = indent;
		return this;
	}
	
	public BuildGridData vIndent(int indent) {
		gd.verticalIndent = indent;
		return this;
	}
	
	public BuildGridData width(int width) {
		gd.widthHint = width;
		return this;
	}
	
	public BuildGridData height(int height) {
		gd.heightHint = height;
		return this;
	}
	
	@Override
	public GridData get() {
		// Copy to new instance so the builder can be reused
		GridData ret = new GridData(gd.horizontalAlignment, gd.verticalAlignment, gd.grabExcessHorizontalSpace, gd.grabExcessVerticalSpace, gd.horizontalSpan, gd.verticalSpan);
		ret.exclude = gd.exclude;
		ret.heightHint = gd.heightHint;
		ret.horizontalIndent = gd.horizontalIndent;
		ret.minimumHeight = gd.minimumHeight;
		ret.minimumWidth = gd.minimumWidth;
		ret.verticalIndent = gd.verticalIndent;
		ret.widthHint = gd.widthHint;
		return ret;
	}
	
	public BuildGridData size(int w, int h) {
		return width(w).height(h);
	}
	
	public BuildGridData fill() {
		return grab().align(SWT.FILL);
	}
	
	public BuildGridData hFill() {
		return hGrab().hAlign(SWT.FILL);
	}
	
	public BuildGridData vFill() {
		return vGrab().vAlign(SWT.FILL);
	}
	
	public BuildGridData button() {
		return width(DEFAULT_BUTTON_WIDTH);
	}
}
