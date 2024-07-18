package com.cydeo.tests.day02_locators_getText_getAttribute;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HWP4_Class_Locator_Practice {
    
    public static void main(String[] args) {
        
        // 1- Open a Chrome browser.
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        
        // 2- Go to: https://practice.cydeo.com/inputs.
        driver.get("https://practice.cydeo.com/inputs");
        
        // 3- Click to "Home" link.
        driver.findElement(By.className("nav-link")).click();
        
        // 4- Verify title is as expected: Expected: "Practice".
        if (driver.getTitle().equals("Practice")) {
            System.out.println("Title verification is PASSED!");
        } else {
            System.out.println("Title verification is FAILED!!!");
            System.out.println("driver.getTitle() = " + driver.getTitle());
        }
        
        driver.close();
        
    }
    
}
