package com.elderresearch.commons.lang.config;

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
        super.load(EnvironmentTree.forPrefix("testprefix")
                .withEnvironmentVariables()
                .withSystemProperties());
        return this;
    }
}
