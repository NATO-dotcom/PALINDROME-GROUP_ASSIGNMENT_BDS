package School_Management.modules;

import java.util.ArrayList;
import java.util.List;

import School_Management.model.Transaction;

public class FeeTracker {
    private Transaction root;
    private int transactionCount;

    public FeeTracker() {
        this.root = null;
        this.transactionCount = 0;
    }

    public String addTransaction(String studentId, double amount, String date) {
        transactionCount++;
        String transactionId = "T" + String.format("%04d", transactionCount);
        Transaction newTransaction = new Transaction(transactionId, studentId, amount, date);

        if (root == null) {
            root = newTransaction;
        } else {
            insert(root, newTransaction);
        }

        return transactionId;
    }

    private void insert(Transaction current, Transaction newTransaction) {
        // Sort by date (you can change the comparison logic)
        if (newTransaction.getDate().compareTo(current.getDate()) < 0) {
            if (current.getLeft() == null) {
                current.setLeft(newTransaction);
            } else {
                insert(current.getLeft(), newTransaction);
            }
        } else {
            if (current.getRight() == null) {
                current.setRight(newTransaction);
            } else {
                insert(current.getRight(), newTransaction);
            }
        }
    }

    public List<Transaction> generateReport() {
        List<Transaction> report = new ArrayList<>();
        inOrderTraversal(root, report);
        return report;
    }

    public List<Transaction> generateReportByDateRange(String startDate, String endDate) {
        List<Transaction> report = new ArrayList<>();
        inOrderTraversalWithFilter(root, report, startDate, endDate);
        return report;
    }

    private void inOrderTraversal(Transaction node, List<Transaction> report) {    // Binary Search Tree traversal
        if (node != null) {
            inOrderTraversal(node.getLeft(), report);
            report.add(node);
            inOrderTraversal(node.getRight(), report);
        }
    }

    private void inOrderTraversalWithFilter(Transaction node, List<Transaction> report,
            String startDate, String endDate) {
        if (node != null) {
            inOrderTraversalWithFilter(node.getLeft(), report, startDate, endDate);

            String transactionDate = node.getDate();
            if ((startDate == null || transactionDate.compareTo(startDate) >= 0) &&
                    (endDate == null || transactionDate.compareTo(endDate) <= 0)) {
                report.add(node);
            }

            inOrderTraversalWithFilter(node.getRight(), report, startDate, endDate);
        }
    }

    public double getTotalRevenue() {
        List<Transaction> allTransactions = generateReport();
        return allTransactions.stream()
                .mapToDouble(Transaction::getAmount)
                .sum();
    }

    public void displayAllTransactions() {
        List<Transaction> transactions = generateReport();
        System.out.println("\n ALL FEE TRANSACTIONS ");
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
        System.out.println("Total Revenue: $" + getTotalRevenue());
    }
}
