/* ©2016-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.viz.gui.swt.dialog;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

import com.compassion.commons.LambdaUtils;
import com.compassion.commons.Utilities;
import com.elderresearch.viz.gui.swt.controls.builders.SWTBuilders;
import com.elderresearch.viz.gui.swt.util.SWTUtilities;

import lombok.val;

/**
 * An input box is a modal dialog that prompts the user for a single string.
 * @author John Dimeo
 */
public class InputBox extends Dialog implements SWTBuilders {
	/** Style bit indicating the input dialog should display a "Browse..." button that opens
	 *  a file dialog that set its text field. */
	public static final int FILE_DIALOG = 1 << 20;

	private String prompt = "";
	private String result;
	private Image icon, image;

	/**
	 * Creates a new input box.
	 * @param parent the shell on which to create the dialog
	 * @param style the style of the inner composite of the dialog
	 */
	public InputBox(Shell parent, int style) {
		super(parent, style);
	}

	/**
	 * Sets the image that appears next to the text in the dialog box.
	 * @param image the dialog's image
	 */
	public void setImage(Image image) {
		this.image = image;
	}

	/**
	 * Sets the icon for the dialog box's shell.
	 * @param icon the dialog's icon
	 */
	public void setIcon(Image icon) {
		this.icon = icon;
	}

	/**
	 * Sets the prompt for the input box, which will appear above the input text box.
	 * @param prompt a string that describes the desired input
	 */
	public void setMessage(String prompt) {
		this.prompt = prompt;
	}

	/**
	 * Opens the input dialog box prompting the user to type a string, and blocks
	 * until the user presses {@code OK} or cancels.
	 * @param initialValue what to set the text field to initially-  can be {@code null}
	 * @return the string the user entered if they pressed {@code OK}, or {@code null}
	 * if they canceled out of the dialog
	 */
	public String open(final String initialValue) {
		val showBrowse = Utilities.isOn(getStyle(), FILE_DIALOG);

		val s = new Shell(getParent(), SWT.APPLICATION_MODAL | SWT.DIALOG_TRIM);
		s.setText(getText());
		s.setImage(icon);
		s.setLayout(grid(1, 1, 1).spacing(10, 5).vMargin(5, 0).get());

		label(s).image(image).layoutData(gridData().hAlign(SWT.CENTER).vAlign(SWT.TOP).vGrab().vSpan(3).hIndent(2));

		label(s).align(SWT.LEFT).text(prompt).layoutData(gridData().fill().hSpan(2));

		val t = text(s).layoutData(gridData().hFill().vAlign(SWT.FILL).hSpan(showBrowse? 1 : 2).width(150)).get();
		LambdaUtils.accept(initialValue, v -> {
			t.setText(v);
			t.setSelection(0, v.length());
		});

		if (showBrowse) {
			button(s).text("Browse...").layoutData(gridData().align(SWT.FILL)).onSelect(e -> {
				val dd = new FileDialog(s);
				dd.setText(getText());
				dd.setFilterPath(initialValue);
				LambdaUtils.accept(dd.open(), t::setText);
			});
		}

		label(s).layoutData(gridData().hFill());

		button(s).text("OK").layoutData(gridData().button()).shellDefault().onSelect(e -> {
			result = t.getText(); s.dispose();
		});

		s.pack();
		SWTUtilities.centerShell(s);
		SWTUtilities.open(s);
	 	return result;
	}
}
