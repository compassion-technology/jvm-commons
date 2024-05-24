/* ©2017-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.commons.structs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.function.Function;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Synchronized;
import lombok.experimental.Accessors;

@NoArgsConstructor
public class ListWithIndex<E, I> extends LinkedList<E> {
	@Setter @Accessors(chain = true)
	private transient Function<E, I> keyExtractor;
	
	private transient int lastModCount = -1;
	private transient Map<I, E> index;
	
	public ListWithIndex(Function<E, I> keyExtractor) {
		this.keyExtractor = keyExtractor;
	}

	@Synchronized
	private Map<I, E> getIndex() {
		if (modCount == lastModCount) { return index; }
		lastModCount = modCount;
		
		index = new HashMap<>(size());
		forEach(elem -> index.put(keyExtractor.apply(elem), elem));
		return index;
	}
	
	public E getByKey(I key) {
		return getIndex().get(key);
	}
}
