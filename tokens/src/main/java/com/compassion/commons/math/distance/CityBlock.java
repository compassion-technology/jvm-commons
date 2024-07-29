package com.compassion.commons.math.distance;

/**
 * City-Block, otherwise known as Manhattan or L<sup>1</sup>, distance is the
 * sum of the absolute value of the differences between each component of the
 * vectors.
 * 
 * @author <a href="dimeo@datamininglab.com">John Dimeo</a>
 * @since Jan 27, 2014
 */
public class CityBlock extends DistanceMetric {
	private double sum;
	
	@Override
	protected void setup() { sum = 0.0; }
	
	@Override
	protected double component(long key, float v1, float v2) {
		double d = Math.abs(v1 - v2); 
		sum += d;
		return d;
	}
	
	@Override
	protected double distance() { return sum; }
	
	@Override
	public CityBlock copy() { return new CityBlock(); }
	
	@Override
	public String toString() { return "L\u00B9 (City Block)"; }
}
