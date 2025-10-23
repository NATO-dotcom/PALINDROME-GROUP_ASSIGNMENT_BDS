package School_Management.model;

public class Transaction {
    private String transactionId;
    private String studentId;
    private double amount;
    private String date;
    private Transaction left;
    private Transaction right;

    public Transaction(String transactionId, String studentId, double amount, String date) {
        this.transactionId = transactionId;
        this.studentId = studentId;
        this.amount = amount;
        this.date = date;
        this.left = null;
        this.right = null;
    }

    // Getters and Setters
    public String getTransactionId() {
        return transactionId;
    }

    public String getStudentId() {
        return studentId;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public Transaction getLeft() {
        return left;
    }

    public Transaction getRight() {
        return right;
    }

    public void setLeft(Transaction left) {
        this.left = left;
    }

    public void setRight(Transaction right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return String.format("Transaction{id=%s, student=%s, amount=%.2f, date=%s}",
                transactionId, studentId, amount, date);
    }
}
