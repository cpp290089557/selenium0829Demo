import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2018/8/21.
 */
public class UpLoad {
    WebDriver driver;
    @BeforeMethod
    public   void driver()
    {
        System.setProperty("webdriver.chrome.driver","F:\\测试资料\\javaday1\\drivers\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.get("https://mail.126.com/");

    }
    @Test
    public  void  upload() throws InterruptedException {
 //        登录
        LoginTest  loginTest= new LoginTest();
        loginTest.loginTest(driver);
//        获取写信元素，点击写信，进入写信页面
 WebElement we= driver.findElement(By.xpath(".//*[@id='dvNavTop']/ul/li[2]/span[2]"));
        we.click();
        Thread.sleep(3000);
//  定位收件人，输入收件人
        //driver.findElement(By.xpath(" .//*[@id='dvContainer'] /div[2]/div[1]/section/header/div/div/div/div[2]/div[1]/input")).sendKeys("cpp290089557@126.com");
        driver.findElement(By.className("nui-editableAddr-ipt")).sendKeys("cpp290089557@126.com");
//        主题
       driver.findElement(By.xpath(" .//*[@id='dvContainer'] /div[2]/div[1]/section/header/div[2]/div/div/div/input")).sendKeys("自动化测试");

//控制权交给frame
        WebElement webElement=driver.findElement(By.className("APP-editor-iframe"));
        driver.switchTo().frame(webElement);
        //内容
        driver.findElement(By.xpath("html/body")).sendKeys("你好，8月！你好，8月！你好，8月！你好，8月！你好，8月！你好，8月！");
//        控制权转交给默认页面
        driver.switchTo().defaultContent();
//        点击发送
//   driver.findElement(By.xpath(".//*[text()='发送']")).click();
        WebElement webElement1=driver.findElement(By.xpath(" .//*[@id='dvContainer'] /div[2]/div[1]/section/footer /div[1]/span[2]"));
        //强制转换为js执行。click事件
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();",webElement1);
        Thread.sleep(3000);
//        校验是否发送成功,
Boolean bl=driver.findElement(By.xpath(".//*[text()='发送成功']")).isDisplayed();
Assert.assertTrue(bl);

        Thread.sleep(3000);
    }
    @AfterMethod
    public  void  quit()
    {
        driver.quit();
    }
}
