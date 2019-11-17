package Tests.day7;

import Utils.BrowserFactory;
import Utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CssSelectorPractice {
    //Please use google chrome
    //Which locator to use?
    //#1 id
    //#2 css
    //#3 xpath
    //## whatever
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        //let's fin all buttons, and click on them one by one
        // why I put . instead of space? because it's 2 class names .btn.btn-primary
        //in this case, we will find all buttons that have: class="btn btn-primary"
        // or like this [class='btn btn-primary'], no need for .
        //. means class name
        //# means id
        //all buttons
        List<WebElement> buttons = driver.findElements(By.cssSelector(".btn.btn-primary"));
        //loop through list of buttons
        for (WebElement button: buttons){
            //and click on every button one by one
            button.click();
            BrowserUtils.wait(1);
            //get the message after click
            WebElement message = driver.findElement(By.cssSelector("#result"));
            //print a text of that message
            System.out.println(message.getText());
        }
        // find element with a tag name h3, that has a parent element, with class name container
        WebElement header = driver.findElement(By.cssSelector(".container > h3"));
        System.out.println(header.getText());

        WebElement p = driver.findElement(By.cssSelector("[class='container'] > p"));
        System.out.println(p.getText());

        driver.quit();
    }
}



/*
How basic CSS selector looks like:
tagName[attribute='value'] | no //, no @, xpath would look like: //tagName[@attribute='value']
IN CSS, WE CAN SPECIFY ID LIKE THIS: #id
for example: #disappearing_button
also, it work like this: [id='disappearing_button']
For class name, in css we use .
.class
example: .h3 - it means, find element with class name h3
also, it works like this: [class='h3']
If, class name has a space, that means you need to put . in between. Because, space, in the class, it's a delimiter for different classes.
<button class="btn btn-info">Click Me</button>
[class='btn btn-primary'][name='button2'] - to specify 2 attributes

How about contains?
sure, we just put * after attribute
[attribute*='value'] - value can be partial, same like contains(@attribute,'value') in xpath
[id*='d'] - example, means that some element contains d in the id value
to match beginning of the attribute value, we use caret symbol: ^

How about end of the attribute?
[id$='end_of_value'] | $ means attribute ends with value
* - contains
^ - starts with
$ - ends with
button[onclick="button4()"] or button[onclick='button4()']
in code: By.cssSelector

How we can move from parent to child element in css selector?
"space" or ">"
div input

What's the difference between space and > ? space in between means any child
 (can be grand, or grand grand child ) > means only direct child.
.container > h3 - means find element with h3 tag name, that has direct parent with class name container.
parent > child

 */