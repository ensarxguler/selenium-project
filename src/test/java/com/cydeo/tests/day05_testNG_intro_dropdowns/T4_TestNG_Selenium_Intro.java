package com.cydeo.tests.day05_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class T4_TestNG_Selenium_Intro {
    
    WebDriver driver;
    
    @BeforeMethod
    public void setupMethod() {
        // 1- Open a Chrome browser.
        // 2- Go to "https://practice.cydeo.com/".
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        driver.get("https://practice.cydeo.com/");
    }

    @Test
    public void test1_cydeo_title_verification() {
        // 3- Verify title: Expected: Practice
        Assert.assertEquals(driver.getTitle(), "Practice");
    }

    @AfterMethod
    public void tearDownMethod() {
        driver.quit();
    }

}
