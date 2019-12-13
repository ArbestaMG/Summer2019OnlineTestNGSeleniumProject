package Tests.day12;

import Utils.BrowserFactory;
import Utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragAndDropPractice {
    private WebDriver driver;
    @Test
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();

        // click on accept cookies
        driver.findElement(By.cssSelector("button[title='Accept Cookies']")).click();
        Actions actions=new Actions(driver);

        WebElement moon= driver.findElement(By.id("draggable"));
        WebElement earth=driver.findElement(By.id("droptarget"));
        BrowserUtils.wait(2);

        actions.dragAndDrop(moon,earth).perform();
        BrowserUtils.wait(2);

        driver.quit();
    }
}
