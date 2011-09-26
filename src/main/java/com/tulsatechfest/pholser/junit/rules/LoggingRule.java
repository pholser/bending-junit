package com.tulsatechfest.pholser.junit.rules;

import org.apache.log4j.Logger;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class LoggingRule extends TestWatcher {
    @Override
    protected void starting(Description description) {
        loggerFor(description).info(message("Starting", description));
    }

    @Override
    protected void finished(Description description) {
        loggerFor(description).info(message("Finished", description));
    }

    @Override
    protected void succeeded(Description description) {
        loggerFor(description).info(message("Succeeded", description));
    }

    @Override
    protected void failed(Throwable e, Description description) {
        Logger logger = loggerFor(description);
        logger.error(message("Failed", description), e);
    }

    private Logger loggerFor(Description description) {
        return Logger.getLogger(description.getClassName());
    }

    private String message(String prefix, Description description) {
        return prefix + ": " + description.getClassName() + '#' + description.getMethodName();
    }
}
