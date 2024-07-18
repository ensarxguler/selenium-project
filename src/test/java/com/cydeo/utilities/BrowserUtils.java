package com.cydeo.utilities;

// This class will be storing only the utility methods that can be used across the project,

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Set;

public class BrowserUtils {

    // This method will accept iny (in seconds) and execute Thread.sleep method for given duration.
    // Catch block is kept empty because we want to ignore the "InterruptedException".
    public static void sleep(int second) {
        second *= 1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {

        }
    }

    public static void switchWindowAndVerify(WebDriver driver, String expectedInUrl, String expectedInTitle) {
        Set<String> allWindowHandles = driver.getWindowHandles();

        for (String eachHandle : allWindowHandles) {
            driver.switchTo().window(eachHandle);

            if (driver.getCurrentUrl().contains(expectedInUrl)) {
                break;
            }
        }

        Assert.assertTrue(driver.getTitle().contains(expectedInTitle), "The page does NOT contain the expected title!!!");
    }

    public static void verifyTitle(WebDriver driver, String expectedTitle) {
        Assert.assertEquals(driver.getTitle(), expectedTitle, "Title of the page does NOT same with the expected title!!!");
    }

    public static void verifyTitleContains(WebDriver driver, String expectedInTitle) {
        Assert.assertTrue(driver.getTitle().contains(expectedInTitle), "Title of the page does NOT same with the expected title!!!");
    }

}
