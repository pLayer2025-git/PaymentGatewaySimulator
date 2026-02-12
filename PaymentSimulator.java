package service;

import bank.Bank;
import bank.KotakBank;
import bank.UnionBank;
import payment.Payment;
import paymentmode.CardPayment;
import paymentmode.UpiPayment;
import response.PaymentResponse;

public class PaymentSimulator {

    public static void main(String[] args) {

        Bank kotak = new KotakBank();
        Bank union = new UnionBank();

        Payment upiPayment = new UpiPayment("mohan@upi", kotak);
        Payment cardPayment = new CardPayment("1234567812345678", union);

        processPayment(upiPayment, 1000);
        processPayment(cardPayment, 1500);

        // Example: dynamically switching payment modes
        Payment dynamicPayment;
        String mode = "upi";  // could come from user input
        if (mode.equalsIgnoreCase("upi")) {
            dynamicPayment = new UpiPayment("user@upi", union);
        } else {
            dynamicPayment = new CardPayment("9876543210987654", kotak);
        }
        processPayment(dynamicPayment, 2000);
    }

    public static void processPayment(Payment payment, double amount) {
        try {
            System.out.println("Using Payment Mode: " + payment.getPaymentMode());
            PaymentResponse response = payment.processPayment(amount);
            System.out.println("Status: " + response.getStatus());
            System.out.println("Message: " + response.getMessage());
            System.out.println("Transaction ID: " + response.getTransactionId());
            System.out.println("----------------------------------------");
        } catch (IllegalArgumentException e) {
            System.out.println("Payment Failed: " + e.getMessage());
        }
    }
}
