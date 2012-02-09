package com.pholser.junit;

import java.util.Collections;

import org.junit.Test;

public class AssertionsAreNothingSpecialTest {
    @Test
    public void usesNativeJavaAssertions() {
        assert Collections.emptyList().isEmpty();
    }
}
