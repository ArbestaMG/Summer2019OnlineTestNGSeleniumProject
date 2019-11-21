package Tests.day10;

import Utils.BrowserFactory;
import Utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploading {
    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
    }
    @Test(description = "Verify that file was uploaded")
    public void test1(){
        driver.findElement(By.linkText("File Upload")).click();
        //provide path to the file
        //insert your path to the file into sendKeys() method
        BrowserUtils.wait(4);               //copy as path dedikten sonra bu moda soktuk
        driver.findElement(By.id("file-upload")).sendKeys("C:/Users/OFM/Desktop/Sharing.png");
        //click submit
        BrowserUtils.wait(4);
        driver.findElement(By.id("file-submit")).click();
        BrowserUtils.wait(4);
        String expectedFileName = "Sharing.png";
        String actualFileName = driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(actualFileName, expectedFileName);
        BrowserUtils.wait(4);
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
