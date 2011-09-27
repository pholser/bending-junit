package com.tulsatechfest.pholser.junit.matchers;

import java.lang.reflect.InvocationTargetException;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.internal.matchers.TypeSafeMatcher;

public class ExceptionMatchers {
    private ExceptionMatchers() {
        throw new UnsupportedOperationException();
    }

    public static Matcher<Throwable> causeOfType(final Class<? extends Throwable> type) {
        return new TypeSafeMatcher<Throwable>() {
            @Override
            public boolean matchesSafely(Throwable target) {
                return type.isInstance(target.getCause());
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("an exception whose cause is of ");
                description.appendValue(type);
            }
        };
    }

    public static Matcher<InvocationTargetException> targetOfType(final Class<? extends Throwable> type) {
        return new TypeSafeMatcher<InvocationTargetException>() {
            @Override
            public boolean matchesSafely(InvocationTargetException item) {
                return type.isInstance(item.getTargetException());
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("InvocationTargetException with target whose type is ");
                description.appendValue(type);
            }
        };
    }
}
