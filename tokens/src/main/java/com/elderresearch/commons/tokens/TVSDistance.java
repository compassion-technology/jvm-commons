/* ©2017-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.commons.tokens;

import java.util.Comparator;

import lombok.AllArgsConstructor;
import lombok.Getter;


/**
 * Represents a content "distance" between two token vectors representing the
 * statistical similarity between them. A lower value means the two original
 * documents are more similar.
 * 
 * @author <a href="dimeo@datamininglab.com">John Dimeo</a>
 * @since Jul 9, 2013
 */
@Getter
@AllArgsConstructor
public final class TVSDistance {
	private long  key1;
	private long  key2;
	private float distance;
	private long  influentialToken;
	
	@Override
	public String toString() {
		return String.format("%d <-> %d = %f", key1, key2, distance);
	}
	
	public static final Comparator<TVSDistance> COMPARATOR = Comparator
			.comparingDouble(TVSDistance::getDistance)
			.thenComparingLong(TVSDistance::getKey1)
			.thenComparingLong(TVSDistance::getKey2);
}

