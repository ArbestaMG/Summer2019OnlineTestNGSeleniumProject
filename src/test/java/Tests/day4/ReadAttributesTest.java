package Tests.day4;

import Utils.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReadAttributesTest {
    public static void main(String[] args) {
      /*
       1. Go to "http://practice.cybertekschool.com/forgot_password"
        2. Enter any valid email
        3. Click on retrieve password button
        4. Verify that message "Your e-mail's been sent!" is displayed
        */

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        WebElement input = driver.findElement(By.name("email"));
        //to read value of any attribute
        //name="email" name it's an attribute, email it's a value of attribute
        System.out.println(input.getAttribute("pattern"));
        input.sendKeys("random_email@email.com");
        //how to read entered text?
        //it's gonna be inside value attribute
        System.out.println(input.getAttribute("value"));// value of attribute value// girdigimiz sey
        //if button has a type "submit"
        //we can use .submit() method instead of click() as well
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        //alternative to click, only if type="submit"
        retrievePasswordButton.submit();// click and submit neredeyse ayni. button submit ise submit metodunu kullanabilirsin
        driver.close();
    }
}