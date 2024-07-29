package com.compassion.commons.gui.swt.dialog;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;

import com.compassion.commons.LambdaUtils;
import com.compassion.commons.Utilities;
import com.compassion.commons.gui.swt.controls.builders.SWTBuilders;
import com.compassion.commons.gui.swt.events.SelectionLambda;
import com.compassion.commons.gui.swt.util.MnemonicUtils;
import com.compassion.commons.gui.swt.util.SWTUtilities;

import lombok.val;

/**
 * An option box is a modal dialog that prompts the user to pick from
 * a list of options.  Options are either displayed as radio buttons,
 * check boxes, toggle buttons or as a list of options in a
 * {@link org.eclipse.swt.widgets.List} control.  Options can also be
 * grouped together to form multiple groups, and radio button exclusivity
 * will be on a per group basis.
 * @author John Dimeo
 */
public class OptionBox extends Dialog implements SWTBuilders {
	private static final String GROUP_KEY = "Group";

	private static final int LIST_WIDTH  = 200;
	private static final int LIST_HEIGHT = 64;

	 private String[][] choices = new String[0][0];
	 private String[] prompts = new String[0];
	 private boolean[][] result = new boolean[0][0];
	 private int[] styles;
	 private Image icon;
	 private boolean cancelled = true;

	 /**
	  * Initializes a new option box with a custom style.
	  * @param parent the shell on which to display this dialog
	  * @param style the style of the dialog box. If the style is {@code SWT.MENU}
	  * the options are displayed in a {@link List} control, and the option box will
	  * also respect {@code SWT.SINGLE} and {@code SWT.MULTI}, the supported styles
	  * of {@link List}. Otherwise, the style is applied directly to {@link Button}
	  * options, so one of {@code SWT.RADIO}, {@code SWT.TOGGLE}, or {@code SWT.CHECK}
	  * is recommended, although any style that {@link Button} supports is allowed.
	  */
	 public OptionBox(Shell parent, int style) {
	 	super(parent, style);
	 }
	 /**
	  * Initializes a new option box, with the default {@code SWT.RADIO} style.
	  * @param parent the shell on which to display this dialog
	  */
	 public OptionBox(Shell parent) {
	 	this(parent, SWT.RADIO);
	 }

	 /**
	  * Sets the list of string options for this dialog box. Do not include the ampersand
	  * character ({@code '&'}) in the strings; they will be added automatically.  Use
	  * this method for only one group of options.
	  * @param choices an array of strings
	  * @see #setOptions(String[][])
	  */
	 public void setOptions(String... choices) {
		 this.choices = new String[1][];
		 this.choices[0] = choices;
	 }

	 /**
	  * Sets the list of string options for this dialog box. Do not include the ampersand
	  * character ({@code '&'}) in the strings; they will be added automatically.  Use
	  * this method for multiple groups of options:<br>
	  * {@code choices[g][i]} is group {@code g}'s {@code i}<sup>th</sup> choice.
	  * @param choices an array of strings
	  * @see #setOptions(String[])
	  */
	 public void setOptions(String[]... choices) {
		 this.choices = choices;
	 }

	 /**
	  * Sets the prompt for the option box, which will appear above all the options.
	  * Use this method for only one group of options. Punctuation at the end of each
	  * prompt is recommended.
	  * @param prompt a string that describes the choices in this box
	  * @see #setMessages(String[])
	  */
	 public void setMessage(String prompt) {
		 prompts = new String[1];
		 prompts[0] = prompt;
	 }

	 /**
	  * If the choices are in more than one group, this method will set the
	  * prompt for each group.  If the number of prompts is less than the number
	  * of option groups, those groups without prompts will only display choices
	  * without a message. If a prompt is {@code null}, no separator will be
	  * drawn. Punctuation at the end of prompts is not recommended, as a horizontal
	  * separator is drawn after each prompt.
	  * @param prompts a list of prompts, where the first prompt corresponds
	  * to the first group of options
	  * @see #setMessage(String)
	  */
	 public void setMessages(String... prompts) {
		 this.prompts = prompts;
	 }

	 /**
	  * Sets the style of each option group if they are different. If the style
	  * is {@code SWT.MENU} the options are displayed in a {@link List} control,
	  * and the option box will also respect {@code SWT.SINGLE} and {@code SWT.MULTI},
	  * the supported styles of {@link List}. Otherwise, the style is applied directly
	  * to {@link Button} options, so one of {@code SWT.RADIO}, {@code SWT.TOGGLE},
	  * or {@code SWT.CHECK} is recommended, although any style that {@link Button}
	  * supports is allowed.
	  * @param styles a list of styles, with one integer for each option group
	  */
	 public void setStyles(int... styles) {
		this.styles = styles;
	 }

	 /**
	  * Sets the icon for the options dialog box.
	  * @param icon the image to use as an icon for the dialog box
	  */
	 public void setImage(Image icon) {
		 this.icon = icon;
	 }

