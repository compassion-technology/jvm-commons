package com.compassion.commons.rest.server.aws;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.compassion.commons.config.CIEnvironment;

import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import software.amazon.awssdk.services.apigateway.ApiGatewayClient;

@Log4j2
@RequiredArgsConstructor(staticName = "forApi")
public class ApiGatewayKeyAuthenticator implements Authenticator<String, ApiGatewayPrincipal> {
	private final String apiId;
	private final Map<String, ApiGatewayPrincipal> map = new HashMap<>();

	private Instant lastReloaded;
	
	@Setter
	private Duration reloadInterval = Duration.ofHours(4);
	@Setter
	private CIEnvironment environment;
	
	public void reload() {
		map.clear();
		
		var client = ApiGatewayClient.create();
		client.getApiKeysPaginator(req -> req.includeValues(true)).forEach(resp -> resp.items().forEach(key -> {
			if (!apiId.equals(key.tags().get("API"))) {
				log.debug("Skipping API key {} {}, wrong API", key.id(), key.name());
				return;
			}
			
			if (environment != null && CIEnvironment.valueOf(key.tags().get("Environment")) != environment) {
				log.debug("Skipping API key {} {}, wrong environment", key.id(), key.name());
				return;
			} 
			
			map.put(key.value(), ApiGatewayPrincipal.forKey(key));
		}));
		log.info("Loaded {} API keys from AWS for API {}", map.size(), apiId);
		lastReloaded = Instant.now();
	}
	
	@Override
	public Optional<ApiGatewayPrincipal> authenticate(String credentials) throws AuthenticationException {
		if (lastReloaded == null || Duration.between(lastReloaded, Instant.now()).compareTo(reloadInterval) > 0) {
			reload();
		}
		
		return Optional.ofNullable(map.get(credentials));
	}
}
