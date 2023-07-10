package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class AppManager {
    Logger logger = LoggerFactory.getLogger(AppManager.class);
    //WebDriver wd;
    EventFiringWebDriver wd;
    HelperUser user;
    HelperContact helperContact;
    String browser;

    public AppManager(String browser) {
        this.browser = browser;
    }



    public HelperUser getUser() {
        return user;
    }

    public HelperContact getHelperContact() {
        return helperContact;

    }

    @BeforeSuite
    public void init() {
        // wd = new ChromeDriver();
        //contact = new HelperContact(wd);
        if (browser.equals(BrowserType.CHROME)) ;
        {
            wd = new EventFiringWebDriver(new ChromeDriver());
            logger.info("Tests starting on Chrome");
        }
        if (browser.equals(BrowserType.FIREFOX)) {
            wd = new EventFiringWebDriver(new FirefoxDriver());
            logger.info("Tests starting on Firefox");
        }
        helperContact = new HelperContact(wd);
        wd.register(new WebDriverListener());
        user = new HelperUser(wd);
        wd.navigate().to("https://telranedu.web.app/home");
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterSuite
    public void tearDown() {
        //wd.quit();
    }
}
