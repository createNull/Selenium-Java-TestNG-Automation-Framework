package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BankTransactionPage extends AbstractPage{

    @FindBy(css = "#PaRes")
    private WebElement passwordInput;

    @FindBy(css = "button[name='ok']")
    private WebElement submitButton;

    public BankTransactionPage(WebDriver driver) {
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
