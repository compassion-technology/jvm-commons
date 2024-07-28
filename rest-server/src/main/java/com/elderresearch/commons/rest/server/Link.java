/* ©2017-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.commons.rest.server;

import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;

import lombok.Getter;
import lombok.val;

/**
 * JSON-friendly class to help with links in <a href="https://en.wikipedia.org/wiki/HATEOAS">HATEOAS</a> services. 
 * Use the {@link LinkBuilder} to create {@link Link} instances and then return them as part of your returned bean 
 * to expose links to the caller.
 * 
 * @author <a href="mailto:dimeo@datamininglab.com">John Dimeo</a>
 * @see WithLinks
 * @since Feb 17, 2017
 */
@Getter
public class Link {
	/** Constant for relates to self. */
	public static final String SELF = "self";

	private String rel;
	private String href;

	/**
	 * Sets the "relates to" ({@code rel}) part of the link that informs the caller the context of the link.
	 * @param rel the context of the link
	 * @return this for method chaining
	 */
	@SuppressWarnings("hiding")
	public Link relatesTo(String rel) {
		this.rel = rel;
		return this;
	}

	/**
	 * Builds {@link Link} instances with a fluent API. 
	 */
	public static class LinkBuilder {
		private UriInfo uriInfo;
		private int commonSegs;
		
		/**
		 * Constructs a new link builder. You must call {@link #setUriInfo(UriInfo)} before using this builder; it is
		 * a separate method to facilitate injection.
		 * @param commonSegs the number of common path segments links should have with each request URI. This is usually
		 * one, but it depends on the path of the resource. For example, if a resource is declared with path
		 * {@code "/foo/bar"}, and the base URI is {@code "http://localhost:8080/"}, using one common segment would
		 * mean that the base URI for all links for request {@code "http://localhost:8080/foo/bar/123"} would be
		 * {@code "http://localhost:8080/foo/..."}. Two common segments would be {@code "http://localhost:8080/foo/bar/..."}.
		 * This ensures all links are absolute URIs.
		 */
		public LinkBuilder(int commonSegs) {
			this.commonSegs = commonSegs;
		}
		
		/**
		 * Sets the URI info for building the link HREFs. If you declare a link builder as a member of a Jersey resource
		 * and annotate it with {@link Context}, this method will be called automatically the URI will be proxied
		 * according to the current request.
		 * @param uriInfo the info with the base URI of the request
		 */
		public void setUriInfo(UriInfo uriInfo) {
			this.uriInfo = uriInfo;
		}

		/**
		 * Sets the destination ({@code href}) of the link, and any parameters to plug in to placeholders.
		 * @param href the link HREF
		 * @param params the URI parameters
		 * @return this for method chaining
		 */
		public Link to(String href, Object... params) {
			Link ret = new Link();
			
			val uriBuilder = uriInfo.getBaseUriBuilder();
			uriInfo.getPathSegments()
				.subList(0, commonSegs)
				.forEach(seg -> uriBuilder.path(seg.getPath()));
			
			ret.href = uriBuilder.path(href).build(params).toString();
			return ret;
		}
	}
}
