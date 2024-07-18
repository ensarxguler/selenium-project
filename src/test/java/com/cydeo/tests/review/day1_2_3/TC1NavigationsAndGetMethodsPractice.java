package com.cydeo.tests.review.day1_2_3;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC1NavigationsAndGetMethodsPractice {

    public static void main(String[] args) throws InterruptedException {

        // 1. Open a Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        
        // 2. Go to: https://practice.expandtesting.com/
        driver.get("https://practice.expandtesting.com/");
        
        // 3. Click on "Automation Training"
        // //tagName[@attribute='value']
        WebElement automationTrainingButton = driver.findElement(By.xpath("//a[.='Automation Training']"));
        automationTrainingButton.click();
        
        // 4. Verify url contains "formations"
        String expectedURL = "formations";
        
        if (driver.getCurrentUrl().contains(expectedURL)) {
            System.out.println("URL verification is PASSED!");
        } else {
            System.out.println("URL verification is FAILED!!!");
        }
        
        // 5. Navigate back, forward and refresh
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        
        // 6. Click on "Practice Site"
        WebElement practiceSite = driver.findElement(By.linkText("Practice Site"));
        practiceSite.click();
        
        driver.navigate().refresh();
        
        // 7. Verify header is "Automation Testing Practice Website for UI and API"
        String expectedTitleText = "Automation Testing Practice Website for UI and API";
        
        WebElement titleElement = driver.findElement(By.id("main-title"));
        String actualTitleText = titleElement.getText();

        if (actualTitleText.equals(expectedTitleText)) {
            System.out.println("Header verification is PASSED!");
        } else {
            System.out.println("Header verification is FAILED!!!");
        }
        
        // Extra -Title Practice-
        if (driver.getTitle().equals("Automation Testing Practice Website for UI and REST API")) {
            System.out.println("EXTRA: Title verification is PASSED!");
        } else {
            System.out.println("EXTRA: Title verification is FAILED!!!");
            System.out.println("driver.getTitle() = " + driver.getTitle());
        }
        
        driver.close();
        
    }
    
}
