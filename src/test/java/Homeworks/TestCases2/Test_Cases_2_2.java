package Homeworks.TestCases2;

import Utils.BrowserFactory;
import Utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_Cases_2_2 {
    private WebDriver driver;
    @Test
    public void test6(){
       driver= BrowserFactory.getDriver("chrome");
        driver.get("https://www.tempmailaddress.com");
        String fakeEmail=driver.findElement(By.id("email")).getText();

        BrowserUtils.wait(2);
        driver.navigate().to("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();

        //Enter Credentials
        driver.findElement(By.name("full_name")).sendKeys("Josh");

        driver.findElement(By.name("email")).sendKeys(fakeEmail);
        driver.findElement(By.name("wooden_spoon")).click();

        //Check the message is correct
        String actualText=driver.findElement(By.name("signup_message")).getText();
        String expectedTect="Thank you for signing up. Click the button below to return to the home page.";

        Assert.assertEquals(actualText,expectedTect);
        BrowserUtils.wait(2);
        //Making sure website got our e-mail
        driver.get("https://www.tempmailaddress.com");
        WebElement ReceivedEmail = driver.findElement(By.xpath("//td[contains(text(),'do-not-reply@practice.cybertekschool.com')]"));
        String ActualEmail = ReceivedEmail.getText();
        ActualEmail = ActualEmail.trim();
        String ExpectedEmail = "do-not-reply@practice.cybertekschool.com";
        Assert.assertEquals(ActualEmail, ExpectedEmail, "Email is not received");
        ReceivedEmail.click();

        //Verify that Thank you message is displayed in the verification email from Cybertekschool
        String fromEmail = driver.findElement(By.id("odesilatel")).getText();
        String expectedFromEmail = "do-not-reply@practice.cybertekschool.com";
        Assert.assertEquals(fromEmail, expectedFromEmail, "Wrong Sender");
        String ActualSubject = driver.findElement(By.id("predmet")).getText();
        String ExpectedSubject = "Thanks for subscribing to practice.cybertekschool.com!";
        Assert.assertEquals(ActualSubject, ExpectedSubject, "Subject line is wrong");

        driver.quit();
    }
    @Test
    public void test7(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");


        driver.findElement(By.linkText("File Upload")).click();
        BrowserUtils.wait(2);

        driver.findElement(By.id("file-upload")).sendKeys("C:/Users/OFM/Desktop/Sharing.png");
        //click submit

        BrowserUtils.wait(2);
        driver.findElement(By.id("file-submit")).click();

        BrowserUtils.wait(2);
        String expectedFileName = "Sharing.png";

        String actualFileName = driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(actualFileName, expectedFileName);
        BrowserUtils.wait(2);
        driver.quit();
    }
    @Test
    public void test8(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");


        driver.findElement(By.linkText("Autocomplete")).click();
        driver.findElement(By.id("myCountry")).sendKeys("United States of America");

        driver.findElement(By.cssSelector("[class='btn btn-primary']")).click();

        String actualText=driver.findElement(By.id("result")).getText();
        String expectedText="You selected: United States of America";

        Assert.assertEquals(actualText,expectedText);
        driver.quit();
    }


}
