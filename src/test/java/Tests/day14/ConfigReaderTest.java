package Tests.day14;

import Utils.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;
/*
browser=chrome
#Brower type
url=https://qa1.vytrack.com/
#This is the url of web application

#Credentials
user_name=storemanager85
password=UserUser123
 */
public class ConfigReaderTest {
    @Test
    public void test1(){
        String expectedBrowser="chrome";// diger sinifta olusturduk
        String actualBrowser= ConfigurationReader.getProperty("browser");
        Assert.assertEquals(actualBrowser,expectedBrowser);
        System.out.println(ConfigurationReader.getProperty("url"));

        System.out.println("URL: "+ConfigurationReader.getProperty("url"));
        System.out.println("Username: "+ConfigurationReader.getProperty("user_name"));
        System.out.println("Password: "+ConfigurationReader.getProperty("password"));


    }
}
