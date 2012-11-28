package com.pholser.junit.matchers;

import com.pholser.junit.util.Strings;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class LamePalindromeMatcher extends TypeSafeMatcher<String> {
    @Override
    public boolean matchesSafely(String item) {
        return Strings.isPalindrome(item);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("a palindromic string");
    }
}
