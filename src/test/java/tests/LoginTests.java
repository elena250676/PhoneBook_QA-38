package tests;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    // WebDriver wd;

    /* @BeforeMethod
     public void init() {
         wd = new ChromeDriver();
         wd.navigate().to("https://telranedu.web.app/home");
         wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
     }*/
    @BeforeMethod(alwaysRun=true)
    public void precondition() {
        if (app.getUser().isLogged()) {
            app.getUser().logout();
        }
    }
/*
    @Test
    public void loginPositiveTest() {
        // open login form
        app.getUser().openLoginForm();
        // fill login form
        app.getUser().fillLoginForm("pavlovae434@gmail.com", "Alex@2001");
        app.getUser().submitLogin();
        app.getUser().pause(3000);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));
    }

    @Test
    public void loginPositiveTestBase() {
        String email = "abc@def.com", password = "$Abcdef12345";
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(email, password);
        app.getUser().submitLogin();
        app.getUser().pause(3000);
//        Assert.assertTrue(wd.findElements(By.xpath("//button")).size() > 0);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));
    }

    @Test
    public void loginPositiveUserData() {
        // User user = new User("pavlovae434@gmail.com", "Alex@2001");
        User user = new User().withEmail("pavlovae434@gmail.com").withPassword("Alex@2001");

//        user.setEmail("pavlovae434@gmail.com");
//        user.setPassword("Alex@2001");
        //       user.setEmail("pavlovae434@gmail.com");
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitLogin();
        app.getUser().pause(3000);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));
    }
*/
    @Test(groups ={"smoke","positive"})
    public void loginPositiveUserBuilder() {
        // User user = new User("pavlovae434@gmail.com", "Alex@2001");
        User user = User.builder()
                .email("pavlovae434@gmail.com")
                .password("Alex@2001")
                .build();
//        user.setEmail("pavlovae434@gmail.com");
//        user.setPassword("Alex@2001");
        //       user.setEmail("pavlovae434@gmail.com");
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitLogin();
        app.getUser().pause(3000);
        logger.info("Logged in user");
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));
    }
    @Test(groups ={"regress","negative"})
    public void loginNegativeUserBuilder() {
        // User user = new User("pavlovae434@gmail.com", "Alex@2001");
        User user = User.builder()
                .email("pavlovae434gmail.com")
                .password("Alex@2001")
                .build();
//        user.setEmail("pavlovae434@gmail.com");
//        user.setPassword("Alex@2001");
        //       user.setEmail("pavlovae434@gmail.com");
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitLogin();
        app.getUser().pause(3000);

        //app.getUser().isAlertPresent();
        Assert.assertTrue(app.getUser().isWrongFormatMessage());
        Assert.assertTrue(app.getUser().isAlertPresent());
        //Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));
    }
/*
    @Test
    public void loginPositiveUser() {
        // User user = new User("pavlovae434@gmail.com", "Alex@2001");
        User user = new User().withEmail("pavlovae434@gmail.com").withPassword("Alex@2001");

//        user.setEmail("pavlovae434@gmail.com");
//        user.setPassword("Alex@2001");
        //       user.setEmail("pavlovae434@gmail.com");
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user.getEmail(), user.getPassword());
        app.getUser().submitLogin();
        app.getUser().pause(3000);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));
    }

    /*@Test
//    public void loginNegativeTestWrongEmail(){
//
//        // open login form
//        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
//
//        // fill login form
//
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("abcdef.com");
//
//        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//        passInput.click();
//        passInput.clear();
//        passInput.sendKeys("$Abcdef12345");
//
//        // click on button Login
//        wd.findElement(By.xpath("//button[1]")).click();
//
//        // Assert
//    }

    @Test
    public void loginNegativeTestWrongPassword() {
        String email = "abc@def.com", password = "Abcdef12345";
        openLoginForm();
        fillLoginForm(email, password);
        submitLogin();
    }
*/
    @AfterMethod(alwaysRun=true)
    public void tearDown() {
        //wd.quit();

    }


}
