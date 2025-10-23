package School_Management.modules;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import School_Management.model.Book;

public class LibrarySystem {
    private Map<String, Book> books; // Hash Map: ISBN -> Book

    public LibrarySystem() {
        this.books = new HashMap<>();
        initializeSampleBooks();
    }

    private void initializeSampleBooks() {
        addBook("ISBN001", "Data Structures and Algorithms", "John Doe", 3);
        addBook("ISBN002", "Calculus Made Easy", "Jane Smith", 2);
        addBook("ISBN003", "Introduction to Physics", "Bob Johnson", 1);
    }

    public void addBook(String isbn, String title, String author, int copies) {
        books.put(isbn, new Book(isbn, title, author, copies));
    }

    public boolean borrowBook(String isbn, String studentId) {
        Book book = books.get(isbn);
        if (book == null) {
            System.out.println("Book not found!");
            return false;
        }

        boolean success = book.borrowBook(studentId);
        if (success) {
            System.out.println(studentId + " successfully borrowed: " + book.getTitle());
        } else {
            System.out.println("No copies available for: " + book.getTitle());
        }
        return success;
    }

    public boolean returnBook(String isbn, String studentId) {
        Book book = books.get(isbn);
        if (book == null) {
            System.out.println("Book not found!");
            return false;
        }

        boolean success = book.returnBook(studentId);
        if (success) {
            System.out.println(studentId + " successfully returned: " + book.getTitle());
        } else {
            System.out.println("All copies are already available for: " + book.getTitle());
        }
        return success;
    }

    public void displayBookStatus(String isbn) {
        Book book = books.get(isbn);
        if (book != null) {
            System.out.println("\n " + book.getTitle() + " ");
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Total Copies: " + book.getTotalCopies());
            System.out.println("Available Copies: " + book.getAvailableCopies());

            Stack<String> history = book.getBorrowHistory();
            if (!history.isEmpty()) {
                System.out.println("Recent Activity (most recent first):");
                // Display recent activity (last 5)
                int count = Math.min(5, history.size());
                for (int i = 0; i < count; i++) {
                    System.out.println("  " + history.get(history.size() - 1 - i));
                }
            }
        }
    }

    public void displayAllBooks() {
        System.out.println("\nLIBRARY COLLECTION ");
        for (Book book : books.values()) {
            System.out.printf("ISBN: %s | %s | Available: %d/%d%n",
                    book.getIsbn(), book.getTitle(),
                    book.getAvailableCopies(), book.getTotalCopies());
        }
    }
}