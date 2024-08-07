package com.compassion.commons.structs;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Combines "copy on write" thread safety, set operations, and the observer pattern
 * into a single collection.
 *
 * @author <a href="mailto:dimeo@datamininglab.com">John Dimeo</a>
 * @param <T> the type of objects in the list
 * @since Jul 25, 2014
 */
public class ObservableSet<T> implements Set<T> {
	/**
	 * Callback for when the elements of an {@link ObservableSet} changes.
	 * @param <T> the type of objects in the set
	 */
	public interface SetObserver<T> {
		/**
		 * This method is invoked when the elements of the set change.
		 * @param list the modified list after the modification
		 */
		void elementsChanged(Set<T> list);
	}

	private List<SetObserver<T>> observers = new CopyOnWriteArrayList<>();
	private SetObserver<T> toSkip;
	private volatile Set<T> set;

	/**
	 * Creates a new, empty observable list.
	 */
	public ObservableSet() {
		set = new HashSet<>();
	}
	/**
	 * Creates a new observable set with the contents of {@code c}.
	 * @param c the existing elements to use
	 */
	public ObservableSet(Collection<? extends T> c) {
		set = new HashSet<>(c);
	}

	/**
	 * Gets the list of observers of this set. This is the actual list, so you
	 * can add, remove, etc. listeners using the returned list.  Adding and
	 * removing listeners is thread-safe.
	 * @return the the list of observers for this set
	 */
	public List<SetObserver<T>> getObservers() {
		return observers;
	}

	/**
	 * Convenience method to add an observer.
	 * @param obs the new observer to add
	 * @return this for method chaining
	 * @see #getObservers()
	 */
	public ObservableSet<T> addObserver(SetObserver<T> obs) {
		getObservers().add(obs);
		return this;
	}

	/**
	 * Does not notify the observer on the next modification to the set. This
	 * is usually one of observers added to the list of observers but also the
	 * one originating the modification and so it would be redundant to notify it.
	 * @param toSkip the observer to skip
	 * @return this for method chaining
	 */
	@SuppressWarnings("hiding")
	public ObservableSet<T> skip(SetObserver<T> toSkip) {
		this.toSkip = toSkip;
		return this;
	}

	@Override
	public boolean contains(Object o) {
		return set.contains(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return set.containsAll(c);
	}

	@Override
	public Iterator<T> iterator() {
		return set.iterator();
	}

	@Override
	public boolean isEmpty() {
		return set.isEmpty();
	}

	@Override
	public int size() {
		return set.size();
	}

	@Override
	public Object[] toArray() {
		return set.toArray();
	}

	@Override
	public <U> U[] toArray(U[] a) {
		return set.toArray(a);
	}

	private Set<T> copySet() {
		return new HashSet<>(set);
	}

	@Override
	public boolean add(T e) {
		Set<T> copy = copySet();
		if (copy.add(e)) {
			setAndNotify(copy);
			return true;
		}
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		Set<T> copy = copySet();
		if (copy.addAll(c)) {
			setAndNotify(copy);
			return true;
		}
		return false;
	}

	@Override
	public void clear() {
		setAndNotify(new HashSet<>());
	}

	@Override
	public boolean remove(Object o) {
		Set<T> copy = copySet();
		if (copy.remove(o)) {
			setAndNotify(copy);
			return true;
		}
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		Set<T> copy = copySet();
		if (copy.removeAll(c)) {
			setAndNotify(copy);
			return true;
		}
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		Set<T> copy = copySet();
		if (copy.retainAll(c)) {
			setAndNotify(copy);
			return true;
		}
		return false;
	}

	/**
	 * Combines {@link #clear()} and {@link #addAll(Collection)} in one action
	 * only notifying observers once.
	 * @param c the new contents of the set
	 * @see #set(Object...)
	 */
	public void set(Collection<? extends T> c) {
		setAndNotify(new HashSet<>(c));
	}

	/**
	 * Combines {@link #clear()} and {@link #addAll(Collection)} in one action
	 * only notifying observers once.
	 * @param array the new contents of the set
	 * @see #set(Collection)
	 */
	@SafeVarargs
	public final void set(T... array) {
		set(Arrays.asList(array));
	}

	/**
	 * Sets the new contents of the set to be the passed in set without copying.
	 * Observers will be notified of the new contents. <b>Warning:</b> advanced use only.
	 * @param set the new contents of the set
	 */
	public void setNoCopy(Set<T> set) {
		setAndNotify(set);
	}

	private void setAndNotify(Set<T> set) {
		this.set = set;

		for (SetObserver<T> obs : observers) {
			if (obs != toSkip) {
				obs.elementsChanged(this);
			}
		}
		toSkip = null;
	}
}
