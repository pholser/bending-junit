package com.pholser.junit;

import com.pholser.junit.categories.InvolvingRules;
import com.pholser.junit.rules.PrintingRule;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class OrderingDemo {
    @ClassRule public static final PrintingRule classRule1 = new PrintingRule(OrderingDemo.class + "#classRule1");
    @ClassRule public static final PrintingRule classRule2 = new PrintingRule(OrderingDemo.class + "#classRule2");
    @Rule public final PrintingRule rule1 = new PrintingRule(OrderingDemo.class + "#rule1");
    @Rule public final PrintingRule rule2 = new PrintingRule(OrderingDemo.class + "#rule2");

    @BeforeClass
    public static void setUpOrderingClass1() {
        System.out.println(OrderingDemo.class + "#setUpOrderingClass1()");
    }

    @BeforeClass
    public static void setUpOrderingClass2() {
        System.out.println(OrderingDemo.class + "#setUpOrderingClass2()");
    }

    @Before
    public final void setUpOrdering1() {
        System.out.println(OrderingDemo.class + "#setUpOrdering1()");
    }

    @Before
    public final void setUpOrdering2() {
        System.out.println(OrderingDemo.class + "#setUpOrdering2()");
    }

    @Test
    @Category(InvolvingRules.class)
    public final void orderingTest1() {
        System.out.println(OrderingDemo.class + "#orderingTest1()");
    }

    @Test
    @Category(InvolvingRules.class)
    public final void orderingTest2() {
        System.out.println(OrderingDemo.class + "#orderingTest2()");
    }

    @After
    public final void tearDownOrdering1() {
        System.out.println(OrderingDemo.class + "#tearDownOrdering1()");
    }

    @After
    public final void tearDownOrdering2() {
        System.out.println(OrderingDemo.class + "#tearDownOrdering2()");
    }

    @AfterClass
    public static void tearDownOrderingClass1() {
        System.out.println(OrderingDemo.class + "#tearDownOrderingClass1()");
    }

    @AfterClass
    public static void tearDownOrderingClass2() {
        System.out.println(OrderingDemo.class + "#tearDownOrderingClass2()");
    }
}
