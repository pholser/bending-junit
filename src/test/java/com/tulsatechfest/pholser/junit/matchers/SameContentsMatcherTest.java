package com.tulsatechfest.pholser.junit.matchers;

import java.util.Collection;

import com.tulsatechfest.pholser.junit.util.Containers;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static java.util.Arrays.*;
import static java.util.Collections.*;
import static org.junit.Assert.*;
import static org.junit.Assume.*;

@RunWith(Theories.class)
public class SameContentsMatcherTest {
    @DataPoints
    public static Collection<?>[] containers() {
        return new Collection<?>[] {
            null,
            emptySet(),
            emptyList(),
            singletonList(0),
            singletonList(1),
            singleton(0),
            singleton(1),
            singletonList(2),
            asList(1, 1),
            asList(1, 2),
            asList(1, 1, 2, 3, 3, 4, 4),
            asList(1, 2, 3, 4, 1, 3, 4),
            asList(1, 2, 3, 4, 1, 2),
            asList(1, 2, 3, 4, 1, 6)
        };
    }

    @Theory
    public void givesResultsOfBooleanTest(Collection<?> first, Collection<?> second) {
        assumeNotNull(first, second);

        boolean methodResult = Containers.haveSameContents(first, second);
        assertEquals(methodResult, SameContentsMatcher.hasSameContentsAs(first).matches(second));
    }
}
