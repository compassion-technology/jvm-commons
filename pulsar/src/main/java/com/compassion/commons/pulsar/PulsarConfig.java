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
	private Path oauthFile;
	private String oauthAudience = "urn:sn:pulsar:o-xqpg6:devint";
	private String context;

	@JsonIgnore
	public String getServiceUrl() {
		return "pulsar+ssl://" + getHost() + ":" + getPort();	
	}
	
	@JsonIgnore
	public String getAdminUrl() {
		return "https://" + getHost();
	}
	
	String oauthParams() throws IOException {
		var params = new PulsarOAuthParams();
		try (var reader = Files.newBufferedReader(getOauthFile())) {
			params.setIssuerUrl(KeyFile.fromJson(reader).getIssuerUrl());
		}
		params.setPrivateKey(getOauthFile().toUri().toURL());
		params.setAudience(getOauthAudience());
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
}
