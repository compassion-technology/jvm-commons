package com.compassion.commons.gui.icons;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import javax.imageio.ImageIO;

/**
 * Reads a directory of PNG files and writes each one as a Base64-encoded 
 * string constant in a auto-generated Java class. The format (once decoded) is
 * graphics-platform-independent- an {@code int} array with the width, height,
 * and then one {@code int} per ARGB pixel.
 * 
 * @author <a href="dimeo@datamininglab.com">John Dimeo</a>
 * @since May 20, 2013
 */
public final class IconSerializer {
	private static final String BASE64_PREFIX = "H4sIAAAAAAA";
	private static final int    BYTES_PER_PIXEL = 4;
	private static final String DIRECTORY  = "C:\\Users\\jdimeo\\Downloads\\FatCow_Icons16x16";
	private static final String CLASS_NAME = "IconsFatCow";
	
	private IconSerializer() {
		// Prevent initialization
	}
	
	public static void main(String[] args) throws IOException {
		try (PrintStream ps = new PrintStream(CLASS_NAME + ".java")) {
			ps.println("// CHECKSTYLE:OFF\n/*\n * Copyright (c) 2013 Elder Research, Inc.\n * All rights reserved.\n*/\npackage com.datamininglab.foundation.icon;\n");
			ps.println("public interface " + CLASS_NAME + " {");
			
			File[] files = new File(DIRECTORY).listFiles();
			for (int i = 0; i < files.length; i++) {
				BufferedImage bi = ImageIO.read(files[i]);
				if (bi == null) { continue; }
				
				int w = bi.getWidth();
				int h = bi.getHeight();
				
				ByteArrayOutputStream baos = new ByteArrayOutputStream(w * h * BYTES_PER_PIXEL + 1);
				DataOutputStream dos = new DataOutputStream(baos);
				dos.writeInt(w); dos.writeInt(h);
				for (int y = 0; y < h; y++) {
					for (int x = 0; x < w; x++) {
						dos.writeInt(bi.getRGB(x, y));
					}
				}
	
				String name = files[i].getName().replace('-', '_').replace(' ', '_').replace('(', '_').replace(")", "");
				name = name.substring(0, name.indexOf('.')).toUpperCase();
				if (!Character.isJavaIdentifierStart(name.charAt(0))) {
					name = "ICO_" + name;
				}
				
				ps.println("\tString " + name + " = \""
					+ Base64.encodeBytes(baos.toByteArray(), Base64.GZIP | Base64.DONT_BREAK_LINES) + "\";");
			}
			
			ps.println("}\n// CHECKSTYLE:ON");
		}
	}
	
	/**
	 * Tests whether or not the string is a Base64-serialized icon.
	 * @param icon the string
	 * @return whether or not it is a serialized icon
	 */
	public static boolean isSerializedIcon(String icon) {
		return icon != null && icon.startsWith(BASE64_PREFIX);
	}
	
	/**
	 * Decompresses and decodes the serialized icon string into a 2D array of ARGB ints.  
	 * @param icon the icon string from one of the {@code Icons}* classes in this package
	 * @return a 2D array of the same size of the original image where each element is the
	 * RGB and alpha values of the corresponding pixel, or {@code null} if there was a 
	 * problem reading the string
	 */
	public static int[][] deserialize(String icon) {
		if (!isSerializedIcon(icon)) { return null; }
		
		byte[] arr = Base64.decode(icon);
		if (arr == null) { return null; }
		
		try (DataInputStream dis = new DataInputStream(new ByteArrayInputStream(arr))) {
			int w = dis.readInt();
			int h = dis.readInt();
			
			int[][] ret = new int[h][w];
			for (int y = 0; y < h; y++) {
				for (int x = 0; x < w; x++) {
					ret[y][x] = dis.readInt();
				}
			}
			return ret;
		} catch (IOException ex) {
			return null;
		}
	}
	
	/**
	 * Converts a serialized string icon to an AWT buffered image.
	 * @param icon the icon to convert
	 * @return a buffered image
	 */
	public static BufferedImage getAWTIcon(String icon) {
		int[][] pixels = deserialize(icon);
		
		BufferedImage bi = new BufferedImage(pixels[0].length, pixels.length, BufferedImage.TYPE_INT_ARGB);
		for (int y = 0; y < pixels.length; y++) {
			for (int x = 0; x < pixels[y].length; x++) {
				bi.setRGB(x, y, pixels[y][x]);
			}
		}
		return bi;
	}
}
