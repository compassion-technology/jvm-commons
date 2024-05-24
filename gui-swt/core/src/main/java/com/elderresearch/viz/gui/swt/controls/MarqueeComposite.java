/* ©2016-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.viz.gui.swt.controls;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;

import com.elderresearch.viz.gui.Viewport;
import com.elderresearch.viz.gui.Viewport.ViewportTransform;

/**
 * <p>This is a subclass of composite that provides "marquee" selection and zooming.  Override
 * {@link #paintControl(PaintEvent)} to draw your own custom graphics on the composite and
 * override {@link #marqueeSelection(Event)} to receive events when the user selects a rectangular
 * region on the composite.</p>
 * <p>If you are drawing custom graphics on the composite, your graphics should be drawn using floating-point
 * numbers with an origin at {@code [0.0f, 0.0f]} in the range {@code [-1.0f, 1.0f]} so that the parent class
 * can handle the pan offset and zoom level for you.  Convert them to integers in the composite's coordinate
 * space by using {@link #x(float)} and {@link #y(float)} (if you need to scale a value, like the width of a
 * rectangle, use {@link #scale(float)}).  If you need to "invert" screen coordinates to the corresponding "real"
 * coordinates on the range {@code [-1.0f, 1.0f]}, use {@link #x(int)}, {@link #y(int)} and {@link #scale(int)}.
 * When overriding {@link #paintControl(PaintEvent)}, be sure to call {@code super.paintControl(e)} <i>after</i>
 * you've drawn your custom graphics so the selection rectangle appears above your graphics.</p>
 *
 * @author John Dimeo
 * @see Viewport
 */
public class MarqueeComposite extends Composite implements PaintListener, MouseMoveListener, MouseListener, ControlListener {
	private static final double HALF = 0.5;
	private static final int MIN_ZOOM_BOX_SIZE = 5;
	private static final int DEFAULT_PADDING = 12;

	private Rectangle2D defaultCoord;
	private Viewport    viewport;
	private boolean     stretchToFit;
	private int         padt, padl, padr, padb;

	private int    dh, // Horizontal drag direction (-1 left, 0 none, 1 right)
	               dv; // Vertical drag direction   (-1   up, 0 none, 1 down)

	// Top left of marquee box
	private Point  tl = new Point(0, 0),
	// Bottom right of marquee box
	               br = new Point(0, 0);

	private int    boxColor = SWT.COLOR_BLACK;
	private Cursor zoomCursor;

	private List<MarqueeListener> listeners = new ArrayList<>();

	/**
	 * Creates a new composite with marquee-selection support.
	 * @param parent the parent composite in which to create this composite
	 * @param style the style of the composite. {@link SWT#DOUBLE_BUFFERED} is always assumed and does not need
	 * to be specified.
	 */
	public MarqueeComposite(Composite parent, int style) {
		super(parent, style | SWT.DOUBLE_BUFFERED);
		padt = padl = padr = padb = DEFAULT_PADDING;

		addPaintListener(this);
		addMouseMoveListener(this);
		addMouseListener(this);
		addControlListener(this);

		defaultCoord = new Rectangle2D.Double(-1.0, -1.0, 2.0, 2.0);
		viewport = new Viewport();
		viewport.setCoordinates(defaultCoord);

		setZoomCursor(null);
	}

	/**
	 * Adds a listener that will be notified when the user selects a marquee
	 * box. The fields of the event have the dimensions of the selected box.
	 * @param listener the new listener
	 */
	public void addMarqueeListener(MarqueeListener listener) {
		listeners.add(listener);
	}

	/**
	 * Sets the color of the marquee box.  This must be one of the {@code COLOR_}
	 * constants in {@link SWT}.
	 * @param color the color of the marquee box
	 */
	public void setBoxColor(int color) { boxColor = color; }

	/**
	 * Sets the size of the whitespace placed between the edge of the composite and the inner
	 * content.
	 * @param top the top padding in pixels
	 * @param right the right padding in pixels
	 * @param bottom the bottom padding in pixels
	 * @param left the left padding in pixels
	 */
	public void setPadding(int top, int right, int bottom, int left) {
		padt = top; padr = right; padb = bottom; padl = left;
	}

	protected int getPaddingTop() { return padt; }
	protected int getPaddingLeft() { return padl; }
	protected int getPaddingRight() { return padr; }
	protected int getPaddingBottom() { return padb; }

	/**
	 * By default, the width of the coordinate window is adjusted to maintain the
	 * same aspect ratio.  If this is {@code true}, the coordinate window will remain
	 * fixed and adjust as the composite is resized.
	 * @param stretch whether or not the composite should stretch the coordinate
	 * window to fit the client area (thus changing the aspect ratio)
	 */
	public void setStretchToFit(boolean stretch) { stretchToFit = stretch; }

	/**
	 * Sets the cursor that is displayed when the user is performing a marquee zoom.
	 * @param c the cursor to use when the user is performing a marquee zoom
	 * (or {@code null} to use the default {@link SWT#CURSOR_SIZEALL} cursor)
	 */
	public void setZoomCursor(Cursor c) {
		zoomCursor = c == null? getDisplay().getSystemCursor(SWT.CURSOR_SIZEALL) : c;
	}

	/**
	 * Sets the coordinate extent for the composite.  These ranges determine how to
	 * convert the screen window into coordinate space as the user pans/zooms.
	 * @param coord the coordinate window
	 */
	public void setCoordinates(Rectangle2D coord) {
		defaultCoord.setFrame(coord);
		reset();
	}

