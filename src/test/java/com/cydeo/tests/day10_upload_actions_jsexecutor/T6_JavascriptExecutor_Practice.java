package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class T6_JavascriptExecutor_Practice {
    
    //TC #6: Scroll using JavascriptExecutor

    @Test
    public void infinite_scroll_test_using_JSExecutor() {
        //1- Open a Chrome browser
        WebDriver driver = Driver.getDriver();
        
        //2- Go to: https://practice.cydeo.com/infinite_scroll
        driver.get("https://practice.cydeo.com/infinite_scroll");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        // OPTIONAL WAY TO CREATE "js" --> ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,750)");
        
        BrowserUtils.sleep(5);
        
        //3- Use below JavaScript method and scroll
        // P.S: JavaScript method to use : window.scrollBy(0,0)

        // window.scrollBy( x , y ) --> X & Y AXIS

        //a. 750 pixels down 10 times.
        for (int i = 0; i < 10; i++) {
            BrowserUtils.sleep(1);
            js.executeScript("window.scrollBy(0,750)");
        }
        
        //b. 750 pixels up 10 times
        for (int i = 0; i < 10; i++) {
            BrowserUtils.sleep(1);
            js.executeScript("window.scrollBy(0,-600)");
        }
        
//        Driver.closeDriver();
    }

}
