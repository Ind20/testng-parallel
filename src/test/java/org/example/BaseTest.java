package org.example;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class BaseTest {
    private static final ThreadLocal<WebDriver> thread = new ThreadLocal<>();
    ExtentReports extent = ExtentManager.getInstance();
    private static final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public static WebDriver getDriver() {
        System.out.println("Setup - Thread ID: " + Thread.currentThread().getId());
        return thread.get();
    }

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        thread.set(new ChromeDriver());
    }

    public synchronized ExtentTest getExtentTest() {
        return extentTest.get();
    }

    public synchronized void setExtentTest(ExtentTest test) {
        extentTest.set(test);

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            getExtentTest().log(Status.FAIL, "Test Failed: " + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            getExtentTest().log(Status.PASS, "Test Passed");
        } else if (result.getStatus() == ITestResult.SKIP) {
            getExtentTest().log(Status.SKIP, "Test Skipped: " + result.getThrowable());
        }

        if (thread.get() != null) {
            thread.get().quit();
            thread.remove();
        }
        extent.flush();
    }

    @AfterSuite(alwaysRun = true)
    public void publishReport() throws IOException {
        Desktop.getDesktop().browse(new File("test-output\\ExtentReport.html").toURI());
    }
}

