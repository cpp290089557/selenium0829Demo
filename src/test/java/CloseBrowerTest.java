import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2018/8/10.
 */
public class CloseBrowerTest {
    WebDriver driver;
    @BeforeMethod
    public void  beforeMethod(){
        //设置Chromedriver路径
        System.setProperty("webdriver.chrome.driver","F:\\测试资料\\javaday1\\drivers\\chromedriver.exe");
        //实例化driver
          driver =new ChromeDriver();
    }
    //关闭当前窗口
    @Test
    public  void  browerClose() throws InterruptedException {

        Thread.sleep(5000);
        driver.close();
    }
    //关闭所有窗口，并退出浏览器
    @Test
    public  void  browerQuit() throws InterruptedException {

        //打开百度
        driver.get("http://www.baidu.com");
        Thread.sleep(5000);//有异常要抛出，单位为毫秒；
        driver.quit();
    }
    //浏览器后退
    @Test
    public  void  browerBack() throws InterruptedException {

        //打开百度
        driver.get("http://www.baidu.com");
        //等待3s
        Thread.sleep(3000);//有异常要抛出，单位为毫秒；
        //后退
        driver.navigate().back();
        //等待3s
       Thread.sleep(3000);
        //关闭浏览器
        driver.quit();
    }
    //浏览器前进
    @Test
    public  void  browerForward() throws InterruptedException {

        //打开百度
        driver.get("http://www.baidu.com");
        //等待3s
        Thread.sleep(3000);//有异常要抛出，单位为毫秒；
        //后退
        driver.navigate().back();
        //等待3s
        Thread.sleep(3000);//有异常要抛出，单位为毫秒；
        //前进
        driver.navigate().forward();
        //等待3s
        Thread.sleep(3000);
        //关闭浏览器
        driver.quit();
    }
    //浏览器刷新
    @Test
    public  void  browerRefresh() throws InterruptedException {

        //打开百度
        driver.get("http://www.baidu.com");//get方法一定会等当前操作完成后再往下走
        //等待3s
        Thread.sleep(3000);//有异常要抛出，单位为毫秒；
        //浏览器刷新
        driver.navigate().refresh();
        //等待3s
        Thread.sleep(3000);//有异常要抛出，单位为毫秒；
        //关闭浏览器
        driver.quit();
    }
    //浏览器窗口设置及最大化
    @Test
    public  void  browerWindow() throws InterruptedException {

        //打开百度
        driver.get("http://www.baidu.com");//get方法一定会等当前操作完成后再往下走
        //实例化一个Dimension新类,设置窗口大小，宽，高
        Dimension dimension = new Dimension(500,500);
        driver.manage().window().setSize(dimension);
        //等待3s
        Thread.sleep(3000);//有异常要抛出，单位为毫秒；
        //窗口最大化
        driver.manage().window().maximize();
        //等待3s
        Thread.sleep(3000);//有异常要抛出，单位为毫秒；
        //关闭浏览器
        driver.quit();
    }
    //获取浏览器路径
    @Test
    public  void  broweUrl() throws InterruptedException {

        //打开百度
        driver.get("http://www.baidu.com");//get方法一定会等当前操作完成后再往下走
       //获取浏览器地址
        String url =driver.getCurrentUrl();
        //比较浏览器地址
        System.out.println("地址"+url);
        Assert.assertEquals(url,"https://www.baidu.com/");
        //等待3s
        Thread.sleep(3000);//有异常要抛出，单位为毫秒；

    }
    @AfterMethod
   public  void quitBrower()
   {
        //关闭浏览器
      driver.quit();
   }

}
