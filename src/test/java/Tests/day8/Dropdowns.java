package Tests.day8;

import Utils.BrowserFactory;
import Utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Dropdowns {
    private WebDriver driver;
    /*
    <select id>="dropdown">
    <option value="" disabled="disabled"  selected="selected"> Please select  an option</
     */
@BeforeMethod
    public void setup(){
    driver= BrowserFactory.getDriver("chrome");
    driver.get("http://practice.cybertekschool.com/");
    driver.findElement(By.linkText("Dropdown")).click();
}
@Test(description = "Select option 2 from the dropdown")
public void test1(){
    WebElement dropdown=driver.findElement(By.id("dropdown"));

    Select select= new Select(dropdown);

    select.selectByVisibleText("Option 2");
    BrowserUtils.wait(2);

    Assert.assertEquals(select.getFirstSelectedOption().getText(),"Option 2");
}
@Test(description ="Print list of all states")
public void test2(){
    WebElement state= driver.findElement(By.id("state"));
    Select select=new Select(state);

    List<WebElement> states= select.getOptions();//

    for(WebElement option:states){
        System.out.println(option.getText());

    }

}
@Test(description = "Select your state and verify that state is selected")
public void test3() {
    WebElement state = driver.findElement(By.id("state"));
    Select select = new Select(state);
    select.selectByValue("KY");

    Assert.assertEquals(select.getFirstSelectedOption().getText(),"Kentucky");
}

@AfterMethod
    public void teardown(){
    driver.quit();
}
}
