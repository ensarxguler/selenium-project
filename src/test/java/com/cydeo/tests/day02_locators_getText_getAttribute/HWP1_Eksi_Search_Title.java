package com.cydeo.tests.day02_locators_getText_getAttribute;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HWP1_Eksi_Search_Title {

    public static void main(String[] args) {

        // 1- Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        
        // 2- Go to "https://eksisozluk.com/"
        driver.get("https://eksisozluk.com/");
        
        // 3- Search for "wooden spoon"
        driver.findElement(By.className("ui-autocomplete-input")).sendKeys("wooden spoon" + Keys.ENTER);
        
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