	/**
	 * Gets the current viewport of the composite, which contains the current
	 * coordinate window and the current screen size.
	 * @return the viewport
	 */
	public Viewport getViewport() { return viewport; }

	protected Rectangle2D getDefaultCoordinates() { return defaultCoord; }
	protected boolean isDragging() { return dh != 0 || dv != 0; }

	@Override
	public void controlResized(ControlEvent e) {
		Point size = super.getSize();
		int w = size.x - padl - padr;
		int h = size.y - padt - padb;

		if (!stretchToFit) {
			if (w < h) {
				viewport.setScreen(padl, HALF * (h - w) + padt, w, w);
			} else {
				viewport.setScreen(HALF * (w - h) + padl, padt, h, h);
			}
		} else {
			viewport.setScreen(padl, padt, w, h);
		}
	}

	@Override
	public void paintControl(PaintEvent e) {
		if (isDragging()) {
			e.gc.setLineWidth(1);
			e.gc.setForeground(e.display.getSystemColor(boxColor));
			e.gc.setLineStyle(SWT.LINE_DASH);
			e.gc.drawRectangle(tl.x, tl.y, br.x - tl.x, br.y - tl.y);
		}
	}

	/**
	 * Resets the view to the default zoom level that will fill the client area completely.
	 * This also occurs when the user double-clicks the mouse.
	 */
	public void reset() {
		viewport.setCoordinates(defaultCoord);
		for (MarqueeListener l : listeners) {
			l.viewportChanged(viewport);
		}

		controlResized(null);
		redraw();
	}

	@Override
	public void mouseDoubleClick(MouseEvent e) {
		if (e.button > 1) { reset(); }
	}

	@Override
	public void mouseDown(MouseEvent e) {
		dv = 1;
		dh = 1;
		tl.x = e.x;
		br.x = e.x;
		tl.y = e.y;
		br.y = e.y;

		if (e.button > 1) { setCursor(zoomCursor); }
	}

	@Override
	public void mouseUp(MouseEvent e) {
		mouseMove(e);
		setCursor(e.display.getSystemCursor(SWT.CURSOR_ARROW));

		dv = 0;
		dh = 0;
		int w = br.x - tl.x;
		int h = br.y - tl.y;

		if (e.button > 1) {
			// Don't allow a super small zoom box
			if (w < MIN_ZOOM_BOX_SIZE || h < MIN_ZOOM_BOX_SIZE) { return; }

			ViewportTransform toCoord = viewport.toCoordinates();
			double x1 = toCoord.toX(tl.x);
			double y1 = toCoord.toY(tl.y);
			double x2 = toCoord.toX(br.x);
			double y2 = toCoord.toY(br.y);

			double dx = Math.abs(x2 - x1);
			double dy = Math.abs(y2 - y1);
			if (!stretchToFit) {
				if (dx < dy) {
					y1 -= HALF * (dy - dx);
					dy = dx;
				} else {
					x1 += HALF * (dx - dy);
					dx = dy;
				}
			}

			viewport.setCoordinates(x1, y2, dx, dy);

			for (MarqueeListener l : listeners) {
				l.viewportChanged(viewport);
			}

			redraw();
		} else {
			Event se = new Event();
			se.data      = e.data;
			se.display   = e.display;
			se.time      = e.time;
			se.widget    = this;
			se.x         = tl.x;
			se.y         = tl.y;
			se.width     = w;
			se.height    = h;
			se.stateMask = e.stateMask;
			for (MarqueeListener ml : listeners) {
				ml.marqueeSelection(se);
			}
		}
	}

	@Override
	public void mouseMove(MouseEvent e) {
		if (!isDragging()) { return; }

		int tlx = tl.x, tly = tl.y, brx = br.x, bry = br.y;

		if (dh < 0) {					// Currently dragging LEFT
			if (e.x <= br.x) {			// Still dragging LEFT
				tl.x = e.x;
				if (e.x < tlx) tlx = e.x;
			} else {					// Now dragging RIGHT (handled below)
				tl.x = br.x;			// Rightmost point is now leftmost
				dh = 1;
			}
		} else if (dh > 0) {			// Currently dragging RIGHT
			if (e.x >= tl.x) {			// Still dragging RIGHT
				br.x = e.x;
				if (e.x > brx) brx = e.x;
			} else {					// Now dragging LEFT (already tested for this above)
				br.x = tl.x;			// Leftmost point is now rightmost
				dh = -1;
				mouseMove(e);			// Re-enter the method to handle LEFT drag
			}
		}
		if (dv < 0) {					// Currently dragging UP
			if (e.y <= br.y) {			// Still dragging UP
				tl.y = e.y;
				if (e.y < tly) tly = e.y;
			} else {					// Now dragging DOWN (handled below)
				tl.y = br.y;			// Bottommost point is now topmost
				dv = 1;
			}
		} else if (dv > 0) {			// Currently dragging DOWN
			if (e.y >= tl.y) {			// Still dragging DOWN
				br.y = e.y;
				if (e.y > bry) bry = e.y;
			} else {					// Now dragging UP (already tested for this above)
				br.y = tl.y;			// Topmost point is now bottommost
				dv = -1;
				mouseMove(e);			// Re-enter the method to handle UP drag
			}
		}

		// Re-draw the union of the previous box and the current box
		redraw(tlx - 1, tly - 1, brx - tlx + 2, bry - tly + 2, true);
	}

	@Override
	public void controlMoved(ControlEvent e) {
		// No actions should be performed for this event
	}

	public interface MarqueeListener {
		void marqueeSelection(Event e);
		void viewportChanged(Viewport viewport);
	}
}
