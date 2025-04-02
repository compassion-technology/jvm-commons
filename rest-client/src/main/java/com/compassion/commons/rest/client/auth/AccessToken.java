package com.compassion.commons.rest.client.auth;

import java.io.IOException;

import com.compassion.commons.rest.client.RecursiveTarget;
import com.compassion.commons.rest.client.RestClient;
import com.compassion.commons.rest.client.WebParam;

import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
public abstract class AccessToken {
	public static IAccessToken acquire(OAuthMethod method, OAuthAwareConfig config) throws IOException {
		log.info("Acquiring new access token for {}", config.baseUrl());
		
		try (var client = new RestClient(ClientBuilder.newBuilder())) {
			var ret = client.request(RecursiveTarget.newTarget(config.baseUrl()), config.authCreds())
				.post(Entity.json(null));
			
				if (ret.getStatus() < 200 || ret.getStatus() >= 300) {
					throw new IOException(
						String.format("Retrieving access token failed with status code %d and details: %s", ret.getStatus(), ret.readEntity(String.class)));
				}
			return ret.readEntity(method.getPojo());
		}
	}
	
	public interface IAccessToken {
		Boolean checkActive();
		WebParam providedSessionCreds();
	}
	
	@NoArgsConstructor @AllArgsConstructor @Getter
	public enum OAuthMethod {
		SALESFORCE(SFSessionResponse.class),
		OATMEAL(OatmealSessionResponse.class);
		
		private Class<? extends IAccessToken> pojo;
	}
	
	public interface OAuthAwareConfig {
		WebParam authCreds();
		WebParam sessionCreds();
		String getScope();
		String baseUrl();
	}
}
