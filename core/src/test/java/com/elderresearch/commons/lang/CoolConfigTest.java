package com.elderresearch.commons.lang;

import com.elderresearch.commons.lang.config.TestConfig;
import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junitpioneer.jupiter.SetEnvironmentVariable;

public class CoolConfigTest {

    @Test
    @SetEnvironmentVariable(key = "TESTPREFIX_X3_Y3", value = "test")
    public void testSomething() {
        val conf = new TestConfig().load();
        Assertions.assertEquals(conf.getX3().getY3(), "test");
    }
}
