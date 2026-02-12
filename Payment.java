package payment;

import response.PaymentResponse;

public interface Payment {

    void validateDetails() throws IllegalArgumentException;

    PaymentResponse processPayment(double amount);

    String getPaymentMode();
}
