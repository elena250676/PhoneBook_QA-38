import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class RegistrationTests {

    WebDriver wd;

    @BeforeMethod
    public void init() {
        wd = new ChromeDriver();
        wd.navigate().to("https://telranedu.web.app/home");
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void registrationPositive() {
        // open login form
        wd.findElement(By.xpath("//*[.='LOGIN']")).click();

        // fill login form

        int i = (int) (System.currentTimeMillis() / 1000) % 3600;

        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("abc" + i + "@def.com");

        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
        passInput.click();
        passInput.clear();
        passInput.sendKeys("$Abcdef12345");

        // click on button Registration
        wd.findElement(By.xpath("//button[2]")).click();

        // Assert

//        Assert.assertTrue(wd.findElements(By.xpath("//*[.='Sign Out']")).size() > 0);
        Assert.assertTrue(wd.findElements(By.xpath("//button")).size() > 0);

    }

    @Test
    public void loginNegativTestWrongEmail() {
        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("pavlovae434" + i + "gmail.com");

        WebElement password = wd.findElement(By.xpath("//input[2]"));
        password.click();
        password.clear();
        password.sendKeys("Alex@2001");

        wd.findElement(By.xpath("//button[1]")).click();
        // Assert.assertTrue(wd.findElements(By.xpath("//*[.='Sign Out']")).size()>0);

    }
    @Test
    public void loginNegativTestWrongPassword() {
        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("pavlovae434" + i + "@gmail.com");

        WebElement password = wd.findElement(By.xpath("//input[2]"));
        password.click();
        password.clear();
        password.sendKeys("1");

        wd.findElement(By.xpath("//button[1]")).click();
        // Assert.assertTrue(wd.findElements(By.xpath("//*[.='Sign Out']")).size()>0);

    }
    @AfterMethod
    public void tearDown() {

    }

}
