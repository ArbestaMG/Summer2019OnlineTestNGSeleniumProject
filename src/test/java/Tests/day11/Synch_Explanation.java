package Tests.day11;

public class Synch_Explanation {
}
/*
Waits in selenium: implicit,explicit,fluent

IF selenium is coming before element appear - you will get NoSuchElementExpectation

Sychnronizaton is one the biggest issue in Selenium WebDriver. Selenium  does not adjust automatically.
To overcome these issues we used to use Thread.sleep(2000)

Whats the problem with this solution?

Thread.sleep(2000) will stop your test script, no matter element is available or no for fixed amount of time

Thread.sleep(20000) lets say we put on pause our test for 20 seconds.Even though element
was available after 3 seconds, still your script will be on hold for 20 seconds, We are increasing execution
time, thus we are loosin money.


ImplicitWait - will help to wait for apperance element, withing given time frame

lets say you specified implicit wait time 10 seconds, and if element was found faster, lets say in 2 seconds,
your test will continue running and will no wait for extra 8 seconds. In after 10 seconds, element was not found
you will get NoSuchElementException.

ImplicitWait should be specified only once, at the beginning.It will apply automatically before every
FindElement() method call.

**************************************************************************************************************

ExplicitWait - It works in similar way as implicit wait, but explicit wait targets specific element with a
specific condition

Implicit resolves only one problem: presence of element
Explicit wait resolves more problems: presence of element,visibility,clickability,stalenes of elemetn

Every 500 miliseconds selenium will check if condition is met.If not, it will keep checking within given time

wait until page is loaded handled automatically by selenium, but other conditions - no

Page is fully loaded,but element can delay, or be invisible or not intractable

 Element can be sibile but not clickable

 ***********************************************************************************************************

 Fluent wait -  it work like explicit wait, but except one difference - you can change polling time.
 Explicit wait checks condition every 500 miliseconds. with a fluent wait, you can change this polling time.
 I would say that Fluent wait its like custom explicit wait.
 */