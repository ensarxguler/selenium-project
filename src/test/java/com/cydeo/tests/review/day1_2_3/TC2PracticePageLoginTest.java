package com.cydeo.tests.review.day1_2_3;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC2PracticePageLoginTest {

    public static void main(String[] args) throws InterruptedException {

        // 1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();

        // 2. Go to https://practice.cydeo.com/login
        driver.get("https://practice.cydeo.com/login");

        // <input type="text" name="username">
        // 3. Enter username: "tomsmith"
        WebElement usernameElement = driver.findElement(By.cssSelector("input[name='username']"));
        usernameElement.sendKeys("tomsmith");

        // <input type="password" name="password">
        // 4. Enter password: "SuperSecretPassword"
        WebElement passwordElement = driver.findElement(By.cssSelector("input[type='password']"));
        passwordElement.sendKeys("SuperSecretPassword");

        // <button class="btn btn-primary" type="submit" id="wooden_spoon">Login</button>
        // 5. Click to Login button
        WebElement logInButton = driver.findElement(By.cssSelector("button#wooden_spoon"));
        logInButton.click();

        // <div data-alert="" id="flash" class="flash success">
        //            You logged into a secure area!
        //            <a href="#" class="close">×</a>
        //          </div>
        // 6. Verify text displayed on page
        //    Expected: "You logged into a secure area!" 
        String expectedHeader = "You logged into a secure area!";

        // SUPER IMPORTANT NOTE #1
        // normalize-space(text()); method is used to remove the whitespace of the specific text like: .trim();
        WebElement header = driver.findElement(By.xpath("//div[normalize-space(text())='You logged into a secure area!']"));

        // SUPER IMPORTANT NOTE #2
        // When there are multiple values for class attribute, you cannot use "By.className();" method
        // because of the empty space between the classes. "By.className();" method looks for "1/1" or unique value.
        // Instead of that, we can go with the XPATH for class attributes.
        WebElement header2 = driver.findElement(By.xpath("//div[@class='flash success']"));
        
        String actualHeader = header.getText().trim();
        
        if (actualHeader.contains(expectedHeader)) {
            System.out.println("Header verification is PASSED!");
        } else {
            System.out.println("Header verification is FAILED!!!");
            System.out.println("expectedHeader = " + expectedHeader);
            System.out.println("actualHeader = " + actualHeader);
        }

        driver.close();

    }

}
