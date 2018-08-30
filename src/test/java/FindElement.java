import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import  org.testng.annotations.*;

import java.util.List;

/**
 * Created by Administrator on 2018/8/13.
 */
public class FindElement {
   WebDriver driver;
     @BeforeMethod
    public void setDriver()
     {
         //设置Chromedriver路径
         System.setProperty("webdriver.chrome.driver","F:\\测试资料\\javaday1\\drivers\\chromedriver.exe");
         //实例化driver
         driver =  new ChromeDriver();

     }
     //通过ID获得
     @Test
    public void  byId()
     {
        driver.get("http://www.baidu.com");
       WebElement  el=driver.findElement(By.id("su"));

     }

    //通过className获得
    @Test
    public void  byClassName()
    {
        driver.get("http://www.baidu.com");
        WebElement  el=driver.findElement(By.className("mnav"));
    }
    //通过LinkTest获得
    @Test
    public void  byLinkTest()
    {
        driver.get("http://www.baidu.com");
        WebElement  el=driver.findElement(By.linkText("新闻"));
    }
    //通过LinkTest获得
    @Test
    public void  byPartialLinkTest()
    {
        driver.get("http://www.baidu.com");
        WebElement  el=driver.findElement(By.partialLinkText("hao"));
    }
    //通过节点名获得
    @Test
    public void  byTagName()
    {
        driver.get("http://www.baidu.com");
       // WebElement  el=driver.findElement(By.tagName("input"));
       List<WebElement> list=driver.findElements(By.tagName("input"));
        System.out.println("ddd"+list.get(0).getText());

    }
    //通过xpath路径获得
    @Test
    public void  byXpath()
    {
        driver.get("http://www.baidu.com");
        // ".//*[@id='']"
        List<WebElement> list =driver.findElements(By.xpath(".//*[@id='search-key']"));
        for (int i = 0; i < list.size(); i++) {
 System.out.println(list.get(i).getText());
        }
    }
    //通过cssSelector(css路径)路径获得
    @Test
    public void  byCssSelector()
    {
        driver.get("http://www.baidu.com");
        // ".//*[@id='']"
        List<WebElement> list =driver.findElements(By.xpath(".//*[@id='search-key']"));
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getText());
        }
    }
@AfterMethod
    public  void  quit(){

    driver.quit();
}
}
