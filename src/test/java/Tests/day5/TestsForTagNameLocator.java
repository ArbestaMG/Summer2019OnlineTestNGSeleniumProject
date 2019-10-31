package Tests.day5;

import Utils.BrowserFactory;

import Utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.xml.transform.sax.SAXSource;

/*
<a href+"/autocomplete">Autocomplete</a>
a- tag name
href- attribute
/autocomplete - value of href attribute
Autocomple - text
<a href="/autocomplete"> - opening tag
</a> - closing tag

In general, a
 */
public class TestsForTagNameLocator {
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");

        driver.findElement(By.name("full_name")).sendKeys("Test User");
        BrowserUtils.wait(2);
        driver.findElement(By.name("email")).sendKeys("test_email@email.com");
        BrowserUtils.wait(2);
        driver.findElement(By.name("wooden_spoon")).click();
        BrowserUtils.wait(2);

        WebElement subhead= driver.findElement(By.tagName("h3"));
        System.out.println(subhead.getText());// burada baktigimiz sey sitenin headeri yani basligi gibi
    }
}
