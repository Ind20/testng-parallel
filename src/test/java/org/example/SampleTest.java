package org.example;

import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.*;

public class SampleTest extends BaseTest {


    @Test
    public void testMethod1() {

        test = extent.createTest("ChromeTest1 - Google Test");
        driver.get("https://www.google.co.in/");
        System.out.println("User navigated to : "+driver.getTitle());
        String title = driver.getTitle();
        test.log(Status.INFO, "Page title is: " + title);

        Assert.assertTrue(title.contains("Google"));
        test.log(Status.PASS, "Verified Google page title successfully.");
    }

    @Test
    public void testMethod2() {
        test = extent.createTest("ChromeTest2 - Bing Test");
        driver.get("https://www.bing.com/");
        System.out.println("User navigated to : "+driver.getTitle());
        String title = driver.getTitle();
        test.log(Status.INFO, "Page title is: " + title);

        Assert.assertTrue(title.contains("Bing"));
        test.log(Status.PASS, "Verified Bing page title successfully.");

    }

}
