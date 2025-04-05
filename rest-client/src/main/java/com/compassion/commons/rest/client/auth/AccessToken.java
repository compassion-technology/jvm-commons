package com.compassion.commons.rest.client.auth;

import java.io.IOException;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.Response.Status.Family;

import com.compassion.commons.rest.client.RecursiveTarget;
import com.compassion.commons.rest.client.RestClient;
import com.compassion.commons.rest.client.WebParam;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

@Log4j2
public abstract class AccessToken {
	public static IAccessToken acquire(RestClient client, OAuthMethod method, OAuthAwareConfig config) throws IOException {
		log.info("Acquiring new access token at {}", config.authUrl());
		
		var ret = client.request(RecursiveTarget.newTarget(config.authUrl()), config.authCreds())
			.post(method.getRequestBody());
		
		if (ret.getStatusInfo().getFamily() != Family.SUCCESSFUL) {
			throw new IOException(
				String.format("Retrieving access token failed with status code %d and details: %s", ret.getStatus(), ret.readEntity(String.class)));
		}
		return ret.readEntity(method.getPojo());
	}
	
	public interface IAccessToken {
		Boolean checkActive();
		WebParam providedSessionCreds();
	}
	
	@AllArgsConstructor @Getter
	public enum OAuthMethod {
		SALESFORCE(SFSessionResponse.class, Entity.json(null)),
		OATMEAL(OatmealSessionResponse.class, Entity.form(new Form()));
		
		private Class<? extends IAccessToken> pojo;
		private Entity<?> requestBody;
	}
	
	public interface OAuthAwareConfig {
		WebParam authCreds();
		WebParam sessionCreds();
		String getScope();
		String authUrl();
	}
}
