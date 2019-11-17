package Tests.day6;

import Utils.BrowserFactory;
import Utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BitrixLogin {
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        //go to bitrix
        driver.get("https://login1.nextbasecrm.com/?login=yes");
        //find username func            buraya ilk deger. input,div gibi
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("marketing39@cybertekschool.com");
        BrowserUtils.wait(3);
        driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("UserUser");
        BrowserUtils.wait(3);
        driver.findElement(By.xpath("//input[contains(@onclick,'BX.add')]")).click();
        BrowserUtils.wait(3);


        /*
        //input[@name='USER_LOGIN']
        //*[placeholder='PASSWORD']
        //input[starts-with(@onclick,  'BX')]
        //*[contains(@title,'Activity Stream')]

         */
    }


}
