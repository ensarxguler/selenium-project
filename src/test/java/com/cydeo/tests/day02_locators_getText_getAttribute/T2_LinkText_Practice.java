package com.cydeo.tests.day02_locators_getText_getAttribute;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_LinkText_Practice {

    public static void main(String[] args) throws InterruptedException {

        // 1- Open a Chrome browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2- Go to the https://practice.cydeo.com
        driver.get("https://practice.cydeo.com");

        // 3- Click to T1_Stale_element_reference/B Testing from top of the list
        driver.findElement(By.linkText("T1_Stale_element_reference/B Testing")).click();
        
        Thread.sleep(2000);

        // 4- Verify the title
        String expectedTitle1 = "No T1_Stale_element_reference/B T1_Bing_Search";
        String actualTitle1 = driver.getTitle();

        if (actualTitle1.equals(expectedTitle1)) {
            System.out.println("First title verification PASSED!");
        } else {
            System.out.println("First title verification FAILED!");
        }

        // 5- Go back to home page by using the .back();
        driver.navigate().back();

        // 6- Verify the title
        String actualTitle2 = driver.getTitle();
        String expectedTitle2 = "T1_locators_getText";

        if (actualTitle2.equals(expectedTitle2)) {
            System.out.println("Second title verification is PASSED!");
        } else {
            System.out.println("Second title verification is FAILED!");
        }
        
        driver.close();
        
    }

}
