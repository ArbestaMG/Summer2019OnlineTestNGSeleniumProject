package com.cbt.utilities;

import Utils.BrowserFactory;
import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class TitleVerification2 {




    public static void main(String[] args) {

        ArrayList<String> urls = new ArrayList<>();
        urls.add("https://www.luluandgeorgia.com/");
        urls.add("https://wayfair.com/");
        urls.add("https://westelm.com/");

        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get(urls.get(0));
        String zerotTitle = driver.getTitle().toLowerCase();


        driver.get(urls.get(1));
        String firstTitle = driver.getTitle().toLowerCase();


        driver.get(urls.get(2));
        String secondTitle = driver.getTitle().toLowerCase();




        zerotTitle = zerotTitle.replaceAll(" ", "");
        firstTitle = firstTitle.replaceAll(" ", "");
        secondTitle = secondTitle.replaceAll(" ", "");

        String url0= urls.get(0).replace("https://www.","");
        String realurl0= url0.replace(".com/","");

        String url1= urls.get(1).replace("https://","");
        String realurl1= url1.replace(".com/","");

        String url2= urls.get(2).replace("https://","");
        String realurl2= url2.replace(".com/","");

        System.out.println(zerotTitle);
        System.out.println(realurl0);
        System.out.println(firstTitle);
        System.out.println(realurl1);
        System.out.println(secondTitle);
        System.out.println(realurl2);

        Boolean A = zerotTitle.contains(realurl0);
        Boolean B = firstTitle.contains(realurl1);
        Boolean C = secondTitle.contains(realurl2);
        System.out.println(A);
        System.out.println(B);
        System.out.println(C);

        if(A==true&&B==true&&C==true){
            System.out.println("test passed");
        }
        else {
            System.out.println("fail");
        }
        driver.close();
}}
