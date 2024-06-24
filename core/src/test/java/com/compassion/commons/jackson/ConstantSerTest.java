package com.compassion.commons.jackson;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.compassion.commons.config.CredentialConfig;
import com.compassion.commons.config.CredentialConfig.ConfigWithUserPassword;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.val;

public class ConstantSerTest {
	static class Bean extends ConfigWithUserPassword {
		Bean() {
			setUser("user");
			setPassword("password");
		}
	}
	
	@Test
	public void testMask() throws JsonProcessingException {
		val om = CredentialConfig.addMaskingMixins(new ObjectMapper());
		assertEquals("{\"user\":\"user\",\"password\":\"********\"}", om.writeValueAsString(new Bean()));
	}
}
