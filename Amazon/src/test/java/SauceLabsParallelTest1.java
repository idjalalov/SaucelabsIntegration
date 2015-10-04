import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by idjalalov on 10/1/2015.
 */
public class SauceLabsParallelTest1 {
    public static String userName = "ilhomdjalalov";
    public static String key = "69c5c864-6ffa-4d25-a0d7-5bd809ba72ec";
    public static String url = "http://"+userName+":"+key+"@ondemand.saucelabs.com:80/wd/hub";

    @Test
    public void Test1() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName("chrome");
        caps.setPlatform(Platform.WINDOWS);
        caps.setVersion("45.0");
        caps.setCapability("name", "My first parallel tests on Sauce labs");

        WebDriver driver = new RemoteWebDriver(new URL(url),caps);

        driver.navigate().to("http://amazon.com");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        System.out.println(driver.getCurrentUrl());

        WebElement search = driver.findElement(By.xpath(".//*[@id='twotabsearchtextbox']"));
        search.sendKeys("smart tv");
        search.submit();
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);

        driver.quit();
    }
}