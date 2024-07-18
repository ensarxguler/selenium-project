package com.cydeo.tests.day01_selenium_intro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    public static void main(String[] args) {
        
        //1- Create the instance of Chrome browser driver
        WebDriver driver = new ChromeDriver();
        
        //2- T1_Bing_Search if driver and browser are working as expected
        driver.get("https://www.google.com");
        
    }
    
}
