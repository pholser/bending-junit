package com.tulsatechfest.pholser.junit;

import com.tulsatechfest.pholser.junit.rules.LoggingRule;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoggingTest {
    @Rule public final LoggingRule logging = new LoggingRule();

    @Test
    public void aTest() {
    }
}
