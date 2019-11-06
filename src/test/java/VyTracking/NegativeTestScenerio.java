package VyTracking;

import Utils.BrowserFactory;
import Utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NegativeTestScenerio {
    public static void main(String[] args) {


        WebDriver driver = BrowserFactory.getDriver("chrome");
        //Go to website
        driver.get("https://qa2.vytrack.com/user/login");
        //Credentials and enter
        WebElement inputBox = driver.findElement(By.name("_username"));
        inputBox.sendKeys("WrongCredentials");// This is wrong credential
        WebElement inputBox2 = driver.findElement(By.name("_password"));
        inputBox2.sendKeys("UserUser123");
        BrowserUtils.wait(5);
        //Click
        WebElement button = driver.findElement(By.id("_submit"));
        //to click on the element
        button.click();
        BrowserUtils.wait(5);

        WebElement error=driver.findElement(By.xpath("//div[contains(text(),'Invalid user name or password.')]"));
        System.out.println(error);

    }
}