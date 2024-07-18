package com.cydeo.tests.day11_pom_explicit_waits;

import com.cydeo.pages.LibraryLoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import static org.testng.AssertJUnit.*;

public class T7_T8_T9_POM_Practices {
    private static final Logger log = LoggerFactory.getLogger(T7_T8_T9_POM_Practices.class);

    //TC #7: Required field error message test
    //NOTE: FOLLOW POM DESIGN PATTERN

    // I don't initialize it in the class level to refrain from the staled instant.
    LibraryLoginPage loginPage;
    Faker faker = new Faker();

    @BeforeMethod
    public void setup() {
        //1- Open a Chrome browser
        //2- Go to: "https://library1.cydeo.com"
        Driver.getDriver().get("https://library1.cydeo.com");

        // I want a fresh and not loaded object before each test.
        loginPage = new LibraryLoginPage();
    }

    @Test
    public void t7_field_required_error_message_test() {
        //3- Do not enter any information
        //4- Click to “Sign in” button
        loginPage.signInBtn.click();

        //5- Verify expected error is displayed:
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(loginPage.errMsg.isDisplayed());

        //Expected:" This field is required."
        String expectedErrMsg = "This field is required.";
        String actualErrMsg = loginPage.errMsg.getText();

        softAssert.assertEquals(expectedErrMsg, actualErrMsg);

        softAssert.assertAll();
    }

    //TC #8: Invalid email format error message test
    //NOTE: FOLLOW POM DESIGN PATTERN

    @Test
    public void t8_email_format_error_message_test() {
        //3- Enter invalid email format
        loginPage.eMailInput.sendKeys("ensarguler64gmail.com");
        loginPage.signInBtn.click();

        //4- Verify expected error is displayed:
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(loginPage.errMsg.isDisplayed());

        //Expected: "Please enter a valid email address."
        String expectedErrMsg = "Please enter a valid email address.";
        String actualErrMsg = loginPage.errMsg.getText();

        softAssert.assertEquals(expectedErrMsg, actualErrMsg);

        softAssert.assertAll();
    }
    
    //TC #9: Library negative login
    //NOTE: FOLLOW POM DESIGN PATTERN

    @Test
    public void t9_wrong_email_or_password_error_message() {        
        //3- Enter incorrect username or incorrect password
        loginPage.eMailInput.sendKeys(faker.letterify("?????@?????????"));
        loginPage.passwordInput.sendKeys(faker.letterify("??????????"));
        loginPage.signInBtn.click();

        BrowserUtils.sleep(1);
        //4- Verify title expected error is displayed:
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(loginPage.wrongEMailOrPassErrMsg.isDisplayed());
        
        //Expected: "Sorry, Wrong Email or Password"
        String expectedErrMsg = "Sorry, Wrong Email or Password";
        String actualErrMsg = loginPage.wrongEMailOrPassErrMsg.getText();

        softAssert.assertEquals(expectedErrMsg, actualErrMsg);
        
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }

}
