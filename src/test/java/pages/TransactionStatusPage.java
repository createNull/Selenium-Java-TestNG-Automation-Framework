package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class TransactionStatusPage extends AbstractPage {

    @FindBy(css = ".text-success:last-of-type")
    private WebElement transactionSuccessMessage;

    @FindBy(css = ".text-failed > span")
    private WebElement transactionFailMessage;

    public TransactionStatusPage(AppiumDriver driver) {
        super(driver);
    }

    public void checkTransactionStatus(String status) {
        if (status.equals("SUCCES")) {
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
