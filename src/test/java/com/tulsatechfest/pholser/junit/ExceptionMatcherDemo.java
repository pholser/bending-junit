package com.tulsatechfest.pholser.junit;

import com.tulsatechfest.pholser.junit.categories.InvolvingRules;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static com.tulsatechfest.pholser.junit.matchers.ExceptionMatchers.*;
import static org.junit.rules.ExpectedException.*;

@Category(InvolvingRules.class)
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
