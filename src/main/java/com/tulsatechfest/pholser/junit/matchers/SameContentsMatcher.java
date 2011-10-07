package com.tulsatechfest.pholser.junit.matchers;

import com.tulsatechfest.pholser.junit.util.Containers;
import org.hamcrest.Description;

import java.util.Collection;

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

    public static <T> SameContentsMatcher<T> hasSameContentsAs(Collection<T> exemplar) {
        return new SameContentsMatcher<T>(exemplar);
    }
}
