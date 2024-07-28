/* ©2017-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.commons.rest.server;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.compassion.commons.Utilities;

import lombok.Getter;

/**
 * Parent class for returned beans with <a href="https://en.wikipedia.org/wiki/HATEOAS">HATEOAS</a> links.
 * 
 * @author <a href="mailto:dimeo@datamininglab.com">John Dimeo</a>
 * @since Feb 18, 2017
 */
public interface WithLinks {
	List<Link> getLinks();
	
	/**
	 * Adds links to this object's list of related links.
	 * @param links one or more links to add
	 * @param <T> the type of the subclass of this class
	 * @return this (casted to the specific implementation/subclass) for method chaining
	 */
	default <T extends WithLinks> T with(Link... links) {
		getLinks().addAll(Arrays.asList(links));
		return Utilities.cast(this);
	}
	
	/**
	 * Base class that implements {@link WithLinks} for you if your bean class doesn't extend another class.
	 */
	class WithLinksBase implements WithLinks {
		@Getter private List<Link> links = new LinkedList<>();
	}
}
