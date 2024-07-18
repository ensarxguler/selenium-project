package com.cydeo.tests.day02_locators_getText_getAttribute;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HWP3_Gmail_Title_Verification {

    public static void main(String[] args) {
        
        // 1- Open a Chrome browser.
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        
        //2- Go to: "https://google.com".
        driver.get("https://google.com");
        
        // 3- Click to Gmail from top right.
        driver.findElement(By.linkText("Gmail")).click();
        
        // 4- Verify title contains: Expected: "Gmail"
        if (driver.getTitle().contains("Gmail")) {
            System.out.println("Title#1 verification is PASSED!");
        } else {
            System.out.println("Title#1 verification is FAILED!!!");
            System.out.println("driver.getTitle()#1 = " + driver.getTitle());
        }
        
        // 5- Go back to "Google"
        driver.navigate().back();
        
        // 6- Verify title equals: Expected: "Google"
        if (driver.getTitle().equals("Google")) {
            System.out.println("Title#2 verification is PASSED!");
        } else {
            System.out.println("Title#2 verification is FAILED!!!");
            System.out.println("driver.getTitle()#2 = " + driver.getTitle());
        }
        
        driver.close();
        
    }
    
}
