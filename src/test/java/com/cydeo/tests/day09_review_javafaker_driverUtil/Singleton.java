package com.cydeo.tests.day09_review_javafaker_driverUtil;

public class Singleton {

    // #1 Create private constructor.
    private Singleton() {
    }

    // #2 Create static String.
    private static String Driver;

    // #3 Utility method to return the 'private String' we just created.
    public static String getDriver() {
        if (Driver == null) {
            System.out.println("First time call. Driver object is null.");
            System.out.println("Assigning value to it now.");
            Driver = "driver_sdfkh123213qwerty7824";
        } else {
            System.out.println("Driver already has a value.");
        }

        return Driver;
    }

}
