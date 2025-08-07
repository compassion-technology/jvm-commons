package com.compassion.commons.rest.server.aws;

import java.io.IOException;

import io.dropwizard.auth.AuthFilter;
import io.dropwizard.auth.Authenticator;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.core.SecurityContext;

public class ApiKeyAuthFilter extends AuthFilter<String, ApiGatewayPrincipal> {
	private static final String API_KEY_HEADER = "x-api-key";

	public ApiKeyAuthFilter setAuthenticator(Authenticator<String, ApiGatewayPrincipal> a) {
		authenticator = a;
		return this;
	}
	
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
        var credentials = requestContext.getHeaders().getFirst(API_KEY_HEADER);
        if (!authenticate(requestContext, credentials, SecurityContext.BASIC_AUTH)) {
            throw unauthorizedHandler.buildException(prefix, realm);
	    }
	}
}
