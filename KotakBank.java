package bank;

public class KotakBank implements Bank {

    @Override
    public boolean authorizePayment(double amount) {
        System.out.println("Connecting to Kotak Bank...");
        try { Thread.sleep(1500); } catch (InterruptedException e) { e.printStackTrace(); }
        return Math.random() > 0.2; // 80% success
    }

    @Override
    public String getBankName() {
        return "Kotak Bank";
    }
}
