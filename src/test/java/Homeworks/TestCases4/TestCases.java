package Homeworks.TestCases4;

import Utils.BrowserFactory;
import Utils.BrowserUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestCases {
    private WebDriver driver;
    private WebDriverWait wait;
    @BeforeMethod
    public void setup(){
        driver=BrowserFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();

        driver.get("https://qa1.vytrack.com/user/login");
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
    public void teardown(){
        driver.quit();
    }



    @Test
public void method1() {
        BrowserUtils.wait(2);
        //Finding the element

        WebElement threeDots=driver.findElement(By.xpath("(//a[@class='dropdown-toggle'])[17]"));
        //Action
        Actions action= new Actions(driver);
        action.moveToElement(threeDots).perform();

        BrowserUtils.wait(1);
        WebElement viewButton=driver.findElement(By.xpath("//a[@href='/calendar/event/view/184']"));

        BrowserUtils.wait(1);
        if(viewButton.isDisplayed()){
            System.out.println("View Button is displayed");
        }
        BrowserUtils.wait(1);
        WebElement editButton=driver.findElement(By.xpath("//a[@href='/calendar/event/update/184']"));

        BrowserUtils.wait(1);
        if(editButton.isDisplayed()){
            System.out.println("Edit Button is displayed");
        }

        BrowserUtils.wait(1);
        WebElement deleteButton=driver.findElement(By.cssSelector("[class='fa-trash-o hide-text']"));

        if(deleteButton.isDisplayed()){
            System.out.println("Delete Button is displayed");
        }
    }
    @Test
    public void test2(){
        BrowserUtils.wait(4);
        driver.findElement(By.cssSelector("[class='fa-cog hide-text']")).click();
        BrowserUtils.wait(2);
        Actions action = new Actions(driver);

        WebElement checkBox1=driver.findElement(By.xpath("//input[@id='column-c325']"));
        action.click(checkBox1).perform();

        WebElement checkBox2=driver.findElement(By.xpath("//input[@id='column-c326']"));
        action.click(checkBox2).perform();

        WebElement checkBox3=driver.findElement(By.xpath("//input[@id='column-c327']"));
        action.click(checkBox3).perform();

        WebElement checkBox4=driver.findElement(By.xpath("//input[@id='column-c328']"));
        action.click(checkBox4).perform();

        WebElement checkBox5=driver.findElement(By.xpath("//input[@id='column-c329']"));
        action.click(checkBox5).perform();

        WebElement checkBox6=driver.findElement(By.xpath("//input[@id='column-c330']"));
        action.click(checkBox6).perform();

        WebElement checkBox7=driver.findElement(By.xpath("//input[@id='column-c324']"));

        if(!checkBox7.isEnabled()){
            System.out.println("Test passed");
        }
        }
    @Test
    public void test3(){{
        BrowserUtils.wait(3);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement saveButton=driver.findElement(By.cssSelector("[title='Create Calendar event']"));
        saveButton.click();

        BrowserUtils.wait(2);
        WebElement multipleButton=driver.findElement(By.cssSelector("[class='btn-success btn dropdown-toggle']"));
        multipleButton.click();




        WebElement button1=driver.findElement(By.xpath("(//button[@type='submit'])[2]"));


        WebElement button2=driver.findElement(By.xpath("(//button[@type='submit'])[3]"));

        WebElement button3=driver.findElement(By.xpath("(//button[@type='submit'])[4]"));

        if(button1.isEnabled() && button2.isEnabled() && button3.isEnabled()){
            System.out.println("Test passed");
        }else {
            System.out.println("We have a problem");


        }}
    }
}
