package com.meyouny.day1;
import org.junit.After;
import org.testng.annotations.*;

/**
 * Created by Administrator on 2018/8/9.
 */
public class TestNGDemo1 {

    @BeforeTest
    public void beforeTest01() {
        System.out.println("这是@BeforeTest注解1");
    }

    @BeforeMethod
    public void beforeMethod01() {
        System.out.println("这是@BeforeMethod注解1");
    }
@Test
    public void  testCase1() {
    System.out.println("这是@Test注解1");
}
    @Test
    public void  testCase2(){
        System.out.println("这是@Test注解2");

}
    @Test
    public void  aestCase3(){
        System.out.println("这是@Test注解3");

    }
@AfterTest

    public void afterTest01() {
        System.out.println("这是@AfterTest注解1");
    }
@AfterMethod
    public void afterMethod01() {
        System.out.println("这是@AfterMethod注解1");
    }
}
