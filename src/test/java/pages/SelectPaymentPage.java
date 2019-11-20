package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectPaymentPage extends AbstractPage {

    @FindBy(xpath = "//div[(text()='Credit Card')]")
    private WebElement creditCardOption;

    public SelectPaymentPage(WebDriver driver) {
        super(driver);
    }

    public void selectCreditCardPayment(){
        waitForElementToAppear(creditCardOption);
        creditCardOption.click();
    }
}
