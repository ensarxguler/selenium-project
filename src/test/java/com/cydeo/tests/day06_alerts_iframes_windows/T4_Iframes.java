package com.cydeo.tests.day06_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class T4_Iframes {

    WebDriver driver;
    
    @BeforeMethod
    public void setupMethod() {
        // 1- Open browser
        // 2- Go to: "https://practice.cydeo.com/iframe"
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://practice.cydeo.com/iframe");
    }

    @Test
    public void information_alert_test1() {

        // 1 - Assert: "Your content goes here." text is displayed.
        
        // We have to switch to iframe to be able to locate the web element in there.
        // #option1: switchTo "name"/"id" attribute value
        // driver.switchTo().frame("mce_0_ifr");
        
        // #option2: switchTo WebElement.
        // driver.switchTo().frame(driver.findElement(By.xpath("//iframe")));
        
        // #option3: switchTo "index" number
        driver.switchTo().frame(0);
        
        Assert.assertTrue(driver.findElement(By.xpath("//p[.='Your content goes here.']")).isDisplayed(), "Placeholder text is NOT displayed!!!");

        // 1 - Assert: "An iFrame containing the TinyMCE WYSIWYG Editor" is displayed.
        
        // If there are more than 1 layer of iFrames, we have 2 options to .switchTo():
        // #1: .parentFrame() method navigates to its direct parent.
        driver.switchTo().parentFrame();
        
        // #2: .defaultContent() method navigates to its default (outmost) parent.
        // driver.switchTo().defaultContent();
        
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed(), "Header text is NOT displayed!!!");
    }
    
    @AfterMethod
    public void tearDownMethod() {
        driver.close();
    }
    
}
