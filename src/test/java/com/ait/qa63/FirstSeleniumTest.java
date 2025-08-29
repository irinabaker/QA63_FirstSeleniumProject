package com.ait.qa63;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public class FirstSeleniumTest {

    WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("BeforeSuite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("AfterSuite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("*****BeforeTest");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("*****AfterTest");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("**********BeforeClass");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("**********AfterClass");
    }

    //before - setUp
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        System.out.println("***************BeforeMethod");
        driver = new ChromeDriver();
      //  driver.get("https://www.google.com");//without history
        driver.navigate().to("https://www.google.com");//with history
        driver.navigate().back();//key back
        driver.navigate().forward();//key forward
        driver.navigate().refresh();
    }
    //test
    @Test()
    public void firstTest() {
        System.out.println("*******************Test");System.out.println("Google is opened!");
    }
    //after - tearDown
    @AfterMethod(enabled = false)
    public void tearDown() {
        System.out.println("***************AfterMethod");
      //  driver.quit();// all tabs & close browser
        driver.close();// only one tab (if tab only one -> close browser)
    }
}