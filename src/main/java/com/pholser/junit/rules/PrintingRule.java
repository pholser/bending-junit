package com.pholser.junit.rules;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class PrintingRule implements TestRule {
    private final String message;

    public PrintingRule(String message) {
        this.message = message;
    }

    @Override
    public Statement apply(Statement base, Description description) {
        System.out.println(message);
        return base;
    }
}
