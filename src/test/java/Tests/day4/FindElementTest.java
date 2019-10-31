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
        String expectedTitle=driver.getTitle();// burada sayfanin titlena bakiyoruz
        // burada sayfayi acinda hemen onu expected a yapiyoruz.

        //Step 1: Open inspector in chrome and find locator in element
        //Step 2: Create object of web element
        //Step 3:Use web element
        BrowserUtils.wait(5);
        WebElement button= driver.findElement(By.id("form_submit"));// basina # koyarsak yani #form_submit yaparsak,
        //onun uniq olup olmadigini bulur
        button.click();

        //after click
        String actualTitle=driver.getTitle();
        if(actualTitle.equals(expectedTitle)){
            System.out.println("Test passed");}
        else{
            System.out.println("Test failed");
            System.out.println("Expected result is "+expectedTitle);
            System.out.println("Actual result is "+actualTitle);
        }
        // wait for two seconds
        BrowserUtils.wait(2);
        driver.close();
    }
}
