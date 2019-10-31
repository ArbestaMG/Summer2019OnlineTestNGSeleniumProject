package Tests.day5;

import Utils.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestsForLocator {
    /*
   1)First we need to open the page in browser(chrome)
   2)Then right click and inspect the page
   3)Click on selector to select specific element or text on the page
   4)We can click with an inspector on the specific element
   5)Them, we can see what HTML code is behind this element
   6)Based on the properties/attributes, tags and text we can choose locator strategy
   7)If it is possible, use id
   8)In code, it will look like: <input type+"text" id= "first_name">

   WebElement first_name=driver.findElemetn(By.id("first_name"));

   //id nin uniq oldugunu bulmak icin id nin basina #koyariz.
     */
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        WebElement button= driver.findElement(By.id("disappearing_button"));
        button.click();

        WebElement result=driver.findElement(By.id("result"));
        System.out.println(result.getText());
        driver.quit();
    }

}
