package com.tulsatechfest.pholser.junit.theories.supply;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

import com.tulsatechfest.pholser.junit.matchers.ExceptionMatchers;
import com.tulsatechfest.pholser.junit.parameterized.PrimeFactors;
import com.tulsatechfest.pholser.junit.util.Classes;
import com.tulsatechfest.pholser.junit.util.Containers;
import com.tulsatechfest.pholser.junit.util.Strings;
import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.ParametersSuppliedBy;
import org.junit.experimental.theories.PotentialAssignment;

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
        if (sig.getType() != Class.class)
            throw new IllegalStateException("Annotated parameter of " + sig.getType()
                + " with @" + Any.class.getSimpleName());

        List<PotentialAssignment> assignments = new ArrayList<PotentialAssignment>();
        for (Class<?> each : classes)
            assignments.add(PotentialAssignment.forValue(each.getName(), each));
        return assignments;
    }
}