package com.tulsatechfest.pholser.junit.matchers;

import com.google.common.base.Predicate;
import org.junit.internal.matchers.TypeSafeMatcher;

public abstract class PredicateMatcher<T> extends TypeSafeMatcher<T> {
    private final Predicate<? super T> predicate;

    public PredicateMatcher(Predicate<? super T> predicate) {
        this.predicate = predicate;
    }

    @Override
    public final boolean matchesSafely(T target) {
        return predicate.apply(target);
    }
}
