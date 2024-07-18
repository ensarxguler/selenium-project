package com.cydeo.tests.day01_selenium_intro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {

    public static void main(String[] args) throws InterruptedException {
        
        // Create an instance for Chrome driver
        WebDriver driver = new ChromeDriver();
        // Session ID: fa191e085dd98aed350cff2bce056321
        // Session ID: 12bc83f4b972059ab08a0fa35c5f5802

        // This method is used to maximize the browser window
        driver.manage().window().maximize();
        // driver.manage().window().fullscreen(); - maximizing is for macOS
        
        // Go to tesla.com
        driver.get("https://www.tesla.com");
        // System.out.println("driver.getTitle() = " + driver.getTitle());
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        
        String currentTitle = driver.getTitle();
        System.out.println("currentTitle = " + currentTitle);

        // User navigate back() to go back
        driver.navigate().back();
        
        // Stop execution for 3 seconds
        Thread.sleep(3000);

        // User navigate forward() to go forward
        driver.navigate().forward();

        // Stop execution for 3 seconds
        Thread.sleep(3000);
        
        // User refreshes the page using navigate.refresh();
        driver.navigate().refresh();

        // Stop execution for 3 seconds
        Thread.sleep(3000);
        
        // navigate to google.com using navigate.to();
        driver.navigate().to("https://www.google.com");
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        
        // get title of the page
        // System.out.println("driver.getTitle() = " + driver.getTitle());
        
        currentTitle = driver.getTitle();
        System.out.println("currentTitle = " + currentTitle);
        
        // Closes the currently focused browser
        driver.close();
        
        // Closes all the opened browsers
        driver.quit();

    }    
    
}
