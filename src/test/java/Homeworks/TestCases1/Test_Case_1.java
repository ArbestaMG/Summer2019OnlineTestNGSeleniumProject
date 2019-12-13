package Homeworks.TestCases1;

import Utils.BrowserFactory;
import Utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class Test_Case_1 {
    private WebDriver driver;
    @BeforeMethod(description = "going to website")
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
    }
    @Test(description = "Test Case1")
    public void Test1(){
        //find the sign up with mail functionality
       WebElement element=driver.findElement(By.xpath("//a[@href='/sign_up']"));
       element.click();

        //find the full name part
       WebElement element1=driver.findElement(By.cssSelector("[name='full_name']"));
       element1.sendKeys("Johny Trying");

        // find the email part
       WebElement element2=driver.findElement(By.cssSelector("[name='email']"));
       element2.sendKeys("Trying@gmail");

       //click signup button
       WebElement button1=driver.findElement(By.cssSelector("[class='radius']"));
       button1.click();

        WebElement realheading=driver.findElement(By.cssSelector("[name='signup_message']"));
       String realtext= realheading.getText();
        String expectedText="Thank you for signing up. Click the button below to return to the home page.";
        Assert.assertEquals(realtext,expectedText,"Something is wrong");

        driver.findElement(By.xpath("//i[@class='icon-2x icon-signout']")).click();
        driver.quit();

    }
    @Test(description = "Test Case2")
    public void Test2(){
        // finding the numbers of listed examples
        List<WebElement> totalNum =driver.findElements(By.cssSelector("[class='list-group-item']"));
        // supposed to be 48
        Assert.assertEquals(totalNum.size(),48);

    }
    @Test(description = "Test Case3")
    public void Test3(){
       WebElement element= driver.findElement(By.linkText("Multiple Buttons"));
       element.click();
        BrowserUtils.wait(2);
       WebElement element1=driver.findElement(By.xpath("//button[@onclick='button1()']"));
       element1.click();
        BrowserUtils.wait(2);

        String realText=driver.findElement(By.cssSelector("#result")).getText();
        System.out.println(realText);
        Assert.assertEquals(realText,"Clicked on button one!");

    }
    @Test(description = "Test Case4")
    public void Test4(){
        WebElement element= driver.findElement(By.linkText("Registration Form"));
        element.click();

        WebElement element1=driver.findElement(By.name("firstname"));
        element1.sendKeys("123");

        String realText=driver.findElement(By.xpath("//small[@class='help-block'  and  @style='display: block;']")).getText();

        Assert.assertEquals(realText,"first name can only consist of alphabetical letters");

    }
    @Test(description = "Test Case5")
    public void Test5() {
        WebElement element= driver.findElement(By.linkText("Registration Form"));
        element.click();

        WebElement element1=driver.findElement(By.name("lastname"));
        element1.sendKeys("123");

        String realText=driver.findElement(By.xpath("//small[contains(text(),'The last name can only ')]")).getText();
        Assert.assertEquals(realText,"The last name can only consist of alphabetical letters and dash");


    }
    @Test(description = "Test Case6")
        public void Test6(){
        WebElement element= driver.findElement(By.linkText("Registration Form"));
        element.click();

        WebElement element1=driver.findElement(By.cssSelector("[name='username']"));
        element1.sendKeys("user");

        String realText= driver.findElement(By.xpath("//small[@style='display: block;']")).getText();
        Assert.assertEquals(realText,"The username must be more than 6 and less than 30 characters long");
        }
    @Test(description = "Test Case7")
    public void Test7(){
        WebElement element= driver.findElement(By.linkText("Registration Form"));
        element.click();

        WebElement element1=driver.findElement(By.name("email"));
        element1.sendKeys("testers@email");

        String realText=driver.findElement(By.xpath("//small[contains(text(), 'email address is not a valid')]")).getText();
        realText+=driver.findElement(By.xpath("//small[contains(text(), 'Email format is not correct')]")).getText();
        System.out.println(realText);

    }
    @Test(description = "Test Case8")
    public void test8(){
        WebElement element= driver.findElement(By.linkText("Registration Form"));
        element.click();

        WebElement element1=driver.findElement(By.name("phone"));
        element1.sendKeys("5711234354");

        String realText=driver.findElement(By.xpath("//small[@data-bv-validator='regexp' and @data-bv-for='phone']")).getText();

        Assert.assertEquals(realText,"Phone format is not correct");

    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
