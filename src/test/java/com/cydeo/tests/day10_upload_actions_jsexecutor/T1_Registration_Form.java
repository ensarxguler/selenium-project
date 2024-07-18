package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class T1_Registration_Form {

    //TC#1: Registration form confirmation

    @Test
    public void registration_form() {
        //1. Open browser
        WebDriver driver = Driver.getDriver();
        Faker faker = new Faker();

        //2. Go to website: https://practice.cydeo.com/registration_form
        driver.get(ConfigurationReader.getProperty("registration.form.URL"));

        //3. Enter first name
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(faker.name().firstName());

        //4. Enter last name
        driver.findElement(By.xpath("//input[@data-bv-field='lastname']")).sendKeys(faker.name().lastName());

        //5. Enter username
        driver.findElement(By.xpath("//input[@placeholder='username']")).sendKeys(faker.bothify("??????????##"));

        //6. Enter email address
        driver.findElement(By.xpath("//*[@placeholder='email@email.com']")).sendKeys(faker.internet().emailAddress());

        //7. Enter password
        driver.findElement(By.xpath("//*[@type='password']")).sendKeys(faker.internet().password());

        //8. Enter phone number
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(faker.numerify("###-###-####"));

        //9. Select a gender from radio buttons
        driver.findElement(By.xpath("//div[@class='radio']/label/input[@value='male']")).click();

        //10.Enter date of birth
        driver.findElement(By.xpath("//input[@name='birthday']")).sendKeys(faker.numerify("09/27/19##"));

        //11.Select Department/Office
        Select select1 = new Select(driver.findElement(By.xpath("//select[@name='department']")));
        select1.selectByVisibleText("Department of Engineering");

        //12.Select Job Title
        Select select2 = new Select(driver.findElement(By.xpath("//select[@name='job_title']")));
        select2.selectByVisibleText("SDET");

        //13.Select programming language from checkboxes
        driver.findElement(By.xpath("//input[@id='inlineCheckbox2']")).click();

        //14.Click to sign up button
        driver.findElement(By.xpath("//button")).click();

        //15.Verify success message “You've successfully completed registration!” is displayed.
        Assert.assertTrue(driver.findElement(By.xpath("//p[.=\"You've successfully completed registration!\"]")).isDisplayed(), "Registration message cannot be found!!!");

        Driver.closeDriver();
    }

}
