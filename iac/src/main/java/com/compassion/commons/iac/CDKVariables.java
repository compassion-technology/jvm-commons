package com.compassion.commons.iac;

import org.apache.commons.lang3.tuple.Pair;

import com.compassion.commons.config.ParamStoreEnvironment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
public interface CDKVariables {
	@Getter @AllArgsConstructor
	enum AWSAccount {
		BUSINESS_ANALYTICS("903318353035"),
		DATA_WORKS("870579819025"),
		SUPPORTER("279142125458");
		
		private String id;
	}
	
	String CONTAINER        = "container",
		   ENABLED          = "ENABLED",
		   FARGATE          = "FARGATE",
		   LATEST           = "latest",
		   MANAGED          = "MANAGED",
		   MEMORY           = "MEMORY",
		   VCPU             = "VCPU";
	
	String AWS_DOMAIN       = ".amazonaws.com";
	
	String ECR_ARN          = "arn:aws:ecr:us-east-2:%s:repository/",
		   ECR_PATH         = "%s.dkr.ecr.us-east-2" + AWS_DOMAIN + "/",
		   SECRET_PATH      = ParamStoreEnvironment.SECRET_PATH;
	
	// TODO: Create a mostly comprehensive enum with `getPrincipal` appending `.amazonaws.com`
	// TODO: Looked through the CDK code since this can/should be managed there, but didn't find anything
	
	String BATCH	        = "batch" + AWS_DOMAIN,
		   ECS		        = "ecs-tasks" + AWS_DOMAIN,
		   EVENTS           = "events" + AWS_DOMAIN,
		   LAMBDA           = "lambda" + AWS_DOMAIN,
		   SCHEDULER        = "scheduler" + AWS_DOMAIN;
	
	String BATCH_ROLE       = "service-role/AWSBatchServiceRole",
		   ECS_ROLE         = "service-role/AmazonECSTaskExecutionRolePolicy",
		   LAMBDA_EXEC_ROLE = "service-role/AWSLambdaBasicExecutionRole",
		   LAMBDA_VPC_ROLE  = "service-role/AWSLambdaVPCAccessExecutionRole",
	       VPC_NAME         = "Compassion VPC";
	
	Pair<String, String> JVM_ARGS_NIO = Pair.of("JDK_JAVA_OPTIONS", "--add-opens=java.base/java.nio=ALL-UNNAMED");
}
