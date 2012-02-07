package com.pholser.junit.matchers;

import com.pholser.junit.util.Containers;
import org.hamcrest.Description;
import org.junit.internal.matchers.TypeSafeMatcher;

import java.util.Collection;

public class LameSameContentsMatcher<T> extends TypeSafeMatcher<Collection<T>> {
    private final Collection<T> exemplar;

    private LameSameContentsMatcher(Collection<T> exemplar) {
        this.exemplar = exemplar;
    }

    @Override
    public boolean matchesSafely(Collection<T> item) {
        return Containers.haveSameContents(exemplar, item);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("a collection with the same contents as ");
        description.appendValue(exemplar);
    }

    public static <T> LameSameContentsMatcher<T> hasSameContentsAs(Collection<T> exemplar) {
        return new LameSameContentsMatcher<T>(exemplar);
    }
}
