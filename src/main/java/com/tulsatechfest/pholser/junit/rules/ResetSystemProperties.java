package com.tulsatechfest.pholser.junit.rules;

import java.util.Collection;
import java.util.Collections;
import java.util.Properties;

import org.junit.rules.ExternalResource;

public class ResetSystemProperties extends ExternalResource {
    private Properties original;

    @Override
    protected void before() {
        original = new Properties();
        Properties forSystem = System.getProperties();

        @SuppressWarnings("unchecked")
        Collection<String> keys = (Collection<String>) Collections.list(forSystem.propertyNames());

        for (String each : keys) {
            original.setProperty(each, forSystem.getProperty(each));
        }
    }

    @Override
    protected void after() {
        System.setProperties(original);
    }
}
