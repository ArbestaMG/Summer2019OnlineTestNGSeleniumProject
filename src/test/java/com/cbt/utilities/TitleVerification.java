package com.cbt.utilities;

import Utils.BrowserFactory;
import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TitleVerification {
    public static void main(String[] args) {
        List<String> urls = Arrays.asList("http://practice.cybertekschool.com/",
                "http://practice.cybertekschool.com/dropdown", "http://practice.cybertekschool.com/login");

        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get(urls.get(0));
        String zerotTitle=driver.getTitle();
        BrowserUtils.wait(3);

        driver.get(urls.get(1));
        String firstTitle=driver.getTitle();
        BrowserUtils.wait(3);

        driver.get(urls.get(2));
        String secondTitle=driver.getTitle();
        BrowserUtils.wait(3);

        if(zerotTitle.equals(firstTitle) && firstTitle.equals(secondTitle)){
            System.out.println("Test passed");
        }
        else{
            System.out.println("Test failed");
        }
        driver.close();
    }
}
