/* ©2016-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.commons.math.distance;

/**
 * Euclidean, otherwise known as L<sup>2</sup>, distance is the sum of the
 * squares of the differences between each component of the of the vectors.
 * 
 * @author <a href="dimeo@datamininglab.com">John Dimeo</a>
 * @since Jan 27, 2014
 */
public class Euclidean extends DistanceMetric {
	private double sum;
	
	@DistanceParameter(name = "Euclidean Format", description = "The distance format: the sum of squares (fastest), or the square root of the sum of squares")
	private EuclideanFormat format = EuclideanFormat.SUM_OF_SQUARES;
	
	public Euclidean setFormat(EuclideanFormat format) {
		this.format = format;
		return this;
	}
	
	@Override
	protected void setup() { sum = 0.0; }
	
	@Override
	protected double component(long key, float v1, float v2) {
		double d = v1 - v2; d *= d;
		sum += d;
		return d;
	}
	
	@Override
	protected double distance() {
		return format == EuclideanFormat.SQUARE_ROOT? Math.sqrt(sum) : sum;
	}
	
	@Override
	public Euclidean copy() {
		Euclidean ret = new Euclidean();
		ret.format = format;
		return ret;
	}
	
	@Override
	public String toString() { return "L\u00B2 (Euclidean)"; }
}
