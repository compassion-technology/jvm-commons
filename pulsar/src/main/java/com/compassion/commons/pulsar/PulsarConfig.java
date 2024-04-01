package com.compassion.commons.pulsar;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

import org.apache.commons.lang3.StringUtils;
import org.apache.pulsar.client.admin.PulsarAdmin;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.impl.auth.AuthenticationToken;
import org.apache.pulsar.client.impl.auth.oauth2.AuthenticationOAuth2;
import org.apache.pulsar.client.impl.auth.oauth2.KeyFile;
import org.apache.pulsar.common.util.ObjectMapperFactory;
import org.apache.pulsar.functions.LocalRunner;
import org.apache.pulsar.functions.LocalRunner.LocalRunnerBuilder;

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
	
	public PulsarAdmin newAdmin() throws IOException {
		var builder = PulsarAdmin.builder().serviceHttpUrl(getAdminUrl())
			.allowTlsInsecureConnection(true);
		if (oauthFile != null && Files.isReadable(oauthFile)) {
			builder.authentication(AuthenticationOAuth2.class.getName(), oauthParams());
		} else if (StringUtils.isNotBlank(adminToken)) {
			builder.authentication(AuthenticationToken.class.getName(), getAdminToken());				
		} else {
			builder.authentication(AuthenticationToken.class.getName(), getClientToken());
		}
		return builder.build();
	}
	
	public PulsarClient newClient() throws IOException {
		var builder = PulsarClient.builder().serviceUrl(getServiceUrl())
			.allowTlsInsecureConnection(true);
		if (oauthFile != null && Files.isReadable(oauthFile)) {
			builder.authentication(AuthenticationOAuth2.class.getName(), oauthParams());
		} else {
			builder.authentication(AuthenticationToken.class.getName(), getClientToken());	
		}
		return builder.build();
	}
	
	public LocalRunnerBuilder newLocalRunner() throws IOException {
		var builder = LocalRunner.builder().brokerServiceUrl(getServiceUrl())
			.tlsAllowInsecureConnection(true);
		if (oauthFile != null && Files.isReadable(oauthFile)) {
			builder.clientAuthPlugin(AuthenticationOAuth2.class.getName())
			       .clientAuthParams(oauthParams());
		} else {
			builder.clientAuthPlugin(AuthenticationToken.class.getName())
			       .clientAuthParams(getClientToken());	
		}
		return builder;
	}
	
	private String oauthParams() throws IOException {
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
