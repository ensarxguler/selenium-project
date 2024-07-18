package com.cydeo.tests.review.day4_5_6;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegistrationFormPage {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        // 1. Open Chrome browser.
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(priority = 1)
    public void registration_form_page_title() {
        // 2. Go to: "https://practice.cydeo.com/registration_form".
        driver.get("https://practice.cydeo.com/registration_form");

        // 3. Verify title is as expected: Expected: "Registration Form".
        Assert.assertEquals(driver.getTitle(), "Registration Form", "Title verification is FAILED!!!");
    }

    @Test(priority = 2, dependsOnMethods = "registration_form_page_title")
    public void registration_form_filling_out_test() {
        // 2. Go to: "https://practice.cydeo.com/registration_form".
        driver.get("https://practice.cydeo.com/registration_form");
        
        // 3. Enter First name: "John".
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("John");

        // 4. Enter Last name: "Smith".
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Smith");

        // 5. Enter Username: "johnsmith123".
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("johnsmith123");

        // 6. Enter Email address: "john.smith@email.com".
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("john.smith@email.com");

        // 7. Enter password: "John1234".
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("John1234");

        // 8. Enter Phone number: "123-456-7890".
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("123-456-7890");

        // 9. Click to "Male" from Gender.
        driver.findElement(By.xpath("//input[@value='male']")).click();

        // 10. Enter Date of birth "01/28/1990"
        driver.findElement(By.xpath("//input[@name='birthday']")).sendKeys("01/28/1990");

        // 11. Select "Department of Engineering" from Department/Office dropdown.
        Select departmentDropdown = new Select(driver.findElement(By.xpath("//select[@name='department']")));
        departmentDropdown.selectByVisibleText("Department of Engineering");

        // 12. Select "SDET" from Job title dropdown.
        Select jobTitleDropdown = new Select(driver.findElement(By.xpath("//select[@name='job_title']")));
        jobTitleDropdown.selectByVisibleText("SDET");

        // 13. Click to "Java" from languages.
        driver.findElement(By.xpath("//input[@id='inlineCheckbox2']")).click();

        // 14. Click to "Sign up" button.
        driver.findElement(By.xpath("//button[@id='wooden_spoon']")).click();

        // 15. Verify text displayed on page. Expected: "Well done!".
        Assert.assertEquals(driver.findElement(By.xpath("//h4")).getText(), "Well done!", "Text verification is FAILED!!!");
    }

    @Test (priority = 3)
    public void alert_practice() {
        // 2. Go to website: "https://practice.cydeo.com/javascript_alerts".
        driver.get("https://practice.cydeo.com/javascript_alerts");
        
        // 3. Click to “Click for JS Prompt” button.
        driver.findElement(By.xpath("//button[.='Click for JS Prompt']")).click();
        
        // 4. Send “hello” text to alert.
        driver.switchTo().alert().sendKeys("hello");
        
        // 5. Click to OK button from the alert.
        driver.switchTo().alert().accept();
        
        // 6. Verify “You entered: hello” text is displayed.
        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='result']")).getText(), "You entered: hello", "Text verification is FAILED!!");
    }

    @AfterMethod
    public void tearDownMethod() {
        driver.close();
    }

}
