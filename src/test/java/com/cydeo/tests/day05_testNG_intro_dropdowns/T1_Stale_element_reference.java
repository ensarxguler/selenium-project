package com.cydeo.tests.day05_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class T1_Stale_element_reference {

    public static void main(String[] args) {

        // 1- Open a Chrome browser.
        // 2- Go to "https://practice.cydeo.com/add_remove_elements/".
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice.cydeo.com/add_remove_elements/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        // 3- Click to "Add Element" button.
        driver.findElement(By.xpath("//button[.='Add Element']")).click();

        // 4- Verify "Delete" button is displayed after clicking.
        WebElement deleteButton = driver.findElement(By.xpath("//div[@id='elements']/button"));

        System.out.println("deleteButton.isDisplayed(), expecting: true = " + deleteButton.isDisplayed());

        // 5- Click to "Delete" button.
        deleteButton.click();

        // 6- Verify "Delete" button is NOT displayed after clicking.
        try {
            if (deleteButton.isDisplayed()) {
                System.out.println("\"Delete\" button is DISPLAYED!");
            }
        } catch (StaleElementReferenceException e) {
            System.out.println("\"Delete\" button is NOT displayed after clicking!!!");
        }
        
        driver.close();
        
    }

}
