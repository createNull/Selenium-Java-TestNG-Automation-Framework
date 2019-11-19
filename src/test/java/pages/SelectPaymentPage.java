package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectPaymentPage extends AbstractPage {

    @FindBy(css = ".list-title:first-of-type")
    private WebElement creditCard;

    public SelectPaymentPage(WebDriver driver) {
        super(driver);
    }

    public void selectCreditCardPayment(){
        waitForElementToAppear(creditCard);
        creditCard.click();
    }
}
