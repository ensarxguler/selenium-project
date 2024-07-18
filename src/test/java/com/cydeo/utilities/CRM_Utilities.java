package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// This class will store the method related to CRM project.
public class CRM_Utilities {
/*     This method will log in using "below" credentials.
     @Username: "helpdesk1@cydeo.com"
     @Password: "UserUser"*/
    public static void login_crm(WebDriver driver) {
        //3. Enter valid username: "'helpdesk1@cydeo.com'"
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("helpdesk1@cydeo.com");

        //4. Enter valid password; "'UserUser'"
        driver.findElement(By.xpath("//input[@name='USER_PASSWORD']")).sendKeys("UserUser");

        //5. Click to `Log In` button.
        driver.findElement(By.xpath("//input[@value='Log In']")).click();
    }

/*   This method will log in using "given" credentials.
     @Username: "anyName@cydeo.com"
     @Password: "anyPassword"*/
    public static void login_crm(WebDriver driver, String username, String password) {
        //3. Enter valid username: "'helpdesk1@cydeo.com' | 'helpdesk2@cydeo.com'"
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys(username);

        //4. Enter valid password; "'UserUser'"
        driver.findElement(By.xpath("//input[@name='USER_PASSWORD']")).sendKeys(password);

        //5. Click to `Log In` button.
        driver.findElement(By.xpath("//input[@value='Log In']")).click();
    }
    
}
