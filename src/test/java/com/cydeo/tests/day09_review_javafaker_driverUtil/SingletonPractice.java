package com.cydeo.tests.day09_review_javafaker_driverUtil;

import org.testng.annotations.Test;

public class SingletonPractice {

    @Test
    public void singleton_understanding_test1() {
        
        String driver1 = Singleton.getDriver();
        System.out.println("driver1 = " + driver1);
        
        String driver2 = Singleton.getDriver();
        System.out.println("driver2 = " + driver2);
        
        String driver3 = Singleton.getDriver();
        System.out.println("driver3 = " + driver3);
        
    }

}
