package Tests.day8;

import Utils.BrowserFactory;
import Utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Dropdown_Practice {
    private WebDriver driver;
    /*
    <select id>="dropdown">
    <option value="" disabled="disabled"  selected="selected"> Please select  an option</
     */
    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");

    }
    @Test(description = "Options")
    public void selectByText(){
        BrowserUtils.wait(2);
        Select select=new Select(driver.findElement(By.id("dropdown")));
        select.selectByVisibleText("Option 1");
        BrowserUtils.wait(2);
    }
    @Test(description = "States")
    public void selectByStates(){
        Select select=new Select(driver.findElement(By.id("state")));
        select.selectByValue("NY");
        String expected="New York";

        String actual=select.getFirstSelectedOption().getText();
        System.out.println("Expected: "+expected);
        System.out.println("Actual: "+actual);

        select.selectByIndex(4);// burada indexe gore sectik
        System.out.println(select.getFirstSelectedOption().getText());

    }
    @Test(description = "Programming languages")
    public void selectByLanguage(){
        Select select=new Select(driver.findElement(By.name("Languages")));

        List<WebElement> options =select.getOptions();

        for(WebElement each:options) {
            BrowserUtils.wait(1);
            select.selectByVisibleText(each.getText());
        }

        List<WebElement>selectedOptions=select.getAllSelectedOptions();// bu gorunmeyen degerleride aldi
    for(WebElement each1:selectedOptions){
        System.out.println(each1.getText());
    }
    }
    @Test(description = "tiklamali olani yapiyoruz")
    public void nonSelectDropDown(){
    WebElement dropdown=driver.findElement(By.id("dropdownMenuLink"));
    dropdown.click();
    BrowserUtils.wait(1);
    WebElement option=driver.findElement(By.xpath("//a[@href='https://www.amazon.com/']"));
    option.click();
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
