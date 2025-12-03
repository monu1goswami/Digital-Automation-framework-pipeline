package com.automation.framework.utils;

import org.testng.Assert;

public class AssertionsUtil {

    public static void assertTextContains(String actual, String expected) {
        Assert.assertTrue(actual.contains(expected),
                "Expected text: " + expected + " but got: " + actual);
    }

    public static void assertTrue(boolean condition, String message) {
        Assert.assertTrue(condition, message);
    }
}
