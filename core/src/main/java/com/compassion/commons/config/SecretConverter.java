package com.compassion.commons.config;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

import com.compassion.commons.Utilities;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.val;

@FunctionalInterface
public interface SecretConverter {
	/**
	 * Parse/convert the secret to extract the actual secret value.
	 * @param path the original path of the secret in SSM before it delegated to SecretsManager.
	 * @param secret the raw/unparsed secret, usually a JSON string
	 * @return the actual secret value
	 * @throws IOException if there was a problem converting the secret
	 */
	public String convert(String path, String secret) throws IOException;
	
	abstract class MapSecretConverter implements SecretConverter {
		private static final ObjectMapper MAPPER = new ObjectMapper();
		
		@Override
		public String convert(String path, String secret) throws IOException {
			return convert(path, MAPPER.readValue(secret, Map.class));
		}
		
		protected abstract String convert(String path, Map<String, Object> secret);
	}
	
	class DefaultSecretConverter extends MapSecretConverter {
		@Override
		protected String convert(String path, Map<String, Object> secret) {
			// Assume that the map key is the last segment of the parameter path
			// For example for /my/database/password, look for "password" in the map
			val key = StringUtils.substringAfterLast(path, "/");
			// Otherwise, just return the first value, since SecretsManager forces 
			// the use of a JSON object even for a single value
			return Objects.toString(secret.getOrDefault(key, Utilities.first(secret.values())), null);
		}
	}
}
