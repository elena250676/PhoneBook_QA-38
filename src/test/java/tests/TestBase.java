package tests;

import manager.AppManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class TestBase {
    static AppManager app = new AppManager(
            System.getProperty("browser", BrowserType.CHROME)
    );


    Logger logger = LoggerFactory.getLogger(TestBase.class);

    //    WebDriver wd;
//
    @BeforeSuite
    public void Setup() {
        app.init();
    }

    @AfterSuite
    public void stop() {
        app.tearDown();
    }

    @BeforeMethod
    public void startLogger(Method method) {
        logger.info("Method " + method.getName() + " is started");
    }

    @AfterMethod
    public void end() {
        logger.info("==================================");
    }


//        wd.findElement(locator).click();
//    }
//
//    public void type(By locator, String text){
//        WebElement element = wd.findElement(locator);
//        element.click();
//        element.clear();
//        element.sendKeys(text);
//    }
//
//    public void pause(int millis){
//        try {
//            Thread.sleep(millis);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

//    public void openLoginForm(){
//        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
//    }
//
//    public void fillLoginForm(String email, String password){
//        type(By.xpath("//input[1]"), email);
//        type(By.xpath("//input[2]"), password);
//    }
//
//    public void submitRegistration(){
//        click(By.xpath("//button[2]"));
//    }
//
//    public void submitLogin(){
//        click(By.xpath("//button[1]"));
//    }

//    public boolean isElementPresent(By locator){
//        return wd.findElements(locator).size() > 0;
//    }

//    public void logout(){
//        click(By.xpath("//*[.='Sign Out']"));
//    }
//
//    public boolean isLogged(){
//        return isElementPresent(By.xpath("//*[.='Sign Out']"));
//    }
    }