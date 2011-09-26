package com.tulsatechfest.pholser.junit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import static org.junit.Assert.*;

public class TestNameDemo {
    @Rule public final TestName name = new TestName();

    @Test
    public void checkName() {
        assertEquals("checkName", name.getMethodName());
    }
}
