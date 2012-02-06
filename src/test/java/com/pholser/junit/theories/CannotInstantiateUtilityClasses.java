package com.pholser.junit.theories;

import org.junit.Rule;
import org.junit.experimental.categories.Category;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.pholser.junit.categories.InvolvingRules;

import com.pholser.junit.theories.supply.ClassSupplier.Any;

import static com.pholser.junit.matchers.ExceptionMatchers.*;
import static com.pholser.junit.matchers.HasPrivateZeroArgCtor.*;

import static org.junit.Assume.*;
import static org.junit.rules.ExpectedException.*;

@RunWith(Theories.class)
@Category(InvolvingRules.class)
public class CannotInstantiateUtilityClasses {
    @Rule public final ExpectedException thrown = none();

    @Theory
    public void attemptInstantiation(@Any Class<?> utility) throws Exception {
        assumeThat(utility, hasPrivateZeroArgCtor());

        Constructor<?> ctor = utility.getDeclaredConstructor();
        ctor.setAccessible(true);

        thrown.expect(InvocationTargetException.class);
        thrown.expect(targetOfType(UnsupportedOperationException.class));

        ctor.newInstance();
    }
}