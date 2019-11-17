package Tests.day9;

import Utils.BrowserFactory;
import Utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LocatorsReview {
    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver=BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
    //we have :ID, NAME, TAG NAME,CLASS NAME, LINK TEXT, PARTIAL LINK TEXT, XPATH, CSS
    @Test(description = "Verify checkboxes")
    public void test1(){
    driver.findElement(By.linkText("Checkboxes")).click();
        BrowserUtils.wait(2);
    // burada 2 tane check box var ,bize 1. lazim. o yuzden :nth-of-type(1) yazdik
        WebElement checkbox1= driver.findElement(By.cssSelector("[type='checkbox']:nth-of-type(1)"));
    // how to verify if the check box is not clicked
        Assert.assertFalse(checkbox1.isSelected(),"Checkbox 1 was selected");// assert that checkbox is not selected
        WebElement checkbox2=driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
        Assert.assertTrue(checkbox2.isSelected(),"Checkbox 2 was not selected");
    }
    @Test(description ="Radio buttons test")
    public void test2(){
        driver.findElement(By.linkText("Radio Buttons")).click();

        WebElement blueButton = driver.findElement(By.xpath("//*[text()='Blue']/preceding-sibling::input[@type='radio']"));
       BrowserUtils.wait(2);
        Assert.assertTrue(blueButton.isSelected(), "Blue button is not selected");
    }

}
