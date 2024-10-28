package org.example;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class RegressionTest extends BaseTest {

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
        Thread.sleep(5000);
    }

    @Test
    public void testMethod2() throws InterruptedException {
        WebDriver driver = BaseTest.getDriver();
        setExtentTest(extent.createTest("ChromeTest2 - Bing Test"));
        driver.get("https://www.bing.com/");
        System.out.println("User navigated to : "+driver.getTitle());
        String title = driver.getTitle();
        getExtentTest().log(Status.INFO, "Page title is: " + title);
        Assert.assertTrue(title.contains("Bing"));
        getExtentTest().log(Status.PASS, "Verified Bing page title successfully.");
        Thread.sleep(5000);

    }

    @Test
    public void testMethod3() throws InterruptedException {
        WebDriver driver = BaseTest.getDriver();
        setExtentTest(extent.createTest("ChromeTest3 - Google Test"));
        driver.get("https://www.google.co.in/");
        System.out.println("User navigated to : "+driver.getTitle());
        String title = driver.getTitle();
        getExtentTest().log(Status.INFO, "Page title is: " + title);
        Assert.assertTrue(title.contains("Google"));
        getExtentTest().log(Status.PASS, "Verified Google page title successfully.");
        Thread.sleep(5000);
    }

    @Test
    public void testMethod4() throws InterruptedException {
        WebDriver driver = BaseTest.getDriver();
        setExtentTest(extent.createTest("ChromeTest4 - Bing Test"));
        driver.get("https://www.bing.com/");
        System.out.println("User navigated to : "+driver.getTitle());
        String title = driver.getTitle();
        getExtentTest().log(Status.INFO, "Page title is: " + title);
        Assert.assertTrue(title.contains("Bing"));
        getExtentTest().log(Status.PASS, "Verified Bing page title successfully.");
        //Assert.fail("This test case is failed");
        Thread.sleep(5000);

    }
    @Test
    public void testMethod5() throws InterruptedException {
        WebDriver driver = BaseTest.getDriver();
        setExtentTest(extent.createTest("ChromeTest5 - Bing Test"));
        driver.get("https://www.bing.com/");
        System.out.println("User navigated to : "+driver.getTitle());
        String title = driver.getTitle();
        getExtentTest().log(Status.INFO, "Page title is: " + title);
        Assert.assertTrue(title.contains("Bing"));
        getExtentTest().log(Status.PASS, "Verified Bing page title successfully.");
        //Assert.fail("This test case is failed");
        Thread.sleep(5000);

    }
}
