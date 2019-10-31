package Tests.day5;

import Utils.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class TestForClassNameLocator {
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        WebElement heading=driver.findElement(By.className("h3"));// burada sitedeki heading i bulduk.
        // headingin numarasi 3 oldugu icin oradan gittik

        System.out.println(heading.getText());
        driver.quit();
    }
}
