package Tests.day10;

import Utils.BrowserFactory;
import Utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowsSwitching {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com");
        driver.manage().window().maximize();

    }
    @Test
    public void method1(){
        driver.findElement(By.linkText("New tab")).click();
        //after 3 seconds another website will be opened in the second window
        //selenium does not switch automatically to the new window
        BrowserUtils.wait(4);
        System.out.println(driver.getTitle());

        Assert.assertEquals(driver.getTitle(),"Practice","Wrong title");
    }
    @Test(description = "Verify that user is able to see new window")
    public void test2(){
        driver.findElement(By.linkText("New tab")).click();
        //record id of original window, that we opened initially
        String oldWindow = driver.getWindowHandle();
        //after 3 seconds, another website will be opened,in the second window
        //selenium doesn't switch automatically to the new window
        BrowserUtils.wait(5);
        //in the selenium every window has an id. That id calls window handle
        //to read window handle we use a method getWindowHandle()
        //after new window was opened, we can get list of all window id's/window handles


        //list - it's a data structure
        //set it's also a data structure, like list, but it doesn't allow duplicates
        //also, you cannot easily access anything from there
        //there is no .get() method
        //that's why, we need to loop through the set, to read a data from there
        //set can store only unique values
        Set<String> windowHandles = driver.getWindowHandles();
        //loop through the collection of window handles
        for(String each1: windowHandles){
            //if it's not an old window
            if(!each1.equals(oldWindow)){
                //switch to that window
                BrowserUtils.wait(2);
                driver.switchTo().window(each1);
                BrowserUtils.wait(2);
            }
        }
        //let's verify that title of new window is a Fresh tab
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Fresh tab", "Title is wrong!");

        String pageTitle="Practice";
        for(String each1:windowHandles){
            driver.switchTo().window(each1);
            if(driver.getTitle().equals(pageTitle)){
                break;
            }
        }
    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
