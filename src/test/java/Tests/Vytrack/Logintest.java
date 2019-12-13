package Tests.Vytrack;

import Tests.TestBase;
import Utils.BrowserFactory;
import Utils.BrowserUtils;
import Utils.ConfigurationReader;
import Utils.Driver;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;


public class Logintest extends TestBase {
    @Ignore
    @Test
    public void test1(){
        String url= ConfigurationReader.getProperty("url");
        Driver.get().get(url);
        BrowserUtils.wait(2);
        System.out.println(Driver.get().getTitle());
        Driver.close();

    }
    @Test
    public void test2(){
        System.out.println(Driver.get().getTitle());
        BrowserUtils.wait(2);
    }
}
