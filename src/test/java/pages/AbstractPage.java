package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {
    AppiumDriver driver;
    WebDriverWait wait;

    public AbstractPage(AppiumDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30, 100);
    }


    public void waitForElementToAppear(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}
