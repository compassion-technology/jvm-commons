package com.compassion.commons.iac;

import org.jooq.lambda.Seq;

import com.compassion.commons.Utilities;
import com.compassion.commons.config.CIEnvironment;
import com.compassion.commons.config.CredentialConfig.ConfigWithUserPassword;
import com.compassion.commons.iac.CDKUtils.ParamFromSecretBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import software.amazon.awscdk.services.secretsmanager.ISecret;

@Getter @Setter @Accessors(chain = true)
public class CIODS extends ConfigWithUserPassword implements CDKCredentials {
	private static final String CLUSTER = "odf-ods-cluster.cluster-cp7ohq9jqeo2.us-east-2.rds.amazonaws.com";
	
	private String hostURL;
	
	public CIODS withDefaults(CIEnvironment env) {
		switch (env) {
			case Prod  -> setHostURL("prod-" + CLUSTER + "/prod-odf-ods");
			case Stage -> setHostURL("dev-"  + CLUSTER + "/stage-odf-ods");
			default    -> setHostURL("dev-"  + CLUSTER + "/dev-odf-ods");
			case Cloud -> throw new IllegalArgumentException("ODS does not support the Cloud environment");
		}
		setUser("odf_svc");
		return this;
	}
	
	@Override
	public Seq<ParamFromSecretBuilder> asParams(CDKUtils utils, String path, ISecret secret) {
		return Seq.of(
			utils.newParam(path + "/user").pathDescription("Username").secret(secret),
			utils.newParam(path + "/password").pathDescription("Password").secret(secret),
			Utilities.cast(utils.newParam(path + "/hostURL").pathDescription("Host URL and Database").value(getHostURL()))
		);
	}
}
