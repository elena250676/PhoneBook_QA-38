package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


public class RegistrationTests extends TestBase {

//    WebDriver wd;
//
//    @BeforeMethod
//    public void init() {
//        wd = new ChromeDriver();
//        wd.navigate().to("https://telranedu.web.app/home");
//        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//    }

    @Test
    public void registrationPositive() {
        // open login form
        app.getUser().openLoginForm();
        // fill login form
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        app.getUser().fillLoginForm("pavlovae434" + i + "@gmail.com", "Alex@2001");
        app.getUser().submitRegistration();
        app.getUser().pause(5000);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));

    }

    //
    @Test
    public void registrationNegativeWrongEmail() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "abc" + i + "def.com", password = "$Abcdef12345";
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(email, password);
        app.getUser().submitRegistration();
    }

    @Test
    public void registrationNegativeWrongPassword() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "pavlovae434" + i + "@gmail.com", password = "1";
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(email, password);
        app.getUser().submitRegistration();
    }


    @AfterMethod
    public void tearDown() {

    }

}
