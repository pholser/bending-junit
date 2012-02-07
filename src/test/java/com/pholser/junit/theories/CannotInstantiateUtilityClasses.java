package com.pholser.junit.theories;

import com.pholser.junit.categories.InvolvingRules;
import com.pholser.junit.theories.supply.ClassSupplier.Any;
import org.junit.Rule;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static com.pholser.junit.matchers.ExceptionMatchers.*;
import static com.pholser.junit.matchers.HasPrivateZeroArgConstructor.*;
import static org.junit.Assume.*;
import static org.junit.rules.ExpectedException.*;

@RunWith(Theories.class)
@Category(InvolvingRules.class)
public class CannotInstantiateUtilityClasses {
    @Rule public final ExpectedException thrown = none();

    @Theory
    public void attemptInstantiation(@Any Class<?> utility) throws Exception {
        assumeThat(utility, hasPrivateZeroArgConstructor());

        Constructor<?> ctor = utility.getDeclaredConstructor();
        ctor.setAccessible(true);

        thrown.expect(InvocationTargetException.class);
        thrown.expect(targetOfType(UnsupportedOperationException.class));

        ctor.newInstance();
    }
}
