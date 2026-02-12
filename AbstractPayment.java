package paymentmode;

import payment.Payment;
import response.PaymentResponse;

import java.util.UUID;

public abstract class AbstractPayment implements Payment {

    protected void simulateDelay() {
        try { Thread.sleep(1500); } catch (InterruptedException e) { e.printStackTrace(); }
    }

    protected String generateTransactionId() {
        return UUID.randomUUID().toString();
    }

    // Child classes implement validateDetails(), getPaymentMode(), processPayment()
}
