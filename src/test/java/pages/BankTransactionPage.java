package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BankTransactionPage extends AbstractPage{

    @FindBy(css = "#PaRes")
    private WebElement passwordInput;

    @FindBy(css = "#PaRes")
    private WebElement submitButton;

    public BankTransactionPage(AppiumDriver driver) {
        super(driver);
    }

    public void typePassword (String password) {
        waitForElementToAppear(passwordInput);
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void finaliseTransaction () {
        waitForElementToAppear(submitButton);
        submitButton.click();
    }
}
