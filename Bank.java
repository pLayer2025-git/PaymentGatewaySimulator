
package bank;

public interface Bank {
    boolean authorizePayment(double amount);
    String getBankName();
}
