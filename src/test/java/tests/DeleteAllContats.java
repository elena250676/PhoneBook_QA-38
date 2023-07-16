package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteAllContats extends TestBase{
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
    public void removeAllContactsPositive(){
        app.getHelperContact().removeAllContacts();
        Assert.assertTrue(app.getHelperContact().isNoContacts());
    }
}
