import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2018/9/1.
 */
public class Test0 {
    WebDriver driver;
    @BeforeMethod
    public void setDriver()
    {
        //设置Chromedriver路径
        System.setProperty("webdriver.chrome.driver","F:\\测试资料\\javaday1\\drivers\\chromedriver.exe");
        //实例化driver
        driver =  new ChromeDriver();

    }
    @Test
    public void  byClassName()
    {
        driver.get("http://www.baidu.com");
        WebElement el=driver.findElement(By.className("mnav"));
    }
    @AfterMethod
    public  void  quit(){

        driver.quit();
    }
}
