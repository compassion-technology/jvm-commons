package com.compassion.commons.rest.client.auth;

import org.apache.commons.lang3.StringUtils;

import com.compassion.commons.rest.client.WebParam;
import com.compassion.commons.rest.client.WebParam.WebHeader;
import com.compassion.commons.rest.client.auth.AccessToken.IAccessToken;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.google.common.net.HttpHeaders;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SFSessionResponse implements IAccessToken {
	
	private String accessToken;
	private String instanceUrl;
	private String tokenType;
	private String issuedAt;
	private String id, signature;
	
	@Override
	public Boolean checkActive() {
		// Salesforce does not provide expiration details so status is only known when a request fails.
		return true;
	}
	@Override
	public WebParam providedSessionCreds() {
		return WebHeader.of(HttpHeaders.AUTHORIZATION, StringUtils.joinWith(" ", getTokenType(), getAccessToken()));
	}
}
