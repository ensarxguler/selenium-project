package com.cydeo.tests.base;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public abstract class TestBase {
    
    // "protected" access modifier must be used to restrict the access to the field.
    protected WebDriver driver;
    
    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    
    @AfterMethod
    public void tearDownMethod() {
        driver.quit();
    }
    
}
