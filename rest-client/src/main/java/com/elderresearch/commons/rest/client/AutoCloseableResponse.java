/* ©2018-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.commons.rest.client;

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
