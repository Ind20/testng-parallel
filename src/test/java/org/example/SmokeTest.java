package org.example;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class SmokeTest extends BaseTest {

    @Test
    public void testMethod1() throws InterruptedException {
        WebDriver driver = BaseTest.getDriver();
        setExtentTest(extent.createTest("ChromeTest1 - Google Test"));
        driver.get("https://www.google.co.in/");
        System.out.println("User navigated to : "+driver.getTitle());
        String title = driver.getTitle();
        getExtentTest().log(Status.INFO, "Page title is: " + title);
        Assert.assertTrue(title.contains("Google"));
        getExtentTest().log(Status.PASS, "Verified Google page title successfully.");
    }

}
