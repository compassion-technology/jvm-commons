package com.compassion.commons.rest.client.auth;

import java.util.concurrent.TimeUnit;

import com.compassion.commons.rest.client.WebParam;
import com.compassion.commons.rest.client.WebParam.WebHeader;
import com.compassion.commons.rest.client.auth.AccessToken.IAccessToken;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.google.common.net.HttpHeaders;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Getter @Setter @Log4j2
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class OatmealSessionResponse implements IAccessToken {
	private String accessToken;
	private int expiresIn;
	private String tokenType;
	@JsonIgnore private long expiresAfter;
	
	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
		this.expiresAfter = System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(expiresIn - 5);
		log.info("Access token valid until {}", String.format("%1$tm/%1$td %1$tI:%1$tM:%1$tS", expiresAfter));
	}
	
	@Override
	public Boolean checkActive() {
		return accessToken != null && System.currentTimeMillis() <= getExpiresAfter();
	}

	@Override
	public WebParam providedSessionCreds() {
		return WebHeader.of(HttpHeaders.AUTHORIZATION, "Bearer " + getAccessToken());
	}
}
