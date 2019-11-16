package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends AbstractPage {

    @FindBy(css = ".btn.buy")
    private WebElement buyNowButton;

    @FindBy(css = ".cart-content.buying")
    private WebElement shoppingCart;

    @FindBy(css = "input.text-right")
    private WebElement inputField;

    @FindBy(css = ".cart-checkout")
    private WebElement checkoutButton;

    public LandingPage(AppiumDriver driver) {
        super(driver);
    }

    public void buyNow() {
        waitForElementToAppear(buyNowButton);
        buyNowButton.click();
    }

    public void fillInOrderDetails(String amount, String userName, String userEmail, String userPhone,
                                   String userCityName, String userAddress, String userPostalCode){
        waitForElementToAppear(shoppingCart);
        // user amount
        inputField.clear();
        inputField.sendKeys(amount);
        inputField.sendKeys(Keys.TAB);

        // name
        inputField.clear();
        inputField.sendKeys(userName);
        inputField.sendKeys(Keys.TAB);

        // email
        inputField.clear();
        inputField.sendKeys(userEmail);
        inputField.sendKeys(Keys.TAB);

        // phone
        inputField.clear();
        inputField.sendKeys(userPhone);
        inputField.sendKeys(Keys.TAB);

        // city
        inputField.clear();
        inputField.sendKeys(userCityName);
        inputField.sendKeys(Keys.TAB);

        // address
        inputField.clear();
        inputField.sendKeys(userAddress);
        inputField.sendKeys(Keys.TAB);

        // postal code
        inputField.clear();
        inputField.sendKeys(userPostalCode);

    }

    public void submitOrder() {
        waitForElementToAppear(checkoutButton);
        checkoutButton.click();
    }
}
