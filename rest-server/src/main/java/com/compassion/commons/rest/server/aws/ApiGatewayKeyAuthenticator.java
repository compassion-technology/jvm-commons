package com.compassion.commons.rest.server.aws;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import software.amazon.awssdk.services.apigateway.ApiGatewayClient;

@Log4j2
@RequiredArgsConstructor(staticName = "forApi")
public class ApiGatewayKeyAuthenticator implements Authenticator<String, ApiGatewayPrincipal> {
	private final String apiId;
	private final Map<String, ApiGatewayPrincipal> map = new HashMap<>();
	
	public void reload() {
		map.clear();
		
		var client = ApiGatewayClient.create();
		client.getApiKeysPaginator(req -> req.includeValues(true)).forEach(resp -> resp.items().forEach(key -> {
			if (apiId.equals(key.tags().get("API"))) {
				map.put(key.value(), ApiGatewayPrincipal.forKey(key));
			}
		}));
		log.info("Loaded {} API keys from AWS", map.size());
	}
	
	@Override
	public Optional<ApiGatewayPrincipal> authenticate(String credentials) throws AuthenticationException {
		return Optional.ofNullable(map.get(credentials));
	}
}
