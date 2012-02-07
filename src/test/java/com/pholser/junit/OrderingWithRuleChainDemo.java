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
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;

public class OrderingWithRuleChainDemo {
    @ClassRule public static final TestRule classRule =
            RuleChain.outerRule(new PrintingRule(OrderingWithRuleChainDemo.class + "#classRule1"))
                     .around(new PrintingRule(OrderingWithRuleChainDemo.class + "#classRule2"));
    @Rule public final TestRule rule =
            RuleChain.outerRule(new PrintingRule(OrderingWithRuleChainDemo.class + "#rule1"))
                     .around(new PrintingRule(OrderingWithRuleChainDemo.class + "#rule2"));

    @BeforeClass
    public static void setUpOrderingClass1() {
        System.out.println(OrderingWithRuleChainDemo.class + "#setUpOrderingClass1()");
    }

    @BeforeClass
    public static void setUpOrderingClass2() {
        System.out.println(OrderingWithRuleChainDemo.class + "#setUpOrderingClass2()");
    }

    @Before
    public final void setUpOrdering1() {
        System.out.println(OrderingWithRuleChainDemo.class + "#setUpOrdering1()");
    }

    @Before
    public final void setUpOrdering2() {
        System.out.println(OrderingWithRuleChainDemo.class + "#setUpOrdering2()");
    }

    @Test
    @Category(InvolvingRules.class)
    public final void orderingTest1() {
        System.out.println(OrderingWithRuleChainDemo.class + "#orderingTest1()");
    }

    @Test
    @Category(InvolvingRules.class)
    public final void orderingTest2() {
        System.out.println(OrderingWithRuleChainDemo.class + "#orderingTest2()");
    }

    @After
    public final void tearDownOrdering1() {
        System.out.println(OrderingWithRuleChainDemo.class + "#tearDownOrdering1()");
    }

    @After
    public final void tearDownOrdering2() {
        System.out.println(OrderingWithRuleChainDemo.class + "#tearDownOrdering2()");
    }

    @AfterClass
    public static void tearDownOrderingClass1() {
        System.out.println(OrderingWithRuleChainDemo.class + "#tearDownOrderingClass1()");
    }

    @AfterClass
    public static void tearDownOrderingClass2() {
        System.out.println(OrderingWithRuleChainDemo.class + "#tearDownOrderingClass2()");
    }
}
