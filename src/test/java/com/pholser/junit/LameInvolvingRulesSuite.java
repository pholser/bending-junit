package com.pholser.junit;

import com.pholser.junit.theories.CannotInstantiateUtilityClasses;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
    ExceptionMatcherDemo.class,
    LoggingTest.class,
    OrderingDemo.class,
    SubOrderingDemo.class,
    TempFolderDemo.class,
    TestNameDemo.class,
    CannotInstantiateUtilityClasses.class
})
public class LameInvolvingRulesSuite {
}
