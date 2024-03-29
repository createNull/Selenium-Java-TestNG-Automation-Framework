package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class TransactionStatusPage extends AbstractPage {

    @FindBy(xpath = "//div[(text()='Transaction successful')]")
    private WebElement transactionSuccessMessage;

    @FindBy(xpath = "//span[text()='Transaction failed']")
    private WebElement transactionFailMessage;

    public TransactionStatusPage(WebDriver driver) {
        super(driver);
    }

    public void checkTransactionStatus(String status) {
        if (status.equals("SUCCESS")) {
            waitForElementToAppear(transactionSuccessMessage);
            Assert.assertEquals(transactionSuccessMessage.getText(), "Transaction successful",
                    "Successful transaction message was not shown.");
        }

        else if (status.equals("FAIL")) {
            waitForElementToAppear(transactionFailMessage);
            Assert.assertEquals(transactionFailMessage.getText(), "Transaction failed",
                    "Failed transaction message was not shown.");
        }


    }
}
