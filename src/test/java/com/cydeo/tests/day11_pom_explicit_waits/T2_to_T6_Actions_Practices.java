package com.cydeo.tests.day11_pom_explicit_waits;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static com.cydeo.utilities.Driver.*;
import static org.testng.Assert.*;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class T2_to_T6_Actions_Practices {
    
    @BeforeMethod
    public void setUpMethod() {
        //1. Go to https://practice.cydeo.com/drag_and_drop_circles
        getDriver().get("https://practice.cydeo.com/drag_and_drop_circles");
    }

    //TC2 #: Drag and drop default value verification
    @Test
    public void test2_default_value_verification() {
        //2. Verify big circle default text is as below.
        //3. Assert: -Text in big circle changed to: “Drag the small circle here.”
        assertEquals(getDriver().findElement(By.xpath("//div[@id='droptarget']")).getText(), "Drag the small circle here.", "Big circle's default text verification FAILED!!!");
    }

    //TC3 #: Drag and drop into the big circle
    @Test
    public void test3_drop_into_the_big_circle() {
        //2. Drag and drop the small circle to bigger circle.
        /*WebElement smallCircle = */
        getDriver().findElement(By.xpath("//div[@id='draggable']"));
        WebElement bigCircle = getDriver().findElement(By.xpath("//div[@id='droptarget']"));

        Actions actions = new Actions(getDriver());
        actions.clickAndHold(getDriver().findElement(By.xpath("//div[@id='draggable']")))
                .moveToElement(bigCircle)
                .pause(1000)
                .release()
                .perform();

        //3. Assert: -Text in big circle changed to: “You did great!”
        assertEquals(bigCircle.getText(), "You did great!", "Big circle's text verification after dropping the small one FAILED!!!");
    }

    //TC4 #: Click and hold
    @Test
    public void test4_click_and_hold_small_circle() {
        //2. Click and hold the small circle.
        Actions actions = new Actions(getDriver());
        actions.clickAndHold(getDriver().findElement(By.xpath("//div[@id='draggable']"))).
                moveToElement(getDriver().findElement(By.linkText("CYDEO")))
                .perform();

        //3. Assert: -Text in big circle changed to: “Drop here.”
        assertEquals(getDriver().findElement(By.xpath("//div[@id='droptarget']")).getText(), "Drop here.", "Big circle's text verification after moving the small one FAILED!!!");
    }

    //TC5 #: Drag and drop outside the big circle
    @Test
    public void test5_drop_outside_of_big_circle() {
        //2. Drag and drop the small circle to bigger circle.        
        Actions actions = new Actions(getDriver());
        actions.dragAndDrop(getDriver().findElement(By.xpath("//div[@id='draggable']")), getDriver().findElement(By.linkText("CYDEO")))
                .perform();

        //3. Assert: -Text in big circle changed to: “Try again!”
        assertEquals(getDriver().findElement(By.xpath("//div[@id='droptarget']")).getText(), "Try again!", "Big circle's text verification after dropping the small one out of target FAILED!!!");
    }

    //TC6 #: Drag and hover
    @Test
    public void big_circle_hovering_text_verify() {
        //2. Drag the small circle on top of the big circle, hold it, and verify.
        WebElement bigCircle = getDriver().findElement(By.xpath("//div[@id='droptarget']"));

        Actions actions = new Actions(getDriver());
        actions.clickAndHold(getDriver().findElement(By.xpath("//div[@id='draggable']")))
                .moveToElement(bigCircle)
                .perform();

        //3. Assert: -Text in big circle changed to: “Now drop...”
        assertEquals(bigCircle.getText(), "Now drop...", "Big circle's text verification after hovering the small over it FAILED!!!");
    }

    @AfterMethod
    public void tearDownMethod() {
        Driver.closeDriver();
    }

}
