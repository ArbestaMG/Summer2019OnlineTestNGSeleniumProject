package Tests.day5;

import Utils.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestForLinkTest {
    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com");
        driver.findElement(By.linkText("Challenging DOM"));// bu bir link oldugu icin bunu yazdik
        //<a href="/autocomplete">Autocomplete</a>
        // it works only if tag name is <a>
        Thread.sleep(3000);
        driver.quit();

    }
}