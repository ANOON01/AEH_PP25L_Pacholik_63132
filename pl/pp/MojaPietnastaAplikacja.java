import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * A simple Java console application to simulate a library system with book borrowing.
 *
 * Features:
 *  - Add books to the library
 *  - Register users
 *  - Borrow and return books
 *  - Show borrowed books by users
 *  - Track availability of books
 *  - Data stored in memory for simplicity
 *
 * Usage:
 *  Run the application and follow the menu prompts.
 */
public class MojaPietnastaAplikacja {

    // Represents a book in the library
    static class Book {
        final String id;
        final String title;
        final String author;
        boolean isBorrowed;

        Book(String id, String title, String author) {
            this.id = id;
            this.title = title;
            this.author = author;
            this.isBorrowed = false;
        }

        @Override
        public String toString() {
            return String.format("[%s] \"%s\" by %s%s", id, title, author, isBorrowed ? " (Borrowed)" : "");
        }
    }

    // Represents a user of the library
    static class User {
        final String id;
        final String name;
        final List<BorrowRecord> borrowedBooks;

        User(String id, String name) {
            this.id = id;
            this.name = name;
            this.borrowedBooks = new ArrayList<>();
        }

        @Override
        public String toString() {
            return String.format("[%s] %s", id, name);
        }
    }

    // Record of a borrowed book with dates
    static class BorrowRecord {
        final Book book;
        final LocalDate borrowDate;
        LocalDate dueDate;
        LocalDate returnDate;

        BorrowRecord(Book book, LocalDate borrowDate, LocalDate dueDate) {
            this.book = book;
            this.borrowDate = borrowDate;
            this.dueDate = dueDate;
            this.returnDate = null;
        }

        boolean isReturned() {
            return returnDate != null;
        }

        @Override
        public String toString() {
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String status = isReturned() ? "Returned on " + returnDate.format(fmt) : "Due on " + dueDate.format(fmt);
            return String.format("\"%s\" borrowed on %s, %s", book.title, borrowDate.format(fmt), status);
        }
    }

    private final Map<String, Book> books = new LinkedHashMap<>();
    private final Map<String, User> users = new LinkedHashMap<>();

    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        MojaPietnastaAplikacja app = new MojaPietnastaAplikacja();
        app.seedData();
        app.run();
    }

    private void seedData() {
        // Add some books
        addBook(new Book("B001", "1984", "George Orwell"));
        addBook(new Book("B002", "To Kill a Mockingbird", "Harper Lee"));
        addBook(new Book("B003", "The Great Gatsby", "F. Scott Fitzgerald"));
        addBook(new Book("B004", "Moby Dick", "Herman Melville"));
        addBook(new Book("B005", "Pride and Prejudice", "Jane Austen"));
        // Add some users
        addUser(new User("U001", "Alice Kowalska"));
        addUser(new User("U002", "Jan Nowak"));
        addUser(new User("U003", "Ewa Wiśniewska"));
    }

    private void addBook(Book book) {
        books.put(book.id, book);
    }

    private void addUser(User user) {
        users.put(user.id, user);
    }

    private void run() {
        System.out.println("=== Library Simulation ===\n");
        while (true) {
            showMainMenu();
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1": listBooks(); break;
                case "2": listUsers(); break;
                case "3": borrowBook(); break;
                case "4": returnBook(); break;
                case "5": showUserBorrowedBooks(); break;
                case "6": System.out.println("Thanks for using Library Simulation. Goodbye!"); return;
                default: System.out.println("Invalid option, please try again.\n");
            }
        }
    }

    private void showMainMenu() {
        System.out.println("\nPlease select an option:");
        System.out.println("1. List all books");
        System.out.println("2. List all users");
        System.out.println("3. Borrow a book");
        System.out.println("4. Return a book");
        System.out.println("5. Show books borrowed by a user");
        System.out.println("6. Exit");
        System.out.print("Your choice: ");
    }

    private void listBooks() {
        System.out.println("\n--- Library Books ---");
        books.values().forEach(System.out::println);
    }

    private void listUsers() {
        System.out.println("\n--- Registered Users ---");
        users.values().forEach(System.out::println);
    }

    private void borrowBook() {
        System.out.println("\n--- Borrow a Book ---");
        User user = selectUser();
        if (user == null) return;

        Book book = selectAvailableBook();
        if (book == null) return;

        // Borrow duration is 14 days by default
        LocalDate today = LocalDate.now();
        LocalDate due = today.plusDays(14);

        book.isBorrowed = true;
        BorrowRecord record = new BorrowRecord(book, today, due);
        user.borrowedBooks.add(record);

        System.out.printf("Success: %s borrowed \"%s\". Due date: %s\n", user.name, book.title, due);
    }

    private User selectUser() {
        listUsers();
        System.out.print("Enter user ID: ");
        String userId = scanner.nextLine().trim();
        User user = users.get(userId);
        if (user == null) {
            System.out.println("User not found.\n");
        }
        return user;
    }

    private Book selectAvailableBook() {
        System.out.println("\nAvailable books:");
        books.values().stream()
                .filter(b -> !b.isBorrowed)
                .forEach(System.out::println);
        System.out.print("Enter book ID to borrow: ");
        String bookId = scanner.nextLine().trim();
        Book book = books.get(bookId);
        if (book == null) {
            System.out.println("Book not found.\n");
            return null;
        }
        if (book.isBorrowed) {
            System.out.println("Book is currently borrowed by someone else.\n");
            return null;
        }
        return book;
    }

    private void returnBook() {
        System.out.println("\n--- Return a Book ---");
        User user = selectUser();
        if (user == null) return;

        if (user.borrowedBooks.isEmpty()) {
            System.out.println("User has no borrowed books.\n");
            return;
        }

        System.out.println("Books currently borrowed by " + user.name + ":");
        for (int i = 0; i < user.borrowedBooks.size(); i++) {
            BorrowRecord record = user.borrowedBooks.get(i);
            if (!record.isReturned()) {
                System.out.printf("%d. %s (Due: %s)\n", i+1, record.book.title, record.dueDate);
            }
        }
        System.out.print("Enter number of the book to return: ");
        String input = scanner.nextLine().trim();
        int idx;
        try {
            idx = Integer.parseInt(input) - 1;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.\n");
            return;
        }
        if (idx < 0 || idx >= user.borrowedBooks.size()) {
            System.out.println("Index out of range.\n");
            return;
        }
        BorrowRecord record = user.borrowedBooks.get(idx);
        if (record.isReturned()) {
            System.out.println("Book already returned.\n");
            return;
        }

        record.returnDate = LocalDate.now();
        record.book.isBorrowed = false;

        System.out.printf("Book \"%s\" returned successfully.\n", record.book.title);
    }

    private void showUserBorrowedBooks() {
        System.out.println("\n--- Show User's Borrowed Books ---");
        User user = selectUser();
        if (user == null) return;

        if (user.borrowedBooks.isEmpty()) {
            System.out.println("User has no borrowed books.\n");
            return;
        }
        user.borrowedBooks.forEach(record -> {
            System.out.println(record);
        });
    }
}

