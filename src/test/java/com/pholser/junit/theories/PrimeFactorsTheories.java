package com.pholser.junit.theories;

import java.math.BigInteger;

import com.pholser.junit.parameterized.PrimeFactors;
import org.junit.contrib.theories.DataPoints;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.experimental.theories.DataPoint;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.junit.Assume.*;

@RunWith(Theories.class)
public class PrimeFactorsTheories {
    @DataPoint public static final int ONE = 1;
    @DataPoint public static final int TWO = 2;
    @DataPoint public static final int THREE = 3;
    @DataPoints public static int[] moreExamples = { 4, 5, 6 };

    @DataPoint public static int anotherExample() {
        return 5;
    }

    @DataPoints public static int[] stillMoreExamples() {
        return new int[] { 6, 7, 8, 9 };
    }

    @Theory
    public void factorsPassPrimalityTest(int n) {
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

    @Theory
    public void factorizationsAreUnique(int m, int n) {
        assumeThat(m, greaterThan(0));
        assumeThat(n, greaterThan(0));
        assumeThat(m, not(equalTo(n)));

        assertThat(PrimeFactors.of(m), not(equalTo(PrimeFactors.of(n))));
    }
}
