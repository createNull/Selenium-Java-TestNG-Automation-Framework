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

    @FindBy(css = ".input > input[type='text']")
    private WebElement userNameInput;

    @FindBy(css = ".input > input[type='email']")
    private WebElement emailInput;

    @FindBy(xpath = "//tr[3]//td[2]//input[1]")
    private WebElement phoneNumberInput;

    @FindBy(xpath = "//tr[4]//td[2]//input[1]")
    private WebElement cityInput;

    @FindBy(css = ".input > textarea")
    private WebElement addressInput;

    @FindBy(xpath = "//tr[6]//td[2]//input[1]")
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
