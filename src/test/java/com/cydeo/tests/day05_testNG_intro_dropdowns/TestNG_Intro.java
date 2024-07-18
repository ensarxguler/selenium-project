package com.cydeo.tests.day05_testNG_intro_dropdowns;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG_Intro {

    // Conventional naming for "@AfterMethod" is "tearDownMethod()".
    // @AfterMethod is executed before the @T1_Bing_Search annotation.
    @AfterMethod
    public void tearDownMethod() {
        System.out.println("--> After method is running...");
    }

    // 2nd @T1_Bing_Search to be executed.
    // (priority = num) --> Use Case: helps us to manipulate the order of the code execution
    @Test(priority = 1)
    public void test2() {
        System.out.println("T1_Bing_Search #2 is running...");

        // .assertEquals(); method compares two values. If returns true, pass: Otherwise fails.
        Assert.assertEquals("apple", "apple");

        System.out.println("T1_Bing_Search is continuing...");
    }

    // The method with the "@AfterClass" annotation will be executed at the very end of the process.
    @AfterClass
    public void tearDownClass() {
        System.out.println("--> After class is running...");
    }

    // Conventional naming for "@BeforeMethod" is "setUpMethod()".
    // @BeforeMethod is executed before the @T1_Bing_Search annotation.
    @BeforeMethod
    public void setupMethod() {
        System.out.println("--> Before method is running...");
    }

    // Source annotation of the testing is "@T1_Bing_Search".
    // All the structure is shaped around it.
    // If there are multiple @T1_Bing_Search annotations, they're executed in ascending order.
    // (dependsOnMethods = "methodName") attach a order_verify_name_test to another to be executed according to "success" of the passed method.
    @Test(priority = 2, dependsOnMethods = "test2")
    public void test1() {
        System.out.println("T1_Bing_Search #1 is running...");

        String actual = "red";
        String expected = "blue";

        Assert.assertTrue(actual.equals(expected));
    }

    // The method with the "@BeforeClass" annotation will be executed at the very beginning of the process.
    @BeforeClass
    public void setupClass() {
        System.out.println("--> Before class is running...");
    }

}
