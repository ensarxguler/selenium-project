package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LibraryLoginPage {
    
    // #1- Initialize the object of the class and the driver instance inside the "constructor".
    public LibraryLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    
    // Use @FindBy annotation instead of findElement method
    // WebElement signInBtn = Driver.getDriver().findElement(By.xpath("//button[.='Sign in']"));
    @FindBy(xpath = "//button[.='Sign in']")
    public WebElement signInBtn;

    @FindBy(css = "div#inputEmail-error")
    public WebElement errMsg;

    @FindBy(css = "input#inputEmail")
    public WebElement eMailInput;

    @FindBy(css = "input#inputPassword")
    public WebElement passwordInput;

    @FindBy(xpath = "//div[@class='mb-4']/div")
    public WebElement wrongEMailOrPassErrMsg;

}
