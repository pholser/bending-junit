package com.tulsatechfest.pholser.junit.util;

import org.junit.Test;

import static com.tulsatechfest.pholser.junit.util.Strings.*;
import static org.junit.Assert.*;

public class StringPalindromeTest {
    @Test
    public void versusNull() {
        assertFalse(isPalindrome(null));
    }

    @Test
    public void versusPalindrome() {
        assertTrue(isPalindrome("radar"));
    }

    @Test
    public void versusNonPalindrome() {
        assertFalse(isPalindrome("scuba"));
    }
}
