/* ©2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.viz.gui.swt.controls.builders;

import org.apache.commons.lang3.mutable.MutableInt;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

import com.elderresearch.viz.gui.swt.util.SWTUtilities;

import lombok.Setter;
import lombok.val;
import lombok.experimental.Accessors;

@Accessors(chain = true, fluent = true)
public class BuildMessageBox implements IBuildText<BuildMessageBox> {
	private Shell parent;
	private int style;
	private String message;
	
	@Setter
	private String text;
	
	@Setter
	private Runnable ifAccepted, ifDeclined;
	
	protected BuildMessageBox(Shell parent, int style) {
		this.parent = parent;
		this.style = style;
	}
	
	public BuildMessageBox message(String format, Object... args) {
		this.message = String.format(format, args);
		return this;
	}
	
	public int open() {
		// Joins UI thread and blocks until open() returns
		val ret = new MutableInt();
		SWTUtilities.run(parent.getDisplay(), () -> {
			val mb = new MessageBox(parent, style);
			mb.setText(text);
			mb.setMessage(message);
			ret.setValue(mb.open());

			// Run any post-processing steps while still on the UI thread
			if (isAccepted(ret.intValue()) && ifAccepted != null) { ifAccepted.run(); }
			if (isDeclined(ret.intValue()) && ifDeclined != null) { ifDeclined.run(); }
			
		}, SWTUtilities.BLOCKING, parent);
		return 	ret.intValue();
	}
	
	public boolean accepted() { return isAccepted(open()); }
	public boolean declined() { return isDeclined(open()); }
	
	protected boolean isAccepted(int response) { return response == SWT.YES || response == SWT.OK; }
	protected boolean isDeclined(int response) { return response == SWT.NO || response == SWT.CANCEL; }
}
