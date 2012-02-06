package com.pholser.junit.parameterized;

import com.pholser.junit.parameterized.PrimeFactors;

import org.junit.Test;

import static java.util.Arrays.*;
import static java.util.Collections.*;
import static org.junit.Assert.*;

public class UnparameterizedPrimeFactorsTest {
    @Test
    public void one() {
        assertEquals(emptyList(), PrimeFactors.of(1));
    }

    @Test
    public void two() {
        assertEquals(asList(2), PrimeFactors.of(2));
    }

    @Test
    public void three() {
        assertEquals(asList(3), PrimeFactors.of(3));
    }

    @Test
    public void four() {
        assertEquals(asList(2, 2), PrimeFactors.of(4));
    }

    @Test
    public void five() {
        assertEquals(asList(5), PrimeFactors.of(5));
    }

    @Test
    public void six() {
        assertEquals(asList(2, 3), PrimeFactors.of(6));
    }

    @Test
    public void seven() {
        assertEquals(asList(7), PrimeFactors.of(7));
    }

    @Test
    public void eight() {
        assertEquals(asList(2, 2, 2), PrimeFactors.of(8));
    }

    @Test
    public void nine() {
        assertEquals(asList(3, 3), PrimeFactors.of(9));
    }
}
