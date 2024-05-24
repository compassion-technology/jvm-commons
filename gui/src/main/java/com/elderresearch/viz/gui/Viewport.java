/* ©2016-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.viz.gui;

import java.awt.geom.Rectangle2D;

import com.compassion.commons.Utilities;

import lombok.EqualsAndHashCode;

/**
 * Translates between a coordinate space and screen pixels. The coordinate space
 * can have arbitrary bounds, with increasing y-axis values usually going "up".
 * The screen viewport usually has an origin in the top left, is the same
 * size as the viewable region of the coordinate space in pixels, and is
 * going "down" for increasing y-axis values.
 *
 * @author <a href="mailto:dimeo@datamininglab.com">John Dimeo</a>
 * @since Sep 8, 2014
 */
@EqualsAndHashCode
public class Viewport {
	// Initialize with non-zero width/height to avoid divide-by-zero
	private Rectangle2D coord  = new Rectangle2D.Double(0.0, 0.0, 1.0, 1.0);
	private Rectangle2D screen = new Rectangle2D.Double(0.0, 0.0, 1.0, 1.0);

	public void setScreen(Rectangle2D screen) {
		this.screen.setFrame(screen);
	}
	public void setScreen(double x, double y, double width, double height) {
		screen.setFrame(x, y, width, height);
	}

	public void setCoordinates(Rectangle2D coord) {
		this.coord.setFrame(coord);
	}
	public void setCoordinates(double x, double y, double width, double height) {
		coord.setFrame(x, y, width, height);
	}

	public Rectangle2D getCoordinates() { return coord; }
	public Rectangle2D getScreen()      { return screen; }

	private ViewportTransform toCoord  = new ViewportTransform(screen, coord);
	private ViewportTransform toScreen = new ViewportTransform(coord, screen);

	public ViewportTransform toCoordinates() { return toCoord; }
	public ViewportTransform toScreen()      { return toScreen; }

	public Viewport copy() {
		Viewport copy = new Viewport();
		copy.setCoordinates(getCoordinates());
		copy.setScreen(getScreen());
		return copy;
	}

	public static final class ViewportTransform {
		private Rectangle2D from, to;

		private ViewportTransform(Rectangle2D from, Rectangle2D to) {
			this.from = from; this.to = to;
		}

		public double scaleX(double value) {
			double norm = Utilities.normalize(value, 0.0, from.getWidth());
			return Utilities.linterp(norm, 0.0, to.getWidth());
		}

		public double toX(double value) {
			return scaleX(value - from.getX()) + to.getX();
		}

		public double scaleY(double value) {
			double norm = Utilities.normalize(value, 0.0, from.getHeight());
			return Utilities.linterp(norm, 0.0, to.getHeight());
		}

		public double toY(double value) {
			return to.getHeight() - scaleY(value - from.getY()) + to.getY();
		}
	}
}
