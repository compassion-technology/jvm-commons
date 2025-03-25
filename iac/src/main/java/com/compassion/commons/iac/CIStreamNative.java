package com.compassion.commons.iac;

import java.util.Map;
import java.util.function.Consumer;

import org.jooq.lambda.Seq;

import com.compassion.commons.config.CIEnvironment;
import com.compassion.commons.config.CredentialConfig;
import com.compassion.commons.iac.CDKUtils.ParamFromSecretBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import software.amazon.awscdk.services.secretsmanager.ISecret;

@Getter @Setter @Accessors(chain = true)
public class CIStreamNative implements CDKCredentials {
	@Getter
	private static final String org = "urn:sn:pulsar:o-xqpg6:";
	@Getter
	private static final String baseHost = ".aws-use2-production-snci-pool-kid.streamnative.aws.snio.cloud";
	@Getter
	private static final Map<CIEnvironment, String> subdomains = Map.of(
		CIEnvironment.Devint, "devint-a200530c-d9e7-4e99-8cdc-6a719deb6326",
		CIEnvironment.Stage,  "stage-0b216fbe-79ee-49f2-bd37-40e804e85460",
		CIEnvironment.Prod,   "prod-f823b154-0d5c-4990-8f71-6d368abbc0a5"
	);
	
	@Getter
	public static class KeyFile implements CredentialConfig {
	    private String clientId = "********************************";
	    private String clientSecret = "****************************************************************";
	    private String clientEmail = "******@o-xqpg6.auth.streamnative.cloud";
	    
	    @Override
	    public void forEachCredentialPath(Consumer<String> withSecretPath) {
	    	// Not needed for CDK usage
	    }
	}
	
	private String host;
	private String oauthAudience;
	private KeyFile oauth = new KeyFile();
	
	public CIStreamNative withDefaults(CIEnvironment env) {
		switch (env) {
			case Prod, Stage -> setHost(subdomains.get(env) + baseHost).setOauthAudience(org + env.name().toLowerCase());
			default          -> setHost(subdomains.get(CIEnvironment.Devint) + baseHost).setOauthAudience(org + CIEnvironment.Devint.name().toLowerCase());
			case Cloud -> throw new IllegalArgumentException("Snowflake does not support the Cloud environment");
		}
		return this;
	}
	
	@Override
	public Seq<ParamFromSecretBuilder> asParams(CDKUtils utils, String path, ISecret secret) {
		return Seq.of(
			utils.newParam(path + "/oauth/client_id").pathDescription("OAuth Client ID").secret(secret),
			utils.newParam(path + "/oauth/client_secret").pathDescription("OAuth Client Secret").secret(secret),
			utils.newParam(path + "/oauth/client_email").pathDescription("OAuth Email").secret(secret),
				
			build(utils.newParam(path + "/host").pathDescription("Host"), $ -> $.value(getHost())),
			build(utils.newParam(path + "/oauthAudience").pathDescription("OAuth Audience"), $ -> $.value(getOauthAudience()))			
		);
	}
	
	@Override
	public String toPlaceholderJson() throws JsonProcessingException {
		return oauth.toPlaceholderJson();
	}
	
    @Override
    public void forEachCredentialPath(Consumer<String> withSecretPath) {
    	// Not needed for CDK usage
    }
}
