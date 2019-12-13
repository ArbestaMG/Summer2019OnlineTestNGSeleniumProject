package Homeworks.TestCases3;

import Utils.BrowserFactory;
import Utils.BrowserUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestCases_1_5 {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://qa1.vytrack.com");
        driver.manage().window().maximize(); //maximize window
        //Implicit and Explicit Waits
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        // Username
        WebElement userName = driver.findElement(By.id("prependedInput"));
        wait.until(ExpectedConditions.visibilityOf(userName));
        userName.sendKeys("storemanager85");
        //Password
        WebElement password = driver.findElement(By.id("prependedInput2"));
        wait.until(ExpectedConditions.visibilityOf(password));
        password.sendKeys("UserUser123");
        //Login
        driver.findElement(By.id("_submit")).click();
        //To be able to see Activities functionality
        WebElement activitiesElement = driver.findElement(By.linkText("Activities"));
        wait.until(ExpectedConditions.visibilityOf(activitiesElement));
        wait.until(ExpectedConditions.elementToBeClickable(activitiesElement));

        //To be able to hover
        Actions action = new Actions(driver);
        action.moveToElement(activitiesElement).perform();
        driver.findElement(By.linkText("Calendar Events")).click();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test
    public void test1() {
        String actualText = driver.findElement(By.cssSelector("[class='btn btn-link dropdown-toggle']")).getText();
        String expectedText = "Options";
        BrowserUtils.wait(2);
        Assert.assertEquals(actualText, expectedText);
    }

    @Test
    public void test2() {
        String actualText = driver.findElement(By.cssSelector("[value='1']:nth-of-type(1)")).getAttribute("value");
        String expectedText = "1";
        BrowserUtils.wait(2);
        Assert.assertEquals(actualText,expectedText);
    }
    @Test
    public void test3(){
        String actualText=driver.findElement(By.cssSelector("[class='btn dropdown-toggle ']")).getText();
        String expectedText="25";
        Assert.assertEquals(actualText,expectedText);

}
    @Test
    public void test4(){
        //Finding the number of the records
        String numberOfRecord=driver.findElement(By.xpath("//label[text()='Total of 19 records']")).getText();
        String realnNumberOfRecord=numberOfRecord.substring(9,11);
        System.out.println(realnNumberOfRecord);

        int act=driver.findElements(By.xpath("//tbody/tr")).size();
        //Trying to make int into String value
        String expected=""+act;
        Assert.assertEquals(realnNumberOfRecord,expected);
    }
    @Test
    public void test5(){
        //Finding the number
        int actualNumOfRec = driver.findElements(By.cssSelector("tr[class='grid-row row-click-action']")).size();
       //Click it
        driver.findElement(By.cssSelector("[class='btn btn-default btn-small dropdown-toggle']>input")).click();
      //Count the clicked ones
        int numOfSelectedRows = driver.findElements(By.cssSelector("[class='grid-row row-click-action row-selected']")).size();

        Assert.assertEquals(numOfSelectedRows, actualNumOfRec);
    }




}