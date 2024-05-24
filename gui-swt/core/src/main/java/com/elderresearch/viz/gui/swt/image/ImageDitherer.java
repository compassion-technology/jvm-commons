/* ©2016-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.viz.gui.swt.image;

import static com.elderresearch.viz.gui.swt.image.ImageFunctions.clamp;

import org.apache.commons.lang3.math.NumberUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.graphics.RGB;

import com.compassion.commons.Utilities;
import com.elderresearch.viz.gui.swt.util.SWTUtilities;

public final class ImageDitherer {
	public enum DitherType { ORDERED_BAYER, FLOYD_STEINBERG }

	private ImageDitherer() {
		// Prevent initialization
	}

	public static void main(String[] args) {
		if (args.length < 4) {
			System.out.println("Usage: ImageScaler input_file output_file type "
				+ "(either \"ordered_bayer\" or \"floyd_steinberg\") bits_per_channel");
			return;
		}
		ImageLoader l = new ImageLoader();
		ImageData id = Utilities.first(l.load(Utilities.first(args)));
		DitherType dither = Utilities.valueOf(DitherType.class, args[2], null);
		l.data = new ImageData[] {
			dither(id, dither, NumberUtils.toInt(args[3]))
		};
		l.save(args[1], SWT.IMAGE_BMP_RLE);
	}

    /**
     * Applies an dither to a 24-bit image to reduce its color
     * depth in a more accurate way than direct quantization.
     * @param src the source image data
     * @param type the dithering method
     * @param nbits the number of bits per color channel in the
     * dithered image:<br>
     * 1 bit per channel: 8 colors<br>
     * 2 bits per channel: 64 colors<br>
     * 3 bits per channel: 512 colors<br>
     * @return the dithered image data
     */
    public static ImageData dither(ImageData src, DitherType type, int nbits) {
    	ImageData clone = (ImageData) src.clone();
    	if (type == DitherType.ORDERED_BAYER) {
	    	for (int y = 0; y < clone.height; y++) {
	    		for (int x = 0; x < clone.width; x++) {
	    			orderedDither(clone, nbits, x, y);
	    		}
	    	}
    	} else {
	    	for (int y = 0; y < clone.height; y++) {
	    		for (int x = 0; x < clone.width; x++) {
	    			floydSteinbergDither(clone, nbits, x, y);
	    		}
	    	}
	    	for (int x = 0; x < clone.width; x++) {
	    		orderedDither(clone, nbits, x, 0);
	    	}
	    	for (int y = 0; y < clone.height; y++) {
	    		orderedDither(clone, nbits, 0, y);
	    	}
    	}
    	return clone;
    }

    private static final int[][] BAYER4 = new int[][]
        {{15,  7, 13,  5},
          {3, 11,  1,  9},
         {12,  4, 14,  6},
          {0,  8,  2, 10}};
    private static void orderedDither(ImageData src, int nbits, int x, int y) {
		RGB p = SWTUtilities.colorToRGB(src.getPixel(x, y));
		int bayer = (((BAYER4[x % 4][y % 4] + 1) * 16 - 1) / nbits) - (128 / nbits);
		p.red   = clamp(p.red   + bayer);
		p.green = clamp(p.green + bayer);
		p.blue  = clamp(p.blue  + bayer);
		src.setPixel(x, y, SWTUtilities.colorToInt(quantize(p, nbits)));
    }

    private static final float ALPHA = 7.0f / 16.0f;
    private static final float BETA  = 3.0f / 16.0f;
    private static final float GAMMA = 5.0f / 16.0f;
    private static final float DELTA = 1.0f / 16.0f;
    private static void floydSteinbergDither(ImageData src, int nbits, int x, int y) {
		int p = src.getPixel(x, y);
		RGB r = SWTUtilities.colorToRGB(p);
		RGB s = quantize(r, nbits);
		int y1 = y > src.height - 2? 0 : y + 1;
		int x0 = x < 1?  src.width - 1 : x - 1;
		int x1 = x >  src.width - 2? 0 : x + 1;
		RGB bl = SWTUtilities.colorToRGB(src.getPixel(x0, y1));
		RGB bm = SWTUtilities.colorToRGB(src.getPixel(x,  y1));
		RGB br = SWTUtilities.colorToRGB(src.getPixel(x1, y1));
		RGB mr = SWTUtilities.colorToRGB(src.getPixel(x1, y));

		int errr = r.red - s.red;
		bl.red = clamp(bl.red + (int) (BETA  * errr));
		bm.red = clamp(bm.red + (int) (GAMMA * errr));
		br.red = clamp(br.red + (int) (DELTA * errr));
		mr.red = clamp(mr.red + (int) (ALPHA * errr));
		int errg = r.green - s.green;
		bl.green = clamp(bl.green + (int) (BETA  * errg));
		bm.green = clamp(bm.green + (int) (GAMMA * errg));
		br.green = clamp(br.green + (int) (DELTA * errg));
		mr.green = clamp(mr.green + (int) (ALPHA * errg));
		int errb = r.blue - s.blue;
		bl.blue = clamp(bl.blue + (int) (BETA  * errb));
		bm.blue = clamp(bm.blue + (int) (GAMMA * errb));
		br.blue = clamp(br.blue + (int) (DELTA * errb));
		mr.blue = clamp(mr.blue + (int) (ALPHA * errb));
		src.setPixel(x0, y1, SWTUtilities.colorToInt(bl));
		src.setPixel(x,  y1, SWTUtilities.colorToInt(bm));
		src.setPixel(x1, y1, SWTUtilities.colorToInt(br));
		src.setPixel(x1, y,  SWTUtilities.colorToInt(mr));
		src.setPixel(x,  y,  SWTUtilities.colorToInt(s));
    }

	//Reduces the color depth of the passed image data
	/*private static ImageData adjustDepth(ImageData src, int nbits) {
		HashSet<RGB> rgbs = new HashSet<RGB>();
		ImageData ret = new ImageData(src.width, src.height, 1 << (nbits + 1),
				new PaletteData(new RGB[0]));
		for(int y = 0; y < src.height; y++) {
			for(int x = 0; x < src.width; x++) {
				rgbs.add(SWTUtilities.colorToRGB(src.getPixel(x, y)));
			}
		}
		ret.palette.colors = rgbs.toArray(ret.palette.colors);
		System.out.println(ret.palette.colors.length);
		for(int y = 0; y < src.height; y++) {
			for(int x = 0; x < src.width; x++) {
				ret.setPixel(x, y, ret.palette.getPixel(
						SWTUtilities.colorToRGB(src.getPixel(x, y))));
			}
		}
		return ret;
	}*/

	//Quantizes a single pixel directly
	public static RGB quantize(RGB p, int nbits) {
		int shift = 8 - nbits;
		float mult = 255 / (float)(255 >> shift);
		RGB ret = new RGB(p.red >> shift, p.green >> shift, p.blue  >> shift);
		ret.red   = clamp((int) (ret.red * mult));
		ret.green = clamp((int) (ret.green * mult));
		ret.blue  = clamp((int) (ret.blue * mult));
		return ret;
	}
}
