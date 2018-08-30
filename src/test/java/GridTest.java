import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2018/8/27.
 */
public class GridTest
{
  @Test
    public  void  gridTest() throws MalformedURLException, InterruptedException {
      DesiredCapabilities  dc=DesiredCapabilities.chrome();
      //由hub依次分发
//      WebDriver driver=new RemoteWebDriver(new URL("http://192.168.0.41:4444/wd/hub"),dc);
//      指定节点执行
      WebDriver driver=new RemoteWebDriver(new URL("http://192.168.0.41:7772/wd/hub"),dc);

      driver.get("http://www.baidu.com");
      Thread.sleep(3000);
      driver.quit();
  }
//  带一个参数
  @DataProvider(name="data4")
    public Object[][] test1()
  {

      return new Object[][]{
              {"firefox"},
              {"chrome"},
              {"ie"}
      };

  }
@Test(dataProvider = "data4")
    public  void  gridTest1(String browser) throws MalformedURLException, InterruptedException {
  DesiredCapabilities dc=null;
    if(browser.contentEquals("firefox"))
    {dc=DesiredCapabilities.firefox();}
    else if(browser.contentEquals("chrome"))
    {dc=DesiredCapabilities.chrome();}
    else {dc=DesiredCapabilities.internetExplorer();}
    WebDriver driver=new RemoteWebDriver(new URL("http://192.168.0.41:4444/wd/hub"),dc);
    driver.get("http://www.baidu.com");
    Thread.sleep(3000);
    driver.quit();
}
//带两个参数,指定到特定的节点运行
@DataProvider(name="data5")
public Object[][] test2()
{

  return new Object[][]{
          {"firefox","http://192.168.0.41:7771/wd/hub"},
          {"chrome","http://192.168.0.41:7772/wd/hub"},
          {"ie","http://192.168.0.41:7772/wd/hub"}
  };

}
  @Test(dataProvider = "data5")
  public  void  gridTest2(String browser,String strUrl) throws MalformedURLException, InterruptedException {
    DesiredCapabilities dc=null;
    if(browser.contentEquals("firefox"))
    {dc=DesiredCapabilities.firefox();}
    else if(browser.contentEquals("chrome"))
    {dc=DesiredCapabilities.chrome();}
    else {dc=DesiredCapabilities.internetExplorer();}
    WebDriver driver=new RemoteWebDriver(new URL(strUrl),dc);
    driver.get("http://www.baidu.com");
    Thread.sleep(3000);
    driver.quit();
  }
}
