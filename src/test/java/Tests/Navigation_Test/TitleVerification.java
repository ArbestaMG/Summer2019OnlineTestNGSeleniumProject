package Tests.Navigation_Test;

import Utils.BrowserFactory;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class TitleVerification {
    public static void main(String[] args) {
        ArrayList<String> urls= new ArrayList<>();
        urls.add("http://practice.cybertekschool.com/");
        urls.add("http://practice.cybertekschool.com/dropdown");
        urls.add( "http://practice.cybertekschool.com/login");
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get(urls.get(0));

        driver.get(urls.get(1));
        driver.get(urls.get(2));

    }
}