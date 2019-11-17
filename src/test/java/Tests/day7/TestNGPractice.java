package Tests.day7;

import Utils.BrowserFactory;
import org.apache.commons.io.input.BrokenInputStream;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice {

    @Test
    public void test(){
        Assert.assertEquals("Apple","Apple","Word is not correct, should a Apple");
/*
Eskiden if(str1.equals(str2)) { falan yazardik, bu daha kisa
 */
    }
    @Test(description = "Verifying the title of the practice website")
    public void verifyTitle() {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        String expectedTitle = "Practice";
        String actualTitle = driver.getTitle();
        // check if two things are same
        Assert.assertEquals(actualTitle, expectedTitle, "Title is wrong");
        driver.quit();
    }
    @Test(description = "Verify that heading is displayed")
    public void verifyHeadingIsDisplayed(){
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");

        WebElement header=driver.findElement(By.xpath(" //span[text()='Test Automation Practice'] "));
        //Assert true checks if something is true
        Assert.assertTrue(header.isDisplayed(),"Message is not visible");// headerin gorundugunden emin olmak istiyoruz
                    // bunun icine istedigimizi yazariz. 1==1,
        driver.quit();


    }


}
