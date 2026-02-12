package paymentmode;

import payment.Payment;
import response.PaymentResponse;
import response.PaymentStatus;
import bank.Bank;

public class UpiPayment extends AbstractPayment {

    private String upiId;
    private Bank bank;

    public UpiPayment(String upiId, Bank bank) {
        this.upiId = upiId;
        this.bank = bank;
    }

    @Override
    public void validateDetails() {
        if (!upiId.contains("@")) {
            throw new IllegalArgumentException("Invalid UPI ID");
        }
    }

    @Override
    public String getPaymentMode() {
        return "UPI";
    }

    @Override
    public PaymentResponse processPayment(double amount) {
        validateDetails();
        simulateDelay();

        boolean approved = bank.authorizePayment(amount);
        if (approved) {
            return new PaymentResponse(PaymentStatus.SUCCESS, generateTransactionId(),
                    "UPI Payment approved by " + bank.getBankName());
        } else {
            return new PaymentResponse(PaymentStatus.FAILED, generateTransactionId(),
                    "UPI Payment declined by " + bank.getBankName());
        }
    }
}
