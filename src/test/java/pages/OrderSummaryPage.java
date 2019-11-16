package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class OrderSummaryPage extends AbstractPage {

    @FindBy(css = ".item-name")
    private WebElement itemName;

    @FindBy(css = ".text-actionable:first-of-type")
    private WebElement orderDetailsTab;

    @FindBy(css = ".table-amount.text-body")
    private WebElement itemAmount;

    @FindBy(css = ".text-actionable:last-of-type")
    private WebElement shippingDetailsTab;

    @FindBy(css = ".text-block > .text-body:first-of-type")
    private WebElement shippingName;

    @FindBy(css = ".text-block > .text-body:nth-of-type(2)")
    private WebElement shippingPhoneNumber;

    @FindBy(css = ".text-block > .text-body:nth-of-type(3)")
    private WebElement shippingEmail;

    @FindBy(css = ".text-block > .text-body:last-of-type")
    private WebElement shippingAddress;

    @FindBy(css = ".text-button-main")
    private WebElement submitOrderSummaryButton;

    public OrderSummaryPage(AppiumDriver driver) {
        super(driver);
    }


    public void checkItemName(String name) {
        waitForElementToAppear(orderDetailsTab);
        orderDetailsTab.click();
        waitForElementToAppear(itemName);
        Assert.assertTrue(itemName.getText().contains(name), name +
                "was not shown on order details");

    }

    public void checkItemAmount(String amount) {
        waitForElementToAppear(orderDetailsTab);
        orderDetailsTab.click();
        waitForElementToAppear(itemAmount);
        Assert.assertTrue(itemAmount.getText().contains(amount), amount +
                "was not shown on order details");

    }

    public void checkShippingName(String username) {
        waitForElementToAppear(shippingDetailsTab);
        shippingDetailsTab.click();
        waitForElementToAppear(shippingName);
        Assert.assertTrue(shippingName.getText().contains(username), username +
                "was not shown on shipping details");

    }

    public void checkShippingPhoneNumber(String phoneNumber) {
        waitForElementToAppear(shippingDetailsTab);
        shippingDetailsTab.click();
        waitForElementToAppear(shippingPhoneNumber);
        Assert.assertTrue(shippingPhoneNumber.getText().contains(phoneNumber), phoneNumber +
                "was not shown on shipping details");

    }

    public void checkShippingEmail(String email) {
        waitForElementToAppear(shippingDetailsTab);
        shippingDetailsTab.click();
        waitForElementToAppear(shippingEmail);
        Assert.assertTrue(shippingEmail.getText().contains(email), email +
                "was not shown on shipping details");

    }

    public void checkShippingAddress(String address) {
        waitForElementToAppear(shippingDetailsTab);
        shippingDetailsTab.click();
        waitForElementToAppear(shippingAddress);
        Assert.assertTrue(itemName.getText().contains(address), address +
                "was not shown on shipping details");

    }

    public void submitOrderDetails() {
        waitForElementToAppear(submitOrderSummaryButton);
        submitOrderSummaryButton.click();
    }
}

