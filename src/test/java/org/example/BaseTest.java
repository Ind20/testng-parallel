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
    protected ExtentReports extent = ExtentManager.getInstance();
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public synchronized ExtentTest getExtentTest() {
        return extentTest.get();
    }

    public synchronized void setExtentTest(ExtentTest test) {
        extentTest.set(test);

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            getExtentTest().log(Status.FAIL, "Test Failed: " + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            getExtentTest().log(Status.PASS, "Test Passed");
        } else if (result.getStatus() == ITestResult.SKIP) {
            getExtentTest().log(Status.SKIP, "Test Skipped: " + result.getThrowable());
        }

        if (driver != null) {
            driver.quit();
        }
        extent.flush();

    }
}

