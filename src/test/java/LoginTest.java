import com.po.DataSources.LoginDataSource;
import com.po.logic.LoginLogic;
import com.po.page.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2018/8/17.
 */
public class LoginTest {
    WebDriver driver;
    @BeforeMethod
    public  void  driver()
    {
        System.setProperty("webdriver.chrome.driver","F:\\测试资料\\javaday1\\drivers\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.get("https://mail.126.com/");
    }
    //带两个参数,指定到特定的节点运行
    @DataProvider(name="userList")
    public Object[][] test2()
    {
        return LoginDataSource.loginDataSource();
    }
  @Test (dataProvider = "userList")
    public  void  loginTest(String userName,String paw) throws InterruptedException {
        Thread.sleep(3000);
        //控制权转到frame
        driver.switchTo().frame("x-URS-iframe");
        //定位、输入用户名
        //定位、输入密码
        //点击登录
      LoginLogic.login(userName,paw,driver);
        Thread.sleep(5000);
     /* Boolean bl=driver.findElement(By.linkText("更换手机")).isDisplayed();
        Assert.assertTrue(bl);*/
        //driver.findElement(By.xpath(".//*[test()='登录']")).click();
    }
    public  void  loginTest(WebDriver driver) throws InterruptedException {
        Thread.sleep(3000);
        //控制权转到frame
        driver.switchTo().frame("x-URS-iframe");
        //定位、输入用户名
        //定位、输入密码
        //点击登录
        LoginLogic.login("cpp290089557","cpp1001",driver);
        Thread.sleep(5000);
     /* Boolean bl=driver.findElement(By.linkText("更换手机")).isDisplayed();
        Assert.assertTrue(bl);*/
        //driver.findElement(By.xpath(".//*[test()='登录']")).click();
        Thread.sleep(3000);
    }
    //登录方法
   /* public  void  login(String email,String password,WebDriver driver){
        //定位、输入用户名
        driver.findElement(LoginPage.userName).sendKeys(email);
        //定位、输入密码
        driver.findElement(LoginPage.paw).sendKeys(password);
        //点击登录
        driver.findElement(LoginPage.loginBottom).click();
    }*/
    //  显示等待
    public  void waitTest(By by)
    {
        //显示等待
        WebDriverWait wait=new WebDriverWait(driver,10);
        //定位元素获取内容
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
    @AfterMethod
    public  void  quit()
    {
        driver.quit();
    }
}
