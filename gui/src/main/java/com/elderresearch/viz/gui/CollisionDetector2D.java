/* ©2016-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.viz.gui;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This class determines if a rectangle overlaps arbitrary two-dimensional shapes.
 *
 * @author <a href="dimeo@datamininglab.com">John Dimeo</a>
 * @param <T> the shape type
 * @since Sep 26, 2012
 */
public class CollisionDetector2D<T extends Shape2D> {
	private static final int    BINS    = 30;
	private static final int    BINS_SQ = BINS * BINS;
	private static final double EPSILON = 0.000001;
	private static final double HALF    = 0.5;

	private Rectangle2D scrBounds;
	private Rectangle2D objBounds;

	private List<List<T>> index;

	public CollisionDetector2D() {
		this.scrBounds = new Rectangle2D.Float();
		this.objBounds = new Rectangle2D.Double();
		setBounds(0.0, 0.0, 1.0, 1.0);

		index = new ArrayList<>(BINS_SQ);
		clear();
	}

	public void setBounds(double minX, double minY, double maxX, double maxY) {
		// Add epsilon so points on the edge don't trigger out-of-bounds logic due to 0-based indexing
		scrBounds.setRect(minX, minY, maxX - minX + EPSILON, maxY - minY + EPSILON);
	}

	public boolean add(T obj) {
		// Recycle the same instance- this makes this class not thread-safe,
        // but prevents significantly more work for the garbage collector
		obj.getMaxExtent(objBounds);
		return addOrRemove(obj, objBounds, true);
	}

	public boolean remove(T obj) {
		obj.getMaxExtent(objBounds);
		return addOrRemove(obj, objBounds, false);
	}

	public void update(T obj, Rectangle2D oldBounds) {
		addOrRemove(obj, oldBounds, false);
		add(obj);
	}

	private boolean addOrRemove(T obj, Rectangle2D bounds, boolean add) {
		int l = getBin(bounds.getMinX(), scrBounds.getX(), scrBounds.getWidth());
		int b = getBin(bounds.getMinY(), scrBounds.getY(), scrBounds.getHeight());
		int r = getBin(bounds.getMaxX(), scrBounds.getX(), scrBounds.getWidth());
		int t = getBin(bounds.getMaxY(), scrBounds.getY(), scrBounds.getHeight());

		if (r < 0)     { return false; }
		if (l < 0)     { l = 0;        }
		if (l >= BINS) { return false; }
		if (r >= BINS) { r = BINS - 1; }

		if (t < 0)     { return false; }
		if (b < 0)     { b = 0;        }
		if (b >= BINS) { return false; }
		if (t >= BINS) { t = BINS - 1; }

		boolean changed = false;
		synchronized (index) {
			for (int x = l; x <= r; x++) {
				for (int y = b; y <= t; y++) {
					List<T> list = index.get(getBin(x, y));
					if (add) {
						changed |= list.add(obj);
					} else {
						changed |= list.remove(obj);
					}
				}
			}
		}
		return changed;
	}

	public Set<T> getHits(Rectangle2D bounds) {
		Set<T> hits = new HashSet<>();

		int l = getBin(bounds.getMinX(), scrBounds.getX(), scrBounds.getWidth());
		int b = getBin(bounds.getMinY(), scrBounds.getY(), scrBounds.getHeight());
		int r = getBin(bounds.getMaxX(), scrBounds.getX(), scrBounds.getWidth());
		int t = getBin(bounds.getMaxY(), scrBounds.getY(), scrBounds.getHeight());

		if (r < 0)     { return hits;  }
		if (l < 0)     { l = 0;        }
		if (l >= BINS) { return hits;  }
		if (r >= BINS) { r = BINS - 1; }

		if (t < 0)     { return hits;  }
		if (b < 0)     { b = 0;        }
		if (b >= BINS) { return hits;  }
		if (t >= BINS) { t = BINS - 1; }

		synchronized (index) {
			for (int x = l; x <= r; x++) {
				for (int y = b; y <= t; y++) {
					List<T> bin = index.get(getBin(x, y));
					if (bin == null) { continue; }

					for (T obj : bin) {
						if (obj.intersects(bounds)) {
							hits.add(obj);
						}
					}
				}
			}
		}
		return hits;
	}

	public void clear() {
		synchronized (index) {
			index.clear();
			for (int i = 0; i < BINS_SQ; i++) {
				index.add(new ArrayList<>());
			}
		}
	}

	private static int getBin(int binx, int biny) {
		return binx + biny * BINS;
	}
	private static int getBin(double d, double offset, double length) {
		return (int) Math.floor((d - offset) * (BINS / length));
	}

	/**
	 * Convenience method to test if a circle intersects with a rectangle.
	 * @param centerX the center x-coordinate of the circle
	 * @param centerY the center y-coordinate of the circle
	 * @param radius the radius of the circle
	 * @param bounds the rectangle to test
	 * @return if the circle intersects the rectangle at any point
	 */
	public static boolean circleIntersects(double centerX, double centerY,
			double radius, Rectangle2D bounds) {
		double w = HALF * bounds.getWidth();
		double h = HALF * bounds.getHeight();

	    double dx = Math.abs(centerX - bounds.getX() - w);
	    double dy = Math.abs(centerY - bounds.getY() - h);

	    // Handle when the circle is clearly outside the rectangle
	    if (dx > w + radius || dy > h + radius) { return false; }

	    // Handle when the circle is clearly inside the rectangle
	    if (dx <= w || dy <= h) { return true; }

	    // Handle when the bounding intersects the rectangle, but the circle
	    // may or may not
	    dx -= w; dx *= dx;
	    dy -= h; dy *= dy;
	    return dx + dy <= radius * radius;
	}
}
