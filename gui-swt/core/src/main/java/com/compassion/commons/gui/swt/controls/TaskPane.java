package com.compassion.commons.gui.swt.controls;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;
import java.util.function.Consumer;

import org.apache.commons.lang3.mutable.MutableInt;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

import com.compassion.commons.gui.swt.controls.builders.SWTBuilders;
import com.compassion.commons.gui.swt.events.MouseDownLambda;
import com.compassion.commons.gui.swt.events.ResizeLambda;
import com.compassion.commons.gui.swt.events.SelectionLambda;
import com.compassion.commons.gui.swt.util.ResourceManager;
import com.compassion.commons.gui.swt.util.SWTUtilities;
import com.elderresearch.commons.icons.eri.IconsERI;
import com.elderresearch.commons.icons.ms.IconsMS;

import lombok.val;

/**
 * A task pane mimics the functionality found in Microsoft Office products since Office 2002.
 * The task pane is a composite with arrows, a heading, close button, and children composites,
 * and is usually docked on the right-hand side of the screen.  The user can cycle through
 * the composite children, which should offer common tasks and duplicate menu and toolbar
 * functionality.  A task pane is a set of {@link Pane}s. The following example adds a task
 * pane to a {@link SashForm}, which is recommended to allow the user to dynamically adjust
 * the size of the task pane:<br><pre>
 * TaskPane pane = new {@link #TaskPane(ResourceManager, Composite, int, MouseListener) TaskPane}(rm, sashForm, SWT.BORDER, new MouseAdapter() {
 *    public void mouseDown(MouseEvent e) {
 *       sashForm.setWeights(new int[] {100, 0});
 *    }
 * });
 * pane.{@link #addPane(Pane) addPane}(new Pane("Common Tasks") {
 *    public void fillPane(Composite parent) {
 *       parent.setLayout(new RowLayout(SWT.VERTICAL));
 *       Label l = new Label(parent, SWT.NONE);
 *       l.setText("Open File");
 *       Button b = new Button(parent, SWT.PUSH);
 *       ...
 *    }
 * });
 * </pre>
 * @author John Dimeo
 * @see Pane
 */
public class TaskPane extends Composite implements SWTBuilders {
	private static final int ARC_WIDTH = 5;
	
	private TreeMap<Pane, Composite> panes = new TreeMap<>();
	private ResourceManager rm;
	private Composite tasks, banner;
	private ToolItem left, right, home;
	private Combo head;
	private int curr;
	private int num;
	
	private PaintListener paint = e -> {
		Rectangle r = ((Control) e.widget).getBounds();
		e.gc.setForeground(e.display.getSystemColor(SWT.COLOR_WIDGET_BORDER));
		e.gc.drawRectangle(0, 0, r.width - 1, r.height - 1);
	};
	
