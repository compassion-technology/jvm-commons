package com.compassion.commons.iac;

import org.apache.commons.lang3.tuple.Pair;

import software.amazon.awssdk.regions.Region;

public interface CDKVariables {
	String CONTAINER = "container",
		   MANAGED = "MANAGED",
		   FARGATE = "FARGATE",
		   ENABLED = "ENABLED",
		   MEMORY = "MEMORY",
		   LATEST  = "latest",
		   VCPU = "VCPU";
	
	String SECRET_PATH = "/aws/reference/secretsmanager/";
	String VPC_NAME = "Compassion VPC";
	
	Pair<String, String> JDK_JAVA_OPTIONS = Pair.of("JDK_JAVA_OPTIONS", "--add-opens java.base/java.nio=ALL-UNNAMED");
}
