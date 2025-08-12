package com.compassion.commons.gui.swt.image;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.PaletteData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Transform;

import com.compassion.commons.Utilities;
import com.compassion.commons.gui.icons.IconSerializer;
import com.compassion.commons.gui.swt.util.ResourceManager;
import com.compassion.commons.gui.swt.util.SWTUtilities;

public class ImageFunctions {
	private ImageData data;

	/**
	 * Clamps an integer between {@code 0} and {@code 255}.
	 * @param i the integer to clamp
	 * @return the original value {@code i} if it falls within the range
	 * {@code 0 - 255}, or {@code 0} if {@code i} is less than or equal
	 * to {@code 0} or {@code 255} if {@code i} is greater than or equal to {@code 255}
	 */
	public static int clamp(int i) { return Utilities.clamp(i, 0, 255); }

	private static class TextRequest {
		String text;
		int x, y, width, height;
		boolean rotate;
		String font;
		Point align;

		TextRequest(String s, String font, int x, int y, int w, int h, Point a, boolean rotate) {
			text = s; this.x = x; this.y = y;
			width = w; height = h; align = a;
			this.rotate = rotate;
			this.font   = font;
		}
	}
	private List<TextRequest> reqs = new LinkedList<>();

	/**
	 * Creates a new instance to modify the passed image data.<br>
	 * <b>Important:</b> Modifications to this data will have no
	 * effect if the image has already been created, only if this
	 * data is used to create a new image (i.e., don't use
	 * {@link org.eclipse.swt.graphics.Image#getImageData()}
	 * for this parameter).
	 * @param data the underlying data of the image to modify
	 */
	public ImageFunctions(ImageData data) {
		this.data = data;
	}

	/**
	 * Returns a pointer to the {@link ImageData} object this instance was
	 * created around.
	 * @return this intance's image data
	 */
	public ImageData getImageData() {
		return data;
	}

