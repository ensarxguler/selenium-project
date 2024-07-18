package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HWP1_Etsy_Xpath_CSS {

    public static void main(String[] args) {
        
        // 1- Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();

        // 2- Go to "https://eksisozluk.com/"
        driver.get("https://eksisozluk.com/");

        // 3a (cssSelector) - Search for "wooden spoon"
        driver.findElement(By.cssSelector("input[type='text']")).sendKeys("wooden spoon");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        // 3b (relative xpath) - Search for "wooden spoon"
        // driver.findElement(By.xpath("//input[@type='text']")).sendKeys("wooden spoon");
        // driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Verify title: "wooden spoon - ekşi sözlük"
        if (driver.getTitle().equals("wooden spoon - ekşi sözlük")) {
            System.out.println("Title verification is PASSED!");
        } else {
            System.out.println("Title verification is FAILED!!!");
            System.out.println("driver.getTitle() = " + driver.getTitle());
        }

        driver.close();
        
    }
    
}
