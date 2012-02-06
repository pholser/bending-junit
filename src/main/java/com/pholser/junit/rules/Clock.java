package com.pholser.junit.rules;

import org.joda.time.DateTimeUtils;
import org.junit.rules.ExternalResource;

public class Clock extends ExternalResource {
    public void timeTravelTo(long millis) {
        DateTimeUtils.setCurrentMillisFixed(millis);
    }

    @Override
    protected void after() {
        DateTimeUtils.setCurrentMillisSystem();
    }
}
