/* ©2016-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.viz.gui.swt.dialog;

import java.util.function.Consumer;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

import com.elderresearch.viz.gui.swt.controls.builders.SWTBuilders;
import com.elderresearch.viz.gui.swt.util.SWTUtilities;

import lombok.Setter;
import lombok.val;

/**
 * A {@code CMessageBox} is a custom {@link MessageBox} that allows the user
 * to answer the question asked by this dialog only once.  This dialog is always
 * a Yes/No/Cancel dialog, but it can have any of the dialog box icons.  It
 * also includes a check box allowing the user to set if the program should
 * continue to prompt this question in the future.  Respecting this option is the
 * responsibility of the programmer.
 * @author John Dimeo
 */
public class CMessageBox implements SWTBuilders {
	private static final int ICON_MASK = SWT.ICON_ERROR | SWT.ICON_INFORMATION | SWT.ICON_QUESTION | SWT.ICON_WARNING | SWT.ICON_WORKING;
	
	private Shell parent;
	private int style;
	
	/**
	 * Sets the receiver's text, which is the string that the window manager
	 * will typically display as the receiver's title, to the argument, which
	 * must not be {@code null}.
	 */
	@Setter private String text;
	
	/**
	 * Sets the dialog's message, which is a description of the purpose
	 * for which it was opened. This message will be visible on the dialog
	 * while it is open.
	 */
	@Setter private String message;
	
	private int answer = SWT.CANCEL;
	
	/**
	 * Creates a new custom message box, with Yes/No/Cancel buttons and the icon
	 * specified by {@code style}.
	 * @param parent the shell on which to create the dialog
	 * @param style the icon of the dialog
	 * @see SWT#ICON_ERROR
	 * @see SWT#ICON_INFORMATION
	 * @see SWT#ICON_QUESTION
	 * @see SWT#ICON_WARNING
	 * @see SWT#ICON_WORKING
	 */
	public CMessageBox(Shell parent, int style) {
		this.parent = parent;
		this.style = style;
	}
	
	/**
	 * Makes the dialog visible and brings it to the front of the display.
	 * @return the ID of the button that was selected to dismiss the message
	 * box ({@link SWT#YES}, {@link SWT#NO}, or {@link SWT#CANCEL}).  If the
	 * user indicated this question should not be asked again, {@link SWT#SAVE}
	 * will be bitwise OR'ed with the returned integer.
	 */
	public int open() {
		answer = SWT.CANCEL;
		SWTUtilities.open(dialog(parent).text(text).autoSize().centerInParent().layout(grid(1, 1)).children(s -> {
			// Icon on the left side
			label(s).image(style & ICON_MASK).layoutData(gridData().vAlign(SWT.TOP).vGrab().vSpan(2));
 			
			// Message along the top
	 		label(s).text(message).layoutData(gridData().hFill());
	 		
	 		// Prompt to remember the answer
	 		val store = check(s).text("Ne&ver ask this again.").get();
	 		Consumer<Integer> dismiss = yesOrNo -> {
				answer = yesOrNo;
	 			if (store.getSelection()) { answer |= SWT.SAVE; }
	 			s.dispose();
	 		};
	 		
	 		// Right-aligned row of buttons along bottom
	 		composite(s).layout(grid(1, 1, 1, 1).margin(0)).layoutData(gridData().hFill().hSpan(2)).children(c -> {
	 			label(c).layoutData(gridData().hFill());
	 			
	 			val gd = gridData().button();
	 			button(c).text("&Yes").layoutData(gd).shellDefault().onSelect(e -> dismiss.accept(SWT.YES));
	 			button(c).text("&No").layoutData(gd).onSelect(e -> dismiss.accept(SWT.NO));
	 			button(c, SWT.CANCEL).text("Cancel").layoutData(gd).onSelect(e -> s.dispose());
	 		});
		}).get());
	 	return answer;
	}
}
