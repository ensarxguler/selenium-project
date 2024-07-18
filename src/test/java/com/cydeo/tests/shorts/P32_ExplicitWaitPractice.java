package com.cydeo.tests.shorts;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class P32_ExplicitWaitPractice {
    
    @Test
    public void explicitWaitTest() {
        WebDriver driver = Driver.getDriver();
        
        driver.get("https://practice.cydeo.com/dynamic_loading/2");
        
        driver.findElement(By.xpath("//button[.='Start']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement loadingBar = driver.findElement(By.xpath("//div[@id='loading']"));
        
        wait.until(ExpectedConditions.invisibilityOf(loadingBar));
        
        String helloWorldText = driver.findElement(By.xpath("//h4[.='Hello World!']")).getText();

        Assert.assertEquals(helloWorldText, "Hello World!", "Text verification is FAILED!!!");
        
        Driver.closeDriver();        
    }
    
}
