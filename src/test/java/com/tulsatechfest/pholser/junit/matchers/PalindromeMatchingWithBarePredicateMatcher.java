package com.tulsatechfest.pholser.junit.matchers;

import com.tulsatechfest.pholser.junit.util.Strings;
import org.junit.Test;

import static com.tulsatechfest.pholser.junit.matchers.PredicateMatcher.matches;
import static org.hamcrest.CoreMatchers.not;
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
