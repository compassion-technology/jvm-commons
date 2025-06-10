package com.compassion.commons.rest.server;

import com.compassion.commons.rest.server.Link.LinkBuilder;

import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;

/**
 * Parent class for Jersey resource classes. For convenience, this declares and configures a {@link LinkBuilder}
 * for adding HATEOAS links to your response objects, as well as providing utilities for returning downloadable files.
 * 
 * @author <a href="mailto:dimeo@datamininglab.com">John Dimeo</a>
 * @since Mar 1, 2017
 */
public abstract class RestResource {
	public static final String TEXT_YAML = "text/yaml";
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
