/* ©2016-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.viz.gui.swt.util;

import java.awt.Color;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.OptionalInt;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.mutable.MutableBoolean;
import org.apache.commons.lang3.mutable.MutableInt;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Scale;
import org.eclipse.swt.widgets.ScrollBar;
import org.eclipse.swt.widgets.Scrollable;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Widget;

import com.compassion.commons.CalendarUtils;
import com.compassion.commons.LambdaUtils;
import com.compassion.commons.ReflectionUtils;
import com.compassion.commons.Utilities;
import com.elderresearch.viz.gui.UIAction;
import com.elderresearch.viz.gui.swt.controls.builders.IEnabled;
import com.elderresearch.viz.gui.swt.controls.builders.SWTBuilders;
import com.elderresearch.viz.gui.swt.events.FocusGainedLambda;
import com.elderresearch.viz.gui.swt.events.SelectionLambda;

import lombok.AllArgsConstructor;
import lombok.val;
import lombok.experimental.UtilityClass;
import lombok.extern.log4j.Log4j2;

/**
 * Utilities for the SWT APIs.
 *
 *
 * @since Mar 18, 2016
 */
@Log4j2
@UtilityClass
public final class SWTUtilities {
	public static final int IMAGE = 1 << 28;
	public static final int TEXT  = 1 << 27;

	private static final Event BLANK_EVENT = new Event();

	/**
	 * Centers the shell on the current screen.
	 * @param shell the shell to center
	 * @return the rectangle client area of the shell's display
	 */
	public static Rectangle centerShell(Shell shell) {
		return centerShell(shell, shell.getMonitor().getClientArea());
	}

	/**
	 * Centers the shell relative to the parent shell.
	 * @param shell the shell to center
	 * @param parent the parent shell whose bounds should be used to compute the center location
	 * @return the bounds of the parent shell
	 */
	public static Rectangle centerShell(Shell shell, Composite parent) {
		return centerShell(shell, parent.getBounds());
	}

	private static Rectangle centerShell(Shell shell, Rectangle bounds) {
		Point p = shell.getSize();
		int nX = (bounds.width  / 2) - (p.x / 2);
		int nY = (bounds.height / 2) - (p.y / 2);
		shell.setLocation(nX + bounds.x, nY + bounds.y);
		return bounds;
	}

	/**
	 * Ensure the shell's bounds do not exceed the bounds of the parent's client area (either another shell or the
	 * shell's display).
	 * @param shell the shell to clamp
	 */
	public static void clampShell(Shell shell) {
		val parentArea = ObjectUtils.defaultIfNull(
			LambdaUtils.apply(shell.getParent(), Composite::getClientArea),
			shell.getDisplay().getClientArea());

		val bounds = shell.getBounds();
		bounds.x = Utilities.clamp(bounds.x, parentArea.x, parentArea.x + parentArea.width - bounds.width);
		bounds.y = Utilities.clamp(bounds.y, parentArea.y, parentArea.y + parentArea.height - bounds.height);
		shell.setBounds(bounds);
	}

	/**
	 * Computes the preferred height of the control based on the current
	 * width.  This assumes that the control has a {@link GridData}
	 * instance as its layout data, and sets the {@link GridData#heightHint}.
	 * @param c the control
	 */
	public static void setDefaultHeight(Control c) {
		Point p = c.computeSize(c.getSize().x, SWT.DEFAULT);
		((GridData) c.getLayoutData()).heightHint = p.y;
	}

	/**
	 * Executes the runnable repeatedly every interval until the callback returns {@code false}.
	 * @param d the display on which to execute the runnable
	 * @param callback the callback to invoke for each frame. This should return {@code false} when it should no
	 * longer be queued for execution
	 * @param periodMS the initial delay and the subsequent delay between each invocation/frame in milliseconds
	 * @param widgets any related widgets that should not be disposed prior to this task running
	 * @see Display#timerExec(int, Runnable)
	 */
	public static void runLoop(Display d, Supplier<Boolean> callback, int periodMS, Widget... widgets) {
		run(d, () -> {
			if (callback.get()) { runLoop(d, callback, periodMS, widgets); }
		}, OptionalInt.of(periodMS), widgets);
	}

	/**
	 * Executes the runnable on the display's UI thread at the next reasonable
	 * opportunity. This method checks to see if the display (and any other specified widgets) are disposed before
	 * handing the runnable off to the display to be executed as well as right before the runnable is executed by
	 * the UI thread.
	 * @param d the display on which to execute the runnable
	 * @param r the runnable to execute
	 * @param widgets any related widgets that should not be disposed prior to this task running
	 * @see Display#asyncExec(Runnable)
	 */
	public static void run(Display d, Runnable r, Widget... widgets) {
		run(d, r, OptionalInt.empty(), widgets);
	}

	/**
	 * A semantic and reusable paramter for an immediate, but synchronous, task
	 * @see #run(Display, Runnable, OptionalInt, Widget...)
	 */
	public static final OptionalInt BLOCKING = OptionalInt.of(0);

	/**
	 * Executes the runnable on the display's UI thread. This method checks to
	 * see if the display is disposed before handing the runnable off to the
	 * display to be executed as well as right before the runnable is executed
	 * by the UI thread. If this is called from the UI thread, the runnable is
	 * invoked directly without using any of the display's {@code *Exec} methods.
	 * @param d the display on which to execute the runnable
	 * @param r the runnable to execute
	 * @param delayMS when to execute the runnable. If this is defined and {@code 0} or less, the method blocks until
	 * the runnable is executed. If this is not defined, the runnable is invoked asynchronously at the next opportunity.
	 * Otherwise, {@code delay} specifies the milliseconds to wait before executing the runnable, and the method returns immediately.
	 * @param widgets any related widgets that should not be disposed prior to this task running
	 * @see Display#asyncExec(Runnable)
	 * @see Display#syncExec(Runnable)
	 * @see Display#timerExec(int, Runnable)
	 * @see #BLOCKING a semantic and reusable paramter for an immediate, but synchronous, task
	 */
	public static void run(Display d, final Runnable r, OptionalInt delayMS, Widget... widgets) {
		val swtr = new SWTRunnable(d, r, widgets);
		if (swtr.checkDisposed()) { return; }

		boolean block = false;
		if (delayMS.isPresent()) {
			val ms = delayMS.getAsInt();
			if (ms > 0) {
				d.timerExec(ms, swtr);
				return;
			}
			block = true;
		}

		if (isUIThread()) {
			swtr.run();
		} else if (block) {
			d.syncExec(swtr);
		} else {
			d.asyncExec(swtr);
		}
	}

