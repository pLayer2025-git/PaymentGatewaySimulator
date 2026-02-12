package response;

public class PaymentResponse {

    private PaymentStatus status;
    private String transactionId;
    private String message;

    public PaymentResponse(PaymentStatus status, String transactionId, String message) {
        this.status = status;
        this.transactionId = transactionId;
        this.message = message;
    }

    public PaymentStatus getStatus() { return status; }
    public String getTransactionId() { return transactionId; }
    public String getMessage() { return message; }
}