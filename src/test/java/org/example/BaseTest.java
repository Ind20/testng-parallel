package org.example;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class BaseTest {
    protected WebDriver driver;
    protected ExtentReports extent;
    protected ExtentTest test;

    @BeforeMethod
    public void setup() {
        extent = ExtentManager.getInstance();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "Test Failed: " + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Test Passed");
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "Test Skipped: " + result.getThrowable());
        }
        if (driver != null) {
            driver.quit();
        }
        extent.flush();

    }
}

