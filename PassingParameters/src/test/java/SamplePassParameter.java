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
        driver.navigate().to("http://metlife.com");
        System.out.println(driver.getCurrentUrl());

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement uName = driver.findElement(By.cssSelector("#uidLbl"));
        uName.sendKeys("good_user");
        WebElement pWord = driver.findElement(By.cssSelector("#pwdLbl"));
        pWord.sendKeys("good_password");
        driver.findElement(By.xpath(".//*[@id='108329']")).click();
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);

        if (driver.getPageSource().contains("Sorry")){
            System.out.println("Login Test with invalid username and password was very successful.");
        }

    }




}
