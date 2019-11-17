package tests;

import common.Constants;
import org.testng.annotations.Test;
import pages.*;

public class Test1_Successful_Payment_Scenario extends BaseTest {

    private LandingPage LandingSteps = new LandingPage(mobileDriver);
    private OrderSummaryPage OrderSummarySteps = new OrderSummaryPage(mobileDriver);
    private SelectPaymentPage SelectPaymentSteps = new SelectPaymentPage(mobileDriver);
    private CardDetailsPage CardDetailsSteps = new CardDetailsPage(mobileDriver);
    private BankTransactionPage BankTransactionSteps = new BankTransactionPage(mobileDriver);
    private TransactionStatusPage TransactionStatusSteps = new TransactionStatusPage(mobileDriver);

    private String amount, username, email, phoneNumber, city, address, postalCode, itemName,
            cardNumberSuccess, expiryDate, cvv, password;

    @Test(dataProvider = Constants.BASE_DIR + "Test1_Successful_Payment_Scenario.csv")
    public void paymentFlowShouldBeSuccessful() throws Exception {

        LandingSteps.buyNow();
        LandingSteps.fillInOrderDetails(amount, username, email, phoneNumber, city, address, postalCode);
        LandingSteps.submitOrderForm();

        OrderSummarySteps.checkItemName(itemName);
        OrderSummarySteps.checkItemAmount(amount);
        OrderSummarySteps.checkShippingName(username);
        OrderSummarySteps.checkShippingPhoneNumber(phoneNumber);
        OrderSummarySteps.checkShippingEmail(email);
        OrderSummarySteps.checkShippingAddress(address);
        OrderSummarySteps.proceedToPayment();

        SelectPaymentSteps.selectCreditCardPayment();

        CardDetailsSteps.checkFinalAmount(amount);
        CardDetailsSteps.inputCardNumber(cardNumberSuccess, expiryDate, cvv);
        CardDetailsSteps.payNow();

        BankTransactionSteps.typePassword(password);
        BankTransactionSteps.finaliseTransaction();

        TransactionStatusSteps.checkTransactionStatus("SUCCESS");
    }
}
