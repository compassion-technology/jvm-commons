/* ©2017-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.commons.rest.client;

import java.util.function.Consumer;
import java.util.function.Function;

import org.apache.commons.lang3.BooleanUtils;

import com.compassion.commons.LambdaUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import lombok.val;
import lombok.extern.log4j.Log4j2;

/**
 * Convenience base class for JSON entities that can persist (usually one of the CRUD HTTP ops - PUT, POST, or DELETE)
 * to a REST API. 
 * 
 * @author <a href="mailto:dimeo@elderresearch.com">John Dimeo</a>
 * @since Nov 8, 2017
 */
@Log4j2
public abstract class JSONPersistable {
	private WebParam[] reqParams = new WebParam[0];
	
	/**
	 * Sets additional parameters to send with the persist request.
	 * @param reqParams optional additional parameters to send with the request
	 * @return this for method chaining
	 */
	public JSONPersistable setRequestParams(WebParam... reqParams) {
		this.reqParams = reqParams;
		return this;
	}
	
	/**
	 * Do the actual persist operation using a Jersey request.
	 * @param entity this object wrapped in a JSON entity
	 * @param params any additional parameters to add to the persist call
	 * @return the response of the Jersey request
	 */
	protected abstract Response persist(Entity<?> entity, WebParam... params);
	
	/**
	 * Some way of uniquely identifying this entity. This is only used when logging a problem persisting in
	 * {@link #persist()}, but frequently the implementation of {@link #persist(Entity, WebParam...)} will include using this
	 * ID as a template or query parameter in the URL.
	 * @return the ID that uniquely identifies this entity
	 */
	@JsonIgnore
	protected abstract Object getId();

	/**
	 * Persist this entity to a REST API and return the result as a Java type. If there is a problem (the returned HTTP
	 * status code is not in the {@link javax.ws.rs.core.Response.Status.Family#SUCCESSFUL} family), the response code
	 * and reason will be logged as a warning and {@code null} returned.
	 * @param c the response class
	 * @param <T> the response type
	 * @return the response or {@code null} if there was a problem persisting this entity
	 * @see Response#readEntity(Class)
	 */
	public <T> T persist(Class<T> c) { return persist($ -> $.readEntity(c), null); }
	
	/**
	 * Persists this entity to a REST API. If there is a problem (the returned HTTP status code is not in the 
	 * {@link javax.ws.rs.core.Response.Status.Family#SUCCESSFUL} family), the response code and reason will be logged
	 * as a warning and {@code false} returned.
	 * @return if the persist was successful
	 */
	public boolean persist() { return BooleanUtils.toBoolean(this.<Boolean>persist($ -> true, null)); }
	
	/**
	 * Persists this entity to a REST API and return a custom result based on the response. If there is a problem
	 * (the returned HTTP status code is not in the {@link javax.ws.rs.core.Response.Status.Family#SUCCESSFUL} family),
	 * the response code and reason will be logged as a warning, {@code onFail} invoked, and {@code null} returned.
	 * @param <T> the response type
	 * @param onSuccess the callback to invoke to produce the successful result from the response
	 * @param onFail the callback to invoke with the raw response if the persist was not successful
	 * @return the result of the persist operation or {@code null} if it was not successful
	 * @see Response
	 */
	public <T> T persist(Function<Response, T> onSuccess, Consumer<Response> onFail) {
		try  (val r = AutoCloseableResponse.wrap(persist(Entity.json(this), reqParams))) {
			val status = r.getResponse().getStatusInfo();
			if (status.getFamily() == Status.Family.SUCCESSFUL) {
				return onSuccess.apply(r.getResponse());
			}
			
			log.warn("Could not persist {} {}: {} ({})",
				getClass().getSimpleName(), getId(), status.getStatusCode(), status.getReasonPhrase());
			LambdaUtils.accept(r.getResponse(), onFail);
			return  null;
		}
	}
}

