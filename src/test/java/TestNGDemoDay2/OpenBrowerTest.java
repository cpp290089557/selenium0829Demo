package TestNGDemoDay2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import   org.testng.annotations.Test;
/**
 * Created by Administrator on 2018/8/9.
 */
public class OpenBrowerTest {
    /*启动火狐浏览器*/
    @Test
    public  void  openFF()
    {


        WebDriver  webDriver = new FirefoxDriver();/*默认安装是这么写，在c盘*/
        webDriver.get("http://www.baidu.com");
    }

    /*启动谷歌浏览器*/
    @Test
    public  void  openChrome()
    {

        System.setProperty("webdriver.chrome.driver","F:/测试资料/javaday1/drivers/chromedriver.exe"); /*谷歌要下载相应版本的webdriver*/

        WebDriver  webDriver = new ChromeDriver();
        webDriver.get("http://www.baidu.com");

    }
    /*启动IE浏览器*/
    @Test
    public  void  openIE()
    {

        System.setProperty("webdriver.ie.driver","F:/测试资料/javaday1/drivers/IEDriverServer.exe"); /*IE要下载webdriver，对版本要求不是很高*/

        WebDriver  webDriver = new InternetExplorerDriver();
        webDriver.get("http://www.baidu.com");

    }

}
