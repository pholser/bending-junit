package com.tulsatechfest.pholser.junit;

import com.tulsatechfest.pholser.junit.categories.InvolvingRules;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.TestName;

import static org.junit.Assert.*;

@Category(InvolvingRules.class)
public class TestNameDemo {
    @Rule public final TestName name = new TestName();

    @Test
    public void checkName() {
        assertEquals("checkName", name.getMethodName());
    }
}
