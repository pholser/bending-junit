package com.tulsatechfest.pholser.junit;

import com.google.common.base.Predicate;

public class Strings {
    public static class _ {
        public static final Predicate<String> isPalindrome = new Predicate<String>() {
            @Override
            public boolean apply(String input) {
                return isPalindrome(input);
            }
        };
    }

    public static boolean isPalindrome(String s) {
        return s != null && s.equals(new StringBuilder(s).reverse().toString());
    }

    private Strings() {
        throw new UnsupportedOperationException();
    }
}
