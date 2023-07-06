package tests;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DeleteOneContact extends TestBase {
    Logger logger = LoggerFactory.getLogger(DeleteOneContact.class);
    //WebDriver wd;
    @BeforeMethod
    public void precondition() {
        if (!app.getUser().isLogged()) {
            String email = "pavlovae434@gmail.com", password = "Alex@2001";
            app.getUser().openLoginForm();
            app.getUser().fillLoginForm(email, password);
            app.getUser().submitLogin();
        }
    }

    @Test
    public void testDeleteOneContact() {

        app.getHelperContact().openContactsList();
       int i= app.getHelperContact().contactcListSize();
        app.getHelperContact().click(By.cssSelector("div[class='contact-page_leftdiv__yhyke'] div div:nth-child(1)"));
        app.getHelperContact().removeContact();
        app.getHelperContact().pause(3000);
        logger.info("Contact deleted");
        Assert.assertTrue(app.getHelperContact().contactcListSize()<i);
    }
}
