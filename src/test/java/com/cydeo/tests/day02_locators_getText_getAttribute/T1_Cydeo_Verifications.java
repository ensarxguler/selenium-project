package com.cydeo.tests.day02_locators_getText_getAttribute;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_Cydeo_Verifications {

    public static void main(String[] args) {

        // Create a driver without the set-up (WebDriverManager).
        WebDriver driver = new ChromeDriver();
        
        // Maximize the window of the browser.
        driver.manage().window().maximize();
        
        // Pass the URL to .get() for navigating the website.
        driver.get("https://practice.cydeo.com/");

        // Create String objects to make the code more understandable.
        String expectedURL = "cydeo";
        String currentURL = driver.getCurrentUrl();
        
        // Crete a if condition to verify the URL.
        if (currentURL.contains(expectedURL)) {
            System.out.println("Url verification is PASSED!!!");
        } else {
            System.out.println("Url verification is FAILED!!!");
        }

        // Create String objects to make the code more understandable.
        String expectedTitle = "T1_locators_getText";
        String actualTitle = driver.getTitle();

        // Crete an if condition to verify the Title.
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title verification is PASSED!!!");
        } else {
            System.out.println("Title verification is FAILED!!!");
        }
        
        // Close the driver.
        driver.close();

    }
    
}
