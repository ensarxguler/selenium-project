package com.cydeo.tests.day07_webtables_utilities_javafaker;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class T1_Windows_Handling {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //TC#1: Window Handle Practice
        //1. Create new order_verify_name_test and make set-ups.
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @Test
    public void window_handling_test1() {
        //2. Go to: "https://google.com".
        driver.get("https://google.com");

        //3. Copy and paste the lines from below into your class.
        ((JavascriptExecutor) driver).executeScript("window.open('https://www.nytimes.com/','_blank');");

        ((JavascriptExecutor) driver).executeScript("window.open('https://www.imdb.com/','_blank');");

        ((JavascriptExecutor) driver).executeScript("window.open('https://www.goodreads.com/','_blank');");

        //4. Create a logic to switch to the tab where "imdb.com" is open.
        Set<String> allWindowHandles = driver.getWindowHandles();

        for (String eachHandle : allWindowHandles) {
            driver.switchTo().window(eachHandle);
            System.out.println("Current URL: " + driver.getCurrentUrl());

            if (driver.getCurrentUrl().contains("imdb")) {
                break;
            }
        }

        //5. Assert: Title contains “IMDb”
        Assert.assertTrue(driver.getTitle().contains("IMDb"), "Title does NOT contain expected title!!!");
    }

    @Test
    public void window_handling_test2() {
        //2. Go to: "https://google.com".
        driver.get("https://google.com");

        //3. Copy and paste the lines from below into your class.
        ((JavascriptExecutor) driver).executeScript("window.open('https://www.nytimes.com/','_blank');");

        ((JavascriptExecutor) driver).executeScript("window.open('https://www.imdb.com/','_blank');");

        ((JavascriptExecutor) driver).executeScript("window.open('https://www.goodreads.com/','_blank');");

        //4. Create a logic to switch to the tab where "nytimes" is open.
        //5. Assert: Title contains “Breaking News”
        BrowserUtils.switchWindowAndVerify(driver, "nytimes", "Breaking News");
    }

    @Test
    public void title_verification_test3() {
        //2. Go to: "https://google.com".
        driver.get("https://google.com");

        //3. Copy and paste the lines from below into your class.
        ((JavascriptExecutor) driver).executeScript("window.open('https://www.nytimes.com/','_blank');");

        ((JavascriptExecutor) driver).executeScript("window.open('https://www.imdb.com/','_blank');");

        ((JavascriptExecutor) driver).executeScript("window.open('https://www.goodreads.com/','_blank');");

        //4. Create a logic to switch to the tab where "www.nytimes.com" is open.
        //5. Assert: Title contains: “Breaking News”
        BrowserUtils.switchWindowAndVerify(driver, "nytimes", "Breaking News");
        
        //6. Assert: Title equals: “The New York Times - Breaking News, US News, World News and Videos”
        BrowserUtils.verifyTitle(driver, "The New York Times - Breaking News, US News, World News and Videos");

        //7. Assert: Title contains: “The New York Times”
        BrowserUtils.verifyTitleContains(driver, "The New York Times");
    }

    @AfterMethod
    public void tearDownMethod() {
        driver.quit();
    }

}
