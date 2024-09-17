package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class SampleTest {
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testMethod1() throws InterruptedException {
        driver.get("https://www.google.co.in/");
        System.out.println("User navigated to : "+driver.getTitle());
    }

    @Test
    public void testMethod2() throws InterruptedException {
        driver.get("https://www.bing.com/");
        System.out.println("User navigated to : "+driver.getTitle());
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
