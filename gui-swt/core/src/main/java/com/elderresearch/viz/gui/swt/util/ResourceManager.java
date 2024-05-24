/* ©2016-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.viz.gui.swt.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.RGBA;
import org.eclipse.swt.graphics.Resource;
import org.eclipse.swt.widgets.Display;
import org.jooq.lambda.Seq;

import com.compassion.commons.Utilities;
import com.elderresearch.commons.icons.utils.IconSerializer;
import com.elderresearch.viz.gui.swt.image.ImageFunctions;
import com.elderresearch.viz.gui.swt.image.ImageFunctions.ImageMode;
import com.elderresearch.viz.gui.swt.image.ImageScaler;
import com.elderresearch.viz.gui.swt.image.ImageScaler.SamplingMethod;

import lombok.val;
import lombok.extern.log4j.Log4j2;


/**
 * This class handles resources for an SWT application, which enforces the call
 * to {@code dispose()} when images, fonts, and colors are no longer needed.
 * One resource manager should be instantiated for each SWT display, and all of
 * this manager's resources will be disposed when {@link #run()} is called,
 * or if any shell this manager is listening to is closed.
 * @author John Dimeo
 */
@Log4j2
public class ResourceManager implements Runnable {
	private static final int MAX_IMAGES_PER_FILE = 32;

	public static final String DEFAULT_COLOR     = "default";
	public static final String DEFAULT_FONT      = "default";
	public static final String DEFAULT_FONT_BOLD = "bold";

	private Display d;
	private Map<Integer, Resource> resources = new HashMap<>();

	/**
	 * Initializes a new resource manager and attaches it to the display
	 * so that resources will automatically dispose when the display
	 * is about to dispose (see {@link Display#disposeExec(Runnable)}).
	 * @param d the display on which to allocate resources
	 */
	public ResourceManager(Display d) {
		this.d = d;

		// Create some commonly used defaults for convenience
		put(DEFAULT_FONT,  d.getSystemFont());
		put(DEFAULT_COLOR, d.getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));

		FontData data = d.getSystemFont().getFontData()[0];
		put(DEFAULT_FONT_BOLD, new Font(d, data.getName(), data.getHeight(), SWT.BOLD));

