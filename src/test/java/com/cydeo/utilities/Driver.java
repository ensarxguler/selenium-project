package com.cydeo.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {

    private Driver() {
    }     // default value == null

    // We want the WebDriver private, because we want to close access from outside the class.
    // We are making it static, because we will use it in a static method.
    private static WebDriver driver;

    // Create a re-usable method which will return the same driver instance once we call it.
    // If an instance doesn't exist, it will create first, and then it will always return same instance.
    public static WebDriver getDriver() {

        if (driver == null) {

            // We will read our browserType from configuration.properties file.
            // This way, we can control which browser is opened from outside our code.
            String browserType = ConfigurationReader.getProperty("browser");

            // Depending on the browserType returned form the configuration.properties,
            // switch statement will determine the "case", and open the matching browser.
            switch (browserType) {
                case "chrome" -> {
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                }
                case "firefox" -> {
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                }
                case "edge" -> {
                    driver = new EdgeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                }
            }

        }

        return driver;

    }

    // Create a new Driver.closeDriver(); it will use .quite() method to quit browsers, and then set the driver value back to null.
    public static void closeDriver() {
        if (driver != null) {
            // This line will terminate the currently existing driver completely. It will be non-existent.
            driver.quit();
            
            // We assign the value back to "null" so that my "singleton" can create a newer one if needed.
            driver = null;
        }
    }

}
