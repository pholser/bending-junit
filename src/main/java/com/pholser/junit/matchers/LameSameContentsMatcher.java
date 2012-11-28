package com.pholser.junit.matchers;

import java.util.Collection;

import com.pholser.junit.util.Containers;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

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

    public static <U> LameSameContentsMatcher<U> hasSameContentsAs(Collection<U> exemplar) {
        return new LameSameContentsMatcher<U>(exemplar);
    }
}
