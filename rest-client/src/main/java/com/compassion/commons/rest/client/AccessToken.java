package com.compassion.commons.rest.client;

import java.io.IOException;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.concurrent.TimeUnit;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.github.mizosoft.methanol.FormBodyPublisher;
import com.github.mizosoft.methanol.Methanol;
import com.github.mizosoft.methanol.MutableRequest;
import com.google.common.net.HttpHeaders;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AccessToken {
	private static final String SCOPE_KEY = "scope", SCOPE_VALUE = "connect/read-Only", GRANT_TYPE = "grant_type",
		CLIENT_CREDS = "client_credentials", CI_DOMAIN = "ci.org", DEF_ENDPOINT = "/oauth2/token";
	private static final ObjectMapper OM = new ObjectMapper();
	
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
	
	public static AccessToken acquire(String subDomain, String domain, String endpoint, String httpAuth) {
		log.info("Acquiring new access token for {}", subDomain);
		
		var body = FormBodyPublisher.newBuilder()
			.query(GRANT_TYPE, CLIENT_CREDS)
			.query(SCOPE_KEY,  SCOPE_VALUE)
			.build();
			
		var client = Methanol.newBuilder()
		    .baseUri(String.format("https://%s.%s", subDomain, domain == null ? CI_DOMAIN : domain))
		    .defaultHeader(HttpHeaders.AUTHORIZATION, httpAuth)
		    .build();
			
		try {
			var json = client.send(MutableRequest.POST(endpoint == null ? DEF_ENDPOINT : endpoint, body),
				BodyHandlers.ofString()).body();
			return OM.readValue(json, AccessToken.class);
		} catch (IOException | InterruptedException e) {
			throw new IllegalArgumentException("Error authenticating", e);
		}
	}
}
