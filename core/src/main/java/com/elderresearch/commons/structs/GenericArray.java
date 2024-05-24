/* ©2016-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.commons.structs;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class GenericArray<T> {
	protected T[] array;
	protected Comparator<T> comp;
	
	public GenericArray(Class<T> c, int length) {
		resize(c, length);
	}
	
	public void setComparator(Comparator<T> comp) {
		this.comp = comp;
	}
	
	@SafeVarargs
	public GenericArray(T... array) {
		this.array = array;
	}
	
	@SuppressWarnings("unchecked")
	public GenericArray(Collection<T> c) {
		this((T[]) c.toArray());
	}
	
	@SuppressWarnings("unchecked")
	public void resize(Class<T> c, int size) {
		T[] temp = array;
		array = (T[]) Array.newInstance(c, size);
		if (temp != null) {
			System.arraycopy(temp, 0, array, 0, Math.min(size, temp.length));
		}
	}
	
	public T get(int i) { return array[i]; }
	public void set(int i, T t) { array[i] = t; }
	public int length() { return array.length; }
	
	public void sort() { Arrays.sort(array, comp); }
}