	@AllArgsConstructor
	private static final class SWTRunnable implements Runnable {
		private Display d;
		private Runnable r;
		private Widget[] w;

		@Override
		public void run() {
			if (!checkDisposed()) { r.run(); }
		}

		boolean checkDisposed() {
			return d.isDisposed() || Stream.of(w).anyMatch(Widget::isDisposed);
		}
	}

	/**
	 * Adds a separator to a composite, consisting of text followed by a horizontal
	 * rule.  If {@code text} is {@code null}, only a horizontal rule is added.
	 * It is assumed the composite has a {@code GridLayout} so {@code horizSpan}
	 * specifies the number of grid columns to span.  Automatically colors all components
	 * using the background and foreground colors of the parent. Example:<p>
	 * <table border=0><tr><td>{@code text}</td><td><hr width=64></td></tr></table></p>
	 * @param rm the resource manager (for any custom fonts)
	 * @param parent the composite on which to add the separator
	 * @param text the text of the separator (can be {@code null})
	 * @param image the image of the separator (can be {@code null})
	 * @param style the bitwise OR of style options:<ul>
	 * <li>{@link SWT#BOLD} sets the font of the separator to be bold</li>
	 * <li>{@link SWT#TOP} indicates that this separator is the first on a page
	 * and should not have the default top padding/indentation</li></ul>
	 * @return the created separator's composite
	 */
	public static Composite addSeperator(ResourceManager rm, Composite parent, String text, Object image, int style) {
		return SWTBuilders.build(b -> b.composite(parent)
			.colorsParent()
			.layout(b.grid(image == null? 2 : 3)
				.hMargin(0)
				.vMargin(Utilities.isOn(style, SWT.TOP)? 0 : 5, 0))
			.children(c -> {
				LambdaUtils.accept(image, i -> b.label(c).colorsParent().image(rm.getImage(i)));

				val lb = b.label(c).colorsParent().text(text);
				if (Utilities.isOn(style, SWT.BOLD)) { lb.font(rm.getFontBold()); }

				b.separator(c, SWT.HORIZONTAL).colorsParent().layoutData(b.gridData().hFill());
			}).get());
	}

	/**
	 * Checks to see if the file exists and prompts the user to overwrite the
	 * file if it does.
	 * @param s a shell to display the dialog on
	 * @param title the title of the dialog box (i.e. "Save", "Copy File", or
	 * your application's name)
	 * @param f the file to check
	 * @return whether or not to continue. This is {@code true} if the file
	 * does not exist or the user wants to overwrite an existing file
	 */
	public static boolean checkFile(Shell s, String title, File f) {
		if (f.exists()) {
			MessageBox mb = new MessageBox(s, SWT.ICON_WARNING | SWT.YES | SWT.NO);
			mb.setText(title);
			mb.setMessage("The file\n'" + f.getAbsolutePath() + "'\nalready exists. Replace it?");
			return mb.open() == SWT.YES;
		}
		return true;
	}

	/**
	 * Returns a focus listener for SWT text fields so that
	 * when they receive focus, they automatically select all their
	 * text.
	 * @return a focus listener
	 */
	public static FocusGainedLambda getSelectAllTextListener() { return SELECT_ALL_TEXT; }
	private static final FocusGainedLambda SELECT_ALL_TEXT = e -> ((Text) e.widget).selectAll();

	/**
	 * Returns a selection listener that will launch web pages (or the target of any {@link Link})
	 * using the operating system executable for the link (usually a web browser).
	 * @return a selection listener
	 */
	public static SelectionLambda getHyperlinkSelectionListener() { return LAUNCH_LINK; }
	private static final SelectionLambda LAUNCH_LINK = e -> Program.launch(e.text);

