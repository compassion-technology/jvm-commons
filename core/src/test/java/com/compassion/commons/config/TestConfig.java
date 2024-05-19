package com.compassion.commons.config;

import java.io.IOException;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain = true)
public class TestConfig extends YAMLConfig {

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
}
