package com.compassion.commons.rest.server.aws;

import java.security.Principal;

import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;
import software.amazon.awssdk.services.apigateway.model.ApiKey;

@RequiredArgsConstructor(staticName = "forKey")
public class ApiGatewayPrincipal implements Principal {
	@Delegate
	private final ApiKey key;
	
	@Override
	public String getName() {
		return key.name();
	}
}
