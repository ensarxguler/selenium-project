package com.cydeo.tests.review.day7_8_9;

import com.cydeo.tests.base.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class WindowsHandlePractice extends TestBase {

    // There is a DB issue in the practice page.
    @Test
    public void windows_handling_practice() {

        //    1. Open a browser.
        //    2. Go to website: "https://demoqa.com/browser-windows".
        driver.get("https://demoqa.com/browser-windows");
        
        //    3. Click on New Tab button.
        driver.findElement(By.xpath("//button[@id='tabButton']")).click();

        //    4. Click on New Window button.
        driver.findElement(By.xpath("//button[@id='windowButton']")).click();

        //    5. Click on New Window Message button.
        driver.findElement(By.xpath("//button[@id='messageWindowButton']")).click();
        
        //    6. Print out each window title.
        for (String eachHandle : driver.getWindowHandles()) {
            System.out.println(driver.getTitle());
            driver.switchTo().window(eachHandle);
        }
        
    }

}
