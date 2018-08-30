package TestNGDemoDay2;
import org.testng.Assert;
import org.testng.annotations.Test;
/**
 * Created by Administrator on 2018/8/9.
 */
public class TestNGDemo2 {
     @Test
    public void  assertEquals1()
     {
         String a ="admin";

         String b ="admin1";
         Assert.assertEquals(a,b);
     }
}
