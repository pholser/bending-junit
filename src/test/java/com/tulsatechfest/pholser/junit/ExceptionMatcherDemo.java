package com.tulsatechfest.pholser.junit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static com.tulsatechfest.pholser.junit.matchers.ExceptionMatchers.*;
import static org.junit.rules.ExpectedException.*;

public class ExceptionMatcherDemo {
    @Rule public final ExpectedException thrown = none();

    @Test
    public void cause() throws Exception {
        Method method = getClass().getDeclaredMethod("raisesException");

        thrown.expect(InvocationTargetException.class);
        thrown.expect(causeOfType(IllegalStateException.class));

        method.invoke(this);
    }

    void raisesException() {
        throw new IllegalStateException();
    }
}
