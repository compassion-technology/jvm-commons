package com.compassion.commons.gui.swt.image;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.graphics.RGB;

public final class ImageScaler {
	private static final float HALF = 0.5f;
	
	private static final RGB BLACK = new RGB(0, 0, 0);
	public enum SamplingMethod { NEAREST, BILINEAR, GAUSSIAN }
	
	private ImageScaler() {
		// Prevent initialization
	}
	
	public static void main(String[] args) {
		if (args.length < 5) {
			System.out.println("Usage: ImageScaler input_file output_file new_width"
				+ "new_height sampling (one of \"nearest\", \"bilinear\", or \"gaussian\")");
			return;
		}
		ImageLoader l = new ImageLoader();
		l.data = new ImageData[] {
			scaleImage(args[0], Integer.parseInt(args[2]), Integer.parseInt(args[3]),
					SamplingMethod.valueOf(args[4].toUpperCase()))
		};
		l.save(args[2], SWT.IMAGE_BMP_RLE);
	}
	
	public static ImageData scaleImage(String image, int width, int height) {
		return scaleImage(image, width, height, SamplingMethod.GAUSSIAN);
	}
	
	public static ImageData scaleImage(ImageData data, int width, int height) {
		return scaleImage(data, width, height, SamplingMethod.GAUSSIAN);
	}
	
	public static ImageData scaleImage(String image, int width, int height,
			SamplingMethod method) {
		ImageLoader loader = new ImageLoader();
		return scaleImage(loader.load(image)[0], width, height, method);
	}
	
	public static ImageData scaleImage(ImageData data, int width, int height,
			SamplingMethod method) {
		
		ImageData ret = new ImageData(width, height, data.depth, data.palette);
		
		// Use either the given mask, or create one from the alpha data so we can sample
		// that as well as the RGB data
		ImageData mask;
		switch (data.getTransparencyType()) {
			case SWT.TRANSPARENCY_ALPHA:
				mask = new ImageData(data.width, data.height, data.depth, data.palette);
			    RGB rgb = new RGB(0, 0, 0);
			    for (int x = 0; x < data.width; x++) {
			        for (int y = 0; y < data.height; y++) {
			            rgb.red = rgb.blue = rgb.green = data.getAlpha(x, y);
			            mask.setPixel(x, y, get(mask, rgb));
			        }
			    }
			    break;
			case SWT.TRANSPARENCY_MASK: default:
				mask = data.getTransparencyMask();
				break;
		}
		
		float sx = width  / (float) data.width;
		float sy = height / (float) data.height;
		for (int v = 0; v < height; v++) {
			for (int u = 0; u < width; u++) {
				ret.setPixel(u, v, get(ret, sample(data, u/sx, v/sy, data.width, data.height, method)));
				ret.setAlpha(u, v, sample(mask, u/sx, v/sy, data.width, data.height, method).red);
			}
		}
		return ret;
	}
	
	private static RGB sample(ImageData img, float u, float v, int width, int height,
			SamplingMethod method) {
		int x = (int) u, y = (int) v, tu, tv;
		float gaus, denom = 0.0f, r, g, b;
		
		switch(method) {
			case BILINEAR:
				if (x < 0 || y < 0 || x >= width || y >= height) { return BLACK; }
				if (x + 1 == width || y + 1 == height) {
					return get(img, x + 1 == width? x : x + 1, y + 1 == height? y : y + 1);
				}
				return lerp(lerp(get(img, x, y), get(img, x + 1, y), u - x),
				            lerp(get(img, x, y), get(img, x, y + 1), v - y), HALF);
			case GAUSSIAN:
				tu = (int) u - 2; tv = (int) v - 2;
				r = g = b = 0;
				for (int i = tu; i < tu + 6; i++) {
					for (int j = tv; j < tv + 6; j++) {
						RGB p = (i >= width || i < 0 || j >= height || j < 0)? get(img, x, y) : get(img, i, j);
						denom += gaus = (float) Math.exp(-Math.pow(dist(u, v, i, j), 2));
						r += gaus * p.red;
						g += gaus * p.green;
						b += gaus * p.blue;	
					}
				}
				return new RGB(ImageFunctions.clamp(Math.round(r / denom)),
						       ImageFunctions.clamp(Math.round(g / denom)),
				               ImageFunctions.clamp(Math.round(b / denom)));
			case NEAREST: default:
				x = (int) (u + HALF);
				y = (int) (v + HALF);
				return (x >= width || y >= height || x < 0 || y < 0)? BLACK : get(img, x, y);
		}
	}
	
	private static float dist(float x1, float y1, float x2, float y2) {
		float dx = x2 - x1, dy = y2 - y1;
		return (float) Math.sqrt(dx * dx + dy * dy);
	}
	
	private static RGB get(ImageData data, int x, int y) {
		return data.palette.getRGB(data.getPixel(x, y));
	}
	private static int get(ImageData data, RGB rgb) {
		return data.palette.getPixel(rgb);
	}
	
	private static RGB lerp(RGB rgb1, RGB rgb2, float factor) {
		return new RGB(
			lerp(rgb1.red,   rgb2.red,   factor),
			lerp(rgb1.green, rgb2.green, factor),
			lerp(rgb1.blue,  rgb2.blue,  factor)
		);
	}
	
	private static int lerp(int i, int j, float factor) {
		return ImageFunctions.clamp((int) Math.floor((1.0f - factor) * i + factor * j + HALF));
	}
}
