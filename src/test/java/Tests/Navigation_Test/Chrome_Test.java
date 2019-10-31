package Tests.Navigation_Test;

import Utils.BrowserFactory;
import org.openqa.selenium.WebDriver;



public class Chrome_Test {

    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://google.com");
        String firstTitle = driver.getTitle();

        driver.navigate().to("http://etsy.com");
        String secondTitle = driver.getTitle();

        driver.navigate().back();
        String thirdTitle = driver.getTitle();
        if (firstTitle.equals(thirdTitle)) {
            System.out.println("First test passed");
        } else {
            System.out.println("First test failed");
        }
        driver.navigate().forward();
        String fourthTitle = driver.getTitle();
        if (secondTitle.equals(fourthTitle)) {
            System.out.println("Second test passed");
        } else {
            System.out.println("Second test failed");
        }
    }
}