package com.compassion.commons.aws;

import java.util.Optional;

import com.amazonaws.services.lambda.runtime.ClientContext;
import com.amazonaws.services.lambda.runtime.Context;
import com.compassion.commons.config.ConfigEnvironment.ConfigEnvironmentMap;
import com.google.common.base.CaseFormat;

public class ContextEnvironment extends ConfigEnvironmentMap {
	public ContextEnvironment(Context c) {
		super('_', CaseFormat.LOWER_UNDERSCORE);
		Optional.ofNullable(c.getClientContext()).map(ClientContext::getCustom).ifPresent(this::putAll);
	}
}
