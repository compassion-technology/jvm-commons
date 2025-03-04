package com.compassion.commons.config;

import lombok.Getter;

// https://ciorg.atlassian.net/wiki/spaces/ITA/pages/27600192537/AWS+Resource+Tagging+Standard
public enum CIEnvironment {
	Cloud, // SaaS
	Devint, Stage, Prod, SandBox, // IT
	Develop; // Business
	
	@Getter
	private static final CIEnvironment[] standard = { Devint, Stage, Prod };
}
