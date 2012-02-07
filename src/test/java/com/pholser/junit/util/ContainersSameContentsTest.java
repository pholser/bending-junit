package com.pholser.junit.util;

import org.junit.Test;

import static java.util.Arrays.*;
import static java.util.Collections.*;
import static org.junit.Assert.*;

public class ContainersSameContentsTest {
    @Test(expected = NullPointerException.class)
    public void nullVersusNonNull() {
        Containers.haveSameContents(null, emptySet());
    }

    @Test(expected = NullPointerException.class)
    public void nonNullVersusNull() {
        Containers.haveSameContents(emptySet(), null);
    }

    @Test
    public void emptyVersusEmpty() {
        assertTrue(Containers.haveSameContents(emptySet(), emptyList()));
    }

    @Test
    public void emptyVersusNonEmpty() {
        assertFalse(Containers.haveSameContents(emptySet(), singleton(1)));
    }

    @Test
    public void nonEmptyVersusEmpty() {
        assertFalse(Containers.haveSameContents(singletonList(0), emptyList()));
    }

    @Test
    public void singletonsWithEquivalentContents() {
        assertTrue(Containers.haveSameContents(singleton(1), singletonList(1)));
    }

    @Test
    public void singletonsWithNonEquivalentContents() {
        assertFalse(Containers.haveSameContents(singleton(1), singletonList(2)));
    }

    @Test
    public void singletonsVersusDoubleton() {
        assertFalse(Containers.haveSameContents(singleton(1), asList(1, 1)));
    }

    @Test
    public void doubletonVersusDoubletonEquivalentContents() {
        assertTrue(Containers.haveSameContents(asList(1, 1), asList(1, 1)));
    }

    @Test
    public void doubletonVersusDoubletonNonEquivalentContents() {
        assertFalse(Containers.haveSameContents(asList(1, 1), asList(1, 2)));
    }

    @Test
    public void mixedOrderOfLists() {
        assertTrue(Containers.haveSameContents(asList(1, 1, 2, 3, 3, 4, 4), asList(1, 2, 3, 4, 1, 3, 4)));
    }

    @Test
    public void mixedOrderOfListsButSlightDifference() {
        assertFalse(Containers.haveSameContents(asList(1, 2, 3, 4, 1, 2), asList(1, 2, 3, 4, 1, 6)));
    }
}
