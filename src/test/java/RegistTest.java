import org.apache.xpath.operations.String;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2018/8/17.
 */
public class RegistTest {
    WebDriver  driver;
  @BeforeMethod
    public  void  driver()
  {
      System.setProperty("webdriver.chrome.driver","F:\\测试资料\\javaday1\\drivers\\chromedriver.exe");
      driver= new ChromeDriver();
      driver.get("https://mail.163.com/");
  }
  @Test
  public  void registTest() throws InterruptedException {
      Thread.sleep(3000);
//  将控制权转交给frame:传入String，name或id
      driver.switchTo().frame("x-URS-iframe");
//点击注册
    // driver.findElement(By.id("changepage")).click();
      driver.findElement(By.linkText("去注册")).click();
//获得原有窗口的handle
      java.lang.String handle=driver.getWindowHandle();
// 打开新窗口，将控制权转换到新窗口
      for (java.lang.String  handles:driver.getWindowHandles()) {
          if(handles.equals(handle))
          continue;
          driver.switchTo().window(handles);

      }
      //显示等待
      By by=By.id("nameIpt");
      waitTest(by);
// 输入邮件地址、密码、确认密码、手机号码、验证码，短信验证码(验证码舍去)
     java.lang.String mainMobileIpt= java.lang.String.valueOf(System.currentTimeMillis()/100);//时间方法，每秒加1，只要不是同时并发很多条，一次插入一条，不会重复
      driver.findElement(By.id("nameIpt")).sendKeys("cpp18702750131");
      driver.findElement(By.id("mainPwdIpt")).sendKeys("cpp1001");
      driver.findElement(By.id("mainCfmPwdIpt")).sendKeys("cpp1001");
      driver.findElement(By.id("mainMobileIpt")).sendKeys(mainMobileIpt);
      driver.findElement(By.id("vcodeIpt")).sendKeys("123468");//验证码
      driver.findElement(By.id("mainAcodeIpt")).sendKeys("123468");//手机验证码*/
      driver.findElement(By.id("mainRegA")).click();
      Thread.sleep(3000);



  }
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
