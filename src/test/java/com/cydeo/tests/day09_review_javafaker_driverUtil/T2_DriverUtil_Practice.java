package com.cydeo.tests.day09_review_javafaker_driverUtil;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class T2_DriverUtil_Practice {

    // TC #2: Bing search

    @Test
    public void test1() {
        //2- Go to: "https://www.bing.com/".

        // Driver.getDriver() --> will return me the "driver"
        // instead of writing "driver" from now on, we will write Driver.getDriver();
        Driver.getDriver().get(ConfigurationReader.getProperty("bing.URL"));

        // For Firefox
        BrowserUtils.sleep(3);

        // Passing the HTML (Non-JS Alert)
        Driver.getDriver().findElement(By.xpath("//a[.='Accept']")).click();

        //3- Write “apple” in search box.
        Driver.getDriver().findElement(By.xpath("//textarea[@id='sb_form_q']")).sendKeys(ConfigurationReader.getProperty("search.keyword") + Keys.ENTER);

        // For Firefox
        BrowserUtils.sleep(3);

        //4- Verify title: Expected: "apple - Search"
        Assert.assertEquals(Driver.getDriver().getTitle(), ConfigurationReader.getProperty("search.keyword") + " - Search", "Title verification is FAILED!");
    }

    @Test
    public void test2() {
        //2- Go to: "https://www.bing.com/".

        // Driver.getDriver() --> will return me the "driver"
        // instead of writing "driver" from now on, we will write Driver.getDriver();
        Driver.getDriver().get(ConfigurationReader.getProperty("bing.URL"));

        // For Firefox
        BrowserUtils.sleep(3);

        // Passing the HTML (Non-JS Alert)
        Driver.getDriver().findElement(By.xpath("//a[.='Accept']")).click();

        //3- Write “apple” in search box.
        Driver.getDriver().findElement(By.xpath("//textarea[@id='sb_form_q']")).sendKeys(ConfigurationReader.getProperty("search.keyword") + Keys.ENTER);

        // For Firefox
        BrowserUtils.sleep(3);

        //4- Verify title: Expected: "apple - Search"
        Assert.assertEquals(Driver.getDriver().getTitle(), ConfigurationReader.getProperty("search.keyword") + " - Search", "Title verification is FAILED!");
    }

    @AfterMethod
    public void tearDownMethod() {
        // We won't be using the selenium's .quit() method directly anymore.
        // Driver.getDriver().quit();
        // We will use Driver.closeDriver();
        Driver.closeDriver();
    }

}
