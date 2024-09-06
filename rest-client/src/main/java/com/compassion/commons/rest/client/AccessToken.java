package com.compassion.commons.rest.client;

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
	private static final String SCOPE_KEY = "scope", SCOPE_VALUE = "connect/read-Only", GRANT_TYPE = "grant_type",
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
	
	public static AccessToken acquire(String subDomain, String scope, String httpAuth) {
		log.info("Acquiring new access token for {}", subDomain);
		
		var client = new RestClient(ClientBuilder.newBuilder());
		client.setBase(String.format("https://%s.ci.org", subDomain))
			.addPerpetualParams(WebHeader.of(HttpHeaders.AUTHORIZATION, httpAuth));
		
		return client.request(RecursiveTarget.newTarget(DEF_ENDPOINT), WebQueryParam.of(GRANT_TYPE, CLIENT_CREDS),
				WebQueryParam.of(SCOPE_KEY, scope != null ? scope : SCOPE_VALUE))
			.get(AccessToken.class);
	}
}
