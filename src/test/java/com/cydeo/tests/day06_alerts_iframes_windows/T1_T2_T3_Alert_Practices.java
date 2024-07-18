package com.cydeo.tests.day06_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class T1_T2_T3_Alert_Practices {

    WebDriver driver;
    
    @BeforeClass
    public void setupClass() {
        // 1- Open browser
        // 2- Go to the website: "https://practice.cydeo.com/javascript_alerts"
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        driver.get("https://practice.cydeo.com/javascript_alerts");
    }
    
    @Test (priority = 1)
    public void information_alert_test1() {

        // 1.3 - Click to "Click fo JS Alert" button.
        driver.findElement(By.xpath("//button[.='Click for JS Alert']")).click();

        // 1.4 - Click to "OK" button from the alert.
        Alert informationAlert = driver.switchTo().alert();
        informationAlert.accept();

        // 1.5 - Verify "You successfully clicked an alert" text is displayed and correct.
        Assert.assertTrue(driver.findElement(By.xpath("//p[@id='result']")).isDisplayed(), "Result text is NOT displayed!!!");
        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='result']")).getText(), "You successfully clicked an alert", "Actual text is NOT as expected!!!");

    }
    
    @Test (priority = 2, dependsOnMethods = "information_alert_test1")
    public void confirmation_alert_test2() {

        // 2.3 - Click to "Click fo JS Confirm" button.
        driver.findElement(By.xpath("//button[.='Click for JS Confirm']")).click();
        
        // 2.4 - Click to "OK" button from the alert.
        Alert confirmationAlert = driver.switchTo().alert();
        confirmationAlert.accept();

        // 2.5 - Verify "You clicked: Ok" text is displayed and correct.        
        Assert.assertTrue(driver.findElement(By.xpath("//p[@id='result']")).isDisplayed(), "Result text is NOT displayed!!!");
        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='result']")).getText(), "You clicked: Ok", "Actual text is NOT as expected!!!");
        
    }
    
    @Test (priority = 3, dependsOnMethods = "confirmation_alert_test2")
    public void prompt_alert_test1() {

        // 3.3 - Click to "Click fo JS Alert" button.
        driver.findElement(By.xpath("//button[.='Click for JS Prompt']")).click();

        // 3.4 - Click to "OK" button from the alert.
        Alert promptAlert = driver.switchTo().alert();
        promptAlert.sendKeys("hello");
        promptAlert.accept();

        // 3.5 - Verify "You successfully clicked an alert" text is displayed and correct.
        Assert.assertTrue(driver.findElement(By.xpath("//p[@id='result']")).isDisplayed(), "Result text is NOT displayed!!!");
        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='result']")).getText(), "You entered: hello", "Actual text is NOT as expected!!!");

    }

    @AfterClass
    public void tearDownClass() {
        driver.close();
    }

}
