package com.cydeo.tests.day05_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T5_dropdowns_intro {

    WebDriver driver;

    @BeforeMethod
    public void startupMethod() {
        // 1- Open a Chrome browser.
        // 2- Go to "https://practice.cydeo.com/dropdown".
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://practice.cydeo.com/dropdown");
    }

    @Test (priority = 1)
    public void simple_Dropdown_test() {
        // 3- Verify "Simple dropdown" default selected value is correct. Expected: "Please select1 an option".
        
        // Locating the dropdown as a web element.
        WebElement simpleDropdown = driver.findElement(By.xpath("//select[@id='dropdown']"));

        // Creating an instance of Select class and passing the dropdown as an argument.
        Select select = new Select(simpleDropdown);
        
        String expectedDefaultValue1 = "Please select an option";
        String actualDefaultValue1 = select.getFirstSelectedOption().getText();
        
        Assert.assertEquals(expectedDefaultValue1, actualDefaultValue1);
        Assert.assertTrue(expectedDefaultValue1.equals(actualDefaultValue1));
        
    }
    
    @Test (priority = 2, dependsOnMethods = "simple_Dropdown_test")
    public void state_dropdown_test() {
        // 4- Verify "State selection" default selected value is correct. Expected: "Select a State".

        // Locating the dropdown as a web element and passing to the constructor of the instance of Select class.
        Select select2 = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        String expectedDefaultValue2 = "Select a State";
        String actualDefaultValue2 = select2.getFirstSelectedOption().getText();

        Assert.assertEquals(expectedDefaultValue2, actualDefaultValue2);
        Assert.assertTrue(expectedDefaultValue2.equals(actualDefaultValue2));

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
