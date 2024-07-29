package com.compassion.commons.gui.swt.controls.builders;

import java.util.function.Function;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Decorations;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

import com.compassion.commons.gui.swt.controls.builders.BuildMenu.BuildMenuItem;
import com.compassion.commons.gui.swt.controls.builders.BuildParent.BuildCanvas;
import com.compassion.commons.gui.swt.controls.builders.BuildParent.BuildComposite;
import com.compassion.commons.gui.swt.controls.builders.BuildTabs.BuildTabItem;
import com.compassion.commons.gui.swt.controls.builders.BuildToolbar.BuildToolbarItem;
import com.compassion.commons.gui.swt.util.ResourceManager;

public interface SWTBuilders {
	static BuildShell wrap(Shell s) { return new BuildShell(s); }
	default BuildShell shell(Display d, int style) { return wrap(new Shell(d, style)); }
	default BuildShell shell(Shell s, int style) { return wrap(new Shell(s, style)); }
	default BuildShell dialog(Shell s) { return shell(s, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL); }
	
	static BuildComposite wrap(Composite c) { return new BuildComposite(c); }
	default BuildComposite composite(Composite parent, int style) { return wrap(new Composite(parent, style)); }
	default BuildComposite composite(Composite parent) { return composite(parent, SWT.NONE); }
	
	static BuildCanvas wrap(Canvas c) { return new BuildCanvas(c); }
	default BuildCanvas canvas(Composite parent, int style) { return wrap(new Canvas(parent, style)); }
	
	static BuildGroup wrap(Group g) { return new BuildGroup(g); }
	default BuildGroup group(Composite parent) { return wrap(new Group(parent, SWT.NONE)); }
	
	static BuildSash wrap(SashForm s) { return new BuildSash(s); }
	default BuildSash sash(Composite parent, int style) { return wrap(new SashForm(parent, style)); }
	
	static BuildTabs wrap(TabFolder t) { return new BuildTabs(t); }
	default BuildTabs tabs(Composite parent) { return wrap(new TabFolder(parent, SWT.TOP)); }
	
	static BuildTabItem wrap(TabItem i) { return new BuildTabItem(i); }
	default BuildTabItem tab(TabFolder parent) { return wrap(new TabItem(parent, SWT.NONE)); }
	
	static BuildToolbar wrap(ToolBar t) { return new BuildToolbar(t); }
	default BuildToolbar toolbar(Composite parent, int style) { return wrap(new ToolBar(parent, style)); }
	default BuildToolbar toolbar(Composite parent) { return toolbar(parent, SWT.WRAP); }

	static BuildToolbarItem wrap(ToolItem i) { return new BuildToolbarItem(i); }
	default BuildToolbarItem toolItem(ToolBar parent, int style) { return wrap(new ToolItem(parent, style)); }
	default BuildToolbarItem toolItem(ToolBar parent) { return toolItem(parent, SWT.PUSH); }
	default BuildToolbarItem toolRadio(ToolBar parent) { return toolItem(parent, SWT.RADIO); }
	default BuildToolbarItem toolCheck(ToolBar parent) { return toolItem(parent, SWT.CHECK); }
	default BuildToolbarItem toolSeparator(ToolBar parent) { return toolItem(parent, SWT.SEPARATOR); }
	default BuildToolbarItem toolMenu(ToolBar parent) { return toolItem(parent, SWT.DROP_DOWN); }
	
	static BuildMenu wrap(Menu m) { return new BuildMenu(m); }
	default BuildMenu menu(Decorations parent, int style) { return wrap(new Menu(parent, style)); }
	default BuildMenu menuFor(Control parent) {
		Menu m = new Menu(parent);
		parent.setMenu(m);
		return wrap(m);
	}
	
	static BuildMenuItem wrap(MenuItem i) { return new BuildMenuItem(i); }
	default BuildMenuItem menuItem(Menu parent, int style) { return wrap(new MenuItem(parent, style)); }
	
	static BuildLabel wrap(Label l) { return new BuildLabel(l); }
	default BuildLabel label(Composite parent, int style) { return wrap(new Label(parent, style)); }
	default BuildLabel label(Composite parent) { return label(parent, SWT.WRAP); }
	default BuildLabel separator(Composite parent, int orientation) { return label(parent, SWT.SEPARATOR | orientation); }

	static BuildLink wrap(Link l) { return new BuildLink(l); }
	default BuildLink link(Composite parent) { return wrap(new Link(parent, SWT.NONE)); }
	
