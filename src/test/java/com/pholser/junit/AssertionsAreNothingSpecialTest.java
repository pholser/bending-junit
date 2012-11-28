package com.pholser.junit;

import org.junit.Test;

import java.util.Collections;

import static org.hamcrest.JavaLangMatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class AssertionsAreNothingSpecialTest {
    @Test
    public void usesNativeJavaAssertions() {
        assert that(Collections.emptyList(), hasSize(0));
    }
}
