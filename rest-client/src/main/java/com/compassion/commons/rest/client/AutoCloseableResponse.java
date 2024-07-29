package com.compassion.commons.rest.client;

import jakarta.ws.rs.core.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(staticName = "wrap")
public class AutoCloseableResponse implements AutoCloseable {
	@Getter
	private Response response;
	
	@Override
	public void close() {
		response.close();
	}
}
