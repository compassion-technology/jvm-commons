package com.compassion.commons.pulsar;

import org.apache.commons.lang3.StringUtils;
import org.apache.pulsar.functions.api.Context;

import com.compassion.commons.config.ConfigEnvironment;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.google.common.base.CaseFormat;

import lombok.RequiredArgsConstructor;
import lombok.val;

@RequiredArgsConstructor(staticName = "with")
public class ContextEnvironment implements ConfigEnvironment {
	private static final String SECRET_PREFIX = "secret:";
	
	private final Context context;
	
	@Override
	public boolean has(String path, JsonNode existing) {
		return context.getUserConfigValue(path).isPresent();
	}
	
	@Override
	public JsonNode get(String path, JsonNode existing) {
		val ret = context.getUserConfigValue(path).get().toString();
		if (ret.startsWith(SECRET_PREFIX)) {
			return JsonNodeFactory.instance.textNode(context.getSecret(StringUtils.removeStart(ret, SECRET_PREFIX)));
		}
		return JsonNodeFactory.instance.textNode(ret);
	}
	
	@Override
	public CaseFormat pathFormat() { return CaseFormat.LOWER_UNDERSCORE; }
	
	@Override
	public char pathSeparator() { return '_'; }
}
