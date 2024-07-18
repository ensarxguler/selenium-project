package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3_cssSelector {

    public static void main(String[] args) {

        // 1- Open a Chrome browser.
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        // 2- Go to "https://login1.nextbasecrm.com/".
        driver.get("https://login1.nextbasecrm.com/");

        // 3- Verify "Log in" button text is as expected:
        // Expected: "Log In"

        // WebElement loginButton = driver.findElement(By.className("login-btn"));
        // WebElement loginButton = driver.findElement(By.cssSelector("input[type='submit']"));
        // WebElement loginButton = driver.findElement(By.cssSelector("input[value='Log In']"));
        // WebElement loginButton = driver.findElement(By.cssSelector("input[class='login-btn']"));
        
        // This is a shorthand to reach web element by using "dot operator" used for CLASS attribute
        WebElement loginButton = driver.findElement(By.cssSelector("input.login-btn"));

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
