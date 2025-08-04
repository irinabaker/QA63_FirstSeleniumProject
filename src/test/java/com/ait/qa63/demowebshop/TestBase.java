package com.ait.qa63.demowebshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.List;

public class TestBase {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        driver.quit();
    }

    public boolean isElementPresent(By locator){
        return driver.findElements(locator).size()>0; // возвращает любой element
    }

    public String newEmail() {
        int i =(int) (System.currentTimeMillis()/1000%3600);
        String email = "manuel" + i + "@gmail.com";
        return email;
    }

    public void type(By locator, String text) {
        if (text != null) {
            click(locator);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void clickOnRegisterLink() {
        click(By.cssSelector("[href='/register']"));
    }

    public boolean isSuccessMessagePresent() {
        return isElementPresent(By.cssSelector(".page-body .result"));
    }

    public void clickOnRegisterButton() {
        click(By.id("register-button"));
    }

    public void fillRegisterForm() {
        type(By.id("FirstName"), "John");
        type(By.id("LastName"), "Doe");
        type(By.id("Email"), "doe3@gm.com");
        type(By.id("Password"), "Doe12345");
        type(By.id("ConfirmPassword"), "Doe12345");
    }

    public void clickOnLoginButton() {
        click(By.cssSelector(".button-1.login-button"));
    }

    public void enterUserCredentials() {
        type(By.id("Email"), "doe2@gm.com");
        type(By.id("Password"), "Doe12345");
    }

    public void clickOnLog_inLink() {
        click(By.cssSelector("[href='/login']"));
    }

    public boolean isItemAdded(String text) {
        List<WebElement> contacts = driver.findElements(By.cssSelector(".product-name"));
        for (WebElement element: contacts) {
            if (element.getText().equals(text)) return true;
        }
        return false;
    }

    public void clickOnShoppingCartLink() {
        click(By.cssSelector("[href='/cart']"));
    }

    public void clickOnAddButton(String number) {
        click(By.cssSelector(".item-box:nth-child("+number+") .add-info .buttons input"));
    }
}
