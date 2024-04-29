package com.compassion.commons.pulsar;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

import org.apache.pulsar.client.impl.auth.oauth2.KeyFile;
import org.apache.pulsar.common.util.ObjectMapperFactory;

import com.compassion.commons.config.YAMLConfig;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain = true)
public class PulsarConfig extends YAMLConfig implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String host = "devint-a200530c-d9e7-4e99-8cdc-6a719deb6326.aws-use2-production-snci-pool-kid.streamnative.aws.snio.cloud";
	private int port = 6651;
	private String clientToken;
	private String adminToken;
	private PulsarOAuthConfig oauth = new PulsarOAuthConfig();
	private String context;

	public PulsarConfig() {
		getOauth().setType("sn_service_account");
		getOauth().setIssuerUrl("https://auth.streamnative.cloud/");
	}
	
	@JsonIgnore
	public String getServiceUrl() {
		return "pulsar+ssl://" + getHost() + ":" + getPort();	
	}
	
	@JsonIgnore
	public String getAdminUrl() {
		return "https://" + getHost();
	}
	
	String oauthParams() throws IOException {
		if (oauth.getFile() == null) {
			oauth.setFile(Files.createTempFile("oauth", ".json"));
			Files.writeString(oauth.getFile(), oauth.toJson());
		} else {
			try (var reader = Files.newBufferedReader(getOauth().getFile())) {
				oauth = ObjectMapperFactory.getMapper().reader().readValue(reader, PulsarOAuthConfig.class);
			}
		}
		
		var params = new PulsarOAuthParams();
		params.setIssuerUrl(getOauth().getIssuerUrl());
		params.setPrivateKey(getOauth().getFile().toUri().toURL());
		params.setAudience(getOauth().getAudience());
		return ObjectMapperFactory.getMapper().getObjectMapper().writeValueAsString(params);
	}
	
	// See https://pulsar.apache.org/docs/next/security-oauth2/#configure-oauth2-authentication-in-pulsar-clients
	@Getter @Setter
	private static class PulsarOAuthParams {
		private String type = "client_credentials";
		private String issuerUrl;
		private URL privateKey;
		private String audience;
		private String scope;
	}
	
	@Getter @Setter
	public static class PulsarOAuthConfig extends KeyFile {
		private String audience = "urn:sn:pulsar:o-xqpg6:devint";
		private Path file;
	}
}
