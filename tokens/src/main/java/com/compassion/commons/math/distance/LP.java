package com.compassion.commons.math.distance;

/**
 * Generalized L<sup>p</sup> distance is the sum of the absolute value of the
 * differences between each component of the vectors, each raised to the
 * p<sup>th</sup> power.
 * 
 * @author <a href="dimeo@datamininglab.com">John Dimeo</a>
 * @since Jan 27, 2014
 */
public class LP extends DistanceMetric {
	private double sum;
	
	@DistanceParameter(name = "Exponent (P)", description = "The power by which to raise the absolute difference between each component")
	private double p = 2.0;
	
	public DistanceMetric setExponent(double p) {
		this.p = p;
		return this;
	}
	
	@Override
	protected void setup() { sum = 0.0; }
	
	@Override
	protected double component(long key, float v1, float v2) {
		double d = Math.pow(Math.abs(v1 - v2), p);
		sum += d;
		return d;
	}
	
	@Override
	protected double distance() { return sum; }
	
	@Override
	public LP copy() { 
		LP ret = new LP();
		ret.p = p;
		return ret;
	}
	
	@Override
	public String toString() { return "L\u1D3E"; }
}
