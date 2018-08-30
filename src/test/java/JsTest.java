import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2018/8/16.
 */
public class JsTest {
    WebDriver driver;
    @BeforeMethod
    public  void setDriver(){
        System.setProperty("webdriver.chrome.driver","F:\\测试资料\\javaday1\\drivers\\chromedriver.exe");
        driver=new ChromeDriver();
    }
    //执行JS
    @Test
    public  void  jsTest() throws InterruptedException {
driver.get("http://www.baidu.com");
        //强制转换为JavascriptExecutor
        JavascriptExecutor  js=(JavascriptExecutor)driver;
        //执行JS
        js.executeScript("document.getElementById(\"kw\").setAttribute(\"value\",\"执行JS\")");
        Thread.sleep(10000);
    }
    //使用PhantomJS驱动
    @Test
    public void  phantomJs() throws InterruptedException {
        System.setProperty("phantomjs.binary.path","F:\\测试资料\\javaday1\\drivers\\phantomjs.exe");
        PhantomJSDriver  phantomJSDriver=new    PhantomJSDriver();
        phantomJSDriver.get("http://www.baidu.com");
       Thread.sleep(3000);
        phantomJSDriver.quit();
    }
    @AfterMethod
    public  void  quit(){

        driver.quit();
    }
}
