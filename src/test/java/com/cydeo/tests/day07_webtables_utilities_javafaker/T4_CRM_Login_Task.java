package com.cydeo.tests.day07_webtables_utilities_javafaker;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.CRM_Utilities;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T4_CRM_Login_Task {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //TC #4: Login scenario.
        //1. Create new order_verify_name_test and make set-ups.
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        // 2. Go to: "http://login1.nextbasecrm.com/".
        driver.get("https://login1.nextbasecrm.com/");
    }

    @Test
    public void test1_crm_login() {
        //3. Enter valid username: "'helpdesk1@cydeo.com' | 'helpdesk2@cydeo.com'"
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("helpdesk1@cydeo.com");

        //4. Enter valid password; "'UserUser'"
        driver.findElement(By.xpath("//input[@name='USER_PASSWORD']")).sendKeys("UserUser");

        //5. Click to `Log In` button.
        driver.findElement(By.xpath("//input[@value='Log In']")).click();

        //6. Verify title is as expected: "Expected: 'Portal'".
        BrowserUtils.verifyTitle(driver, "Portal");
    }

    @Test
    public void test2_crm_login() {
        // Logging in using the utility method we created in CRM_Utilities class.
        CRM_Utilities.login_crm(driver);

        //6. Verify title is as expected: "Expected: 'Portal'".
        BrowserUtils.verifyTitle(driver, "Portal");
    }

    @Test
    public void test3_crm_login() {
        // Logging in using the utility method we created in CRM_Utilities class.
        // CRM_Utilities.login_crm(driver, "helpdesk1@cydeo.com", "UserUser"); (Optional)
        CRM_Utilities.login_crm(driver, "helpdesk2@cydeo.com", "UserUser");

        //6. Verify title is as expected: "Expected: 'Portal'".
        BrowserUtils.verifyTitle(driver, "Portal");
    }

    @AfterMethod
    public void tearDownMethod() {
        driver.close();
    }

}