		d.disposeExec(this);
	}

	@SuppressWarnings("unchecked")
	private <R extends Resource> R get(String key, Class<R> c) {
		if (resources == null) { throw new IllegalStateException("This resource manager has been disposed."); }
		synchronized (resources) {
			return (R) resources.get(getKey(c, key));
		}
	}
	private <R extends Resource> void put(String key, R resource) {
		if (resources == null) { throw new IllegalStateException("This resource manager has been disposed."); }
		synchronized (resources) {
			resources.put(getKey(resource.getClass(), key), resource);
		}
	}
	private <R extends Resource> Resource remove(String key, Class<R> c) {
		if (resources == null) { throw new IllegalStateException("This resource manager has been disposed."); }
		synchronized (resources) {
			return resources.remove(getKey(c, key));
		}
	}
	private static int getKey(Class<?> c, String key) {
		return Objects.hash(c.getName(), key);
	}

	/**
	 * Use this to manually dispose a resource if you are certain you no
	 * longer need it.  This resource will be disposed and removed from this
	 * manager's managed resources.
	 * @param resource the resource to dispose
	 */
	public void dispose(final Resource resource) {
		resource.dispose();
		Seq.seq(resources.entrySet()) // TODO: May throw a concurrent mod exception
			.findFirst($ -> $.getValue() == resource)
			.ifPresent($ -> resources.remove($.getKey()));
	}

	/**
	 * Manually adds a resource to this manager so that it will be disposed
	 * when the other resources managed by this manager are disposed.
	 * @param resource the resource, created outside this manager, to be
	 * managed by this manager
	 */
	public void add(Resource resource) {
	    resources.put(resource.hashCode(), resource);
	}

	/**
	 * Creates a new image in memory from any of the following sources:<ul>
	 * <li>An actual {@link Image} instance</li>
	 * <li>An {@link ImageData} instance</li>
	 * <li>Or, most commonly, an icon that has been serialized as a string (see
	 * {@link IconSerializer#isSerializedIcon(String)}</li></ul>
	 * Always use this function so the program knows what resources to release on exit.
	 * @param image the image encoded as a string
	 * @return the image loaded into memory, or {@code null} if the
	 * string did not contain valid image data
	 */
	public Image getImage(Object image) {
		return getImage(image, ImageMode.NORMAL);
	}

	/**
	 * Creates a new image in memory whose image data has
	 * been encoded as a string. Always use this function so
	 * that the program knows what resources to release on exit.
	 * @param image the image encoded as a string
	 * @param mode the image mode (for example, {@link ImageMode#GRAYSCALE})
	 * @return the image loaded into memory, or {@code null} if the
	 * string did not contain valid image data
	 */
	public Image getImage(Object image, ImageMode mode) {
		if (image == null) { return null; }

		if (image instanceof Image) {
			return (Image) image;
		}
		if (image instanceof ImageData) {
			return getImage((ImageData) image);
		}

		String imgStr = image.toString();
		if (IconSerializer.isSerializedIcon(imgStr)) {
			String key = mode + imgStr;
			Image  ret = get(key, Image.class);
			if (ret != null) { return ret; }

			ImageData id = ImageFunctions.getSWTIcon(imgStr, mode);
			if (id != null) {
				ret = new Image(d, id);
				put(key, ret);
			}
			return ret;
		}

		log.warn("Cannot interpret {} as an SWT image", image);
		return null;
	}

	/**
	 * Loads the specified image into memory. If the image is an icon
	 * with multiple images, this method loads the 16 by 16 icon with
	 * a high color depth.  Always use this function so the program knows what
	 * resources to release on exit.
	 * @param filename the name of the image file to load, including its
	 * extension. The method automatically prefixes {@code "img/"}
	 * @return the image loaded into memory, or {@code null} if the
	 * specified file did not exist
	 */
	public Image loadImage(String filename) {
		Image[] all;
		try {
			all = loadImages("img" + File.separator + filename);
		} catch (IOException e) {
			return null;
		}

		for (Image img : all) {
			ImageData id = img.getImageData();
			if (id.depth > 16 && id.width <= 16 && id.height <= 16) { return img; }
		}
		return all[0];
	}

	/**
	 * Loads all images contained in the specified file into memory. Always use
	 * this function so the program knows what resources to release on exit.
	 * @param filename the name of the image file to load, including its extension.
	 * @return all images contained in the file (for example, Windows .ico format)
	 * @throws IOException if there was a problem reading the image file
	 */
	public Image[] loadImages(String filename) throws IOException {
		Image[] ret = getImages(filename);
		if (ret != null) { return ret; }

		try (FileInputStream fis = new FileInputStream(filename)) {
			return loadImages(fis, filename);
		} catch (SWTException ex) {
			throw new IOException(ex);
		}
	}

	/**
	 * Loads all images contained in the specified resource file. Always use
	 * this function so the program knows what resources to release on exit.
	 * @param c the class name to determine the relative resource path
	 * @param resourceName the name of the resource
	 * @return all images contained in the file (for example, Windows .ico format)
	 * @throws IOException if there was a problem reading the resource file
	 * @see Utilities#getResourceOrFile(Class, String)
	 */
	public Image[] loadImages(Class<?> c, String resourceName) throws IOException {
		String key = c.getName() + "." + resourceName;
		Image[] ret = getImages(key);
		if (ret != null) { return ret; }

		try (InputStream is = Utilities.getResourceOrFile(c, resourceName)) {
			if (is == null) { throw new FileNotFoundException(resourceName); }
			return loadImages(is, key);
		} catch (SWTException ex) {
			throw new IOException(ex);
		}
	}

	private Image[] getImages(String key) {
		Image first = get(key + "0", Image.class);
		if (first == null) { return null; }

		Image[] ret = new Image[MAX_IMAGES_PER_FILE];
		ret[0] = first;
		int i = 1;
		for (; i < ret.length; i++) {
			ret[i] = get(key + i, Image.class);
			if (ret[i] == null) { break; }
		}
		return Arrays.copyOf(ret, i);
	}

	private Image[] loadImages(InputStream is, String key) {
		ImageData[] id = new ImageLoader().load(is);
		Image[] ret = new Image[id.length];
		for (int i = 0; i < ret.length; i++) {
			ret[i] = new Image(d, id[i]);
			put(key + i, ret[i]);
		}
		return ret;
	}

	/**
	 * Creates a new image in memory using the specified image data.
	 * Always use this function so the program knows what resources
	 * to release on exit.
	 * @param data the data from which to construct the image
	 * @return the image loaded into memory
	 */
	public Image getImage(ImageData data) {
		if (data == null) { return null; }

		Image img = get(data.toString(), Image.class);
		if (img == null) {
			img = new Image(d, data);
			put(data.toString(), img);
		}
		return img;
	}

	/**
	 * Constructs an image with transparency from a bitmap file and
	 * a mask file.
	 * @param image the file name of the image to load
	 * @param mask the file name of the mask image to load.  This must
	 * be the same width and height of {@code image}
	 * @return the image loaded into memory
	 */
	public Image getImage(String image, String mask) {
		String key = image + "|" + mask;
		Image ret = get(key, Image.class);
		if (ret != null) { return ret; }

		ImageLoader il = new ImageLoader();
		ImageData fid = il.load(image)[0];
		ImageData mid = il.load(mask)[0];

		for (int r = 0; r < fid.height; r++) {
			for (int c = 0; c < fid.width; c++) {
				int gray = mid.getPixel(c, r) & 0xFFFFFF;
				gray = (int) (gray / (float) 0xFFFFFF * 0xFF);
				fid.setAlpha(c, r, gray);
			}
		}

		ret = new Image(d, fid);
		put(key, ret);
		return ret;
	}

	/**
	 * Resizes an existing image. Always use this function so the program
	 * knows what resources to release on exit.
	 * @param data the original image data from which to construct the image
	 * @param w the new width (in pixels)
	 * @param h the new height (in pixels)
	 * @param m the sampling method (determines the quality of the resulting image)
	 * @return the resized image
	 */
	public Image getImage(ImageData data, int w, int h, SamplingMethod m) {
		return getImage(ImageScaler.scaleImage(data, w, h, m));
	}

	/**
	 * Creates a new image from an existing one, adding transparent padding
	 * around the image to fill the new width and height.  The {@code width}
	 * and {@code height} parameters must be greater than the image's current
	 * size for this method to have an effect.
	 * @param image the source image
	 * @param width the new width
	 * @param height the new height
	 * @return the new, padded image
	 */
	public Image padImage(Image image, int width, int height) {
		ImageData data = image.getImageData();
		if (data.width == width && data.height == height) { return image; }

		String key = "pad" + image.toString() + width + "-" + height;
		Image img = get(key, Image.class);
		if (img == null) {
			ImageData icon = new ImageData(width, height, data.depth, data.palette);
			int l = Math.max((width  - data.width)  / 2, 0);
			int t = Math.max((height - data.height) / 2, 0);
			for (int x = l; x < l + data.width; x++) {
				for (int y = t; y < t + data.height; y++) {
					icon.setPixel(x, y, data.getPixel(x - l, y - t));
					icon.setAlpha(x, y, data.getAlpha(x - l, y - t));
				}
			}
			img = new Image(d, icon);
			put(key, img);
		}
		return img;
	}

	/**
	 * Loads the specified cursor into memory. If the cursor is an icon
	 * with multiple images, this method loads the 16 by 16 icon with
	 * the highest color depth.  Always use this function so the
	 * program knows what resources to release on exit.
	 * @param image the image encoded as a string
	 * @param hx the <em>x</em>-coordinate of the cursor's hotspot
	 * @param hy the <em>y</em>-coordinate of the cursor's hotspot
	 * @param tx the <em>x</em>-coordinate of the cursor's transparent pixel, or {@code -1}
	 * if the cursor is completely opaque
	 * @param ty the <em>y</em>-coordinate of the cursor's transparent pixel, or {@code -1}
	 * if the cursor is completely opaque
	 * @return the image loaded into memory, or {@code null} if the
	 * specified file did not exist
	 */
	public Cursor getCursor(String image, int hx, int hy, int tx, int ty) {
		Cursor c = get(image, Cursor.class);
		if (c == null) {
			ImageData data = ImageFunctions.getSWTIcon(image, ImageMode.NORMAL);
			if (data != null) {
				if (tx >= 0 && ty >= 0) {
					data.transparentPixel = data.getPixel(tx, ty);
				}
				c = new Cursor(d, data, hx, hy);
				put(image, c);
			}
		}
		return c;
	}

	/**
	 * Creates the font with the specified attributes.  Always use
	 * this function so the program knows what resources to release
	 * on exit.
	 * @param name the name of the font, or {@code "default"} to
	 * get the default font
	 * @param height the size of the font
	 * @param style the style ({@link SWT#BOLD}, {@link SWT#ITALIC},
	 * or {@link SWT#NORMAL})
	 * @return the font with the specified attributes
	 */
	public Font getFont(String name, int height, int style) {
		if (DEFAULT_FONT.equals(name) || DEFAULT_FONT_BOLD.equals(name)) {
			return get(name, Font.class);
		}

		val key = name + "-" + height + "-" + style;
		Font f = get(key, Font.class);
		if (f == null) {
			f = new Font(d, name, height, style);
			put(key, f);
		}
		return f;
	}

	/**
	 * Creates a new instance of the default system font with the new
	 * size and style.
	 * @param height the size of the font
	 * @param style the style ({@link SWT#BOLD}, {@link SWT#ITALIC},
	 * or {@link SWT#NORMAL})
	 * @return the font with the specified attributes
	 */
	public Font getFont(int height, int style) {
		val fd = Utilities.first(get(DEFAULT_FONT, Font.class).getFontData());
		return getFont(fd.getName(), height, style);
	}

	/**
	 * Gets the default system font.
	 * @return the default font
	 */
	public Font getFontDefault() {
		return get(DEFAULT_FONT, Font.class);
	}

	/**
	 * Gets the default bold font.
	 * @return the bold font
	 */
	public Font getFontBold() {
		return get(DEFAULT_FONT_BOLD, Font.class);
	}

	/**
	 * Gets the color relative to the default widget background
	 * color. Always use this function so the program knows what
	 * resources to release on exit.
	 * @param delta specifies the difference in shade from the
	 * default widget color, where negative values produce darker
	 * shades, and positive values lighter shades
	 * @return the color
	 */
	public Color getColor(int delta) {
		Color c = get(DEFAULT_COLOR, Color.class);
		int r = c.getRed() + delta;
		int g = c.getGreen() + delta;
		int b = c.getBlue() + delta;
		r = ImageFunctions.clamp(r);
		g = ImageFunctions.clamp(g);
		b = ImageFunctions.clamp(b);
		return getColor(r, g, b, c.getAlpha());
	}

	/**
	 * Gets the color that is equivalent to the AWT color.
	 * @param color the AWT color
	 * @return the equivalent SWT color
	 */
	public Color getColor(java.awt.Color color) {
		if (color == null) { return null; }
		return getColor(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
	}

	/**
	 * Gets the color with the specified red, green, and blue
	 * components, between {@code 0} and {@code 255}. Always
	 * use this function so the program knows what resources
	 * to release on exit.
	 * @param red the red component
	 * @param green the green component
	 * @param blue the blue component
	 * @return the color
	 */
	public Color getColor(int red, int green, int blue) {
		return getColor(red, green, blue, 255);
	}

	/**
	 * Gets the color with the specified red, green, and blue
	 * components, between {@code 0} and {@code 255}. Always
	 * use this function so the program knows what resources
	 * to release on exit.
	 * @param red the red component
	 * @param green the green component
	 * @param blue the blue component
	 * @param alpha the alpha (transparency) component
	 * @return the color
	 */
	public Color getColor(int red, int green, int blue, int alpha) {
		red   = ImageFunctions.clamp(red);
		green = ImageFunctions.clamp(green);
		blue  = ImageFunctions.clamp(blue);
		alpha = ImageFunctions.clamp(alpha);

		String key = red + "-" + blue + "-" + green + "-" + alpha;
		Color c = get(key, Color.class);
		if (c == null || c.isDisposed()) {
			c = new Color(d, red, green, blue, alpha);
			put(key, c);
		}
		return c;
	}

	/**
	 * Gets the color with the specified RGB components.
	 * Always use this function so the program knows what
	 * resources to release on exit.
	 * @param rgb the RGB struct with the red, green, and
	 * blue components of the color
	 * @return the color
	 */
	public Color getColor(RGB rgb) {
		return getColor(rgb.red, rgb.green, rgb.blue, 255);
	}

	/**
	 * Gets the color with the specified RGB components.
	 * Always use this function so the program knows what
	 * resources to release on exit.
	 * @param rgba the RGBA struct with the red, green, blue,
	 * and alpa components of the color
	 * @return the color
	 */
	public Color getColor(RGBA rgba) {
		return getColor(rgba.rgb.red, rgba.rgb.green, rgba.rgb.blue, rgba.alpha);
	}

	/**
	 * Returns the display where this resource manager was created.
	 * @return the display of the receiver
	 */
	public Display getDisplay() {
		return d;
	}

	/** Disposes all the managed resources.*/
	@Override
	public void run() {
		// Don't dispose system-allocated defaults
		remove(DEFAULT_FONT,  Font.class);
		remove(DEFAULT_COLOR, Color.class);

		Seq.seq(resources.values()).filter(r -> !r.isDisposed()).forEach(Resource::dispose);
		log.info("Disposed {} {}.", resources.size(), Utilities.pluralizeIf("resource", resources.size()));
		resources = null;
	}
}
