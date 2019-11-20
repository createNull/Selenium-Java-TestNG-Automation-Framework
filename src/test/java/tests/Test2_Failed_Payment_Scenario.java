package tests;

import org.testng.annotations.Test;
import pages.*;

import static common.Constants.*;


public class Test2_Failed_Payment_Scenario extends BaseTest {

    @Test
    public void paymentFlowShouldBeSuccessful() throws Exception {

        LandingPage landingSteps = new LandingPage(driver);
        landingSteps.launchBrowser();
        landingSteps.buyNow();
        landingSteps.fillInItemValue(amount);
        landingSteps.fillInUserDetails(username, email, phoneNumber, city, address, postalCode);
        landingSteps.submitOrderForm();

        OrderSummaryPage orderSummarySteps = new OrderSummaryPage(driver);
        orderSummarySteps.checkItemName(itemName);
        orderSummarySteps.checkItemAmount(amount);
        orderSummarySteps.checkShippingUsername(username);
        orderSummarySteps.checkShippingPhoneNumber(phoneNumber);
        orderSummarySteps.checkShippingEmail(email);
        orderSummarySteps.checkShippingAddress(address);
        orderSummarySteps.confirmOrder();

        SelectPaymentPage selectPaymentSteps = new SelectPaymentPage(driver);
        selectPaymentSteps.selectCreditCardPayment();

        CardDetailsPage cardDetailsSteps = new CardDetailsPage(driver);
        cardDetailsSteps.checkFinalAmount(amount);
        cardDetailsSteps.fillInCardDetails(cardNumberFail, expiryDate, cvv);
        cardDetailsSteps.confirmPayment();

        BankTransactionPage bankTransactionSteps = new BankTransactionPage(driver);
        bankTransactionSteps.typePassword(password);
        bankTransactionSteps.finaliseTransaction();

        TransactionStatusPage transactionStatusSteps = new TransactionStatusPage(driver);
        transactionStatusSteps.checkTransactionStatus("FAIL");
    }
}
