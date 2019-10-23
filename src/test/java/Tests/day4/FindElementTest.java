package Tests.day4;

import Utils.BrowserFactory;
import Utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindElementTest {

    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        //Step 1: Open inspector in chrome and find locator in element
        //Step 2: Create object of web element
        //Step 3:Use web element
        WebElement button= driver.findElement(By.id("form_submit"));
        button.click();
        // wait for two seconds
        BrowserUtils.wait(2);
        driver.close();
    }
}
