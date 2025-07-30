package com.ait.qa63;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TableTests {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/css/css_table.asp");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void tableCssSelectorTest() {
        //get numbers of rows
        List<WebElement> rows = driver.findElements(By.cssSelector("tr"));
        System.out.println(rows.size());
        for (int i = 0; i < rows.size(); i++) {
            System.out.println(rows.get(i).getText());
        }
        System.out.println("***************************************************");
        for(WebElement element: rows) {
            System.out.println(element.getText());
        }
        System.out.println("***************************************************");

        //get row 5
        WebElement austria = driver.findElement(By.cssSelector("tr:nth-child(5)"));
        System.out.println(austria.getText());
        System.out.println("**************************************************");
        
        //get row 3 with class
        WebElement peter = driver.findElement(By.cssSelector(".fullwidthtable tr:nth-child(2)"));
        System.out.println(peter.getText());
        System.out.println("***********************************************");

        //get row 5, last element
        //WebElement austria1 = driver.findElement(By.cssSelector("tr:nth-child(5) td:nth-child(3)"));
        WebElement austria1 = driver.findElement(By.cssSelector("tr:nth-child(5) td:last-child"));
        System.out.println(austria1.getText());
    }

    @Test
    public void xpathTableTest() {
        //get row 5
        WebElement austria = driver.findElement(By.xpath("//tr[5]"));
        System.out.println(austria.getText());
        System.out.println("**************************************************");

        //get row 3 with class
        WebElement peter = driver.findElement(By.xpath("//*[@class='fullwidthtable']//tr[2]"));
        System.out.println(peter.getText());
        System.out.println("***********************************************");

        //get row 5, last element
        //WebElement austria1 = driver.findElement(By.xpath("//tr[5]//td[3]"));
        WebElement austria1 = driver.findElement(By.xpath("//tr[5]//td[last()]"));
        System.out.println(austria1.getText());
    }
}
