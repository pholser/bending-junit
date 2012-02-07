package com.pholser.junit.parameterized;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Collection;
import java.util.List;

import static java.util.Arrays.*;
import static java.util.Collections.*;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class PrimeFactorsTest {
    private final int target;
    private final List<Integer> expectedFactors;

    public PrimeFactorsTest(int target, List<Integer> expectedFactors) {
        this.target = target;
        this.expectedFactors = expectedFactors;
    }

    @Parameters
    public static Collection<?> data() {
        return asList(new Object[][] {
            { 1, emptyList() },
            { 2, asList(2) },
            { 3, asList(3) },
            { 4, asList(2, 2) },
            { 5, asList(5) },
            { 6, asList(2, 3) },
            { 7, asList(7) },
            { 8, asList(2, 2, 2) },
            { 9, asList(3, 3) },
        });
    }

    @Test
    public void comparison() {
        assertEquals(Integer.toString(target), expectedFactors, PrimeFactors.of(target));
    }
}
