package pages;

import common.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LandingPage extends AbstractPage {

    @FindBy(css = ".btn.buy")
    private WebElement buyNowButton;

    @FindBy(css = ".cart-content.buying")
    private WebElement shoppingCart;

    @FindBy(css = "input.text-right")
    private WebElement itemValueInput;

    @FindBy(xpath = "//td[contains(text(),'Name')]/../td/input")
    private WebElement userNameInput;

    @FindBy(xpath = "//td[contains(text(),'Email')]/../td/input")
    private WebElement emailInput;

    @FindBy(xpath = "//td[contains(text(),'Phone no')]/../td/input")
    private WebElement phoneNumberInput;

    @FindBy(xpath = "//td[contains(text(),'City')]/../td/input")
    private WebElement cityInput;

    @FindBy(css = ".input > textarea")
    private WebElement addressInput;

    @FindBy(xpath = "//td[contains(text(),'Postal Code')]/../td/input")
    private WebElement postalCodeInput;

    @FindBy(css = ".cart-checkout")
    private WebElement checkoutButton;


    public LandingPage(WebDriver driver) {
        super(driver);
    }

    public void launchBrowser() {
        driver.get(Constants.URL);
        Assert.assertEquals(driver.getCurrentUrl(), Constants.URL, "URL Mismatch");
    }

    public void buyNow() {
        waitForElementToAppear(buyNowButton);
        buyNowButton.click();
    }

    public void fillInItemValue(String amount) {
        waitForElementToAppear(itemValueInput);
        itemValueInput.clear();
        itemValueInput.sendKeys(amount);
    }

    public void fillInUserDetails(String username, String email, String phoneNumber,
                                  String city, String address, String postalCode) {
        waitForElementToAppear(shoppingCart);

        userNameInput.clear();
        userNameInput.sendKeys(username);

        emailInput.clear();
        emailInput.sendKeys(email);

        phoneNumberInput.clear();
        phoneNumberInput.sendKeys(phoneNumber);

        cityInput.clear();
        cityInput.sendKeys(city);

        addressInput.clear();
        addressInput.sendKeys(address);

        postalCodeInput.clear();
        postalCodeInput.sendKeys(postalCode);

    }

    public void submitOrderForm() {
        waitForElementToAppear(checkoutButton);
        checkoutButton.click();
    }
}
