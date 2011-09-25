package com.tulsatechfest.pholser.junit.util;

import java.util.ArrayList;
import java.util.Collection;

import com.google.common.base.Predicate;

public class Containers {
    private Containers() {
        throw new UnsupportedOperationException();
    }

    public static boolean haveSameContents(Collection<?> first, Collection<?> second) {
        if (first.size() != second.size())
            return false;

        Collection<?> copyOfFirst = new ArrayList<Object>(first);
        for (Object each : second)
            copyOfFirst.remove(each);

        return copyOfFirst.isEmpty();
    }

    public static class _ {
        public static Predicate<Collection<?>> hasSameContentsAs(final Collection<?> exemplar) {
            return new Predicate<Collection<?>>() {
                @Override
                public boolean apply(Collection<?> input) {
                    return haveSameContents(exemplar, input);
                }
            };
        }
    }
}