	 /**
	  * Opens the dialog box and blocks until the user disposes of the box by either
	  * canceling (clicking {@code x}) or accepting their new selection
	  * (clicking {@code OK}).
	  * @param defaultSelections the option index in each group to select by default.
	  * If this number is less than zero or greater than the number of options,
	  * nothing will be selected by default. If the number of defaults is less than the
	  * number of option groups, those remaining groups will not have a default selection.
	  * @return an array of the same length as the number of options, where each
	  * {@code boolean} element indicates if the corresponding element was selected
	  * at the time the dialog was disposed, or {@code null} if the user cancelled
	  * @see #open(int)
	  */
	 public boolean[][] open(int... defaultSelections) {
	 	Shell parent = getParent();
	 	Display display = parent.getDisplay();
	 	int maxlen = 0;
	 	for (int i = 0; i < choices.length; i++) {
	 		if (choices[i] == null) { choices[i] = new String[0]; }
	 		if (choices[i].length > maxlen) {
	 			maxlen = choices[i].length;
	 		}
	 	}

	 	result = new boolean[choices.length][maxlen];
	 	boolean list = false;
	 	if (styles == null) {
	 		list = Utilities.isOn(getStyle(), SWT.MENU);
	 	}

	 	final Shell shell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
	 	shell.setText(getText());
 		shell.setLayout(new GridLayout(2, false));
	 	Label pic = new Label(shell, SWT.NONE);
	 		if (!list) { pic.setImage(display.getSystemImage(SWT.ICON_QUESTION)); }
	 		pic.setLayoutData(new GridData(SWT.CENTER, SWT.TOP, false, true, 1, choices.length));

	 	for (int group = 0; group < choices.length; group++) {
	 		Composite gc = composite(shell).layout(grid()).layoutData(gridData().hFill().vAlign(SWT.CENTER)).get();
	 		if (group < prompts.length) {
	 			SWTUtilities.addSeperator(null, gc, prompts[group], null, SWT.NONE);
	 		}
	 		if (styles != null && group >= styles.length) {  styles = null; }
		    if ((styles != null && Utilities.isOn(styles[group], SWT.MENU)) || list) {
		    	final List opt = new List(gc, getStyle() | SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		    	GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
		    	data.widthHint  = LIST_WIDTH;
		    	data.heightHint = LIST_HEIGHT;
		    	opt.setLayoutData(data);
		    	for (int i = 0; i < choices[group].length; i++) {
		    		opt.add(choices[group][i]);
		    		if (group < defaultSelections.length) {
			    		if (i == defaultSelections[group]) { opt.select(i); }
		    		}
		    	}
		    	shell.setData(GROUP_KEY + group, opt);
		    } else {
			 	final Button[] opt = new Button[choices[group].length];
			 	for (int i = 0; i < choices[group].length; i++) {
			 		opt[i] = new Button(gc, styles == null? getStyle() : styles[group]);
			 		opt[i].setText(MnemonicUtils.getMnemonic(gc, choices[group][i], null));
			 		opt[i].setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
			 		if (group < defaultSelections.length) {
				 		opt[i].setSelection(i == defaultSelections[group]);
			 		}
			 	}
			 	shell.setData(GROUP_KEY + group, opt);
		    }
	 	}

	 	label(shell).layoutData(gridData().hFill());

	 	val ok = button(shell).text("OK").shellDefault().layoutData(gridData().button().hSpan(2)).get();
	 	if (list) {
	 		ok.addSelectionListener((SelectionLambda) e -> {
 				for (int g = 0; g < choices.length; g++) {
 					List opt = (List) shell.getData(GROUP_KEY + g);
	 				for (int i = 0; i < result[g].length; i++) { result[g][i] = false; }
	 			 	for (int i : opt.getSelectionIndices())    { result[g][i] = true;  }
 				}
 				shell.dispose();
 			 	cancelled = false;
	 		});
	 		MouseListener ml = new MouseAdapter() {
	 			@Override
	    		public void mouseDoubleClick(MouseEvent e) {
	    			ok.notifyListeners(SWT.Selection, new Event());
	    		}
	    	};
	    	for (int g = 0; g < choices.length; g++) {
	    		((List) shell.getData("Group" + g)).addMouseListener(ml);
	    	}
	 	} else {
	 		ok.addSelectionListener((SelectionLambda) e -> {
 				for (int g = 0; g < choices.length; g++) {
 					Button[] opt = (Button[]) shell.getData(GROUP_KEY + g);
	 			 	for (int i = 0; i < opt.length; i++) {
	 			 		result[g][i] = opt[i].getSelection();
	 			 	}
 				}
 				shell.dispose();
 				cancelled = false;
	 		});
	 	}

	 	LambdaUtils.accept(icon, shell::setImage);
	 	shell.pack();
	 	SWTUtilities.centerShell(shell);
	 	SWTUtilities.open(shell);
	 	return cancelled? null : result;
	 }

	 /**
	  * Opens the dialog box and blocks until the user disposes of the box by either
	  * canceling (clicking {@code x}) or accepting their new selection
	  * (clicking {@code OK}).
	  * @param defaultSelection the option index to select by default. If this number
	  * is less than zero or greater than the number of options, nothing will be
	  * selected by default.
	  * @return an array of the same length as the number of options, where each
	  * {@code boolean} element indicates if the corresponding element was selected
	  * at the time the dialog was disposed, or {@code null} if the user cancelled
	  * @see #open(int[])
	  */
	 public boolean[] open(int defaultSelection) {
		 boolean[][] ans = open(new int[] {defaultSelection});
		 if (ans != null) { return ans[0]; }
		return null;
	 }
}
