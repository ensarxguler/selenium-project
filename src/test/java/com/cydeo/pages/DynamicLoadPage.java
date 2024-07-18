package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicLoadPage {

    // #1- Initialize the driver and object.
    public DynamicLoadPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    
    @FindBy (css = "div#alert")
    public WebElement doneMessage;

    @FindBy (xpath = "//img[@alt='square pants']")
    public WebElement spongeBobImage;
    
}
