package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class AbstractPage {

    protected static WebDriver driver;
    protected static WebDriverWait wait;

    public AbstractPage(WebDriver driver) {
        AbstractPage.driver = driver;
        wait = new WebDriverWait(driver, 30, 100);
        PageFactory.initElements(driver, this);
    }

    public void waitForElementToAppear(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}
