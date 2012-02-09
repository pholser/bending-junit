package com.pholser.junit.matchers;

import java.util.Collection;

import com.pholser.junit.util.Containers;
import org.junit.contrib.theories.DataPoints;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import static com.pholser.junit.matchers.SameContentsMatcher.*;
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
        assertEquals(methodResult, hasSameContentsAs(first).matches(second));
    }
}
