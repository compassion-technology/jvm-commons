package com.compassion.commons.rest.client.auth;

import java.util.concurrent.TimeUnit;

import com.compassion.commons.rest.client.WebParam.WebHeader;
import com.compassion.commons.rest.client.WebParam.WebQueryParam;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.google.common.net.HttpHeaders;

import jakarta.ws.rs.client.ClientBuilder;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AccessToken {
	private static final String SCOPE_KEY = "scope", GRANT_TYPE = "grant_type",
		CLIENT_CREDS = "client_credentials", DEF_ENDPOINT = "/oauth2/token";
	
	private String accessToken;
	private int expiresIn;
	private String tokenType;
	
	@JsonIgnore
	private long expiresAfter;
	
	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
		this.expiresAfter = System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(expiresIn - 5);
		log.info("Access token valid until {}", String.format("%1$tm/%1$td %1$tI:%1$tM:%1$tS", expiresAfter));
	}
	
	public static AccessToken acquire(AuthEnvironment env, String scope, WebHeader httpAuth) {
		log.info("Acquiring new access token for {}", env.getAuthSubdomain());
		
		try (var client = new RestClient(ClientBuilder.newBuilder())) {
			client.setBase(String.format("https://%s.ci.org", env.getAuthSubdomain()))
				.addPerpetualParams(httpAuth);
		
			return client.request(RecursiveTarget.newTarget(DEF_ENDPOINT), WebQueryParam.of(GRANT_TYPE, CLIENT_CREDS),
				WebQueryParam.of(SCOPE_KEY, scope))
					.get(AccessToken.class);
		}
	}
}
