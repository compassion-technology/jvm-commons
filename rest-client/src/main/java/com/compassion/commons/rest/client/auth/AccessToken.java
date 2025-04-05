package com.compassion.commons.rest.client.auth;

import java.io.IOException;

import com.compassion.commons.rest.client.RecursiveTarget;
import com.compassion.commons.rest.client.RestClient;
import com.compassion.commons.rest.client.WebParam;

import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.Form;
import jakarta.ws.rs.core.Response.Status.Family;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

@Log4j2
public abstract class AccessToken {
	public static IAccessToken acquire(OAuthMethod method, OAuthAwareConfig config) throws IOException {
		log.info("Acquiring new access token for {}", config.baseUrl());
		
		try (var client = new RestClient(ClientBuilder.newBuilder())) {
			var ret = client.request(RecursiveTarget.newTarget(config.baseUrl()), config.authCreds())
				.post(method.getRequestBody());
			
			if (ret.getStatusInfo().getFamily() != Family.SUCCESSFUL) {
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
		String baseUrl();
	}
}
