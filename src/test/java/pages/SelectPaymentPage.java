package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectPaymentPage extends AbstractPage {

    @FindBy(css = ".list-title:first-of-type")
    private WebElement creditCard;

    public SelectPaymentPage(AppiumDriver driver) {
        super(driver);
    }

    public void selectCreditCardPayment(){
        waitForElementToAppear(creditCard);
        creditCard.click();
    }
}
