package com.compassion.commons.rest.client.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AuthEnvironment {
	DEVINT("shaphat-devint", "/test"),
	STAGE ("shaphat-stage",  "/stage"),
	PROD  ("shaphat",        "");
	
	// The OAuth subdomain from which to request a token
	private final String authSubdomain;
	
	// How to replace the base path hardcoded in the swagger YAML for this environment
	private final String basePath;
}
