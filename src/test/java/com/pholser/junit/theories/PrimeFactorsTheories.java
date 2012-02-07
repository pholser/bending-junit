package com.pholser.junit.theories;

import com.pholser.junit.parameterized.PrimeFactors;
import com.pholser.junit.quickcheck.ForAll;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import java.math.BigInteger;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.junit.Assume.*;

@RunWith(Theories.class)
public class PrimeFactorsTheories {
    @Theory
    public void factorsPassPrimalityTest(@ForAll int n) {
        assumeThat(n, greaterThan(0));

        for (int each : PrimeFactors.of(n))
            assertTrue(BigInteger.valueOf(each).isProbablePrime(1000));
    }

    @Theory
    public void factorsMultiplyToOriginal(int n) {
        assumeThat(n, greaterThan(0));

        int product = 1;
        for (int each : PrimeFactors.of(n))
            product *= each;

        assertEquals(n, product);
    }
}
