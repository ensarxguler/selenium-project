package com.cydeo.tests.review.day10_11_12;

import com.cydeo.tests.base.BaseTest;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Guru99DragAndDropTest extends BaseTest {
    
    // TC: Drag and Drop Test

    @Test
    public void test1() {
        // 1- Open a Chrome browser
        // 2- Go to: https://demo.guru99.com/test/drag_drop.html
        Driver.getDriver();

        // 3- Drag “BANK” and drop into Account area under Debit Side
        actions.dragAndDrop(Driver.getDriver().findElement(By.linkText("BANK")), Driver.getDriver().findElement(By.xpath("//ol[@id='bank']//li[@class='placeholder']"))).perform();

        // 4- Drag “5000” and drop into Amount area under Debit Side
        actions.clickAndHold(Driver.getDriver().findElement(By.xpath("//a[.=' 5000 ']"))).moveToElement(Driver.getDriver().findElement(By.xpath("//ol[@id='amt7']/li"))).release().perform();

    }

}
