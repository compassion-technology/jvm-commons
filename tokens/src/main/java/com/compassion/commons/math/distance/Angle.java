package com.compassion.commons.math.distance;

import org.apache.commons.math3.util.FastMath;

/**
 * The angle between two vectors (in radians) is the arc-cosine of the dot
 * product of the two vectors.
 * 
 * @author <a href="dimeo@datamininglab.com">John Dimeo</a>
 * @since Jan 27, 2014
 */
public class Angle extends DistanceMetric {
	/** Enumerates the angle format options. */
	public enum AngleFormat {
		/** Returns the dot product of the two vectors. This is the fastest,
		 *  as {@link Math#acos(double)} is not invoked. */
		COSINE,
		/** Returns the arcosine of the dot product of the two vectors, which
		 *  is the angle in radians. */
		RADIANS,
		/** Returns the acrosine of the dot product of the two vectors in
		 *  degrees. */
		DEGREES
	}
	
	private double sum, mag1, mag2;
	
	@DistanceParameter(name = "Angle Format", description = "The angle format, either the cosine of the angle (fastest), the angle in radians, or the angle converted to degrees")
	private AngleFormat format = AngleFormat.DEGREES;

	/**
	 * Sets the angle format to use when computing the angle between two vectors.
	 * @param format the angle format (defaults to {@link AngleFormat#DEGREES})
	 * @return this for method chaining
	 */
	public Angle setFormat(AngleFormat format) {
		this.format = format;
		return this;
	}
	
	@Override
	protected void setup() {
		sum  = 0.0;
		mag1 = 0.0;
		mag2 = 0.0;
	}
	
	@Override
	protected double component(long key, float v1, float v2) {
		double p = v1 * v2;
		sum  += p;
		mag1 += v1 * v1;
		mag2 += v2 * v2;
		return p;
	}
	
	@Override
	protected double distance() {
		double a = sum / (Math.sqrt(mag1) * Math.sqrt(mag2));
		switch (format) {
			case RADIANS: return FastMath.acos(a);
			case DEGREES: return Math.toDegrees(FastMath.acos(a));
			default:      return a;
		}
	}

	@Override
	public Angle copy() {
		Angle ret = new Angle();
		ret.format = format;
		return ret;
	}
}
