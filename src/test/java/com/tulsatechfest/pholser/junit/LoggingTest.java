package com.tulsatechfest.pholser.junit;

import com.tulsatechfest.pholser.junit.categories.InvolvingRules;
import com.tulsatechfest.pholser.junit.rules.LoggingRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(InvolvingRules.class)
public class LoggingTest {
    @Rule public final LoggingRule logging = new LoggingRule();

    @Test
    public void aTest() {
    }
}
