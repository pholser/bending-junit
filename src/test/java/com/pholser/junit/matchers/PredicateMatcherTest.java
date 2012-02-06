package com.pholser.junit.matchers;

import com.pholser.junit.matchers.PredicateMatcher;

import com.google.common.base.Predicate;
import org.hamcrest.Description;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class PredicateMatcherTest {
    @Mock private Predicate<Object> predicate;
    private PredicateMatcher<Object> matcher;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        matcher = new PredicateMatcher<Object>(predicate) {
            @Override
            public void describeTo(Description description) {
                description.appendText("matches predicate");
            }
        };
    }

    @Test
    public void defersToPredicateToDecideMatches() {
        when(predicate.apply(any())).thenReturn(true);

        Object target = new Object();
        assertTrue(matcher.matches(target));

        verify(predicate).apply(target);
    }
}
