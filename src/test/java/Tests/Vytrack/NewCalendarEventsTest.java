package Tests.Vytrack;

import Tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;


public class NewCalendarEventsTest extends TestBase {



    @Test(description = "Verify that page subtitle is equals to 'All Calendar Events'")
    public void test1() {
        extentTest=extentReports.createTest("Verify that page subtitle is equals to 'All Calendar Events'");

        LoginPage loginPage = new LoginPage(); //login page object

        loginPage.login("storemanager85", "UserUser123");
        loginPage.navigateTo("Activities", "Calendar Eventseee");
                                                            //Events olacakti,ss icin degistirdim

        String expectedSubtitle = "All Calendar Events";
        String actualSubTitle = loginPage.getPageSubTitle();

        Assert.assertEquals(actualSubTitle, expectedSubtitle);

        extentTest.pass("Verify that page subtitle 'All Calendar Events' is displayed");
    }
}