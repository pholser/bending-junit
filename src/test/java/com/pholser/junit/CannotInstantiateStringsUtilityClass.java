package com.pholser.junit;

import com.pholser.junit.util.Strings;

public class CannotInstantiateStringsUtilityClass extends UtilityClassHarness {
    public CannotInstantiateStringsUtilityClass() {
        super(Strings.class);
    }
}
