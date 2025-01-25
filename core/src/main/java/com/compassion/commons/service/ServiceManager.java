package com.compassion.commons.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import java.util.function.Function;

/**
 * Utilities around the {@link ServiceLoader} API. Orders implementations of a given service by some ordering (a
 * priority enum is provided for convenience), and applies some function to each in turn.
 * 
 * @author <a href="mailto:dimeo@datamininglab.com">John Dimeo</a>
 * @param <S> the service type
 * @since Sep 20, 2016
 */
public class ServiceManager<S> implements Iterable<S> {
	public enum ServiceImplPriority {
		/** The default or reference implementation of the service if no others exist. */
		REFERENCE,
		/** Use this implementation instead of the reference implementation, but use all others instead of this. */
		TERTIARY,
		/** Use this implementation only if no primary or override implementations are present. */
		SECONDARY,
		/** The best or preferred implementation to use. */
		PRIMARY,
		/** Use this implementation instead of all other available implementations. */
		OVERRIDE
	}
	
	private List<S> impls;
	
	@SafeVarargs
	public ServiceManager(Class<S> c, Function<S, ServiceImplPriority> priority, S... builtInServices) {
		this(c, Comparator.comparing(priority).reversed(), builtInServices);
	}
	
	@SafeVarargs
	public ServiceManager(Class<S> c, Comparator<S> priority, S... builtInServices) {
		impls = new ArrayList<>();
		for (S impl : builtInServices)       { impls.add(impl); }
		for (S impl : ServiceLoader.load(c)) { impls.add(impl); }
		impls.sort(priority);
		
		if (impls.isEmpty()) {
			throw new IllegalStateException("At least one implemetation must be present between loaded services and built in implementations");
		}
	}
	
	/**
	 * Apply the function to the highest priority service that returns a value.
	 * @param fn the function to apply
	 * @param <T> the output type
	 * @return the output of the highest priority service, or {@code null} if all available implementations returned
	 * {@code null}
	 */
	public <T> T apply(Function<S, T> fn) {
		for (S impl : this) {
			T ret = fn.apply(impl);
			if (ret != null) { return ret; }
		}
		return null;
	}
	
	/**
	 * Returns an iterator over implementations for the service, ordered by priority.
	 */
	@Override
	public Iterator<S> iterator() {
		return impls.iterator();
	}
}
