package Tests.day1;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstSeleniumScript {
    public static void main(String[] args) {
        //we have to setup webdriver based on the browser that we gonna use
        System.setProperty("webdriver.chrome.driver","/path/chromedriver");

        WebDriverManager.chromedriver().setup();// buradaki chromedriver a firefoxdriver yaparsak firefoxa doner
        //we need to create an object of appropriate class
        ChromeDriver driver = new ChromeDriver();// buradaki icin de usttekinin aynisi
        //let's open google.com
        driver.get("http://google.com");
        // to read page title, there is method .getTitle()
        String actualResult=driver.getTitle();
        String expectedResult="Google" ;// title yani arama motorunda bunun yazdigini kontrol ediyoruz.
        if(actualResult.equals(expectedResult)){
            System.out.println("Test pass");
        }
        else{
            System.out.println("Test fail");
        }
            //to close browser
            driver.close();

    }
}
