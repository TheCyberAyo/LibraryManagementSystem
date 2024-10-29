import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagementApp {
    public static void main(String[] args) {
        ArrayList<book> libraryBooks = new ArrayList<>();
        Librarian librarian = new Librarian("Alice", 1, libraryBooks);
        Member member = new Member("Bob", 2);

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nLibrary System Menu:");
            System.out.println("1. Add Book (Librarian)");
            System.out.println("2. Remove Book (Librarian)");
            System.out.println("3. Borrow Book (Member)");
            System.out.println("4. Return Book (Member)");
            System.out.println("5. View Library Books");
            System.out.println("6. Exit");

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.println("Enter title, author, ISBN:");
                        String title = scanner.nextLine();
                        String author = scanner.nextLine();
                        String isbn = scanner.nextLine();
                        librarian.addBook(new book(title, author, isbn));
                        break;
                    case 2:
                        System.out.println("Enter ISBN of book to remove:");
                        String removeISBN = scanner.nextLine();
                        librarian.removeBook(removeISBN);
                        break;
                    case 3:
                        System.out.println("Enter ISBN of book to borrow:");
                        String borrowISBN = scanner.nextLine();
                        libraryBooks.stream().filter(b -> b.getISBN().equals(borrowISBN)).findFirst()
                                .ifPresentOrElse(member::borrowBook,
                                        () -> System.out.println("Book not found or unavailable."));
                        break;
                    case 4:
                        System.out.println("Enter ISBN of book to return:");
                        String returnISBN = scanner.nextLine();
                        libraryBooks.stream().filter(b -> b.getISBN().equals(returnISBN)).findFirst()
                                .ifPresentOrElse(member::returnBook,
                                        () -> System.out.println("Book not found in borrowed list."));
                        break;
                    case 5:
                        System.out.println("Library Books:");
                        libraryBooks.forEach(System.out::println);
                        break;
                    case 6:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
        scanner.close();
        System.out.println("Library System closed.");
    }
}
