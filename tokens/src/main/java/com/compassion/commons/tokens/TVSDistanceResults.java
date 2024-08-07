package com.compassion.commons.tokens;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.collections.api.map.primitive.MutableLongObjectMap;
import org.eclipse.collections.impl.factory.primitive.LongObjectMaps;

import com.compassion.commons.LambdaUtils;
import com.compassion.commons.hash.DataHash;
import com.compassion.commons.structs.SortedArray;

public class TVSDistanceResults implements Iterable<TVSDistance> {
	private TVSDistance defDist;
	private TVSDistanceSettings settings;
	private MutableLongObjectMap<SortedArray<TVSDistance>> map;
	private List<TVSDistance> list;
	
	TVSDistanceResults(TVSDistanceSettings settings) {
		this.settings = settings;
		this.defDist = settings.getDefaultDistance();
		this.map = LongObjectMaps.mutable.empty();
	}
	
	void add(TVSDistance dist) {
		switch (settings.getMaxAggregation()) {
			case PER_UNIQUE_ID:
				add(dist.getKey1(), dist);
				add(dist.getKey2(), dist);
				break;
			default:
				add(DataHash.NULL, dist);
				break;
		}
	}
	private void add(long id, TVSDistance dist) {
		SortedArray<TVSDistance> arr = map.get(id);
		if (arr == null) {
			arr = new SortedArray<>(settings.getMaxDistanceCount(), defDist, settings.getSortBuffer());
			arr.setComparator(settings.getSortOrder());
			map.put(id, arr);
		}
		if (settings.getRange().contains(dist.getDistance())) {
			arr.add(dist);
			LambdaUtils.accept(dist, settings.getCallback());
		}
	}
	
	@Override
	public Iterator<TVSDistance> iterator() {
		if (list != null) { return list.iterator(); }
		
		// Sort and remove duplicates before iteration
		Set<TVSDistance> unique = new HashSet<>(settings.getMaxDistanceCount());
		for (SortedArray<TVSDistance> arr : map) {
			for (TVSDistance d : arr) {
				if (d != defDist) { unique.add(d); }
			}
		}
		map = null;
		
		list = new ArrayList<>(unique);
		Collections.sort(list, settings.getSortOrder());
		
		return iterator();
	}
	
	/**
	 * Gets the estimate of the number of distances contained in these results.
	 * @return the size of the results
	 */
	public long size() {
		return list == null? map.size() * (long) settings.getMaxDistanceCount() : list.size();
	}
}
