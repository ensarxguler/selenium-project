package com.cydeo.tests.day04_findElements_checkboxes_radio;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class T3_checkboxes_radioButtons {

    public static void main(String[] args) {

        // TC#3: Checkboxes
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1- Go to "https://practice.cydeo.com/checkboxes".
        driver.get("https://practice.cydeo.com/checkboxes");
        
        // 2- Confirm checkbox #1 is NOT selected by default.
        WebElement checkbox1 = driver.findElement(By.cssSelector("input#box1"));

        if (checkbox1.isSelected()) {
            System.out.println("Checkbox #1 is selected by default.");
        } else {
            System.out.println("Checkbox #1 is \"NOT\" selected by default.");
        }

        // 3- Confirm checkbox #2 is SELECTED by default.
        WebElement checkbox2 = driver.findElement(By.cssSelector("input#box2"));

        if (checkbox2.isSelected()) {
            System.out.println("Checkbox #2 is \"SELECTED\" by default.");
        } else {
            System.out.println("Checkbox #2 is \"NOT\" selected by default.");
        }
        
        // 4- Click checkbox #1 to "select" it.
        checkbox1.click();

        // 5- Click checkbox #2 to "de-select" it.
        checkbox2.click();
        
        // 6- Confirm checkbox #1 is SELECTED.
        if (checkbox1.isSelected()) {
            System.out.println("Checkbox #1 is selected");
        } else {
            System.out.println("Checkbox #1 is \"NOT\" selected");
        }
        
        // 7- Confirm checkbox #2 is NOT selected.
        if (checkbox2.isSelected()) {
            System.out.println("Checkbox #2 is selected");
        } else {
            System.out.println("Checkbox #2 is \"NOT\" selected");
        }
        
        driver.close();
        
    }
    
}
