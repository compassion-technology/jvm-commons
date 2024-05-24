/* ©2017-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.viz.gui.swt.controls.builders;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;

import com.elderresearch.viz.gui.swt.events.ShellClosedLambda;
import com.elderresearch.viz.gui.swt.util.SWTUtilities;

public class BuildShell extends BuildParent<Shell, BuildShell> implements IBuildText<BuildShell>, IBuildImage<BuildShell> {
	private boolean autoSize, centerScreen, centerParent;
	
	protected BuildShell(Shell s) {
		super(s);
	}
	
	@Override
	public BuildShell text(String text) {
		ref.setText(text);
		return this;
	}
	
	@Override
	public BuildShell image(int image) {
		return image(ref.getDisplay().getSystemImage(image));
	}
	
	@Override
	public BuildShell image(Image image) {
		ref.setImage(image);
		return this;
	}
	
	public BuildShell icons(Image... images) {
		ref.setImages(images);
		return this;
	}
	
	public BuildShell fullScreen() {
		ref.setFullScreen(true);
		return this;
	}
	
	public BuildShell maximized() {
		ref.setMaximized(true);
		return this;
	}
	
	public BuildShell minimized() {
		ref.setMinimized(true);
		return this;
	}
	
	public BuildShell active() {
		ref.setActive();
		return this;
	}
	
	public BuildShell menuBar(Menu menu) {
		ref.setMenuBar(menu);
		return this;
	}
	
	public BuildShell size(int w, int h) {
		ref.setSize(w, h);
		return this;
	}
	
	public BuildShell location(int x, int y) {
		ref.setLocation(x, y);
		return this;
	}
	
	public BuildShell autoSize() {
		autoSize = true;
		ref.pack();
		return this;
	}
	
	public BuildShell centerInScreen() {
		centerScreen = true;
		centerParent = false;
		SWTUtilities.centerShell(ref);
		return this;
	}
	
	public BuildShell centerInParent() {
		centerParent = true;
		centerScreen = false;
		SWTUtilities.centerShell(ref, ref.getParent());
		return this;
	}
	
	public BuildShell onClose(ShellClosedLambda sl) {
		ref.addShellListener(sl);
		return this;
	}
	
	@Override
	public Shell get() {
		// Pack and center again now that presumably all children have been initialized
		if (autoSize)     { ref.pack(); }
		if (centerScreen) { SWTUtilities.centerShell(ref); }
		if (centerParent) { SWTUtilities.centerShell(ref, ref.getParent()); }
		return super.get();
	}

	@Override
	protected BuildShell self() { return this; }
}
