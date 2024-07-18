package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T4_xpath {

    public static void main(String[] args) {

        // 1- Open a Chrome browser.
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        // 2- Go to "https://login1.nextbasecrm.com/".
        driver.get("https://login1.nextbasecrm.com/");

        // 3- Verify "Log in" button text is as expected:
        // Expected: "Log In"

        // tagName[@attribute='value']
        // Locating loginButton using xpath using type attribute's value
        // WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));

        // tagName[@attribute='value']
        // Locating loginButton using xpath using value attribute's value
        // WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        
        WebElement loginButton = driver.findElement(By.xpath("//input[@class='login-btn']"));
        
        String actualLoginButtonText = loginButton.getAttribute("value");
        String expectedLoginButtonText = "Log In";

        if (actualLoginButtonText.equals(expectedLoginButtonText)) {
            System.out.println("Log in button text verification is PASSED!");
            System.out.println("actualLoginButtonText = " + actualLoginButtonText);
            System.out.println("expectedLoginButtonText = " + expectedLoginButtonText);
        } else {
            System.out.println("Log in button text verification is FAILED!!!");
        }

        driver.close();

    }
    
}
