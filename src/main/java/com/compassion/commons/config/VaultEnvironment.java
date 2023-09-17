package com.compassion.commons.config;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.StringUtils;

import com.bettercloud.vault.SslConfig;
import com.bettercloud.vault.Vault;
import com.bettercloud.vault.VaultConfig;
import com.bettercloud.vault.VaultException;
import com.bettercloud.vault.api.Logical.logicalOperations;
import com.bettercloud.vault.response.LogicalResponse;
import com.bettercloud.vault.rest.RestResponse;
import com.compassion.commons.config.EnvironmentTree.Environment;
import com.google.common.base.CaseFormat;
import com.google.common.net.MediaType;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class VaultEnvironment extends VaultConfig implements Environment {
	private static final String DEF_URL = "https://vault.cybersecurity.ci.org/";
	
	// Don't check arrays of config that won't have secrets in Vault.
	// Don't check Vault for Vault related config items.
	private static final String[] SKIP = {
		"/delegateViews",
		"/domainDatabases",
		"/vault"
	};
	
	private final Vault vault;
	private final Map<String, LogicalResponse> cache;
	
	public VaultEnvironment() {
		this.cache  = new ConcurrentHashMap<>();
		
		try {
			address(StringUtils.defaultIfBlank(System.getenv("VAULT_ADDR"), DEF_URL));
			engineVersion(2);
			sslConfig(new SslConfig().verify(false).build());
			build();
		} catch (VaultException e) {
			log.warn("Vault configuration overrides unavailable: {}", e);
			this.vault = null;
			return;
		}
		
		this.vault = new Vault(this);
	}
	
    @Override
    public CaseFormat pathFormat() { return CaseFormat.LOWER_CAMEL; }
	
	@Override
	public boolean has(String path) {
		return get(path) != null;
	}

	@Override
	public String get(String path) {
		path = StringUtils.prependIfMissing(path, "/");
		if (vault == null || StringUtils.containsAny(path, SKIP)) { return null; }
		
		var lastSlash = StringUtils.lastIndexOf(path, '/');
		if (lastSlash < 1) { return null; }
		
		var jsonKey = path.substring(lastSlash + 1);
		path = path.substring(0, lastSlash);
		
		var resp = cache.computeIfAbsent(path, this::getSecret);
		switch (resp.getRestResponse().getStatus()) {
			case 403:
				log.debug("⛔ Not authorized. Did you set the {} environment variable?", VAULT_TOKEN);
				return null;
			case 404:
				log.debug("✖ No secret at path {}", path);
				return null;
			case 200:
				var ret = resp.getData().get(jsonKey);
				if (ret != null) { log.debug("✅ Secret found at path {} with key {}", path, jsonKey); }
				return ret;
			default:
				log.debug("⚠ Error reading Vault secret: {}", new String(resp.getRestResponse().getBody()));
				return null;
		}
	}
	
	@Override
	public void close() throws IOException {
		cache.clear(); // Don't leave secrets sitting in memory
	}
	
	private LogicalResponse getSecret(String path) {
		log.debug("🔍 Checking Vault for secret at path {}", path);
		try {
			return vault.logical().read(path);
		} catch (VaultException e) {
			return new LogicalResponse(new RestResponse(
				500, MediaType.PLAIN_TEXT_UTF_8.toString(), e.getMessage().getBytes()),
				0, logicalOperations.readV2);
		}
	}
}
