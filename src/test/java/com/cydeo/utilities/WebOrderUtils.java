package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

//TC#2: Web table practice Task1 cont.
//1. Create a new class called WebTableUtils.
//2. Create two methods to verify order.

//TC#3: Create a custom method to get the e-mail of the given person in the table.

public class WebOrderUtils {

    // This method accepts a "costumerName" and returns the costumer order date as a String. 
    public static String returnOrderDate(WebDriver driver, String costumerName) {
        return driver.findElement(By.xpath("//td[.='" + costumerName + "']/following-sibling::td[3]")).getText();
    }

    // This method should accept above arguments and internally assert "expectedOrderDate" matching "actualOrderDate".
    public static void orderVerify(WebDriver driver, String costumerName, String expectedOrderDate) {
        Assert.assertEquals(returnOrderDate(driver, costumerName), expectedOrderDate, "Order dates are NOT matching!");
    }

    public static void getTableGetEmail(WebDriver driver, int tableNum, String firstName) {
        System.out.println(driver.findElement(By.xpath("//table[@id='table" + tableNum + "']//td[.='" + firstName + "']/following-sibling::td[1]")).getText());
    }

}
