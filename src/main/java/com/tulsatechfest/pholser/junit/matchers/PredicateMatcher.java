package com.tulsatechfest.pholser.junit.matchers;

import com.google.common.base.Predicate;
import org.hamcrest.Description;
import org.junit.internal.matchers.TypeSafeMatcher;

public abstract class PredicateMatcher<T> extends TypeSafeMatcher<T> {
    protected final Predicate<? super T> predicate;

    public PredicateMatcher(Predicate<? super T> predicate) {
        this.predicate = predicate;
    }

    @Override
    public final boolean matchesSafely(T target) {
        return predicate.apply(target);
    }

    public static <U> PredicateMatcher<U> matches(Predicate<? super U> predicate) {
        return new PredicateMatcher<U>(predicate) {
            @Override
            public void describeTo(Description description) {
                description.appendText("a value that passes the predicate ");
                description.appendValue(this.predicate);
            }
        };
    }
}