	/**
	 * Creates a new task pane. Use {@link Pane} to add panes to this task pane.
	 * @param rm the resource manager on which to allocate icons
	 * @param parent the parent composite of this pane
	 * @param style the style of the pane
	 * @param close the runnable to execute when the user hides the task pane.
	 * The pane doesn't know how to hide itself, so this parameter is required.
	 */
	public TaskPane(final ResourceManager rm, Composite parent, int style, final Runnable close) {
		super(parent, style);
		this.rm = rm;
		GridLayout layout = new GridLayout(3, false);
		layout.marginWidth = layout.marginHeight = 2;
		layout.horizontalSpacing = 0;
		layout.verticalSpacing = 0;
		setLayout(layout);
		
		head = new Combo(this, SWT.FLAT | SWT.READ_ONLY);
		head.setLayoutData(gridData().hFill().vAlign(SWT.BOTTOM).hSpan(2).get());
		head.setFont(rm.getFont(8, SWT.BOLD));
		head.setText("Task Pane");
		head.addSelectionListener((SelectionLambda) e -> {
			String name = head.getText();
			for (Entry<Pane, Composite> entry : panes.entrySet()) {
				if (entry.getKey().getName().equals(name)) {
					setVisiblePane(entry.getKey());
				}
			}
		});
		
		val hide = label(this)
				.tooltip("Close")
				.image(rm.getImage(IconsERI.CLOSE))
				.layoutData(gridData().hIndent(3))
				.get();
		hide.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				hide.setBackground(rm.getColor(-24));
				hide.addPaintListener(paint);
			}
			@Override
			public void mouseExit(MouseEvent e) {
				hide.setBackground(rm.getColor(0));
				hide.removePaintListener(paint);
			}
		});
		hide.addMouseListener((MouseDownLambda) e -> close.run());
		
		ToolBar bar = new ToolBar(this, SWT.NONE);
		bar.setBackground(rm.getColor(-18));
		
		left = new ToolItem(bar, SWT.PUSH);
		left.setImage(rm.getImage(IconsMS.ARROW_LEFT_GREEN_CIRCLE));
		left.setDisabledImage(rm.getImage(IconsERI.ARROW_LEFT_GREEN_CIRCLE_GRAY));
		left.setEnabled(false);
		left.setToolTipText("Back");
		left.addSelectionListener((SelectionLambda) e -> setVisiblePane(curr - 1));
		
		right = new ToolItem(bar, SWT.PUSH);
		right.setImage(rm.getImage(IconsMS.ARROW_RIGHT_GREEN_CIRCLE));
		right.setDisabledImage(rm.getImage(IconsERI.ARROW_RIGHT_GREEN_CIRCLE_GRAY));
		right.setEnabled(false);
		right.setToolTipText("Forward");
		right.addSelectionListener((SelectionLambda) e -> setVisiblePane(curr + 1));
		
		home = new ToolItem(bar, SWT.PUSH);
		home.setImage(rm.getImage(IconsMS.HOME));
		home.setEnabled(false);
		home.setToolTipText("Home");
		home.addSelectionListener((SelectionLambda) e -> setVisiblePane(null));
		
		bar.pack();
		banner = new Composite(this, SWT.NONE);
		banner.setLayoutData(gridData().hFill().vAlign(SWT.FILL).height(10).hSpan(2).get());
		banner.setBackground(this.getBackground());
		banner.addPaintListener(e -> {
			int width = ARC_WIDTH * 2;
			e.gc.setAntialias(SWT.DEFAULT);
			e.gc.setBackground(rm.getColor(-18));
			e.gc.fillOval(-ARC_WIDTH, e.height - width, width, width);
			e.gc.fillRectangle(0, 0, ARC_WIDTH, e.height - ARC_WIDTH);
		});
		
		tasks = composite(this).layout(stack()).layoutData(gridData().fill().hSpan(3)).get();
	}
	
	@Override
	public void setBackground(Color color) {
		banner.setBackground(color);
		super.setBackground(color);
	}
	
	private synchronized void removePane(Pane p) {
		num--;
		head.remove(p.getName());
		panes.get(p).dispose();
		panes.remove(p);
		setVisiblePane(panes.firstKey(), 0);
	}
	
	/**
	 * Sets which pane is visible in the task pane. If the index is invalid
	 * this method does nothing.
	 * @param index the index of the pane; a pane's index is determined by
	 * the order it was added to the task pane
	 */
	public void setVisiblePane(int index) {
		if (index >= num || index < 0) { return; }
		Iterator<Pane> iter = panes.keySet().iterator();
		for (int i = 0; i < index; i++) {
			iter.next();
		}
		setVisiblePane(iter.next(), index);
	}
	
	/**
	 * Sets which pane is visible in the task pane. This pane must have
	 * been added to the task pane using {@link #addPane(Pane)}.
	 * @param p the pane to make visible, or {@code null} to display
	 * the root pane
	 */
	public void setVisiblePane(Pane p) {
		Iterator<Pane> iter = panes.keySet().iterator();
		int index = -1;
		for (int i = 0; iter.hasNext(); i++) {
			Pane next = iter.next();
			if (p == next || (p == null && next.isHome())) {
				p = next; index = i; break;
			}
		}
		setVisiblePane(p, index);
	}
	
	private void setVisiblePane(Pane p, int index) {
		curr = index;
		head.setText(p.getName());
		SWTUtilities.setTopControl(panes.get(p));
		tasks.layout(true, true);
		right.setEnabled(curr < num - 1);
		left.setEnabled(curr > 0);
		home.setEnabled(!p.isHome());
	}
	
	public void addPane(String name, int style, Consumer<Composite> init) {
		addPane(new Pane(name, style) {
			@Override public void fillPane(Composite parent) { init.accept(parent); }
		});
	}
	
	/**
	 * Adds a pane to this task pane.  If the pane has the same title as an
	 * existing pane, the existing pane is replaced with {@code pane}.
	 * @param pane the pane to be added to this task pane
	 */
	public synchronized void addPane(final Pane pane) {
		{ //Uniqueness check
			List<Pane> remove = new LinkedList<>();
			for (Pane p : panes.keySet()) {
				if (p.getName().equals(pane.getName())) { remove.add(p); }
			}
			for (Pane p : remove) { removePane(p); }
		}
		
		//GUI setup
		final Composite root = new Composite(tasks, SWT.NONE);
		root.setLayout(grid().margin(0).spacing(0).get());
		final Label up = new Label(root, SWT.FLAT | SWT.CENTER);
			up.setLayoutData(gridData().hFill().height(12).get());
			up.setImage(rm.getImage(IconsERI.UP_SM));
			up.setBackground(rm.getColor(-12));
			SWTUtilities.setVisibleAndIncluded(up, false);
			up.setEnabled(false);
		final Composite child = composite(root, SWT.NONE).layoutData(gridData().fill()).get();
		final Label dn = new Label(root, SWT.FLAT | SWT.CENTER);
			dn.setLayoutData(gridData().hFill().height(12).get());
			dn.setImage(rm.getImage(IconsERI.DN_SM));
			dn.setBackground(rm.getColor(-12));
			SWTUtilities.setVisibleAndIncluded(dn, false);
		pane.fillPane(child);
		
		//Scrolling code
		final MutableInt top = new MutableInt();
		child.addControlListener((ResizeLambda) e -> {
			int rootY = root.getSize().y;
			int prefY = child.computeSize(child.getSize().x, SWT.DEFAULT).y + 32;
			boolean visible = (prefY - top.intValue()) > rootY;
			SWTUtilities.setVisibleAndIncluded(up, visible);
			SWTUtilities.setVisibleAndIncluded(dn, visible);
			top.setValue(0);
			scrollLayout(child, 0, up, dn);
			root.layout();
		});

		MouseTrackListener mtl = new MouseTrackAdapter() {
			private Timer t;
			@Override
			public void mouseEnter(final MouseEvent e) {
				final Runnable target = (Runnable) e.widget.getData();
				t = new Timer(true);
				t.schedule(new TimerTask() {
					@Override
					public void run() { SWTUtilities.run(e.display, target, e.widget); }
				}, 0L, 20L);
				((Control) e.widget).setBackground(rm.getColor(12));
			}
			
			@Override
			public void mouseExit(MouseEvent e) {
				((Control) e.widget).setBackground(rm.getColor(-12));
				t.cancel();
			}
		};
		
		dn.setData((Runnable) () -> {
			top.add(-2);
			scrollLayout(child, top.intValue(), up, dn);
		});
		up.setData((Runnable) () -> {
			top.add(2);
			scrollLayout(child, top.intValue(), up, dn);
		});
		dn.addMouseTrackListener(mtl);
		up.addMouseTrackListener(mtl);
		up.addPaintListener(paint);
		dn.addPaintListener(paint);
		
		//Display
		panes.put(pane, root);
		head.add(pane.getName());
		home.setEnabled(!pane.isHome());
		num++;
		
		if (pane.isHome()) {
			setVisiblePane(pane);
		} else {
			right.setEnabled(curr < num - 1);
			left.setEnabled(curr > 0);
		}
	}
	
	private static void scrollLayout(Composite c, int top, Label up, Label dn) {
		Layout layout = c.getLayout();
		if (layout instanceof GridLayout) {
			((GridLayout) layout).marginTop = top;
		} else if (layout instanceof RowLayout) {
			((RowLayout) layout).marginTop = top;
		} else if (layout instanceof FormLayout) {
			((FormLayout) layout).marginTop = top;
		} else {
			return;
		}
		
		boolean u = up.isEnabled(), d = dn.isEnabled();
		if (u != (top < 0)) {
			up.setEnabled(!u); up.redraw();
		}
		val size = c.getSize();
		if (d != (size.y < c.computeSize(size.x, SWT.DEFAULT).y)) {
			dn.setEnabled(!d); dn.redraw();
		}
		c.layout();
	}
}
