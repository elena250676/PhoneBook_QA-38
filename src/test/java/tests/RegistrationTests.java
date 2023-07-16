package tests;

import manager.ProviderData;
import manager.TestNgListener;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNgListener.class)

public class RegistrationTests extends TestBase {

//    WebDriver wd;
//
//    @BeforeMethod
//    public void init() {
//        wd = new ChromeDriver();
//        wd.navigate().to("https://telranedu.web.app/home");
//        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//    }

    /* @Test
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
 */
    @Test(dataProvider = "userDtoCSV", dataProviderClass = ProviderData.class)
    public void registrationPositiveUser(User user) {
//        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
//        User user = User.builder()
//                .email("pavlovae434@gmail.com")
//                .password("Alex@2001")
//                .build();

        app.getUser().openLoginForm();
        logger.info("openRegistrationForm invoked");
        app.getUser().fillLoginForm(user);
        logger.info("fillRegistrationForm invoked");
        app.getUser().submitRegistration();
        logger.info("submitLogin invoked");
        logger.info("registrationPositive starts with credentials: login   "
                + user.getEmail() + "   password" + user.getPassword());
        app.getUser().pause(5000);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));
        app.getUser().logout();
    }

    @Test(groups = {"regress", "negative"})
    public void registrationNegativeWrongEmail() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "abc" + i + "def.com", password = "$Abcdef12345";
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(email, password);
        app.getUser().submitRegistration();
        if (app.getUser().isAlertPresent()) {
            app.getUser().click(By.cssSelector("#root > div:nth-child(2) > div"));
        }
    }

    @Test(dataProvider = "userDtoCSVnegative", dataProviderClass = ProviderData.class)
    public void registrationNegativeWrongEmailDTO(User user) {
//        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
//        String email = "abc" + i + "def.com", password = "$Abcdef12345";
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitRegistration();
        if (app.getUser().isAlertPresent()) {
            app.getUser().click(By.cssSelector("#root > div:nth-child(2) > div"));
        }
    }

    @Test(groups = {"regress", "negative"})
    public void registrationNegativeWrongPassword() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "pavlovae434" + i + "@gmail.com", password = "1";
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(email, password);
        app.getUser().submitRegistration();
        if (app.getUser().isAlertPresent()) {
            app.getUser().click(By.cssSelector("#root > div:nth-child(2) > div"));
        }
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        app.getUser().navToHome();
    }

}
