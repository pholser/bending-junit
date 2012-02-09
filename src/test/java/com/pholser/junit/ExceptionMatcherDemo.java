package com.pholser.junit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.pholser.junit.categories.InvolvingRules;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;

import static com.pholser.junit.matchers.ExceptionMatchers.*;
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
