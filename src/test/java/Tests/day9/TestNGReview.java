package Tests.day9;

import Utils.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
/*
@Test annotation is req. Everything is optional


After-Before Method==>after and before every test

After-Before Class==> after and before every class

After-Before Suite==> runs as a precondition for entire test suite. Test suite can include tests for multiple
test classes

 */

public class TestNGReview {
    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        System.out.println("Before method");
       driver= BrowserFactory.getDriver("chrome");
    }
    @AfterMethod
    public void teardown(){
        System.out.println("After method");
        driver.quit();
    }
    @Test
    public void test1(){
        System.out.println("Test method");
        driver.get("http://google.com");
        String actualTitle="Google";
        String realTitle=driver.getTitle();
        Assert.assertEquals(actualTitle,realTitle);
    }
    @Test(priority = 1)
    public void test2(){
        driver.get("http://apple.com");
        String actualTitle="Apple";
        String realTitle=driver.getTitle();
        Assert.assertEquals(actualTitle,realTitle);
    }
    // data proivider can supply test with a test data. Also it allows to do Data Driven Testing
    //What is thi? its when same test runs multiple times with different test data set
    @DataProvider(name="testData")
    public static Object[][] testData(){
        return new Object[][]{{"http://apple.com","Apple"},
                    {"http://google.com","Google"}};
    }
    //data provider must return 2d array of object
    //1st parameter= 1 object in the inner array,2 nd parameter= 2 object in the inner array
    //url=https://apple.com/, title=Apple
    //url=https://google.com/, title=Google
    //we can have as many sets of data as we want
    @Test(dataProvider = "testData")
    public void testWithDataProvider(String url,String title){
        driver.get(url);
        Assert.assertEquals(driver.getTitle(),title);
    }
}
