/* ©2016-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.viz.gui.swt.controls;

import java.util.function.Consumer;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;

import com.elderresearch.viz.gui.swt.events.SelectionLambda;
import com.elderresearch.viz.gui.swt.util.SWTUtilities;

/**
 * This class wraps an SWT {@link Combo} widget and invokes a listener when the
 * user types a help topic. The combo will maintain a historical list of keywords
 * the user has entered, and display a custom prompt inside the combo.
 * 
 * @author <a href="dimeo@datamininglab.com">John Dimeo</a>
 * @since Jun 28, 2013
 */
public class QuickHelpCombo implements SelectionLambda {
	private Combo c;
	private Consumer<String> listener;
	
	/**
	 * Creates a new help combo.
	 * @param parent the parent composite
	 * @param style the combo style
	 * @param listener the listener to be notified when the user types a new
	 * keyword and hits the enter key
	 */
	public QuickHelpCombo(Composite parent, int style, Consumer<String> listener) {
		this (parent, style, "Type a keyword for help", listener);
	}

	/**
	 * Creates a new help combo.
	 * @param parent the parent composite
	 * @param style the combo style
	 * @param prompt the prompt to show in the combo box until the user types something
	 * @param listener the listener to be notified when the user types a new
	 * keyword and hits the enter key
	 */
	public QuickHelpCombo(Composite parent, int style, Object prompt, Consumer<String> listener) {
		this.listener = listener;
		
		c = new Combo(parent, style);
		SWTUtilities.addReplacePromptListener(c, prompt);
		SWTUtilities.addAutoCompleteListeners(c);
		c.addSelectionListener(this);
	}
	
	/**
	 * Access the underlying combo box to set layout data, etc.
	 * @return the combo widget
	 */
	public Combo getWidget() {
		return c;
	}
	
	@Override
	public void widgetSelected(SelectionEvent e) {
		String s = c.getText();
		SWTUtilities.uniqueAdd(c, s);
		listener.accept(s);
	}
}
