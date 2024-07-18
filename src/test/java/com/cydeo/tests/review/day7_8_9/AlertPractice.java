package com.cydeo.tests.review.day7_8_9;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertPractice {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        // 1. Open browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void alert_test() {
        // 1.2 Go to website: "https://practice.cydeo.com/javascript_alerts"
        driver.get("https://practice.cydeo.com/javascript_alerts");

        // 1.3 Click to: “Click for JS Prompt” button.
        driver.findElement(By.xpath("//button[.='Click for JS Prompt']")).click();

        // 1.4 Send “hello” text to alert.
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("hello");

        // 1.5 Click to OK button from the alert.
        alert.accept();

        // 1.6 Verify "You entered: hello" text is displayed.
        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='result']")).getText(), "You entered: hello", "Text verification is FAILED!!!");
    }

    @AfterMethod
    public void tearDownMethod() {
        driver.quit();
    }

}
