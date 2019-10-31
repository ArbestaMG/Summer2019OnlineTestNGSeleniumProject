package VyTracking;

import Utils.BrowserFactory;
import Utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PositiveTestScenerio {
    public static void main(String[] args) {


        WebDriver driver = BrowserFactory.getDriver("chrome");
        //Go to website
        driver.get("https://qa2.vytrack.com/user/login");
        //Credentials and enter
        WebElement inputBox = driver.findElement(By.name("_username"));
        inputBox.sendKeys("salesmanager107");
        WebElement inputBox2 = driver.findElement(By.name("_password"));
        inputBox2.sendKeys("UserUser123");
        BrowserUtils.wait(5);
        WebElement button = driver.findElement(By.id("_submit"));
        //to click on the element
        button.click();
        BrowserUtils.wait(5);

        //Website check
        String expectedUrl = "https://qa2.vytrack.com/";
        String actualUrl = driver.getCurrentUrl();

        if (expectedUrl.equals(actualUrl)) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }
        driver.close();
    }
    }
