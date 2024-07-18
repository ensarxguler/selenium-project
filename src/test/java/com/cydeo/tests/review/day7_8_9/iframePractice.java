package com.cydeo.tests.review.day7_8_9;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.CRM_Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.text.BreakIterator;

public class iframePractice extends TestBase {
    
    // TC#2 : Iframe practice
    @Test
    public void iframe_practice() {
        // 1. Users are already login and on the homepage of CRM app.
        driver.get("https://login1.nextbasecrm.com/");
        CRM_Utilities.login_crm(driver);
        
        // 2. Users click the "MESSAGE" tab.
        driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-message']/span")).click();
        
        // 3. Users write test message.
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']")));
        
        driver.findElement(By.xpath("//body[@contenteditable='true']")).sendKeys("Hello World!");
        
        // 4. Users click the "SEND" button.
        driver.switchTo().parentFrame();
        
        driver.findElement(By.xpath("//button[@id='blog-submit-button-save']")).click();
        
        // 5. Verify the message is displayed on the feed.
        BrowserUtils.sleep(3);
        WebElement message = driver.findElement(By.xpath("(//div[starts-with(@id,'blog_post_body_')])[1]"));
        Assert.assertEquals(message.getText(), "Hello World!", "Text verification is FAILED!!!");
        
    }

}
