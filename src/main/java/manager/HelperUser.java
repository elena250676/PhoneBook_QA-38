package manager;

import models.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HelperUser extends HelperBase {

    public HelperUser(WebDriver wd) {
        super(wd);
    }

    //WebDriver wd;
    public void openLoginForm() {
        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
    }

    public void fillLoginForm(String email, String password) {
        type(By.xpath("//input[1]"), email);
        //type(By.xpath("//input[2]"), password);
        type(By.xpath("//input[2]"), password);
    }

    public void submitRegistration() {
        click(By.xpath("//button[2]"));
    }

    public void submitLogin() {
        click(By.xpath("//button[1]"));
    }

    public void logout() {
        click(By.xpath("//*[.='Sign Out']"));
    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//*[.='Sign Out']"));
    }

    public void fillLoginForm(User user) {
        type(By.xpath("//input[1]"), user.getEmail());
        type(By.xpath("//input[2]"), user.getPassword());
    }

    public boolean isAlertPresent() {
        Alert alert = new WebDriverWait(wd, 10)
                .until(ExpectedConditions.alertIsPresent());
        if(alert==null) return false;
        wd.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        return true;
        //Assert.assertTrue();
    }
    public boolean isWrongFormatMessage() {
        Alert alert = new WebDriverWait(wd, 10)
                .until(ExpectedConditions.alertIsPresent());
        return alert.getText().equals("Wrong email or password");


       // Wrong email or password
    }


}
