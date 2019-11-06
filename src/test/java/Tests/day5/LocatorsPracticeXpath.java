package Tests.day5;

import Utils.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LocatorsPracticeXpath {
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");

        WebElement dropDownLink=driver.findElement(By.xpath("html/body/div/div[2]/div/ul/li[11]/a"));
        System.out.println(dropDownLink.getText());
        dropDownLink.click();

        try {
            //thread to sleep for the specified number of milliseconds
            Thread.sleep(2000);
        } catch ( java.lang.InterruptedException ie) {
            System.out.println(ie);
        }
        driver.close();
    }
}
