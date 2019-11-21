package Homeworks.Basic_Navigation;

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

public class Test_Cases_2_1 {
    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver=BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Registration Form")).click();

    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @Test
    public void test1(){
    driver.findElement(By.name("birthday")).sendKeys("wrong_dob");
    String actual=driver.findElement(By.xpath("//small[contains(text(),' is not valid')]")).getText();

    String expected="The date of birth is not valid";
        Assert.assertEquals(actual,expected);
    }
    @Test
    public void test2(){
        String actual_languages="C++JavaJavaScript";
        String expected_languages="";
        expected_languages+=driver.findElement(By.cssSelector("[for='inlineCheckbox1']")).getText();
        expected_languages+=driver.findElement(By.cssSelector("[for='inlineCheckbox2']")).getText();
        expected_languages+=driver.findElement(By.cssSelector("[for='inlineCheckbox3']")).getText();



        System.out.println(expected_languages);

        Assert.assertEquals(expected_languages,actual_languages);
    }
    @Test
    public void test3(){
        driver.findElement(By.name("firstname")).sendKeys("a");
       String actual= driver.findElement(By.xpath("//small[contains(text(),'first name must')]")).getText();
        String expected="first name must be more than 2 and less than 64 characters long";
        Assert.assertEquals(actual,expected);
    }
    @Test
    public void test4(){
        driver.findElement(By.name("lastname")).sendKeys("a");
        String actual= driver.findElement(By.xpath("//small[contains(text(),'The last name')]")).getText();
        String expected="The last name must be more than 2 and less than 64 characters long";
        Assert.assertEquals(actual,expected);
    }
    @Test
    public void test(){
     driver.findElement(By.name("firstname")).sendKeys("Josh");
     driver.findElement(By.name("lastname")).sendKeys("Stone");
     driver.findElement(By.name("username")).sendKeys("JStone");
     driver.findElement(By.name("email")).sendKeys("jstone@gmail.com");
     driver.findElement(By.name("password")).sendKeys("12345678");
     driver.findElement(By.name("phone")).sendKeys("123-456-7890");
     driver.findElement(By.cssSelector("[value='male']")).click();
     driver.findElement(By.name("birthday")).sendKeys("10/10/2000");


     //Now we move to dropdowns

     WebElement departments=driver.findElement(By.name("department"));
        Select selecting1=new Select(departments);
        selecting1.selectByVisibleText("Tresurer's Office");

     WebElement jobTitle=driver.findElement(By.name("job_title"));
     Select selecting2=new Select((jobTitle));
     selecting2.selectByVisibleText("QA");

     driver.findElement(By.id("inlineCheckbox2")).click();

     driver.findElement(By.id("wooden_spoon")).click();
        BrowserUtils.wait(3);

        String actualHeading=driver.findElement(By.tagName("h4")).getText();
        String actualWrite=driver.findElement(By.xpath("//p")).getText();

        String expectedHeading="Well done!";
        String expectedWrite="You've successfully completed registration!";

        Assert.assertEquals(actualHeading,expectedHeading);
        Assert.assertEquals(actualWrite,expectedWrite);


    }
}
