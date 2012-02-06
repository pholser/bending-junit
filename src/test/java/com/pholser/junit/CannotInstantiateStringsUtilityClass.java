package com.pholser.junit;

import com.pholser.junit.util.Strings;

import com.pholser.junit.UtilityClassHarness;


public class CannotInstantiateStringsUtilityClass extends UtilityClassHarness {
    public CannotInstantiateStringsUtilityClass() {
        super(Strings.class);
    }
}
