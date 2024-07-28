/* ©2017-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.commons.rest.server;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalLong;
import java.util.function.Consumer;
import java.util.stream.Stream;

import org.glassfish.jersey.server.ContainerRequest;

import com.compassion.commons.LambdaUtils;
import com.google.common.base.Function;
import com.google.common.collect.Collections2;

import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.Setter;
import lombok.val;
import lombok.experimental.Accessors;

/**
 * A functional "switch" utility that registers callbacks for different requested media types (MIME types).
 * Clients can request a response type via an "Accept" header, and this utility allows you to transform the entity or
 * add headers to the response based on the requested type. To use this class:<ul>
 * <li>Instantiate a new instance providing your "raw" result entity to the constructor (this is the entity you
 * would've passed to {@link Response#ok(Object)})</li>
 * <li>Register a type handler for each type the user can request via a {@code forType} method. The types you register
 * should correspond to the types identified in the {@link Produces} annotation for this method.</li>
 * <li>Register a fallback handler if the requested type is not one of the specific types handled.</li>
 * <li>Call {@link #respond(ContainerRequest)} with the incoming request as the parameter. You can get the request by
 * declaring a method parameter of type {@link ContainerRequest} with a {@link Context} annotation.</li></ul>
 * For example:<pre>
 * 	return new AcceptHandler&lt;&gt;(users)
 *		.forType(TEXT_CSV,        $ &rarr; $.mapEntity(mapEach(CSVUser::new)))
 *		.forType(APPLICATION_CSV, $ &rarr; $.mapEntity(mapEach(CSVUser::new))).fileName("users.csv"))
 *		.fallback(                $ &rarr; $.mapEntity(mapEach(JSONUser::new)))
 *		.respond(req);
 * </pre>
 * In this example, the result is a list of "raw" user objects. If the caller requested a CSV variant, they are 
 * transformed to beans suitable for serializing to CSV, but by default they are transformed to JSON friendly beans.
 * If the caller requested {@code "application/csv"}, headers are added to the response to make it appear to the browser
 * as a downloadable file with name "users.csv".
 * 
 * @author <a href="mailto:dimeo@datamininglab.com">John Dimeo</a>
 * @since May 27, 2017
 * @param <T> the entity/result type
 */
@Accessors(chain = true, fluent = true)
public class AcceptHandler<T> {
	private T entity;
	private Map<String, AcceptTypeHandler<T>> handlers = new HashMap<>();
	
	/**
	 * Create a new Accept header handler.
	 * @param entity the response entity
	 */
	public AcceptHandler(T entity) {
		this.entity = entity;
	}
	
	private AcceptTypeHandler<T> getOrAdd(String type) {
		return handlers.computeIfAbsent(type, $ -> new AcceptTypeHandler<>());
	}

	/**
	 * Register a type-specific handler.
	 * @param type the media type as a string
	 * @param callback this callback will be invoked with the existing handler for the type (if one exists), or a new
	 * handler that was registered for the type. You should call methods on the callback's parameter to customize
	 * the handler's behavior.
	 * @return this for method chaining
	 */
	public AcceptHandler<T> forType(String type, Consumer<AcceptTypeHandler<T>> callback) {
		callback.accept(getOrAdd(type));
		return this;
	}
	
	/**
	 * Register a type-specific handler.
	 * @param type the media type as a {@link MediaType}
	 * @param callback this callback will be invoked with the existing handler for the type (if one exists), or a new
	 * handler that was registered for the type. You should call methods on the callback's parameter to customize
	 * the handler's behavior.
	 * @return this for method chaining
	 */
	public AcceptHandler<T> forType(MediaType type, Consumer<AcceptTypeHandler<T>> callback) {
		return forType(type.toString(), callback);
	}
	
	/**
	 * Customize the behavior of the default handler when no other types match.
	 * @param callback this callback will be invoked with the default handler when no other types match. You should call
	 * methods on the callback's parameter to customize the handler's behavior.
	 * @return this for method chaining
	 */
	public AcceptHandler<T> fallback(Consumer<AcceptTypeHandler<T>> callback) {
		return forType(MediaType.WILDCARD, callback);
	}
	
	private AcceptHandler<T> forTypes(Consumer<AcceptTypeHandler<T>> callback, Stream<String> types) {
		val ret = new AcceptTypeHandler<T>();
		types.forEach(type -> handlers.put(type, ret));
		callback.accept(ret);
		return this;
	}
	
	/**
	 * Register a handler for one or more types. Unlike {@link #forType(MediaType, Consumer)}, this will overwrite
	 * any previously registered handler for the type(s).
	 * @param callback this callback will be invoked with the newly created handler for the type(s). You should call
	 * methods on the callback's parameter to customize the handler's behavior.
	 * @param types one or more media types
	 * @return this for method chaining
	 */
	public AcceptHandler<T> forTypes(Consumer<AcceptTypeHandler<T>> callback, MediaType... types) {
		return forTypes(callback, Stream.of(types).map(Object::toString));
	}
	
	/**
	 * Register a handler for one or more types. Unlike {@link #forType(String, Consumer)}, this will overwrite
	 * any previously registered handler for the type(s).
	 * @param callback this callback will be invoked with the newly created handler for the type(s). You should call
	 * methods on the callback's parameter to customize the handler's behavior.
	 * @param types one or more media types
	 * @return this for method chaining
	 */
	public AcceptHandler<T> forTypes(Consumer<AcceptTypeHandler<T>> callback, String... types) {
		return forTypes(callback, Stream.of(types)); 
	}
	
	@Setter
	@Accessors(chain = true, fluent = true)
	public static final class AcceptTypeHandler<T> {
		/**
		 * Transform the response entity into a new type. If your result is a collection, consider using
		 * {@link AcceptHandler#mapEach(Function)} to transform each element in the collection.
		 */
		private Function<T, ?> mapEntity;
		
		/** Add a "Content-Disposition" header to the response with the specified attachment file name. */
		private String fileName;
		
		/** Add a "Content-Length" header to the response with the specified file length (in bytes). */
		private OptionalLong fileLength = OptionalLong.empty();
		
		private AcceptTypeHandler() {
			// Must be instantiated from parent handler
		}
		
		private Response respond(T entity) {
			Object mapped = mapEntity == null? entity : mapEntity.apply(entity);
			val ret = Response.ok(mapped);
			fileLength.ifPresent(l -> ret.header("Content-Length", l));
			LambdaUtils.accept(fileName, n -> ret.header("Content-Disposition", "attachment; filename=" + n));
			return ret.build();
		}
	}
	
	/**
	 * Create a new response using {@link Response#ok(Object)}, mapping the entity if applicable and adding any
	 * headers before building the response and returning it.
	 * @param req the client's request with a possible "Accept" header specifying the desired response format
	 * @return the response
	 */
	public Response respond(ContainerRequest req) {
		return Optional.ofNullable(handlers.get(req.getHeaderString("Accept")))
			.orElseGet(() -> getOrAdd(MediaType.WILDCARD))
			.respond(entity);
	}
	
	/**
	 * Create a function that maps each element of a collection with another function.
	 * @param <I> the original element type
	 * @param <O> the transformed element type
	 * @param <T> the collection type
	 * @param fn the function to map each element
	 * @return a function that maps a collection to a new collection where each element has been transformed
	 */
	public static <I, O, T extends Collection<I>> Function<T, Collection<O>> mapEach(Function<I, O> fn) {
		return c -> Collections2.transform(c, fn);
	}
}
