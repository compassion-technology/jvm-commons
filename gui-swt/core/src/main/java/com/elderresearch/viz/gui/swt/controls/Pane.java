/* ©2016-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.viz.gui.swt.controls;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import com.compassion.commons.Utilities;

/**
 * Panes populate a {@link TaskPane}.  Implementers of this class
 * must implement the {@link #fillPane(Composite)} method to fill
 * the pane with widgets.  The following example adds a task pane
 * to a {@code SashForm}, which is recommended to allow the user to
 * dynamically adjust the size of the task pane:<br><pre>
 * TaskPane pane = new TaskPane(rm, sashForm, SWT.BORDER, new MouseAdapter() {
 *    public void mouseDown(MouseEvent e) {
 *       sashForm.setWeights(new int[] {100, 0});
 *    }
 * });
 * pane.addPane(new {@link #Pane(String, int) Pane}("Common Tasks", SWT.HOME) {
 *    public void {@link #fillPane(Composite) fillPane}(Composite parent) {
 *       parent.setLayout(new RowLayout(SWT.VERTICAL));
 *       Label l = new Label(parent, SWT.NONE);
 *       l.setText("Open File");
 *       Button b = new Button(parent, SWT.PUSH);
 *       ...
 *    }
 * });
 * </pre>
 * @author John Dimeo
 *
 */
public abstract class Pane implements Comparable<Pane> {
	private static int instances;
	private int id, style;
	private String name;

	/**
	 * Creates a new pane with the specified name.
	 * @param name the name for the pane. This is the header displayed
	 * at the top of the task pane when this pane is visible.
	 * @param style supports only one style flag, {@link SWT#HOME}, which indicates this pane is the "home" pane.
	 * The home pane is set as the default visible pane when and when the "home" tool bar button is pressed.
	 */
	public Pane(String name, int style) {
		this.name = name;
		this.style = style;
		id = instances++;
	}

	/**
	 * Gets this pane's name.
	 * @return the name for the pane. This is the header displayed
	 * at the top of the task pane when this pane is visible.
	 */
	public String getName() { return name; }

	boolean isHome() { return Utilities.isOn(style, SWT.HOME); }

	/**
	 * Specifies the content of the pane. You should specify {@code parent}
	 * or a child of {@code parent} as the parent of all widgets you wish
	 * to display on this pane.
	 * @param parent the parent composite to fill
	 */
	public abstract void fillPane(Composite parent);

	@Override
	public int compareTo(Pane o) {
		return id < o.id? -1 : (id > o.id? 1 : 0);
	}
}
