package Tests.day7;

import Utils.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Warmup {
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("http://cybertekschool.com/");
        // we are trying to find how many tags we have// tag starts with <a>
        List<WebElement> links= driver.findElements(By.xpath("//a"));
                                            // elementSSS yaptik cunku coklu bir list
        // //a ile baslayanlar link oluyor. o yuzden onlari bulup linke assign ediyoruz.
        // linkin size i bize link sayyisini veriyor
        System.out.println("Number of the links "+ links.size());

        for(WebElement each:links){
            System.out.println(each.getText());
        }
        driver.quit();

    }
}
