package com.compassion.commons.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BooleanSupplier;

import org.apache.commons.lang3.StringUtils;

import com.compassion.commons.LambdaUtils.IO;
import com.compassion.commons.config.EnvironmentTree.Environment;
import com.compassion.commons.config.SecretConverter.DefaultSecretConverter;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.CaseFormat;

import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.log4j.Log4j2;
import software.amazon.awssdk.services.ssm.SsmClient;
import software.amazon.awssdk.services.ssm.model.GetParameterRequest;
import software.amazon.awssdk.services.ssm.model.ParameterNotFoundException;
import software.amazon.awssdk.services.ssm.model.SsmException;

@Log4j2 @Accessors(fluent = true)
public class ParamStoreEnvironment implements Environment {
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
    public CaseFormat pathFormat() { return CaseFormat.LOWER_CAMEL; }
    
	@Override
	public boolean has(String path, JsonNode existing) {
	    if (!enabled.getAsBoolean()) { return false; }
	    return initClientAndMap().containsKey(StringUtils.prependIfMissing(path, "/"));
	}
	
	private Map<String, String> initClientAndMap() {
		if (client == null) {
	    	client = SsmClient.create();
	    }
		if (map == null) {
	    	map = new HashMap<>();
	    	client.describeParametersPaginator().forEach($ -> $.parameters().forEach(p -> {
	    		map.put(p.name(), SENTINEL);
	    	}));
	    }
		return map;
	}
	
	@Override
	public String get(String path, JsonNode existing) {
		var pathNorm = StringUtils.prependIfMissing(path, "/");
		var ret = initClientAndMap().get(pathNorm);
		return ret == null || ret != SENTINEL? ret : getParamValue(pathNorm);
	}
	
	public String getParamValue(String path) {
		try {
			log.debug("Looking for parameter {}", path);
			var v = client.getParameter(req -> req.name(path).withDecryption(true)).parameter().value();
			if (v.startsWith(SECRET_PATH)) { v = getSecretValue(path, v); }
			// Cache the parameter to avoid a second lookup in get()
			map.put(path, v);
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
		if (slash > 0) { secret = secret.substring(0, slash); }

		log.debug("Looking for secret {}...", secret);
		var ret = client.getParameter(
			GetParameterRequest.builder().name(secret).withDecryption(true).build()
		).parameter().value();
		
		return secretConverter.convert(path, ret);		
	}

	@Override
	public void close() throws IOException {
        IO.accept(client, SsmClient::close);
	}
}
