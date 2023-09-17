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

	@Setter
    private SsmClient client;
    private Map<String, String> map = new HashMap<>();
    
    @Setter
    private SecretConverter secretConverter = new DefaultSecretConverter();
    
    @Setter
    private BooleanSupplier enabled = () -> true;
    
    @Override
    public CaseFormat pathFormat() { return CaseFormat.LOWER_CAMEL; }
    
	@Override
	public boolean has(String path) {
	    if (!enabled.getAsBoolean()) { return false; }

	    if (client == null) { client = SsmClient.create(); }

        // Any SSM blocks are reserved and can't be looked up and also
		// relate to configuring this lookup itself (e.g. region passed to ctor) and won't be overridden anyway
		if (StringUtils.startsWithAny(path.toLowerCase(), "/ssm", "ssm")) { return false; }
		
		try {
			log.debug("Looking for parameter {}", path);
			String v = client.getParameter(req -> req
				.name(StringUtils.prependIfMissing(path, "/"))
				.withDecryption(true)
			).parameter().value();
			
			if (v.startsWith(SECRET_PATH)) {
				// If there is a slash after the secret name, that might indicate the key inside the secret to retrieve,
				// so don't include that in lookups.
				// CDK v2 now parses owned secret names (used to be a context toggle) and no longer includes a suffix on the name. 
				int slash = v.indexOf('/', SECRET_PATH.length());
				if (slash > 0) { v = v.substring(0, slash); }

				log.debug("Looking for secret {}...", v);
				var secret = client.getParameter(GetParameterRequest.builder().name(v).withDecryption(true).build()).parameter().value();
				map.put(path, secretConverter.convert(path, secret));
			} else {
				// Cache the parameter to avoid a second lookup in get()
				map.put(path, v);
			}
			return true;
		} catch (ParameterNotFoundException e) {
			// Not all params are required or defined- no logging needed
		} catch (SsmException e) {
			log.warn("SSM parameter lookup failed for path {}: {}", path, e.getMessage());
		} catch (IOException e) {
			// Don't actually log exception or else it would have the decrypted secret
			log.warn("Secret for {} not in expected format", path);
		}
		return false;
	}
	
	@Override
	public String get(String path) {
		return map.get(path);
	}

	@Override
	public void close() throws IOException {
        IO.accept(client, SsmClient::close);
	}
}
