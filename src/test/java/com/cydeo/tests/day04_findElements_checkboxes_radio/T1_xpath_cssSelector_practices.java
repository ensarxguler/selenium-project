package com.cydeo.tests.day04_findElements_checkboxes_radio;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_xpath_cssSelector_practices {

    public static void main(String[] args) {

        // Methods will be displayed as "1" for XPaths, "2" for cssSelectors.
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://practice.cydeo.com/forgot_password");

        // #1 "Home" link -------------------------------------------------------------------------
        // text() method can be represented by a dot operator in .xpath();
        WebElement home1 = driver.findElement(By.xpath("//a[.='Home']"));

        // class attribute can be represented by a (.) "dot operator" in .cssSelector();
        WebElement home2 = driver.findElement(By.cssSelector("a.nav-link"));

        // 3rd way of navigating to the same element is using the "href" attribute without the link
        WebElement home3 = driver.findElement(By.cssSelector("a[href='/']"));

        if (home1.isDisplayed() && home2.isDisplayed() && home3.isDisplayed()) {
            System.out.println("Verification#1 is PASSED!");
        } else {
            System.out.println("Verification#1 is FAILED!!!");
        }

        // #2 "Forgot Password" header ------------------------------------------------------------
        // If the path or selector works for the html/web page, it works for code as well.
        WebElement forgotPassword1 = driver.findElement(By.xpath("//h2"));

        // (>) "greater than" sign can be used to navigate from parent element to child one.
        WebElement forgotPassword2 = driver.findElement(By.cssSelector("div[class='example'] > h2"));

        // An alternative to "forgotPassword2" with "dot operator"
        WebElement forgotPassword3 = driver.findElement(By.cssSelector("div.example > h2"));

        if (forgotPassword1.isDisplayed() && forgotPassword2.isDisplayed()) {
            System.out.println("Verification#2 is PASSED!");
        } else {
            System.out.println("Verification#2 is FAILED!!!");
        }
        
        // #3 "E-mail" text -----------------------------------------------------------------------
        // .xpath(); with text() method 
        WebElement eMailText1 = driver.findElement(By.xpath("//label[text()='E-mail']"));

        // Ordinary cssSelector usage
        WebElement eMailText2 = driver.findElement(By.cssSelector("label[for='email']"));

        if (eMailText1.isDisplayed() && eMailText2.isDisplayed()) {
            System.out.println("Verification#3 is PASSED!");
        } else {
            System.out.println("Verification#3 is FAILED!!!");
        }
        
        // #4 "E-mail" input box ------------------------------------------------------------------
        // .xpath(); with absolute XPath
        WebElement eMailInputBox1 = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/div/div/input"));

        // XPath with the contains() method. SYNTAX: tagName[contains( @attribute, 'value' )]
        WebElement eMailInputBox2 = driver.findElement(By.xpath("//input[contains(@pattern, '%+-]+@[a-z0-9')]"));

        // Ordinary .cssSelector(); usage
        WebElement eMailInputBox3 = driver.findElement(By.cssSelector("input[type='text']"));

        if (eMailInputBox1.isDisplayed() && eMailInputBox2.isDisplayed() && eMailInputBox3.isDisplayed()) {
            System.out.println("Verification#4 is PASSED!");
        } else {
            System.out.println("Verification#4 is FAILED!!!");
        }
        
        // #5 "Retrieve password" button ----------------------------------------------------------
        // Ordinary .xpath(); usage
        WebElement retrievePassword1 = driver.findElement(By.xpath("//button[@type='submit']"));

        // id attribute can be represented by a (#) "hashtag" in .cssSelector();
        WebElement retrievePassword2 = driver.findElement(By.cssSelector("button#form_submit"));

        if (retrievePassword1.isDisplayed() && retrievePassword2.isDisplayed()) {
            System.out.println("Verification#5 is PASSED!");
        } else {
            System.out.println("Verification#5 is FAILED!!!");
        }
        
        // #6 "Powered by Cydeo" text -------------------------------------------------------------
        // Ordinary .xpath(); usage
        WebElement poweredByCydeo1 = driver.findElement(By.xpath("//div[@style='text-align: center;']"));

        // Ordinary .cssSelector(); usage
        WebElement poweredByCydeo2 = driver.findElement(By.cssSelector("div[style='text-align: center;']"));

        if (poweredByCydeo1.isDisplayed() && poweredByCydeo2.isDisplayed()) {
            System.out.println("Verification#6 is PASSED!");
        } else {
            System.out.println("Verification#6 is FAILED!!!");
        }
        
        driver.close();
        
    }

}
