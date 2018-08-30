package com.po.logic;

import com.po.page.LoginPage;
import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2018/8/29.
 */
public class LoginLogic {
    //登录方法
    public static void  login(String email,String password,WebDriver driver){
        //定位、输入用户名
        driver.findElement(LoginPage.userName).sendKeys(email);
        //定位、输入密码
        driver.findElement(LoginPage.paw).sendKeys(password);
        //点击登录
        driver.findElement(LoginPage.loginBottom).click();
    }
}
