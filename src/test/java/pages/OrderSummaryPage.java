package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class OrderSummaryPage extends AbstractPage {

    @FindBy(css = ".item-name")
    private WebElement itemName;

    @FindBy(css = "li:first-of-type > .text-actionable > span")
    private WebElement orderDetailsTab;

    @FindBy(css = ".table-amount.text-body")
    private WebElement itemAmount;

    @FindBy(css = "li:last-of-type > .text-actionable > span")
    private WebElement shippingDetailsTab;

    @FindBy(xpath = "//div[(text()='Name')]/../div[2]")
    private WebElement shippingUsername;

    @FindBy(xpath = "//div[(text()='Phone number')]/../div[2]")
    private WebElement shippingPhoneNumber;

    @FindBy(xpath = "//div[(text()='Email')]/../div[2]")
    private WebElement shippingEmail;

    @FindBy(xpath = "//div[(text()='Address')]/../div[2]")
    private WebElement shippingAddress;

    @FindBy(css = ".text-button-main")
    private WebElement confirmOrderButton;

    public OrderSummaryPage(WebDriver driver) {
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
        Assert.assertEquals(itemAmount.getText().replace(",", ""), amount, amount +
                "was not shown on order details");

    }

    public void checkShippingUsername(String username) {
        waitForElementToAppear(shippingDetailsTab);
        shippingDetailsTab.click();
        waitForElementToAppear(shippingUsername);
        Assert.assertEquals(shippingUsername.getText(), username, username +
                "was not shown on shipping details");

    }

    public void checkShippingPhoneNumber(String phoneNumber) {
        waitForElementToAppear(shippingDetailsTab);
        shippingDetailsTab.click();
        waitForElementToAppear(shippingPhoneNumber);
        Assert.assertEquals(shippingPhoneNumber.getText(), phoneNumber, phoneNumber +
                "was not shown on shipping details");

    }

    public void checkShippingEmail(String email) {
        waitForElementToAppear(shippingDetailsTab);
        shippingDetailsTab.click();
        waitForElementToAppear(shippingEmail);
        Assert.assertEquals(shippingEmail.getText(), email, email +
                "was not shown on shipping details");

    }

    public void checkShippingAddress(String address) {
        waitForElementToAppear(shippingDetailsTab);
        shippingDetailsTab.click();
        waitForElementToAppear(shippingAddress);
        Assert.assertEquals(itemName.getText(), address, address +
                "was not shown on shipping details");

    }

    public void confirmOrder() {
        waitForElementToAppear(confirmOrderButton);
        confirmOrderButton.click();
    }
}

