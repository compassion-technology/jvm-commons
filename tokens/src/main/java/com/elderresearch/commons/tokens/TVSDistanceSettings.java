/* ©2017-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.commons.tokens;

import java.util.Comparator;
import java.util.function.Consumer;

import org.apache.commons.lang3.Range;
import org.apache.commons.math3.util.MathArrays.OrderDirection;

import com.compassion.commons.StatusMonitor;
import com.elderresearch.commons.hash.DataHash;
import com.elderresearch.commons.math.distance.Angle;
import com.elderresearch.commons.math.distance.DistanceMetric;

import lombok.AccessLevel;
import lombok.Getter;

/**
 * Settings that configure a distance computation run.
 * 
 *
 * @since Dec 12, 2014
 */
@Getter(AccessLevel.PACKAGE)
public class TVSDistanceSettings {
	private static final int DEFAULT_SORT_BUFFER_DENOM = 10;
	
	public enum MaxDistanceAggregation {
		NONE("No aggregation", 10000),
		PER_UNIQUE_ID("Aggregate by unique ID", 100);
		
		private String s;
		private int defMax;
		MaxDistanceAggregation(String s, int defMax) {
			this.s = s;
			this.defMax = defMax;
		}
		
		@Override
		public String toString() { return s; }
		
		public int getDefaultMaxDistances() { return defMax; }
		public int getDefaultSortBuffer() { return defMax / DEFAULT_SORT_BUFFER_DENOM; }
	}
	
	private StatusMonitor statusMonitor;
	private int threads = Math.max(Runtime.getRuntime().availableProcessors() - 1, 1);
	
	private DistanceMetric distanceMetric = new Angle();
	private OrderDirection sortOrder = OrderDirection.INCREASING;
	private Range<Float> range = Range.of(Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY);
	
	private MaxDistanceAggregation maxAggregation = MaxDistanceAggregation.NONE;
	private int maxDistanceCount = maxAggregation.getDefaultMaxDistances();
	private int sortBuffer = maxAggregation.getDefaultSortBuffer();
	
	private Consumer<TVSDistance> callback;
	
	/**
	 * Sets the callback that will be invoked for each computed distance. <strong>Not every distance passed to this
	 * callback will be in the final result set</strong> if it didn't make the "final cut" based on the other settings
	 * in this class. However, distances that fail the initial checks (e.g. min/max range) will not be passed to this
	 * callback.
	 * @param callback the callback/listener invoked for each computed distance. Multiple threads may be invoking this
	 * callback so it must be thread safe.
	 */
	public void setCallback(Consumer<TVSDistance> callback) {
		this.callback = callback;
	}
	
	/**
	 * When computing the maximum distances to keep, this determines the aggregation
	 * to use. By default, this is {@link MaxDistanceAggregation#NONE}, meaning
	 * the maximum distances saved will be no more than the value provided to
	 * {@link #setMaxDistances(int)}, regardless of how many have been computed
	 * for each unique ID.
	 * @param maxAggregation the aggregation to use when computing the distances
	 * to save/keep
	 * @return this for method chaining
	 */
	public TVSDistanceSettings setMaxAggregation(MaxDistanceAggregation maxAggregation) {
		this.maxAggregation = maxAggregation;
		return this;
	}
	
	/**
	 * Sets the metric used to compute the distance between two token vectors.
	 * The default is {@link Angle}).
	 * @param dm the distance metric
	 * @return this for method chaining
	 */
	public TVSDistanceSettings setMetric(DistanceMetric dm) {
		this.distanceMetric = dm;
		return this;
	}
	
	/**
	 * Sets the maximum number of distances that will be computed. This
	 * improves run time performance as well as cap RAM usage. By default
	 * this is a function of the aggregation method.
	 * @param maxDistanceCount the maximum number of distances to return
	 * @return this for method chaining
	 * @see MaxDistanceAggregation
	 */
	public TVSDistanceSettings setMaxDistances(int maxDistanceCount) {
		this.maxDistanceCount = maxDistanceCount;
		return this;
	}
	
	/**
	 * Sets the range of distances that will be returned. Use this to exclude
	 * very small or equivalent distances (as the minimum) or very large or
	 * dissimilar distances (as the maximum). The range of distances is dependent
	 * on the metric used. By default this is infinite, so all distances will be
	 * returned.
	 * @param range the distance range
	 * @return this for method chaining
	 */
	public TVSDistanceSettings setRange(Range<Float> range) {
		this.range = range;
		return this;
	}
	
	/**
	 * Sets the number of worker threads used to compute distances. This
	 * should be higher than the number of cores available to the JVM for
	 * best performance. By default this is one less than the number of available
	 * processors on the system.
	 * @param distThreads the number of distance threads
	 * @return this for method chaining
	 */
	public TVSDistanceSettings setThreads(int distThreads) {
		this.threads = distThreads;
		return this;
	}
	
	/**
	 * Sets the sort buffer to use when computing distances. This is the number
	 * of results that will be "buffered" unordered between sorts. The higher the
	 * number, the more RAM will be used but the less CPU work will be performed
	 * as results will be sorted less often. By default this is a function of the 
	 * distance aggregation.
	 * @param sortBuffer the size of the sort buffer
	 * @return this for method chaining
	 * @see MaxDistanceAggregation
	 */
	public TVSDistanceSettings setSortBuffer(int sortBuffer) {
		this.sortBuffer = sortBuffer;
		return this;
	}
	
	/**
	 * Sets how distances will be ordered when determining which distances to return.
	 * By default this is {@link OrderDirection#INCREASING}.
	 * @param sortOrder the sort order
	 * @return this for method chaining
	 */
	public TVSDistanceSettings setSortOrder(OrderDirection sortOrder) {
		this.sortOrder = sortOrder;
		return this;
	}
	
	/**
	 * Sets the status monitor to monitor the progress of the distance
	 * computation. This can be {@code null}, but is the mechanism for
	 * providing status to the user and a way to cancel the computation, so
	 * specifying one is recommended.
	 * @param sm the status monitor
	 * @return this for method chaining
	 */
	public TVSDistanceSettings setStatusMonitor(StatusMonitor sm) {
		this.statusMonitor = sm;
		return this;
	}
	
	TVSDistance getDefaultDistance() {
		float defDist = sortOrder == OrderDirection.DECREASING? Float.NEGATIVE_INFINITY : Float.POSITIVE_INFINITY;
		return new TVSDistance(DataHash.NULL, DataHash.NULL, defDist, 0L); 
	}
	Comparator<TVSDistance> getSortOrder() {
		return sortOrder == OrderDirection.DECREASING? TVSDistance.COMPARATOR.reversed() : TVSDistance.COMPARATOR;
	}
}
