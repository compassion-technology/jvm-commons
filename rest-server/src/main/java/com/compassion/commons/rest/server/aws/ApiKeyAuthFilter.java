package com.compassion.commons.rest.server.aws;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;

import io.dropwizard.auth.AuthFilter;
import io.dropwizard.auth.Authenticator;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.core.SecurityContext;

public class ApiKeyAuthFilter extends AuthFilter<String, ApiGatewayPrincipal> {
	static final String API_KEY_HEADER = "x-api-key";

	public ApiKeyAuthFilter() {
		prefix = null;
	}
	
	public ApiKeyAuthFilter setAuthenticator(Authenticator<String, ApiGatewayPrincipal> a) {
		authenticator = a;
		return this;
	}
	
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
        var credentials = requestContext.getHeaders().getFirst(API_KEY_HEADER);
        if (!authenticate(requestContext, StringUtils.stripToNull(credentials), SecurityContext.DIGEST_AUTH)) {
            throw unauthorizedHandler.buildException(prefix, realm);
	    }
	}
}
