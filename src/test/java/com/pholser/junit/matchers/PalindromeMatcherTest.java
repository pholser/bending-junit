package com.pholser.junit.matchers;

import com.pholser.junit.matchers.PalindromeMatcher;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class PalindromeMatcherTest {
    private PalindromeMatcher isPalindrome;

    @Before
    public void setUp() {
        isPalindrome = new PalindromeMatcher();
    }

    @Test
    public void versusNull() {
        assertThat(null, not(isPalindrome));
    }

    @Test
    public void versusPalindrome() {
        assertThat("radar", isPalindrome);
    }

    @Test
    public void versusNonPalindrome() {
        assertThat("scuba", not(isPalindrome));
    }
}
