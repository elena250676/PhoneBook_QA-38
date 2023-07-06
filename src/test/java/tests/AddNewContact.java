package tests;

import models.Contact;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContact extends TestBase {
    Logger logger = LoggerFactory.getLogger(AddNewContact.class);

    @BeforeMethod
    public void precondition() {
        if (!app.getUser().isLogged()) {
            String email = "pavlovae434@gmail.com", password = "Alex@2001";
            app.getUser().openLoginForm();
            app.getUser().fillLoginForm(email, password);
            app.getUser().submitLogin();
        }
    }

    @Test(invocationCount = 5)
    public void testAddNewContactPositive() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        Contact contact = Contact.builder()
                .name("Elena" + i)
                .lastname("Pavlova")
                .phone("0533858426" + i)
                .email("pavlova" + i + "@gmail.com")
                .address("Pinsker 30")
                .description("ggg")
                .build();

        logger.info("Phone number is " + contact.getPhone());

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().submitContactForm();
        app.getHelperContact().pause(3000);
        Assert.assertTrue(app.getHelperContact().isContactCreated(contact));
    }
}
