package com.pholser.junit.matchers;

import static com.pholser.junit.matchers.PredicateMatcher.*;

import com.pholser.junit.util.Strings;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class PalindromeMatchingWithBarePredicateMatcher {
    @Test
    public void versusNull() {
        assertThat(null, not(matches(Strings._.isPalindrome)));
    }

    @Test
    public void versusPalindrome() {
        assertThat("radar", matches(Strings._.isPalindrome));
    }

    @Test
    public void versusNonPalindrome() {
        assertThat("scuba", not(matches(Strings._.isPalindrome)));
    }
}
