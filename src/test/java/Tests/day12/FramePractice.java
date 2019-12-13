package Tests.day12;


import Utils.BrowserFactory;
import Utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FramePractice {
    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/frames");

    }
    @AfterMethod(description = "iFrame example")
    public void teardown(){
        driver.quit();
    }
    @Test//HERHANGI BIR SITEDE FRAME BULMAK ISTIYORSAK, ARAMA YERINE iframe//frame yaz
    public void test1(){
        driver.findElement(By.partialLinkText("iF")).click();
        // burada iceride frame var, yani yazilabilecek bi alan, selenium bunu goremiyor
        // bu yuzden switch yapmak lazim
        //since element inside the frame, element is not visible for selenium
        //without switching to the frame
        //we can switch to frame based on id, name, index(starting from 0). web element
        driver.switchTo().frame("mce_0_ifr");
        //Without switchin,we can not see inner html document
        // which one to use? id , name, index,webelement?
        // 1)id or name
        //2)web
        WebElement inputArea = driver.findElement(By.id("tinymce"));

        String expectedText = "Your content goes here.";
        String actualText = inputArea.getText();

        Assert.assertEquals(actualText, expectedText);

        BrowserUtils.wait(2);
        inputArea.clear();
        BrowserUtils.wait(2);
        inputArea.sendKeys("JAVA IS FUN");
        BrowserUtils.wait(2);

        driver.switchTo().defaultContent();
    }
    @Test(description = "Nested Frames example")
    public void test2(){
        driver.findElement(By.partialLinkText("Nested")).click();
        BrowserUtils.wait(1);
        driver.switchTo().frame(driver.findElement(By.cssSelector("[name='frame-bottom']")));
        BrowserUtils.wait(1);
        WebElement content=driver.findElement(By.tagName("body"));

        System.out.println(content.getText());

        driver.switchTo().defaultContent();

        driver.switchTo().frame("frame-top");// second floor


        driver.switchTo().frame("frame-left");// third floor
        System.out.println(driver.findElement(By.tagName("body")).getText());


        driver.switchTo().defaultContent();
        // bunu yapiyoruz cunku framelerde adim adim gidiyoruz

        driver.switchTo().frame("frame-top");// second floor

        driver.switchTo().frame("frame-right");// third floor
        System.out.println(driver.findElement(By.tagName("body")).getText());
    }

}
