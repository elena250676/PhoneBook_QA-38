package tests;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DeleteOneContact extends TestBase {
    @BeforeMethod(alwaysRun=true)
    public void precondition() {
        if (!app.getUser().isLogged()) {
            String email = "pavlovae434@gmail.com", password = "Alex@2001";
            app.getUser().openLoginForm();
            app.getUser().fillLoginForm(email, password);
            app.getUser().submitLogin();
        }
    }

    @Test
    public void removeOneContactPositive() {
        int res = app.getHelperContact().removeOneContact();
        Assert.assertEquals(-1, res);

    }
}
