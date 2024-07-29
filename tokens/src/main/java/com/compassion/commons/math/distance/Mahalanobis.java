package com.compassion.commons.math.distance;

import org.eclipse.collections.api.map.primitive.MutableLongDoubleMap;
import org.eclipse.collections.impl.factory.primitive.LongDoubleMaps;

/**
 * Mahalanobis distance is the sum of the absolute value of the differences
 * between each component of the vectors weighted by the covariance matrix of
 * the data.
 * 
 * @author <a href="dimeo@datamininglab.com">John Dimeo</a>
 * @since Jan 27, 2014
 */
public class Mahalanobis extends DistanceMetric {
	private MutableLongDoubleMap dv;
	
	@DistanceParameter(name = "Covariance Provider", description = "Specifies the covariance between two different token keys")
	private CovarianceProvider cp;
	
	// TODO: Make more user-friendly
	public Mahalanobis setCovarianceProvider(CovarianceProvider cp) {
		this.cp = cp;
		return this;
	}

	@Override
	protected void setup() {
		dv = LongDoubleMaps.mutable.empty();
	}
	
	@Override
	protected double component(long key, float v1, float v2) {
		double d = Math.abs(v1 - v2);
		dv.put(key, d);
		return d;
	}
	
	@Override
	protected double distance() {
		double dist = 0;
		
		long[] keys = dv.keySet().toArray();
		for (int i = 0; i < keys.length; i++) {
			double m = 0;
			for (int j = 0; j < keys.length; j++) {
				m += cp.invcov(keys[i], keys[j]) * dv.get(keys[j]);
			}
			dist += dv.get(keys[i]) * m;
		}
		return dist;
	}

	@Override
	public Mahalanobis copy() {
		Mahalanobis ret = new Mahalanobis();
		ret.cp = cp;
		return ret;
	}
	
	/** Interface to provide the inverse covariance needed by the Mahalanobis
	 *  distance calculation. The implementation <b>must</b> be thread-safe. */
	public interface CovarianceProvider {
		double invcov(long key1, long key2);
	}
}
