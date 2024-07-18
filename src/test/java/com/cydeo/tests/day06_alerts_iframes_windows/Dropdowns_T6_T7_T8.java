package com.cydeo.tests.day06_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Dropdowns_T6_T7_T8 {

    WebDriver driver;

    @BeforeClass
    public void setupMethod() {
        // 1- Set-up and navigating to specified URL.
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://practice.cydeo.com/dropdown");
    }

    @Test (priority = 1)
    public void dropdowns_task6() {

        // 2- Select objects for different dropdown are created.
        Select yearDropdown = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        Select monthDropdown = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        Select dayDropdown = new Select(driver.findElement(By.xpath("//select[@id='day']")));

        // 3- Instances selected the options according to: VisibleText / Value / Index
        yearDropdown.selectByVisibleText("1933");
        monthDropdown.selectByValue("11");
        dayDropdown.selectByIndex(0);

        // Verifications using "ASSERTS"
        Assert.assertEquals(yearDropdown.getFirstSelectedOption().getText(), "1933");
        Assert.assertEquals(monthDropdown.getFirstSelectedOption().getText(), "December");
        Assert.assertEquals(dayDropdown.getFirstSelectedOption().getText(), "1");

    }

    @Test (priority = 2, dependsOnMethods = "dropdowns_task6")
    public void dropdowns_task7() {

        // 2- Select objects for different dropdown are created.
        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        // 3- Instances selected the options according to: VisibleText / Value / Index
        stateDropdown.selectByVisibleText("Illinois");
        stateDropdown.selectByValue("VA");
        int indexOfCA = 0;
        for (WebElement eachState : driver.findElements(By.xpath("//select[@id='state']/option"))) {
            if (eachState.getText().equals("California")){
                break;
            }
            indexOfCA++;
        }
        stateDropdown.selectByIndex(indexOfCA);
        System.out.println("indexOfCA = " + indexOfCA);
        
        // Verifications using "ASSERT"
        Assert.assertEquals(stateDropdown.getFirstSelectedOption().getText(), "California", "STATE DROPDOWN VALUE IS NOT AS EXPECTED!");

    }

    @Test (priority = 3, dependsOnMethods = "dropdowns_task7")
    public void dropdowns_task8() {

        // 2- Click to non-select dropdown
        driver.findElement(By.xpath("//a[normalize-space()='Dropdown link']")).click();
        
        // 3- Click "Facebook" from dropdown
        driver.findElement(By.xpath("//a[.='Facebook']")).click();
        
        // 4- Verify title is "Facebook – log in or sign up"
        Assert.assertEquals(driver.getTitle(), "Facebook – log in or sign up", "Title verification is FAILED!!!");

    }

    @AfterClass
    public void tearDownMethod() {
        driver.close();
    }

}
