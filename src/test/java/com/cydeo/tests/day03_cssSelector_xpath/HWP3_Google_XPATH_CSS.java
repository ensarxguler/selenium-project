package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HWP3_Google_XPATH_CSS {

    public static void main(String[] args) {

        // 1- Open a Chrome browser.
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        
        //2- Go to: "https://google.com".
        driver.get("https://google.com");
        
        // 3a (cssSelector) - Click to Gmail from top right.
        driver.findElement(By.cssSelector("a[aria-label='Gmail ']")).click();
        // 3b (relative xpath) - Click to Gmail from top right.
        // driver.findElement(By.xpath("//a[@aria-label='Gmail ']")).click();
        
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
