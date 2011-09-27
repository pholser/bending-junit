package com.tulsatechfest.pholser.junit.matchers;

import com.tulsatechfest.pholser.junit.util.Classes;
import org.hamcrest.Description;

public class HasPrivateZeroArgCtor extends PredicateMatcher<Class<?>> {
    public HasPrivateZeroArgCtor() {
        super(Classes._.hasPrivateZeroArgConstructor);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("a class with a private zero-arg ctor");
    }
}
