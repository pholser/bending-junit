package com.pholser.junit.matchers;

import com.pholser.junit.util.Strings;
import org.hamcrest.Description;

public class PalindromeMatcher extends PredicateMatcher<String> {
    public PalindromeMatcher() {
        super(Strings._.isPalindrome);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("a palindromic string");
    }
}
