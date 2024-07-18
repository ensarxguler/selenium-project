package com.cydeo.tests.day11_pom_explicit_waits;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Understanding_closeDriver_method {

    @Test
    public void test1() {
        WebDriver driver = Driver.getDriver();
        driver.get("https://www.google.com/");
        //verify something
        //Driver.getDriver().quit();
        //Driver.getDriver().close();
        Driver.closeDriver();
    }

    @Test
    public void test2() {
        WebDriver driver = Driver.getDriver();
        driver.get("https://www.google.com/");
        //verify something else
        //Driver.getDriver().quit();
        //Driver.getDriver().close();
        Driver.closeDriver();
    }

    @Test
    public void test3() {
        WebDriver driver = Driver.getDriver();
        driver.get("https://www.google.com/");
        //verify something completely different
        //Driver.getDriver().quit();
        //Driver.getDriver().close();
        Driver.closeDriver();
    }

}
