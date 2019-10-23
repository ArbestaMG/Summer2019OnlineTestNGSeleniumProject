package Tests.day3;

import Utils.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactoryTest {
    public static void main(String[] args) {
        WebDriver driver=BrowserFactory.getDriver("chrome" );
        //getDriver() method will return webdriver object
        // and we can use reference variable to work with that object
        driver.get("http://practice.cybertekschool.com/new_tab");
        // how we can print a source code of the page?
        System.out.println(driver.getPageSource());
        driver.quit();
    }
}
