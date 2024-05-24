/* ©2016-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.viz.gui.swt.controls;

import org.eclipse.swt.SWTException;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Text;

import com.elderresearch.viz.gui.swt.controls.builders.SWTBuilders;


public class LabeledTextBox extends Composite implements SWTBuilders {
	private GridLayout layout;
	private Label label;
	private GridData labelData;
	private Text text;
	
	public LabeledTextBox(Composite parent, int style, int labelStyle, int textStyle) {
		super(parent, style);
		layout = grid(1, 1).margin(0).get();
		super.setLayout(layout);
		
		label = new Label(this, labelStyle);
		labelData = new GridData();
		label.setLayoutData(labelData);
		
		text = text(this, textStyle).layoutData(gridData().hFill()).get();
	}
	
	/**
	 * Sets the receiver's text.
	 * <p>
	 * This method sets the widget label.  The label may include
	 * the mnemonic character and line delimiters.
	 * </p>
	 * <p>
	 * Mnemonics are indicated by an '&amp;' that causes the next
	 * character to be the mnemonic.  When the user presses a
	 * key sequence that matches the mnemonic, focus is assigned
	 * to the control that follows the label. On most platforms,
	 * the mnemonic appears underlined but may be emphasized in a
	 * platform specific manner.  The mnemonic indicator character
	 * '&amp;' can be escaped by doubling it in the string, causing
	 * a single '&amp;' to be displayed.
	 * </p>
	 * 
	 * @param string the new text
	 *
	 * @exception IllegalArgumentException <ul>
	 *    <li>ERROR_NULL_ARGUMENT - if the text is null</li>
	 * </ul>
	 * @exception SWTException <ul>
	 *    <li>ERROR_WIDGET_DISPOSED - if the receiver has been disposed</li>
	 *    <li>ERROR_THREAD_INVALID_ACCESS - if not called from the thread that created the receiver</li>
	 * </ul>
	 */
	public void setLabelText(String string) {
		label.setText(string);
	}
	
	/**
	 * Sets the contents of the receiver to the given string. If the receiver has style
	 * SINGLE and the argument contains multiple lines of text, the result of this
	 * operation is undefined and may vary from platform to platform.
	 *
	 * @param string the new text
	 *
	 * @exception IllegalArgumentException <ul>
	 *    <li>ERROR_NULL_ARGUMENT - if the string is null</li>
	 * </ul>
	 * @exception SWTException <ul>
	 *    <li>ERROR_WIDGET_DISPOSED - if the receiver has been disposed</li>
	 *    <li>ERROR_THREAD_INVALID_ACCESS - if not called from the thread that created the receiver</li>
	 * </ul>
	 */
	public void setTextText(String string) {
		text.setText(string);
	}
	
	/**
	 * Returns the widget text.
	 * <p>
	 * The text for a text widget is the characters in the widget, or
	 * an empty string if this has never been set.
	 * </p>
	 *
	 * @return the widget text
	 *
	 * @exception SWTException <ul>
	 *    <li>ERROR_WIDGET_DISPOSED - if the receiver has been disposed</li>
	 *    <li>ERROR_THREAD_INVALID_ACCESS - if not called from the thread that created the receiver</li>
	 * </ul>
	 */
	public String getText() {
		return text.getText();
	}
	
	/**
	 * Sets the width hint for the label widget.
	 * @param width the label's width hint
	 */
	public void setLabelWidth(int width) {
		labelData.widthHint = width;
		layout(true);
	}
	
	/**
	 * Sets the gap between the label and the text widgets.
	 * @param gap the label-text gap
	 */
	public void setLabelTextGap(int gap) {
		layout.horizontalSpacing = gap;
		layout(true);
	}
	
	/**
	 * Adds the listener to the collection of listeners who will
	 * be notified when the control is selected by the user, by sending
	 * it one of the messages defined in the <code>SelectionListener</code>
	 * interface.
	 * <p>
	 * <code>widgetSelected</code> is not called for texts.
	 * <code>widgetDefaultSelected</code> is typically called when ENTER is pressed in a single-line text,
	 * or when ENTER is pressed in a search text. If the receiver has the <code>SWT.SEARCH | SWT.CANCEL</code> style
	 * and the user cancels the search, the event object detail field contains the value <code>SWT.CANCEL</code>.
	 * </p>
	 *
	 * @param listener the listener which should be notified when the control is selected by the user
	 *
	 * @exception IllegalArgumentException <ul>
	 *    <li>ERROR_NULL_ARGUMENT - if the listener is null</li>
	 * </ul>
	 * @exception SWTException <ul>
	 *    <li>ERROR_WIDGET_DISPOSED - if the receiver has been disposed</li>
	 *    <li>ERROR_THREAD_INVALID_ACCESS - if not called from the thread that created the receiver</li>
	 * </ul>
	 *
	 * @see SelectionListener
	 * @see #removeSelectionListener
	 * @see SelectionEvent
	 */
	public void addSelectionListener(SelectionListener listener) {
		text.addSelectionListener(listener);
	}
	
	/**
	 * Removes the listener from the collection of listeners who will
	 * be notified when the control is selected by the user.
	 *
	 * @param listener the listener which should no longer be notified
	 *
	 * @exception IllegalArgumentException <ul>
	 *    <li>ERROR_NULL_ARGUMENT - if the listener is null</li>
	 * </ul>
	 * @exception SWTException <ul>
	 *    <li>ERROR_WIDGET_DISPOSED - if the receiver has been disposed</li>
	 *    <li>ERROR_THREAD_INVALID_ACCESS - if not called from the thread that created the receiver</li>
	 * </ul>
	 *
	 * @see SelectionListener
	 * @see #addSelectionListener
	 */
	public void removeSelectionListener(SelectionListener listener) {
		text.removeSelectionListener(listener);
	}
	
	@Override
	public void setLayout(Layout layout) {
		throw new RuntimeException("This composite's layout cannot be changed.");
	}
	
	@Override
	public void setBackground(Color color) {
		super.setBackground(color);
		label.setBackground(color);
		text.setBackground(color);
	}
}
