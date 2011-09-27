package com.tulsatechfest.pholser.junit.util;

import java.lang.reflect.Constructor;

import com.google.common.base.Predicate;

import static java.lang.reflect.Modifier.*;

public class Classes {
    private Classes() {
        throw new UnsupportedOperationException();
    }

    public static boolean hasPrivateZeroArgConstructor(Class<?> clazz) {
        try {
            Constructor<?> ctor = clazz.getDeclaredConstructor();
            return isPrivate(ctor.getModifiers());
        } catch (NoSuchMethodException e) {
            return false;
        }
    }

    public static class _ {
        private _() {
            throw new UnsupportedOperationException();
        }

        public static final Predicate<Class<?>> hasPrivateZeroArgConstructor = new Predicate<Class<?>>() {
            @Override
            public boolean apply(Class<?> input) {
                return hasPrivateZeroArgConstructor(input);
            }
        };
    }
}
