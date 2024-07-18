package com.cydeo.tests.day04_findElements_checkboxes_radio;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class TC4_StaleElementReferenceException {

    public static void main(String[] args) {

        // 1- Open a Chrome browser.
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 2- Go to "https://practice.cydeo.com/abtest".
        driver.get("https://practice.cydeo.com/abtest");

        // 3- Locate "CYDEO" link, verify it is displayed.
        WebElement cydeoLink = driver.findElement(By.xpath("//a[.='CYDEO']"));

        if (cydeoLink.isDisplayed()) {
            System.out.println("Verification #1 for CYDEO link is PASSED!");
        } else {
            System.out.println("Verification #1 for CYDEO link is FAILED!!!");
        }

        // 4- Refresh the page.
        driver.navigate().refresh();
        System.out.println("Refreshing the page...");

        // 5- Verify it is displayed, again.
        cydeoLink = driver.findElement(By.xpath("//a[.='CYDEO']"));
        if (cydeoLink.isDisplayed()) {
            System.out.println("Verification #2 for CYDEO link is PASSED!");
        } else {
            System.out.println("Verification #2 for CYDEO link is FAILED!!!");
        }
        
        driver.close();
        
    }

}
