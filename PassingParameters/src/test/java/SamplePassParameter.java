import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by idjalalov on 10/1/2015.
 */
public class SamplePassParameter extends BaseClass{

    @Test
    public void chaseBank(){
        driver.navigate().to("http://lg.com/us");
        System.out.println(driver.getCurrentUrl());

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement login = driver.findElement(By.xpath(".//*[@id='app-my-lg']/div/div/ul/li[1]/div/div/a/span"));
        login.click();

        WebElement uName = driver.findElement(By.xpath(".//*[@id='txtBoxEmail']"));
        uName.sendKeys("good_user@fff.com");
        WebElement pWord = driver.findElement(By.xpath(".//*[@id='txtBoxPassword']"));
        pWord.sendKeys("good_password");
        driver.findElement(By.xpath(".//*[@id='signinForm']/div[3]/button")).click();
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);

        if (driver.getPageSource().contains("incorrect")){
            System.out.println("LOGIN TEST WITH INVALID USERNAME AND PASSWORD HAS PASSED SUCCESSFULLY.");
            System.out.println("Auto trigger is on");
            System.out.println("I'm trying all posssible ways.");

        }

    }




}
