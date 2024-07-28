/* ©2017-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.commons.rest.server;

import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;

import com.elderresearch.commons.rest.server.Link.LinkBuilder;

/**
 * Parent class for Jersey resource classes. For convenience, this declares and configures a {@link LinkBuilder}
 * for adding HATEOAS links to your response objects, as well as providing utilities for returning downloadable files.
 * 
 * @author <a href="mailto:dimeo@datamininglab.com">John Dimeo</a>
 * @since Mar 1, 2017
 */
public abstract class RestResource {
	public static final String TEXT_CSV = "text/csv";
	public static final String APPLICATION_CSV = "application/csv";
	
	protected LinkBuilder link = new LinkBuilder(1);
	
	@Context
	public void setUriInfo(UriInfo uriInfo) {
		link.setUriInfo(uriInfo);
	}

	protected static <T> AcceptHandler<T> handleAccept(T entity) {
		return new AcceptHandler<>(entity);
	}
}
