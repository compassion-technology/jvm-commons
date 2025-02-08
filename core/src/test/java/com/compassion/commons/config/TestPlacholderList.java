package com.compassion.commons.config;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.jooq.lambda.Seq;
import org.junit.jupiter.api.Test;

import com.compassion.commons.config.CredentialConfig.ConfigWithUserPasswordToken;

public class TestPlacholderList {
	public static class MyTestConfig extends ConfigWithUserPasswordToken {
		// Custom config class
	}
	
	@Test
	public void testRightPlaceholder() {
		var placeholder = Seq.seq(CredentialConfig.getPlaceholders()).findFirst(cc -> cc.getClass().isAssignableFrom(MyTestConfig.class))
			.orElseThrow(() -> new IllegalStateException("No credential configs loaded by service loader"));

		// Ensure it's NOT just ConfigWithUserPassword even though that also can be assigned
		assertEquals(ConfigWithUserPasswordToken.class, placeholder.getClass());
	}
}
