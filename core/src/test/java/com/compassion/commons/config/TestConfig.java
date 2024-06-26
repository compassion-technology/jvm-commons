package com.compassion.commons.config;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.function.Consumer;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain = true)
public class TestConfig extends YAMLConfig implements CredentialConfig {

    private TestX x3 = new TestX();

    @Getter @Setter @Accessors(chain = true)
    public static class TestX {
        private String y3 = "I want to change to test";
    }

    public TestConfig load() throws IOException {
        return super.load(ConfigOverrides.forPrefixes("testprefix")
                .withEnvironmentVariables()
                .withSystemProperties());
    }
    
	@Test
	public void testConfigToJson() throws JsonProcessingException {
		var conf   = new TestConfig();
		assertEquals("{\"x3\":{\"y3\":\"I want to change to test\"}}", conf.toJson());
		conf.getX3().setY3(null);
		assertEquals("{\"x3\":{\"y3\":\"\"}}", conf.toJson());
	}

	@Override
	public void forEachCredentialPath(Consumer<String> withSecretPath) {
		withSecretPath.accept("x3");
	}
}
