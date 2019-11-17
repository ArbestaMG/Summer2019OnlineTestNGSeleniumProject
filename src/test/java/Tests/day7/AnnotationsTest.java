package Tests.day7;

import org.testng.Assert;
import org.testng.annotations.*;

public class AnnotationsTest {
/*
Beforeclass= hepsinden once 1 kere calisir
BeforeMethod= her methoddan once calisir
Test=sirasi gelince calisir
AfterMethod= her methoddan sonra calisir
AfterClass= her class calisir biter, en son bu 1 kez calisir.
 */
    @AfterClass
    public void afterClass(){
    System.out.println("After Class");
}

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class");
    }
    @BeforeMethod
    public void setup(){
        // some code that will be runnin before every test, like test1, test2,test3.
        // we can use method with @BeforeMethod Annotion
        // bu method her seferinde calisir.
        System.out.println("Before method");
    }
    @AfterMethod
    public void teardown(){
        System.out.println("After Method!");
    }
    @Test
    public void test1() {
        System.out.println("Test 1!");
        Assert.assertTrue(5==5);
    }
    @Test
    public void test2(){
        System.out.println("Test 2");
    }
    @Test
    public void test3(){
        System.out.println("Test 3");
    }
}
