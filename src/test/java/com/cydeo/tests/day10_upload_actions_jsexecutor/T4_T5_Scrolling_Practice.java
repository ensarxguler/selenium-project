package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class T4_T5_Scrolling_Practice {
    
    // There are 3 ways to achieve scrolling in Selenium:
    // PC: Actions actions = new Actions (WebDriver);
    // #1: actions.moveToElement(WebElement).perform();
    // #2: actions.ScrollToElement(WebElement).perform();
    // #3: actions.sendKeys(Keys.PAGE_UP,Keys.PAGE_UP / Keys.PAGE_DOWN, Keys.PAGE_DOWN).perform();
    
    //TC #4: Scroll practice
    //TC #5: Scroll practice 2

    @Test
    public void t4_t5_scrolling_practice() {
        //4.1 Open a Chrome browser
        WebDriver driver = Driver.getDriver();
        
        //4.2 Go to: https://practice.cydeo.com/
        driver.get("https://practice.cydeo.com/");
        
        //4.3 Scroll down to “Powered by CYDEO”
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//div[.='Powered by CYDEO']"))).perform();
        
        //P.S: Scroll using Actions class “.moveToElement(WebElement)” method
        
        //Continue from where the Task 4 is left in the same test.
        //5.1 Scroll back up to “Home” link using PageUP button
        
        actions.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP).perform();

        // actions.moveToElement(driver.findElement(By.xpath("//a[.='Home']"))).perform();
        
        Driver.closeDriver();
    }

}
