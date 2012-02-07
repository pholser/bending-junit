package com.pholser.junit.matchers;

import com.pholser.junit.util.Classes;
import org.hamcrest.Description;

public class HasPrivateZeroArgConstructor extends PredicateMatcher<Class<?>> {
    private HasPrivateZeroArgConstructor() {
        super(Classes._.hasPrivateZeroArgConstructor);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("a class with a private zero-arg constructor");
    }

    public static HasPrivateZeroArgConstructor hasPrivateZeroArgConstructor() {
        return new HasPrivateZeroArgConstructor();
    }
}
