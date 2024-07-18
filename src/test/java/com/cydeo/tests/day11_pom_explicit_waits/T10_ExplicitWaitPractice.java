package com.cydeo.tests.day11_pom_explicit_waits;

import com.cydeo.pages.DynamicLoadPage;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class T10_ExplicitWaitPractice {

    //TC#10 : Dynamically Loaded Page Elements 7
    //Note: Follow POM  

    @Test
    public void test10_wait_until_title_changes() {
        //1. Go to "https://practice.cydeo.com/dynamic_loading/7"
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading/7");
        
        //2. Wait until title is “Dynamic title”
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleIs("Dynamic title"));
        
        //3. Assert: Message “Done” is displayed.
        SoftAssert softAssert = new SoftAssert();
        DynamicLoadPage loadedPage = new DynamicLoadPage();

        softAssert.assertTrue(loadedPage.doneMessage.isDisplayed());

        //4. Assert: Image is displayed.
        softAssert.assertTrue(loadedPage.spongeBobImage.isDisplayed());
        
        softAssert.assertAll();
        
        Driver.closeDriver();
    }

}