	static BuildButton wrap(Button b) { return new BuildButton(b); }
	default BuildButton button(Composite parent, int style) { return wrap(new Button(parent, style)); }
	default BuildButton button(Composite parent) { return button(parent, SWT.PUSH);   }
	default BuildButton toggle(Composite parent) { return button(parent, SWT.TOGGLE); }
	default BuildButton radio(Composite parent)  { return button(parent, SWT.RADIO);  }
	default BuildButton check(Composite parent)  { return button(parent, SWT.CHECK);  }
	
	static BuildText wrap(Text t) { return new BuildText(t); }
	default BuildText text(Composite parent, int style) { return wrap(new Text(parent, style)); }
	default BuildText text(Composite parent)     { return text(parent, SWT.BORDER); }
	default BuildText textArea(Composite parent) { return text(parent, SWT.BORDER | SWT.MULTI | SWT.WRAP | SWT.V_SCROLL); }
	default BuildText search(Composite parent)   { return text(parent, SWT.SEARCH); }
	default BuildText password(Composite parent) { return text(parent, SWT.PASSWORD); }
	
	static BuildSpinner wrap(Spinner sp) { return new BuildSpinner(sp); }
	default BuildSpinner spinner(Composite parent, int style) { return wrap(new Spinner(parent, style)); }
	default BuildSpinner spinner(Composite parent) { return spinner(parent, SWT.BORDER); }
	
	static <T> BuildCombo<T> wrap(Combo c) { return new BuildCombo<>(c); }
	default <T> BuildCombo<T> combo(Composite parent) { return wrap(new Combo(parent, SWT.READ_ONLY | SWT.DROP_DOWN)); }
	default <T> BuildCombo<T> comboEditable(Composite parent) { return wrap(new Combo(parent, SWT.DROP_DOWN)); }
	
	default BuildGridData gridData() { return new BuildGridData(); }
	default BuildRowData rowData() { return new BuildRowData(); }
	default BuildRowData columnData() { return new BuildRowData(); }
	
	default BuildLayoutFill  fill()       { return new BuildLayoutFill(SWT.HORIZONTAL); }
	default BuildLayoutFill  fillColumn() { return new BuildLayoutFill(SWT.VERTICAL); }
	default BuildLayoutRows  rows()       { return new BuildLayoutRows(SWT.HORIZONTAL); }
	default BuildLayoutRows  columns()    { return new BuildLayoutRows(SWT.VERTICAL); }
	default BuildLayoutForm  form()       { return new BuildLayoutForm(); }
	default BuildLayoutStack stack()      { return new BuildLayoutStack(); }
	
	default BuildMessageBox messageBox(Shell parent, int style) { return new BuildMessageBox(parent, style); }
	default BuildMessageBox messageInfo(Shell parent) { return messageBox(parent, SWT.OK | SWT.ICON_INFORMATION); }
	default BuildMessageBox messageWarn(Shell parent) { return messageBox(parent, SWT.OK | SWT.ICON_WARNING); }
	default BuildMessageBox messageError(Shell parent) { return messageBox(parent, SWT.OK | SWT.ICON_ERROR); }
	default BuildMessageBox confirm(Shell parent) { return messageBox(parent, SWT.YES | SWT.NO | SWT.ICON_QUESTION); }
	
	default WithResources withResources(ResourceManager rm) { return () -> rm; }
	
	interface WithResources extends SWTBuilders {
		ResourceManager resourceManager();
		
		default Image image(Object image) { return resourceManager().getImage(image); }
		default Color color(RGB rgb) { return resourceManager().getColor(rgb); }
		default Color color(java.awt.Color c) { return resourceManager().getColor(c); }
		default Color color(int r, int g, int b) { return resourceManager().getColor(r, g, b); }
		default Font fontDefault() { return resourceManager().getFontDefault(); }
		default Font fontBold() { return resourceManager().getFontBold(); }
		default Font font(String name, int height, int style) { return resourceManager().getFont(name, height, style); }
	}
	
	/**
	 * Sets the layout manager to be a {@link GridLayout} with the specified number of columns. To avoid magic numbers,
	 * and to better visualize the layout, you can use an array whose length represents the number of columns instead
	 * of the column count. So calling this method with {@code 3} is equivalent to calling it with {@code 1, 1, 1}.
	 * If the parameter array is empty, the layout manager will have a single column.
	 * @param cols the number of columns in the grid
	 * @return this for chaining
	 */
	default BuildLayoutGrid grid(int... cols) {
		int colCount;
		switch (cols.length) {
			case 0:  colCount = 1;           break;
			case 1:  colCount = cols[0];     break;
			default: colCount = cols.length; break;
		}
		return new BuildLayoutGrid(colCount);
	}
	
	static <T> T build(Function<SWTBuilders, T> callback) {
		return callback.apply(new SWTBuilders() {
			// Provide default instance for static usage			
		});
	}
}
