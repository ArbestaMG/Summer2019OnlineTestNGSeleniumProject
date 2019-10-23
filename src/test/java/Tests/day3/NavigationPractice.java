package Tests.day3;

import Utils.BrowserFactory;
import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;

public class NavigationPractice {
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome" );
        driver.manage().window().maximize();// to maximize browser
        driver.get("http://google.com");
        BrowserUtils.wait(3);// bu metodu biz olusturduk
        driver.navigate().to("http://facebook.com");
        driver.navigate().back();// geri google gel
        driver.navigate().forward();// facebooka don
        driver.navigate().refresh();// sayfayi yenile



        //driver.quit();
        //bunu yaparsak  sistem kapanir,sonraki kodlar olu kod olur
        driver.get("http://amazon.com");
        driver.getTitle();
        driver.quit();
        /*
       getTilte() - to get page title
getCurrentUrl() - to get URL of the current website
close() - to close current tab. it's it's a last tab - it will also shutdown a browser and session.
quit() - to close all tabs that were opened by webdriver.
navigate().to(URL) - to jump to other website. It will not open a new tab/browser.
navigate().back() - comeback to previous website
navigate().forward() - to move forward in the browser history. Usually, used after navigate().back().
navigate().refresh() - to refresh a website.
manage().window().maximize() - to maximize window
manage().window().fullscreen() - to run browser in the fullscreeen mode

         */
    }
}
