package com.compassion.commons.iac;

import org.apache.commons.lang3.tuple.Pair;

public interface CDKVariables {
	String CONTAINER = "container",
		   ENABLED   = "ENABLED",
		   FARGATE   = "FARGATE",
		   LATEST    = "latest",
		   MANAGED   = "MANAGED",
		   MEMORY    = "MEMORY",
		   VCPU      = "VCPU";
	
	String SECRET_PATH = "/aws/reference/secretsmanager/";
	
	String BA_ACCOUNT  = "903318353035",
	       DW_ACCOUNT  = "870579819025",
	       VPC_NAME    = "Compassion VPC";
	
	Pair<String, String> JDK_JAVA_OPTIONS = Pair.of("JDK_JAVA_OPTIONS", "--add-opens java.base/java.nio=ALL-UNNAMED");
}
