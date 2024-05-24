/* ©2016-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.commons.structs;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.jooq.lambda.function.Function3;

import lombok.val;

/**
 * A map of tuples/pairs to values (which is implemented as a map of keys to a map of other keys to values).
 *
 * @author <a href="mailto:dimeo@datamininglab.com">John Dimeo</a>
 * @param <K> the first key type
 * @param <L> the second key type
 * @param <V> the value type
 * @since Oct 9, 2017
 */
public class TwoKeyHashMap<K, L, V> extends HashMap<K, Map<L, V>> {
	private static final long serialVersionUID = 1L;

	public V put(K key1, L key2, V value) {
		return computeIfAbsent(key1, $ -> new HashMap<>()).put(key2, value);
	}

	public V get(K key1, L key2) {
		return getOrDefault(key1, Collections.emptyMap()).get(key2);
	}

	public Stream<V> streamValues() {
		return values().stream().flatMap($ -> $.values().stream());
	}

	public Set<V> getValues() {
		return streamValues().collect(Collectors.toSet());
	}

	/**
	 * Remove the value with pair of keys. The implementation will remove the secondary map if this removal leaves the
	 * map empty.
	 * @param key1 the first key
	 * @param key2 the second key
	 * @return the value that was mapped to the keys prior to removal, or {@code null} if no value was removed
	 */
	public V removeValue(K key1, L key2) {
		val map = get(key1);
		if (map == null) { return null; }
		val ret = map.remove(key2);
		if (map.isEmpty()) { remove(key1); }
		return ret;
	}

	/**
	 * Iterates each entry in the map. If the callback returns {@code false}, iteration will be prematurely aborted.
	 * @param op the callback for each entry
	 */
	public void forEachEntry(Function3<K, L, V, Boolean> op) {
		for (Map.Entry<K, Map<L, V>> sup : entrySet()) {
			for (Map.Entry<L, V> sub : sup.getValue().entrySet()) {
				if (op.apply(sup.getKey(), sub.getKey(), sub.getValue()) == Boolean.FALSE) { return; }
			}
		}
	}
}
