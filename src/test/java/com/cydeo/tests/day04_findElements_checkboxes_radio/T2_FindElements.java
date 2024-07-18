package com.cydeo.tests.day04_findElements_checkboxes_radio;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class T2_FindElements {

    public static void main(String[] args) {

        // 1- Open a Chrome browser.
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        
        // Smart wait for the session:
        // It's smart because it stops the execution only when the driver couldn't find the specified element.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        // 2- Go to: "https://practice.cydeo.com/".
        driver.get("https://practice.cydeo.com/abtest");
        
        // 3- Locate all the links in the page.
        List<WebElement> ListOfLinks = driver.findElements(By.tagName("a"));

        // 4- Print out the number of the links on the page.
        System.out.println("Number of the links" + ListOfLinks.size());
        
        // 5- Print out the texts of the links.
        // 6- Print out the HREF attribute values of the links.
        for (WebElement webElement : ListOfLinks) {
            System.out.println("Text of the links: " + webElement.getText());
            System.out.println("URLs of the links: " + webElement.getAttribute("href"));
        }
        
        driver.close();
        
    }
    
}