	/**
	 * <p>Adds a focus listener to a SWT text fields that displays
	 * a prompt in a grayed out font until it receives focus.
	 * If the user hasn't typed any text when focus is lost, the
	 * prompt text is displayed again.</p>
	 * <p>For text fields, consider using {@link Text#setMessage(String)} instead.</p>
	 * @param c the control to add the listeners to (must be a {@link Combo} or a {@link Text})
	 * @param prompt the prompt to display in the text box before
	 * the user starts typing in it
	 */
	public static void addReplacePromptListener(final Control c, final Object prompt) {
		c.addFocusListener(new FocusListener() {
			private boolean empty = true;

			@Override
			public void focusGained(FocusEvent e) {
				if (empty) {
					c.setForeground(e.display.getSystemColor(SWT.COLOR_WIDGET_FOREGROUND));
					if (c instanceof Combo) { ((Combo) c).setText(""); }
					if (c instanceof Text)  { ((Text)  c).setText(""); }
					empty = false;
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				String s = "";
				if (c instanceof Combo) { s = ((Combo) c).getText(); }
				if (c instanceof Text)  { s = ((Text)  c).getText(); }

				if (s.isEmpty()) {
					c.setForeground(e.display.getSystemColor(SWT.COLOR_WIDGET_DARK_SHADOW));
					if (c instanceof Combo) { ((Combo) c).setText(prompt.toString()); }
					if (c instanceof Text)  { ((Text)  c).setText(prompt.toString()); }
					empty = true;
				} else {
					c.setForeground(e.display.getSystemColor(SWT.COLOR_WIDGET_FOREGROUND));
					empty = false;
				}
			}
		});
		c.notifyListeners(SWT.FocusOut, new Event());
	}

	/**
	 * Configures the passed combo box such that, as the user types in the
	 * combo box, it suggests completions based on its list of items.
	 * @param combo the combo box to configure
	 */
	public static void addAutoCompleteListeners(final Combo combo) {
		addAutoCompleteListeners(combo, false, false);
	}

	/**
	 * Configures the passed combo box such that, as the user types in the
	 * combo box, it suggests completions based on its list of items.
	 * @param combo the combo box to configure
	 * @param notifyOnComplete by default, the combo box only notifies its selection listeners when the user presses
	 * the {@code Enter} key, allowing them to type and find the item they want to select before propagating to the
	 * listeners. Passing {@code true} means that the combo will notify its selection listeners as soon as a suggestion
	 * is completed from what the user has typed so far. You can use default selection to detect when the user pressed
	 * the {@code Enter} key.
	 * @param tryContains by default, the combo tries only prefixes (starts with). This also attempts to match the middle
	 * of the strings in the list of items, but can lead to unintuitive behavior.
	 */
	public static void addAutoCompleteListeners(final Combo combo, boolean notifyOnComplete, boolean tryContains) {
		val wasLastKeyDel = new MutableBoolean();
		val startIdx = new MutableInt();

		combo.addModifyListener(e -> {
			if (wasLastKeyDel.booleanValue()) { return; }

			val fullText = combo.getText();
			if (fullText.length() < startIdx.intValue()) { startIdx.setValue(0); }

			val startSel = combo.getSelection().x;
			if (fullText.length() < startSel) { return; }
			String t = fullText.substring(Math.min(startSel, startIdx.intValue()), startSel).toLowerCase();

			if (t.length() < 1) { return; }
			for (int i = 0; i < combo.getItemCount(); i++) {
				String s = combo.getItem(i);
				if (t.length() >= s.length()) { continue; }
				if (s.toLowerCase().startsWith(t)) {
					if (notifyOnComplete) {
						selectAndNotify(combo, i);
					} else {
						combo.select(i);
					}
					combo.setSelection(new Point(t.length(), s.length()));
					break;
				}
			}

			if (t.length() < 2 || !tryContains) { return; }
			for (int i = 0; i < combo.getItemCount(); i++) {
				String s = combo.getItem(i);
				int j = s.toLowerCase().indexOf(t);
				if (j > 0) {
					startIdx.setValue(j);
					if (notifyOnComplete) {
						selectAndNotify(combo, i);
					} else {
						combo.select(i);
					}
					combo.setSelection(new Point(j + t.length(), j + s.length()));
					break;
				}
			}
		});

		combo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int selection = combo.getSelectionIndex();
				wasLastKeyDel.setFalse();
				if (e.keyCode == SWT.BS || e.keyCode == SWT.DEL) {
					wasLastKeyDel.setTrue();
				}
				if (!notifyOnComplete && (e.keyCode == SWT.CR || e.keyCode == SWT.KEYPAD_CR) && selection >= 0) {
					combo.clearSelection();
					combo.notifyListeners(SWT.Selection, new Event());
				}
				if (e.keyCode == SWT.TAB) {
					combo.traverse(SWT.TRAVERSE_TAB_NEXT);
				}
			}
		});
	}

	/**
	 * Adds a menu item to a drop-down toolbar item (that was created with style {@link SWT#DROP_DOWN} and
	 * adds the appropriate listeners to create and show the menu when the user clicks the tool item.  When
	 * menu items are clicked, their user data becomes data of the tool item.
	 * @param item the tool item to add to
	 * @param style the style of the menu item (see {@link MenuItem}) plus one or more of the following style
	 * flags bitwise OR'ed together:<ul>
	 * <li>{@link SWT#SELECTED}: this menu item should be the default or initial action of the tool item</li>
	 * <li>{@link SWT#SIMPLE}: the menu item should not show the passed in image, just the text.  The tool item
	 * will still display the image when this menu item is selected</li></ul>
	 * @param text the text of the menu item
	 * @param image the image of the menu item (can be {@code null})
	 * @param data a user object for the menu item that will be set as the tool item's user object when
	 * the menu item is selected
	 * @param sel a selection listener that will be called when either the menu item itself is clicked, or
	 * the tool item is clicked and this menu item was the most recent menu item clicked
	 * @return the created menu item
	 */
	public static MenuItem addMenuItem(final ToolItem item, int style, String text, Image image, Object data, final SelectionListener sel) {
		Menu menu = (Menu) item.getData("menu");
		if (menu == null) {
			menu = new Menu(item.getParent().getShell());
			item.setData("menu", menu);

			item.addSelectionListener((SelectionLambda) e -> {
				if (e.detail == SWT.ARROW) {
					Menu parent = (Menu) e.widget.getData("menu");
					Rectangle rect = item.getBounds();
					Point p = item.getParent().toDisplay(rect.x, rect.y);
					parent.setLocation(p.x, p.y + rect.height);
					parent.setVisible(true);
					e.doit = false;
				} else {
					SelectionListener sl = (SelectionListener) e.widget.getData("listener");
					e.widget = (Widget) e.widget.getData("item");
					sl.widgetSelected(e);
				}
			});
		}

		final String original = item.getToolTipText();

		MenuItem mi = new MenuItem(menu, style & ~SWT.SELECTED);
		if (image != null && !Utilities.isOn(style, SWT.SIMPLE)) { mi.setImage(image); }
		if (text  != null) { mi.setText(text); }
		mi.setData(data);
		mi.addSelectionListener((SelectionLambda) e -> {
			item.setData(mi.getData());
			item.setData("item", mi);
			item.setData("listener", sel);

			LambdaUtils.accept(mi.getImage(), item::setImage);
			LambdaUtils.accept(mi.getText(), $ -> item.setToolTipText(original == null? $ : (original + ": " + $)));
			sel.widgetSelected(e);
		});

		if (Utilities.isOn(style, SWT.SELECTED)) {
			item.setData(data);
			item.setData("item", mi);
			item.setData("listener", sel);

			LambdaUtils.accept(image, item::setImage);
		}
		return mi;
	}

	/**
	 * Recursively adds a key listener to a control and all of its
	 * children.  This is useful for manually supporting key accelerators
	 * on your interface. Call this method on a shell once it has been
	 * initialized so that key presses on the shell or its children are
	 * sent to the listener.
	 * @param kl the key listener to add to the control
	 * @param c a control
	 */
	public static void addKeyListener(KeyListener kl, Control c) {
		c.addKeyListener(kl);
		if (c instanceof Composite) {
			for (Control child : ((Composite) c).getChildren()) {
				addKeyListener(kl, child);
			}
		}
	}

	/**
	 * Converts an AWT color to the SWT RGB struct.
	 * @param c the color to convert
	 * @return the equivalent SWT color
	 */
	public static RGB colorToSWT(Color c) {
		return new RGB(c.getRed(), c.getGreen(), c.getBlue());
	}
	/**
	 * Converts an SWT color to an AWT color.
	 * @param rgb the SWT RGB struct
	 * @return the equivalent AWT color
	 */
	public static Color colorToAWT(RGB rgb) {
		return new Color(rgb.red, rgb.green, rgb.blue);
	}

	/**
	 * Computes the integer equivalent of the specified color by using
	 * the lower 24 bits of the returned integer to store each channel
	 * of the color as an 8-bit value between {@code 0} and {@code 255}.
	 * This conversion was copied from the SWT {@link org.eclipse.swt.graphics.Color}
	 * class.
	 * @param rgb the RGB struct to convert to an integer representation
	 * @return an integer representation of the RGB parameter
	 */
	public static int colorToInt(RGB rgb) {
		return 0x02000000 | (rgb.red & 0xFF) | ((rgb.green & 0xFF) << 8) | ((rgb.blue & 0xFF) << 16);
	}

	/**
	 * Extracts the red, green, and blue channels from a integer, where
	 * each channel was represented with 8 bits in the lower 24 bits of
	 * the integer.
	 * @param pixel an integer representing a color
	 * @return the red, green, and blue channels of the passed color
	 */
	public static RGB colorToRGB(int pixel) {
		return new RGB(pixel & 0xFF,
				      (pixel & 0xFF00)   >> 8,
				      (pixel & 0xFF0000) >> 16);
	}

	/**
	 * Converts an RGB pixel to a BGR pixel and vice versa.
	 * @param rgbgr an integer representing a color
	 * @return the equivalent color in the opposite representation
	 */
	public static int colorRGBGR(int rgbgr) {
		return (rgbgr & 0xFF) << 16
		     | (rgbgr & 0xFF00)
		     | (rgbgr & 0xFF0000) >> 16;
	}

	/**
	 * Recursively sets the foreground and background colors of a control's children
	 * to the colors of the parent.
	 * @param parent the parent control whose colors will be passed down to its children
	 * @param classFilter if this is not empty, only children that are one of these classes
	 * will have their colors changed
	 */
	@SafeVarargs
	public static void setColor(Composite parent, Class<? extends Control>... classFilter) {
		Control[] children = parent.getChildren();
		for (int i = 0; i < children.length; i++) {
			Control child = children[i];
			Class<?> c = child.getClass();

			boolean match = classFilter.length == 0;
			for (int j = 0; j < classFilter.length; j++) {
				if (c.equals(classFilter[j])) {
					match = true; break;
				}
			}

			if (match) {
				child.setBackground(parent.getBackground());
				child.setForeground(parent.getForeground());
			}
			if (child instanceof Composite) {
				setColor((Composite) child, classFilter);
			}
		}
	}

	/**
	 * Gets the currently selected date and time in the {@link DateTime} as a {@link Date}.
	 * @param dt the date/time selector
	 * @return the selected date
	 */
	public static Date getDate(DateTime dt) {
		Calendar c = CalendarUtils.get();
		c.set(Calendar.YEAR,        dt.getYear());
		c.set(Calendar.MONTH,       dt.getMonth());
		c.set(Calendar.DATE,        dt.getDay());
		c.set(Calendar.HOUR_OF_DAY, dt.getHours());
		c.set(Calendar.MINUTE,      dt.getMinutes());
		c.set(Calendar.SECOND,      dt.getSeconds());
		return c.getTime();
	}

	/**
	 * Sets the currently selected date and time in the {@link DateTime} to the specified {@link Date}.
	 * @param dt the date/time selector
	 * @param d the new date. If this is {@code null}, the current date/time will be used
	 */
	public static void setDate(DateTime dt, Date d) {
		Calendar c = CalendarUtils.at(d == null? new Date() : d);
		dt.setDate(c.get(Calendar.YEAR), c.get(Calendar.MONTH),  c.get(Calendar.DATE));
		dt.setTime(c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE), c.get(Calendar.SECOND));
	}

	/**
	 * Sets the control's text if this control supports the operation.  Otherwise,
	 * this method logs an exception and does nothing.
	 * @param w the control on which to set the text (like {@code Text}, {@code Label}, etc.)
	 * @param text the text to set
	 */
	public static void setText(Widget w, String text) {
		ReflectionUtils.invoke(w, "setText", text);
	}

	/**
	 * Gets the control's text if this control supports the operation. Otherwise,
	 * this method logs an exception and returns {@code null}.
	 * @param w the control whose text to get
	 * @return the control's text, or {@code null} if the control does not
	 * have text
	 */
	public static String getText(Widget w) {
		return Objects.toString(ReflectionUtils.invoke(w, "getText"), null);
	}

	/**
	 * Convenience method for the SWT read/dispatch loop for a shell.
	 * This method should only be called on modal shells.  The body
	 * of this method is as follows:<br><pre>
	 * s.open();
	 * while(!s.isDisposed()) {
	 *    if(!s.getDisplay().readAndDispatch())
	 *       s.getDisplay().sleep();
	 * }
	 * </pre>
	 * @param s a modal shell
	 */
	public static void open(Shell s) {
		s.open();
		Display d = s.getDisplay();
		while (!s.isDisposed()) {
			if (!d.readAndDispatch()) { d.sleep(); }
		}
	}

	private static final float COLOR_IAMGE_BORDER_THRESH = 0.7f;

	/**
	 * Creates and returns an image where the background is shaded a solid color.  If the color
	 * is too light, a single-pixel gray border is drawn around the border of the rectangle.
	 * @param rm the resource manager to use when allocating the color and image
	 * @param rgb the solid color for the background of the image
	 * @param width the width of the image
	 * @param height the height of the image
	 * @param border whether or not to draw a single pixel border (a light
	 * color for dark colors and a dark for light colors)
	 * @return the created image
	 */
	public static Image getColorImage(ResourceManager rm, RGB rgb, int width, int height, boolean border) {
		Image im = new Image(rm.getDisplay(), width, height);
		rm.add(im);

		GC gc = new GC(im);
		gc.setBackground(rm.getColor(rgb));
		gc.fillRectangle(0, 0, width, height);

		if (border) {
			int c = rgb.getHSB()[2] > COLOR_IAMGE_BORDER_THRESH? SWT.COLOR_DARK_GRAY : SWT.COLOR_WHITE;
			gc.setForeground(rm.getDisplay().getSystemColor(c));
			gc.drawRectangle(0, 0, width - 1, height - 1);
		}

		gc.dispose();
		return im;
	}

	/**
	 * Opens a {@link FileDialog} that filters using SWT supported image
	 * file formats.
	 * @param parent the parent shell of the dialog
	 * @param title the title for the file dialog
	 * @param file the initial file that is selected by the dialog (can be <code>null</code>)
	 * @param style one of {@link SWT#OPEN} or {@link SWT#SAVE}
	 * @return the filename the user selected, or {@code null} if they
	 * canceled the dialog
	 */
	public static String getImageFileDialog(Shell parent, String title, String file, int style) {
		FileDialog fd = new FileDialog(parent, style);
		fd.setText(title);
		fd.setFilterNames(new String[] {
				"All Picture Files", "Bitmap Files (*.bmp)", "JPEG (*.jpg, *.jpeg)",
				"GIF (*.gif)", "ICO (*.ico)", "All Files (*.*)"});
		fd.setFilterExtensions(new String[] {
				"*.bmp;*.jpg;*.jpeg;*.gif;*.ico;",
				"*.bmp", "*.jpg;*.jpeg", "*.gif", "*.ico", "*.*"});
		fd.setFileName(file);
		return fd.open();
	}

	/**
	 * Adds an item to a list only if its list of items does not already
	 * contain that item.
	 * @param list an SWT List widget
	 * @param item the item to add
	 * @param scroll whether or not scroll the list so that the item that
	 * was just added is in view
	 * @return whether or not the item was added
	 * @see List#add(String)
	 */
	public static boolean uniqueAdd(List list, String item, boolean scroll) {
		String[] items = list.getItems();
		for (String s : items) {
			if (item.equals(s)) { return false; }
		}
		list.add(item);
		if (scroll) { list.setTopIndex(list.getItemCount()); }
		return true;
	}

	/**
	 * Adds an item to a combo box only if its list of items does not already
	 * contain that item.
	 * @param c an SWT Combo widget
	 * @param item the item to add
	 * @return whether or not the item was added
	 * @see Combo#add(String)
	 */
	public static boolean uniqueAdd(Combo c, String item) {
		String[] items = c.getItems();
		for (String s : items) {
			if (item.equals(s)) { return false; }
		}
		c.add(item);
		return true;
	}

	/**
	 * Selects the corresponding index of the combo's item if that item is found.
	 * @param c the combo
	 * @param item the item to select
	 * @return if the item was found in the combo's items (and thus selected)
	 * @see Combo#select(int)
	 */
	public static boolean select(Combo c, Object item) {
		if (item == null) {
			c.deselectAll();
			return false;
		}

		String itemStr = StringUtils.stripToEmpty(item.toString());
		String[] items = c.getItems();
		for (int i = 0; i < items.length; i++) {
			if (items[i].equals(itemStr)) { c.select(i); return true; }
		}
		for (int i = 0; i < items.length; i++) {
			if (itemStr.startsWith(items[i])) { c.select(i); return true; }
		}
		return false;
	}

	/**
	 * Sets the combo's selection to the specified index and notifies any listeners.
	 * @param c the combo to select
	 * @param index the index to select, or {@code -1} to clear selection
	 * @see Combo#select(int)
	 * @see SWTUtilities#selectAndNotify(Control)
	 */
	public static void selectAndNotify(Combo c, int index) {
		if (index < 0) {
			c.deselectAll();
		} else {
			c.select(index);
		}
		selectAndNotify(c);
	}

	/**
	 * Sets the list's selection to the specified index and notifies any listeners.
	 * @param l the list to select
	 * @param index the index to select, or {@code -1} to clear selection
	 * @see List#select(int)
	 * @see SWTUtilities#selectAndNotify(Control)
	 */
	public static void selectAndNotify(List l, int index) {
		if (index < 0) {
			l.deselectAll();
		} else {
			l.select(index);
		}
		selectAndNotify(l);
	}

	/**
	 * Sets the scale's selected value and notifies any listeners.
	 * @param s the scale to select
	 * @param value the value to select (must be positive)
	 * @see Scale#setSelection(int)
	 * @see #selectAndNotify(Control)
	 */
	public static void selectAndNotify(Scale s, int value) {
		s.setSelection(value);
		selectAndNotify(s);
	}

	/**
	 * Sets the spinner's selected value and notifies any listeners.
	 * @param s the spinner to select
	 * @param value the value to select
	 * @see Spinner#setSelection(int)
	 * @see #selectAndNotify(Control)
	 */
	public static void selectAndNotify(Spinner s, int value) {
		s.setSelection(value);
		selectAndNotify(s);
	}

	/**
	 * Notifies the control's selection listeners that a selection event occurred.<br/>
	 * <b>Warning:</b> this will send a blank event to the listeners, so you must
	 * ensure that the listeners are not using any event-specific state, just that a selection
	 * event occurred.
	 * @param c the control to select
	 */
	public static void selectAndNotify(Control c) {
		c.notifyListeners(SWT.Selection, BLANK_EVENT);
	}

	/**
	 * Returns the currently selected value of the spinner as a floating-point
	 * number.  The value returned is:<br>
	 * <code>{@link Spinner#getSelection()} / Math.pow(10.0, {@link Spinner#getDigits()})</code>
	 * @param s the spinner
	 * @return the currently selected value
	 * @see #setSpinnerSelection(Spinner, double)
	 */
	public static double getSpinnerSelection(Spinner s) {
		return s.getSelection() / Math.pow(10.0, s.getDigits());
	}

	/**
	 * Sets the currently selected value of the spinner to a floating-point
	 * number.  This value is computed using:<br>
	 * <code>(int) Math.round(val * Math.pow(10.0, {@link Spinner#getDigits()}))</code>
	 * @param s the spinner
	 * @param val the new value
	 * @see #getSpinnerSelection(Spinner)
	 * @see #setSpinnerValues(Spinner, double, double, double, double)
	 */
	public static void setSpinnerSelection(Spinner s, double val) {
		s.setSelection(convertSpinnerValue(s.getDigits(), val));
	}

	/**
	 * Sets the acceptable range of values of the spinner to floating-point
	 * numbers. These values are computed using:<br>
	 * <code>(int) Math.round(val * Math.pow(10.0, {@link Spinner#getDigits()}))</code>
	 * @param s the spinner
	 * @param min the new minimum
	 * @param max the new maximum
	 * @param inc the new increment
	 * @param page the new page increment
	 * @see #setSpinnerSelection(Spinner, double)
	 */
	public static void setSpinnerValues(Spinner s, double min, double max, double inc, double page) {
		int d = s.getDigits();
		s.setMinimum(convertSpinnerValue(d, min));
		s.setMaximum(convertSpinnerValue(d, max));
		s.setIncrement(convertSpinnerValue(d, inc));
		s.setPageIncrement(convertSpinnerValue(d, page));
	}
	private static int convertSpinnerValue(int d, double v) {
		return (int) Math.round(v * Math.pow(10.0, d));
	}

	/**
	 * Sets the provided control as the "top" control of its parent's stack layout and
	 * lays out the parent. The control's parent must have a {@link StackLayout} as its layout manager.
	 * @param c the control to set as the top control
	 */
	public static void setTopControl(Control c) {
		Composite parent = c.getParent();
		StackLayout l = (StackLayout) parent.getLayout();
		if (l.topControl != c) {
			l.topControl = c;
			parent.layout();
		}
	}

	/**
	 * Parses the key combination into the corresponding SWT key code(s) from
	 * the provided string. For example, parsing {@code "Ctrl+C"} returns
	 * {@code {@link SWT#CTRL} | 'C'}.
	 * @param accel the string representation of the key combination, or accelerator
	 * @return the key code, which is the bitwise OR'ing of letters or key constants
	 * in the {@code SWT} class.
	 */
	public static int parseAccelerator(String accel) {
		int ret = 0;
		String[] arr = accel.split(Pattern.quote("+"));
		for (int i = 0; i < arr.length; i++) {
			try {
				Field f = SWT.class.getDeclaredField(arr[i].toUpperCase());
				ret |= f.getInt(null);
			} catch (NoSuchFieldException e) {
				ret |= arr[i].charAt(0);
			} catch (IllegalAccessException e) {
				log.warn("Cannot access SWT constant {}", arr[i], e);
			}
		}
		return ret;
	}

	/**
	 * Sets the control's layout data to be a {@link GridData} object that has its
	 * {@code exclude} field set to {@code true} so that it won't be laid out by
	 * its parent with a {@link GridLayout}.
	 * @param c the control to exclude from its parent's layout
	 */
	public static void exclude(Control c) {
		GridData gd = new GridData();
		gd.exclude = true;
		c.setLayoutData(gd);
	}

	/**
	 * Sets the control visibility as well as exclusion, so that they are totally ignored
	 * by the layout manager and not displayed. This method assumes that the control has
	 * no layout data (so only visiblity will be set) or a {@link GridData} (so
	 * {@link GridData#exclude} will be set) or a {@link RowData} (so {@link RowData#exclude}
	 * will be set).
	 * @param c the control
	 * @param visible whether or not to show the control
	 */
	public static void setVisibleAndIncluded(Control c, boolean visible) {
		Object o = c.getLayoutData();
		if (o != null) {
			if (o instanceof GridData) { ((GridData) o).exclude = !visible; }
			if (o instanceof RowData)  { ((RowData) o).exclude = !visible; }
		}
		c.setVisible(visible);
	}

	/**
	 * Creates a cool item with {@code c} as its control.  This convenience method
	 * also resizes the cool item to the preferred size of {@code c}.
	 * @param cb the cool bar in which to create the item
	 * @param c the item's control
	 * @return the created cool item
	 */
	public static CoolItem item(CoolBar cb, Control c) {
		CoolItem item = new CoolItem(cb, SWT.NONE);
		item.setControl(c);
		Point size = c.computeSize(SWT.DEFAULT, SWT.DEFAULT);
		size = item.computeSize(size.x, size.y);
		item.setSize(size);
		return item;
	}

	/**
	 * Creates a cascading menu on an existing menu.
	 * @param mainMenu the top-level menu
	 * @param name the name of the menu item that opens the menu
	 * @return the created menu
	 */
	public static Menu menu(Menu mainMenu, String name) {
		MenuItem mi = new MenuItem(mainMenu, SWT.CASCADE);
		if (name != null) {
			mi.setText(MnemonicUtils.getMnemonic(mainMenu.getShell(), name, null));
		}
		Menu m = new Menu(mainMenu.getShell(), SWT.DROP_DOWN);
		mi.setMenu(m);
		return m;
	}

	/**
	 * Creates a menu item for the specified action.
	 * @param menu the menu on which to create the item
	 * @param style the style of the menu item (of the supported styles in {@link MenuItem})
	 * @param action the action that specifies the text, tooltip, image, etc. for the item
	 * @param rm the resource manager used for any images or colors
	 * @param sel the selection listener that will be notified when the item is clicked
	 * @return the initialized menu item
	 */
	public static MenuItem item(Menu menu, int style, UIAction action, ResourceManager rm, SelectionListener sel) {
		MenuItem mi = new MenuItem(menu, style);
		if (sel != null) { mi.addSelectionListener(sel); }

		return decorate(mi, action, rm);
	}

	/**
	 * Decorates an existing menu item with the specified action.
	 * @param mi the menu item
	 * @param action the action that specifies the text, tooltip, image, etc. for the item
	 * @param rm the resource manager used for any images or colors
	 * @return the menu item parameter
	 */
	public static MenuItem decorate(MenuItem mi, UIAction action, ResourceManager rm) {
		MnemonicUtils.freeMnemonic(mi.getParent(), mi.getText());

		String text = MnemonicUtils.getMnemonic(mi.getParent(), action.getName(), null);
		if (action.isMoreInputNeeded()) { text += "..."; }
		if (action.getAccelerator() != null) {
			String accel = action.getAccelerator().toString();
			text += "\t" + accel;
			mi.setAccelerator(parseAccelerator(accel));
		}
		mi.setText(text);

		Image img = rm.getImage(action.getImage());
		if (img != null) { mi.setImage(img); }

		mi.setData(action);
		return mi;
	}

	/**
	 * Convenience method that creates a horizontal separator item on a menu.
	 * @param menu the menu
	 * @return the separator item
	 */
	public static MenuItem separator(Menu menu) { return new MenuItem(menu, SWT.SEPARATOR); }

	/**
	 * Creates a tool bar item for the specified action.
	 * @param tools the tool bar on which to create the item
	 * @param style the style of the tool item (of the supported styles in {@link ToolItem}) in
	 * addition to {@link #IMAGE} or {@link #TEXT}.
	 * @param action the action that specifies the text, tooltip, image, etc. for the item
	 * @param rm the resource manager used for any images or colors
	 * @param sel the selection listener that will be notified when the item is clicked
	 * @return the initialized tool item
	 */
	public static ToolItem item(ToolBar tools, int style, UIAction action, ResourceManager rm, SelectionListener sel) {
		ToolItem ti = new ToolItem(tools, style);
		LambdaUtils.accept(sel, ti::addSelectionListener);
		return decorate(ti, style, action, rm);
	}

	/**
	 * Decorates an existing tool item with the specified action.
	 * @param ti the tool item
	 * @param style the style of the tool item (of the supported styles in {@link ToolItem})
	 * @param action the action that specifies the text, tooltip, image, etc. for the item
	 * @param rm the resource manager used for any images or colors
	 * @return the tool item parameter
	 */
	public static ToolItem decorate(ToolItem ti, int style, UIAction action, ResourceManager rm) {
		if (Utilities.isOn(style, IMAGE) || !Utilities.isOn(style, TEXT)) {
			Image img = rm.getImage(action.getImage());
			if (img != null) { ti.setImage(img); }
		}
		if (Utilities.isOn(style, TEXT)) {
			ti.setText(action.getName());
			ti.setToolTipText(action.getDescription());
		} else {
			StringBuilder sb = new StringBuilder(action.getName());
			if (action.getDescription() != null) {
				sb.append(System.lineSeparator()).append(action.getDescription());
			}
			ti.setToolTipText(sb.toString());
		}

		ti.setData(action);
		return ti;
	}

	private static final int DEF_SEP_WIDTH = 12;
	/**
	 * Convenience method that creates a vertical separator item on a toolbar.
	 * @param tools the toolbar
	 * @return the separator item
	 */
	public static ToolItem separator(ToolBar tools) {
		return SWTBuilders.build(b ->
			b.toolItem(tools, SWT.SEPARATOR)
			 .separatorWidth(DEF_SEP_WIDTH)
			 .separatorContent(b.label(tools, SWT.SEPARATOR | SWT.VERTICAL).get()).get());
	}

	/**
	 * Create a new tab item using the specified action to style the item's
	 * text, tooltip and image.
	 * @param tabs the tab folder
	 * @param action the action
	 * @param rm the resource manager used for any images
	 * @return the new tab item
	 */
	public static TabItem item(TabFolder tabs, UIAction action, ResourceManager rm) {
		TabItem ti = new TabItem(tabs, SWT.NONE);
		ti.setText(action.getName());
		ti.setToolTipText(Objects.toString(action.getDescription(), null));

		Image img = rm.getImage(action.getImage());
		if (img != null) { ti.setImage(img); }
		return ti;
	}

	/**
	 * Creates a button for the specified action.
	 * @param parent the parent composite in which to create the button
	 * @param style the style of the button (of the supported styles in {@link Button}), as
	 * well as the at least one of the following custom style bits:<ul>
	 * <li>{@link SWTUtilities#TEXT}  - the name of the action should be the button text</li>
	 * <li>{@link SWTUtilities#IMAGE} - the image of the action should be the button image</li></ul>
	 * @param action the action that specifies the text, tooltip, image, etc. for the item
	 * @param rm the resource manager used for any images or colors
	 * @param sel the selection listener that will be notified when the item is clicked
	 * @return the initialized button
	 */
	public static Button button(Composite parent, int style, UIAction action, ResourceManager rm, SelectionListener sel) {
		Button b = new Button(parent, style);
		if (sel != null) { b.addSelectionListener(sel); }
		return decorate(b, style, action, rm);
	}

	/**
	 * Decorates an existing button with the specified action.
	 * @param b the button
	 * @param style one or both of the following custom style bits:<ul>
	 * <li>{@link SWTUtilities#TEXT}  - the name of the action should be the button text</li>
	 * <li>{@link SWTUtilities#IMAGE} - the image of the action should be the button image</li></ul>
	 * This method does not support the {@link Button} styles since those are only used at initialization
	 * @param action the action that specifies the text, tooltip, image, etc. for the item
	 * @param rm the resource manager used for any images or colors
	 * @return the button parameter
	 */
	public static Button decorate(Button b, int style, UIAction action, ResourceManager rm) {
		if (Utilities.isOn(style, TEXT) || !Utilities.isOn(style, IMAGE)) {
			String text = action.getName();
			if (action.isMoreInputNeeded()) { text += "..."; }
			b.setText(text);
		}
		if (action.getDescription() != null) {
			b.setToolTipText(action.getDescription());
		}
		Image img = rm.getImage(action.getImage());
		if (Utilities.isOn(style, IMAGE) && img != null) {
			b.setImage(img);
		}

		b.setData(action);
		return b;
	}

	/**
	 * Attaches a resize listener to the {@link Scrollable} that adjusts the increment
	 * and page increment based on the size of the thumb. This helps prevent the
	 * increment from being too fine relative to the amount of information to be scrolled.
	 * @param scrollable the scrollable control
	 */
	public static void setScrollIncrementsOnResize(Scrollable scrollable) {
		scrollable.addControlListener(new ControlAdapter() {
			@Override
			public void controlResized(ControlEvent e) {
				Scrollable s = (Scrollable) e.widget;
				setScrollbarIncrements(s.getHorizontalBar());
				setScrollbarIncrements(s.getVerticalBar());
			}
		});
	}

	private static void setScrollbarIncrements(ScrollBar sb) {
		if (sb != null) {
			int thumb = sb.getThumb();
			sb.setPageIncrement(thumb);
			sb.setIncrement(Math.max(1, thumb / 5));
		}
	}

	/**
	 * Gets a listener that will propagate the traversal unless the {@code Ctrl} key is pressed.
	 * Some controls, like multi-line text boxes, will consume tabs or carriage returns. Adding this
	 * listener will perform the traversal unless overridden by the user.
	 * @return a traverse listener
	 */
	public static TraverseListener getTraverseListener() { return KEY_TRAVERSED; }
	private static final TraverseListener KEY_TRAVERSED = e -> {
		if (e.detail == SWT.TRAVERSE_ARROW_NEXT || e.detail == SWT.TRAVERSE_ARROW_PREVIOUS) { return; }
		e.doit = !Utilities.isOn(e.stateMask, SWT.CTRL);
	};

	/**
	 * Fires the key event on a different control, stopping it from occurring
	 * on the original control.
	 * @param ke a key event (usually received in the handling method of a key listener)
	 * @param type the type of event that was generated (either {@link SWT#KeyDown} or
	 * {@link SWT#KeyUp})
	 * @param c the control to fire the event on instead
	 */
	public static void propagate(KeyEvent ke, int type, Control c) {
		Event e = new Event();
		e.type      = type;
		e.character = ke.character;
		e.data      = ke.data;
		e.display   = ke.display;
		e.keyCode   = ke.keyCode;
		e.stateMask = ke.stateMask;
		e.time      = ke.time;

		ke.doit = false;
		c.setFocus();
		c.getDisplay().post(e);
	}

	/**
	 * Fires the mouse event on a different control.
	 * @param me a mouse event (usually received in the handling method of a mouse listener)
	 * @param type the type of event that was generated (either {@link SWT#MouseDoubleClick},
	 * {@link SWT#MouseDown}, {@link SWT#MouseEnter}, {@link SWT#MouseExit}, {@link SWT#MouseHover},
	 * {@link SWT#MouseMove}, {@link SWT#MouseUp}, or {@link SWT#MouseWheel})
	 * @param c the control to fire the event on instead
	 */
	public static void propagate(MouseEvent me, int type, Control c) {
		Event e = new Event();
		e.type      = type;
		e.button    = me.button;
		e.count     = me.count;
		e.data      = me.data;
		e.display   = me.display;
		e.stateMask = me.stateMask;
		e.time      = me.time;
		e.x         = me.x;
		e.y         = me.y;

		c.setFocus();
		c.getDisplay().post(e);
	}

	/**
	 * Returns whether or not the user was holding down the "Shift" or the
	 * "Control" key when the event was generated.
	 * @param mask the event mask
	 * @return if the event mask contains {@link SWT#SHIFT} or {@link SWT#CTRL}
	 * @see Event#stateMask
	 */
	public static boolean isShiftOrCtrl(int mask) {
		return (mask & (SWT.SHIFT | SWT.CTRL)) > 0;
	}

	/**
	 * Returns if the current thread is a UI thread for SWT.
	 * @return if the thread is the current UI thread
	 */
	public static boolean isUIThread() {
		return Display.findDisplay(Thread.currentThread()) != null;
	}

	/**
	 * Sets the enabled state of a group  of controls in one operation.
	 * @param enabled the new enabled state
	 * @param controls the controls
	 * @see Control#setEnabled(boolean)
	 */
	public static void setEnabled(boolean enabled, Control... controls) {
		for (val c : controls) { c.setEnabled(enabled); }
	}

	/**
	 * Sets the enabled state of a group  of controls/widgets/items in one operation.
	 * @param enabled the new enabled state
	 * @param controls the controls
	 * @see Control#setEnabled(boolean)
	 */
	public static void setEnabled(boolean enabled, IEnabled<?>... controls) {
		for (val c : controls) { c.enabled(enabled); }
	}

	/**
	 * Sets the visibility of a group of controls in one operation.
	 * @param visible the visibility state
	 * @param controls the controls
	 * @see Control#setVisible(boolean)
	 */
	public static void setVisible(boolean visible, Control... controls) {
		for (Control c : controls) { c.setVisible(visible); }
	}

	private static final String BASE_FONT_KEY = "$BASE_FONT$";

	/**
	 * Scales the text size/height compared to the default font of the control.
	 * @param rm the resource manager
	 * @param c the control
	 * @param factor the factor by which to scale the size
 	 * @param recurse whether or not to recurse to the control's children
	 */
	public static void scaleText(ResourceManager rm, Control c, float factor, boolean recurse) {
		Font base = (Font) c.getData(BASE_FONT_KEY);
		if (base == null) {
			base = c.getFont();
			c.setData(BASE_FONT_KEY, base);
		}

		FontData fd = Utilities.first(base.getFontData());
		fd.setHeight(Math.round(factor * fd.getHeight()));

		Font f = new Font(rm.getDisplay(), fd);
		rm.add(f);
		c.setFont(f);

		if (recurse && (c instanceof Composite)) {
			Composite comp = (Composite) c;
			for (Control child : comp.getChildren()) {
				scaleText(rm, child, factor, recurse);
			}
		}
	}

	/**
	 * Disposes all children of the composite.
	 * @param c the composite
	 */
	public static void disposeChildren(Composite c) {
		forEachChild(c, child -> child.dispose(), false);
	}

	/**
	 * Execute the function for each child of the composite.
	 * @param c the composite
	 * @param consumer the function to execute
	 * @param recurse whether or not to recurse down the entire tree
	 */
	public static void forEachChild(Composite c, Consumer<Control> consumer, boolean recurse) {
		for (Control child : c.getChildren()) {
			consumer.accept(child);
			if (child instanceof Composite && recurse) {
				forEachChild((Composite) child, consumer, recurse);
			}
		}
	}

	/**
	 * Adds a menu item to the control's context menu (creating one if one does not exit) that offers
	 * to copy the control's text to the clipboard. This can recurse down through the UI tree starting
	 * at {@code root} and add the context menu to any matching elements.
	 * @param c the control type to match
	 * @param getText the way of accessing the text the control (usually a method {@code getText()})
	 * @param root the root control to add the context menu. This is not necessarily of type {@code C}
	 * since it could be a {@link Composite}.
	 * @param recurse whether or not to recurse down the UI tree (if {@code root} is a {@link Composite})
	 * and add context menus to all matching children
	 * @param <C> the control type
	 */
	public static <C extends Control> void addCopyContextMenu(Class<C> c, Function<C, String> getText, Control root, boolean recurse) {
		Display d = root.getDisplay();
		Clipboard cb = new Clipboard(d);
		d.disposeExec(() -> cb.dispose());

		addCopyContextMenu(c, getText, root, cb);

		if (recurse && (root instanceof Composite)) {
			forEachChild((Composite) root, child -> addCopyContextMenu(c, getText, child, cb), true);
		}
	}

	private static <C extends Control> void addCopyContextMenu(Class<C> c, Function<C, String> getText, Control root, Clipboard cb) {
		if (!c.isAssignableFrom(root.getClass())) { return; }
		C casted = Utilities.cast(root);

		Menu m = root.getMenu();
		if (m == null) {
			m = new Menu(root);
			root.setMenu(m);
		}

		MenuItem copy = new MenuItem(m, SWT.PUSH);
		copy.setText("&Copy");
		copy.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TextTransfer[] tt = {TextTransfer.getInstance()};
				cb.setContents(new String[] {getText.apply(casted)}, tt);
			}
		});
	}
}
