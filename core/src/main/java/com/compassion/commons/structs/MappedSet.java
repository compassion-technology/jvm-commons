package com.compassion.commons.structs;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class MappedSet<K, V> extends HashMap<K, Set<V>> {
	private Comparator<V> setSorter;
	public MappedSet() {
		this(null);
	}
	public MappedSet(Comparator<V> setSorter) {
		this.setSorter = setSorter;
	}
	
	private Set<V> getSet(K key) {
		Set<V> set = get(key);
		if (set == null) {
			if (setSorter == null) {
				set = new HashSet<>();
			} else {
				set = new TreeSet<>(setSorter);
			}
			put(key, set);
		}
		return set;
	}
	
	public boolean add(K key, V value) {
		return getSet(key).add(value);
	}
	
	public boolean addAll(K key, Collection<? extends V> values) {
		return getSet(key).addAll(values);
	}
	
	public boolean removeValue(K key, V value) {
		Set<V> set = get(key);
		if (set == null) { return false; }
		return set.remove(value);
	}
	
	public boolean removeAll(K key, Collection<? extends V> values) {
		Set<V> set = get(key);
		if (set == null) { return false; }
		return set.removeAll(values);
	}
	
	public boolean contains(K key, V value) {
		Set<V> set = get(key);
		if (set == null) {  return false; }
		return set.contains(value);
	}
	
	@Override
	public int size() {
		int size = 0;
		for (Set<V> set : values()) { size += set.size(); }
		return size;
	}
}
