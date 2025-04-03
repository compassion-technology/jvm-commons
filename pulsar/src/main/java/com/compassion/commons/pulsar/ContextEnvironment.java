package com.compassion.commons.pulsar;

import java.util.Collection;
import java.util.Optional;

import org.apache.pulsar.functions.api.BaseContext;
import org.apache.pulsar.functions.api.Context;

import com.compassion.commons.config.ConfigEnvironment;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.google.common.base.CaseFormat;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "with")
public class ContextEnvironment implements ConfigEnvironment {
	private final BaseContext context;
	
	private Optional<Object> getUserConfigValue(String path) {
		if (context instanceof Context c) {
			return c.getUserConfigValue(path);
		}
		return Optional.empty();
	}
	
	@Override
	public boolean has(String path, JsonNode existing) {
		return getUserConfigValue(path).isPresent() || context.getSecret(path) != null;
	}
	
	@Override
	public JsonNode get(String path, JsonNode existing) {
		var override = getUserConfigValue(path).orElseGet(() -> context.getSecret(path));
		if (existing.isArray() && override instanceof Collection<?> c) {
			c.forEach(e -> ((ArrayNode) existing).add(JsonNodeFactory.instance.textNode(e.toString())));
			return existing;
		}
		return JsonNodeFactory.instance.textNode(override.toString());
	}
	
	@Override
	public CaseFormat pathFormat() { return CaseFormat.LOWER_UNDERSCORE; }
	
	@Override
	public char pathSeparator() { return '_'; }
}
