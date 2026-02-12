package paymentmode;

import payment.Payment;
import response.PaymentResponse;
import response.PaymentStatus;
import bank.Bank;

public class CardPayment extends AbstractPayment {

    private String cardNumber;
    private Bank bank;

    public CardPayment(String cardNumber, Bank bank) {
        this.cardNumber = cardNumber;
        this.bank = bank;
    }

    @Override
    public void validateDetails() {
        if (cardNumber.length() != 16) {
            throw new IllegalArgumentException("Invalid Card Number");
        }
    }

    @Override
    public String getPaymentMode() {
        return "Card";
    }

    @Override
    public PaymentResponse processPayment(double amount) {
        validateDetails();
        simulateDelay();

        boolean approved = bank.authorizePayment(amount);
        if (approved) {
            return new PaymentResponse(PaymentStatus.SUCCESS, generateTransactionId(),
                    "Card Payment approved by " + bank.getBankName());
        } else {
            return new PaymentResponse(PaymentStatus.FAILED, generateTransactionId(),
                    "Card Payment declined by " + bank.getBankName());
        }
    }
}
