package com.compassion.commons.rest.client;

import jakarta.ws.rs.client.Invocation;

import org.apache.commons.lang3.ArrayUtils;

import com.compassion.commons.rest.client.WebParam.WebTemplateParam;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter @Accessors(fluent = true)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class RestEndpoint {
	@Getter private static final String idTemplate = "{id}";
	public static WebTemplateParam idParam(Object id) { return WebTemplateParam.of("id", id); }

	private final RestClient client;
	private final RecursiveTarget target;
	
	public Invocation.Builder request(WebParam... params) {
		return client.request(target, params);
	}
	
	public static abstract class RestEndpointWithId extends RestEndpoint {
		protected RestEndpointWithId(RestClient client, RecursiveTarget target) { super(client, target); }
		
		public Invocation.Builder request(Object id, WebParam... params) {
			return request(ArrayUtils.add(params, idParam(id)));
		}
	}
	
	public static abstract class RestEndpointWithIdInt extends RestEndpoint {
		protected RestEndpointWithIdInt(RestClient client, RecursiveTarget target) { super(client, target); }
		
		public Invocation.Builder request(int id, WebParam... params) {
			return request(ArrayUtils.add(params, idParam(id)));
		}
	}
	
	public static abstract class RestEndpointWithIdString extends RestEndpoint {
		protected RestEndpointWithIdString(RestClient client, RecursiveTarget target) { super(client, target); }
		
		public Invocation.Builder request(String id, WebParam... params) {
			return request(ArrayUtils.add(params, idParam(id)));
		}
	}
}
