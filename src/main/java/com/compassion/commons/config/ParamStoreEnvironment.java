package com.compassion.commons.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BooleanSupplier;

import org.apache.commons.lang3.StringUtils;

import com.compassion.commons.LambdaUtils.IO;
import com.compassion.commons.config.EnvironmentTree.Environment;
import com.compassion.commons.config.SecretConverter.DefaultSecretConverter;
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
	private static final String SECRET_PATH = "/aws/reference/secretsmanager/";
	
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
	public boolean has(String path) {
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
	public String get(String path) {
		var pathNorm = StringUtils.prependIfMissing(path, "/");
		var ret = initClientAndMap().get(pathNorm);
		if (ret == null || ret != SENTINEL) { return ret; }
		
		try {
			log.debug("Looking for parameter {}", pathNorm);
			var v = client.getParameter(req -> req.name(pathNorm).withDecryption(true)).parameter().value();
			
			if (v.startsWith(SECRET_PATH)) {
				// If there is a slash after the secret name, that might indicate the key inside the secret to retrieve,
				// so don't include that in lookups.
				// CDK v2 now parses owned secret names (used to be a context toggle) and no longer includes a suffix on the name. 
				int slash = v.indexOf('/', SECRET_PATH.length());
				if (slash > 0) { v = v.substring(0, slash); }

				log.debug("Looking for secret {}...", v);
				var secret = client.getParameter(GetParameterRequest.builder().name(v).withDecryption(true).build()).parameter().value();
				ret = secretConverter.convert(pathNorm, secret);
			} else {
				// Cache the parameter to avoid a second lookup in get()
				ret = v;
			}
			map.put(pathNorm, ret);
			return ret;
		} catch (ParameterNotFoundException e) {
			// Not all params are required or defined- no logging needed
		} catch (SsmException e) {
			log.warn("SSM parameter lookup failed for path {}: {}", pathNorm, e.getMessage());
		} catch (IOException e) {
			// Don't actually log exception or else it would have the decrypted secret
			log.warn("Secret for {} not in expected format", pathNorm);
		}
		return null;
	}

	@Override
	public void close() throws IOException {
        IO.accept(client, SsmClient::close);
	}
}
