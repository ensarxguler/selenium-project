package com.cydeo.tests.day02_locators_getText_getAttribute;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3_GoogleSearch {

    public static void main(String[] args) throws InterruptedException {

        // 1- Open a Chrome browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        // 2- Go to: https://www.google.com
        driver.get("https://www.google.com");
        
        // 3- Write "apple" in search box
        // 3a- Locate search box
        // 3b- Enter "apple" key, and press ENTER
        WebElement googleSearchBox = driver.findElement(By.name("q"));
        googleSearchBox.sendKeys("apple" + Keys.ENTER);
        
        // 4- Press ENTER to search
        // Thread.sleep(2000);
        // googleSearchBox.sendKeys(Keys.ENTER);

        // 5- Verify title:
        // Expected: Title should start with "apple" word
        
        boolean doesItStartWithApple = driver.getTitle().startsWith("apple");
        
        if (doesItStartWithApple) {
            System.out.println("Title verification PASSED!");
        } else {
            System.out.println("Title verification FAILED!!!");
        }

        driver.close();

    }
    
}
