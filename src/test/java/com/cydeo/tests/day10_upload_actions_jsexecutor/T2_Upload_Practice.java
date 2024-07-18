package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T2_Upload_Practice {
    
    //TC #2 Upload Test

    @Test
    public void uploading_test() {
        WebDriver driver = Driver.getDriver();
        
        //1. Go to https://practice.cydeo.com/upload
        driver.get("https://practice.cydeo.com/upload");
        
        //2. Find some small file from your computer, and get the path of it.
        // Windows path option #1: C:\\Users\\Ensar Guler\\OneDrive\\Desktop\\Wooden Spoon.jpg
        // Windows path option #2: C://Users//Ensar Guler/OneDrive/Desktop/Wooden Spoon.jpg
        // Path of the file: "C:\\Users\\Ensar Guler\\OneDrive\\Desktop\\Wooden Spoon.jpg".

        //3. Upload the file.
        driver.findElement(By.xpath("//input[@id='file-upload']")).sendKeys("C:\\Users\\Ensar Guler\\OneDrive\\Desktop\\Wooden Spoon.jpg");

        driver.findElement(By.xpath("//input[@id='file-submit']")).click();
        
        //4. Assert: -File uploaded text is displayed on the page
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed(), "Header text is NOT displayed!!!");
    
        Driver.closeDriver();
    }

}
