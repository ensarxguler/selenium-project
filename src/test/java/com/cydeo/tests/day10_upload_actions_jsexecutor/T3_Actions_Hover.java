package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class T3_Actions_Hover {

    // TC #3: Hover Test

    @Test
    public void hovering_test() {
        WebDriver driver = Driver.getDriver();

        //1. Go to https://practice.cydeo.com/hovers
        driver.get("https://practice.cydeo.com/hovers");

        //2. Hover over to first image
        Actions actions = new Actions(driver);

        //3. Assert: “name: user1” is displayed
        //4. Hover over to second image
        //5. Assert: “name: user2” is displayed
        //6. Hover over to third image
        //7. Assert: “name: user3” is displayed
        SoftAssert softAssert = new SoftAssert();
        
        List<WebElement> images = driver.findElements(By.xpath("//div[@class='figure']/img"));
        List<WebElement> headers = driver.findElements(By.xpath("//div[@class='figcaption']/h5"));

        for (int i = 0; i < images.size(); i++) {
            actions.moveToElement(images.get(i)).perform();
            softAssert.assertTrue(headers.get(i).isDisplayed(), "Header verification is FAILED!!!");
        }
        
        Driver.closeDriver();
    }

}
