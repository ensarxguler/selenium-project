package com.cydeo.tests.day02_locators_getText_getAttribute;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC5_getText_getAttribute {

    public static void main(String[] args) {

        // 1- Open a Chrome browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2- Go to: "https://practice.cydeo.com/registration_form"
        driver.get("https://practice.cydeo.com/registration_form");

        // 3- Verify header text is as expected:
        // Expected: Registration form
        WebElement headerElement = driver.findElement(By.tagName("h2"));

        String headerText = headerElement.getText();

        String expectedHeaderText = "Registration form";

        if (headerText.equals(expectedHeaderText)) {
            System.out.println("Header text verification is PASSED!");
        } else {
            System.out.println("Header text verification is FAILED!!!");
        }

        // 4- Locate "First name" input box
        WebElement firstNameElement = driver.findElement(By.className("form-control"));

        String placeholderOfFirstName = firstNameElement.getAttribute("placeholder");

        String expectedPlaceholderOfFirstName = "first name";

        if (placeholderOfFirstName.equals(expectedPlaceholderOfFirstName)) {
            System.out.println("Placeholder text verification is PASSED!");
        } else {
            System.out.println("Placeholder text verification is FAILED!!!");
        }

        // 5- Close the WebDriver
        driver.close();

    }

}
