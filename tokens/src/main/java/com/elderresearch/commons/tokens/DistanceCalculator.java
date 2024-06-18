/* ©2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.commons.tokens;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.jooq.lambda.tuple.Tuple2;

import com.compassion.commons.StatusMonitor;
import com.compassion.commons.iter.IteratorMultithreaded;
import com.elderresearch.commons.math.distance.DistanceMetric;
import com.google.common.collect.Iterators;

import lombok.val;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DistanceCalculator {
	private static final int QUEUE_SIZE_PER_THREAD = 1024, BATCH_SIZE = 256;

	public <TV extends TokenVector> TVSDistanceResults calculate(TVSDistanceSettings settings, long n, Iterator<Tuple2<TV, TV>> iter) {
		val dmLocal = ThreadLocal.withInitial(() -> settings.getDistanceMetric().copy());
		
		val sm = Optional.ofNullable(settings.getStatusMonitor()).orElseGet(StatusMonitor::new);
		sm.newTask("Computing distances...", n);
		
		List<TVSDistanceResults> resultList = new LinkedList<>();
		ThreadLocal<TVSDistanceResults> results = ThreadLocal.withInitial(() -> {
			val ret = new TVSDistanceResults(settings);
			synchronized (resultList) { resultList.add(ret); }
			return ret;
		});
		
		val parallelIter = new IteratorMultithreaded<List<Tuple2<TV, TV>>>() {
			@Override
			protected boolean process(List<Tuple2<TV, TV>> list) {
				DistanceMetric dm = dmLocal.get();
				list.forEach(p -> {
					results.get().add(new TVSDistance(p.v1.getKey(), p.v2.getKey(),
							(float) dm.getDistance(p.v1.countsWeighted, p.v2.countsWeighted),
							        dm.getMostInfluentialKey()));	
				});
				return sm.isRunning();
			}
			
			@Override
			protected List<Tuple2<TV, TV>> preprocess(List<Tuple2<TV, TV>> list) {
				sm.setProgress(list.size(), true);
				return list;
			}
		};
		
		parallelIter
			.setThreads(settings.getThreads())
			.setQueueSize(settings.getThreads() * QUEUE_SIZE_PER_THREAD)
			.iterate(Iterators.partition(iter, BATCH_SIZE));
			
		return merge(sm, resultList);
	}
	
	private TVSDistanceResults merge(StatusMonitor sm, List<TVSDistanceResults> results) {
		long total = 0L;
		for (TVSDistanceResults r : results) { total += r.size(); }
		
		TVSDistanceResults ret = null;
		for (TVSDistanceResults r : results) {
			if (ret == null) {
				ret = r;
				sm.newTask("Merging results...", total - r.size());
			} else {
				for (TVSDistance d : r) {
					ret.add(d);
					sm.setProgress(1L, true);
				}
			}
		}
		return ret;	
	}
}
