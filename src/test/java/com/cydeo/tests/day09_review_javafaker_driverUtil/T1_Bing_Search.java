package com.cydeo.tests.day09_review_javafaker_driverUtil;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class T1_Bing_Search {
    
    // TC #1: Bing search

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //1- Open a Chrome browser.
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    
    @org.testng.annotations.Test
    public void test1() {
        //2- Go to: "https://www.bing.com/".
        driver.get(ConfigurationReader.getProperty("bing.URL"));

        // Passing the HTML (Non-JS Alert)
        driver.findElement(By.xpath("//a[.='Accept']")).click();
        
        //3- Write “apple” in search box.
        driver.findElement(By.xpath("//textarea[@id='sb_form_q']")).sendKeys(ConfigurationReader.getProperty("search.keyword") + Keys.ENTER);
        
        //4- Verify title: Expected: "apple - Search"
        Assert.assertEquals(driver.getTitle(), ConfigurationReader.getProperty("search.keyword") + " - Search", "Title verification is FAILED!");
    }

    @AfterMethod
    public void tearDownMethod() {
        driver.close();
    }
    
}
