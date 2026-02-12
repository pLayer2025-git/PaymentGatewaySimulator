package bank;

public class UnionBank implements Bank {

    @Override
    public boolean authorizePayment(double amount) {
        System.out.println("Connecting to Union Bank...");
        try { Thread.sleep(1500); } catch (InterruptedException e) { e.printStackTrace(); }
        return Math.random() > 0.4; // 60% success
    }

    @Override
    public String getBankName() {
        return "Union Bank of India";
    }
}
