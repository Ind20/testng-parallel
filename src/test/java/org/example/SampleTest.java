package org.example;

import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.*;

public class SampleTest extends BaseTest {


    @Test
    public void testMethod1() {

        setExtentTest(extent.createTest("ChromeTest1 - Google Test"));
        driver.get().get("https://www.google.co.in/");
        System.out.println("User navigated to : "+driver.get().getTitle());
        String title = driver.get().getTitle();
        getExtentTest().log(Status.INFO, "Page title is: " + title);

        Assert.assertTrue(title.contains("Google"));
        getExtentTest().log(Status.PASS, "Verified Google page title successfully.");
    }

    @Test
    public void testMethod2() throws InterruptedException {
        setExtentTest(extent.createTest("ChromeTest2 - Bing Test"));
        driver.get().get("https://www.bing.com/");
        System.out.println("User navigated to : "+driver.get().getTitle());
        String title = driver.get().getTitle();
        getExtentTest().log(Status.INFO, "Page title is: " + title);

        Assert.assertTrue(title.contains("Bing"));
        getExtentTest().log(Status.PASS, "Verified Bing page title successfully.");
        Thread.sleep(3000);

    }
}
