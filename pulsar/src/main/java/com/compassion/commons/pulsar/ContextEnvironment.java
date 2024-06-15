package com.compassion.commons.pulsar;

import org.apache.pulsar.functions.api.Context;

import com.compassion.commons.config.ConfigEnvironment;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.google.common.base.CaseFormat;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "with")
public class ContextEnvironment implements ConfigEnvironment {
	private final Context context;
	
	@Override
	public boolean has(String path, JsonNode existing) {
		return context.getUserConfigValue(path).isPresent() || context.getSecret(path) != null;
	}
	
	@Override
	public JsonNode get(String path, JsonNode existing) {
		return JsonNodeFactory.instance.textNode(context.getUserConfigValue(path)
			.orElseGet(() -> context.getSecret(path)).toString());
	}
	
	@Override
	public CaseFormat pathFormat() { return CaseFormat.LOWER_UNDERSCORE; }
	
	@Override
	public char pathSeparator() { return '_'; }
}
