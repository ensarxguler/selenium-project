package com.cydeo.tests.base;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

// By making it abstract we can eliminate the option to be instantiated for the class.
public abstract class BaseTest {

    protected Actions actions = new Actions(Driver.getDriver());
    protected Select select;
    
    @BeforeMethod
    public void setupMethod() {
        Driver.getDriver().get(ConfigurationReader.getProperty("guru99.drag.drop.url"));
    }

    @AfterMethod
    public void tearDownMethod() {
        Driver.closeDriver();
    }

}
