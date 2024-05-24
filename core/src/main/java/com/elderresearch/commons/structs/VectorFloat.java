/* ©2016-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.commons.structs;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.util.Arrays;
import java.util.Random;

public class VectorFloat implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private static final float HALF = 0.5f;
	private static final int   N_3D = 3;
	private static final int   FLOAT_BYTES = 4;
	
	public static final VectorFloat ALL_ZEROS = new VectorFloat(0.0f, 0.0f, 0.0f);
	public static final VectorFloat UNIT_X    = new VectorFloat(1.0f, 0.0f, 0.0f);
	public static final VectorFloat UNIT_Y    = new VectorFloat(0.0f, 1.0f, 0.0f);
	public static final VectorFloat UNIT_Z    = new VectorFloat(0.0f, 0.0f, 1.0f);
	
	public enum RandomShape { UNIT, UNIT_CENTERED, UNIT_SPHERE }
	
	private static final int X = 0;
	private static final int Y = X + 1;
	private static final int Z = Y + 1;
	private static Random rand = new Random();
	
	private float[] comp;
	
	public VectorFloat() {
		this(0.0f, 0.0f, 0.0f);
	}
	
	public VectorFloat(int dimensions) {
		comp = new float[dimensions];
	}
	
	public VectorFloat(float x, float y, float z) {
		comp = new float[N_3D];
		comp[X] = x;
		comp[Y] = y;
		comp[Z] = z;
	}
	
	public int size() { return comp.length; }
	
	public float getX() { check3(this); return comp[X]; }
	public float getY() { check3(this); return comp[Y]; }
	public float getZ() { check3(this); return comp[Z]; }
	public float get(int dimension) { return comp[dimension]; }
	
	public void setX(float x) { check3(this); comp[X] = x; }
	public void setY(float y) { check3(this); comp[Y] = y; }
	public void setZ(float z) { check3(this); comp[Z] = z; }
	public void set(int dimension, float v) { comp[dimension] = v; }
	
	public void set(float... values) {
		check(comp, values);
		System.arraycopy(values, 0, comp, 0, values.length);
	}
	
	public VectorFloat set(FloatBuffer buffer) {
		buffer.get(comp);
		return this;
	}
	public VectorFloat set(DoubleBuffer buffer) {
		for (int i = 0; buffer.hasRemaining(); i++) {
			comp[i] = (float) buffer.get();
		}
		return this;
	}
	
	public FloatBuffer toBuffer() {
		FloatBuffer ret = ByteBuffer.allocateDirect(comp.length * FLOAT_BYTES).asFloatBuffer();
		ret.put(comp);
		ret.rewind();
		return ret;
	}
	
	public float[] toArray() {
		return comp;
	}
	
	public void set(VectorFloat other) {
		if (comp.length != other.comp.length) {
			comp = new float[other.comp.length];
		}
		System.arraycopy(other.comp, 0, comp, 0, comp.length);
	}
	
	public float getMedian() {
		float[] temp = new float[comp.length];
		System.arraycopy(comp, 0, temp, 0, comp.length);
		Arrays.sort(temp);
		return temp[temp.length / 2];
	}
	
	public float getMagnitude() {
		return (float) Math.sqrt(getDotProductWith(this));
	}
	
	public VectorFloat getNormal() {
		float m = getMagnitude();
		if (m == 0.0f) {
			VectorFloat v = new VectorFloat(comp.length);
			v.comp[Y] = 1.0f;
			return v;
		}
		return divide(m);
	}
	
	public float getDistanceWith(VectorFloat other) {
		check(this, other);
		float sumsq = 0.0f;
		for (int i = 0; i < comp.length; i++) {
			float d = other.comp[i] - comp[i];
			sumsq += d * d;
		}
		return (float) Math.sqrt(sumsq);
	}
	
	public double getDotProductWith(VectorFloat other) {
		check(this, other);
		double sum = 0.0;
		for (int i = 0; i < comp.length; i++) {
			double prod = (double) comp[i] * other.comp[i];
			if (!Double.isNaN(prod) && !Double.isInfinite(prod)) {
				sum += prod;
			}
		}
		return sum;
	}
	
	public VectorFloat getCrossProductWith(VectorFloat other) {
		check3(this);
		float tx = (comp[Y] * other.comp[Z]) - (comp[Z] * other.comp[Y]);
		float ty = (comp[Z] * other.comp[X]) - (comp[X] * other.comp[Z]);
		float tz = (comp[X] * other.comp[Y]) - (comp[Y] * other.comp[X]);
		return new VectorFloat(tx, ty, tz);
	}
	
	public void add(float x, float y, float z) {
		check3(this);
		comp[X] += x; comp[Y] += y; comp[Z] += z;
	}
	
	public VectorFloat add(VectorFloat other) {
		check(this, other);
		VectorFloat ret = new VectorFloat(comp.length);
		for (int i = 0; i < comp.length; i++) {
			ret.comp[i] = comp[i] + other.comp[i];
		}
		return ret;
	}
	
	public VectorFloat subtract(VectorFloat other) {
		check(this, other);
		VectorFloat ret = new VectorFloat(comp.length);
		for (int i = 0; i < comp.length; i++) {
			ret.comp[i] = comp[i] - other.comp[i];
		}
		return ret;
	}
	
	public VectorFloat multiply(VectorFloat other) {
		check(this, other);
		VectorFloat ret = new VectorFloat(comp.length);
		for (int i = 0; i < comp.length; i++) {
			ret.comp[i] = comp[i] * other.comp[i];
		}
		return ret;
	}
	
	public VectorFloat divide(VectorFloat other) {
		check(this, other);
		VectorFloat ret = new VectorFloat(comp.length);
		for (int i = 0; i < comp.length; i++) {
			ret.comp[i] = comp[i] / other.comp[i];
		}
		return ret;
	}
	
	public VectorFloat add(float value) {
		VectorFloat ret = new VectorFloat(comp.length);
		for (int i = 0; i < comp.length; i++) {
			ret.comp[i] = comp[i] + value;
		}
		return ret;
	}
	
	public VectorFloat subtract(float value) {
		VectorFloat ret = new VectorFloat(comp.length);
		for (int i = 0; i < comp.length; i++) {
			ret.comp[i] = comp[i] - value;
		}
		return ret;
	}
	
	public VectorFloat multiply(float value) {
		VectorFloat ret = new VectorFloat(comp.length);
		for (int i = 0; i < comp.length; i++) {
			ret.comp[i] = comp[i] * value;
		}
		return ret;
	}
	
	public VectorFloat divide(float value) {
		VectorFloat ret = new VectorFloat(comp.length);
		for (int i = 0; i < comp.length; i++) {
			ret.comp[i] = comp[i] / value;
		}
		return ret;
	}
	
	@Override
	public boolean equals(Object obj) {
		return Arrays.equals(comp, ((VectorFloat) obj).comp);
	}
	
	@Override
	public int hashCode() {
		return Arrays.hashCode(comp);
	}
	
	public float getAngleWith(VectorFloat other) {
		return (float) Math.acos(getNormal().getDotProductWith(other.getNormal()));
	}
	
	public float getAngleWith(VectorFloat other, VectorFloat weights) {
		return multiply(weights).getAngleWith(other.multiply(weights));
	}
	
	public VectorFloat getCartesian() {
		check3(this);
		return new VectorFloat((float) (comp[X] * Math.cos(comp[Y]) * Math.sin(comp[Z])),
							   (float) (comp[X] * Math.cos(comp[Z])),
							   (float) (comp[X] * Math.sin(comp[Y]) * Math.sin(comp[Z])));
	}

	public VectorFloat getSpherical() {
		check3(this);			
		float r = getMagnitude();
		float t;
		if (comp[X] == 0.0f) {
			if (comp[Z] >= 0.0f) {
				t = (float) (Math.PI * HALF);
			} else {
				t = (float) (Math.PI * -HALF);	
			}
		} else {
			t = (float) Math.atan(comp[Z] / comp[X]);
		}
		if (comp[X] < 0) {
			t += Math.PI;
		}
		return new VectorFloat(r, t, r == 0.0f? 0.0f : (float) Math.acos(comp[Y] / r));
	}
	
	public VectorFloat rotateAround(VectorFloat axis, float angle) {
		check3(axis); check3(this);
		
		float newX, newY, newZ;
		float u = axis.comp[X], v = axis.comp[Y], w = axis.comp[Z];
		
		float sATV = u * u + v * v + w * w;
		if (sATV == 0) { return this; }
		
		float scalarProduct = u * comp[X] + v * comp[Y] + w * comp[Z];
		newX = (float) (u * scalarProduct + (comp[X] * (v * v + w * w) - u
				* (v * comp[Y] + w * comp[Z])) * Math.cos(angle) + Math.sqrt(sATV)
				* (-w * comp[Y] + v * comp[Z]) * Math.sin(angle)) / sATV;
		newY = (float) (v * scalarProduct + (comp[Y] * (u * u + w * w) - v
				* (u * comp[X] + w * comp[Z])) * Math.cos(angle) + Math.sqrt(sATV)
				* (w * comp[X] - u * comp[Z]) * Math.sin(angle)) / sATV;
		newZ = (float) (w * scalarProduct + (comp[Z] * (u * u + v * v) - w
				* (u * comp[X] + v * comp[Y])) * Math.cos(angle) + Math.sqrt(sATV)
				* (-v * comp[X] + u * comp[Y]) * Math.sin(angle)) / sATV;
		return new VectorFloat(newX, newY, newZ);
	}
	
	public static VectorFloat getRandomVector(RandomShape shape) {
		return getRandomVector(shape, N_3D);
	}
	public static VectorFloat getRandomVector(RandomShape shape, int dimensions) {
		switch (shape) {
			case UNIT_SPHERE:
				return new VectorFloat(rand.nextFloat() * HALF,
					(float) (rand.nextFloat() * 2.0f * Math.PI - Math.PI),
					(float) (rand.nextFloat() * HALF * Math.PI)).getCartesian();
				
			default:
				VectorFloat ret = new VectorFloat(dimensions);
				for (int i = 0; i < dimensions; i++) {
					ret.set(i, rand.nextFloat());
				}
				
				if (shape == RandomShape.UNIT_CENTERED) {
					for (int i = 0; i < dimensions; i++) {
						ret.comp[i] -= HALF;
					}
				}
				return ret;
		}
	}
	
	public static VectorFloat wrap(float[] components) {
		VectorFloat v = new VectorFloat(components.length);
		System.arraycopy(components, 0, v.comp, 0, components.length);
		return v;
	}
	
	public static VectorFloat wrap(double[] components) {
		VectorFloat v = new VectorFloat(components.length);
		for (int i = 0; i < components.length; i++) {
			v.comp[i] = (float) components[i];
		}
		return v;
	}
	
	public static VectorFloat parse(String[] components, int start, int len) {
		VectorFloat v = new VectorFloat(len);
		for (int i = 0; i < len; i++) {
			try {
				v.comp[i] = Float.parseFloat(components[i + start]);
			} catch (NullPointerException | NumberFormatException e) {
				v.comp[i] = Float.NaN;
			}
		}
		return v;
	}
	
	@Override
	public String toString() {
		String ret = "(";
		for (int i = 0; i < comp.length; i++) {
			ret += comp[i];
			if (i < comp.length - 1) { ret += ", "; }
		}
		return ret + ")";
	}
	
	private static void check(VectorFloat v1, VectorFloat v2) {
		check(v1.comp, v2.comp);
	}
	private static void check(float[] arr1, float[] arr2) {
		if (arr1.length != arr2.length) {
			throw new RuntimeException("The vector parameters must be the same length");
		}
	}
	private static void check3(VectorFloat v) {
		if (v.comp.length != N_3D) {
			throw new RuntimeException("This method applies only to 3-dimensional vectors");
		}
	}
}
