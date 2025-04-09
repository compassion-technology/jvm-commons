package com.compassion.commons.config;

import org.apache.commons.lang3.StringUtils;
import org.jooq.lambda.Seq;

import lombok.Getter;

// https://ciorg.atlassian.net/wiki/spaces/ITA/pages/27600192537/AWS+Resource+Tagging+Standard
public enum CIEnvironment {
	Cloud, // SaaS
	Devint, Stage, Prod, SandBox, // IT
	Develop; // Business
	
	@Getter
	private static final CIEnvironment[] standard = { Devint, Stage, Prod };
	
	private static final String pathSep = "/";
	public String newPath(String... paths) {
		return pathSep + StringUtils.join(Seq.of(toString().toLowerCase()).append(paths), pathSep);
	}
	
	@Override
	public String toString() {
		return super.toString().toUpperCase();
	}
}
