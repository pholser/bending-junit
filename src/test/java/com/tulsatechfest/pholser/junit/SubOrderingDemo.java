package com.tulsatechfest.pholser.junit;

import com.tulsatechfest.pholser.junit.rules.PrintingRule;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

public class SubOrderingDemo extends OrderingDemo {
    @ClassRule public static PrintingRule subClassRule1 = new PrintingRule(SubOrderingDemo.class + "#subClassRule1");
    @ClassRule public static PrintingRule subClassRule2 = new PrintingRule(SubOrderingDemo.class + "#subClassRule2");
    @Rule public final PrintingRule subRule1 = new PrintingRule(SubOrderingDemo.class + "#subRule1");
    @Rule public final PrintingRule subRule2 = new PrintingRule(SubOrderingDemo.class + "#subRule2");

    @BeforeClass
    public static void setUpSubOrderingClass1() {
        System.out.println(SubOrderingDemo.class + "#setUpSubOrderingClass1()");
    }

    @BeforeClass
    public static void setUpSubOrderingClass2() {
        System.out.println(SubOrderingDemo.class + "#setUpSubOrderingClass2()");
    }

    @Before
    public final void setUpSubOrdering1() {
        System.out.println(SubOrderingDemo.class + "#setUpSubOrdering1()");
    }

    @Before
    public final void setUpSubOrdering2() {
        System.out.println(SubOrderingDemo.class + "#setUpSubOrdering2()");
    }

    @Test
    public final void subOrderingTest1() {
        System.out.println(SubOrderingDemo.class + "#subOrderingTest1()");
    }

    @Test
    public final void subOrderingTest2() {
        System.out.println(SubOrderingDemo.class + "#subOrderingTest2()");
    }

    @After
    public final void tearDownSubOrdering1() {
        System.out.println(SubOrderingDemo.class + "#tearDownSubOrdering1()");
    }

    @After
    public final void tearDownSubOrdering2() {
        System.out.println(SubOrderingDemo.class + "#tearDownSubOrdering2()");
    }

    @AfterClass
    public static void tearDownSubOrderingClass1() {
        System.out.println(SubOrderingDemo.class + "#tearDownSubOrderingClass1()");
    }

    @AfterClass
    public static void tearDownSubOrderingClass2() {
        System.out.println(SubOrderingDemo.class + "#tearDownSubOrderingClass2()");
    }
}
