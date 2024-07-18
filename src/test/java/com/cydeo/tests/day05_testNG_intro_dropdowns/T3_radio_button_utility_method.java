package com.cydeo.tests.day05_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T3_radio_button_utility_method {

    public static void main(String[] args) throws InterruptedException {

        // 1- Open a Chrome browser.
        // 2- Go to "https://practice.cydeo.com/radio_buttons".
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://practice.cydeo.com/radio_buttons");

        clickAndVerifyRadioButton(driver, "sport", "hockey");
        clickAndVerifyRadioButton(driver, "sport", "football");
        
        clickAndVerifyRadioButton(driver, "color", "red");
        
        driver.close();

    }

    private static void clickAndVerifyRadioButton(WebDriver driver, String nameAttributes, String idAttributes) {
        
        // Locate all the "sport" radio buttons, and store them in a List<WebElement>.
        //  *** *** *** STRING CONCATENATION *** *** *** SYNTAX: "//tagName[@attribute='"+valueVariable+"']"
        
        // 1st option: List<WebElement> sportRadioButtons = driver.findElements(By.name(nameAttributes));
        List<WebElement> sportRadioButtons = driver.findElements(By.xpath("//input[@name='"+nameAttributes+"']"));

        for (WebElement each : sportRadioButtons) {
            String actualID = each.getAttribute("id");
            System.out.println(actualID);
            if (actualID.equals(idAttributes)) {
                each.click();
                System.out.println(actualID + " is selected: " + each.isSelected());
                break;
            }
        }
        
    }

}
