package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LandingPage extends AbstractPage {

    @FindBy(css = ".btn.buy")
    private WebElement buyNowButton;

    @FindBy(css = ".cart-content.buying")
    private WebElement shoppingCart;

    @FindBy(css = "input.text-right")
    private WebElement inputField;

    @FindBy(css = ".cart-checkout")
    private WebElement checkoutButton;

    @FindBy(css = ".trans-status.trans-success > span:first-of-type")
    private WebElement transactionSuccessMessage;

    public LandingPage(AppiumDriver driver) {
        super(driver);
    }

    public void buyNow() {
        waitForElementToAppear(buyNowButton);
        buyNowButton.click();
    }

    public void fillInOrderDetails(String amount, String username, String email, String phoneNumber,
                                   String city, String address, String postalCode){
        waitForElementToAppear(shoppingCart);

        String[] userDetails = {amount, username, email, phoneNumber, city, address, postalCode};

        for (String field : userDetails) {
            inputField.clear();
            inputField.sendKeys(field);
            inputField.sendKeys(Keys.TAB);
        }
//        // user amount
//        inputField.clear();
//        inputField.sendKeys(amount);
//        inputField.sendKeys(Keys.TAB);
//
//        // name
//        inputField.clear();
//        inputField.sendKeys(userName);
//        inputField.sendKeys(Keys.TAB);
//
//        // email
//        inputField.clear();
//        inputField.sendKeys(userEmail);
//        inputField.sendKeys(Keys.TAB);
//
//        // phone
//        inputField.clear();
//        inputField.sendKeys(userPhone);
//        inputField.sendKeys(Keys.TAB);
//
//        // city
//        inputField.clear();
//        inputField.sendKeys(userCityName);
//        inputField.sendKeys(Keys.TAB);
//
//        // address
//        inputField.clear();
//        inputField.sendKeys(userAddress);
//        inputField.sendKeys(Keys.TAB);
//
//        // postal code
//        inputField.clear();
//        inputField.sendKeys(userPostalCode);

    }

    public void checkTransactionStatus(String status) {
        if (status.equals("SUCCES")) {
            waitForElementToAppear(transactionSuccessMessage);
            Assert.assertEquals(transactionSuccessMessage.getText(), "Thank you for your purchase.",
                    "Successful transaction message was not shown.");
        }


    }

    public void submitOrderForm() {
        waitForElementToAppear(checkoutButton);
        checkoutButton.click();
    }
}
