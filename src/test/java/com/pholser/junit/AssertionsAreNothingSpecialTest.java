package com.pholser.junit;

import org.junit.Test;

import java.util.Collections;

public class AssertionsAreNothingSpecialTest {
    @Test
    public void usesNativeJavaAssertions() {
        assert Collections.emptyList().isEmpty();
    }
}
