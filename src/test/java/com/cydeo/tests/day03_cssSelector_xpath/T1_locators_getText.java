package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_locators_getText {

    public static void main(String[] args) {

        // 1- Open a Chrome browser and maximize the window
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        // 2- Go to "https://login1.nextbasecrm.com/"
        driver.get("https://login1.nextbasecrm.com/");

        // 3- Enter incorrect username "incorrect".
        WebElement userLogin = driver.findElement(By.className("login-inp"));
        userLogin.sendKeys("incorrect");

        // 4- Enter incorrect password "incorrect".
        WebElement password = driver.findElement(By.name("USER_PASSWORD"));
        password.sendKeys("incorrect");

        // 5- Click to log in button
        WebElement loginButton = driver.findElement(By.className("login-btn"));
        loginButton.click();

        // 6- Verify the error message text is as expected:
        // Expected: Incorrect login or password
        WebElement errorMessage = driver.findElement(By.className("errortext"));

        String actualErrorMessage = errorMessage.getText();
        String expectedErrorMessage = "Incorrect login or password";

        if (actualErrorMessage.equals(expectedErrorMessage)) {
            System.out.println("Error message verification is PASSED!");
        } else {
            System.out.println("Error message verification is FAILED!!!");
        }

        driver.close();

    }

}
