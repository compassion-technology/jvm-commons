package com.compassion.commons.math.distance;

/**
 * L-Infinity distance is the maximum of the absolute value of the differences
 * between each component of the vectors.
 * 
 * @author <a href="dimeo@datamininglab.com">John Dimeo</a>
 * @since Jan 27, 2014
 */
public class LInfinity extends DistanceMetric {
	private double max;
	
	@Override
	protected void setup() { max = 0.0; }
	
	@Override
	protected double component(long key, float v1, float v2) {
		double m = Math.abs(v1 - v2); 
		max = Math.max(max, m);
		return m;
	}
	
	@Override
	protected double distance() { return max; }
	
	@Override
	public LInfinity copy() { return new LInfinity(); }
	
	@Override
	public String toString() { return "L\u221E (Chebyshev)"; }
}
