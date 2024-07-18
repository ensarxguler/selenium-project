package com.cydeo.tests.review.day7_8_9;

import com.cydeo.tests.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTablePractice extends TestBase {

    @Test
    public void web_table_practice() {

        // 1. Open Chrome browser.
        // 2. Go to "https://practice.cydeo.com/tables"
        driver.get("https://practice.cydeo.com/tables");

        // 3. Print table data as a single String. (not so common, but useful sometimes)
        WebElement table1 = driver.findElement(By.xpath("//table[@id='table1']"));

        String tableData = table1.getText();

        System.out.println(tableData);

        // 4. Verify "tconway@earthlink.net" is anywhere in the table.
        Assert.assertTrue(tableData.contains("tconway@earthlink.net"), "Table-1 data does NOT include the e-mail!!!");

        // 5. Print all column names in single line
        System.out.println(driver.findElement(By.xpath("//table[@id='table1']/thead/tr")).getText());

        // 6. Print each column name in separate lines using a loop and findElements method
        for (WebElement nameCells : driver.findElements(By.xpath("//table[@id='table1']//th"))) {
            System.out.println(nameCells.getText());
        }

        // 7. Verify Tim due amount is "$50.00"
        Assert.assertEquals(driver.findElement(By.xpath("//table[@id='table1']//td[.='Tim']/following-sibling::td[2]")).getText(), "$50.00");

    }

}
