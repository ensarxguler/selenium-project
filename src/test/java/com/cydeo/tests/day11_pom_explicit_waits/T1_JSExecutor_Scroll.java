package com.cydeo.tests.day11_pom_explicit_waits;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class T1_JSExecutor_Scroll {

    //TC #7: Scroll using JavascriptExecutor

    @Test
    public void scroll_using_js_executor() {
        
        //1- Open a Chrome browser
        WebDriver driver = Driver.getDriver();
        
        //2- Go to: https://practice.cydeo.com/large
        driver.get("https://practice.cydeo.com/large");
        
        //3- Scroll down to “Cydeo” link
        JavascriptExecutor js = ((JavascriptExecutor) driver);

        WebElement cydeoLink = driver.findElement(By.linkText("CYDEO"));
        WebElement homeLink = driver.findElement(By.linkText("Home"));
        
        //WebElement middleOfTheTable = driver.findElement(By.xpath("//h4[.='Table']"));
        
        js.executeScript("arguments[0].scrollIntoView(true)", cydeoLink, homeLink);

        // Actions actions = new Actions(driver);
        // actions.moveToElement(middleOfTheTable);
        
        BrowserUtils.sleep(2);
        //js.executeScript("arguments[0].scrollIntoView(true)", middleOfTheTable);

        //4- Scroll up to “Home” link
        BrowserUtils.sleep(2);
        js.executeScript("arguments[1].scrollIntoView(true)", cydeoLink, homeLink);
        
        //5- Use below provided JS method only
        //JavaScript method to use : arguments[0].scrollIntoView(true)
        //Note: You need to locate the links as web elements and pass them as arguments into executeScript() method.
        
        Driver.closeDriver();
    }

}
