package com.elderresearch.commons.lang.jackson;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.elderresearch.commons.lang.jackson.ConstantSerializer.PasswordSerializer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;
import lombok.val;

public class ConstantSerTest {
	@Data
	static class Bean {
		private String user = "user", password = "password";
	}
	
	interface BeanMixin {
		@JsonSerialize(using = PasswordSerializer.class)
		String getPassword();
	}
	
	@Test
	public void testMask() throws JsonProcessingException {
		val om = new ObjectMapper().addMixIn(Bean.class, BeanMixin.class);
		assertEquals("{\"user\":\"user\",\"password\":\"******\"}", om.writeValueAsString(new Bean()));
	}
}
