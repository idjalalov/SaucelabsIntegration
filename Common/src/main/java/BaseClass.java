import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by idjalalov on 10/1/2015.
 */
public class BaseClass {
    public WebDriver driver = null;

    @Parameters({"userName","key"})

    @BeforeMethod
    public void setUp(String userName, String key) throws MalformedURLException {
        String url = "http://"+userName+":"+key+"@ondemand.saucelabs.com:80/wd/hub";
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName("firefox");
        caps.setCapability("platform", "Windows 10");
        caps.setVersion("40.0");
        caps.setCapability("name", "Passing Parameter Test");

        driver = new RemoteWebDriver(new URL(url),caps);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void cleanUp(){
        driver.quit();
    }

}