	/**
	 * Fills a rectangle in an image with the specified color.
	 * @param x the <em>x</em>-coordinate of the top left corner of the rectangle
	 * @param y the <em>y</em>-coordinate of the top left corner of the rectangle
	 * @param width the width of the rectangle to fill
	 * @param height the height of the rectangle to fill
	 * @param color the background color of the rectangle to fill
	 */
	public void fillRectangle(int x, int y, int width, int height, RGB color) {
		if (x < 0 || y < 0 || x > data.width - 1 || y > data.height - 1) { return; }

		width  = Math.max(Math.min(width, data.width - x), 0);
		height = Math.max(Math.min(height, data.height - y), 0);
		int[] pixels = new int[width];
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = data.palette.getPixel(color);
		}
		for (int row = y; row < y + height; row++) {
			data.setPixels(x, row, width, pixels, 0);
		}
	}

	/**
	 * Draws a black rectangle 3 pixels thick.
	 * @param x the <em>x</em>-coordinate of the top left corner of the rectangle
	 * @param y the <em>y</em>-coordinate of the top left corner of the rectangle
	 * @param width the width of the rectangle to draw
	 * @param height the height of the rectangle to draw
	 * @param offset usually indicates the size of headers on the top and the left
	 * of the image. The rectangle will not be drawn to the left of {@code offset.x}
	 * or above {@code offset.y}
	 */
	public void drawThickRectangle(int x, int y, int width, int height, Point offset) {
		if (x > data.width - 1 || y > data.height - 1) { return; }

		boolean t = true, l = true, b = true, r = true;
		if (x < offset.x - 1) {
			width += x - offset.x;
			x = offset.x;
			l = false;
		}
		if (y < offset.y - 1) {
			height += y - offset.y;
			y = offset.y;
			t = false;
		}
		if (width > data.width - x) {
			width = data.width - x;
			r = false;
		}
		if (height > data.height - y) {
			height = data.height - y;
			b = false;
		}
		if (width < 3 || height < 3) {
			return;
		}

		int[] pixels = new int[width];
		if (t) {
			for (int row = y; row < y + 3; row++) {
				Arrays.fill(pixels, 0);
				data.setPixels(x, row, width, pixels, 0);
			}
		}
		if (b) {
			for (int row = y + height - 3; row < y + height; row++) {
				Arrays.fill(pixels, 0);
				data.setPixels(x, row, width, pixels, 0);
			}
		}
		for (int row = y; row < y + height; row++) {
			data.getPixels(x, row, width, pixels, 0);
			if (l) { pixels[0] = pixels[1] = pixels[2] = 0; }
			if (r) { pixels[width - 1] = pixels[width - 2] = pixels[width - 3] = 0; }
			data.setPixels(x, row, width, pixels, 0);
		}
	}

	/**
	 * Draws a horizontal line in an image.  This method does nothing if
	 * {@code lineWidth} is {@code 0} or less.
	 * @param x the <em>x</em>-coordinate of the starting coordinate of the line
	 * @param y the <em>y</em>-coordinate of the starting coordinate of the line
	 * @param width the width of the line (height is assumed to be {@code 1})
	 * @param color the color of the line
	 * @param lineWidth the width of the stroke (use odd widths for the best
	 * results)
	 */
	public void drawRule(int x, int y, int width, RGB color, int lineWidth) {
		if (x < 0 || y < 0 || lineWidth < 1 || x > data.width - 1 || y > data.height - 1) { return; }

		width = Math.max(Math.min(width, data.width - x), 0);
		int[] pixels = new int[width];
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = data.palette.getPixel(color);
		}
		int w = lineWidth / 2;
		for (int i = Math.max(0, y - w); i < y + w + 1 && i < data.height; i++) {
			data.setPixels(x, i, width, pixels, 0);
		}
	}

	/**
	 * Draws a vertical line in an image.  This method does nothing if
	 * {@code lineWidth} is {@code 0} or less.
	 * @param x the <em>x</em>-coordinate of the starting coordinate of the line
	 * @param y the <em>y</em>-coordinate of the starting coordinate of the line
	 * @param height the height of the line (width is assumed to be {@code 1})
	 * @param color the color of the line
	 * @param lineWidth the width of the stroke (use odd widths for the best
	 * results)
	 */
	public void drawLine(int x, int y, int height, RGB color, int lineWidth) {
		if (x < 0 || y < 0 || lineWidth < 1 || x > data.width - 1 || y > data.height - 1) { return; }

		x -= lineWidth / 2;
		if (x + lineWidth > data.width || x < 0) { return; }
		height = Math.max(Math.min(height, data.height - y), 0);
		int[] pixels = new int[lineWidth];
		for (int i = 0; i < lineWidth; i++) {
			pixels[i] = data.palette.getPixel(color);
		}
		for (int row = y; row < y + height; row++) {
			data.setPixels(x, row, lineWidth, pixels, 0);
		}
	}

	/**
	 * Draws the text at the specified position in the image. Because text drawing
	 * can only be done on an actual image, the text is not actually drawn now, but
	 * instead in {@link #getImage(ResourceManager, int, int)}.  Because of this,
	 * no guarantee can be made about the string's <em>z</em>-order (depth) in the image.
	 * @param text the string of text to draw
	 * @param font the name of the font
	 * @param x the <em>x</em>-coordinate of the starting coordinate of the text
	 * @param y the <em>y</em>-coordinate of the starting coordinate of the text
	 * @param width the maximum width of the text (text will be clipped if characters
	 * exceed this width)
	 * @param height the maximum height of the text (text will be clipped if characters
	 * exceed this width)
	 * @param align the alignment of the text; {@code align.x} is the horizontal
	 * alignment, one of {@link SWT#LEFT}, {@link SWT#CENTER}, or {@link SWT#RIGHT}.
	 * {@code align.y} is the vertical alignment, one of {@link SWT#TOP}, {@link SWT#CENTER},
	 * or {@link SWT#BOTTOM}.
	 * @param rotate whether or not to rotate the text 90&deg; clockwise*/
	public void drawText(String text, String font, int x, int y, int width, int height, Point align, boolean rotate) {
		reqs.add(new TextRequest(text, font, x, y, width, height, align, rotate));
	}

	/**
	 * Creates a new SWT image (with an opaque background) using
	 * this instance's data.
	 * @param rm the manager with which to create the image
	 * @param fontSize the size of the text in the image
	 * @param fontColor the color of the text in the image
	 * @param antialias if text should be anti-aliased or not (slow)
	 * @return the resulting image
	 */
	public Image getSWTImage(ResourceManager rm, int fontSize, RGB fontColor, boolean antialias) {
		Image ret = new Image(rm.getDisplay(), data);
		GC gc = new GC(ret);
		gc.setForeground(rm.getColor(fontColor));
		if (antialias) { gc.setTextAntialias(SWT.ON); }

		for (TextRequest req : reqs) {
			Point p = gc.textExtent(req.text);
			Transform t = new Transform(rm.getDisplay(),
					1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f);
			t.translate(req.x, req.y);
			if (req.rotate) {
				t.translate(0.0f, req.height);
				int temp   = req.width;
				req.width  = req.height;
				req.height = temp;
			}
			float dx = 0.0f, dy = 0.0f;
			if (req.align.x == SWT.RIGHT) {
				dx =  req.width  - p.x;
			}
			if (req.align.x == SWT.CENTER) {
				dx = (req.width  - p.x) * 0.5f;
			}
			if (req.align.y == SWT.BOTTOM) {
				dy =  req.height - p.y;
			}
			if (req.align.y == SWT.CENTER) {
				dy = (req.height - p.y) * 0.5f;
			}
			if (req.rotate) {
				t.rotate(-90.0f);
			}
			t.translate(dx, dy);
			gc.setTransform(t);
			gc.setClipping(0, 0, req.width, req.height);
			gc.setFont(rm.getFont(fontSize, SWT.NORMAL));
			gc.drawText(req.text, 0, 0, true);
			t.dispose();
		}
		reqs.clear();
		gc.dispose();
		return ret;
	}

	/**
	 * Creates a new AWT image (with an opaque background) using
	 * this instance's data.
	 * @param fontSize the size of the text in the image
	 * @param fontColor the color of the text in the image
	 * @param antialias if text should be anti-aliased or not (slow)
	 */
	public BufferedImage getAWTImage(int fontSize, Color fontColor, boolean antialias) {
		BufferedImage bi = getAWTImage(data);
		Graphics2D g = bi.createGraphics();
		AffineTransform original = g.getTransform();
		if (antialias) {
			g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
						  	   RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		}
		g.setColor(fontColor);

		for (TextRequest req : reqs) {
			g.setFont(new Font(req.font, Font.BOLD, Math.max(fontSize, 4)));
			g.setTransform(original);

			String[] s;
			if (req.text.contains("\n")) {
				s = req.text.split(Pattern.quote("\n"));
			} else {
				s = new String[] {req.text};
			}
			int    w = 0, h = 0;
			double x = 0, y = 0;
			for (int i = 0; i < s.length; i++) {
				Rectangle2D bounds = g.getFontMetrics().getStringBounds(s[i], g);
				if (bounds.getWidth()  > w) {
					w = (int) Math.round(bounds.getWidth());
				}
				if (bounds.getHeight() > h) {
					h = (int) Math.round(bounds.getHeight());
				}
				if (i == 0) {
					x = bounds.getX(); y = bounds.getY();
				}
			}

			g.translate(req.x, req.y);
			if (req.rotate) {
				g.translate(0.0f, req.height);
				int temp   = req.width;
				req.width  = req.height;
				req.height = temp;
			}

			int dx = 0, dy = 0;
			if (req.align.x == SWT.RIGHT) {
				dx = req.width - w;
			}
			if (req.align.x == SWT.CENTER) {
				dx = (req.width - w) / 2;
			}
			if (req.align.y == SWT.BOTTOM) {
				dy = req.height - (h * s.length);
			}
			if (req.align.y == SWT.CENTER) {
				dy = (req.height - (h * s.length)) / 2;
			}
			if (req.rotate) {
				g.rotate(-Math.PI / 2.0);
			}
			g.setClip(0, 0, req.width, req.height);
			g.translate(dx - x, dy - y);
			for (int i = 0; i < s.length; i++) {
				g.drawString(s[i], 0, i * h);
			}
		}
		reqs.clear();
		g.dispose();
		return bi;
	}

	private static Map<String, Integer> extMap = new HashMap<>();
	static {
		extMap.put(".bmp",  SWT.IMAGE_BMP);
		extMap.put(".jpg",  SWT.IMAGE_JPEG);
		extMap.put(".jpeg", SWT.IMAGE_JPEG);
		extMap.put(".ico",  SWT.IMAGE_ICO);
		extMap.put(".gif",  SWT.IMAGE_GIF);
	}

	/**
	 * Inspects a file name and returns the corresponding SWT image
	 * type.
	 * @param name the name of the file
	 * @return the integer constant corresponding to the file's type,
	 * or {@link SWT#IMAGE_UNDEFINED} if the file type is not a supported
	 * image type
	 * @see SWT#IMAGE_BMP
	 * @see SWT#IMAGE_PNG
	 * @see SWT#IMAGE_GIF
	 * @see SWT#IMAGE_ICO
	 * @see SWT#IMAGE_JPEG
	 */
	public static int getImageType(String name) {
		if (!name.contains(".")) { return SWT.IMAGE_PNG; }
		Integer type = extMap.get(name.substring(name.lastIndexOf('.')).toLowerCase());
		return type == null? SWT.IMAGE_UNDEFINED : type;
	}

	/**
	 * Converts the SWT image data to an AWT {@link BufferedImage} instance. This
	 * method assumes {@link BufferedImage#TYPE_INT_ARGB}.
	 * @param data the image data to convert
	 * @return the equivalent AWT image
	 */
	public static BufferedImage getAWTImage(ImageData data) {
		BufferedImage bi = new BufferedImage(data.width, data.height, BufferedImage.TYPE_INT_ARGB);
		for (int y = 0; y < data.height; y++) {
			for (int x = 0; x < data.width; x++) {
				int a   = data.getAlpha(x, y);
				RGB rgb = SWTUtilities.colorToRGB(data.getPixel(x, y));
				bi.setRGB(x, y, new Color(rgb.red, rgb.green, rgb.blue, a).getRGB());
			}
		}
		return bi;
	}

	/**
	 * Converts a serialized string icon to an SWT image data instance.
	 * @param icon the icon to convert
	 * @param mode the mode of the of the returned image
	 * @return SWT image data
	 */
	public static ImageData getSWTIcon(String icon, ImageMode mode) {
		int[][] pixels = IconSerializer.deserialize(icon);
		if (pixels == null) { return null; }

		PaletteData pd = new PaletteData(0xFF0000, 0xFF00, 0xFF);
		ImageData   id = new ImageData(pixels[0].length, pixels.length, 32, pd);

		for (int y = 0; y < pixels.length; y++) {
			for (int x = 0; x < pixels[y].length; x++) {
				int p = pixels[y][x];
				id.setAlpha(x, y, (p >>> 24) & 0xFF);

				switch (mode) {
					case GRAYSCALE:
					    RGB rgb = pd.getRGB(p);
					    int lum = Math.round(0.3f * rgb.red + 0.59f  * rgb.green + 0.11f * rgb.blue);
					    id.setPixel(x, y, lum | (lum << 8) | (lum << 16));
						break;
					case NORMAL: default:
						id.setPixel(x, y, p & 0xFFFFFF);
						break;
				}
			}
		}
		return id;
	}

	public enum ImageMode { NORMAL, GRAYSCALE }
}
