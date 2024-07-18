package com.cydeo.tests.day02_locators_getText_getAttribute;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC4_Library_Practice {

    public static void main(String[] args) throws InterruptedException {

        // 1- Open a Chrome browser.
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2- Go to "https://library2.cybertekschool.com/login.html".
        driver.get("https://library2.cybertekschool.com/login.html");

        // 3- Enter username: "incorrect@email.com".
        driver.findElement(By.className("form-control")).sendKeys("incorrect@email.com");

        // 4- Enter password "incorrect password".
        driver.findElement(By.id("inputPassword")).sendKeys("incorrect password");

        // 5- Verify visually "Sorry, Wrong Email or Password" displayed.
        Thread.sleep(2000);

        driver.findElement(By.tagName("button")).click();

        Thread.sleep(2000);
        
        driver.close();
        
    }
    
}
