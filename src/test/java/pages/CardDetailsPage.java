package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CardDetailsPage extends AbstractPage {

    @FindBy(css = ".text-amount-amount")
    private WebElement finalAmount;

    @FindBy(css = "input[name='cardnumber']")
    private WebElement cardNumberInput;

    @FindBy(xpath = "//div[@class='card-container'][1]/div[2]/input")
    private WebElement cardExpiryDateInput;

    @FindBy(xpath = "//div[@class='card-container'][1]/div[3]/input")
    private WebElement cardCVVInput;

    @FindBy(css = ".text-button-main")
    private WebElement confirmPaymentButton;

    public CardDetailsPage(WebDriver driver) {
        super(driver);
    }

    public void checkFinalAmount(String amount) {
        waitForElementToAppear(finalAmount);
        Assert.assertEquals(finalAmount.getText().replace(",", ""), amount, amount +
                "was not shown on order details");
    }

    public void fillInCardDetails(String cardNumber, String expiryDate, String cvv) {
        waitForElementToAppear(cardNumberInput);
        cardNumberInput.clear();
        cardNumberInput.sendKeys(cardNumber);

        cardExpiryDateInput.clear();
        cardExpiryDateInput.sendKeys(expiryDate);

        cardCVVInput.clear();
        cardCVVInput.sendKeys(cvv);
    }

    public void confirmPayment() {
        waitForElementToAppear(confirmPaymentButton);
        confirmPaymentButton.click();
    }
}
