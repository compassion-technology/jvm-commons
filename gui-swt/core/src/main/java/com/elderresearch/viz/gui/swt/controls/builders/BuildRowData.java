/* ©2016-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.viz.gui.swt.controls.builders;

import java.util.function.Supplier;

import org.eclipse.swt.layout.RowData;

public class BuildRowData implements Supplier<RowData> {
	private RowData rd;
	
	protected BuildRowData() {
		rd = new RowData();
	}
	
	public BuildRowData exclude() {
		rd.exclude = true;
		return this;
	}
	
	public BuildRowData include() {
		rd.exclude = false;
		return this;
	}
	
	public BuildRowData exclude(boolean exclude) {
		rd.exclude = exclude;
		return this;
	}
	
	public BuildRowData width(int width) {
		rd.width = width;
		return this;
	}
	
	public BuildRowData height(int height) {
		rd.height = height;
		return this;
	}
	
	@Override
	public RowData get() {
		// Copy to new instance so the builder can be reused
		RowData ret = new RowData(rd.width, rd.height);
		ret.exclude = rd.exclude;
		return ret;
	}
	
	public BuildRowData size(int w, int h) {
		return width(w).height(h);
	}
	
	public BuildRowData button() {
		return width(BuildGridData.DEFAULT_BUTTON_WIDTH);
	}
}
