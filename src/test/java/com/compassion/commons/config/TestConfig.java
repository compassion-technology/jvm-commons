package com.compassion.commons.config;

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

    public TestConfig load() {
        return super.load(ConfigOverrides.forPrefix("testprefix")
                .withEnvironmentVariables()
                .withSystemProperties());
    }
}
