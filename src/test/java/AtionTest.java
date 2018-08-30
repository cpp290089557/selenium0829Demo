import com.sun.glass.events.KeyEvent;
import com.sun.glass.ui.*;
import org.apache.bcel.generic.Select;
import org.apache.bcel.generic.Visitor;
import org.apache.commons.io.FileUtils;
import org.apache.xpath.operations.String;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.imageio.IIOException;
import java.awt.*;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018/8/13.
 */
public class AtionTest {
    WebDriver driver;
    @BeforeMethod
    public  void setDriver(){
   System.setProperty("webdriver.chrome.driver","F:\\测试资料\\javaday1\\drivers\\chromedriver.exe");
        driver=new ChromeDriver();
    }
    //文本框输入
    @Test
    public  void  sendKeysTest() throws InterruptedException {
//打开百度
        driver.get("http://www.baidu.com");
        //定位搜索框
        WebElement  el=driver.findElement(By.id("kw"));
        //输入selenium值
       el.sendKeys("selenium");
        //定位搜索框
        WebElement  click=driver.findElement(By.id("su"));
        //点击百度
        click.click();
        //等待3S，要不然会出现未跳转到下一个页面的情形
        Thread.sleep(3000);
        //获取页面title
      java.lang.String str=driver.getTitle();
        //校验title是否等于“selenium_百度搜索”
        Assert.assertEquals(str,"selenium_百度搜索");
    }
    //清空数据
    @Test
    public  void  keyClearTest() throws InterruptedException {
        driver.get("http://www.baidu.com");
        //定位搜索框
        WebElement  el=driver.findElement(By.id("kw"));
        //输入selenium值
        el.sendKeys("selenium");
        //等待3S
        Thread.sleep(3000);
        //清空输入的内容
        el.clear();
        //等待3S
        Thread.sleep(3000);
    }
    //或者标签中部的值
    @Test
    public  void  getTestTest() throws InterruptedException {
        driver.get("http://www.baidu.com");
        // ".//*[@id='']"
        List<WebElement> list =driver.findElements(By.cssSelector(".engine-key-wrapper"));
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getText());
        }
    }
    //获取标签名
    @Test
    public  void   getTagName(){
        driver.get("http://www.baidu.com");
        WebElement  element=driver.findElement(By.id("su"));
       java.lang.String str= element.getTagName();
        Assert.assertEquals(str,"input");
        System.out.println("标签名为："+str);
    }
    //获取属性值
    @Test
    public  void   getAttribute(){
        driver.get("http://www.baidu.com");
        WebElement  element=driver.findElement(By.id("su"));
       java.lang.String str= element.getAttribute("type");
        System.out.println("标签名为："+str);
    }
    //是否展示
    @Test
    public  void   isDisplayed(){
        driver.get("http://www.baidu.com");
        WebElement  element=driver.findElement(By.id("su"));
        Boolean  bl=element.isDisplayed();
        System.out.println("标签名是否展示："+  bl);
    }
    //是否选中)
    @Test
    public  void   isSelected()
    {
        driver.get("http://www.baidu.com");
        WebElement  element=driver.findElement(By.id("su"));
        Boolean  bl=element.isSelected();
        System.out.println("标签名是否展示："+  bl);
    }
    //是否启用
    @Test
    public  void   isEnbled()
    {

        driver.get("http://www.baidu.com");
        WebElement element=driver.findElement(By.id("su"));
        Boolean  bl= element.isEnabled();
        System.out.println("标签名是否展示："+  bl);
    }
    //截取当前窗口页面
    @Test
    public  void   screenShotFile(){
        driver.get("https://www.hao123.com/");
        //强制转换驱动类为TakeScreenshot，获取文件流。
        File  screenShotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
       try {
           //复制文件在某个文件路径下，并命名
           FileUtils.copyFile(screenShotFile,new File("F://test2.png"));
       } catch (IOException e) {
           e.printStackTrace();
       }


    }
    //alert 弹窗处理
    @Test
    public  void  alertTest() throws InterruptedException {
        driver.get("file:///F:/%E6%B5%8B%E8%AF%95%E8%B5%84%E6%96%99/%E6%95%99%E7%A8%8B/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
        driver.findElement(By.className("alert")).click();
        Thread.sleep(3000);
        //控制权转交给alert
        Alert alert= driver.switchTo().alert();
        //点击确定
        alert.accept();
      //点击取消  alert.dismiss();
    }
    //submit 弹窗处理
    @Test
    public  void  submitTest() throws InterruptedException {
        driver.get("file:///F:/%E6%B5%8B%E8%AF%95%E8%B5%84%E6%96%99/%E6%95%99%E7%A8%8B/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
        driver.findElement(By.className("confirm")).click();
        Thread.sleep(3000);
        //控制权转交给alert
        Alert alert= driver.switchTo().alert();
        Thread.sleep(3000);
        //点击取消
     alert.dismiss();
        Thread.sleep(3000);
    }
    //Prompt弹窗处理
    @Test
    public  void  promptTest() throws InterruptedException {
       WebDriver driver=new FirefoxDriver();
        driver.get("file:///F:/%E6%B5%8B%E8%AF%95%E8%B5%84%E6%96%99/%E6%95%99%E7%A8%8B/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
        driver.findElement(By.className("prompt")).click();
        Thread.sleep(3000);
        //控制权转交给alert
        Alert alert= driver.switchTo().alert();
        alert.sendKeys("这个是Prompt");
        Thread.sleep(3000);
        alert.dismiss();
        driver.quit();
    }
    //获取警告弹窗的文本
    @Test
    public  void  getTest() throws InterruptedException {
        driver.get("file:///F:/%E6%B5%8B%E8%AF%95%E8%B5%84%E6%96%99/%E6%95%99%E7%A8%8B/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
        driver.findElement(By.className("alert")).click();
        Thread.sleep(3000);
        //控制权转交给alert
        Alert alert= driver.switchTo().alert();
        java.lang.String str=alert.getText();
        alert.accept();
        Assert.assertEquals(str,"请点击确定");
    }
    //多个IFrame嵌套 中获取元素
    @Test
    public  void  iFrameTest() throws InterruptedException {
        driver.get("file:///F:/%E6%B5%8B%E8%AF%95%E8%B5%84%E6%96%99/%E6%95%99%E7%A8%8B/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
        WebElement webElement=driver.findElement(By.tagName("iframe"));
        WebElement webElement1=driver.findElement(By.tagName("iframe"));

        Thread.sleep(3000);
        //控制权转交给alert
      driver.switchTo().frame(webElement);
       //driver.switchTo().frame(webElement1);
       driver.findElement(By.linkText("baidu")).click();
       Thread.sleep(3000);
        //控制权转交给原来界面
        driver.switchTo().defaultContent();
        driver.findElement(By.id("id01")).click();
        Thread.sleep(3000);
    }
    //下拉框的处理
    @Test
    public  void  selectedTest() throws InterruptedException {
        //打开路径
  driver.get("file:///F:/%E6%B5%8B%E8%AF%95%E8%B5%84%E6%96%99/%E6%95%99%E7%A8%8B/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
//定位元素
WebElement  element=driver.findElement(By.id("moreSelect"));
        //实例化select类
        org.openqa.selenium.support.ui.Select  select=new org.openqa.selenium.support.ui.Select(element);
        //通过索引选中
        select.selectByIndex(1);
        Thread.sleep(3000);
        //通过value选中
        select.selectByValue("meizu");
        Thread.sleep(3000);
        //通过下拉内容值选中
select.selectByVisibleText("huawei");
        Thread.sleep(3000);

    }
    //多窗口的处理
    @Test
    public  void  moreWindowsTest() throws InterruptedException {
        //打开路径
        driver.get("file:///F:/%E6%B5%8B%E8%AF%95%E8%B5%84%E6%96%99/%E6%95%99%E7%A8%8B/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
       //定位元素
       driver.findElement(By.linkText("Open new window")).click();
        //获得当前窗口的句柄值
        java.lang.String strhandle = driver.getWindowHandle();
        Thread.sleep(3000);
        //循环浏览器中所有窗口的句柄值，若不相等就将控制权转交给这个窗口
        for (java.lang.String handles:driver.getWindowHandles()) {
 if ( handles.equals(strhandle))
     continue;
            driver.switchTo().window(handles);
        }
        Thread.sleep(3000);
        driver.findElement(By.linkText("baidu"));
    }
    //鼠标单击右键和双击
    @Test
    public  void  contestClick() throws InterruptedException {
//打开路径
        driver.get("http://www.baidu.com");
        //定位元素
       WebElement el= driver.findElement(By.id("su"));
        //实例化Ations类
        Actions ac=new Actions(driver);
        //鼠标单击右键并执行
        ac.contextClick(el).perform();
        Thread.sleep(3000);
        //鼠标双击
        ac.doubleClick(el).perform();
        Thread.sleep(3000);
    }
    //鼠标移动到某元素上
    @Test
    public  void  move() throws InterruptedException {
        //打开路径
        driver.get("file:///F:/%E6%B5%8B%E8%AF%95%E8%B5%84%E6%96%99/%E6%95%99%E7%A8%8B/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
        //定位元素
      WebElement el=  driver.findElement(By.xpath("//*[@id=\"action\"]/input"));
        Actions ac=new Actions(driver);
        ac.moveToElement(el).perform();
        Thread.sleep(3000);
    }
    //把元素拖拽到（x,y）
    @Test
    public  void  testDragAndDropBy() throws InterruptedException {
//file:///F:/%E6%B5%8B%E8%AF%95%E8%B5%84%E6%96%99/%E6%95%99%E7%A8%8B/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/dragAndDrop.html
        //打开路径
        driver.get("file:///F:/%E6%B5%8B%E8%AF%95%E8%B5%84%E6%96%99/%E6%95%99%E7%A8%8B/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/dragAndDrop.html");
        //定位元素
        WebElement el=  driver.findElement(By.xpath("//*[@id=\"drag\"]"));
        Actions ac=new Actions(driver);
        ac.dragAndDropBy(el,500,500).perform();
        Thread.sleep(3000);
    }
    //等待元素
    @Test
    public   void   waitTest() throws InterruptedException {
        //打开路径
        driver.get("file:///F:/%E6%B5%8B%E8%AF%95%E8%B5%84%E6%96%99/%E6%95%99%E7%A8%8B/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
        //定位元素
         driver.findElement(By.xpath("//*[@id=\"wait\"]/input")).click();
        //线程等待
       // Thread.sleep(3000);
        //全局等待   执行findElement（）之前都会等待10s，重新执行，直到找到定位元素,放在全局变量里，则只要执行findElement都会执行等待。
       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //显示等待
        WebDriverWait  wait=new WebDriverWait(driver,10);
        //定位元素获取内容
      String str= (String) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"display\"]/div")));
        Assert.assertEquals(str,"wait for display");
    }
    //把一个元素拖到另一个元素上
    @Test
    public  void  dropTest() throws InterruptedException {
        driver.get("F:\\测试资料\\教程\\源码\\webdriver_demo\\selenium_html\\dragAndDrop.html");
        WebElement webElement1=driver.findElement(By.id("drag"));
        WebElement webElement2=driver.findElement(By.xpath("/html/body/h1"));

        //点击
        Actions  actions=new Actions(driver);
        actions.clickAndHold(webElement1)//拖拽
                .moveToElement(webElement2)//移动到
                .release(webElement1).//释放拖拽
                perform();//执行
        Thread.sleep(3000);
    }
    //Actions类下拉框多选，按shift或ctrl
    @Test
    public  void  dropdownListSelect() throws InterruptedException {
        //打开路径
        driver.get("file:///F:/%E6%B5%8B%E8%AF%95%E8%B5%84%E6%96%99/%E6%95%99%E7%A8%8B/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
        WebElement element=driver.findElement(By.id("selectWithMultipleEqualsMultiple"));
        //获取所有下拉内容
        List <WebElement> list=element.findElements(By.xpath("//*[@id=\"selectWithMultipleEqualsMultiple\"]/option"));
        Actions  actions=new Actions(driver);
        //按住shift，点击第一项和第三项，建立，执行。
       // actions.keyDown(Keys.SHIFT).click(list.get(0)).click(list.get(2)).build().perform();
        actions.keyDown(Keys.CONTROL).click(list.get(2)).build().perform();
        Thread.sleep(3000);
    }
    //Robot类下拉框多选，按shift或ctrl
    @Test
    public  void  dropdownListSelect1() throws AWTException, InterruptedException {
        //打开路径
        driver.get("http://www.baidu.com");
        //实例化Robot
      Robot  rb=new Robot();
        //按下ctrl
        rb.keyPress(KeyEvent.VK_CONTROL);
        //按下S
        int i=(int)new Character('S');
        rb.keyPress(i);
        Thread.sleep(3000);
        //按下enter
        rb.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(3000);
        //释放control
        rb.keyRelease(KeyEvent.VK_CONTROL);

    }
    //上传文件
    @Test
    public  void  upload() throws InterruptedException {
        //打开路径
        driver.get("file:///F:/%E6%B5%8B%E8%AF%95%E8%B5%84%E6%96%99/%E6%95%99%E7%A8%8B/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
        driver.findElement(By.id("load")).sendKeys("E://支付宝充值逻辑.txt");
        Thread.sleep(10000);
    }
    //下载文件
    @Test
    public  void  downLoad() throws AWTException, InterruptedException {
        //启动火狐驱动
        WebDriver  driver = new FirefoxDriver();
        driver.get("http://chrome.xiangtatech.com/");
        driver.findElement(By.xpath("html/body/div[2]/div/a")).click();
        Thread.sleep(3000);
       Robot rb=new Robot();
        //这里按enter取消了？？？？
       rb.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(10000);
        driver.quit();
    }
    @AfterMethod
public  void  quit(){
    driver.quit();
}
}
