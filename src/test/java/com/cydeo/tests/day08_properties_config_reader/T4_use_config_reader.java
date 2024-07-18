package com.cydeo.tests.day08_properties_config_reader;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.time.Duration;

public class T4_use_config_reader {

    //TC #4: Google search
    //Use `configuration.properties` for the following:
    //1. The browser type
    //2. The URL
    //3. The search keyword
    //4. Make title verification dynamic: If search value changes, title assertion should not fail.

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //1- Open a Chrome browser.
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));    // "Dynamic Coding"
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @Test
    public void test1() {
        //2- Go to: "https://google.com".
        driver.get(ConfigurationReader.getProperty("google.URL"));

        //3- Write “apple” in search box.
        driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys(ConfigurationReader.getProperty("search.keyword") + Keys.ENTER);

        //4- Verify title: Expected: "apple - Google Search"
        Assert.assertEquals(driver.getTitle(), ConfigurationReader.getProperty("search.keyword") + " - Google'da Ara", "Title verification is FAILED!");
    }

    @AfterMethod
    public void tearDownMethod() {
        driver.close();
    }

}
