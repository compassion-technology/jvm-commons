package com.compassion.commons.pulsar;

import java.io.IOException;
import java.nio.file.Files;

import org.apache.commons.lang3.StringUtils;
import org.apache.pulsar.client.admin.PulsarAdmin;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.impl.auth.AuthenticationToken;
import org.apache.pulsar.client.impl.auth.oauth2.AuthenticationOAuth2;
import org.apache.pulsar.functions.LocalRunner;
import org.apache.pulsar.functions.LocalRunner.LocalRunnerBuilder;

public interface PulsarClients {
	static PulsarAdmin newAdmin(PulsarConfig c) throws IOException {
		var builder = PulsarAdmin.builder().serviceHttpUrl(c.getAdminUrl())
			.allowTlsInsecureConnection(true);
		if (c.getOauthFile() != null && Files.isReadable(c.getOauthFile())) {
			builder.authentication(AuthenticationOAuth2.class.getName(), c.oauthParams());
		} else if (StringUtils.isNotBlank(c.getAdminToken())) {
			builder.authentication(AuthenticationToken.class.getName(), c.getAdminToken());				
		} else {
			builder.authentication(AuthenticationToken.class.getName(), c.getClientToken());
		}
		return builder.build();
	}
	
	static PulsarClient newClient(PulsarConfig c) throws IOException {
		var builder = PulsarClient.builder().serviceUrl(c.getServiceUrl())
			.allowTlsInsecureConnection(true);
		if (c.getOauthFile() != null && Files.isReadable(c.getOauthFile())) {
			builder.authentication(AuthenticationOAuth2.class.getName(), c.oauthParams());
		} else {
			builder.authentication(AuthenticationToken.class.getName(), c.getClientToken());	
		}
		return builder.build();
	}
	
	static LocalRunnerBuilder newLocalRunner(PulsarConfig c) throws IOException {
		var builder = LocalRunner.builder().brokerServiceUrl(c.getServiceUrl())
			.tlsAllowInsecureConnection(true);
		if (c.getOauthFile() != null && Files.isReadable(c.getOauthFile())) {
			builder.clientAuthPlugin(AuthenticationOAuth2.class.getName())
			       .clientAuthParams(c.oauthParams());
		} else {
			builder.clientAuthPlugin(AuthenticationToken.class.getName())
			       .clientAuthParams(c.getClientToken());	
		}
		return builder;
	}
}
