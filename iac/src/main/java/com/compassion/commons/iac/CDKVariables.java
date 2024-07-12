package com.compassion.commons.iac;

import org.apache.commons.lang3.tuple.Pair;

public interface CDKVariables {
	String CONTAINER        = "container",
		   ENABLED          = "ENABLED",
		   FARGATE          = "FARGATE",
		   LATEST           = "latest",
		   MANAGED          = "MANAGED",
		   MEMORY           = "MEMORY",
		   VCPU             = "VCPU";
	
	String ECR_ARN          = "arn:aws:ecr:us-east-2:%s:repository/",
		   ECR_PATH         = "%s.dkr.ecr.us-east-2.amazonaws.com/",
		   SECRET_PATH      = "/aws/reference/secretsmanager/";
	
	// TODO: Create a mostly comprehensive enum with `getPrincipal` appending `.amazonaws.com`
	
	String BATCH	        = "batch.amazonaws.com",
		   ECS		        = "ecs-tasks.amazonaws.com",
		   EVENTS           = "events.amazonaws.com",
		   LAMBDA           = "lambda.amazonaws.com",
		   SCHEDULER        = "scheduler.amazonaws.com";
	
	String BATCH_ROLE       = "service-role/AWSBatchServiceRole",
		   ECS_ROLE         = "service-role/AmazonECSTaskExecutionRolePolicy",
		   LAMBDA_EXEC_ROLE = "service-role/AWSLambdaBasicExecutionRole",
		   LAMBDA_VPC_ROLE  = "service-role/AWSLambdaVPCAccessExecutionRole";
	
	String BA_ACCOUNT       = "903318353035",
	       DW_ACCOUNT       = "870579819025",
	       VPC_NAME         = "Compassion VPC";
	
	Pair<String, String> JDK_JAVA_OPTIONS = Pair.of("JDK_JAVA_OPTIONS", "--add-opens=java.base/java.nio=ALL-UNNAMED");
}
