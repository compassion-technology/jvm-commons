package com.compassion.commons.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BooleanSupplier;

import org.apache.commons.lang3.StringUtils;

import com.compassion.commons.LambdaUtils.IO;
import com.compassion.commons.config.SecretConverter.DefaultSecretConverter;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;

import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.log4j.Log4j2;
import software.amazon.awssdk.services.ssm.SsmClient;
import software.amazon.awssdk.services.ssm.model.GetParameterRequest;
import software.amazon.awssdk.services.ssm.model.ParameterNotFoundException;
import software.amazon.awssdk.services.ssm.model.SsmException;

@Log4j2 @Accessors(fluent = true)
public class ParamStoreEnvironment implements ConfigEnvironment {
	public static final String SECRET_PATH = "/aws/reference/secretsmanager/";

	// Mark a parameter as existing but not looked up yet
	private static final String SENTINEL = "$";

	@Setter
    private SsmClient client;
    private Map<String, String> map;

    @Setter
    private SecretConverter secretConverter = new DefaultSecretConverter();

    @Setter
    private BooleanSupplier enabled = () -> true;

	@Override
	public boolean has(String path, JsonNode existing) {
	    if (!enabled.getAsBoolean()) { return false; }
	    return listParams().containsKey(StringUtils.prependIfMissing(path, "/"));
	}

	private SsmClient initClient() {
		if (client == null) { client = SsmClient.create(); }
		return client;
	}
	private Map<String, String> initMap() {
		if (map == null) { map = new HashMap<>(); }
		return map;
	}
	private Map<String, String> listParams() {
		if (initMap().isEmpty()) {
			initClient().describeParametersPaginator().forEach($ -> $.parameters().forEach(p -> {
	    		map.put(p.name(), SENTINEL);
	    	}));
		}
		return map;
	}

	@Override
	public JsonNode get(String path, JsonNode existing) {
		var pathNorm = StringUtils.prependIfMissing(path, "/");
		var ret = listParams().get(pathNorm);
		// Simple equality on the sentinel means that an actual value of $ is NOT equal, even though equal()
		return JsonNodeFactory.instance.textNode(ret == null || ret != SENTINEL? ret : getParamValue(pathNorm));
	}

	public String getParamValue(String path) {
		try {
			log.debug("Looking for parameter {}", path);
			var v = initClient().getParameter(req -> req.name(path).withDecryption(true)).parameter().value();
			if (v.startsWith(SECRET_PATH)) { v = getSecretValue(path, v); }
			// Cache the parameter to avoid a second lookup in get()
			initMap().put(path, v);
			return v;
		} catch (ParameterNotFoundException e) {
			// Not all params are required or defined- no logging needed
		} catch (SsmException e) {
			log.warn("SSM parameter lookup failed for path {}: {}", path, e.getMessage());
		} catch (IOException e) {
			// Don't actually log exception or else it would have the decrypted secret
			log.warn("Secret for {} not in expected format", path);
		}
		return null;
	}

	public String getSecretValue(String path, String secret) throws IOException {
		// If there is a slash after the secret name, that might indicate the key inside the secret to retrieve,
		// so don't include that in lookups.
		// CDK v2 now parses owned secret names (used to be a context toggle) and no longer includes a suffix on the name.
		int slash = secret.indexOf('/', SECRET_PATH.length());
		if (slash > 0) {
			path = secret.substring(slash);
			secret = secret.substring(0, slash);
		}

		var ret = listParams().computeIfAbsent(secret, $ -> {
			log.debug("Looking for secret {}...", $);
			return initClient().getParameter(
				GetParameterRequest.builder().name($).withDecryption(true).build()
			).parameter().value();
		});

		return secretConverter.convert(path, ret);
	}

	@Override
	public void close() throws IOException {
        IO.accept(client, SsmClient::close);
	}

	public interface ParamStoreAwareConfig {
		/**
		 * Whether or not AWS Systems Manager's parameter store should be checked for configuration overrides.
		 * Usually an "offline" configuration specifies this (like a YAML file or environment variabe) and then
		 * if this is {@code true}, the {@link ParamStoreEnvironment} is queried to further override configuration.
		 * @return if this configuration should look for config overrides in SSM
		 */
		boolean isSsm();
	}

	/**
	 * Convenience load method that applies SSM Parameter Store overrides <b>after</b> the configuration is
	 * initially loaded and "offline" overrides like environment variables have been applied, which dictate
	 * whether or not SSM overrides are enabled or not.
	 * @param <C> a YAML configuration class that also implements {@link #ParamStoreAwareConfig}
	 * @param config the configuration instance
	 * @param prefix the prefix to use when applying overrides
	 * @return the configuration instance after overrides have been applied
	 * @throws IOException if there was a problem loading the initial configuration
	 */
	public static <C extends YAMLConfig & ParamStoreAwareConfig> C load(C config, String prefix) throws IOException {
		return load(config, ConfigOverrides.forPrefix(prefix).with(new ParamStoreEnvironment()));
	}

	/**
	 * Convenience load method that applies SSM Parameter Store overrides <b>after</b> the configuration is
	 * initially loaded and "offline" overrides like environment variables have been applied, which dictate
	 * whether or not SSM overrides are enabled or not.
	 * @param <C> a YAML configuration class that also implements {@link #ParamStoreAwareConfig}
	 * @param config the configuration instance
	 * @param ssm the pre-initialized/custom {@link ConfigOverrides} presumably with a {@link ParamStoreEnvironment}
	 * registered
	 * @return the configuration instance after overrides have been applied
	 * @throws IOException if there was a problem loading the initial configuration
	 */
	public static <C extends YAMLConfig & ParamStoreAwareConfig> C load(C config, ConfigOverrides ssm) throws IOException {
		// Now that environment variables and simple configuration has been loaded, see if we
		// should look for secrets in SSM.
		if (config.isSsm()) {
			log.info("Checking AWS SSM and Secrets for configuration overrides...");
			try {
				config = ssm.applyOverrides(YAMLConfig.getMapper(), config);
			} catch (IOException e) {
				log.warn("Error loading SSM configuration", e);
			}
		}
		return config;
	}
}
