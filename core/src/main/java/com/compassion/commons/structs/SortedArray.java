package com.compassion.commons.structs;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Provides a continually sorted, high performance fixed length array of
 * comparable elements. This class is <b>not</b> thread-safe.
 * 
 * @author <a href="dimeo@datamininglab.com">John Dimeo</a>
 * @param <T> the type of elements in the array
 * @since Jul 6, 2013
 */
public class SortedArray<T> extends GenericArray<T> implements Iterable<T> {
	private static final int DEFAULT_SORT_BUFFER = 1024;
	
	private int index;
	private int maxSize;
	private boolean potentiallyUnsorted;
	
	private T smallest;
	private T largest;
	
	/**
	 * Create a new sorted array.
	 * @param length the fixed size of the array
	 * @param maxValue a value representing the maximum possible value allowed
	 * to be added to this array; that is, any element {@code e} added to this
	 * array where {@code e.compareTo(maxValue)} will not be added. This must
	 * not be {@code null} as to avoid ambiguity associated with {@code null}
	 * sort order.
	 */
	public SortedArray(int length, T maxValue) {
		this(length, maxValue, DEFAULT_SORT_BUFFER);
	}
	
	/**
	 * Create a new sorted array.
	 * @param length the fixed size of the array
	 * @param maxValue a value representing the maximum possible value allowed
	 * to be added to this array; that is, any element {@code e} added to this
	 * array where {@code e.compareTo(maxValue)} will not be added. This must
	 * not be {@code null} as to avoid ambiguity associated with {@code null}
	 * sort order.
	 * @param sortBuffer the number of elements to add before resorting the
	 * array. If this is {@code 0}, you will not be able to use {@link #add(Object)}.
	 * If this is {@code 1}, the array will be resorted on every call to
	 * {@link #add(Object)}. If this is greater than {@code 1}, the array
	 * will be sorted every {@code sortBuffer} adds, or when a method like
	 * {@link #get(int)} or {@link #iterator()} requires a sorted array.
	 */
	@SuppressWarnings("unchecked")
	public SortedArray(int length, T maxValue, int sortBuffer) {
		// Allocate an array some fixed size larger than the ultimate max size.
		// This allows us to add a batch of elements "past" the limit
		// to avoid resorting on every add once the array fills.
		super((Class<T>) maxValue.getClass(), length + sortBuffer);
		this.maxSize = length;
		
		// Prefill with the maximum to avoid null check code and guarantee that
		// all values will be less than the maximum value
		smallest = maxValue;
		largest = maxValue;
		for (int i = 0; i < array.length; i++) { array[i] = maxValue; }
	}
	
	/**
	 * Extends the semantics of an array to allow "adding" to this array. By using
	 * this method to fill the array, you can add elements to this array, even
	 * past it's length, and guarantee that the smallest {@link #length()} elements
	 * will be retained, while avoiding a resort on every invocation.
	 * @param element the element to add
	 * @return if it was added to this array. Elements will be rejected if they
	 * are larger than the current {@link #getLargest() largest value}.
	 */
	public boolean add(T element) {
		if (element == null) {
			throw new NullPointerException("You may not add null elements to a " + getClass().getSimpleName());
		}
		
		// If we are greater than the largest element, don't bother adding since
		// we are guaranteed to be sorted out
		if (comp == null) {
			@SuppressWarnings("unchecked")
			Comparable<T> c1 = (Comparable<T>) element;
			if (c1.compareTo(getLargest()) > 0) { return false; }		
		} else {
			if (comp.compare(element, getLargest()) > 0) { return false; }
		}
		
		// Otherwise, add the element at the current position. Don't use set()
		// as we want to bypass normal bounds checking
		array[index++] = element;
		potentiallyUnsorted = true;
		
		// If the new position is the max size, sort the array since we will
		// being comparing new elements to the maximum element (above)
		if (index == maxSize) { sort(); }
		
		// If the new position is the total length, sort the array and begin
		// overwriting the "sort buffer" with new elements until the next sort
		if (index == array.length) {
			sort();
			index = maxSize;
		}
		return true;
	}
	
	/**
	 * Return the smallest element in the array. The array will be resorted before
	 * returning if needed.
	 * @return the smallest (first) element in the array
	 */
	public T getSmallest() { return smallest; }
	
	/**
	 * Gets the largest element in the array. The array will be resorted before
	 * returning if needed.
	 * @return the largest (last) element in the array
	 */
	public T getLargest() { return largest; }
	
	@Override
	public T get(int i) {
		if (i < maxSize) {
			sort();
			return super.get(i);
		}
		throw new ArrayIndexOutOfBoundsException(i);
	}
	
	@Override
	public void set(int i, T t) {
		if (i < maxSize) { 
			potentiallyUnsorted = true;
			super.set(i, t);
		} else {
			throw new ArrayIndexOutOfBoundsException(i);
		}
	}
	
	@SuppressWarnings("unchecked")
	public SortedArray<T> compact() {
		super.resize((Class<T>) smallest.getClass(), maxSize);
		return this;
	}
	
	@Override
	public Iterator<T> iterator() {
		sort();
		List<T> l = Arrays.asList(array);
		if (l.size() > maxSize) { l = l.subList(0, maxSize); }
		return l.iterator();
	}

	@Override
	public int length() { return maxSize; }
	
	@Override
	public void sort() {
		if (potentiallyUnsorted) {
			super.sort();
			smallest = array[0];
			largest = array[maxSize - 1];
		}
		potentiallyUnsorted = false;
	}
}
