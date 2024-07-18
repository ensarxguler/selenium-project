package com.cydeo.tests.day02_locators_getText_getAttribute;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HWP2_Zerobank_Header {

    public static void main(String[] args) {

        // 1- Open a Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();

        // 2- Go to "http://zero.webappsecurity.com/login.html"
        driver.get("http://zero.webappsecurity.com/login.html");

        // 3- Verify header text: Expected "Log in to ZeroBank"
        if (driver.findElement(By.tagName("h3")).getText().equals("Log in to ZeroBank")) {
            System.out.println("Header verification is PASSED!");
        } else {
            System.out.println("Header verification is FAILED!!!");
            System.out.println("headerText = " + driver.findElement(By.cssSelector("h3")).getText());
        }
        
        driver.close();
        
    }
    
}
