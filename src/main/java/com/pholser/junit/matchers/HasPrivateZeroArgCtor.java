package com.pholser.junit.matchers;

import com.pholser.junit.util.Classes;

import org.hamcrest.Description;

public class HasPrivateZeroArgCtor extends PredicateMatcher<Class<?>> {
    private HasPrivateZeroArgCtor() {
        super(Classes._.hasPrivateZeroArgConstructor);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("a class with a private zero-arg ctor");
    }

    public static HasPrivateZeroArgCtor hasPrivateZeroArgCtor() {
        return new HasPrivateZeroArgCtor();
    }
}
