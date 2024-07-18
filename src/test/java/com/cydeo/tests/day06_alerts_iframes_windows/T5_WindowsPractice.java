package com.cydeo.tests.day06_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T5_WindowsPractice {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        // 1- Open browser.
        // 2- Go to: "https://practice.cydeo.com/windows".
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://practice.cydeo.com/windows");
    }

    @Test
    public void multiple_windows_test() {

        // 3- Assert: Title is "Windows".
        Assert.assertEquals(driver.getTitle(), "Windows", "Title verification is FAILED!!!");
        
        String mainHandle = driver.getWindowHandle();

        // 4- Click to: "Click here" link.
        driver.findElement(By.xpath("//a[.='Click Here']")).click();
        
        // 5- Switch to new Window USING ENHANCED FOR LOOP.
        for (String eachTab : driver.getWindowHandles()) {
            driver.switchTo().window(eachTab);
        }

        // 6- Assert: Title is "New Window".
        Assert.assertEquals(driver.getTitle(), "New Window", "Title verification is FAILED!!!");

    }

    @AfterMethod
    public void tearDownMethod() {
        // driver.quit closes the whole window.
        driver.quit();
    }

}
