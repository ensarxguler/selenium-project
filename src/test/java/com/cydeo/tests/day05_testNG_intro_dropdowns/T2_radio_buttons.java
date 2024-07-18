package com.cydeo.tests.day05_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class T2_radio_buttons {

    public static void main(String[] args) {

        // 1- Open a Chrome browser.
        // 2- Go to "https://practice.cydeo.com/radio_buttons".
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://practice.cydeo.com/radio_buttons");

        // 3- Click to "Hockey" radio button.
        WebElement hockeyRadioBtn = driver.findElement(By.xpath("//input[@id='hockey']"));

        hockeyRadioBtn.click();

        // 4- Verify "Hockey" radio button is selected after clicking.
        if (hockeyRadioBtn.isSelected()) {
            System.out.println("\"Hockey\" radio button is SELECTED after clicking!");
        } else {
            System.out.println("\"Hockey\" radio button is NOT selected after clicking!!!");
        }

        driver.close();

    }

}
