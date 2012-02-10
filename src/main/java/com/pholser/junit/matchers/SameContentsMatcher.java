package com.pholser.junit.matchers;

import java.util.Collection;

import com.pholser.junit.util.Containers;
import org.hamcrest.Description;

public class SameContentsMatcher<T> extends PredicateMatcher<Collection<T>> {
    private final Collection<T> exemplar;

    private SameContentsMatcher(Collection<T> exemplar) {
        super(Containers._.hasSameContentsAs(exemplar));
        this.exemplar = exemplar;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("a collection with the same contents as ");
        description.appendValue(exemplar);
    }

    public static <U> SameContentsMatcher<U> hasSameContentsAs(Collection<U> exemplar) {
        return new SameContentsMatcher<U>(exemplar);
    }
}
