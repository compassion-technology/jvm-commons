package com.compassion.commons.pulsar;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Consumer;

import org.apache.pulsar.client.impl.auth.oauth2.KeyFile;
import org.apache.pulsar.common.util.ObjectMapperFactory;

import com.compassion.commons.config.CredentialConfig;
import com.compassion.commons.config.YAMLConfig;
import com.compassion.commons.jackson.PasswordSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain = true)
public class PulsarConfig extends YAMLConfig {
	public static class PulsarKeyFile extends KeyFile implements Serializable, CredentialConfig {
		private static final long serialVersionUID = 1L;

		@Override
		public void forEachCredentialPath(Consumer<String> withSecretPath) {
			withSecretPath.accept("client_id");
			withSecretPath.accept("client_secret");
			withSecretPath.accept("client_email");
		}
		
		public interface PulsarKeyFileMixin {
			@JsonSerialize(using = PasswordSerializer.class) String getClientId();
			@JsonSerialize(using = PasswordSerializer.class) String getClientSecret();
		}
	}
	
	private static final long serialVersionUID = 1L;

	private String host = "devint-a200530c-d9e7-4e99-8cdc-6a719deb6326.aws-use2-production-snci-pool-kid.streamnative.aws.snio.cloud";
	private int port = 6651;
	private String clientToken;
	private String adminToken;
	private Path oauthFile;
	private PulsarKeyFile oauth = new PulsarKeyFile();
	private String oauthAudience = "urn:sn:pulsar:o-xqpg6:devint";
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
		if (oauthFile == null) {
			oauthFile = Files.createTempFile("oauth", ".json");
			Files.writeString(oauthFile, oauth.toJson());
		} else {
			try (var reader = Files.newBufferedReader(getOauthFile())) {
				oauth = ObjectMapperFactory.getMapper().reader().readValue(reader, PulsarKeyFile.class);
			}
		}

		var params = new PulsarOAuthParams();
		params.setIssuerUrl(getOauth().getIssuerUrl());
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
