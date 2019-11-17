package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CardDetailsPage extends AbstractPage {

    @FindBy(css = ".text-amount-amount")
    private WebElement finalAmount;

    @FindBy(css = "input[name='cardnumber']")
    private WebElement cardDetailsInput;

    @FindBy(css = ".text-button-main")
    private WebElement payNowButton;

    public CardDetailsPage(AppiumDriver driver) {
        super(driver);
    }

    public void checkFinalAmount(String amount) {
        waitForElementToAppear(finalAmount);
        Assert.assertEquals(finalAmount.getText(), amount, amount +
                "was not shown on order details");
    }

    public void inputCardNumber(String cardNumber, String expiryDate, String cvv) {
        waitForElementToAppear(cardDetailsInput);

        String[] cardDetails = {cardNumber, expiryDate, cvv};

        for (String cardInputField : cardDetails) {
            cardDetailsInput.clear();
            cardDetailsInput.sendKeys(cardInputField);
            cardDetailsInput.sendKeys(Keys.TAB);
        }
    }

    public void payNow() {
        waitForElementToAppear(payNowButton);
        payNowButton.click();
    }
}
