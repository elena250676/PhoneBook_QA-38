import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTests {
    WebDriver wd;

    @BeforeMethod
    public void init() {
        wd = new ChromeDriver();
        wd.navigate().to("https://telranedu.web.app/home");
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void loginPositiveTest() {
        //open login form
        //fill login form
        //click on button login
        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("pavlovae434@gmail.com");

        WebElement password = wd.findElement(By.xpath("//input[2]"));
        password.click();
        password.clear();
        password.sendKeys("Alex@2001");

        wd.findElement(By.xpath("//button[1]")).click();
         Assert.assertTrue(wd.findElements(By.xpath("//*[.='Sign Out']")).size()>0);
    }

    @Test
    public void loginNegativTestWrongEmail() {
        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("pavlovae434gmail.com");

       WebElement password = wd.findElement(By.xpath("//input[2]"));
        password.click();
        password.clear();
        password.sendKeys("Alex@2001");

        wd.findElement(By.xpath("//button[1]")).click();
       // Assert.assertTrue(wd.findElements(By.xpath("//*[.='Sign Out']")).size()>0);

    }

    @AfterMethod
    public void tearDown() {
        //wd.quit();

    }


}
