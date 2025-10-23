package School_Management.model;

import java.util.Stack;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private int totalCopies;
    private int availableCopies;
    private Stack<String> borrowHistory; // Stack of student IDs

    public Book(String isbn, String title, String author, int totalCopies) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.totalCopies = totalCopies;
        this.availableCopies = totalCopies;
        this.borrowHistory = new Stack<>();
    }

    // Getters
    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public Stack<String> getBorrowHistory() {
        return borrowHistory;
    }

    public boolean borrowBook(String studentId) {
        if (availableCopies > 0) {
            availableCopies--;
            borrowHistory.push(studentId + " borrowed on " + System.currentTimeMillis());
            return true;
        }
        return false;
    }

    public boolean returnBook(String studentId) {
        if (availableCopies < totalCopies) {
            availableCopies++;
            borrowHistory.push(studentId + " returned on " + System.currentTimeMillis());
            return true;
        }
        return false;
    }
}
