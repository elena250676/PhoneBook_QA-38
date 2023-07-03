package manager;

import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void click(By locator){
        wd.findElement(locator).click();
    }

    public void type(By locator, String text){
        WebElement element = wd.findElement(locator);
        element.click();
        element.clear();
        element.sendKeys(text);
    }
public void takeScreen(String link) {
    File tmp = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
    File screenshot = new File(link);
    try {

        com.google.common.io.Files.copy(tmp, screenshot);
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    public void pause(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isElementPresent(By locator){
        return wd.findElements(locator).size() > 0;
    }
}
