package com.compassion.commons.gui;

import java.awt.geom.Rectangle2D;

public interface Shape2D {
	void getMaxExtent(Rectangle2D bounds);
	void getMinExtent(Rectangle2D bounds);
	boolean intersects(Rectangle2D bounds);
}
