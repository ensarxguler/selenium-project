package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HWP2_Zerobank_XPATH_CSS {

    public static void main(String[] args) {

        // 1- Open a Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        
        // 2- Go to "//http://zero.webappsecurity.com/login.html"
        driver.get("http://zero.webappsecurity.com/login.html");
        
        // 3a (cssSelector) - Verify header text: Expected "Log in to ZeroBank"
        if (driver.findElement(By.cssSelector("h3")).getText().equals("Log in to ZeroBank")) {
            System.out.println("Header verification is PASSED!");
        } else {
            System.out.println("Header verification is FAILED!!!");
            System.out.println("headerText = " + driver.findElement(By.cssSelector("h3")).getText());
        }
        // 3b (relative xpath) - Verify header text: Expected "Log in to ZeroBank"
        //        if (driver.findElement(By.xpath("//h3")).getText().equals("Log in to ZeroBank")) {
        //            System.out.println("Header verification is PASSED!");
        //        } else {
        //            System.out.println("Header verification is FAILED!!!");
        //        }
        
        driver.close();
        
    }
    
}
