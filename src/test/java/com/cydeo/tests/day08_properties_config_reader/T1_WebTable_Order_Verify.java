package com.cydeo.tests.day08_properties_config_reader;

import com.cydeo.utilities.WebDriverFactory;
import com.cydeo.utilities.WebOrderUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T1_WebTable_Order_Verify {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //TC #1: Web table practice
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void order_verify_name_test() {
        //1. Go to: "https://practice.cydeo.com/web-tables".
        driver.get("https://practice.cydeo.com/web-tables");
        
        //2. Verify Bob’s name is listed as expected. Expected: “Bob Martin”.
        Assert.assertEquals(driver.findElement(By.xpath("//table[@class='SampleTable']//td[.='Bob Martin']")).getText(), "Bob Martin", "Names are NOT matching!");

        //3. Verify Bob Martin’s order date is as expected. Expected: "12/31/2021".
        // Optional Xpath: " //td[.='Bob Martin']/following-sibling::td[3] "
        Assert.assertEquals(driver.findElement(By.xpath("//td[.='Bob Martin']/../td[5]")).getText(), "12/31/2021", "Order dates are NOT matching!");
    }

    @Test
    public void test2_use_order_verify_method() {
        //1. Go to: "https://practice.cydeo.com/web-tables".
        driver.get("https://practice.cydeo.com/web-tables");

        // Call the utility method we created.
        System.out.println(WebOrderUtils.returnOrderDate(driver,"Alexandra Gray"));
        System.out.println(WebOrderUtils.returnOrderDate(driver,"Bart Fisher"));

        // Call the other utility method we created.
        WebOrderUtils.orderVerify(driver, "Bob Martin", "12/31/2021");
    }

    @Test
    public void test3_get_email() {
        //1. Go to: "https://practice.cydeo.com/tables".
        driver.get("https://practice.cydeo.com/tables");

        // Call the third utility method we created.
        WebOrderUtils.getTableGetEmail(driver,1, "Tim");
    }

    @AfterMethod
    public void tearDownMethod() {
        driver.close();
    }

}
