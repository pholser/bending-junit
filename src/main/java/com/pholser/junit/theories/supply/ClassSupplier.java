package com.pholser.junit.theories.supply;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.pholser.junit.matchers.ExceptionMatchers;
import com.pholser.junit.parameterized.PrimeFactors;
import com.pholser.junit.util.Classes;
import com.pholser.junit.util.Containers;
import com.pholser.junit.util.Strings;
import org.junit.contrib.theories.ParameterSignature;
import org.junit.contrib.theories.ParameterSupplier;
import org.junit.contrib.theories.ParametersSuppliedBy;
import org.junit.contrib.theories.PotentialAssignment;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

public class ClassSupplier extends ParameterSupplier {
    @Target(PARAMETER)
    @Retention(RUNTIME)
    @ParametersSuppliedBy(ClassSupplier.class)
    public @interface Any {
    }

    private static final Class<?>[] classes = {
        Containers.class,
        Containers._.class,
        Strings.class,
        Strings._.class,
        ExceptionMatchers.class,
        Classes.class,
        Classes._.class,
        PrimeFactors.class
    };

    @Override
    public List<PotentialAssignment> getValueSources(ParameterSignature sig) {
        if (!(isClass(sig.getType()) || isParameterizedClass(sig.getType())))
            throw new IllegalStateException("Annotated parameter of " + sig.getType()
                + " with @" + Any.class.getSimpleName());

        List<PotentialAssignment> assignments = new ArrayList<PotentialAssignment>();
        for (Class<?> each : classes)
            assignments.add(PotentialAssignment.forValue(each.getName(), each));
        return assignments;
    }

    private static boolean isClass(Type type) {
        return type == Class.class;
    }

    private boolean isParameterizedClass(Type type) {
        return type instanceof ParameterizedType && isClass(((ParameterizedType) type).getRawType());
    }
}
